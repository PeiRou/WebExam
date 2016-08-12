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
		Ext.create('Ext.tab.Panel', {
			title: 'Some Title',
			plugins     : 'viewport',
		    tabPosition : 'left',
		    tabRotation : 0,
		    cls : 'tabpanel',
		    items       : [
		        {
		            title : 'One',
		            html  : 'One'
		        },
		        {
		            title : 'Two',
		            html  : 'Two'
		        },
		        {
		            title : 'Three',
		            html  : 'Three'
		        }
		    ]
		});
	}
});