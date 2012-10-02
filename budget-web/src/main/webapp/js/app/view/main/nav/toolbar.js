define([
  'jquery',
  'underscore',
  'backbone',
  'view/main/nav/navigator',
  "i18n!nls/general",
  'text!templates/main/toolbar.html'
], function($, _, Backbone, Navigator, i18n, toolbarTemplate){

  var toolbarView = Navigator.extend({
	  render: function() {
		  var compiledTmpl  = _.template( toolbarTemplate, {i18n : i18n} );
		  $(this.el).html(compiledTmpl );
	      return this;
	  }
  });
  return toolbarView;
});