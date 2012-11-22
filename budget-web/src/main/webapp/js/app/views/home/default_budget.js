define(	['require', 'marionette', 'jquery'], function(require, marionette, $) {
	"use strict";
	return marionette.ItemView.extend({
		template: 'default_budget_form_tpl'
	});
});