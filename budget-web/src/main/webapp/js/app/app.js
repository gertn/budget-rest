define(
		['marionette','vent', 'controllers/router', 'views/main/region/modalregion'],
		function(marionette, vent, MainRouter, ModalRegion) {
			"use strict";
			var app = new marionette.Application();
			
			app.addRegions({
				header : '#header',
				messages : '#messages',
				main   : '#main',
				footer : '#footer',
				modal: ModalRegion
			});
			
			app.addInitializer(function(){
				vent.trigger('app:init:regions');
			});
			
			app.on("initialize:after", function(options){
				app.router = new MainRouter();
				
				Backbone.history.start();
			});
			
			return app;
		}
);