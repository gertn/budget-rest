'use strict';

budgetApp.controller('BudgetController', function BudgetController($scope, $rootScope, $location, $routeParams, Budget) {
	$scope.readOnlyMode = false;
	
	if(angular.isDefined($routeParams.budgetId) && $routeParams.budgetId.length > 0) {
		$scope.budgetFormTitle = "update_budget";
		$scope.budget = Budget.get({budgetId: $routeParams.budgetId});
	} else {
		$scope.budgetFormTitle = "new_budget";
		$scope.budget = new Budget();
	}
	
	$scope.mainViewUrl = function(){
		return 'views/home/budget_form.html';
	};
	
	$scope.cancel = function(){
		$location.path('/');
	};
	
	$scope.save = function(){
		var budget = $scope.budget;
		Budget.saveOrUpdate(budget, function(budget) {
				$scope.budget = budget;
				$location.path('/');
			}, function(response){
				$rootScope.$broadcast('ajax-errors', response);
		});
		/*if(!angular.isNumber(budget.id)){
			Budget.save({}, budget, function(budget) {
				$scope.budget = budget;
				$location.path('/');
			}, function(response){
				$rootScope.$broadcast('ajax-errors', response);
			});
    	} else {
    		Budget.update({budgetId: budget.id}, budget, function(budget) {
    			$scope.budget = budget;
    			$location.path('/');
    		}, function(response){
    			$rootScope.$broadcast('ajax-errors', response);
    		});
    	}*/
		
		
	};
	
});
