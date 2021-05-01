<%@page import="com.niit.connection.FactoryProvider" %>
<%@page import="jdk.nashorn.internal.runtime.regexp.JoniRegExp.Factory"%>

<html>
<head>

<title>Job Portal</title>

<!-- common style  -->
<%@include file="component/common_cs_js.jsp" %>
</head>

<body>

<!-- navbar component -->
<%@include file="component/navbar.jsp" %>


<h2>Hello World!</h2>
<%
out.println(FactoryProvider.getFactory());
%>

</body>
</html>
