define(['jquery','vent'], function($, vent) {
	"use strict";
	$(document).ajaxError(function(e, jqxhr, settings, exception) {
		/*var json = !jqxhr.getResponseHeader('content-type').indexOf('application/json');
		var data = json ? $.parseJSON(jqxhr.responseText) : jqxhr.responseText;
		vent.trigger('ajax:error', {status: jqxhr.status, data: data});*/
	});
});