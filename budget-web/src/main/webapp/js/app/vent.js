define(['marionette'],function(marionette){
  "use strict";
  var vent = new marionette.EventAggregator();
  
  vent.CATEGORIES_ACTION =  'categories:action';
  vent.ACCOUNTS_ACTION =  'accounts:action';
  vent.REPORTS_ACTION =  'reports:action';
  vent.TRANSACTIONS_ACTION =  'transactions:action';
  
  vent.HOME_ACTION =  'home:action';
  vent.HOME_ACTION_BUDGET_SAVED =  'home:action:budget:saved';
  vent.HOME_ACTION_BUDGET_NEW =  'home:action:budget:new';
  vent.HOME_ACTION_BUDGET_DEFAULT =  'home:action:budget:default';
  vent.HOME_ACTION_BUDGET_UPDATE =  'home:action:budget:update';
  
  vent.APP_SHOW_MAIN = 'app:show:main';
  vent.APP_SHOW_MESSAGES =  'app:show:messages';
  vent.APP_INIT_REGIONS =  'app:init:regions';
  
  vent.AJAX_ERROR = 'ajax:error';
  vent.ROUTE_CHANGED = 'route:changed';
  
  return vent;
});