define(
		['marionette','vent','views/main/nav/toolbar','views/main/main_layout','views/main/footer','views/home/home', 'controllers/router', 'views/main/region/modalregion'],
		function(marionette, vent, MainToolbarView, MainLayout, FooterView, MainHomeView, MainRouter, ModalRegion) {
			"use strict";
			var app = new marionette.Application();
			
			app.addRegions({
				header : '#header',
				main   : '#main',
				footer : '#footer',
				modal: ModalRegion
			});
			
			app.mainLayout = new MainLayout();
			
			app.showMainContainerInMainLayout = function(View){
				app.mainLayout.messages.reset();
				app.mainLayout.mainContainer.show(View);
			};
			
			app.addInitializer(function(){
				app.header.show(new MainToolbarView());
				app.footer.show(new FooterView());
				app.main.show(app.mainLayout);
			});
			
			app.on("initialize:after", function(options){
				app.router = new MainRouter();
				
				Backbone.history.start();
			});
			
			return app;
		}
);