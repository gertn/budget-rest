define([
  'jquery',
  'underscore',
  'backbone',
  'marionette',
  'vent'
], function($, _, Backbone, marionette, vent){

  var navView = marionette.ItemView.extend({
	  initialize: function() { 
		  this.bindTo(vent, vent.ROUTE_CHANGED, this.setActiveLink, this);
	   },
	  setActiveLink: function(linkName){
		  this.$('li').removeClass('active');
		  this.$('li[data-id="'+ linkName +'"]').addClass('active');
	  }	 
  });
  return navView;
});