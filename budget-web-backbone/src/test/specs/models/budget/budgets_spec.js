define([ 'jquery', 'models/budget/budgets', 'models/collection' ], function($, Budgets, Collection) {
	describe("Models - Budgets Collection", function() {
		"use strict";
		beforeEach(function() {
			 this.budgets = new Budgets();
		}); 

		it('should be intanceof Collection', function() {
			
			expect(this.budgets).toBeInstanceOf(Collection);
		});

		describe('url', function() {
		    it("should return the api/budgets URL", function() {
		      expect(this.budgets.url).toEqual("api/budgets");
		    });
		});
	});
});