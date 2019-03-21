var z=document.getElementById('mythead0').className;
var n=document.getElementById('mytbody0').className;
var flag1=document.getElementById('mythead1').className;
z=z.replace(/\[/g,"");
z = z.replace("]", "");
z=z.replace(/\ /g,"");
var a = z.split(",");
var b = n.split(",");
function selectEchart() {
    var select = document.getElementById("selectid4").value;
    var myChart = echarts.init(document.getElementById('echarts1'));
    var legends = [];
    var series = [];
    if (select == 1) {
        option.yAxis[0].name = '温度/℃'
        for (var i = 0; i < a.length; i++) {
            jQuery.ajax({
                type: "POST",
                url: "/dayWeather0",
                data: {
                    "place": b[i],
                    "year": a[i]
                },
                dataType: "json",
                async: false,
                success: function (datas) {
                    var Item = function () {
                        return {
                            name: '',
                            type: 'line',
                            data: []
                        }
                    };
                    var it = new Item();
                    legends.push(a[i]);
                    it.name = a[i];
                    for (var j = 0; j < datas.length; j++) {
                        if (flag1 == 1) {
                            it.data.push(datas[j].MaxTemp);
                        }
                    }
                    series.push(it);
                }
            })
        }
        option.legend.data = legends;
        option.series = series;
        option.title.text = '最高气温'
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    }
    else if(select==2) {
        option.yAxis[0].name = '温度/℃'
        for (var i = 0; i < a.length; i++) {
            jQuery.ajax({
                type: "POST",
                url: "/dayWeather0",
                data: {
                    "place": b[i],
                    "year": a[i]
                },
                dataType: "json",
                async: false,
                success: function (datas) {
                    var Item = function () {
                        return {
                            name: '',
                            type: 'line',
                            data: []
                        }
                    };
                    var it = new Item();
                    legends.push(a[i]);
                    it.name = a[i];
                    for (var j = 0; j < datas.length; j++) {
                        if (flag1 == 1) {
                            it.data.push(datas[j].MinTemp);
                        }
                    }
                    series.push(it);
                }
            })
        }
        option.legend.data = legends;
        option.series = series;
        option.title.text = '最低气温'
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    }
    else if(select==3){
        option.yAxis[0].name = '时长/h'
        for (var i = 0; i < a.length; i++) {
            jQuery.ajax({
                type: "POST",
                url: "/dayWeather0",
                data: {
                    "place": b[i],
                    "year": a[i]
                },
                dataType: "json",
                async: false,
                success: function (datas) {
                    var Item = function () {
                        return {
                            name: '',
                            type: 'line',
                            data: []
                        }
                    };
                    var it = new Item();
                    legends.push(a[i]);
                    it.name = a[i];
                    for (var j = 0; j < datas.length; j++) {
                        if (flag1 == 1) {
                            it.data.push(datas[j].SunshineHours);
                        }
                    }
                    series.push(it);
                }
            })
        }
        option.legend.data = legends;
        option.series = series;
        option.title.text = '日照时数'
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    }
    else{
        option.yAxis[0].name = '降雨量/mm'
        for (var i = 0; i < a.length; i++) {
            jQuery.ajax({
                type: "POST",
                url: "/dayWeather0",
                data: {
                    "place": b[i],
                    "year": a[i]
                },
                dataType: "json",
                async: false,
                success: function (datas) {
                    var Item = function () {
                        return {
                            name: '',
                            type: 'bar',
                            data: []
                        }
                    };
                    var it = new Item();
                    legends.push(a[i]);
                    it.name = a[i];
                    for (var j = 0; j < datas.length; j++) {
                        if (flag1 == 1) {
                            it.data.push(datas[j].Rainfall);
                        }
                    }
                    series.push(it);
                }
            })
        }
        option.legend.data = legends;
        option.series = series;
        option.title.text = '降雨量'
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    }
}