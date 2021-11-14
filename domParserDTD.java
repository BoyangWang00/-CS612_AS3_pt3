import java.io.IOException;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import org.xml.sax.*;
import org.w3c.dom.*;


class domParserDTD{

    public static void main(String[] args) throws Exception{

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);

        DocumentBuilder parser = factory.newDocumentBuilder();

        parser.setErrorHandler(new ErrorHandler() {
            @Override
            public void error(SAXParseException exception) throws SAXException {
                exception.printStackTrace();
            }
            @Override
            public void fatalError(SAXParseException exception) throws SAXException {
                exception.printStackTrace();
            }

            @Override
            public void warning(SAXParseException exception) throws SAXException {
                exception.printStackTrace();
            }
        });

        Document document = parser.parse("pet.xml");

        System.out.println("document is valid!");

    }
}