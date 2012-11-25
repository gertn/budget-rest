define(
		[ 'vent', 'backbone', 'views/home/home_layout', 'views/home/home_toolbar', 'views/home/budget', 
		  'views/home/default_budget', 'views/home/select_budget', 'models/budget/budget', 
		  'models/budget/default_budget', 'models/budget/budgets','i18n!nls/general' ], 
		function(vent, Backbone, HomeLayout, HomeToolbar, BudgetView, 
				DefaultBudgetView, SelectBudgetView, BudgetModel, DefaultBudgetModel, BudgetsModel, i18n) {
	
	"use strict";

	vent.on('action:home', homeAction);
	vent.on('action:budgetSaved', homeAction);
	vent.on('action:newBudget', newBudgetAction);
	vent.on('action:defaultBudget', defaultBudgetAction);
	vent.on('action:updateBudget', updateBudgetAction);
	
	var homeLayout;

	function homeAction() {
		homeLayout = new HomeLayout();
		var budgetsModel = new BudgetsModel(),
		defaultBudgetModel = new DefaultBudgetModel();
		
		vent.trigger('app:main:show', {view: homeLayout});
		homeLayout.toolbar.show(new HomeToolbar());
		
		budgetsModel.fetch({success: function() {
            homeLayout.selectBugdet.show(new SelectBudgetView({model: budgetsModel}));
        }});
		
		defaultBudgetModel.fetch({success: function() {
			homeLayout.defaultBugdet.show(new DefaultBudgetView({model: defaultBudgetModel}));
		}});
	};
	function newBudgetAction() {
		vent.trigger('app:main:show', {view: new BudgetView({model: new BudgetModel(), title: i18n.budget.new_budget})});
	};
	function defaultBudgetAction(selectedId) {
		new DefaultBudgetModel().save({'id' : selectedId}, {success : function() {
			homeAction();
		}});
	};
	function updateBudgetAction() {
		var budgetModel = new BudgetModel({id :  defaultBudgetId()});
		budgetModel.fetch({success: function() {
			var view = new BudgetView({model: budgetModel, title: i18n.budget.update_budget});
			vent.trigger('app:main:show', {view: view});
		}});
	};
	
	function defaultBudgetId(){
		return homeLayout.defaultBugdet.currentView.model.get('id');
	};

});