<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="m" uri="/morinda-tags" %>
<!DOCTYPE HTML>
<html>
<head>
    <title><spring:message code="sys.tital"/></title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <%-- 在IE运行最新的渲染模式 --%>
    <meta http-equiv=X-UA-Compatible content="IE=edge,chrome=1">
    <%-- 初始化移动浏览显示 --%>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="keywords" content=""/>
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);
    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <!-- Bootstrap Core CSS -->
    <link href="/static/css/bootstrap/bootstrap.css" rel='stylesheet' type='text/css'/>
    <!-- Custom CSS -->
    <link href="/static/css/custom/style.css" rel='stylesheet' type='text/css'/>
    <link href="../static/css/page/page.css" rel='stylesheet' type='text/css'/>
    <!-- font CSS -->
    <!-- font-awesome icons -->
    <link href="/static/css/font-awesome.css" rel="stylesheet">
    <!-- //font-awesome icons -->
    <link href="/static/css/animate.css" rel="stylesheet" type="text/css" media="all">

    <link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/font-awesome.4.6.0.css">
    <link rel="stylesheet" href="/static/css/jquery/animsition.min.css"/>
    <link rel="stylesheet" href="/static/css/jquery/drop-down.css"/>
    <link rel="stylesheet" href="/static/css/jquery/common.css"/>
    <link rel="stylesheet" href="/static/css/jquery/system.css"/>
    <!-- js-->
    <script src="/static/js/jquery/jquery-1.11.1.min.js"></script>
    <script src="/static/js/modernizr.custom.js"></script>
    <script src="/static/js/wow.min.js"></script>
    <script>
        new WOW().init();
    </script>
    <script src="/static/js/metisMenu.min.js"></script>
    <script>
        $(function () {
            $('#menu').metisMenu();
        });
    </script>
    <script src="/static/js/custom.js"></script>
    <script src="/static/js/showRight.js"></script>
</head>

<body class="cbp-spmenu-push">
<div class="main-content">
    <div class='sidebar' role='navigation'>
        <div class='navbar-collapse'>
            <jsp:include page="../main/nav.jsp"></jsp:include>
            <jsp:include page="../main/header.jsp"></jsp:include>
            <!-- main content start-->
            <div id="page-wrapper" style="min-height: 453px;">
                <div class="main-page">
                    <div id="content">
                        <div class="data_wrap"
                             style="background: #efeff5; width: 1040px; padding: 10px; overflow: hidden;">
                            <div class="animsition">
                                <div style="background: white; solid #efeff5; width: 1020px; overflow: hidden;">
                                    <%--<p id="my_date_set1">日期</p>--%>
                                    <%--<p id="my_date_set2">日期</p>--%>
                                    <div id="main"
                                         style="height:350px; width: 1020px;clear: both; border-top: 10px solid #efeff5;"></div>
                                    <%--<div id="main2" style="height:350px; width: 320px; float: left;"></div>--%>
                                    <div id="main3"
                                         style="height:350px; width: 1020px; clear: both; border-top: 10px solid #efeff5;"></div>
                                    <%--<div id="main4"--%>
                                    <%--style="height:350px; width: 700px; float: left; border-top: 10px solid #efeff5;"></div>--%>
                                    <div id="main5"
                                         style="height:350px; width: 1020px; float: left;border-top: 10px solid #efeff5;"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<!-- main content end-->
<%@ include file="../main/foolter.jsp" %>
<script src="http://www.jq22.com/jquery/jquery-ui-1.11.0.js"></script>
<script src="/static/js/jquery/select-widget-min.js"></script>
<script src="/static/js/jquery/jquery.animsition.min.js"></script>
<script src="https://cdn.bootcss.com/echarts/3.5.3/echarts.min.js"></script>
<script src="/static/js/jquery/macarons .js"></script>
<script src="/static/js/jquery/common.js"></script>
<script>
    $(document).ready(function () {
        //初始化切换
        $(".animsition").animsition({

            inClass: 'fade-in-right',
            outClass: 'fade-out',
            inDuration: 1500,
            outDuration: 800,
            linkElement: '.animsition-link',
            // e.g. linkElement   :   'a:not([target="_blank"]):not([href^=#])'
            loading: true,
            loadingParentElement: 'body', //animsition wrapper element
            loadingClass: 'animsition-loading',
            unSupportCss: ['animation-duration',
                '-webkit-animation-duration',
                '-o-animation-duration'
            ],
            //"unSupportCss" option allows you to disable the "animsition" in case the css property in the array is not supported by your browser.
            //The default setting is to disable the "animsition" in a browser that does not support "animation-duration".

            overlay: false,

            overlayClass: 'animsition-overlay-slide',
            overlayParentElement: 'body'
        });

        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'), 'macarons');
//        var myChart2 = echarts.init(document.getElementById('main2'),'macarons');
        var myChart3 = echarts.init(document.getElementById('main3'), 'macarons');
//        var myChart4 = echarts.init(document.getElementById('main4'),'macarons');
        var myChart5 = echarts.init(document.getElementById('main5'), 'macarons');
        // 指定图表的配置项和数据
//        var date = ['2018/1/1','2018/1/2','2018/1/3','2018/1/4','2018/1/5','2018/1/6','2018/1/7','2018/1/8','2018/1/9','2018/1/10',
//            '2018/1/11','2018/1/12','2018/1/13','2018/1/14','2018/1/15','2018/1/16','2018/1/17','2018/1/18'
//            ,'2018/1/19','2018/1/20','2018/1/21','2018/1/22','2018/1/23','2018/1/24','2018/1/25','2018/1/26','2018/1/27'
//            ,'2018/1/28','2018/1/29','2018/1/30','2018/1/31'];
        var date = ['2017-01', '2017-02', '2017-03', '2017-04', '2017-05', '2017-06', '2017-07', '2017-08', '2017-09', '2017-10', '2017-11', '2017-12', '2018-01'];
        var sf_data = [
            {name: '空气温度', value: Math.round(Math.random() * 10)},
            {name: '空气湿度', value: Math.round(Math.random() * 10)},
            {name: '光照', value: Math.round(Math.random() * 10)},
            {name: '土壤温度', value: Math.round(Math.random() * 10)},
            {name: 'CO2浓度', value: Math.round(Math.random() * 10)},
            {name: '土壤水分', value: Math.round(Math.random() * 10)},
        ];
        var wendu = [7, 8, 7, 8, 7, 7, 8, 8, 10, 12, 15, 20, 22, 25, 23, 20, 18, 16, 14, 13, 12, 10, 9, 8, 7];
var shidu=[];
        function my_data() {
            var data = [];
            for (var i = 0; i < 31; i++) {
                data.push(Math.round(Math.random() * (5 - 1) + 1));
            }
            ;
            return data;
        }

        function yield_data() {
            var data = [];
            for (var i = 0; i < 31; i++) {
                data.push(Math.round(Math.random() * (5000 - 1000) + 1000));
            }
            ;
            return data;
        }


        var option = {
            title: {
                text: '月产量',
                /*subtext: '昨日新增：',
                 subtextStyle: {
                 fontSize:14,
                 color : '#ff4a84'
                 }*/
            },
            tooltip: {
                trigger: 'axis',
                /*formatter: function(data){
                 //console.log(data)
                 myChart.setOption({
                 title : {
                 text: '会员数量' + data.value,
                 }
                 });

                 return data.name + '</br>' + '新增数：' + data.value + '</br>';
                 }*/

            },
            legend: {
                data: ['黄瓜', '西红柿', '青椒']
            },
            toolbox: {
                show: true,
                feature: {
                    mark: {show: true},
                    dataView: {show: true, readOnly: true},
                    magicType: {show: true, type: ['line', 'bar']},
                    restore: {show: true},
                    saveAsImage: {show: true}
                }
            },
            calculable: true,
            xAxis: {
                type: 'category',
                boundaryGap: false,
                data: date
            },
            yAxis: {
                name: '产量(KG)',
                type: 'value',
                boundaryGap: [0, '100%']
            },
            grid: {
                left: '3%',
                right: '4%',
                containLabel: true
            },
            dataZoom: [{
                type: 'inside',
                start: 50,
                end: 100
            }, {
                start: 50,
                end: 100,
                handleSize: '80%',
                handleStyle: {
                    color: '#fff',
                    shadowBlur: 3,
                    shadowColor: 'rgba(0, 0, 0, 0.6)',
                    shadowOffsetX: 2,
                    shadowOffsetY: 2
                }
            }],
            series: [
//                {
//                    name: '黄瓜',
//                    type: 'line',
//                    smooth: true,
//                    itemStyle: {
//                        normal: {
//                            color: 'rgb(255, 70, 131)'
//                        }
//                    },
//                    areaStyle: {
//                        normal: {
//                            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
//                                offset: 0,
//                                color: 'rgb(255, 158, 68)'
//                            }, {
//                                offset: 1,
//                                color: 'rgb(255, 70, 131)'
//                            }])
//                        }
//                    },
//                    data: my_data()
//                }
                {
                    name: '黄瓜',
                    type: 'line',
                    stack: '总量',
                    smooth: true,
                    barMaxWidth: 30,
                    //itemStyle: {normal: {areaStyle: {type: 'default'}}},
//                    areaStyle: {
//                        normal: {
//                            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
//                                offset: 0,
//                                color: 'rgb(255, 158, 68)'
//                            }, {
//                                offset: 1,
//                                color: 'rgb(255, 70, 131)'
//                            }])
//                        }
//                    },
                    data: yield_data()
                },
                {
                    name: '西红柿',
                    type: 'line',
                    stack: '总量',
                    barMaxWidth: 30,
                    smooth: true,
//                    areaStyle: {
//                        normal: {
//                            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
//                                offset: 0,
//                                color: 'rgb(255, 158, 68)'
//                            }, {
//                                offset: 1,
//                                color: 'rgb(255, 70, 131)'
//                            }])
//                        }
//                    },
                    data: yield_data()
                },
                {
                    name: '青椒',
                    type: 'line',
                    stack: '总量',
                    barMaxWidth: 30,
                    smooth: true,
//                    areaStyle: {
//                        normal: {
//                            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
//                                offset: 0,
//                                color: 'rgb(255, 158, 68)'
//                            }, {
//                                offset: 1,
//                                color: 'rgb(255, 70, 131)'
//                            }])
//                        }
//                    },
                    data: yield_data()
                }
            ]
        };

//        var option2 = {
//            tooltip: {
//                trigger: 'item',
//                formatter: function(data){
//                    //console.log(data)
//                    myChart.setOption({
//                        title : {
//                            text: '会员数量' + data.value,
//                        }
//                    });
//                    return data.name + '</br>' + '人数：' + data.value + '</br>占比：' + data.percent + '%'+'</br>';
//                }
//            },
//            toolbox: {
//                show : true,
//                feature : {
//                    mark : {show: true},
//                    dataView : {show: true, readOnly: false},
//                    restore : {show: true},
//                    saveAsImage : {show: true}
//                }
//            },
//            legend: {
//                orient: 'horizontal', // 'vertical'
//                icon:'pie',
//                // orient: 'vertical',
//                x: 'right',
//                y: 'bottom',
//                selectedMode:true,
//                data:['准会员','普通会员','高级会员','VIP会员','超级VIP会员']
//            },
//            series: [
//                {
//                    name:'各级别会员人数',
//                    center:['50%','50%'],
//                    type:'pie',
//                    radius: ['50%', '65%'],
//                    avoidLabelOverlap: false,
//                    label: {
//                        normal: {
//                            show: false,
//                            position: 'center',
//                        },
//                        emphasis: {
//                            show: true,
//                            textStyle: {
//                                fontSize: '20',
//                                fontWeight: 'bold'
//                            }
//                        }
//                    },
//                    labelLine: {
//                        normal: {
//                            show: false
//                        }
//                    },
//                    data:[
//                        {value:335, name:'准会员'},
//                        {value:310, name:'普通会员'},
//                        {value:234, name:'高级会员'},
//                        {value:135, name:'VIP会员'},
//                        {value:1548, name:'超级VIP会员'}
//                    ]
//                }
//            ]
//        };
        var option3 = {
            title: {
                text: '影响产量因数'
            },
            tooltip: {
                trigger: 'axis',
                /* axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                 type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                 }*/
            },
            legend: {
                data: ['空气温度', '空气湿度', '光照', '土壤温度', 'CO2浓度', '土壤水分']
            },
            toolbox: {
                show: true,
                feature: {
                    mark: {show: true},
                    dataView: {show: true, readOnly: false},
                    magicType: {show: true, type: ['line', 'bar', 'stack', 'tiled']},
                    restore: {show: true},
                    saveAsImage: {show: true}
                }
            },
            calculable: true,
            xAxis: [
                {
                    type: 'category',
                    boundaryGap: true,
                    data: date
                }
            ],
            yAxis: [
                {
                    type: 'value'
                }
            ],
            grid: {
                left: '3%',
                right: '4%',
                containLabel: true
            },
            dataZoom: [{
                type: 'inside',
                start: 50,
                end: 100,
            }, {
                start: 50,
                end: 100,
                handleSize: '80%',
                handleStyle: {
                    color: '#fff',
                    shadowBlur: 3,
                    shadowColor: 'rgba(0, 0, 0, 0.6)',
                    shadowOffsetX: 2,
                    shadowOffsetY: 2
                }
            }],
            series: [
                {
                    name: '空气温度',
                    type: 'bar',
                    stack: '总量',
                    barMaxWidth: 30,
                    //itemStyle: {normal: {areaStyle: {type: 'default'}}},
                    data: my_data()
                },
                {
                    name: '空气湿度',
                    type: 'bar',
                    stack: '总量',
                    //itemStyle: {normal: {areaStyle: {type: 'default'}}},
                    data: my_data()
                },
                {
                    name: '光照',
                    type: 'bar',
                    stack: '总量',
                    //itemStyle: {normal: {areaStyle: {type: 'default'}}},
                    data: my_data()
                },
                {
                    name: '土壤温度',
                    type: 'bar',
                    stack: '总量',
                    //itemStyle: {normal: {areaStyle: {type: 'default'}}},
                    data: my_data()
                },
                {
                    name: 'CO2浓度',
                    type: 'bar',
                    stack: '总量',
                    //itemStyle: {normal: {areaStyle: {type: 'default'}}},
                    data: my_data()
                },
                {
                    name: '土壤水分',
                    type: 'bar',
                    stack: '总量',
                    //itemStyle: {normal: {areaStyle: {type: 'default'}}},
                    data: my_data()
                }
            ]
        };
//        var option4 = {
//            tooltip: {
//                trigger: 'axis',
//            },
//            title: {
//                text: '新老顾客数量',
//                /*subtext: '昨日新增：',
//                 subtextStyle: {
//                 fontSize:14,
//                 color : '#ff4a84'
//                 }*/
//            },
//
//            toolbox: {
//                show : true,
//                feature : {
//                    mark : {show: true},
//                    dataView : {show: true, readOnly: false},
//                    magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
//                    restore : {show: true},
//                    saveAsImage : {show: true}
//                }
//            },
//            legend: {
//                data:['新会员','老会员','潜客']
//            },
//            calculable : true,
//            xAxis: {
//                type : 'category',
//                boundaryGap : false,
//                data : date
//            },
//            yAxis: {
//                type: 'value',
//                boundaryGap: [0, '100%']
//            },
//            dataZoom: [{
//                type: 'inside',
//                start: 84,
//                end: 100
//            }, {
//                start: 84,
//                end: 100,
//                handleSize: '80%',
//                handleStyle: {
//                    color: '#fff',
//                    shadowBlur: 3,
//                    shadowColor: 'rgba(0, 0, 0, 0.6)',
//                    shadowOffsetX: 2,
//                    shadowOffsetY: 2
//                }
//            }],
//            series: [
//                {
//                    name:'新会员',
//                    type:'line',
//                    smooth:false,
//                    stack: '总量',
//                    itemStyle: {normal: {areaStyle: {type: 'default'}}},
//                    data:my_data()
//                },
//                {
//                    name:'老会员',
//                    type:'line',
//                    stack: '总量',
//                    smooth:true,
//                    itemStyle: {normal: {areaStyle: {type: 'default'}}},
//                    data:my_data()
//                },
//                {
//                    name:'潜客',
//                    type:'line',
//                    stack: '总量',
//                    smooth:true,
//                    itemStyle: {normal: {areaStyle: {type: 'default'}}},
//                    data:my_data()
//                }
//            ]
//        };

        var option5 = {
            title: {
                text: '产量因子合适占比'
            },
            tooltip: {
                trigger: 'item',
                formatter: function (data) {
                    //console.log(data)
                    myChart.setOption({
                        title: {
                            text: '产量因子占比' + data.value,
                        }
                    });
                    return data.name + '</br>' + '</br>占比：' + data.percent + '%' + '</br>';
                }
            },
            toolbox: {
                show: true,
                y: 25,
                x: 930,
                feature: {
                    mark: {show: true},
                    dataView: {show: true, readOnly: false},
                    restore: {show: true},
                    saveAsImage: {show: true}
                }
            },
            legend: {
                orient: 'horizontal', // 'vertical'
                icon: 'pie',
                // orient: 'vertical',
                x: 'center',
                y: 'bottom',
                selectedMode: true,
                data: ['空气温度', '空气湿度', '光照', '土壤温度', 'CO2浓度', '土壤水分']
            },
            series: [
                {
                    name: '产量因子合适占比',
                    type: 'pie',
                    center: ['50%', '55%'],
                    radius: ['40%', '55%'],
                    selectedMode: 'single',
                    itemStyle: {
                        normal: {
                            label: {
                                show: true,
                                formatter: function (param) {
                                    return param.name + ' : ' + Math.round(param.percent) + '%';
                                },
                                textStyle: {
                                    fontWeight: 'bolder'
                                }
                            }
                        },
                        emphasis: {
                            label: {
                                show: true,
                                position: 'center',
                                textStyle: {
                                    fontSize: '30',
                                    fontWeight: 'bold'
                                }
                            }
                        }
                    },
                    data: sf_data

                }
            ]
//            series: [
//                {
//                    name:'产量因子合适占比',
//                    center:['50%','50%'],
//                    type:'pie',
//                    radius: ['50%', '65%'],
//                    avoidLabelOverlap: false,
//                    label: {
//                        normal: {
//                            show: false,
//                            position: 'center'
//                        },
//                        emphasis: {
//                            show: true,
//                            textStyle: {
//                                fontSize: '20',
//                                fontWeight: 'bold'
//                            }
//                        }
//                    },
//                    labelLine: {
//                        normal: {
//                            show: false
//                        }
//                    },
//                    data:[
//                        {value:335, name:'空气温度'},
//                        {value:310, name:'空气湿度'},
//                        {value:210, name:'光照'},
//                        {value:230, name:'土壤温度'}
//                    ]
//                }
//            ]
        };


        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
//        myChart2.setOption(option2);
        myChart3.setOption(option3);
//        myChart4.setOption(option4);
        myChart5.setOption(option5);

//        myChart.on('mousemove',function(params){ // 控制台打印数据的名称
//            $('#my_date_set1').html(params.name);
//            myChart2.clear();
//            option2.series[0].data = [
//                {value:900, name:'准会员'},
//                {value:150, name:'普通会员'},
//                {value:150, name:'高级会员'},
//                {value:150, name:'VIP会员'},
//                {value:150, name:'超级VIP会员'}
//            ];
//            myChart2.setOption(option2,true);
//            /*myChart2.setOption({
//             series: [
//             {
//             data:[
//             {value:100, name:'准会员'},
//             {value:310, name:'普通会员'},
//             {value:234, name:'高级会员'},
//             {value:135, name:'VIP会员'},
//             {value:params.value, name:'超级VIP会员'}
//             ]
//             }
//             ]
//             });*/
//        });
//        myChart4.on('mousemove',function(params){ // 控制台打印数据的名称
//            $('#my_date_set2').html(params.name)
//            myChart5.setOption({
//                series: [
//                    {
//                        data:[
//                            {value:params.value, name:'新会员'},
//                            {value:310, name:'老会员'},
//                            {value:210, name:'潜客'}
//                        ]
//                    }
//                ]
//            });
//        });

    });
</script>
</body>
</html>