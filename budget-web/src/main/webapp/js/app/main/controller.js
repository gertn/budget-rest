define(['vent','app','view/home/home','view/transactions/transactions'], function (vent, app, MainHomeView , TransactionsView) {
  "use strict";
  
  var doAction, homeAction, transactionsAction; 
  
  doAction = function (view, route) {
	  	app.main.show(new view());
  		vent.trigger('route:changed', route);
  };
  
  homeAction = function(actions){
	  doAction(MainHomeView, 'home');
  };
  
  transactionsAction = function(actions){
	  doAction(TransactionsView, 'transactions');
  };
  
  return {
	  homeAction : homeAction, 
	  transactionsAction : transactionsAction
  };
});