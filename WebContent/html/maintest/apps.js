Ext.Loader.setConfig({ 
    enabled: true 
    });

Ext.application({
    name: 'Main',

    appFolder: 'app',
   
    controllers: [
                  'AjaxExample'
              ],
              
	launch: function() {
	    Ext.create('Ext.container.Viewport', {
	    	layout: 'fit',
	    	items: [
	          {
	              xtype: 'ajaxRequestForm',
	              }
	          ]
	      });
	}
});