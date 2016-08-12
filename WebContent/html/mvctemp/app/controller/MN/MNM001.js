// app.controller.MN.MNM001.js
/**
 * 功能群組維護
 */
Ext.define('Frontend.controller.MN.MNM001', {
	extend : 'Frontend.controller.common.Standard',
	views : [ 'MN.MNM001.Panel' ],

	refs : [ {
		ref : 'deleteButton',
		selector : 'mnm001panel commonbuttondelete'
	}, {
		ref : 'gridPanel',
		selector : 'mnm001panel'
	}, {
		ref : 'combobox',
		selector : 'mnm001combobox'
	} ],
	init : function() {

		定義各個元件所要執行的事件以及相關的函數
		this.control({
			'mnm001panel commonbuttoncreate' : {
				click : this.doCreate
			},
			'mnm001panel commonbuttondelete' : {
				click : this.doDelete
			},
			'mnm001panel commonbuttonupdate' : {
				click : this.doUpdate
			},
			'mnm001panel commonbuttonread' : {
				click : this.doRead
			},
			'mnm001combobox' : {
				select : this.comboboxSelect
			},
			'mnm001panel' : {
				selectionchange : this.onGridSelection,
				render : this.onPanelRendered
			}
		})
		// ref 的使用對象為 Conpoment
		// store 的取得直接用 this
		// 在 view 所組成的 compoment 中有使用到的 store 皆可以在 controllr 中存取

		this.store = this.getStore("MN.MNM001.Store");

	},
	execute : function(params) {
		// 定義此 contoller 所使用之屬性，controller 一旦被執行此事件將會最先被執行
		params.tabXtype = 'mnm001panel';
		// 結果將透過下列程式呼叫繼承來的 controller 之 execute
		this.callParent(arguments);
	},
	comboboxSelect : function(combo, records, eOpts) {
		this.selections[0].set('userGroupDes', records[0].get('description'));
	}
});