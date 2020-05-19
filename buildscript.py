import os
import shutil
import yaml 

import glob
from os import listdir
from os.path import isfile, join


def getClassFiles(mypath):
    mypath = "./app/src/main/java/org/projectkickstart/templates/" + mypath

    onlyFiles = []
    for f in listdir(mypath):
        filePath = mypath+"/"+ f
        if isfile(filePath):
            onlyFiles.append(filePath)
    return onlyFiles
  

shutil.rmtree("./template",ignore_errors=True)

os.mkdir("./template")
# f = open("./template/test.txt","w")
 
with open("./buildconfig.yaml", 'r') as stream:
    try:
        for item in yaml.safe_load(stream)['templates']:
            print(item['name'])
            print(item['path'])
            print(item['type'])
            print(item['layout'])

            print(getClassFiles(item['path']))
            
    except yaml.YAMLError as exc:
        print(exc)