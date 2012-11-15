define(
		['marionette','vent','views/main/nav/toolbar','views/main/footer','views/home/home', 'controllers/router', 'views/main/region/modalregion'],
		function(marionette, vent, MainToolbarView, FooterView, MainHomeView, MainRouter, ModalRegion) {
			"use strict";
			var app = new marionette.Application();
			
			app.addRegions({
				header : '#header',
				main   : '#main',
				footer : '#footer',
				modal: ModalRegion
			});
			
			app.addInitializer(function(){
				app.header.show(new MainToolbarView());
				app.footer.show(new FooterView());
			});
			
			app.on("initialize:after", function(options){
				app.router = new MainRouter();
				
				Backbone.history.start();
			});
			
			return app;
		}
);