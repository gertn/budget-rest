define([
  'underscore',
  'backbone'
], function(_, Backbone) {
  var budgetModel = Backbone.Model.extend({
    defaults: {
      name: 'budget'
    },
    initialize: function(){
    }
    
  });
  return budgetModel;

});