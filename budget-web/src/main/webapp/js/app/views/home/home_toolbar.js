define(	['marionette', 'require', 'jquery', 'vent'], function(marionette, require, $, vent) {
	"use strict";
	return marionette.ItemView.extend({
		template: 'home_toolbar_tpl',
		onRender: function(){
			$('#newBudget', this.$el).tooltip();
		},
		events: {
			"click #newBudget"    : "newBudget"
	    },
	    newBudget: function(event) {
	    	$('#newBudget', this.$el).tooltip('hide');
	    	require('app').router.navigate("budgets/new", true);
			return false;
		}
	});
});