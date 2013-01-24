'use strict';

angular.module('services.localizedMessages', []).factory('localizedMessages', ['$interpolate', function ($interpolate) {

  var handleNotFound = function (msg, msgKey) {
    return msg || '?' + msgKey + '?';
  };
  
  function resolveProperty(interpolateParams, messageBundle){
	  return messageBundle.properties[interpolateParams.property] ? messageBundle.properties[interpolateParams.property]: interpolateParams.property;
  };

  return {
    get : function (msgKey, interpolateParams, messageBundle) {
      var msg =  messageBundle.messages[msgKey];
      if (msg) {
    	if(interpolateParams.hasOwnProperty('property')){
    		interpolateParams.property = resolveProperty(interpolateParams, messageBundle);
    	}
        return $interpolate(msg)(interpolateParams);
      } else {
        return handleNotFound(msg, msgKey);
      }
    }
  };
}]);