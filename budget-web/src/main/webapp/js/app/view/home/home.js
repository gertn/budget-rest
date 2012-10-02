define([
  'jquery',
  'underscore',
  'backbone',
  'view/main/templateNoSidebar',
  'text!templates/view/home/home_main.html',
  'text!templates/view/home/home_toolbar.html'
], function($, _, Backbone, TemplateNoSidebar, homeMainTemplate, homeToolbarTemplate){

	var mainHomeView = TemplateNoSidebar.extend({
		renderMain : function(mainEl) {
			console.log('renderMain');
			mainEl.html(homeToolbarTemplate);
			mainEl.append(homeMainTemplate);
			return this;
		}
	});
  return mainHomeView;
});