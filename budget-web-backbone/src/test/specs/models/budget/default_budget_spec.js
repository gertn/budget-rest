define([ 'jquery', 'backbone', 'models/budget/default_budget' ], function($, Backbone, DefaultBudget) {
	describe("Models - DefaultBudget model", function() {
		"use strict";
		
		beforeEach(function() {
			this.budget = new DefaultBudget();
		});
		
		it("should be instance of Backbone.Model", function() {
		      expect(this.budget).toBeInstanceOf(Backbone.Model);
		 });
		
		describe('url', function() {
			describe("when no id is set", function() {
			    it("should return the api/budgets/default URL", function() {
			      expect(this.budget.url()).toEqual("api/budgets/default");
			    });
			});
			describe("when id is set", function() {
			    it("should return the api/budgets/default URL and id", function() {
			      this.budget.id = 1;
			      expect(this.budget.url()).toEqual("api/budgets/default/1");
			    });
			 });
		});
	});
});