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

# 供电故障查询 errProcessFlag=0 值为0时标示查询未处理的告警，传1时标示查询已经处理的告警，不传值标示查询全部告警
http://localhost:8080/EnergyAnalysisSystem/error/query?callback=123123&beginDate=2013-10-09 13:00:01&endDate=2013-10-19 00:00:01&errFlag=1&errProcessFlag=0

# 抄电压记录查询 errFlag=1 值为0时标示查询全部电压记录，值为1时候查询有异常的电压记录，值为2是查询正常电压记录
http://localhost:8080/EnergyAnalysisSystem/error/query?callback=123123&beginDate=2013-10-09 13:00:01&endDate=2013-10-19 00:00:01&errFlag=1

# 停气报警查询:errType = 4
# 数据异常查询 :errType = 3
http://localhost:8080/EnergyAnalysisSystem/readerr/query?callback=123123&beginDate=2013-10-09 13:00:01&endDate=2013-10-19 00:00:01&errType=3

# 树形结构查询 infoID=0001 非必须，不传时返回根节点
http://localhost:8085/EnergyAnalysisSystem/api/tree/query?callback=123123&infoID=0001

# 日志数据
http://localhost:8080/EnergyAnalysisSystem//api/log/query?callback=123123&beginDate=2014-04-09 13:00:01&endDate=2014-10-11 00:00:01
