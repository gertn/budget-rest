define(
		['marionette','vent'],
		function(marionette, vent) {
			"use strict";
			return  marionette.Layout.extend({
				  template: 'main_layout_tpl',

				  regions: {
				    messages: '#messages',
				    mainContainer: '#main-container'
				  }
			});
		}
);