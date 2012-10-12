<%@page import="com.usermodule.util.UserModuleConstants"%>
<div>
	<div class="pageContent">
		<%
			String errorMessage = (String) request.getAttribute(UserModuleConstants.ERROR_MESSAGE);
			if(errorMessage != null) {
		%>
			<div class="portlet-msg-error"><%=errorMessage%></div><br/>
		<%
				request.removeAttribute(UserModuleConstants.ERROR_MESSAGE);
			}
		%>
	</div>
</div>