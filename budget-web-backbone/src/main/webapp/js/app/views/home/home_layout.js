define(
		['marionette'],
		function(marionette) {
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