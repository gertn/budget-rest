define([ 'vent', 'app', 'views/accounts/accounts' ], 
		function(vent, app, MainAccountsView) {
	
	"use strict";

	vent.on('action:accounts', accountsAction);

	function accountsAction() {
		vent.trigger('app:main:show', {view: new MainAccountsView()});
	};

});