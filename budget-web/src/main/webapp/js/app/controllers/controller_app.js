define([ 'vent', 'app', 'views/main/nav/toolbar', 'views/main/footer', 'views/home/home_layout' ], 
		function(vent, app, MainToolbarView, FooterView, HomeLayout) {
	
	"use strict";

	vent.on(vent.APP_SHOW_MAIN, showMain);
	vent.on(vent.APP_SHOW_MESSAGES, showMessages);
	vent.on(vent.APP_INIT_REGIONS, initRegions);

	function showMain(options) {
		if(!options.skipResetMessages){
			app.messages.reset();
		}
		app.main.show(options.view);
	};
	
	function showMessages(options) {
		app.messages.show(options.view);
	};
	
	function initRegions() {
		app.messages.reset();
		app.header.show(new MainToolbarView());
		app.footer.show(new FooterView());
		app.main.show(new HomeLayout());
	};

});