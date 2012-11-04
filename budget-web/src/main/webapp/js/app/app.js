define(
		['marionette','vent','view/main/nav/toolbar','view/main/footer','view/home/home'],
		function(marionette, vent, MainToolbarView, FooterView, MainHomeView) {
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
			
			return app;
		}
);