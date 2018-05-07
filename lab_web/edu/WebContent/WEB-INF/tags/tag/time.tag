<%@tag import="java.util.Calendar"%>
<%@ tag body-content="empty" %>



	<% Calendar cal = Calendar.getInstance();%>
	
	<%= cal.get(Calendar.YEAR) %>-<%= cal.get(Calendar.MONTH) %>-<%= cal.get(Calendar.DATE) %>

