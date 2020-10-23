package Placement_package;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.apache.xmlbeans.impl.common.XPath;
import org.w3c.dom.*;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import java.util.*;
public class arnab
{
	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Arnab","root","MyNewPass");
		File file=new File("arnab.xml");
		Statement st = con.createStatement();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document xml=builder.parse(file);
		
		NodeList length= xml.getElementsByTagName("Company");
		
		javax.xml.xpath.XPath xpath = XPathFactory.newInstance().newXPath();
		Object res = xpath.evaluate("/Results/Company",xml,XPathConstants.NODESET);
		
		PreparedStatement stmt = con.prepareStatement("insert into results(Companyname,roundname,studentname,rollno,status, role, offertype) values(?,?,?,?,?,?,?)");

		for (int i=0;i<length.getLength();i++)
		{
		    Node node = length.item(i);
		        List<String> columns = Arrays.asList(
		        getTextContent(node, "Companyname"),
		        getTextContent(node, "roundname"),
		        getTextContent(node, "studentname"),
		        getTextContent(node, "rollno"),
		        getTextContent(node, "status"),
		        getTextContent(node, "role"),
		        getTextContent(node, "offertype") );
		    for (int n = 0 ; n <columns.size() ; n++)
		    {
		    	stmt.setString(n+1, columns.get(n));
		    }
		    stmt.execute();
		}

	}
	static private String getAttrValue(Node node,String attrName)
	{
	    if (!node.hasAttributes())
	    	return "";
	    NamedNodeMap nmap = node.getAttributes();
	    if(nmap==null)
	    	return "";
	    Node n=nmap.getNamedItem(attrName);
	    if (n==null)
	    	return "";
	    return n.getNodeValue();
	}
	static private String getTextContent(Node parentNode,String childName)
	{
	    NodeList nlist = parentNode.getChildNodes();
	    for (int i = 0;i<nlist.getLength();i++)
	    {
	    	Node n = nlist.item(i);
	    	String name = n.getNodeName();
	    	if(name != null && name.equals(childName))
	    		return n.getTextContent();
	    }
	    return "";
	}

}