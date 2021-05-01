<%
    //this will give the message
	String message = (String) session.getAttribute("message");

	if(message != null)
	{
		
%>	

<div class="alert alert-secondary" role="alert">

<!-- this line will print the message -->
  <%=message %>  
</div>


<%
	}
	//this will remove the session
	session.removeAttribute("message");
%>
