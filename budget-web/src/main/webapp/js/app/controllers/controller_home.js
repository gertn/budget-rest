define([ 'vent', 'app', 'views/home/home', 'views/home/newBudget', 'models/budget/budget' ], 
		function(vent, app, MainHomeView, NewBudgetView, BudgetModel) {
	
	"use strict";

	vent.on('action:home', homeAction);
	vent.on('action:newBudget', newBudgetAction);

	function homeAction() {
		app.main.show(new MainHomeView());
	};
	function newBudgetAction() {
		app.main.show(new NewBudgetView({model: new BudgetModel()}));
	};

});