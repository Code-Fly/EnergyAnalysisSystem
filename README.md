# EnergyAnalysisSystem

#主表接口
http://localhost:8080/EnergyAnalysisSystem/api/meter/query?callback=123123

#趋势接口
http://localhost:8085/EnergyAnalysisSystem//api/readrec/query?callback=123123&mID=37&beginDate=2015-02-19 13:00:01&endDate=2015-02-20 00:00:01

# 日用量分析
http://localhost:8085/EnergyAnalysisSystem/api/dayaccount/query?callback=123123&mID=37&beginDate=2015-02-19&endDate=2015-05-21

# 月用量分析
http://localhost:8080/EnergyAnalysisSystem/api/monthaccount/query?callback=123123&year=2015&mID=37

# 年用量分析
http://localhost:8080/EnergyAnalysisSystem/api/yearaccount/query?callback=123123&year=2014&infoID=000103

# 供电故障查询  errClass这个参数非必须，其他必须
http://localhost:8080/EnergyAnalysisSystem//error/meter/query?callback=123123&beginDate=2013-10-09 13:00:01&endDate=2013-10-19 00:00:01&errClass=202

# 树形结构查询 infoID=0001 非必须，不传时返回根节点
http://localhost:8085/EnergyAnalysisSystem/api/tree/query?callback=123123&infoID=0001

# 日志数据
http://localhost:8080/EnergyAnalysisSystem//api/log/query?callback=123123&beginDate=2014-04-09 13:00:01&endDate=2014-10-11 00:00:01
