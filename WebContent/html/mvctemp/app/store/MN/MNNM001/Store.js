// app.store.MN.MNM001.Store.js
    Ext.define('Frontend.store.MN.MNM001.Store' ,{
        model:'Frontend.model.MN.MNM001.MenuGroup', 
        extend: 'Ext.data.Store',
        alias : 'widget.mnm001store',
        autoLoad: true,
        proxy: {
            type: 'rest',   // 使用 rest 來與後端 server 溝通
            url: 'http://localhost:8080/agricloud/rest/menuGroup/',
            reader: {
                type: 'json',
                root: 'items'
            },
            writer: {
                type: 'json'
            },
            afterRequest:function(request,success){
                var operation = request.operation;
                var response = operation.response; 
                if(success){
                }else{}
            }
        },
        listeners: {
            // 讀取完資料後，進行 load 
            write: function(store, operation) {
                store.load();
            }
        }
    });