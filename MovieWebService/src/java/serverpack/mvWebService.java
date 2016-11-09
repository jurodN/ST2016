/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverpack;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.io.FileOutputStream;
import java.io.InputStream;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

//transformer
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.dom.DOMSource; 
import javax.xml.transform.stream.StreamResult;
/**
 *
 * @author nuyuyii
 */
@WebService(serviceName = "mvWebService")
public class mvWebService {

    /**
     * Web service operation 
     */
    public static NodeList callXML(int func) throws SAXException, IOException, ParserConfigurationException {  
        // call path xml file to parse document
        URL url = mvWebService.class.getResource("/serverpack/movies.xml");
        String xmlFile = url.getPath();
        // File xmlFile = new File("/home/nuyuyii/NetBeansProjects/Pro_ST/MovieWebService/web/movies.xml");  
        // InputStream xmlFile = mvWebService.class.getResourceAsStream("/serverpack/movies.xml");
        try {
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(xmlFile);
            
            if (func==1){
                NodeList nList = doc.getElementsByTagName("film");
                return nList;
            } 
            

        } catch (SAXException se) {
            // Error generated by this application
            // (or a parser-initialization error)
            se.printStackTrace();
        } catch (ParserConfigurationException pce) {
            // Parser with specified options 
            // cannot be built
            pce.printStackTrace();
        } catch (IOException ie) {
            // I/O error
            ie.printStackTrace();
        }    
        return null;
    }
    
    @WebMethod(operationName = "checklogin")
    public String checklogin(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        String result = "";
        String user[] = {"user1"};
        String pass[] = {"1234"};
        if(user[0].equals(username) && pass[0].equals(password)){
            result = "ยินดีต้อนรับเข้าสู่ระบบ";
            return result;
        } else {
            result = "ไม่สามารถเข้าสู่ระบบได้";
            return result;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getsqr")
    public int getsqr(@WebParam(name = "no") final int no) {
        //TODO write your implementation code here:
        return no*no;
    }


    /**
     * Web service operation
     */
    @WebMethod(operationName = "serchbyID")
    public String serchbyID(@WebParam(name = "nodeID") final int nodeID) throws Exception  {
        String result = "";
        NodeList nList = callXML(1);
        
        Element nfilm = (Element) nList.item(nodeID-1);
          NodeList childfilm = nfilm.getChildNodes();
          for (int j= 0; j < childfilm.getLength(); j++){
            Node temp = childfilm.item(j);
            NodeList childtemp = temp.getChildNodes();
            if(childtemp.getLength() > 1){
                for (int i = 0; i<childtemp.getLength();i++){
                    Node child = childtemp.item(i);
                    NodeList childnode = child.getChildNodes();
                    if (i==1){
                        result = String.format("%s%s: %s\n", result , temp.getNodeName(), child.getTextContent());
                    }else if (childnode.getLength()>0){
                        result = String.format("%s       %s\n", result, child.getTextContent());
                    }
                }
                
            //We got more childs; Let's visit them as well
            }else if(childtemp.getLength() > 0){
                result = String.format("%s%s: %s\n", result, temp.getNodeName(), temp.getTextContent());
            }
          }
        return result;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "DeleteMovie")
    public String DeleteMovie(@WebParam(name = "nodeID") final int nodeID) throws Exception  {
        String result="";
        try {
            // call path xml file to parse document
            URL url = mvWebService.class.getResource("/serverpack/movies.xml");
            String xmlFile = url.getPath();
            // File xmlFile = new File("movies.xml");
            // InputStream xmlFile = mvWebService.class.getResourceAsStream("/serverpack/movies.xml");
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(xmlFile);
            NodeList nList = doc.getElementsByTagName("film"); 
            
            result = "XML file delete successfully";
            Element nfilm = (Element) nList.item(nodeID-1);
            nfilm.getParentNode().removeChild(nfilm);
            //Use a Transformer for output        
            SaveXML(doc);    
            return result;
        } catch (Exception e) {
            result = "Error Delete Movie! Selete NodeID again Pls.";
            e.printStackTrace();

        }
        return result;
    }
    
    public static void SaveXML(Document doc)throws Exception  {
        URL url = mvWebService.class.getResource("/serverpack/UpdatemoviesSr.xml");
        String path = url.getPath();
        // String filepath = "/serverpack/UpdatemoviesSr.xml";
        // Use a Transformer for output
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer transformer = tFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new FileOutputStream(path));
        //StreamResult result = new StreamResult(new File(filepath));//System.out);
        transformer.transform(source, result);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addMovie")
    public String addMovie(@WebParam(name = "title") final String title, @WebParam(name = "year") final String year, @WebParam(name = "types") final String types, @WebParam(name = "time") int time, @WebParam(name = "director") final String director) throws Exception{
        String result="";
        try {
            // call path xml file to parse document
            // File xmlFile = new File("movies.xml");
            // InputStream xmlFile = mvWebService.class.getResourceAsStream("/serverpack/movies.xml");
            URL url = mvWebService.class.getResource("/serverpack/movies.xml");
            String xmlFile = url.getPath();
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(xmlFile);
            Element movie = (Element) doc.getDocumentElement();
            Element newfilm = doc.createElement("film");
            // Tranform Time: interger to String
            String mins = time+" min";
            // add Element to film
            newfilm.appendChild(getMovieElement(doc, "title", title));
            newfilm.appendChild(getMovieElement(doc, "year", year));
            newfilm.appendChild(getMovieElement(doc, "types", ""));
            newfilm.appendChild(getMovieElement(doc, "time", mins));
            newfilm.appendChild(getMovieElement(doc, "director", director));
            Element addtype = (Element) newfilm.getElementsByTagName("types").item(0);
            // add element types movie
            // int index = 1;
            for (String type: types.split(",")){
                String name = "type";//+index;
                addtype.appendChild(getMovieElement(doc, name, type));
                // index++;
            }
            result = String.format(":%s:%s:%s:%s:%s", title,year,types,mins,director);

            // add element film to movie 
            movie.appendChild(newfilm);
            SaveXML(doc);    
            return result;
        } catch (Exception e) {
            result = "Error Add Movie! Try again Pls.";
            e.printStackTrace();

        }
        return result;
    }
    
    private static Node getMovieElement(Document doc, String name, String value){
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        System.out.println("Insert OK "+node.getTextContent());
        return node;
    }
    
    @WebMethod(operationName = "movie")
    public String movie(@WebParam(name = "category") String category, @WebParam(name = "search") String search) {
        String re;
        try {
            re = "";
            //File inputFile = new File("movies.xml");
            //InputStream xmlFile = mvWebService.class.getResourceAsStream("/serverpack/movies.xml");
            URL url = mvWebService.class.getResource("/serverpack/movies.xml");
            String xmlFile = url.getPath();
            
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("film");
            
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                Element eElement = (Element) nNode;
                if (eElement.getElementsByTagName(category).item(0).getTextContent().toLowerCase().contains(search.toLowerCase())) {
                    re = re + "<br> NodeID: ::" + (temp+1)+"::";
                    re = re + "<br> Title: " + eElement.getElementsByTagName("title").item(0).getTextContent();
                    re = re + "<br> Year: " + eElement.getElementsByTagName("year").item(0).getTextContent();
                    re = re + "<br> Types: " + eElement.getElementsByTagName("types").item(0).getTextContent();
                    re = re + "<br> Time: " + eElement.getElementsByTagName("time").item(0).getTextContent();
                    re = re + "<br> Director: " + eElement.getElementsByTagName("director").item(0).getTextContent();
                    re = re + "<br> --";
                }
            }
            return re;
        } catch (Exception e) {
            search = "Selete Search Pls.";
            e.printStackTrace();

        }
        return search;        
    }
    
    @WebMethod(operationName = "Edit")
    public String EditMovie(@WebParam(name = "nodeID") final int nodeID) throws Exception  {
        String result="";
        try {
            // call path xml file to parse document
            URL url = mvWebService.class.getResource("/serverpack/movies.xml");
            String xmlFile = url.getPath();
            // InputStream xmlFile = mvWebService.class.getResourceAsStream("/serverpack/movies.xml");
            // File xmlFile = new File("/home/nuyuyii/NetBeansProjects/Pro_ST/MovieWebService/src/java/serverpack/movies.xml");
            
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("film");         

            //String result = "";
            Element nfilm =  (Element) nList.item(nodeID-1);
            NodeList childfilm = nfilm.getChildNodes();
            for (int j= 0; j < childfilm.getLength(); j++){
                Node temp = childfilm.item(j);
                NodeList childtemp = temp.getChildNodes();
                if(childtemp.getLength() > 1){
                    for (int i = 0; i<childtemp.getLength();i++){
                        Node child = childtemp.item(i);
                        NodeList childnode = child.getChildNodes();
                        if (i==1){
                            result = String.format("%s:%s", result, child.getTextContent());
                        }else if (childnode.getLength()>0){
                            result = String.format("%s,%s", result, child.getTextContent());
                        }
                    }

                //We got more childs; Let's visit them as well
            }else if(childtemp.getLength() > 0){
                result = String.format("%s:%s", result, temp.getTextContent());
            }
          }
            return result;
        } catch (Exception e) {
            result = "Selete NodeID Pls.";
            e.printStackTrace();

        }
        return result;
    }
    
    @WebMethod(operationName = "Save")
    public String SaveMovie(@WebParam(name = "nodeID") int nodeID, @WebParam(name = "title") final String _title,
            @WebParam(name = "year") final String _year, @WebParam(name = "types") final String _types, @WebParam(name = "time") final String _time, @WebParam(name = "director") final String _director) throws Exception {
        //NodeList nList = callXML();
        //String del = ""+DeleteMovie(nodeID);
        //String result = ""+addMovie(_title,_year,_types,_time,_director);
        String result="";
        try {
            // call path xml file to parse document
            URL url = mvWebService.class.getResource("/serverpack/movies.xml");
            String xmlFile = url.getPath();
            //File xmlFile = new File("movies.xml");
            //InputStream xmlFile = mvWebService.class.getResourceAsStream("/serverpack/movies.xml");
            
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(xmlFile);
            Element movie = (Element) doc.getDocumentElement();
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("film");         

            String re = "";
            //String mins =_time+"min";
            Element nfilm =  (Element) nList.item(nodeID-1);
            Node title = nfilm.getElementsByTagName("title").item(0).getFirstChild();
            title.setNodeValue(_title);
            Node year = nfilm.getElementsByTagName("year").item(0).getFirstChild();
            year.setNodeValue(_year);    
            Node time = nfilm.getElementsByTagName("time").item(0).getFirstChild();
            time.setNodeValue(_time);  
            Node dir = nfilm.getElementsByTagName("director").item(0).getFirstChild();
            dir.setNodeValue(_director);  
            Node alltype = nfilm.getElementsByTagName("types").item(0);
            NodeList atype = alltype.getChildNodes();
            for (int i= 0; i < atype.getLength(); i++){ 
                Node child = atype.item(i);
                if (child.getNodeName() == "type" ){
                    alltype.removeChild(child);
                }
            }
            for (String type: _types.split(",")){
                String name = "type";//+index;
                alltype.appendChild(getMovieElement(doc, name, type));
            }
            result = String.format(":%s:%s:%s:%s:%s", _title,_year,_types,_time,_director);
            //movie.appendChild(newfilm);
            SaveXML(doc);
            return result;
        //SaveXML(doc);  
        } catch (Exception e) {
            result = "Selete NodeID Pls.";
            e.printStackTrace();

        }
        return result;
    }
    
}