<%-- 
    Document   : contentEdit_
    Created on : Oct 31, 2016, 12:21:16 AM
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
            <h3 class="p12">Edit Complete</h3>
            <div class="page1-box3">           

    <%-- start web service invocation --%><hr/>
    <%
    try {
        
	serverpack.MvWebService_Service service = new serverpack.MvWebService_Service();
	serverpack.MvWebService port = service.getMvWebServicePort();
	 // TODO initialize WS operation arguments here
        int nodeID = Integer.parseInt(request.getParameter("number"));
	java.lang.String title = request.getParameter("editTitle");
        java.lang.String year = request.getParameter("editYear");
        java.lang.String types = request.getParameter("editTypes");
        java.lang.String time = request.getParameter("editTime");
        java.lang.String director = request.getParameter("editDir");
        // TODO process result here
        //out.println("Result::"+title+"<br>"+year+"<br>"+types+"<br>"+time+"<br>"+director);
        java.lang.String result = port.save(nodeID, title, year, types, time, director);
        String[] show = result.split(":",6);
    
    %>
            <table width="428">
                <tr>
                    <th width="181"><div align="left">NodeID: </div><br/></th>
                    <td width="231"><input type="hidden" name="number" value="<%=request.getParameter("number")%>" />
                        <%=request.getParameter("number")%></td>
                </tr><br/>
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
    
    <%
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
        </div></article>
        </div>
        </div>
        </section>
    </body>
</html>
