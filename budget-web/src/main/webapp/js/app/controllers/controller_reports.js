define([ 'vent', 'app', 'views/reports/reports' ], 
		function(vent, app, MainReportsView) {
	
	"use strict";

	vent.on('action:reports', reportsAction);

	function reportsAction() {
		app.showMainContainerInMainLayout(new MainReportsView());
	};

});