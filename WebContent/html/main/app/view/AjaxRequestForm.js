Ext.define('Main.view.AjaxRequestForm', {
    extend: 'Ext.form.Panel',
    alias : 'widget.ajaxRequestForm',
    frame: true,
    title: 'Welxcome',
    bodyPadding: '5 5 10',
    layout:'border',
    defaults: {
        anchor: '100%',
        allowBlank: false,
        msgTarget: 'side',
        labelWidth: 75
    },
    items: [{        
        region: 'south',     // position for region
        xtype: 'panel',
        height: 100,
        split: true
    }
    ,{
      title: '選單',
      region:'west',
      xtype: 'panel',
      width: 200,
      collapsible: true,   // make collapsible 可以伸縮
      id: 'west-region-container',
      items: [
              {  
            	  bbar: [
            	         { xtype: 'button', text: '遊戲天堂' }
            	       ]
              },
              {
            	  bbar: [
            	         { xtype: 'button', text: '遊戲天堂' }
            	       ]
              },
              {
                  xtype: 'countryTree',
              }
      ]
    }
    ,{
        region: 'center',
        xtype: 'tabpanel',
        items: [{            
            rtl: false,
            title: 'Bogus Tab',
            dataUrl:'../../page1.jsp'
        }, {
            title: 'Another Tab',
            html: '<h1>123<h1>'
        }, {
            title: 'Closable Tab',
            html: 'Hello world 3'
        },{
        	title: 'Bar',
            tabConfig: {
                title: 'Custom Title',
                tooltip: 'A button tooltip'
        }}]
    }]
//    ,initComponent:function(){
//    	var menu = Ext.createWidget('TR.view.CountryTree',{
//    		region:'west',
//    	})
//    }
});
//Ext.define('Main.view.AjaxRequestForm', {
//    extend: 'Ext.form.Panel',
//    alias : 'widget.ajaxRequestForm',
//    frame: true,
//    title: 'Welxcome',
//    bodyPadding: '5 5 10',
//    layout:'border',
//    defaults: {
//        anchor: '100%',
//        allowBlank: false,
//        msgTarget: 'side',
//        labelWidth: 75
//    },
//    items: [{
//        
//        region: 'south',     // position for region
//        xtype: 'panel',
//        height: 100,
//        split: true
//    }
//    ,{
//        title: '選單',
//        region:'west',
//        xtype: 'panel',
//        width: 200,
//        collapsible: true,   // make collapsible 可以伸縮
//        id: 'west-region-container',
//        layout: 'fit',
//        html:'../menu.jsp'
//    }
//    ,{
//        region: 'center',
//        xtype: 'tabpanel',
//        items: [{            
//            rtl: false,
//            title: 'Bogus Tab',
//            dataUrl:'../../page1.jsp'
//        }, {
//            title: 'Another Tab',
//            html: '<h1>123<h1>'
//        }, {
//            title: 'Closable Tab',
//            html: 'Hello world 3'
//        },{
//        	title: 'Bar',
//            tabConfig: {
//                title: 'Custom Title',
//                tooltip: 'A button tooltip'
//        }}]
//    }]
//});
//Ext.define('Main.view.AjaxRequestForm', {
//        extend: 'Ext.tab.Panel',
//        plugins: 'responsive',
//        responsiveConfig: {
//                landscape: {
//                        tabPosition: 'left'
//                },
//                portrait: {
//                        tabPosition: 'top'
//                }
//        },
//        items: [
//                { title: 'Foo' },
//                { title: 'Bar' }
//        ]
//});
