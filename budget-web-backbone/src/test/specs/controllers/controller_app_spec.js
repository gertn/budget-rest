define([ 'jquery', 'marionette', 'vent', 'app', 'views/main/nav/toolbar', 'views/main/footer', 'views/home/home_layout', 'controllers/controller_app'], 
		function($, marionette, vent, app, MainToolbarView, FooterView, HomeLayout) {
	describe("Controllers - App Controller", function() {
		"use strict";
		
		describe('on APP_SHOW_MAIN trigger', function() {
			
			beforeEach(function() {
				this.view = "view";
				this.mainRegionMock = sinon.mock(app.main);
				this.messagesRegionMock = sinon.mock(app.messages);
			});
			afterEach(function() {
				this.mainRegionMock.restore();
				this.messagesRegionMock.restore();
			});

			it('view is show in main region of app', function() {
				this.mainRegionMock.expects("show").withArgs(this.view).once();
				
				vent.trigger(vent.APP_SHOW_MAIN, {view: this.view});
				
				this.mainRegionMock.verify();
			});
			
			it('messages region of app is reset', function() {
				this.mainRegionMock.expects("show");
				this.messagesRegionMock.expects("reset").once();
				
				vent.trigger(vent.APP_SHOW_MAIN, {view: this.view});
				
				this.messagesRegionMock.verify();
			});
			
			it('messages region of app is not reset when skipResetMessages', function() {
				this.mainRegionMock.expects("show");
				this.messagesRegionMock.expects("reset").never();
				
				vent.trigger(vent.APP_SHOW_MAIN, {view: this.view, skipResetMessages: true});
				
				this.messagesRegionMock.verify();
			});
			
			
		});
		
	});
});