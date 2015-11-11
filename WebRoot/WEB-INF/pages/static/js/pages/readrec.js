$(document).ready(function() {
	$("#chart").kendoChart({
		dataSource : {
			transport : {
				read : {
					url : _ctx + "/api/readrec/query?mID=37&beginDate=2015-01-18 13:00:01&endDate=2015-01-20 10:20:01",
					dataType : "jsonp"
				}
			}
		},
		series : [ {
			field : "tFlow",
			name : "瞬时流量",
			style : "smooth",
			type : "line",
			markers : {
				visible : false
			}
		}, {
			field : "p",
			name : "压力",
			style : "smooth",
			type : "line",
			markers : {
				visible : false
			}
		}, {
			field : "t",
			name : "温度",
			style : "smooth",
			type : "line",
			markers : {
				visible : false
			}
		} ],
		categoryAxis: {
            title: {
                text: "2015-01-18 13:00:01 ~ 2015-01-20 10:20:01"
            },
            majorGridLines: {
                visible: false
            },
            majorTicks: {
                visible: false
            }
        },
		tooltip : {
			visible : true,
			template : "<div>#= series.name #: #= value #</div><div> #= dataItem.comTime#</div>"
		},

	});
	
});