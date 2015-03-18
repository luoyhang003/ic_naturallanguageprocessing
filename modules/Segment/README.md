#分词系统

****


##概述
- 将用户输入的中文自然语言进行分词
- 给每一个分词的结果标注词性

****


##详细设计
>
**使用中科院NTPIR中文语义库进行分词，并对目标词语进行词性标注，在此基础上可以加入用户个人词典，来使得软件生成过程中得到的目标词汇更加准确**

****


##接口设计

###SegmentToString

***将目标语句分词，并以String返回***

#####static String SegmentToString(String target);

执行周期    |   所需类库   | 
:--------: | :--------: | 
方法结束    | NTPIR.dll  | 


#####返回值

**Return String if succeed. Otherwise return null**

#####参数
*target*  String类型 待分词字符串

#####注意
**如果程序执行期间类库初始化失败也会出现返回值为null**

###SegmentToString

***将目标语句分词，并输出到文件***

#####static void SegmentToFile(String target, String filename);

执行周期    |   所需类库   | 
:--------: | :--------: | 
方法结束    | NTPIR.dll  | 


#####返回值

**void**

#####参数

*target*  String类型 待分词字符串

*filename* String类型 输出文件文件名

#####注意

**输出文件位置位于项目的根目录**

**如果期间出现错误将不会有文件输出**

****

*Created By Yuanhang Luo*
 
<luoyhang003@hotmail.com>

Jan 31，2015
