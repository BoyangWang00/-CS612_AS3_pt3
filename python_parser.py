import lxml
from lxml import etree
xml_file = lxml.etree.parse("pet.xml")
dtd_validator = lxml.etree.DTD(file="pet.dtd")
is_dtd_valid = dtd_validator(xml_file)
print("is_dtd_valid: ", is_dtd_valid)
schema_validator = lxml.etree.XMLSchema(file="pet.xsd")
is_schema_validate = schema_validator(xml_file)
is_schema_validate
print("is_schema_validate: ", is_schema_validate)