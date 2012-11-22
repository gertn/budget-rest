define(	['require', 'marionette', 'jquery','i18n!nls/general',], function(require, marionette, $, i18n) {
	"use strict";
	return marionette.ItemView.extend({
		template: 'select_budget_form_tpl',
		render: function() {
			var self = this;
			dust.render( "select_budget_form_tpl", {i18n : i18n, budgets: this.model.models}, function(err, out) {
				self.$el.append(out);
			});
		 },
	});
});