from dataclasses import dataclass

@dataclass
class Template:
    type:str
    path:str
    name:str
    layout:str
    layoutFrom:str
    templateName:str
    templateDescription:str
    parameterName:str
    parameterHelp:str
    