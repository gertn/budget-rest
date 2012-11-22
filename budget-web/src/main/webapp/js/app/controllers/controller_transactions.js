define([ 'vent', 'app', 'views/transactions/transactions' ], 
		function(vent, app, TransactionsView) {
	"use strict";

	vent.on('action:transactions', transactionsAction);

	function transactionsAction() {
		app.showMainContainerInMainLayout(new TransactionsView());
	};

});