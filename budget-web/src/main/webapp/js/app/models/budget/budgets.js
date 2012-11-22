define([
  'underscore',
  'backbone',
  'models/budget/budget'
], function(_, Backbone, BudgetModel) {
	"use strict";
	var budgetsModel = Backbone.Collection.extend({
		url: "api/budgets",
		model: BudgetModel
	});
	return budgetsModel;
});