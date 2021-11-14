import java.io.File;

import javax.xml.*;
import javax.xml.parsers.*;
import javax.xml.validation.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.dom.DOMSource;

import org.w3c.dom.*;

import org.xml.sax.*;

class domParserSchema{

    public static void main(String[] args) throws Exception{
        
    // parse an XML document into a DOM tree
    DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    Document document = parser.parse(new File("pet.xml"));

    // create a SchemaFactory capable of understanding WXS schemas
    SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

    // load a WXS schema, represented by a Schema instance
    Source schemaFile = new StreamSource(new File("pet.xsd"));
    Schema schema = factory.newSchema(schemaFile);

    // create a Validator instance, which can be used to validate an instance document
    Validator validator = schema.newValidator();

    // validate the DOM tree
    try {
        validator.validate(new DOMSource(document));
    } catch (SAXException e) {
        // instance document is invalid!
        System.out.println("document is invalid!" + e.getMessage());
        
    }

    System.out.println("document is valid!");

    }
}