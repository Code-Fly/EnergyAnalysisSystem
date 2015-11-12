$(document).ready(function() {
	$(".export-img").click(function() {
		var chart = $("#chart").getKendoChart();
		chart.exportImage().done(function(data) {
			kendo.saveAs({
				dataURI : data,
				fileName : "chart.png",
			});
		});
	});

	$(".export-svg").click(function() {
		var chart = $("#chart").getKendoChart();
		chart.exportSVG().done(function(data) {
			kendo.saveAs({
				dataURI : data,
				fileName : "chart.svg",
			});
		});
	});
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
			axisCrossingValues : [ 999999, 999999, 0 ],
		},
		tooltip : {
			visible : true,
			template : "<div>#= series.name #: #= value #</div><div> #= dataItem.readTime#</div>"
		},
		chartArea : {
			background : "transparent"
		}
	});

	function startChange() {
		var startDate = start.value(), endDate = end.value();
		var endDateMax = new Date(start.value().getFullYear(), start.value().getMonth() + 1, 0);

		if (startDate) {
			startDate = new Date(startDate);
			startDate.setDate(startDate.getDate());
			end.min(startDate);
		} else if (endDate) {
			start.max(new Date(endDate));
		} else {
			endDate = new Date();
			start.max(endDate);
			end.min(endDate);
		}
		end.max(endDateMax);
	}

	function endChange() {
		var endDate = end.value(), startDate = start.value();

		if (endDate) {
			endDate = new Date(endDate);
			endDate.setDate(endDate.getDate());
			start.max(endDate);
		} else if (startDate) {
			end.min(new Date(startDate));
		} else {
			endDate = new Date();
			start.max(endDate);
			end.min(endDate);
		}
	}

	var today = new Date();

	var start = $("#start").kendoDateTimePicker({
		value : today,
		change : startChange,
		format : "yyyy-MM-dd hh:mm tt",
		culture : "zh-CN"
	}).data("kendoDateTimePicker");

	var end = $("#end").kendoDateTimePicker({
		value : today,
		change : endChange,
		format : "yyyy-MM-dd hh:mm tt",
		culture : "zh-CN"
	}).data("kendoDateTimePicker");

	initDateTimePicker();

	$("#reset-dp").click(function() {
		end.max(new Date(today.getFullYear(), today.getMonth() + 1, 0));
		end.value(today);
		start.max(end.value());
		start.value(today);
	});

	function initDateTimePicker() {
		start.max(end.value());
		end.min(start.value());
		var endDateMax = new Date(start.value().getFullYear(), start.value().getMonth() + 1, 0);
		end.max(endDateMax);
	}

	

});