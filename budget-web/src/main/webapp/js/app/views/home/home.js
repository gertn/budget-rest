define(	['marionette', 'require'], function(marionette, require) {
	return marionette.ItemView.extend({
		template: 'home',
		events: {
			"click #newBudget"    : "newBudget"
	    },
	    newBudget: function(event) {
	    	require('app').router.navigate("budgets/new", true);
			return false;
		}
	});
});