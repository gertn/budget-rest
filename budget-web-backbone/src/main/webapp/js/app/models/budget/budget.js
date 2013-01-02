define([
  'underscore',
  'backbone',
  'models/model'
], function(_, Backbone, Model) {
	"use strict";
	var budgetModel = Model.extend({
		urlRoot: "api/budgets",
		defaults: {
			id : null,
			name:  "",
			year:  "",
			description: "",
			state: null
		}		
	});
	
	budgetModel.ID = 'id';
	budgetModel.NAME =  'name';
	budgetModel.YEAR =  'year';
	budgetModel.DESCRIPTION = 'description';
	budgetModel.STATE = 'state';
	
	return budgetModel;
});