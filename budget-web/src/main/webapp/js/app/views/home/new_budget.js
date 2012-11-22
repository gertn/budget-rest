define(	['require', 'marionette', 'jquery', 'app'], function(require, marionette, $, app) {
	"use strict";
	return marionette.ItemView.extend({
		template: 'new_budget_form_tpl',
		events: {
			"click #save"    : "save",
			"click #cancel"    : "cancel"
	    },
	    
	    ui : {
	        name   : '#name',
	        year : '#year',
	        description : '#description'
	    },
	    cancel: function(event) {
	    	require('app').router.navigate("", true);
	    	return false;
	    },
	    save: function(event) {
	    	this.model.save({
				name: this.ui.name.val(),
				year: this.ui.year.val(),
				description: this.ui.description.val()
			}, {success : function(model, res, options) {
		          if (res && res.errors) {
		            //that.renderErrMsg(res.errors);
		          } else {
		        	require('app').router.navigate("", true);
		            model.trigger('save-success', model.get('_id'));
		          }
		        }
		});
			return false;
		}
	});
});