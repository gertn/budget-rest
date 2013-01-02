define([
  'jquery',
  'underscore',
  'backbone',
  'views/main/nav/navigator',
  "i18n!nls/general",
  'dust'
], function($, _, Backbone, Navigator, i18n, Dust){
	"use strict";
	var footer = Backbone.View.extend({
		  render: function() {
			  var that = this;
			  Dust.render( 'footer', {i18n : i18n}, function(err, out) {
				  that.$el.html(out);
			  });
		      return this;
		  }
	});
	
	return footer;
	
});