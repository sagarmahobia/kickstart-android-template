from dataclasses import dataclass
from pysrc.models.template import Template

@dataclass
class Config:
    classSrcDir: str
    resSrcDir: str
    outDir: str
    templates: list