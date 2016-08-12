Ext.define('Main.store.tab1_s', {
	extend: 'Ext.data.Store',
    model: 'Main.model.Columns_m',
    autoLoad: true,
    proxy: {
        type: 'ajax',
//        api: {
//            read: 'data/customers.json',
//        },
        url: '_03_ante/loadAnte.controller',
        extraParams: {
            store_id: 1
        },
        reader: {
            type: 'json',
            root: 'customers',
            successProperty: 'success'
        }
    }
});