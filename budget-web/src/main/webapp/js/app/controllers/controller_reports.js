define([ 'vent', 'app', 'views/reports/reports' ], 
		function(vent, app, MainReportsView) {
	
	"use strict";

	vent.on(vent.REPORTS_ACTION, reportsAction);

	function reportsAction() {
		vent.trigger(vent.APP_SHOW_MAIN, {view: new MainReportsView()});
	};

});