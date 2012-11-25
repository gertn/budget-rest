define([ 'vent', 'app', 'views/reports/reports' ], 
		function(vent, app, MainReportsView) {
	
	"use strict";

	vent.on('action:reports', reportsAction);

	function reportsAction() {
		vent.trigger('app:main:show', {view: new MainReportsView()});
	};

});