#encoding:utf-8
file = open('E:/testpy.txt','a')
file.write('这是追加的内容！！！！！！！！！！！！！！！！！！！！！！！！！')
file.close()
file = open('E:/testpy.txt','w')
file.write('这是重写的内容，会清除以前的数据！！！！！！！！！！！！！！！！！！！！！！！！！')
file.close()
file = open('E:/testpy.txt','r')
readlines = file.readlines()