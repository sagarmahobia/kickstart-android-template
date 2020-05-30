from pysrc.models.template import Template
from pysrc.models.config import Config
from dacite import from_dict

class Generator:
    
    __configuration: Config

    def __init__(self, configDict:dict):
        self.__parseConfig(configDict)
       
    def __parseConfig(self, configDict: dict):
        self.__configuration = from_dict(data_class=Config, data=configDict)
        
    def generate(self):
        print(self.__configuration)
        pass
    