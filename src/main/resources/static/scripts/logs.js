var table;
function init(){
	loadThisDay();
	loadLastDay();
	loadLast7Day();
	loadLast1Month();
}
function loadThisDay(){
	$.get(
        "/log/getdaystat?kind=1",
        function(json){
            if(json.success){
                var list=json.data;
                var ipdict={},timedict={};
                var dict={};
                for(var i=0;i<list.length;i++){
                	var item=list[i];
                	//console.log(item);
                	ipdict[item.name]=item.name;
                	timedict[item.period]=item.period;
                	
                	if(isEmpty(dict[item.name]))dict[item.name]={};
                	dict[item.name][item.period]=item.total;
                }

                var dataSet=[];var i=0;
                for(var ip in ipdict){
                	var data=[];i++;
                	for(var time in timedict){
                		data.push([parseInt(time),dict[ip][time]]);
                		//data.push(time,dict[ip][time]);
                		//console.log(ip+"|"+time+"|"+dict[ip][time]);
                	}
                	dataSet.push({label:ip,data:data});
                }
                buildChart('#line-chart1',dataSet);
            }
        },"json");
}

function loadLastDay(){
	$.get(
        "/log/getdaystat?kind=2",
        function(json){
            if(json.success){
                var list=json.data;
                var ipdict={},timedict={},dict={};
                for(var i=0;i<list.length;i++){
                	var item=list[i];
                	ipdict[item.name]=item.name;
                	timedict[item.period]=item.period;
                	
                	if(isEmpty(dict[item.name]))dict[item.name]={};
                	dict[item.name][item.period]=item.total;
                }

                var dataSet=[];var i=0;
                for(var ip in ipdict){
                	var data=[];i++;
                	for(var time in timedict){
                		data.push([parseInt(time),dict[ip][time]]);
                	}
                	dataSet.push({label:ip,data:data});
                }
                buildChart('#line-chart2',dataSet);
            }
        },"json");
}

function loadLast7Day(){
	$.get(
        "/log/getdaystat?kind=3",
        function(json){
            if(json.success){
                var list=json.data;
                var ipdict={},timedict={},dict={};
                for(var i=0;i<list.length;i++){
                	var item=list[i];
                	ipdict[item.name]=item.name;
                	timedict[item.period]=item.period;
                	
                	if(isEmpty(dict[item.name]))dict[item.name]={};
                	dict[item.name][item.period]=item.total;
                }

                var dataSet=[];var i=0;
                for(var ip in ipdict){
                	var data=[];i++;
                	for(var time in timedict){
                		data.push([parseInt(time),dict[ip][time]]);
                	}
                	dataSet.push({label:ip,data:data});
                }
                buildChart('#line-chart3',dataSet);
            }
        },"json");
}

function loadLast1Month(){
	$.get(
        "/log/getdaystat?kind=4",
        function(json){
            if(json.success){
                var list=json.data;
                var ipdict={},timedict={},dict={};
                for(var i=0;i<list.length;i++){
                	var item=list[i];
                	ipdict[item.name]=item.name;
                	timedict[item.period]=item.period;
                	
                	if(isEmpty(dict[item.name]))dict[item.name]={};
                	dict[item.name][item.period]=item.total;
                }

                var dataSet=[];var i=0;
                for(var ip in ipdict){
                	var data=[];i++;
                	for(var time in timedict){
                		data.push([parseInt(time),dict[ip][time]]);
                	}
                	dataSet.push({label:ip,data:data});
                }
                buildChart('#line-chart4',dataSet);
            }
        },"json");
}

function buildChart(placeholder,dataSet){
	var chartOption={
		grid:{
			hoverable  : true,
			borderColor: '#f3f3f3',
			borderWidth: 1,
			tickColor  : '#f3f3f3'
		},
		series:{
			shadowSize: 0,
			lines:{show: true},
			points:{show: true}
		},
		lines:{
			fill : false,
			color: ['#3c8dbc', '#f56954']
		},
		yaxis:{
			show: true
		},
		xaxis:{
			show: true
		}
	};
			
	$.plot(placeholder,dataSet,chartOption);
    $('<div class="tooltip-inner" id="line-chart-tooltip"></div>').css({
		position: 'absolute',
		display : 'none',
		opacity : 0.8
    }).appendTo('body');
    	
    $(placeholder).bind('plothover', function (event, pos, item) {
		if (item) {
			var x = item.datapoint[0].toFixed(0),y = item.datapoint[1].toFixed(0)
			var label;
			if(x>24)label="IP："+item.series.label + "<br/>日期："+x+'<br/>PV：' + y;
			else label="IP："+item.series.label + "<br/>小时："+x+'<br/>PV：' + y;
			$('#line-chart-tooltip').html(label)
				.css({ top: item.pageY + 5, left: item.pageX + 5 })
				.fadeIn(200);
		}else {
			$('#line-chart-tooltip').hide()
		}
    });
}

function initChart(){
	var sin = [], cos = []
    for (var i = 1; i < 23; i += 1) {
      sin.push([i, Math.sin(i)])
      cos.push([i, Math.cos(i)])
    }
    var line_data1 = {
    	label: "line1",
      data : sin,
      color: '#3c8dbc'
    }
    var line_data2 = {
    	label: "line2",
      data : cos,
      color: '#00c0ef'
    }
    var dataSet=[line_data1, line_data2];
    var chartOption={
      grid  : {
        hoverable  : true,
        borderColor: '#f3f3f3',
        borderWidth: 1,
        tickColor  : '#f3f3f3'
      },
      series: {
        //shadowSize: 0,
        lines:{show: true},
        points:{show: true}
      },
      lines : {
        fill : false,
        color: ['#3c8dbc', '#f56954']
      },
      yaxis : {
        show: true
      },
      xaxis : {
        show: true
      }
	};
	
    $.plot('#line-chart',dataSet,chartOption);
    $('<div class="tooltip-inner" id="line-chart-tooltip"></div>').css({
      position: 'absolute',
      display : 'none',
      opacity : 0.8
    }).appendTo('body');
    $('#line-chart').bind('plothover', function (event, pos, item) {

      if (item) {
        var x = item.datapoint[0].toFixed(2),
            y = item.datapoint[1].toFixed(2)

        $('#line-chart-tooltip').html(item.series.label + ' of ' + x + ' = ' + y)
          .css({ top: item.pageY + 5, left: item.pageX + 5 })
          .fadeIn(200)
      } else {
        $('#line-chart-tooltip').hide()
      }

    });
}
