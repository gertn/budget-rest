define([
  'underscore',
  'backbone',
  'models/model'
], function(_, Backbone, Model) {
	"use strict";
	var budgetModel = Model.extend({
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