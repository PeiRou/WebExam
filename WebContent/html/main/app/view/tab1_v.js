Ext.define('Main.view.tab1_v', {
	extend	:	'Ext.grid.Panel',
    alias	:	'widget.tab1',
    store	:	'tab1_s',
    columns	:	[
					{header: 'Active', dataIndex: 'active', flex: 1  },           
					{header: 'Customer Id',  dataIndex: 'customerId',  flex: 1},
					{header: 'First Name',  dataIndex: 'aa',  flex: 1},
					{header: 'Last Name',  dataIndex: 'lastName',  flex: 1},
					{header: 'OS',  dataIndex: 'os',  flex: 1}
    ],
    tbar	:	[
				{   
					text		: 	'投注',
					style: { 
						border: 'solid 1px none',
					    padding: '10px'
					},
					itemId		:	'ds_add',
					icon		:	'icon/favicon.png'
				},
    ],
 	initComponent : function() {
 	    this.callParent(arguments);
 	}
});