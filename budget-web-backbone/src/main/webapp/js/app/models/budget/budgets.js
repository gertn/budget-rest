define([
  'underscore',
  'backbone',
  'models/budget/budget',
  'models/collection'
], function(_, Backbone, BudgetModel, Collection) {
	"use strict";
	var budgetsModel = Collection.extend({
		url: "api/budgets",
		model: BudgetModel
	});
	return budgetsModel;
});