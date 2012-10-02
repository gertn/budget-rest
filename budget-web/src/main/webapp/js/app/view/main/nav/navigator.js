define([
  'jquery',
  'underscore',
  'backbone',
  'event_bus'
], function($, _, Backbone, eventBus){

  var navView = Backbone.View.extend({
	  initialize: function() { 
		  eventBus.on("routeChanged", this.setActiveLink, this);
	   },
	  setActiveLink: function(linkName){
		  this.$('li').removeClass('active');
		  this.$('li[data-id="'+ linkName +'"]').addClass('active');
	  }	 
  });
  return navView;
});