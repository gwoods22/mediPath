<%@ page import="java.util.*" %>
<html>
  <head>
    <link rel="shortcut icon" href="images/favicon.ico" />
		<title>MediPath Results</title>
		<meta charset="utf-8" />
    <link rel="stylesheet" href="main.css" />
  </head>
  <body>
    <h1 align="center">Hospital Recommendations</h1>
    <p>

    	<%
      	List styles = (List)request.getAttribute("styles");
      	out.print("<br/>" + styles.get(0));
      	%>
      	
    </p>
    </body>
  </html>
