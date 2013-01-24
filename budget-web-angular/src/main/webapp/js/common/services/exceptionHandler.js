"use strict";

angular.module('services.exceptionHandler', []).factory('exceptionHandler', ['i18nNotifications', function (i18nNotifications) {

	function errorHandler(response) {
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
		 attributes = {};
		 
		 attributes.property = extractProperty(error);
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
	 
	 function extractProperty(error){
		 return i18n.properties[error.property] ? i18n.properties[error.property]: error.property;
	 };
	
	 	
	return {
	   handleErrors : errorHandler
	};
	
}]);