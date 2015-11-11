$(document).ready(function() {
	$("#chart").kendoChart({
		dataSource : {
			transport : {
				read : {
					url : _ctx + "/api/readrec/query?mID=37&beginDate=2015-01-18 13:00:01&endDate=2015-01-19 10:20:01",
					dataType : "jsonp"
				}
			}
		},
		series : [ {
			field : "tFlow",
			name : "瞬时流量 [kwh]",
			style : "smooth",
			type : "line",
			markers : {
				visible : false
			},
			color : "#ff1c1c",
			axis : "tFlow"
		}, {
			field : "p",
			name : "压力 [pa]",
			style : "smooth",
			type : "line",
			markers : {
				visible : false
			},
			color : "#ffae00",
			axis : "p"
		}, {
			field : "t",
			name : "温度 [&deg;C]",
			style : "smooth",
			type : "line",
			markers : {
				visible : false
			},
			color : "#73c100",
			axis : "t"
		}, {
			field : "curNumber",
			name : "累计 [kwh]",
			style : "smooth",
			type : "line",
			markers : {
				visible : false
			},
			color : "#007eff",
			axis : "curNumber"
		} ],
		valueAxes : [ {
			name : "tFlow",
			color : "#ff1c1c"
		}, {
			name : "p",
			color : "#ffae00"
		}, {
			name : "t",
			color : "#73c100"
		}, {
			name : "curNumber",
			color : "#007eff"
		} ],
		legend : {
			position : "bottom"
		},
		title : {
			text : "2015-01-18 13:00:01 ~ 2015-01-19 10:20:01"
		},
		categoryAxis : {
			majorGridLines : {
				visible : false
			},
			majorTicks : {
				visible : false
			},
			axisCrossingValues : [ 999999, 999999, 0, 0 ],
		},
		tooltip : {
			visible : true,
			template : "<div>#= series.name #: #= value #</div><div> #= dataItem.comTime#</div>"
		},
		chartArea : {
			background : "transparent"
		}
	});

});