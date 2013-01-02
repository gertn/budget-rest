define([ 'vent', 'app', 'views/transactions/transactions' ], 
		function(vent, app, TransactionsView) {
	"use strict";

	vent.on(vent.TRANSACTIONS_ACTION, transactionsAction);

	function transactionsAction() {
		vent.trigger(vent.APP_SHOW_MAIN, {view: new TransactionsView()});
	};

});