<%-- 
    Document   : contentA
    Created on : Oct 30, 2016, 5:17:37 AM
    Author     : nuyuyii
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <section id="content">
        <div class="container_12 ">
        <div class="wrapper">
        <article class="grid_12">   
            <h3 class="p12">Delete Movie</h3>
            <div class="page1-box3">  
            <p>Enter NodeID</p>
            <form>
                <input type="text" name="number"/><br />
                <br /> 
                <input class="button2" type="submit" value="Delete"/>
            </form>

            <%-- start web service invocation --%>    
            <p>
            <br />
            <br />
            <%
            try {
                serverpack.MvWebService_Service service = new serverpack.MvWebService_Service();
                serverpack.MvWebService port = service.getMvWebServicePort();
                 // TODO initialize WS operation arguments here
                int nodeID = Integer.parseInt(request.getParameter("number"));
                // TODO process result here
                java.lang.String result = port.deleteMovie(nodeID);
                out.println("Result: "+result);
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }
            %>
            <%-- end web service invocation --%>
            </p></div></article>
        </div>
        </div>
        </section>
    </body>
</html>
