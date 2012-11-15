define([ 'jquery', 'underscore', 'backbone', 'marionette', 'vent' ], function(
		$, _, Backbone, marionette, vent) {

	"use strict";
	var modalRegion = marionette.Region.extend({
		el : "#modal",

		constructor : function() {
			marionette.Region.prototype.constructor.apply(this,
					arguments);
			this.on("show", this.showModal, this);
		},

		getEl : function(selector) {
			var $el = $(selector);
			$el.on("hidden", this.close);
			return $el;
		},

		showModal : function(view) {
			view.on("close", this.hideModal, this);
			this.$el.modal('show');
		},

		hideModal : function() {
			this.$el.modal('hide');
		}
	});
	return modalRegion;
});