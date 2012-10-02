define([
  'jquery',
  'underscore',
  'backbone',
  'event_bus',
  'view/home/home',
  'view/main/nav/toolbar'
], function($, _, Backbone, eventBus, mainHomeView, mainToolbarView) {
  return Backbone.Router.extend({
    routes: {
      '*actions': 'defaultAction'
    },
    initialize: function() { 
    	new mainToolbarView({el: $("body header")}).render(); 
    },
    defaultAction: function(actions){
    	new mainHomeView({el: $("#page")}).render(); 
    	eventBus.trigger('routeChanged', 'home');
    }
  });

});