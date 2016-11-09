<%-- 
    Document   : contentB
    Created on : Oct 30, 2016, 5:18:01 AM
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
            <h3 class="p12">Search Movie</h3>
            <div class="page1-box3">  
            <form>

                <select name="category" class="button2">
                    <option value="title">title</option>
                    <option value="year">year</option>
                    <option value="types">type</option>
                    <option value="director">director</option>
                </select>
                <input type="text" name="search">
                <input class="button2" type="submit" value="Search">
            </form>
            <br />
            <br />
            <%-- start web service invocation --%>
    
            <%
            try {
                String category_name = request.getParameter("category");
                String search_name = request.getParameter("search");
                serverpack.MvWebService_Service service = new serverpack.MvWebService_Service();
                serverpack.MvWebService port = service.getMvWebServicePort();
                // TODO initialize WS operation arguments here
                java.lang.String category = category_name;
                java.lang.String search = search_name;
                // TODO process result here
                java.lang.String result = port.movie(category, search);
                out.println("Category = " + category_name);
                out.println("<br>Search = " + search_name);%>
            </div>
        </article>
        <%
            String show = result;
            for (String s: show.split("--")){                

         %>
    
        <article class="grid_6">
           <div class="page1-box3">
               <% out.println(s); 
                  //for (String id: s.split("")){   }
                  String[] NodeID = s.split("::",3);
                  //int nodeID = Integer.parseInt(NodeID[0]);
                  if (NodeID[0].equals("Selete Search Pls.")){
                      out.println(NodeID[1]);
                  }
                  
               %> 
               <form action="Delete.jsp" method="POST">
               <input type="hidden" name="number" value="<%=NodeID[1]%>" />
               <input class="button2 fright" name="act" type="submit" value="Delete" />
               </form>
               <form action="Edit.jsp" method="POST">
               <input type="hidden" name="number" value="<%=NodeID[1]%>" />
               <input class="button2 fright" name="act" type="submit" value="Edit" />
               </form>
           </div>
        </article>
        <%
        }
        //out.println(show);
        } catch (Exception ex) {
              // TODO handle custom exceptions here
        }
        %>
        <%-- end web service invocation --%>
        </div>
        </div>    
        </section>
    </body>
</html>
