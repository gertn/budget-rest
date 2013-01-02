'use strict';

budgetApp.controller('TransactionsController', function HomeController($scope, $location) {
	$scope.mainViewUrl = function(){
		return 'views/transactions/main_transactions.html';
	};
	
});