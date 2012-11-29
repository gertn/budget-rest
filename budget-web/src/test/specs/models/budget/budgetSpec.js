define([ 'jquery', 'models/budget/budget' ], function($, Budget) {
	describe("Models - Budget model", function() {
		"use strict";
		
		var ID = 1, NAME = "name", DESCRIPTION = "description", YEAR = 2012;

		describe('when instantiated', function() {

			it('should exhibit attributes', function() {
				var budget = new Budget({
					id: ID,
					name : NAME,
					description : DESCRIPTION,
					year : YEAR
				});
				expect(budget.get(Budget.ID)).toEqual(ID);
				expect(budget.get(Budget.NAME)).toEqual(NAME);
				expect(budget.get(Budget.DESCRIPTION)).toEqual(DESCRIPTION);
				expect(budget.get(Budget.YEAR)).toEqual(YEAR);
			});

			it('should have default values', function() {
				var budget = new Budget();
				expect(budget.get(Budget.ID)).toBeNull();
				expect(budget.get(Budget.NAME)).toBeEmpty();
				expect(budget.get(Budget.DESCRIPTION)).toBeEmpty();
				expect(budget.get(Budget.YEAR)).toBeEmpty();
				expect(budget.get(Budget.STATE)).toBeNull();
			});

		});
		
		describe('url', function() {
			beforeEach(function() {
				this.budget = new Budget();
			});
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