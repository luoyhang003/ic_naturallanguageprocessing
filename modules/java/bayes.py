# -*- coding:gb2312 -*-

from numpy import *

def loadDataSet():

    postingList=[['我', '想要', '一款', '播放', '音乐', '软件'],['今天', '我', '在', '食堂', '吃了', '两', '碗', '米饭'],['平时', '想要', '听', '音乐', '来', '放松'],['超超', '今天', '吃了', '一个', '饼'],['我', '想要', '一个', '有', '便签', '的', '软件'],['我', '平时', '很', '喜欢', '听', '音乐']]

    classVec = [1,0,1,0,0,1]
    return postingList,classVec

def createVocabList(dataSet):
    vocabSet = set([])
    for document in dataSet:
        vocabSet = vocabSet | set(document)
    return list(vocabSet)

def setOfWords2Vec(vocabList, inputSet):
    returnVec = [0]*len(vocabList)
    for word in inputSet:
        if word in vocabList:
            returnVec[vocabList.index(word)] = 1
        else: print "the word: %s is not in my Vocabulary!" % word
    return returnVec

def trainNB0(trainMatrix,trainCategory):
    numTrainDocs = len(trainMatrix)
    numWords = len(trainMatrix[0])
    pAbusive = sum(trainCategory)/float(numTrainDocs)
    p0Num = ones(numWords); p1Num = ones(numWords)
    p0Denom = 2.0; p1Denom = 2.0
    for i in range(numTrainDocs):
        if trainCategory[i] == 1:
            p1Num += trainMatrix[i]
            p1Denom += sum(trainMatrix[i])
        else:
            p0Num += trainMatrix[i]
            p0Denom += sum(trainMatrix[i])
    p1Vect = log(p1Num/p1Denom)
    p0Vect = log(p0Num/p0Denom)
    return p0Vect,p1Vect,pAbusive

def classifyNB(vec2Classify, p0Vec, p1Vec, pClass1):
	p1 = sum(vec2Classify * p1Vec) + log(pClass1)
	p0 = sum(vec2Classify * p0Vec) + log(1.0 - pClass1)
	if p1 > p0:
		return 1
	else:
		return 0
		
def testingNB():
	listOPosts, listClasses = loadDataSet()
	myVocabList = createVocabList(listOPosts)
	trainMat = []
	for postInDoc in listOPosts:
		trainMat.append(setOfWords2Vec(myVocabList, postInDoc))
	p0V,p1V,pAB = trainNB0(array(trainMat),array(listClasses))
	testEntry = ['只是','想','听','音乐']
	thisDoc = array(setOfWords2Vec(myVocabList, testEntry))
	print testEntry,'分类为',classifyNB(thisDoc, p0V, p1V, pAB)
	
testingNB()		

file = open('E:/testpy.txt','a')
file.write('这是追加的内容！！！！！！！！！！！！！！！！！！！！！！！！！')
file.close()
file = open('E:/testpy.txt','w')
file.write('这是重写的内容，会清除以前的数据！！！！！！！！！！！！！！！！！！！！！！！！！')
file.close()
file = open('E:/testpy.txt','r')
readlines = file.readlines()

