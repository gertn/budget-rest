define(
		['marionette','vent'],
		function(marionette, vent) {
			"use strict";
			return  marionette.Layout.extend({
				  template: 'home_layout_tpl',

				  regions: {
				    toolbar: '#home-toolbar-section',
				    defaultBugdet: '#default-budget-section',
				    selectBugdet: '#select-budget-section'
				  }
			});
		}
);