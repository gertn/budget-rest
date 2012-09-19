define(['jquery', 'app/model/budget'], function($, Budget) {
  describe("Budget model", function() {

	  describe('when instantiated', function() {
		    
		    it('should exhibit attributes', function() {
		      var todo = new Budget({
		        name: 'Budget 2012'
		      });
		      expect(todo.get('name'))
		        .toEqual('Budget 2012');
		    });
		    
	  });
  });
});