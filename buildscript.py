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
        filePath = mypath+"/" + f
        if isfile(filePath):
            onlyFiles.append(filePath)
    return onlyFiles


def getClassFileNames(mypath):
    mypath = "./app/src/main/java/org/projectkickstart/templates/" + mypath

    onlyFilesNames = []
    for fileName in listdir(mypath):
        onlyFilesNames.append(fileName)
    return onlyFilesNames


def writeGlobalXML(fullPath):
    globalsXml = open(fullPath+"/globals.xml.ftl", "w")
    globalsXmlContent = '''<?xml version="1.0"?>
<globals>
    <global id="resOut" value="${resDir}" />
    <global id="srcOut" value="${srcDir}/${slashedPackageName(packageName)}" />
</globals>
    '''
    globalsXml.write(globalsXmlContent)
    globalsXml.close()


def makedirs(fullPath):
    os.mkdir(fullPath)
    os.mkdir(fullPath+"/root")
    os.mkdir(fullPath+"/root/res")
    os.mkdir(fullPath+"/root/src")
    os.mkdir(fullPath+"/root/res/layout")
    os.mkdir(fullPath+"/root/src/app_package")


def getXml(classFileNames, prefix):
    recipeXmlContent = ""
    for className in classFileNames:
        name = className[len(prefix):]
        recipeXmlContent += '\t<instantiate from="src/classes/'+name+'.ftl"\n\
                    to="${escapeXmlAttribute(srcOut)}/${name}'+name+'"/>\n'
    return recipeXmlContent


def getResXml(name, layoutfrom):
    str = '\t<instantiate from="src/res/'+layoutfrom+'.ftl"\n\
                     to = "${resOut}/layout/'+name+'"/>'
    return str


def writeRecipeXML(classFileNames, prefix, layout, layoutfrom, fullPath):

    recipeXmlContent = f'''<?xml version="1.0"?>
<recipe>
{getXml(classFileNames,prefix)}

{getResXml(layout,layoutfrom)}
</recipe>
'''
    recipeXML = open(fullPath + "/recipe.xml.ftl", "w")
    recipeXML.write(recipeXmlContent)
    recipeXML.close


def generateSrcFiles(files, fileNames, fullPath, name, folder):

    outdir = fullPath+"/root/src/app_package/"

    i = 0
    for file in files:
        outfile = outdir+fileNames[i][len(name):]+'.ftl'
        f = open(outfile, 'w')
        inp = open(file, 'r')

        read = inp.read()

        read = read.replace(name.lower(), "${name?lower_case}")
        read = read.replace(name, "${name}")

        # package org.projectkickstart.templates.activity;

        read = read.replace("org.projectkickstart.templates." + folder,
                            "${packageName}")

        read = read.replace("org.projectkickstart.templates",
                            "${applicationPackage}")

        f.write(read)
        f.close()
        inp.close()
        i = i+1


def generateResFiles(fileName, fullPath, name):
    outdir = fullPath + "/root/res/layout/"
    outfile = outdir + 'layout.xml' + '.ftl'
    f = open(outfile, 'w')
    inp = open('./app/src/main/res/layout/'+fileName, "r")
    read = inp.read()

    read = read.replace(name.lower(), "${name?lower_case}")
    read = read.replace(name, "${name}")

    f.write(read)
    f.close()
    inp.close()
    pass


def just(param):
    return param


def generateTemplateXML(fullPath, templateName, templateDescription, parameterName, parameterDescription):
    templateXML = open(fullPath+"/template.xml", "w")
    templateXmlContent = f'''<template format="4"
    revision="1"
    name="{templateName}"
    description="{templateDescription}">

    <category value="Other"/>

    <parameter id="name"
        name="{parameterName}"
        type="string"
        constraints="class|unique|nonempty"
        default="MyActivity"
        help="{parameterDescription}"/>

    <globals file="globals.xml.ftl" />
    <execute file="recipe.xml.ftl" />

</template>
'''
    templateXML.write(templateXmlContent)
    templateXML.close()


# main
shutil.rmtree("./.templates", ignore_errors=True)
os.mkdir("./.templates")

with open("./buildconfig.yaml", 'r') as stream:
    try:
        for item in yaml.safe_load(stream)['templates']:

            # print(item['type'])
            folder = item['path']
            fullPath = "./.templates/"+item['templatename']

            makedirs(fullPath)

            writeGlobalXML(fullPath)
            writeRecipeXML(
                getClassFileNames(item['path']),
                item['name'], item['layout'], 'layout.xml', fullPath
            )
            generateTemplateXML(
                fullPath, item['templatename'], item['templatedescription'], item['parametername'], item['parameterhelp'])
            generateSrcFiles(getClassFiles(item['path']), getClassFileNames(
                item['path']), fullPath, item['name'], folder)
            generateResFiles(item['layoutfrom'], fullPath, item['name'])

            # print(getClassFiles(item['path']))
            # print(getClassFileNames(item['path']))

    except yaml.YAMLError as exc:
        print(exc)
