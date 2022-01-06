
    var randomList = [
     	[0.3, 0.27, 0.31, 0.32, 0.26, 0.33, 0.34],
        [0.29, 0.28, 0.27, 0.27, 0.34, 0.3,0.3],
        [0.25, 0.3, 0.29, 0.28, 0.26, 0.33,0.34],
        [0.24, 0.25, 0.28, 0.29, 0.31, 0.32,0.33],
        [0.33, 0.31, 0.3, 0.34, 0.34, 0.31,0.27],
        [0.34, 0.31, 0.29, 0.28, 0.27, 0.3,0.29]
      ];
    console.log(randomList);




let Index = {
    init() {
        this.charts = {};
        this.loadData();
        Public.chartsResize(this.charts);
//        Public.chartsReDraw(this.charts, null, [
//            'ec01_line_tiobe', 'ec06_pie_findSong'
//        ], [
//            'ec03_barV_timeDistribute', 'ec05_lineBar_timeDistribute', 'ec06_pie_findSong'
//        ])
    },
    loadData() {
        this.ec01_line_tiobe();//
        this.ec02_area_accessSource();//
        this.ec03_barV_timeDistribute();//
        this.ec04_pie_computerBroken();//
        this.ec05_lineBar_timeDistribute();//
        this.ec06_pie_findSong();//
    },
    ec01_line_tiobe() {
        let chart = echarts.init($("#ec01_line_tiobe")[0]); //初始化图表，注意命名的规范合理
        this.charts.ec01_line_tiobe = chart; //放入charts对象方便后面的刷新缩放以及其他操作
        var random=Math.ceil(Math.random()*6-1);
        console.log(random);
        chart.setOption(opt_line); // 设置这个类型（折线图）图表的共性
        chart.setOption({
            xAxis: { // 本图表option的个性
                nameLocation: 'start',
                inverse: true,
                data: ['0', '5', '10', '15', '20', '30', '40']
            },
            yAxis: { // 本图表option的个性
                name: '数据',
                nameLocation: 'start',
                min: 0.2,
                inverse: true
            },
            dataZoom: { // 本图表option的个性
                type: 'inside',
                orient: 'vertical'
            },
            series: [
                {"name": "ap1", data: randomList[random]},
                {"name": "ap2", data: randomList[random+1]},
                {"name": "ap3", data: randomList[random+2]},
                {"name": "ap4", data: randomList[random+3]},
                {"name": "ap5", data: randomList[random+4]},
                {"name": "ap6", data: randomList[random+5]},
                {"name": "ap7", data: randomList[random+6]},
                {"name": "ap8", data: randomList[random+7]},
                {"name": "ap9", data: randomList[random+8]},
                {"name": "ap10", data: randomList[random+9]},
//                {"name": "Visual Basic .NET", data: [5, 10, '-', '-', '-', '-', 0]},
//                {"name": "C#", data: [6, 5, 6, 7, 23, '-', 0]},
//                {"name": "JavaScript", data: [7, 8, 8, 8, 17, '-', 0]},
//                {"name": "PHP", data: [8, 6, 4, 5, '-', '-', 0]},
//                {"name": "SQL", data: [9, '-', '-', 6, '-', '-', 0]},
//                {"name": "Objective-C", data: [10, 3, 36, 44, '-', '-', 0]},
                // {"name": "COBOL", data: [25, 20, 16, 11, 3, 9, 12]},
                // {"name": "Lisp", data: [29, 13, 19, 14, 14, 5, 2]},
                // {"name": "Pascal", data: [207, 14, 14, 96, 6, 3, 17]}
            ].map(item => {
                return $.extend(true, {}, seri_line,// 折线图图表series的共性
                    { // 本图表series的个性
                        symbol:'circle',
                        smooth: false,
                        showSymbol: false,
                    }, item)
            })
        })
    },
   
    ec02_area_accessSource() {
        let chart = echarts.init($("#ec02_area_accessSource")[0]);
        this.charts.ec02_area_accessSource = chart;
        var random=Math.ceil(Math.random()*6-1);
        console.log("random:"+random)
        chart.setOption(opt_line);
        chart.setOption({
            xAxis: {
                data: ['周日', '周一', '周二', '周三', '周四', '周五', '周六']
            },
            yAxis: {
                name: '数量/次',
            },
            series: [{
                name: '员工1',
                data: [10, 11, 12, 14, 9, 12, 11]
            }, {
                name: '员工2',
                data: [14, 10, 15, 17, 12, 19, 12]
            }, {
                name: '员工3',
                data: [12, 13, 18, 18, 11, 14, 16]
            }, {
                name: '员工4',
                data: [13, 14, 16, 15, 12, 14, 18]
            }, /*{
                name: '员工5',
                data: [820, 932, 901, 934, 1290, 1330, 1320]
            }*/].map(item => {
                return $.extend(true, {}, seri_area, {
                    symbol: 'circle',
                }, item)
            })
        });
    },
    ec03_barV_timeDistribute() {
        let chart = echarts.init($("#ec03_barV_timeDistribute")[0]);
        this.charts.ec03_barV_timeDistribute = chart;
        chart.setOption(opt_bar_v);
        chart.setOption({
            xAxis: {
                data: ['周日', '周一', '周二', '周三', '周四', '周五', '周六']
            },
            yAxis: {
                name: '时间/小时',
            },
            series: [
                {"name": "一级预警", data: [1, 1, 1, 1, 1, 1, 1]},
                {"name": "二级预警", data: [1.5, 2, 0, 0, 0, 0, 0]},
                {"name": "三级预警", data: [0, 0, 0, 0, 0, 0, 5]},
                {"name": "正常", data:    [21.5, 21, 23, 23, 23, 23, 18]},
              /*  {"name": "关闭状态", data: [10, 6, 6, 5.5, 6, 6.5, 3.5]},*/
            ].map(item => {
                return $.extend(true, {}, seri_bar_v, item, {stack: '总时间'})
            })
        })
    },
    ec04_pie_computerBroken() {
        let chart = echarts.init($("#ec04_pie_computerBroken")[0]);
        this.charts.ec04_pie_computerBroken = chart;
        chart.setOption(opt_pie);
        chart.setOption({
            roseType: 'radius',
            series: [
                {
                    name: "结构不合格",
                    data: [{
                        value: 3,
                        name: '混凝土稀疏'
                    },{
                        value: 2,
                        name: '钢筋弯折'
                    }, {
                        value: 4,
                        name: '自然缝隙'
                    }, {
                        value: 1,
                        name: '重大问题'
                    } ]
                },
            ].map(item => {
                return $.extend(true, {}, seri_circle, item)
            })
        })
    },
    ec05_lineBar_timeDistribute() {
        let chart = echarts.init($("#ec05_lineBar_timeDistribute")[0]);
        this.charts.ec05_lineBar_timeDistribute = chart;
        chart.setOption(opt_line);
        chart.setOption({
            legend: {
                data: ["一级预警", "二级预警", "三级预警", "正常", ]
            },
            tooltip: {
                formatter: function (param) {
                    return param.map(item => {
                        if (item.seriesName === '补位') {
                            return ''
                        } else {
                            return `${item.seriesName}: ${item.value}<br>`
                        }
                    }).join("").replace(',', '')

                }
            },
            xAxis: {
                boundaryGap: true,
                data: ['周日', '周一', '周二', '周三', '周四', '周五', '周六']
            },
            yAxis: {
                name: '次数/天',
            },
            series: [
                {
                    name: '一级预警',
                    data: [1, 1, 1, 1, 1, 1, 1]
                }/*, {
                    name: '一级预警',
                    silent: true,
                    itemStyle: {
                        color: c_bg_bar,
                    },
                    barGap: '-100%',
                    data: new Array(7).fill(3)
                }*/
            ].map(item => {
                return $.extend(true, {}, seri_bar_v, item)
            }).concat([
                {"name": "二级预警", data: [1, 1, 0, 0, 0, 0, 0]},
                {"name": "三级预警", data: [0, 0, 0, 0, 0, 0, 1]},
               /* {"name": "正常", data: [0, 8, 8, 8, 8, 7.5, 8]},*/
/*                {"name": "关闭状态", data: [10, 6, 6, 5.5, 7, 7, 3.5]}, '关闭状态',*/
            ].map(item => {
                return $.extend(true, {}, seri_line, {
                    symbol: 'emptyCircle'
                }, item)
            }))
        })
    },
    ec06_pie_findSong() {
        let chart = echarts.init($("#ec06_pie_findSong")[0]);
        this.charts.ec06_pie_findSong = chart;
        chart.setOption(opt_pie);
        chart.setOption({
            roseType: 'radius',
            visualMap: {
                show: false,
                min: 0,
                max: 100,
                inRange: {
                    colorLightness: [0.3, 1.2]
                }
            },

            series: [
                {
                    name: "",
                    itemStyle: {
                        normal: {
                            color: colors[0],
                            shadowBlur: 100 * scale,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    },
                    data: [{
                        value: 3,
                        name: '重新浇筑'
                    }, {
                        value: 2,
                        name: '混凝土固定'
                    }, {
                        value: 2,
                        name: '支架固定'
                    },/* {
                        value: 10,
                        name: '填充物'
                    }*/, {
                        value: 1,
                        name: '重建'
                    }].sort(function (a, b) {
                        return a.value - b.value;
                    }),
                },
            ].map(item => {
                return $.extend(true, {}, seri_pie, item)
            })
        })
    }
};

Index.init();
//setInterval(function(){
//	$.ajax({
//		url:"../TableServlet",
//		type:"POST",
//		dataType:"text",
//		data:{
//			
//		},
//		success:function(data){
//			alert(data);
//		}
//	})
//},1000);
//$.ajax({
//	url:"../TableServlet",
//	type:"POST",
//	dataType:"text",
//	data:{
//		
//	},
//	success:function(data){
//		alert(data);
//	}
//})

//$.ajax({
//	url:"../TableServlet",
//	type:"POST",
//	dataType:"json",
//	data:{},
//	success:function(data){
////		var $data = $(data);
////	alert(data[0].serial);
//		if(data[0].data=="正常"){
//			}
//		else{
//			alert(data[0].data+'\n'+data[0].serial+'号节点异常');
//			}
//	}
//})

//setTimeout('myrefresh()',1000);
setInterval(  //设置定时器，1s更新一次
		function(){
			Index.init();
			
		},500000
	);


