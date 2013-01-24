'use strict';

budgetApp.controller('MainController', ['$scope', '$rootScope', 'i18n', '$location', 'i18nNotifications', 'localizedMessages', 'ErrorHandler', 
                                        function HomeController($scope, $rootScope, i18n, $location, i18nNotifications, ErrorHandler) {
	
	$scope.notifications = i18nNotifications;
	
	$scope.removeNotification = function (notification) {
	   i18nNotifications.remove(notification);
	 };
	 
     $scope.setLanguage = function(lang) {
         i18n.setLanguage(lang);
         $event.preventDefault();
     };
	  
	$scope.languages = i18n.languages;
	
	$scope.navbarViewUrl = function(){
		return 'views/main/navbar.html';
	};
	

}]);