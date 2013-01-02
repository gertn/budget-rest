'use strict';
budgetApp.factory('Budget', function($resource){
			var Budget =  $resource('api/budgets/:budgetId', {}, {
			        update: {
			            method: 'PUT'
			        }
			});
			Budget.saveOrUpdate =  function(budget){
	        	if(!angular.isNumber(budget.id)){
	        		return budget.$save();
	        	} else {
	        		return budget.$update({budgetId: budget.id});
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
