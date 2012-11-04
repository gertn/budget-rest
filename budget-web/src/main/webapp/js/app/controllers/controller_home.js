define([ 'vent', 'app', 'views/home/home' ], 
		function(vent, app, MainHomeView) {
	
	"use strict";

	vent.on('action:home', homeAction);

	function homeAction() {
		app.main.show(new MainHomeView());
	};

});