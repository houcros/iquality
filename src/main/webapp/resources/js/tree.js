var TreeView = function () {

    return {
        //main function to initiate the module
        init: function () {

            var DataSourceTree = function (options) {
                this._data  = options.data;
                this._delay = options.delay;
            };

// Funcion original para popular el arbol
//
//            DataSourceTree.prototype = {
//
//                data: function (options, callback) {
//                    var self = this;
//
//                    setTimeout(function () {
//                        var data = $.extend(true, [], self._data);
//
//                        callback({ data: data });
//
//                    }, this._delay)
//                }
//            };

            DataSourceTree.prototype = {
            		data: function (options, callback) {
            			callback({ data: options.data || this._data });
            		}
            	};
            
//            DataSourceTree.prototype = {
//
//                    data: function (options, callback) {
//
//                        setTimeout(function () {
//                        	
//                             callback({ data: options.data || this._data });
//                             
//                        }, this._delay)
//                   }
//            };
            
            // INITIALIZING TREE
            var treeDataSource = new DataSourceTree({
                data: [
                    { name: 'Dashboard', type: 'folder', additionalParameters: { id: 'F1' } },
                    { name: 'Elements', type: 'folder', additionalParameters: { id: 'F2' } },
                    { name: 'View Category', type: 'item', additionalParameters: { id: 'I1' } },
                    { name: 'Testing', type: 'item', additionalParameters: { id: 'I2' } }
                ],
                delay: 400
            });
            
            
            var treeDataSource2 = new DataSourceTree({
                data: [
                    { name: 'Secci&oacute;n Base <div class="tree-actions"></div>', type: 'folder', additionalParameters: { id: 'F-1' },
                    	data: [
                    	    { name: 'Modelo Contable <div class="tree-actions"></div>', type: 'folder', additionalParameters: { id: 'F-1.1' },
	                    	    data: [
	                           	    { name: 'Entidad Contable <div class="tree-actions"></div>', type: 'folder', additionalParameters: { id: 'F-1.1.1' },
			                    	    data: [
				                           	    { name: 'Dimensi&oacute;n Aplicaci&oacute;n Contable <div class="tree-actions"></div>', type: 'folder', additionalParameters: { id: 'F-1.1.1.1' },
						                    	    data: [
							                           	    { name: 'Aplicaci&oacute;n Contable <div class="tree-actions"></div>', type: 'folder', additionalParameters: { id: 'F-1.1.1.1.1' },
									                    	    data: [
										                           	    { name: '<i class="fa  fa-certificate "></i> Aplicaci&oacute;n Contable <div class="tree-actions"></div>', type: 'item', additionalParameters: { id: 'I-1.1.1.1.1.1' }},
										                           	]
							                           	    }
							                           	]
				                           	    }
				                           	]
	                           	    }
	                           	]
                    	    },
                    	    { name: 'Modelo de Cuadre de Contabilidad vs. Gesti&oacute;n <div class="tree-actions"></div>', type: 'folder', data: [], additionalParameters: { id: 'F-1.2' }},
                    	    { name: 'Modelo de Flujos y Curvas <div class="tree-actions"></div>', type: 'folder', data: [], additionalParameters: { id: 'F-1.3' }},
                    	    { name: 'Modelo de Gesti&oacute;n de Activos <div class="tree-actions"></div>', type: 'folder', data: [], additionalParameters: { id: 'F-1.4' }},
                    	    { name: 'Modelo de Gesti&oacute;n del Pasivo <div class="tree-actions"></div>', type: 'folder', data: [], additionalParameters: { id: 'F-1.5' }},
                    	]
                    },
                    { name: 'Secci&oacute;n de Motores de C&aacute;lculo <div class="tree-actions"></div>', type: 'folder', additionalParameters: { id: 'F11' } },
                    { name: 'Secci&oacute;n de Reporting <div class="tree-actions"></div>', type: 'folder', additionalParameters: { id: 'F12' } },
                    { name: '<i class="fa fa-bell-o"></i> Notification', type: 'item', additionalParameters: { id: 'I11' } },
                    { name: '<i class="fa fa-bar-chart-o"></i> Assignment', type: 'item', additionalParameters: { id: 'I12' } }
                ],
                delay: 400
            });

            var treeDataSource3 = new DataSourceTree({
                data: [
                    { name: 'Dashboard <div class="tree-actions"></div>', type: 'folder', additionalParameters: { id: 'F11' } },
                    { name: 'View Category <div class="tree-actions"></div>', type: 'folder', additionalParameters: { id: 'F12' } },
                    { name: 'Bucket Theme', type: 'item', additionalParameters: { id: 'I11' } },
                    { name: 'Modern Elements', type: 'item', additionalParameters: { id: 'I12' } }
                ],
                delay: 400
            });

            var treeDataSource4 = new DataSourceTree({
                data: [
                    { name: 'Dashboard<div class="tree-actions"><i class="fa fa-plus"></i><i class="fa fa-trash-o"></i><i class="fa fa-refresh"></i></div>', type: 'folder', additionalParameters: { id: 'F11' } },
                    { name: 'View Category<div class="tree-actions"><i class="fa fa-plus"></i><i class="fa fa-trash-o"></i><i class="fa fa-refresh"></i></div>', type: 'folder', additionalParameters: { id: 'F12' } },
                    { name: '<i class="fa fa-user"></i> User <div class="tree-actions"><i class="fa fa-plus"></i><i class="fa fa-trash-o"></i><i class="fa fa-refresh"></i></div><div class="tree-actions"><i class="fa fa-plus"></i><i class="fa fa-trash-o"></i><i class="fa fa-refresh"></i></div>', type: 'item', additionalParameters: { id: 'I11' } },
                    { name: '<i class="fa fa-calendar"></i> Events <div class="tree-actions"><i class="fa fa-plus"></i><i class="fa fa-trash-o"></i><i class="fa fa-refresh"></i></div>', type: 'item', additionalParameters: { id: 'I12' } },
                    { name: '<i class="fa  fa-gear "></i> Works <div class="tree-actions"><i class="fa fa-plus"></i><i class="fa fa-trash-o"></i><i class="fa fa-refresh"></i></div>', type: 'item', additionalParameters: { id: 'I12' } }
                ],
                delay: 400
            });

            
            var treeDataSource5 = new DataSourceTree({
                data: [
                    { name: 'Dashboard<div class="tree-actions"><i class="fa fa-plus"></i><i class="fa fa-trash-o"></i><i class="fa fa-refresh"></i></div>', type: 'folder', additionalParameters: { id: 'F11' } },
                    { name: 'View Category<div class="tree-actions"><i class="fa fa-plus"></i><i class="fa fa-trash-o"></i><i class="fa fa-refresh"></i></div>', type: 'folder', additionalParameters: { id: 'F12' } },
                    { name: '<i class="fa fa-user"></i> User <div class="tree-actions"><i class="fa fa-plus"></i><i class="fa fa-trash-o"></i><i class="fa fa-refresh"></i></div><div class="tree-actions"><i class="fa fa-plus"></i><i class="fa fa-trash-o"></i><i class="fa fa-refresh"></i></div>', type: 'item', additionalParameters: { id: 'I11' } },
                    { name: '<i class="fa fa-calendar"></i> Events <div class="tree-actions"><i class="fa fa-plus"></i><i class="fa fa-trash-o"></i><i class="fa fa-refresh"></i></div>', type: 'item', additionalParameters: { id: 'I12' } },
                    { name: '<i class="fa  fa-gear "></i> Works <div class="tree-actions"><i class="fa fa-plus"></i><i class="fa fa-trash-o"></i><i class="fa fa-refresh"></i></div>', type: 'item', additionalParameters: { id: 'I12' } }
                ],
                delay: 400
            });

            var treeDataSource6 = new DataSourceTree({
                data: [
                    { name: 'Dashboard<div class="tree-actions"><i class="fa fa-plus"></i><i class="fa fa-trash-o"></i><i class="fa fa-refresh"></i></div>', type: 'folder', additionalParameters: { id: 'F11' } },
                    { name: 'View Category<div class="tree-actions"><i class="fa fa-plus"></i><i class="fa fa-trash-o"></i><i class="fa fa-refresh"></i></div>', type: 'folder', additionalParameters: { id: 'F12' } },
                    { name: '<i class="fa fa-user"></i> User <div class="tree-actions"><i class="fa fa-plus"></i><i class="fa fa-trash-o"></i><i class="fa fa-refresh"></i></div><div class="tree-actions"><i class="fa fa-plus"></i><i class="fa fa-trash-o"></i><i class="fa fa-refresh"></i></div>', type: 'item', additionalParameters: { id: 'I11' } },
                    { name: '<i class="fa fa-calendar"></i> Events <div class="tree-actions"><i class="fa fa-plus"></i><i class="fa fa-trash-o"></i><i class="fa fa-refresh"></i></div>', type: 'item', additionalParameters: { id: 'I12' } },
                    { name: '<i class="fa  fa-gear "></i> Works <div class="tree-actions"><i class="fa fa-plus"></i><i class="fa fa-trash-o"></i><i class="fa fa-refresh"></i></div>', type: 'item', additionalParameters: { id: 'I12' } }
                ],
                delay: 400
            });

  /*          
            $('#FlatTree1').tree({
//            	dataSource: treeDataSource2,
            	dataSource: treeDataSourceDictionary,
                loadingHTML: '<img src="resources/images/input-spinner.gif"/>',
            });
           */

//            $('#FlatTree2').tree({
//                selectable: false,
//                dataSource: treeDataSource4,
//                loadingHTML: '<img src="resources/images/input-spinner.gif"/>',
//            });

            
//          var treeDataSourceDictWithAjax = null
            
            $.ajax({
        		  url: "api/jsonTree",
//        		  async: false,
        		  success: function( data ) {
                  $('#FlatTree1').tree({
                      dataSource: new DataSourceTree(data),
                      loadingHTML: '<img src="resources/images/input-spinner.gif"/>',
                  });
        		  }
              });
        }

    };

}();