'use strict';
budgetApp.factory('Budget', function($resource, notifications){
			var Budget =  $resource('api/budgets/:budgetId', {}, {
			        update: {
			            method: 'PUT'
			        }
			});
			Budget.saveOrUpdate =  function(budget, success, error){
				notifications.resetCurrent();
	        	if(!angular.isNumber(budget.id)){
	        		return budget.$save(success, error);
	        	} else {
	        		return budget.$update({budgetId: budget.id}, success, error);
	        	}
	        };
			return Budget;
});

budgetApp.factory('DefaultBudget', function($resource){
	return $resource('api/budgets/default/:budgetId', {}, {
		queryDefault: {
			method:'GET', 
			isArray:false
		},
		update: {
            method: 'PUT'
        }
	});
});

budgetApp.factory('i18n', function($rootScope, ngI18nResourceBundle, ngI18nConfig){
	
	function setLanguage(language) {
		loadResourceBundle(language);
	};
	
	function loadResourceBundle(language){
		ngI18nResourceBundle.get({locale: language}).success(function (resourceBundle) {
			$rootScope.resourceBundle = resourceBundle;
			$rootScope.$broadcast('resourceBundleLoaded', resourceBundle);
		});
		
	}
	
	loadResourceBundle(ngI18nConfig.supportedLocales[0]);
	
	return {
			languages: ngI18nConfig.supportedLocales,
			setLanguage: setLanguage
	};
});

budgetApp.factory('ErrorHandler', function($resource, $rootScope, i18nNotifications){ 
	
	$rootScope.$on('event:error', errorHandler);
	
	function errorHandler(event, response) {
		if (response.status === 422) {
			unprocessableEntityHandler(response.data);
		} else if (response.status === 404) {
			notFoundHandler();
		} else if (response.status === 500) {
			internalServerErrorHandler();
		} else {
			unkownErrorHandler();
		}
	};
	function notFoundHandler() {
		alert('page not found error!');
	};
	function internalServerErrorHandler() {
		window.location.href='500.html';
	};
	function unkownErrorHandler() {
		alert('Unknown server error!');
	};
	function unprocessableEntityHandler(data) {
		if(angular.isArray(data.errors)){
			angular.forEach(data.errors, function(error, key) { 
				addError(error, key);
			 });
		 } else if(angular.isObject(data.errors) ) {
			 addError(data.errors, 0);
		 }
	};
	
	function addError(error, key){ 
		 i18nNotifications.pushForCurrentRoute(error.messageKey, 'error', extractAttributes(error));
	 };
	 
	 function extractAttributes(error){
		 var attributes = {};
		 
		 attributes.property = error.property;
		 if(angular.isArray(error.attributes)){
			 angular.forEach(error.attributes, function(attr){ 
				 attributes[attr.key] = attr.value;
			 });
		 } else if(angular.isObject(error.attributes) ) {
			 var attr = error.attributes;
			 attributes[attr.key] = attr.value;
		 }
		 return attributes;
	 };
	
	return {};
	
});
