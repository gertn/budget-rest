define(	['marionette', 'jquery', 'app'], function(marionette, $, app) {
	return marionette.ItemView.extend({
		template: 'new_budget_form',
		id: 'budget_form',
		events: {
			"click #save"    : "save",
			"click #cancel"    : "cancel"
	    },
	    
	    ui : {
	        name   : '#name',
	        year : '#year',
	        description : '#description'
	      },
	    save: function(event) {
	    	this.model.save({
				name: this.ui.name.val(),
				year: this.ui.year.val(),
				description: this.ui.description.val()
			});
	    	require('app').router.navigate("", true);
			return false;
		},
	    cancel: function(event) {
	    	require('app').router.navigate("", true);
	    	return false;
	    }
	});
});