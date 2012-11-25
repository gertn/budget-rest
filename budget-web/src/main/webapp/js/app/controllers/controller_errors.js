define([ 'vent', 'views/main/error', 'util/ajaxhandler' ], 
		function(vent, MainErrorView) {
	
	"use strict";

	vent.on('ajax:error', errorHandler);

	function errorHandler(response) {
		if (response.status === 422) {
			unprocessableEntityHandler(response.data);
		} else if (response.status === 404) {
			notFoundHandler();
		} else if (response.status === 500) {
			internalServerErrorHandler();
		} else {
			unkownErrorHandler();
		}
	};
	function unprocessableEntityHandler(errors) {
		vent.trigger('app:messages:show', {view: new MainErrorView({errors: errors})});
	};
	function notFoundHandler() {
		alert('page not found error!');
	};
	function internalServerErrorHandler() {
		window.location.href='500.html';
	};
	function unkownErrorHandler() {
		alert('Unknown server error!');
	};

});