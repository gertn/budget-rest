define(['jquery','vent'], function($, vent) {
	"use strict";
	
	var error = function(model, xhr, options) {
		var json = !xhr.getResponseHeader('content-type').indexOf('application/json');
		var data = json ? $.parseJSON(xhr.responseText) : xhr.responseText;
		vent.trigger(vent.AJAX_ERROR, {status: xhr.status, data: data});
	};
	
	return {
		error: error
	};
});