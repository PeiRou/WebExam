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
		            title : '首頁',
		            xtype : 'welcome'
		        },
		        {
		            title : 'One',
		            xtype : 'tab1'
		        },
		        {
		            title : 'Two',
		            xtype : 'tab2'
		        },
		        {
		            title : 'Three',
		            xtype : 'tab3'
		        },
		        {
		            title : 'four',
		            xtype : 'tab4'
		        }
		        
		    ]
		});
	}
});