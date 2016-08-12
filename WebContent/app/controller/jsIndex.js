function load(appName){
	var username ={
			name:'username',
			fieldLabel:'帳號',
			minLength:1,
			minLengthText:'最少{0}個字元'
	}
	var password ={
			name:'password',
			fieldLabel:'密碼',
			minLength:3,
			minLengthText:'最少{0}個字元',
			inputType:'password'
	}
	var btnok = new Ext.Button({
		text:'確定',
		handler:function(){
			var form = this.up('form').getForm();
			submitForm(form,appName);
		}
	});
	var panel = new Ext.form.Panel({		
		title:'登入',
		width: 300,
        height: 140,
        frame:true,
        defaultType: 'textfield',
        bodyPadding: 10,
        defaults: {
            labelWidth: 100
        },
        items:[
   			username,
   			password
   		],
        buttons:[
                btnok
        ]
	}); 
	return panel;
}
function submitForm(form,appName){	 
	appName = appName + '/_01_account/chkAccount.controller';
	console.log(appName);
		if (form.isValid()) {
         form.submit({
        	 url : appName,
             success: function(form, action) {
                Ext.Msg.alert('Success', '登入成功');
                
                location.href = Ext.fly('page1').getAttribute('href');
             },
             failure: function(form, action) {
            	 var data = JSON.parse(action.response.responseText);
            	 Ext.Msg.alert('Failed', '代碼:'+data.errors.clientCode +'<br>錯誤訊息:'+data.errors.portOfLoading);
             }
         });     
        }
	
}