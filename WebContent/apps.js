Ext.Loader.setConfig({ 
    enabled: true 
    });

Ext.application({
    name: 'MyAjaxApp',

    appFolder: 'app',
   
    controllers: [
                  'AjaxExample'
              ],

    launch: function() {
    	Ext.create('Ext.window.Window', {
    	    title: 'Hello',
    	    height: 200,
    	    width: 400,
    	    closable:false,
    	    layout: 'fit',
    	    items: {  
    	    	xtype: 'ajaxRequestForm'
    	    }
    	}).show();
    }
});