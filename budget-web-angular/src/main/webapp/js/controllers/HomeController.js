'use strict';

budgetApp.controller('HomeController', function HomeController($scope, $location, $parse, Budget, DefaultBudget) {
	$scope.budgetForm = {};
	$scope.$on('resourceBundleLoaded', function(event, resourceBundle){
		$scope.budgetForm.budgetFormTitle = $parse("budget.default_budget")(resourceBundle);
	});
	$scope.readOnlyMode = true;
	
	$scope.mainViewUrl = function(){
		return 'views/home/main_home.html';
	};
	
	$scope.budgets = Budget.query({}, function(Budgets){
	});
	
	DefaultBudget.queryDefault({}, function(defaultBudget) {
		$scope.budget = defaultBudget;
	});
	
	$scope.setAsDefault = function(defaultBudget) {
		DefaultBudget.update({budgetId: defaultBudget.id}, defaultBudget, function(budget) {
			$scope.budget = budget;
		}, function(){
			console.log('error');
		});
	};
	
	
});
