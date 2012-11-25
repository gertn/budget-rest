define(	['require', 'vent', 'marionette', 'jquery', 'app'], function(require, vent, marionette, $, app) {
	"use strict";
	return marionette.ItemView.extend({
		template: 'budget_form_tpl',
		events: {
			"click #save"    : "save",
			"click #cancel"    : "cancel"
	    },
	    onRender: function(){
	        this.ui.legend.html(this.options.title);
	    },
	    ui : {
	    	legend: 'legend',
	        name   : '#name',
	        year : '#year',
	        description : '#description'
	    },
	    cancel: function(event) {
	    	vent.trigger('action:home');
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
		            vent.trigger('action:budgetSaved', model.get('id'));
		          }
		        }
//			, error : function(model, xhr, options) {
//		          console.log(xhr);
//		          console.log('yes we did it');
//			}
			});
			return false;
		}
	});
});