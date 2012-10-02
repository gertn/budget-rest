define([
  'jquery',
  'underscore',
  'backbone',
  'view/main/nav/navigator',
  'text!templates/main/templateNoSidebar.html'
], function($, _, Backbone, Navigator, templateNoSidebar){

  var noSidebarView = Backbone.View.extend({
	  renderMain: function() {
		  return this;
	  },
	  render: function() {
		  this.$el.html(templateNoSidebar);
	      this.renderMain($('#main', this.$el));
	      return this;
	  }
	 
  });
  return noSidebarView;
});