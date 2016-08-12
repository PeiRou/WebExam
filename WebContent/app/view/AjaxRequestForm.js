Ext.define('MyAjaxApp.view.AjaxRequestForm', {
    extend: 'Ext.form.Panel',
    alias : 'widget.ajaxRequestForm',
    frame: true,
    title: '登入',
    bodyPadding: '20 20 0',

    defaults: {
        anchor: '100%',
        allowBlank: false,
        msgTarget: 'side',
        labelWidth: 75
    },

    items: [{
        xtype: 'textfield',
        name: 'username',
        fieldLabel: '帳號'
    },{
        xtype: 'textfield',
        name: 'password',
        fieldLabel: '密碼',
        inputType: 'password',
    }],

    buttons: [{
        text: 'Submit',
        action: 'login'
    },
    {
        text: 'Reset Form',
        handler: function() {
            this.up('form').getForm().reset();
        }
    }]
});