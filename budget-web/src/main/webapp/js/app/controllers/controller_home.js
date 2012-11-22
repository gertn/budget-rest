define(
		[ 'vent', 'app', 'backbone', 'views/home/home_layout', 'views/home/home_toolbar', 'views/home/new_budget', 
		  'views/home/default_budget', 'views/home/select_budget', 'models/budget/budget', 'models/budget/default_budget', 'models/budget/budgets' ], 
		function(vent, app, Backbone, HomeLayout, HomeToolbar, NewBudgetView, 
				DefaultBudgetView, SelectBudgetView, BudgetModel, DefaultBudgetModel, BudgetsModel) {
	
	"use strict";

	vent.on('action:home', homeAction);
	vent.on('action:newBudget', newBudgetAction);

	function homeAction() {
		var homeLayout = new HomeLayout(),
		budgetsModel = new BudgetsModel(),
		defaultBudgetModel = new DefaultBudgetModel();
		
		app.showMainContainerInMainLayout(homeLayout);
		homeLayout.toolbar.show(new HomeToolbar());
		homeLayout.defaultBugdet.show(new DefaultBudgetView());
		
		budgetsModel.fetch({success: function() {
            homeLayout.selectBugdet.show(new SelectBudgetView({model: budgetsModel}));
        }});
		defaultBudgetModel.fetch({success: function() {
			homeLayout.defaultBugdet.show(new DefaultBudgetView({model: defaultBudgetModel}));
		}});
	};
	function newBudgetAction() {
		app.showMainContainerInMainLayout(new NewBudgetView({model: new BudgetModel()}));
	};

});