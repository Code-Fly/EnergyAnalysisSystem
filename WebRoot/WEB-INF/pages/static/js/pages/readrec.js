$(document).ready(function() {
	var dataSource = new kendo.data.DataSource({
		transport : {
			read : {
				url : _ctx + "/api/readrec/query?mID=37&beginDate=2015-01-01 13:00:01&endDate=2015-01-20 00:00:01",
				dataType : "jsonp"
			}
		}
	});
	$("#chart").kendoChart({
		autoBind : false,
		dataSource : dataSource,
		series : [ {
			field : "tFlow",
			name : "瞬时流量",
			style : "smooth",
			type : "line",
            markers: {
                visible: false
            }
		}, {
			field : "p",
			name : "压力",
			style : "smooth",
			type : "line",
            markers: {
                visible: false
            }
		}, {
			field : "t",
			name : "温度",
			style : "smooth",
			type : "line",
            markers: {
                visible: false
            }
		} ],
//		categoryAxis: {
//	        categories: [
//	            new Date("2015-01-01 13:00:01"),
//	            new Date("2015-01-20 00:00:01")
//	        ],
//	        baseUnitStep: "auto"
//	    },
		tooltip : {
			visible : true,
			template : "#= series.name #: #= value #"
		},

	});
	dataSource.read();
});