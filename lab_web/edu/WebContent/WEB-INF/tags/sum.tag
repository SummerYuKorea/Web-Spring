<%@ tag body-content="empty"%>

<%@ attribute name="num1" required="true"%>
<%@ attribute name="num2" required="true"%>

<%PageContext.%>

<p>${num1+num2}</p>

<% out.print(request.getMethod());
%>