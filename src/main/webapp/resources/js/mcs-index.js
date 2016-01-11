var morrisLine;
(function ($) {
    "use strict";
    $(document).ready(function () {
    	
    	var dataArrayY = ['2015-05', '2015-06', '2015-07', '2015-08', '2015-09', '2015-10', '2015-11'];
    	var dataArrayDimA = [45, 33, 67, 58, 68, 78, 89];
    	var dataArrayDimB = [90, 65, 40, 65, 40, 65, 90];
    	var dataArrayDimC = [45, 78, 23, 66, 84, 94, 89];
    	var dataArrayDimD = [78, 90, 80, 56, 65, 87, 98];
    	var dataArrayDimE = [34, 56, 54, 45, 76, 64, 77];
    	// Init array de datos
    	var morrisLineDataArray = new Array(dataArrayY.length);
    	console.log(morrisLineDataArray.length);
    	for (var i = 0; i < dataArrayY.length; ++i){
    		var item = {};
    		item.y = dataArrayY[i];
    		item.dimA = dataArrayDimA[i];
    		item.dimB = dataArrayDimB[i];
    		item.dimC = dataArrayDimC[i];
    		item.dimD = dataArrayDimD[i];
    		item.dimE = dataArrayDimE[i];
    		morrisLineDataArray[i] = item;
    	}
    	// Init array de opciones
    	var morrisLineOptions = {
    			element: 'morris-line',
    			data: morrisLineDataArray,
    			xLabelFormat: function(x){
    				var indexToMonth = ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'];
    				var month = indexToMonth[x.getMonth()];
    				var year = x.getFullYear();
    				return month + ' ' + year;
    			},
    			dateFormat: function(x){
    				var indexToMonth = ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'];
    				var month = indexToMonth[new Date(x).getMonth()];
    				var year = new Date(x).getFullYear();
    				return month + ' ' + year;
    			},
    			xkey: 'y',
    			ykeys: ['dimA', 'dimB', 'dimC', 'dimD', 'dimE'],
    			labels: ['Integridad', 'Completitud', 'Duplicidad', 'Conformidad', 'Precisi&oacute;n']
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

        // Los toggles que sacan y ponen una tabla del plot
        $('#toggle-2').change(function() {
        	if($(this).prop('checked')){
        		console.log('reinsertando un graph');
        		// Añado las b's de los datos
        		// OJO: pueden sobrar b's que no inserto!
        		// OJO: estoy pusheando, last puede no ser la posición correcta
        		var data = morrisLineDataArray;
        		for (var i = 0; i < morrisLineDataArray.length; ++i){
        			data[i].dimD = dataArrayDimB[i];
        		}
        		console.log(data);
        		// Añado ykey
        		morrisLine.options.ykeys.push('dimB');
        		console.log(morrisLine.options.ykeys);
        		// Añado label
        		morrisLine.options.labels.push('Completitud');
        		console.log(morrisLine.options.labels);
        		// Actualizo datos
        		morrisLine.setData(data);
        	}
        	else{
        		console.log('eliminando un graph');
        		// Saco las b's de los datos
        		var data = morrisLineDataArray;
        		data.forEach(function(entry){
        			delete entry.b;
        		});
        		// Saco ykey
        		var indexYKeys = morrisLine.options.ykeys.indexOf('dimB');
        		if (indexYKeys > -1) morrisLine.options.ykeys.splice(indexYKeys, 1);
        		// Saco label
        		var indexLabels = morrisLine.options.labels.indexOf('Completitud');
        		if (indexLabels > -1) morrisLine.options.labels.splice(indexYKeys, 1);
        		// Actualizo datos
        		morrisLine.setData(data);
        	}
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
        
    });


})(jQuery);
