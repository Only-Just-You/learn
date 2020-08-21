# -*- coding: utf-8 -*-
# @Author: Administrator
# @Date:   2020-05-08 14:57:08
# @Last Modified by:   Administrator
# @Last Modified time: 2020-07-15 20:49:52
import urllib.request,urllib.error
from bs4 import BeautifulSoup
import re
import pymysql
import xlwt
import time
import xlrd

def main():
	baseurl = 'https://music.douban.com/top250?start='
	# verurl = 'file:///C:/Users/Administrator/Desktop/html2.html'
	
	# datalist = getData(baseurl)        #从网页中获取数据
	# saveDataToDB(datalist)             #存入数据库
	# savePath = '豆瓣音乐Top250.xls'
	# saveData(datalist,savePath)        #存入Excel表
	# askURL(baseurl)
	# data_list = readDate(savePath)       #从Excel中获取数据
	# saveDataToDB(data_list)				 #读取Excel中的数据存入数据库
	readDataFromDB()
	# for i in range(len(n)):
	# 	n[i] = str(n[i])[2:6]
	# saveDataToDB(n)

#正则表达式
findLink = re.compile(r'a href="(.*?)"',re.S)           #音乐链接
#----------------------------------------------------------------------------
# findname = re.compile(r'<a class="nbg" href=".*?title="(.*?)">',re.S)
# findaddname = re.compile(r'<span style="font-size:12px;">(.*?)</span>',re.S)
#------------------------------------------------------------------------------
findName = re.compile(r'<a class="nbg" href=".*?title="(.*?)">',re.S)   #音乐名1)
findOName = re.compile(r'<span style="font-size:12px;">(.*?)</span>',re.S)   #音乐名2
findTitle = re.compile(r'(.*?) - .*?',re.S)             #作者名
findpoltime = re.compile(r'.*?/ (\d*)-?(\d*)?-?(\d*)?.*?')         #年份
findPl = re.compile(r'<p class="pl">(.*?)</p>',re.S)     #音乐简介
findRate = re.compile(r'<span class="rating_nums">(.*?)</span>',re.S)    #评分
findRatingNum = re.compile(r'<span class="pl">.*?(\d*)人评价.*?</span>',re.S)   #评价人数
#-----------------------------------------------------------
def getData(baseurl):
	datalist = []

	for i in range(0,10):
		print("...")
		time.sleep( 3 )
		url = baseurl + str(i*25)

		html = askURL(url)
		# fo = open("html.html","r", encoding='UTF-8')
		# html = fo.read()

		soup = BeautifulSoup(html,'html.parser')
		for item in soup.find_all('tr',class_="item"):
			data = []
			item = str(item)
			# print(item)
			# break
			link = re.findall(findLink,item)[0]               #音乐的连接
			data.append(link)

			#----------------------------------------------------------------
			# nl = re.findall(findname,item)
			# mk = re.findall(findaddname,item)
			# print(nl)
			# break
			#-----------------------------------------------------------------
			name = re.findall(findName,item)[0]              #音乐名1
			data.append(name)

			oname = re.findall(findOName,item)                 #音乐名2
			if len(oname) != 0:
				data.append(oname[0])
			else:
				data.append(' ')
			# print(data)
			# break

			pi = re.findall(findPl,item)[0]                   #音乐风格
			data.append(pi)

			title = re.findall(findTitle,name)[0]             #作者名
			data.append(title)

			poltime = re.findall(findpoltime,pi)[0]                   #发行年份
			poltime = "-".join(poltime)
			poltime = poltime.replace('--','')
			data.append(poltime)

			rate = re.findall(findRate,item)[0]               #评分
			data.append(rate)

			ratingnum = re.findall(findRatingNum,item)[0]     #评价人数
			data.append(ratingnum)
			# print(data)
			# break
			datalist.append(data)
		# print()
		# print(datalist)
		# break
	return datalist

def saveDataToDB(datalist):
	# init_db()

	try:
		conn = pymysql.connect('localhost','root','123','movie')
	except:
		print('连接错误')
	cursor = conn.cursor()

	print('插入数据中......')
	i=0
	for data in datalist:
		i=i+1
		sql = """
				UPDATE music250
				set year = {0}
				where id = {1}
		""".format(data,i)
		# print(sql)
		# break
		# for index in range(len(data)):
		# 	data[index] = '"'+data[index]+'"'
		# sql = """
		# 	insert into music250(
		# 		link_music,name_music,oname_music,introduction,title,poltime,score,rate
		# 	)values(
		# 		%s
		# 	)
		# """%",".join(data)
		# print(sql)
		# break
		cursor.execute(sql)

		conn.commit()

	cursor.close()
	conn.close()
	print('数据插入完成')
	

def saveData(datalist,savePath):
	print('save.....')
	book = xlwt.Workbook(encoding='utf-8',style_compression=0)
	sheet = book.add_sheet('豆瓣音乐Top250',cell_overwrite_ok=True)
	cols = ('音乐链接','音乐中文名','音乐别名','概况','作者','发行时间','评分','评价人数')
	for i in range(0,8):
		sheet.write(0,i,cols[i])
	for i in range(len(datalist)):
		data = datalist[i]
		for j in range(0,8):
			sheet.write(i+1,j,data[j])

	book.save(savePath)

def readDate(filePath):
	data_list = []
	try:
		book = xlrd.open_workbook(filePath,'rb')
	except:
		print('打开Excel文件错误')
	sheet = book.sheet_by_name('豆瓣音乐Top250')
	for i in range(1,251):
		data = []
		for j in range(0,8):
			data.append(sheet.cell_value(i,j))
		data_list.append(data)

	return data_list

def readDataFromDB():
	try:
		conn = pymysql.connect('localhost','root','123','movie')
	except:
		print('连接错误')
	cursor = conn.cursor()
	sql = """
		SELECT * from music250 order by score DESC limit 20
	"""
	cursor = conn.cursor()
	cursor.execute(sql)
	date = cursor.fetchall()
	m = []
	n = []
	o = []
	p = []
	q = []
	for i in date:
		m.append(i[1])
		n.append(i[2])
		o.append(str(i[4]))
		p.append(i[8])
		q.append(i[9])
	print(m)
	print(n)
	print(o)
	print(p)
	print(q)

	cursor.close()
	conn.close()

def askURL(url):
	head = {
		'User-Agent': 'Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.25 Safari/537.36 Core/1.70.3756.400 QQBrowser/10.5.4039.400'
	}


	request = urllib.request.Request(url,headers=head)
	html=''
	try:
		response = urllib.request.urlopen(request)
		html = response.read().decode('utf-8')
	except urllib.error.URLError as e:
		if hasattr(e,'code'):
			print(e.code)
		if hasattr(e,'reason'):
			print(e.reason)

	return html

def init_db():
	sql ="""
		create table music250(
			id integer primary key auto_increment,
			link_music text,
			name_music text,
			oname_music text,
			introduction text,
			title varchar(100),
			poltime varchar(100),
			score double,
			rate bigint
)
	"""
	try:
		conn = pymysql.connect('localhost','root','123','movie')
	except:
		print('连接错误')

	cursor = conn.cursor()
	cursor.execute(sql)

	conn.commit()
	cursor.close()
	conn.close()

	print('数据表创建成功')
	
if __name__ == '__main__':
	main()