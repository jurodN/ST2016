<%-- 
    Document   : contentEdit
    Created on : Oct 30, 2016, 7:22:46 PM
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
            <h3 class="p12">Edit Movie</h3>
            <div class="page1-box3"> 
            <p>Enter NodeID</p>
            <form>
                <input type="text" name="number"/><br />
                <br /> 
                <input class="button2" type="submit" value="Edit"/>
            </form>

            <%-- start web service invocation --%>    
            <br />
            <br />
            <%
            try {
                serverpack.MvWebService_Service service = new serverpack.MvWebService_Service();
                serverpack.MvWebService port = service.getMvWebServicePort();
                 // TODO initialize WS operation arguments herei
                int nodeID = Integer.parseInt(request.getParameter("number"));
                // TODO process result here
                java.lang.String result = port.edit(nodeID);
                out.println("Result: "+result);
                String show = result;
                String[] re = show.split(":",6);
                //for (String s: show.split(":")){ 
            %>
            <form action="Edit_.jsp" method="POST">
            <table width="428">
                <tr>
                    <th width="181"><div align="left">NodeID: </div><br/></th>
                    <td width="231"><input type="hidden" name="number" value="<%=request.getParameter("number")%>" />
                        <%=request.getParameter("number")%></td>
                </tr><br/>
                <tr>
                    <th width="181"><div align="left">Title: </div><br/></th>
                    <td ><input type="text" name="editTitle" size="20" value="<%=re[1]%>"></td>
                </tr>
                <tr>
                    <th width="181"><div align="left">Year: </div><br/></th>
                    <td ><input type="text" name="editYear" size="20" value="<%=re[2]%>"></td>
                </tr>
                <tr>
                    <th width="181"><div align="left">Types: </div><br/></th>
                    <td ><input type="text" name="editTypes" size="20" value="<%=re[3]%>"></td>
                </tr>
                <tr>
                    <th width="181"><div align="left">Time: </div><br/></th>
                    <td ><input type="text" name="editTime" size="20" value="<%=re[4]%>"></td>
                </tr>
                <tr>
                    <th width="181"><div align="left">Director: </div><br/></th>
                    <td ><input type="text" name="editDir" size="20" value="<%=re[5]%>"></td>
                </tr>
            </table>
                <input type="submit" class="button2" value="save" />                
            </form>
            <%               
               // }
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }
            %>            
            <%-- end web service invocation --%>
        </div></article>
        </div>
        </div>
        </section>
    </body>
</html>
