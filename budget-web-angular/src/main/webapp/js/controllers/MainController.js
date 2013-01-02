'use strict';

budgetApp.controller('MainController', ['$scope', '$location', 'ngI18nResourceBundle', 'ngI18nConfig',
                                        function HomeController($scope, $location, ngI18nResourceBundle, ngI18nConfig) {
	$scope.languages = [
        {locale:"en"},
        {locale:"nl"}
    ];

	$scope.i18n = {language: $scope.languages[0]};
	
	$scope.setLanguage = function(locale, $event) {
		$scope.i18n = {language: {locale:locale}};
		$event.preventDefault();
	};

	$scope.$watch('i18n.language', function (language) {
        ngI18nResourceBundle.get({locale: language.locale}).success(function (resourceBundle) {
        	$scope.resourceBundle = resourceBundle;
        	$scope.$broadcast('resourceBundleLoaded', resourceBundle);
        });
    });
	
	$scope.navbarViewUrl = function(){
		return 'views/main/navbar.html';
	};
	

}]);