(function(){dust.register("base",body_0);function body_0(chk,ctx){return chk.write("<div id=\"main-container\" class=\"span12\">").block(ctx.getBlock("container-toolbar"),ctx,{},null).block(ctx.getBlock("container"),ctx,{},null).write("</div>");}return body_0;})();(function(){dust.register("footer",body_0);function body_0(chk,ctx){return chk.write("<p>© Company 2012</p>");}return body_0;})();(function(){dust.register("toolbar",body_0);function body_0(chk,ctx){return chk.write("<div id=\"headerToolbar\" class=\"navbar navbar-inverse navbar-fixed-top\"><div class=\"navbar-inner\"><div class=\"container-fluid\"><button type=\"button\" class=\"btn btn-navbar\" data-toggle=\"collapse\" data-target=\".nav-collapse\"><span class=\"icon-bar\"></span><span class=\"icon-bar\"></span><span class=\"icon-bar\"></span></button><a data-id=\"nav-link\" class=\"brand\" href=\"#\">").reference(ctx.getPath(false,["i18n","budget_title"]),ctx,"h").write("</a><div class=\"nav-collapse collapse\" id=\"main-menu\"><ul class=\"nav\" id=\"main-menu-left\"><li data-id=\"home\"><a data-id=\"nav-link\" href=\"#\"><i class=\"icon-home header-icon\"></i> ").reference(ctx.getPath(false,["i18n","home"]),ctx,"h").write("</a> </li><li data-id=\"transactions\"><a data-id=\"nav-link\" href=\"#transactions\"><i class=\"icon-retweet header-icon\"></i> ").reference(ctx.getPath(false,["i18n","transactions"]),ctx,"h").write("</a></li><li data-id=\"reports\"><a data-id=\"nav-link\" href=\"#reports\"><i class=\"icon-bar-chart header-icon\"></i> ").reference(ctx.getPath(false,["i18n","reports"]),ctx,"h").write("</a></li><li data-id=\"accounts\"><a data-id=\"nav-link\" href=\"#accounts\"><i class=\"icon-credit-card header-icon\"></i> ").reference(ctx.getPath(false,["i18n","accounts"]),ctx,"h").write("</a></li><li data-id=\"categories\"><a data-id=\"nav-link\" href=\"#categories\"><i class=\"icon-envelope header-icon\"></i> ").reference(ctx.getPath(false,["i18n","categories"]),ctx,"h").write("</a></li></ul><ul class=\"nav pull-right\" id=\"main-menu-right\"><li data-id=\"settings\"><a data-id=\"nav-link\" href=\"#\"><i class=\"icon-cog header-icon\"></i></a></li></ul></div></div></div></div>");}return body_0;})();(function(){dust.register("accounts",body_0);var blocks={'toolbar':body_1,'container':body_2};function body_0(chk,ctx){ctx=ctx.shiftBlocks(blocks);return chk.partial("base",ctx,null);}function body_1(chk,ctx){ctx=ctx.shiftBlocks(blocks);return chk.write("<div class=\"btn-toolbar\"></div>");}function body_2(chk,ctx){ctx=ctx.shiftBlocks(blocks);return chk.write("<p>this is the accounts page!!</p>");}return body_0;})();(function(){dust.register("categories",body_0);var blocks={'toolbar':body_1,'container':body_2};function body_0(chk,ctx){ctx=ctx.shiftBlocks(blocks);return chk.partial("base",ctx,null);}function body_1(chk,ctx){ctx=ctx.shiftBlocks(blocks);return chk.write("<div class=\"btn-toolbar\"></div>");}function body_2(chk,ctx){ctx=ctx.shiftBlocks(blocks);return chk.write("<p>this is the categories page!!</p>");}return body_0;})();(function(){dust.register("control_group",body_0);function body_0(chk,ctx){return chk.write("<div class=\"control-group\"><label class=\"control-label\" for=\"").reference(ctx.get("_id"),ctx,"h").write("\">").reference(ctx.get("label"),ctx,"h").write("</label><div class=\"controls\">").block(ctx.getBlock("controls"),ctx,{},null).exists(ctx.get("help-block"),ctx,{"block":body_1},null).write("</div></div>");}function body_1(chk,ctx){return chk.write("<span class=\"help-block\">").reference(ctx.get("help-block"),ctx,"h").write("</span>");}return body_0;})();(function(){dust.register("input_text_field",body_0);var blocks={'controls':body_1};function body_0(chk,ctx){ctx=ctx.shiftBlocks(blocks);return chk.partial("control_group",ctx,null);}function body_1(chk,ctx){ctx=ctx.shiftBlocks(blocks);return chk.write("<input type=\"text\" id=\"").reference(ctx.get("_id"),ctx,"h").write("\" ").exists(ctx.get("placeholder"),ctx,{"block":body_2},null).write("/>");}function body_2(chk,ctx){ctx=ctx.shiftBlocks(blocks);return chk.write("placeholder=\"").reference(ctx.get("placeholder"),ctx,"h").write("\"");}return body_0;})();(function(){dust.register("output_text_field",body_0);var blocks={'controls':body_1};function body_0(chk,ctx){ctx=ctx.shiftBlocks(blocks);return chk.partial("control_group",ctx,null);}function body_1(chk,ctx){ctx=ctx.shiftBlocks(blocks);return chk.write("<input type=\"text\" id=\"").reference(ctx.get("_id"),ctx,"h").write("\" value=").reference(ctx.get("value"),ctx,"h").write(" disabled />");}return body_0;})();(function(){dust.register("output_textarea_field",body_0);var blocks={'controls':body_1};function body_0(chk,ctx){ctx=ctx.shiftBlocks(blocks);return chk.partial("control_group",ctx,null);}function body_1(chk,ctx){ctx=ctx.shiftBlocks(blocks);return chk.write("<textarea id=\"").reference(ctx.get("_id"),ctx,"h").write("\" rows=\"").exists(ctx.get("rows"),ctx,{"else":body_2,"block":body_3},null).write("\" disabled>").reference(ctx.get("value"),ctx,"h").write("</textarea>");}function body_2(chk,ctx){ctx=ctx.shiftBlocks(blocks);return chk.write("3");}function body_3(chk,ctx){ctx=ctx.shiftBlocks(blocks);return chk.reference(ctx.get("rows"),ctx,"h");}return body_0;})();(function(){dust.register("textarea_field",body_0);var blocks={'controls':body_1};function body_0(chk,ctx){ctx=ctx.shiftBlocks(blocks);return chk.partial("control_group",ctx,null);}function body_1(chk,ctx){ctx=ctx.shiftBlocks(blocks);return chk.write("<textarea id=\"").reference(ctx.get("_id"),ctx,"h").write("\" rows=\"").exists(ctx.get("rows"),ctx,{"else":body_2,"block":body_3},null).write("\"></textarea>");}function body_2(chk,ctx){ctx=ctx.shiftBlocks(blocks);return chk.write("3");}function body_3(chk,ctx){ctx=ctx.shiftBlocks(blocks);return chk.reference(ctx.get("rows"),ctx,"h");}return body_0;})();(function(){dust.register("errors_tpl",body_0);function body_0(chk,ctx){return chk.write("<button type=\"button\" class=\"close\" data-dismiss=\"alert\">x</button>").section(ctx.getPath(false,["data","errors"]),ctx,{"block":body_1},null);}function body_1(chk,ctx){return chk.write("<p>").reference(ctx.getPath(true,[]),ctx,"h").write("</p>");}return body_0;})();(function(){dust.register("select_budgets_field",body_0);var blocks={'controls':body_1};function body_0(chk,ctx){ctx=ctx.shiftBlocks(blocks);return chk.partial("control_group",ctx,null);}function body_1(chk,ctx){ctx=ctx.shiftBlocks(blocks);return chk.write("<select id=\"").reference(ctx.get("_id"),ctx,"h").write("\" name=\"budgets_dropdown\" class='input-xxlarge'><option value=\"\">...</option>").section(ctx.get("budgets"),ctx,{"block":body_2},null).write("</select>");}function body_2(chk,ctx){ctx=ctx.shiftBlocks(blocks);return chk.write("<option value=\"").reference(ctx.getPath(false,["attributes","id"]),ctx,"h").write("\">").reference(ctx.getPath(false,["attributes","name"]),ctx,"h").write(" - ").reference(ctx.getPath(false,["attributes","year"]),ctx,"h").write("</option>");}return body_0;})();(function(){dust.register("default_budget_form_tpl",body_0);function body_0(chk,ctx){return chk.write("<form class=\"form-horizontal\"><fieldset><legend>").reference(ctx.getPath(false,["i18n","budget","default_budget"]),ctx,"h").write("</legend>").partial("output_text_field",ctx,{"_id":"name","label":body_1,"value":body_2}).write(" ").partial("output_text_field",ctx,{"_id":"year","label":body_3,"value":body_4}).partial("output_textarea_field",ctx,{"_id":"description","label":body_5,"value":body_6}).write("</fieldset></form>");}function body_1(chk,ctx){return chk.reference(ctx.getPath(false,["i18n","properties","name"]),ctx,"h");}function body_2(chk,ctx){return chk.reference(ctx.get("name"),ctx,"h");}function body_3(chk,ctx){return chk.reference(ctx.getPath(false,["i18n","properties","year"]),ctx,"h");}function body_4(chk,ctx){return chk.reference(ctx.get("year"),ctx,"h");}function body_5(chk,ctx){return chk.reference(ctx.getPath(false,["i18n","properties","description"]),ctx,"h");}function body_6(chk,ctx){return chk.reference(ctx.get("description"),ctx,"h");}return body_0;})();(function(){dust.register("home",body_0);var blocks={'container-toolbar':body_1,'container':body_2};function body_0(chk,ctx){ctx=ctx.shiftBlocks(blocks);return chk.partial("base",ctx,null);}function body_1(chk,ctx){ctx=ctx.shiftBlocks(blocks);return chk.write("<div id=\"home_container_toolbar\" class=\"btn-toolbar\"><div class=\"btn-group\"><button id=\"newBudget\" type=\"button\" class=\"btn\" data-placement=\"bottom\" title=\"").reference(ctx.getPath(false,["i18n","budget","new_budget"]),ctx,"h").write("\"><i class=\"icon-plus\"></i></button></div></div><hr>");}function body_2(chk,ctx){ctx=ctx.shiftBlocks(blocks);return chk.write("<p>this is the main home page!!</p>");}return body_0;})();(function(){dust.register("home_layout_tpl",body_0);function body_0(chk,ctx){return chk.write("<section id=\"home-toolbar-section\"></section><section id=\"default-budget-section\" class=\"well\"></section><section id=\"select-budget-section\" class=\"well\"></section>");}return body_0;})();(function(){dust.register("home_toolbar_tpl",body_0);function body_0(chk,ctx){return chk.write("<div id=\"home_container_toolbar\" class=\"btn-toolbar\"><div class=\"btn-group\"><button id=\"newBudget\" type=\"button\" class=\"btn\" data-placement=\"bottom\" title=\"").reference(ctx.getPath(false,["i18n","budget","new_budget"]),ctx,"h").write("\"><i class=\"icon-plus\"></i></button></div></div><hr>");}return body_0;})();(function(){dust.register("new_budget_form_tpl",body_0);function body_0(chk,ctx){return chk.write("<form class=\"form-horizontal\"><fieldset><legend>").reference(ctx.getPath(false,["i18n","budget","new_budget"]),ctx,"h").write("</legend>").partial("input_text_field",ctx,{"_id":"name","label":body_1,"help-block":body_2}).write(" ").partial("input_text_field",ctx,{"_id":"year","label":body_3,"help-block":body_4}).partial("textarea_field",ctx,{"_id":"description","label":body_5,"help-block":body_6}).write("<div class=\"form-actions\"><button id=\"save\" type=\"submit\" class=\"btn btn-primary\">").reference(ctx.getPath(false,["i18n","buttons","save"]),ctx,"h").write("</button><button id=\"cancel\" type=\"button\" class=\"btn\">").reference(ctx.getPath(false,["i18n","buttons","cancel"]),ctx,"h").write("</button></div></fieldset></form>");}function body_1(chk,ctx){return chk.reference(ctx.getPath(false,["i18n","properties","name"]),ctx,"h");}function body_2(chk,ctx){return chk.reference(ctx.getPath(false,["i18n","budget","name_help"]),ctx,"h");}function body_3(chk,ctx){return chk.reference(ctx.getPath(false,["i18n","properties","year"]),ctx,"h");}function body_4(chk,ctx){return chk.reference(ctx.getPath(false,["i18n","budget","year_help"]),ctx,"h");}function body_5(chk,ctx){return chk.reference(ctx.getPath(false,["i18n","properties","description"]),ctx,"h");}function body_6(chk,ctx){return chk.reference(ctx.getPath(false,["i18n","budget","description_help"]),ctx,"h");}return body_0;})();(function(){dust.register("select_budget_form_tpl",body_0);function body_0(chk,ctx){return chk.write("<form class=\"form-vertical\">").partial("select_budgets_field",ctx,{"_id":"budgets_dropdown","label":body_1}).write("<div class=\"form-actions\"><button id=\"set_default\" type=\"submit\" class=\"btn btn-primary\">").reference(ctx.getPath(false,["i18n","buttons","set_default"]),ctx,"h").write("</button></div></form>");}function body_1(chk,ctx){return chk.reference(ctx.getPath(false,["i18n","budget","select_budget"]),ctx,"h");}return body_0;})();(function(){dust.register("main_layout_tpl",body_0);function body_0(chk,ctx){return chk.write("<div id=\"messages\" class=\"row-fluid\"></div><div id=\"main-container\" class=\"row-fluid\"></div>");}return body_0;})();(function(){dust.register("new_budget_modal",body_0);function body_0(chk,ctx){return chk.write("<div class=\"modal-header\"><button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button><h3>").reference(ctx.getPath(false,["i18n","budget","new_budget"]),ctx,"h").write("</h3></div><div class=\"modal-body\"><form class=\"form-horizontal\">").partial("input_text",ctx,{"_id":"name","label":body_1,"help-block":body_2}).write(" ").partial("input_text",ctx,{"_id":"year","label":body_3,"help-block":body_4}).partial("textarea",ctx,{"_id":"description","label":body_5,"help-block":body_6}).write("</form></div><div class=\"modal-footer\"><button id=\"cancel\" data-dismiss=\"modal\" aria-hidden=\"true\" class=\"btn\">").reference(ctx.getPath(false,["i18n","buttons","cancel"]),ctx,"h").write("</button><button id=\"save\" class=\"btn btn-primary\">").reference(ctx.getPath(false,["i18n","buttons","save"]),ctx,"h").write("</button></div>");}function body_1(chk,ctx){return chk.reference(ctx.getPath(false,["i18n","properties","name"]),ctx,"h");}function body_2(chk,ctx){return chk.reference(ctx.getPath(false,["i18n","budget","name_help"]),ctx,"h");}function body_3(chk,ctx){return chk.reference(ctx.getPath(false,["i18n","properties","year"]),ctx,"h");}function body_4(chk,ctx){return chk.reference(ctx.getPath(false,["i18n","budget","year_help"]),ctx,"h");}function body_5(chk,ctx){return chk.reference(ctx.getPath(false,["i18n","properties","description"]),ctx,"h");}function body_6(chk,ctx){return chk.reference(ctx.getPath(false,["i18n","budget","description_help"]),ctx,"h");}return body_0;})();(function(){dust.register("reports",body_0);var blocks={'toolbar':body_1,'container':body_2};function body_0(chk,ctx){ctx=ctx.shiftBlocks(blocks);return chk.partial("base",ctx,null);}function body_1(chk,ctx){ctx=ctx.shiftBlocks(blocks);return chk.write("<div class=\"btn-toolbar\"></div>");}function body_2(chk,ctx){ctx=ctx.shiftBlocks(blocks);return chk.write("<p>this is the reports page!!</p>");}return body_0;})();(function(){dust.register("transactions",body_0);var blocks={'toolbar':body_1,'container':body_2};function body_0(chk,ctx){ctx=ctx.shiftBlocks(blocks);return chk.partial("base",ctx,null);}function body_1(chk,ctx){ctx=ctx.shiftBlocks(blocks);return chk.write("<div class=\"btn-toolbar\"></div>");}function body_2(chk,ctx){ctx=ctx.shiftBlocks(blocks);return chk.write("<p>this is the transactions page!!</p>");}return body_0;})();