# EnergyAnalysisSystem

#主表接口
http://localhost:8080/EnergyAnalysisSystem/api/meter/query?callback=123123&opID=1

#趋势接口
http://localhost:8085/EnergyAnalysisSystem//api/readrec/query?callback=123123&mID=37&beginDate=2015-02-19 13:00:01&endDate=2015-02-20 00:00:01

# 日用量分析
http://localhost:8085/EnergyAnalysisSystem/api/dayaccount/query?callback=123123&mID=37&beginDate=2015-02-19&endDate=2015-05-21

# 月用量分析
http://localhost:8080/EnergyAnalysisSystem/api/monthaccount/query?callback=123123&year=2015&mID=37

# 年用量分析
http://localhost:8080/EnergyAnalysisSystem/api/yearaccount/query?callback=123123&year=2014&infoID=000103&opID=1

# 电压故障 
http://localhost:8080/EnergyAnalysisSystem/api/error/query?callback=123123&beginDate=2013-10-09 13:00:01&endDate=2013-10-19 00:00:01&errClass=201&opID=1

# 抄电压记录查询 
http://localhost:8080/EnergyAnalysisSystem/api/meterlog/query?callback=123123&beginDate=2013-10-09 13:00:01&endDate=2013-10-19 00:00:01&mID=37

# 停气报警查询:errType = 4
# 数据异常查询 :errType = 3
http://localhost:8080/EnergyAnalysisSystem/api/readerr/query?callback=123123&beginDate=2013-10-09 13:00:01&endDate=2013-10-19 00:00:01&errType=3&opID=1

# 树形结构查询 infoID=0001 非必须，不传时返回根节点.
http://localhost:8085/EnergyAnalysisSystem/api/tree/area/query?callback=123123&infoID=0001



# 日志数据
http://localhost:8080/EnergyAnalysisSystem/api/log/query?callback=123123&beginDate=2014-04-09 13:00:01&endDate=2014-10-11 00:00:01
