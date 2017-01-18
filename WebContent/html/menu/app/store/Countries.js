Ext.define('TR.store.Countries', {
    extend: 'Ext.data.TreeStore',
    defaults:{
    	folderSort: false,
    },
    proxy: {
        type: 'ajax',
        url : '../../_02_MenuTree/CountryServlet.controller'
    },
    root: {
        text: 'Tree display of Countries',
        id: 'myTree',
        expanded: true
    },
    autoLoad	:	true,
//    sorters: [
//              {
//				    property: 'RowNum',
//				    direction: 'ASC'
//				}
//    ]
    sorters: null,
});