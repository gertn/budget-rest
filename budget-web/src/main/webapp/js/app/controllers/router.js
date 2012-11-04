define([ 'vent', 'backbone' ], 
		function(vent, Backbone) {
	"use strict";

	return Backbone.Router.extend({
		routes : {
			'transactions': 'transactionsAction',
			'reports': 'reportsAction',
			'accounts': 'accountsAction',
			'categories': 'categoriesAction',
			'*defaults': 'homeAction'
		},

		homeAction : function() {
			vent.trigger('action:home');
			vent.trigger('route:changed', 'home');
		},
		reportsAction : function() {
			vent.trigger('action:reports');
			vent.trigger('route:changed', 'reports');
		},
		accountsAction : function() {
			vent.trigger('action:accounts');
			vent.trigger('route:changed', 'accounts');
		},
		categoriesAction : function() {
			vent.trigger('action:categories');
			vent.trigger('route:changed', 'categories');
		},
		transactionsAction : function() {
			vent.trigger('action:transactions');
			vent.trigger('route:changed', 'transactions');
		}
		
	});
	
	
});