var morrisLine;
(function ($) {
    "use strict";
    $(document).ready(function () {
    	
    	/* ###### Morris Line ###### */
    	
    	// Hipótesis: dataArrayX.length == ejesYDict.dim_k.data.length, para todo k
    	// Eje x
    	var dataArrayX = ['2015-05', '2015-06', '2015-07', '2015-08', '2015-09', '2015-10', '2015-11'];
    	// Diccionario con los datos de los ejes y
    	var ejesYDict = {
    			'dimA': {
    				'data': [45, 33, 67, 58, 68, 78, 89],
    				'label': 'Integridad',
    				'color': '#FEA352'
    			},
    			'dimB': {
    				'data': [90, 65, 40, 65, 40, 65, 54],
    				'label': 'Completitud',
    				'color': '#FE0600'
    			},
    			'dimC': {
    				'data': [45, 78, 23, 66, 84, 94, 80],
    				'label': 'Duplicidad',
    				'color': '#4A0BAD'
    			},
    			'dimD': {
    				'data': [78, 90, 80, 56, 65, 87, 98],
    				'label': 'Conformidad',
    				'color': '#34D700'
    			},
    			'dimE': {
    				'data': [34, 56, 54, 45, 76, 64, 77],
    				'label': 'Precisi&oacute;n',
    				'color': '#FEF400'
    			}
    	}
    	
    	// Init array de datos
    	var morrisLineDataArray = new Array(dataArrayX.length);
    	for (var i = 0; i < dataArrayX.length; ++i){
    		var item = {};
    		item.mes = dataArrayX[i];
    		for (var key in ejesYDict){
    			item[key] = ejesYDict[key].data[i];
    		}
    		morrisLineDataArray[i] = item;
    	}
    	// Init array de yKeys
    	var yKeysArray = [];
    	for (var key in ejesYDict){
    		yKeysArray.push(key);
		}
    	// Init array de labels
    	var labelsArray = [];
    	for (var key in ejesYDict){
    		labelsArray.push(ejesYDict[key].label);
		}
    	// Init array de colores
    	var colorsArray = [];
    	for (var key in ejesYDict){
    		colorsArray.push(ejesYDict[key].color);
		}
    	
    	// Init array de opciones
    	var morrisLineOptions = {
    			element: 'morris-line',
    			data: morrisLineDataArray,
    			resize: true,
    			xLabelFormat: function(x){
    				var indexToMonth = ['Enero', 'Febr.', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Sept.', 'Oct.', 'Nov.', 'Dic.'];;
    				var month = indexToMonth[x.getMonth()];
    				var year = x.getFullYear();
    				return month + ' ' + year;
    			},
    			dateFormat: function(x){
    				var indexToMonth = ['Enero', 'Febr.', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Sept.', 'Oct.', 'Nov.', 'Dic.'];
    				var month = indexToMonth[new Date(x).getMonth()];
    				var year = new Date(x).getFullYear();
    				return month + ' ' + year;
    			},
    			xkey: 'mes',
    			ykeys: yKeysArray,
    			labels: labelsArray,
    			lineColors: colorsArray 
    	}
    	
        if ($.fn.plot) {

            var d1 = [
                [0, 10],
                [1, 20],
                [2, 33],
                [3, 24],
                [4, 45],
                [5, 96],
                [6, 47],
                [7, 18],
                [8, 11],
                [9, 13],
                [10, 21]

            ];
            var data = ([{
                label: "Too",
                data: d1,
                lines: {
                    show: true,
                    fill: true,
                    lineWidth: 2,
                    fillColor: {
                        colors: ["rgba(255,255,255,.1)", "rgba(160,220,220,.8)"]
                    }
                }
            }]);
            var options = {
                grid: {
                    backgroundColor: {
                        colors: ["#fff", "#fff"]
                    },
                    borderWidth: 0,
                    borderColor: "#f0f0f0",
                    margin: 0,
                    minBorderMargin: 0,
                    labelMargin: 20,
                    hoverable: true,
                    clickable: true
                },
                // Tooltip
                tooltip: true,
                tooltipOpts: {
                    content: "%s X: %x Y: %y",
                    shifts: {
                        x: -60,
                        y: 25
                    },
                    defaultTheme: false
                },

                legend: {
                    labelBoxBorderColor: "#ccc",
                    show: false,
                    noColumns: 0
                },
                series: {
                    stack: true,
                    shadowSize: 0,
                    highlightColor: 'rgba(30,120,120,.5)'

                },
                xaxis: {
                    tickLength: 0,
                    tickDecimals: 0,
                    show: true,
                    min: 2,

                    font: {

                        style: "normal",


                        color: "#666666"
                    }
                },
                yaxis: {
                    ticks: 3,
                    tickDecimals: 0,
                    show: true,
                    tickColor: "#f0f0f0",
                    font: {

                        style: "normal",


                        color: "#666666"
                    }
                },
                //        lines: {
                //            show: true,
                //            fill: true
                //
                //        },
                points: {
                    show: true,
                    radius: 2,
                    symbol: "circle"
                },
                colors: ["#87cfcb", "#48a9a7"]
            };
//            var plot = $.plot($("#daily-visit-chart"), data, options);



            // DONUT
            var dataPie = [{
                label: "Wait",
                data: 24
            }, {
                label: "OK",
                data: 50
            }, {
                label: "KO",
                data: 12
            }];

            $.plot($(".sm-pie"), dataPie, {
                series: {
                    pie: {
                        innerRadius: 0.7,
                        show: true,
                        stroke: {
                            width: 0.1,
                            color: '#ffffff'
                        }
                    }

                },

                legend: {
                    show: true
                },
                grid: {
                    hoverable: true,
                    clickable: true
                },

                colors: ["#ffdf7c", "#b2def7", "#efb3e6"]
            });

        }


        if (Morris.EventEmitter) {
        	/*
            // Use Morris.Area instead of Morris.Line
            Morris.Area({
                element: 'graph-area',
                padding: 10,
                behaveLikeLine: true,
                gridEnabled: false,
                gridLineColor: '#dddddd',
                axes: true,
                fillOpacity: .7,
                data: [{
                    period: '2012-02-24',
                    iphone: 1000,
                    ipad: 10,
                    itouch: 10
                }, {
                    period: '2012-02-25',
                    iphone: 1778,
                    ipad: 7294,
                    itouch: 18441
                }, {
                    period: '2012-02-26',
                    iphone: 4912,
                    ipad: 12969,
                    itouch: 3501
                }, {
                    period: '2012-02-27',
                    iphone: 3767,
                    ipad: 3597,
                    itouch: 5689
                }, {
                    period: '2012-02-28',
                    iphone: 6810,
                    ipad: 1914,
                    itouch: 2293
                }, {
                    period: '2012-03-01',
                    iphone: 5670,
                    ipad: 4293,
                    itouch: 1881
                }, {
                    period: '2012-03-02',
                    iphone: 4820,
                    ipad: 3795,
                    itouch: 1588
                }, {
                    period: '2012-03-03',
                    iphone: 10073,
                    ipad: 5967,
                    itouch: 5175
                }, {
                    period: '2012-03-04',
                    
                    iphone: 10687,
                    ipad: 34460,
                    itouch: 22028
                }, {
                    period: '2012-03-05',
                    iphone: 1000,
                    ipad: 5713,
                    itouch: 1791
                }


                ],
                lineColors: ['#ED5D5D', '#D6D23A', '#32D2C9'],
                xkey: 'period',
                ykeys: ['iphone', 'ipad', 'itouch'],
                labels: ['Cert. 1', 'Cert. 2', 'Cert. 3'],
                pointSize: 0,
                lineWidth: 0,
                hideHover: 'auto'
        	
            });
            */
        	
            morrisLine = Morris.Line(morrisLineOptions);

        }

        // Callback para mostrar un parámetro de calidad
        $('.my-checkbox-dim').on('ifChecked', function(event) {
        		console.log('reinsertando un graph');
        		// Obtengo el valor de la dimension
        		var dim = $(this).attr('id').split('-')[1];
        		console.log('dim: ' + dim);
        		// Añado las b's de los datos
        		// OJO: pueden sobrar b's que no inserto!
        		// OJO: estoy pusheando, last puede no ser la posición correcta
        		var newData = morrisLineDataArray;
        		for (var i = 0; i < morrisLineDataArray.length; ++i){
        			newData[i][dim] = ejesYDict[dim].data[i];
        		}
        		console.log(newData);
        		// Nota: arr.splice(index, 0, item); will insert item into arr at the specified index.
        		// Añado ykey en la posición correspondiente
        		morrisLine.options.ykeys.splice(1, 0, dim);
        		console.log(morrisLine.options.ykeys);
        		// Añado label en la posición correspondiente
        		morrisLine.options.labels.splice(1, 0, ejesYDict[dim].label);
        		console.log(morrisLine.options.labels);
        		// Añado color en la posición correspondiente
        		morrisLine.options.lineColors.splice(1, 0, ejesYDict[dim].color);
        		console.log(morrisLine.options.lineColors);
        		// Actualizo datos
        		morrisLine.setData(newData);
        });
        
        // Callback para ocultar un parámetro de calidad
        $('.my-checkbox-dim').on('ifUnchecked', function(event) {
        		console.log('eliminando un graph');
        		// Obtengo el valor de la dimension
        		var dim = $(this).attr('id').split('-')[1];
        		console.log('dim: ' + dim);
        		// Saco las b's de los datos
        		var newData = morrisLineDataArray;
        		newData.forEach(function(entry){
        			delete entry[dim];
        		});
        		// Saco ykey
        		var indexYKeys = morrisLine.options.ykeys.indexOf(dim);
        		if (indexYKeys > -1) morrisLine.options.ykeys.splice(indexYKeys, 1);
        		// Saco label
        		var indexLabels = morrisLine.options.labels.indexOf(ejesYDict[dim].label);
        		if (indexLabels > -1) morrisLine.options.labels.splice(indexYKeys, 1);
        		// Saco color
        		var indexColor = morrisLine.options.lineColors.indexOf(ejesYDict[dim].color);
        		if (indexColor > -1) morrisLine.options.lineColors.splice(indexYKeys, 1);
        		// Actualizo datos
        		morrisLine.setData(newData);
        });
        
        
        // Sparkline
        var myvalues = [50,70,54,234,600,234,345,789,576,754,567];
        $('.sparkline').sparkline(myvalues, {
        	type: 'line', 
        	resize: 'true', 
        	height: 'auto', 
        	width: '100%', 
        	lineWidth: 1,
        	minSpotColor: 'false',
        	maxSpotColor: 'false',
        	lineColor: 'blue',
        	spotColor: 'blue',
        	spotRadius: 2,
        	fillColor: '',
        	highlightLineColor: '#4694E8',
        	highlightSpotColor: '#e1b8ff',
        	spotRadius: 1,
        });
        
        // Init knobs
        $("#dial-dimA").knob({
        	'width': 90,
        	'fgColor': '#FEA352',
        	'skin': 'tron',
        	'thickness': '.3',
        	'readOnly': true,
        	'height': '90'
        });
        $("#dial-dimB").knob({
        	'width': 90,
        	'fgColor': '#FE0600',
        	'skin': 'tron',
        	'thickness': '.3',
        	'readOnly': true,
        	'height': '90'
        });
        $("#dial-dimC").knob({
        	'width': 90,
        	'fgColor': '#4A0BAD',
        	'skin': 'tron',
        	'thickness': '.3',
        	'readOnly': true,
        	'height': '90'
        });
        $("#dial-dimD").knob({
        	'width': 90,
        	'fgColor': '#34D700',
        	'skin': 'tron',
        	'thickness': '.3',
        	'readOnly': true,
        	'height': '90'
        });
        $("#dial-dimE").knob({
        	'width': 90,
        	'fgColor': '#FEF400',
        	'skin': 'tron',
        	'thickness': '.3',
        	'readOnly': true,
        	'height': '90'
        });
        
        
        
        $('.random-change').click(function(){
        	$(".dial").each(function(index, element){
        		$(element).val(Math.floor(Math.random() * 50) + 50).trigger('change');
        	});
        });
        
    });
})(jQuery);
