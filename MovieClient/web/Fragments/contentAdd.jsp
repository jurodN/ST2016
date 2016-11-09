<%-- 
    Document   : contentAdd
    Created on : Oct 30, 2016, 2:52:40 PM
    Author     : nuyuyii
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <section id="content">
        <div class="container_12 ">
        <div class="wrapper">
        <article class="grid_12">   
            <h3 class="p12">Add Movie</h3>
            <div class="page1-box3"> 
            <form>
                <form>
                    <table width="428">
                        <tr><th width="181"><div align="left">Title: </div><br/></th>
                            <td ><input type="text" name="addTitle"/></td>
                        </tr>
                        <tr><th width="181"><div align="left">Year: </div><br/></th>
                            <td><input type="text" name="addYear"/></td>
                        </tr>
                        <tr><th width="181"><div align="left">Types: </div><br/></th>
                            <td><input type="text" name="addTypes"/></td>
                        </tr>
                        <tr><th width="181"><div align="left">Time: </div><br/></th>
                            <td><input type="text" name="addTime"/></td>
                        <tr><th width="181"><div align="left">Director: </div><br/></th>
                            <td><input type="text" name="AddDirec"/></td>
                        </tr>
                    </table>
                    <input class="button2" type="submit" value="addMovie"/>
                </form>
            </form>

            <%-- start web service invocation --%>    
            <br />
            <br />
            <%
            try {
                serverpack.MvWebService_Service service = new serverpack.MvWebService_Service();
                serverpack.MvWebService port = service.getMvWebServicePort();
                 // TODO initialize WS operation arguments here
                java.lang.String title = request.getParameter("addTitle");
                java.lang.String year = request.getParameter("addYear");
                java.lang.String types = request.getParameter("addTypes");
                int time = Integer.parseInt(request.getParameter("addTime"));
                java.lang.String director = request.getParameter("AddDirec");
                // TODO process result here
                //java.lang.String result = port.deleteMovie(time);	
                java.lang.String result = port.addMovie(title, year, types, time, director);
                String[] show = result.split(":",6);
                %>
            </div>
        </article>
        <article class="grid_12">
            <h3 class="p12">Result</h3>
            <div class="page1-box3"> 
                <table width="428">
                <tr>
                    <th width="181"><div align="left">Title: </div><br/></th>
                    <td ><%=show[1]%></td>
                </tr>
                <tr>
                    <th width="181"><div align="left">Year: </div><br/></th>
                    <td ><%=show[2]%></td>
                </tr>
                <tr>
                    <th width="181"><div align="left">Types: </div><br/></th>
                    <td ><%=show[3]%></td>
                </tr>
                <tr>
                    <th width="181"><div align="left">Time: </div><br/></th>
                    <td ><%=show[4]%></td>
                </tr>
                <tr>
                    <th width="181"><div align="left">Director: </div><br/></th>
                    <td ><%=show[5]%></td>
                </tr>
            </table>
            <p>
                
        <%
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }%></p>
            
            </div>
        </article>
        <%-- end web service invocation --%>    
        </div>
        </div>
        </section>
    
    </body>
</html>
