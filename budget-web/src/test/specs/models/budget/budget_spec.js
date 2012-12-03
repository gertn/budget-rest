define([ 'jquery', 'models/budget/budget', 'models/model' ], function($, Budget, Model) {
	describe("Models - Budget model", function() {
		"use strict";
		
		beforeEach(function() {
			this.budget = new Budget();
		});
		
		it("should be instance of Model", function() {
		      expect(this.budget).toBeInstanceOf(Model);
		 });

		describe('when instantiated', function() {

			it('should have default values', function() {
				expect(this.budget.get(Budget.ID)).toBeNull();
				expect(this.budget.get(Budget.NAME)).toBeEmpty();
				expect(this.budget.get(Budget.DESCRIPTION)).toBeEmpty();
				expect(this.budget.get(Budget.YEAR)).toBeEmpty();
				expect(this.budget.get(Budget.STATE)).toBeNull();
			});

		});
		
		describe('url', function() {
			describe("when no id is set", function() {
			    it("should return the api/budgets URL", function() {
			      expect(this.budget.url()).toEqual("api/budgets");
			    });
			});
			describe("when id is set", function() {
			    it("should return the api/budgets URL and id", function() {
			      this.budget.id = 1;
			      expect(this.budget.url()).toEqual("api/budgets/1");
			    });
			 });
		});
	});
});