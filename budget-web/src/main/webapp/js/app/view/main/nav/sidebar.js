define([
  'jquery',
  'underscore',
  'backbone',
  'view/main/nav/navigator',
  'text!templates/main/sidebar.html'
], function($, _, Backbone, Navigator, sidebarTemplate){

  var sidebarView = Navigator.extend({
	  render: function() {
	      $el.html(sidebarTemplate);
	      return this;
	  }
  });
  return sidebarView;
});