define(['jquery',
		'underscore',
		'backbone',
		'router/main_router'], function($, _, Backbone, MainRouter) {
	this._router = new MainRouter();
	var router = function() {
		return _router;
	};
	var init = function() {
		Backbone.history.start();
	};
	return 	{
		init: init,
		router: router
	};
});