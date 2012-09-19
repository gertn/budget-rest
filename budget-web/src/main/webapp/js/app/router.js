define([
  'jquery',
  'underscore',
  'backbone'
], function($, _, Backbone){
  var AppRouter = Backbone.Router.extend({
    routes: {
      // Define some URL routes
      //'/projects': 'showProjects',
      //'/users': 'showUsers',
      
      // Default
      '*actions': 'defaultAction'
    },
    defaultAction: function(actions){
      // We have no matching route, lets display the home page 
      //mainHomeView.render(); 
    }
  });

  var initialize = function(){
    new AppRouter;
    Backbone.history.start();
  };
  
  return { 
    initialize: initialize
  };
});