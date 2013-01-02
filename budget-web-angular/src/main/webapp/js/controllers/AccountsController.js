'use strict';

budgetApp.controller('AccountsController', function HomeController($scope, $location) {
	$scope.mainViewUrl = function(){
		return 'views/accounts/main_accounts.html';
	};
	
});