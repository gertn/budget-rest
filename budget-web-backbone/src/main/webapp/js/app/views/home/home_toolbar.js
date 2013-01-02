define(	['marionette', 'require', 'jquery', 'vent', 'util/localStorage'], function(marionette, require, $, vent, localStorage) {
	"use strict";
	return marionette.ItemView.extend({
		template: 'home_toolbar_tpl',
		onRender: function(){
			$('#newBudget', this.$el).tooltip();
			$('#updateBudget', this.$el).tooltip();
		},
		events: {
			"click #newBudget"    : "newBudget",
			"click #updateBudget"    : "updateBudget",
			"click #en"    : "setLocale",
			"click #nl"    : "setLocale"
	    },
	    newBudget: function(event) {
	    	$('#newBudget', this.$el).tooltip('hide');
	    	vent.trigger(vent.HOME_ACTION_BUDGET_NEW);
			return false;
		},
		updateBudget: function(event) {
	    	$('#updateBudget', this.$el).tooltip('hide');
	    	vent.trigger(vent.HOME_ACTION_BUDGET_UPDATE);
	    	return false;
	    },
	    setLocale: function(event) {
	    	var locale = $(event.target).attr('id');
	    	localStorage.setItem('locale', locale);  
            location.reload();
			return false;
		}
	});
});