define(
		['marionette','vent','views/main/nav/toolbar','views/main/footer','views/home/home', 'controllers/router'],
		function(marionette, vent, MainToolbarView, FooterView, MainHomeView, MainRouter) {
			"use strict";
			var app = new marionette.Application();
			
			app.addRegions({
				header : '#header',
				main   : '#main',
				footer : '#footer'
			});
			
			app.addInitializer(function(){
				app.header.show(new MainToolbarView());
				app.footer.show(new FooterView());
			});
			
			app.on("initialize:after", function(options){
				var router = new MainRouter();
				
				_.extend(app, {router : router});
				
				if (Backbone.history){
					Backbone.history.start();
				}
			});
			
			return app;
		}
);