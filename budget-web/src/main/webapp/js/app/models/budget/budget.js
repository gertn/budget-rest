define([
  'underscore',
  'backbone'
], function(_, Backbone) {
	"use strict";
	var budgetModel = Backbone.Model.extend({
		urlRoot: "api/budgets",
		defaults: {
			"id": null,
			"name":  "",
			"year":  "",
			"state": null
		},
		initialize: function(){
			
		}
	});
	return budgetModel;
});