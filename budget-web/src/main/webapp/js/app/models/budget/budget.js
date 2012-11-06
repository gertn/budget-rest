define([
  'underscore',
  'backbone'
], function(_, Backbone) {
  var budgetModel = Backbone.Model.extend({
	urlRoot: "api/budgets",
	defaults: {
		"id": null,
		"name":  "",
		"year":  "",
		"state": ""
	},
    initialize: function(){
    }
    
  });
  return budgetModel;
});