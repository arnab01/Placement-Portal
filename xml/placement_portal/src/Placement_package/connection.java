package Placement_package;

import java.io.File;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;


public class connection {
	 public static boolean validateXMLSchema(String xsdPath, String xmlPath){
	      try {
	            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
	            Schema schema = factory.newSchema(new File(xsdPath));
	            Validator validator = schema.newValidator();
	            validator.validate(new StreamSource(new File(xmlPath)));
	      } 
	      catch (IOException e){
	         System.out.println("Exception: "+e.getMessage());
	         return false;
	      }
	      catch(SAXException e1){
	         System.out.println("SAX Exception: "+e1.getMessage());
	         return false;
	      }
			
	      return true;
		
	   }

	public static void main(String[] args) throws Exception {
		
		if(args.length !=2){
	         System.out.println("Usage : XSDValidator <arnab.xsd> <arnab.xml>" );
	      } 
		else 
		{
	         boolean isValid = validateXMLSchema(args[0],args[1]);
	         
	         if(isValid){
	            System.out.println(args[1] + " is valid against " + args[0]);
	         } else {
	            System.out.println(args[1] + " is not valid against " + args[0]);
	         }
	      }
		
		
		
        
	}

}