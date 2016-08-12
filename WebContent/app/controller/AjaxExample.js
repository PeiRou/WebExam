Ext.define('MyAjaxApp.controller.AjaxExample', {
            extend : 'Ext.app.Controller',

            //define the views
            views : ['AjaxRequestForm'],

            //special method that is called when your application boots
            init : function() {
               
                //control function makes it easy to listen to events on 
                //your view classes and take some action with a handler function
                this.control({
                   
                            //when the viewport is rendered
                            'viewport > panel' : {
                                render : this.onPanelRendered
                            },
                            //when you click Submit button
                            'ajaxRequestForm button[action=login]' : {
                                click : this.onLoginRequest   
                            }
                    });
            },

            onPanelRendered : function() {
                //just a console log to show when the panel is rendered
                console.log('The panel was rendered');
            },
           
            onLoginRequest : function(button) {
                //just a console log to show when the Login Ajax request starts
                console.log('Login Ajax Request in progress');
                
                var form = button.up('form').getForm();
                if(form.isValid()){
                   //create an AJAX request
                    Ext.Ajax.request({
                        url : '_01_account/chkAccount.controller',
                        method:'POST', 
                        params : {
                            loginData: Ext.encode(form.getValues())
                        },
                        scope : this,
                        //method to call when the request is successful
                        success : this.onLoginSuccess,
                        //method to call when the request is a failure
                        failure : this.onLoginFailure
                }); 
                }
            },
           
            onLoginFailure : function(err) {
                //Alert the user about communication error
                Ext.MessageBox.alert('Error occured during Login', 'Please try again!');
            },

            onLoginSuccess : function(response, opts) {
                //Received response from the server
            	data = Ext.decode(response.responseText);
                if(data.success){
                    location.href = "html/main/main.jsp";
                }
                else {
               	 	Ext.Msg.alert('Failed', '代碼:'+data.errors.clientCode +'<br>錯誤訊息:'+data.errors.portOfLoading);
                }
        }
    });