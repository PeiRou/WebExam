Ext.define('Main.controller.AjaxExample', {
            extend : 'Ext.app.Controller',
            stores: [
                     'tab1_s'
            ],
            views : [
                     'AjaxRequestForm',
                     'welcome',
                     'tab1_v',
                     'tab2_v',
                     'tab3_v',
                     'tab4_v'
            ],
            refs	:	[
//                	 {ref	:	'base',			selector	:	'menu'}
            ],
            init : function() {
            	console.log("init");
                this.control({   
	                    'welcome' : {
	                        render : this.LoadPanel
	                    },
                    });
            },
            LoadPanel	:	function(){        		
            	console.log("hihi123");
        	}
    });