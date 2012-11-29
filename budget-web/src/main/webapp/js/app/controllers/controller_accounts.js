define([ 'vent', 'app', 'views/accounts/accounts' ], 
		function(vent, app, MainAccountsView) {
	
	"use strict";

	vent.on(vent.ACCOUNTS_ACTION, accountsAction);

	function accountsAction() {
		vent.trigger(vent.APP_SHOW_MAIN, {view: new MainAccountsView()});
	};

});