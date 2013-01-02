'use strict';

budgetApp.controller('CategoriesController', function HomeController($scope, $location) {
	$scope.mainViewUrl = function(){
		return 'views/categories/main_categories.html';
	};
	
});