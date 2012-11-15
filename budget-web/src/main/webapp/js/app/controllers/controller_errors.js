define([ 'vent', 'app', 'views/main/error', 'util/ajaxhandler' ], 
		function(vent, app, MainErrorView) {
	
	"use strict";

	vent.on('ajax:error', errorHandler);

	function errorHandler(response) {
		if (response.status === 422) {
			unprocessableEntityHandler(response.data)
		} else if (response.status === 404) {
			notFoundHandler()
		} else if (response.status === 500) {
			internalServerErrorHandler();
		}
	};
	function unprocessableEntityHandler(errors) {
		app.main.show(new MainErrorView({errors: errors}));
	};
	function notFoundHandler() {
		alert('page not found error!');
	};
	function internalServerErrorHandler() {
		alert('Severe server error!');
	};

});