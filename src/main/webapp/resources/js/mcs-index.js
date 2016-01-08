(function ($) {
    "use strict";
    $(document).ready(function () {
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
            var plot = $.plot($("#daily-visit-chart"), data, options);



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
            
            Morris.Line({
            	  element: 'morris-line',
            	  data: [
            	    { y: '2006', a: 100, b: 90 },
            	    { y: '2007', a: 75,  b: 65 },
            	    { y: '2008', a: 50,  b: 40 },
            	    { y: '2009', a: 75,  b: 65 },
            	    { y: '2010', a: 50,  b: 40 },
            	    { y: '2011', a: 75,  b: 65 },
            	    { y: '2012', a: 100, b: 90 }
            	  ],
            	  xkey: 'y',
            	  ykeys: ['a', 'b'],
            	  labels: ['Series A', 'Series B']
            	});

        }

        var myvalues = [250,200,459,234,600,800,345,987,675,457,765,100,50,0,49,-100,399,1000,250,200,459,234,600,800,345,987,675,457,765,100,50,0,49,-100,399,1000];
        $('.sparkline').sparkline(myvalues, {
        	type: 'line', 
        	resize: 'true', 
        	height: '100%', 
        	width: '100%', 
        	lineWidth: 1, 
        	minSpotColor: 'false',
        	maxSpotColor: 'false',
        	lineColor: '#C390D4',
        	spotColor: '#C390D4',
        	fillColor: '',
        	highlightLineColor: '#4694E8',
        	highlightSpotColor: '#e1b8ff',
        	spotRadius: 1,
        });
        
    });


})(jQuery);
