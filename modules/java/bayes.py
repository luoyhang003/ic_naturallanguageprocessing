# -*- coding:gb2312 -*-

from numpy import *

def loadDataSet():

    postingList=[['��', '��Ҫ', 'һ��', '����', '����', '���'],['����', '��', '��', 'ʳ��', '����', '��', '��', '�׷�'],['ƽʱ', '��Ҫ', '��', '����', '��', '����'],['����', '����', '����', 'һ��', '��'],['��', '��Ҫ', 'һ��', '��', '��ǩ', '��', '���'],['��', 'ƽʱ', '��', 'ϲ��', '��', '����']]

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
	testEntry = ['ֻ��','��','��','����']
	thisDoc = array(setOfWords2Vec(myVocabList, testEntry))
	print testEntry,'����Ϊ',classifyNB(thisDoc, p0V, p1V, pAB)
	
testingNB()		

file = open('E:/testpy.txt','a')
file.write('����׷�ӵ����ݣ�������������������������������������������������')
file.close()
file = open('E:/testpy.txt','w')
file.write('������д�����ݣ��������ǰ�����ݣ�������������������������������������������������')
file.close()
file = open('E:/testpy.txt','r')
readlines = file.readlines()

