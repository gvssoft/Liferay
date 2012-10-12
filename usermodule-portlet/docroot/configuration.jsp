<%@page import="com.usermodule.util.UserModuleConstants"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<portlet:renderURL var="confURL">
	<portlet:param name="<%= UserModuleConstants.ACTION %>" value="<%= UserModuleConstants.UPDATE_CONFIGURATION_ACTION %>"/>
</portlet:renderURL>
<div style="width:100%;">
	<%
		String errorMessage = (String) request.getAttribute(UserModuleConstants.ERROR_MESSAGE);
		if(errorMessage != null) {
			System.out.println("errorMessage : " +errorMessage);
	%>
		<div class="portlet-msg-error" style="width:95%;"><%=errorMessage%></div><br/>
	<%
			request.removeAttribute(UserModuleConstants.ERROR_MESSAGE);
		}
	%>
	<%
		String infoMessage = (String) request.getAttribute(UserModuleConstants.SUCCESS);
		if(infoMessage != null) {
	%>			
		<div class="portlet-msg-info" style="width:95%;"><%=infoMessage%></div><br/>
	<%
			request.removeAttribute(UserModuleConstants.SUCCESS);
		}
	%>
</div>			
<aui:form action="<%=confURL%>" method="post" name="fm1">
	<aui:fieldset>
		<aui:select label="User Click Action" name="useraction">
			<aui:option label="Details Page" value="Details Page" />
			<aui:option label="Public Page" value="Public Page" />
		</aui:select>
		<aui:button type="submit" />
	</aui:fieldset>
</aui:form>