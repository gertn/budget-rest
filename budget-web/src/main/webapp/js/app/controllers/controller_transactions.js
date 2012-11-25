define([ 'vent', 'app', 'views/transactions/transactions' ], 
		function(vent, app, TransactionsView) {
	"use strict";

	vent.on('action:transactions', transactionsAction);

	function transactionsAction() {
		vent.trigger('app:main:show', {view: new TransactionsView()});
	};

});