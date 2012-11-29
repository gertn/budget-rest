define(	['vent', 'marionette', 'jquery','i18n!nls/general'], function(vent, marionette, $, i18n) {
	"use strict";
	var select_budget = marionette.ItemView.extend({
		template: 'select_budget_form_tpl',
		events: {
			"click #set_default"    : "setAsDefault"
	    },
		render: function() {
			var self = this;
			dust.render( "select_budget_form_tpl", {i18n : i18n, budgets: this.model.models}, function(err, out) {
				self.$el.append(out);
			});
		 },
		 setAsDefault: function() {
			var selectedId = $('#budgets_dropdown option:selected').val();
			if(selectedId){
				vent.trigger(vent.HOME_ACTION_BUDGET_DEFAULT, selectedId);
			}
	    	return false;
		 }
	});
	
	return select_budget;
});