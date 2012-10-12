<%@page import="com.usermodule.util.UserModuleConstants"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.service.OrganizationLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Organization"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.model.Group"%>

<%User u = (User)request.getAttribute(UserModuleConstants.USER); %>
<%
String bdays[] = new String[20];

String birthday = u.getBirthday().toString();
if(birthday!=null) {	
	SimpleDateFormat formattar = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String bday = formattar.format(u.getBirthday());			
	int i = 0;
	StringTokenizer st = new StringTokenizer(bday,"-, ,:");
	while(st.hasMoreTokens()){
		bdays[i] = st.nextToken();	
		i++;
	}
} 
List<Organization> organ = OrganizationLocalServiceUtil.getUserOrganizations(u.getUserId());
String organizationList = "";

if(organ!=null && organ.size()>0) {
	List<Organization> organization = new ArrayList<Organization>();
	organization.add(organ.get(0));
	Organization orgId = OrganizationLocalServiceUtil.getOrganization(organ.get(0).getOrganizationId());
	organizationList = organizationList + orgId.getName();
	
	while(orgId.getParentOrganizationId()>0){
		Organization pOrg = OrganizationLocalServiceUtil.getOrganization(orgId.getParentOrganizationId());
		organization.add(pOrg);
		organizationList = organizationList + pOrg.getName();
		orgId=OrganizationLocalServiceUtil.getOrganization(orgId.getParentOrganizationId());
	} 
}

List<Group> userGroups = u.getGroups();
String userGroup = "";

for(Group ug : userGroups) {
	userGroup = userGroup + " " + ug.getName();
}
%>
<table style="margin: 0 0 10px 0; width: 100%; font-size: 12px; ">
	<tr>
		<td align="right">
			<div class="taglib-user-display display-style-1>">			
				<%
				String taglibAlt = (u != null) ? HtmlUtil.escapeAttribute(u.getFullName()) : LanguageUtil.get(pageContext, "generic-portrait");
			
				String taglibSrc = null;
				ThemeDisplay td = (ThemeDisplay) request.getAttribute("THEME_DISPLAY");
				String url = u.getDisplayURL(td);
			
				if (u != null) {
					taglibSrc = u.getPortraitURL(td);
				}
				
				%>						
				<span class="user-profile-image">
					<img alt="<%= taglibAlt %>" class="avatar" src="<%= HtmlUtil.escape(taglibSrc) %>" width="65" />
				</span>
			</div>		
		</td>
	</tr>	
	<tr>
		<td width="50%" align="right"><strong>Name : </strong><td>
		<td width="50%" align="left"><%= u.getFirstName()+ " "+u.getLastName() %><td>
	</tr>
	<tr>
		<td width="50%" align="right"><strong>Email : </strong><td>
		<td width="50%" align="left">
			<%= u.getEmailAddress() %>
		<td>
	</tr>
	<tr>
		<td width="50%" align="right"><strong>Date of Birth : </strong><td>
		<td width="50%" align="left">
			<%= bdays[2]+"/"+bdays[1]+"/"+bdays[0]%>
		<td>
	</tr>	
	<tr>
		<td width="50%" align="right"><strong>Member of Organization(s) : </strong><td>
		<td width="50%" align="left">
			<%= organizationList%>
		<td>
	</tr>
		<tr>
		<td width="50%" align="right"><strong>Member of Site(s) : </strong><td>
		<td width="50%" align="left">
			<%= userGroup%>
		<td>
	</tr>
	<tr>
		<td width="50%" align="right"><strong>Jabatan Struktural : </strong><td>
		<td width="50%" align="left">
			<liferay-ui:custom-attribute
				className="<%= User.class.getName() %>"
				classPK="<%= u.getUserId() %>"
				editable="<%= false %>"
				name="Jabatan Struktural"
			/>  
		<td>
	</tr>
	<tr>
		<td width="50%" align="right"><strong>Pangkat : </strong><td>
		<td width="50%" align="left">
			<liferay-ui:custom-attribute
				className="<%= User.class.getName() %>"
				classPK="<%= u.getUserId() %>"
				editable="<%= false %>"
				name="Pangkat"
			/>  
		<td>
	</tr>
</table>