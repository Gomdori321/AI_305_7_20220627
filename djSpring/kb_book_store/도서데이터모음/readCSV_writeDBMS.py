import csv
import pymysql

f = open("kbBookStoreData.csv",'r',encoding='utf-8') #파일 정보 있는 csv 파일 열기
rdr = csv.reader(f) #csv 파일 읽기

mydata = []
for line in rdr:
    mydata.append(line) #새로운 배열에 csv 값들 추가

f.close() #파일 관련 객체 종료시킴


del mydata[0] # 첫줄은 제목이므로 지운다


# %d : 숫자, %s : 문자열
sql = 'insert into book(bookid, bookisbn, bookname, publisher, price) ' \
      'values(%d, "%s", "%s", "%s", %d)'
for item in mydata:
    conn = pymysql.connect(host='localhost',
                           user='kb_bookstore_admin',
                           password='kbadmin',
                           db='kb_book_store',
                           charset='utf8')
    with conn: #db 연결 및 끊어주는 걸 자동으로 함. db명령수행하면 자동끊김
        with conn.cursor() as cur: #conn의 cursor를 cur로 변경(db 안의 커서)
            try :
                cur.execute(
                sql % ( int(item[0]), item[4], item[1], item[2],
                        (int)(item[6].strip().replace(",","")))
                ) #가격의 큰따옴표나 콤마를 공백으로 대체한 뒤 숫자로 변경
                conn.commit()
            except : #중복등의 이슈로 들어가지 않는 데이터는 무시한다. 
                pass
