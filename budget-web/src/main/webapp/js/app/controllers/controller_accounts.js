define([ 'vent', 'app', 'views/accounts/accounts' ], 
		function(vent, app, MainAccountsView) {
	
	"use strict";

	vent.on('action:accounts', accountsAction);

	function accountsAction() {
		app.main.show(new MainAccountsView());
	};

});