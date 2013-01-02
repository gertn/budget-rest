define([
  'underscore',
  'backbone'
], function(_, Backbone) {
	"use strict";
	var budgetModel = Backbone.Model.extend({
		urlRoot: "api/budgets/default",
	});
	return budgetModel;
});