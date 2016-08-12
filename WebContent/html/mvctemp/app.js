Ext.Loader.setConfig({
	enabled : true,
//disableCaching: true //強制關閉 cache
});

Ext.application({
	name : 'Frontend', //app folder 別名為 Frontend
	appFolder : 'app', //檔案 root 存放位置
	controllers : [

	'SYS.SYS001', //使用者登入
	'SYS.SYS002', //主畫面
	'MN.MNM001', //群組權限維護
	'US.USM002' //使用者群組維護
	],
	launch : function() {
		Ext.create('Ext.container.Viewport', {
			id : 'mainVP',
			layout : 'fit',
			items : [ {
				xtype : 'sys001loginform',
				url : 'http://localhost:8080/agricloud/user/login.json'
			} ]
		});
	}
});