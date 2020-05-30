import yaml
from pysrc.generator import Generator
with open("./buildconfig.yaml", 'r') as stream:
    try:
        g = Generator(yaml.safe_load(stream))
        g.generate()
    except yaml.YAMLError as err:
        print(err)
