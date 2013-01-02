define([ 'vent', 'app', 'views/categories/categories' ], 
		function(vent, app, MainCategoriesView) {
	
	"use strict";

	vent.on(vent.CATEGORIES_ACTION, categoriesAction);

	function categoriesAction() {
		vent.trigger(vent.APP_SHOW_MAIN, {view: new MainCategoriesView()});
	};

});