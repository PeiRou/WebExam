Ext.Loader.setConfig({ 
    enabled: true 
    });

Ext.application({
    name: 'TR',

    appFolder: 'app',
   
    controllers: [
                  'Countries'
              ],

    launch: function() {
        Ext.create('Ext.container.Viewport', {
            items: [                
                {
                    xtype: 'countryTree',
                }
            ]
        });
    }
});
