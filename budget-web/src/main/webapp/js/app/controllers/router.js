define([ 'vent', 'backbone' ], 
		function(vent, Backbone) {
	"use strict";
	
	function doHomeAction(action) {
		doAction(action, 'home');
	};
	
	function doAction(action, route) {
		vent.trigger('action:' + action);
		vent.trigger('route:changed', route);
	};

	return Backbone.Router.extend({
		routes : {
			'': 'homeAction',
			'transactions': 'transactionsAction',
			'reports': 'reportsAction',
			'accounts': 'accountsAction',
			'categories': 'categoriesAction',
			'*defaults': 'notFoundAction'
		},

		homeAction : function() {
			doHomeAction('home');
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
		},
		notFoundAction : function() {
			window.location.href='404.html';
		}
		
	});
	
	
});