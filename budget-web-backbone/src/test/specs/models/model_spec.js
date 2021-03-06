define([ 'jquery', 'models/model', 'util/ajaxhandler', 'backbone' ], function($, Model, ajaxhandler, Backbone) {
	describe("Models - Model", function() {
		"use strict";
		
		beforeEach(function() {
			sinon.stub(Backbone, "sync");
		});
		afterEach(function() {
			Backbone.sync.restore();
		});
		
		it("should be instance of Backbone.Model", function() {
		      expect(new Model()).toBeInstanceOf(Backbone.Model);
		 });

		describe('when overriding save', function() {
			
			beforeEach(function() {
				this.spyOnBackboneModelSave = sinon.spy(Backbone.Model.prototype, 'save');
			});
			afterEach(function() {
				Backbone.Model.prototype.save.restore();
			});

			it('should call Backbone.Model.prototype.save', function() {
				var ExtendedModel = Model.extend({urlRoot: "url"});
				var attrs = { name: 'name'},
				options = { error: function(){}};
				
				new ExtendedModel().save(attrs, options);
				
				expect(Backbone.Model.prototype.save).toHaveBeenCalledWith(attrs, options);
			});
			
			it('should add error callback when not provided in options', function() {
				 
				var ExtendedModel = Model.extend({urlRoot: "url"});
				var attrs = { name: 'name'},
				optionsWithoutError = {},
				options = { error: ajaxhandler.error};
				
				new ExtendedModel().save(attrs, optionsWithoutError);
				
				expect(Backbone.Model.prototype.save).toHaveBeenCalledWith(attrs, options);
			});

		});
		
		describe('when overriding fetch', function() {
			
			beforeEach(function() {
				this.spyOnBackboneModelFetch = sinon.spy(Backbone.Model.prototype, 'fetch');
				this.ExtendedModel = Model.extend({urlRoot: "url"});
			});
			afterEach(function() {
				Backbone.Model.prototype.fetch.restore();
			});

			it('should call Backbone.Model.prototype.fetch', function() {
				var options = { error: function(){}};
				
				new this.ExtendedModel().fetch(options);
				
				expect(this.spyOnBackboneModelFetch).toHaveBeenCalledWith(options);
			});
			
			it('should add error callback when not provided in options', function() {
				var optionsWithoutError = {},
				options = { error: ajaxhandler.error};
				
				new this.ExtendedModel().fetch(optionsWithoutError);
				
				expect(this.spyOnBackboneModelFetch).toHaveBeenCalledWith(options);
			});

		});
	});
});