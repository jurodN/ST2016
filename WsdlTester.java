import java.net.HttpURLConnection;
import java.net.URL;

public class WsdlTester {

    public static void main(String[] args) {

//        isWSDLAvailable  wstvip = new WSDLtestvip();
       boolean result = isWSDLAvailable("movies.xml?wsdl");

        System.out.println(result);

    }

    private boolean isWSDLAvailable(String wsdlAddr) {
            HttpURLConnection c = null;
            try {
                URL u = new URL(wsdlAddr);
                c = (HttpURLConnection) u.openConnection();
                c.setRequestMethod("HEAD");
                c.getInputStream();
                return c.getResponseCode() == 200;
            } catch (Exception e) {
                return false;
            } finally {
                if (c != null) c.disconnect();
            }    
    }

}
