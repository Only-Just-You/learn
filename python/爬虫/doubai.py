#coding:utf-8
import urllib.request,urllib.error   #获取网页，打印内容
from bs4 import BeautifulSoup		 #对网页进行解析
import re                            #正则表达式
import xlwt                          #Excel表格
import pymysql                       #MySQL

# 爬虫步骤
# 1.获取网页，解析网页
# 2.对解析的网页进行筛选存入datalist
# 3.将datalist列表的内容遍历存入Excel
# 或
# 3.将datalist列表的内容遍历insert into MySQL



def main():
	# baseurl = 'https://movie.douban.com/top250?start='
	# askURL(baseurl)
	# datalist = getDate(baseurl)
	# savepath = "豆瓣电影Top250.xls"
	# saveData(datalist,savepath)
	# saveDataToDB(datalist)
	getDataFormDB()

findLink = re.compile(r'<a href="(.*?)">')                                         #r' '是防止' '中的有转义字符
findImgSrc = re.compile(r'<img.*sec="(.*?)"',re.S)
findTitle = re.compile(r'<span class="title">(.*)</span>')
findRate = re.compile(r'<span class="rating_num" property="v:average">(.*)</span>')
findJudge = re.compile(r'<span>(\d*)人评价</span>')
findInq = re.compile(r'<span class="inq">(.*)</span>')
findbd = re.compile(r'<p class="">(.*?)</p>',re.S)

def getDate(baseurl):
	datalist = []
	for i in range(0,10):                    #获取共250条数据
		url = baseurl + str(i*25)            #根据网页分成10页
		html = askURL(url)
		# print html
		soup = BeautifulSoup(html,'html.parser')                #对html中的内容用html.parser解析
		for item in soup.find_all('div',class_="item"):         #截取符合<div class="item">标签中的全部内容
			# print item
			data = []
			item = str(item)                                    #将item字符串
			# print (item)
			# break

			link = re.findall(findLink,item)[0]                 #用re正则表达式匹配合适的内容
			data.append(link)                                   #re.findall(a,b) a是条件,b是要截取的内容

			imgsrc = re.findall(findImgSrc,item)
			if len(imgsrc) != 0:
				data.append(imgsrc)
			else:
				data.append(' ')

			titles = re.findall(findTitle,item)
			if len(titles)==2:
				ctitle = titles[0]
				data.append(ctitle)
				otitle = titles[1].replace(" / ","")               #str.replace(a,b) 将str中的a全部转变为b
				data.append(otitle)
			else:
				data.append(titles[0])
				data.append(' ')

			# print (data)
			# break
				
			rating = re.findall(findRate,item)[0]
			data.append(rating)

			judgeNum = re.findall(findJudge,item)[0]
			data.append(judgeNum)

			inq = re.findall(findInq,item)
			if len(inq) != 0:
				inq = inq[0]
				data.append(inq)
			else:
				data.append(' ')

			bd = re.findall(findbd,item)[0]
			bd = re.sub(r'<br(\s+)?/>(\s+)?'," ",bd)       #re.sub(a,b,c) 和str.place()差不多，但能使用正则表达式
			bd = re.sub(r'/'," ",bd)                       #a 是正则表达式 b 是要替换的内容 c 是目标
			data.append(bd.strip())         #去空格

			datalist.append(data)
	# print (datalist)
	return datalist

def getDataFormDB():
	try:
		conn = pymysql.connect('localhost','root','123','movie')
	except:
		print('连接错误')

	sql = """
		SELECT * from movie250 order by score DESC limit 20
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
		m.append(i[3])
		n.append(i[5])
		o.append(str(i[6]))
		p.append(i[7])
		q.append(i[8])
	print(m)
	print(n)
	print(o)
	print(p)
	print(q)

	cursor.close()
	conn.close()

def askURL(url):
	# 头部信息，有些网站会识别访问来源，所以要模拟浏览器来进行网站的访问
	head = {
		'User-Agent': 'Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.25 Safari/537.36 Core/1.70.3756.400 QQBrowser/10.5.4039.400'
	}

	request = urllib.request.Request(url, headers=head) # 对网站进行获取请求
	html = ''
	try:
		response = urllib.request.urlopen(request)      # 获取网站的内容
		html = response.read().decode('utf-8')          # 用utf-8编码内容并存入html中
		# print html
	except urllib.error.URLError as e:
		if hasattr(e,'code'):
			print (e.code)
		if hasattr(e,'reason'):
			print (e.reason)

	return html 

def saveData(datalist,savepath):
	print("save.....")
	book = xlwt.Workbook(encoding='utf-8',style_compression=0)            #用xlwt打开Excel
	sheet = book.add_sheet('豆瓣电影Top250',cell_overwrite_ok=True)        #设置Excel格式
	col = ("电影链接","图片链接","影片中文名","影片英文名","评分","评价数","概况","相关信息")  #列名
	for i in range(0,8):
		sheet.write(0,i,col[i])                #二维数组表示位置，然后write()写入列名
	for i in range(0,250):
		print('第%d系' %i)
		data = datalist[i]
		for j in range(0,8):
			sheet.write(i+1,j,data[j])         #很明显(0,*)已经被写完了所以从第二行写

	book.save(savepath)                        #存储路径，默认当前目录

def saveDataToDB(datalist):
	init_db()
	try:
		conn = pymysql.connect('localhost',user = "root",passwd = "123",db = "movie")
	except:
		print("连接失败")
	cur = conn.cursor()

	for data in datalist:
		for index in range(len(data)):
			data[index] = '"'+data[index]+'"'              #MySQL的插入方式，先把每一个data左右两边加上“”
		sql = """
			insert into movie250(
				info_link,pic_link,cname,oname,score,rated,instroduction,info
			) values(
				%s
			)
		"""%",".join(data)                             #",".join(data)  意思是使用，将data中的数组合并
		# print(sql)
		# break
		cur.execute(sql)
		conn.commit()

	cur.close()
	conn.close()


def init_db():
	sql = """
		create table movie250(
			id integer primary key auto_increment,
			info_link text,
			pic_link text,
			cname varchar(100),
			oname varchar(100),
			score double,
			rated numeric,
			instroduction text,
			info text
		)
	"""
	try:
		conn = pymysql.connect('localhost',user = "root",passwd = "123",db = "movie")    #连接数据库
	except:
		print("连接失败")
	cursor = conn.cursor()         #获取游标
	cursor.execute(sql)            #编译
	conn.commit()                  #提交
	conn.close()                   #关闭                                              

if __name__ == '__main__':
	main()
	print('\n')
	print("爬取成功")