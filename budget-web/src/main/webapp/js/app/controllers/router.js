define([ 'vent', 'backbone' ], 
		function(vent, Backbone) {
	"use strict";
	
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
			vent.trigger(vent.HOME_ACTION);
			vent.trigger(vent.ROUTE_CHANGED, 'home');
		},
		reportsAction : function() {
			vent.trigger( vent.REPORTS_ACTION);
			vent.trigger(vent.ROUTE_CHANGED, 'reports');
		},
		accountsAction : function() {
			vent.trigger(vent.ACCOUNTS_ACTION);
			vent.trigger(vent.ROUTE_CHANGED, 'accounts');
		},
		categoriesAction : function() {
			vent.trigger(vent.CATEGORIES_ACTION);
			vent.trigger(vent.ROUTE_CHANGED, 'categories');
		},
		transactionsAction : function() {
			vent.trigger(vent.TRANSACTIONS_ACTION);
			vent.trigger(vent.ROUTE_CHANGED, 'transactions');
		},
		notFoundAction : function() {
			window.location.href='404.html';
		}
		
	});
	
	
});