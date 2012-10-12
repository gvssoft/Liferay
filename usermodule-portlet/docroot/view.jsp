<%@page import="java.util.LinkedHashMap"%>
<%@page import="com.liferay.portal.model.Group"%>
<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Organization"%>
<%@page import="com.liferay.portal.service.OrganizationLocalServiceUtil"%>
<%@page import="com.usermodule.service.UseractionLocalServiceUtil"%>
<%@page import="com.usermodule.model.Useraction"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.model.UserConstants"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.model.Phone"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<%@page import="com.usermodule.util.UserModuleConstants"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="java.util.List"%>

<portlet:defineObjects />
<%
/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
%>
<style>
.pm_header {
		background:	gray; 
		color:	white; 
		border:	white; 
		font-weight: bold;
		padding-left: 5px;
	}
</style>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:renderURL var="searchUrl">
	<portlet:param name="<%= UserModuleConstants.ACTION %>" value="<%= UserModuleConstants.SEARCH_ACTION %>"/>
</portlet:renderURL>

<portlet:renderURL var="configurationUrl">
	<portlet:param name="<%= UserModuleConstants.ACTION %>" value="<%= UserModuleConstants.CONFIGURATION_ACTION %>"/>
</portlet:renderURL>

<form id="search_form" action="<%=searchUrl%>" method="post">
<table style="margin: 0 0 10px 0;">			
<tr>
	<%
	String searchBook = (String)request.getAttribute(UserModuleConstants.SEARCH_KEYWORD);
	if(searchBook==null) {
		searchBook = "";
	}	
	List<Organization> orgList = OrganizationLocalServiceUtil.getOrganizations(0, OrganizationLocalServiceUtil.getOrganizationsCount());
	List<Group> groupList = GroupLocalServiceUtil.getGroups(0, GroupLocalServiceUtil.getGroupsCount());
	%>
	<td align="left" style="width:100%">
		<table style="width:100%;align:left">
		<tr>
			<td align="center" style="width:60px;"><strong><%=LanguageUtil.get(pageContext,"keyword")%></strong></td>
			<td align="left" style="width:150px;">
				<input type="text" id="searchBook" name="searchBook" style="width:150px;" value="<%=searchBook%>"/>				
			</td>
			<td style="width:2%"></td>
			<td>
				<select id="special" name="special">
				  <option value="All Users">All Users</option>
				  <%for(Organization o : orgList) { %>
				  	<option value=<%="org_"+o.getOrganizationId()%>><%=o.getName()%></option>
				  <%}%>
				   <%for(Group g : groupList) { 
				   if(g.getType()==1) {%>
				  	<option value=<%="group_"+g.getGroupId()%>><%=g.getName()%></option>
				  <%}
				  }%>
				</select>
			</td>
			<td style="width:2%"></td>
			<td align="center" style="width:60px;">
				<input type="submit" value="<%=LanguageUtil.get(pageContext,"search") %>" />
			</td>	
			<td style="width:2%"></td>		
			<td align="center" style="width:60px;">
				<a href="<%=configurationUrl%>"><input type="button" value="<%=LanguageUtil.get(pageContext,"configuration") %>" /></a>
			</td>
		</tr>
		</table>						
	</td>						
</tr>
</table>
</form>    
<% 
	List<User> userList = null;
	Integer count = 0;       
	Integer delta = 0;       
	Integer cur = 0;
	
	if (request.getAttribute(UserModuleConstants.USER_LIST) != null) {
		userList = (List<User>) request.getAttribute(UserModuleConstants.USER_LIST);
		count = userList.size();        
	    delta = (Integer)request.getAttribute(UserModuleConstants.DELTA);        
	    cur = (Integer)request.getAttribute(UserModuleConstants.CUR); 
	}	
    
	if(cur == null){
        cur = 1;
    }
    if(delta == null){
        delta = 20;
    }
    if(count == null){
        count = 0;
    }   
    
  	PortletURL portletURL = renderResponse.createRenderURL();
  	
  	portletURL.setParameter(UserModuleConstants.ACTION, UserModuleConstants.SEARCH_ACTION);
  	portletURL.setParameter(UserModuleConstants.SEARCH_KEYWORD, searchBook);
  	
  	List<Useraction> ua = UseractionLocalServiceUtil.getUseractions(0, UseractionLocalServiceUtil.getUseractionsCount());
  	
  	String userclickaction = "Details Page";
  	
  	for(Useraction u : ua) {
  		userclickaction = u.getUserclickaction();
  	}  	
%>

<liferay-ui:search-container iteratorURL="<%= portletURL %>" delta="<%= delta %>" emptyResultsMessage="No Users Found.">

<% 
int end = searchContainer.getEnd(); 
if(searchContainer.getEnd()>userList.size()) {
	end = userList.size();
}%>
 
    <liferay-ui:search-container-results results="<%=userList.subList(searchContainer.getStart(), end)%>" total="<%= count %>"/>
     
    <liferay-ui:search-container-row className="com.liferay.portal.model.User" escapedModel="<%= true %>" keyProperty="userId" modelVar="u" rowIdProperty="screenName">     
    	             
    	<liferay-ui:search-container-column-text name="Picture">        	

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
				
				<%if(userclickaction.equals("Details Page")) { %>
				<a href="<portlet:renderURL>
								<portlet:param name="<%= UserModuleConstants.ACTION %>" value="<%= UserModuleConstants.DETAIL_VIEW %>"/>
								<portlet:param name="<%= UserModuleConstants.USER_ID %>" value="<%= String.valueOf(u.getUserId()) %>"/>
							</portlet:renderURL>">
				<% } else { %>				
				<a href="<%= url %>">
				<% } %>				
					<span class="user-profile-image">
						<img alt="<%= taglibAlt %>" class="avatar" src="<%= HtmlUtil.escape(taglibSrc) %>" width="65" />
					</span>
				</a>
				</div>

        </liferay-ui:search-container-column-text>
        <liferay-ui:search-container-column-text name="Name" orderable="<%=true%>"> 
        	<%= u.getFirstName()+ " "+u.getLastName() %>
        </liferay-ui:search-container-column-text>
        <liferay-ui:search-container-column-text name="Email" orderable="<%=true%>" property="emailAddress">         
   		</liferay-ui:search-container-column-text>
   		<liferay-ui:search-container-column-text name="Jabatan Struktural">
   			<liferay-ui:custom-attribute
					className="<%= User.class.getName() %>"
					classPK="<%= u.getUserId() %>"
					editable="<%= false %>"
					name="Jabatan Struktural"
				/>            
   		</liferay-ui:search-container-column-text>
   		<liferay-ui:search-container-column-text name="Jabatan Fungsional">
   			<liferay-ui:custom-attribute
					className="<%= User.class.getName() %>"
					classPK="<%= u.getUserId() %>"
					editable="<%= false %>"
					name="Jabatan Fungsional"
				/>            
   		</liferay-ui:search-container-column-text>
   		<liferay-ui:search-container-column-text name="Phone">
   			<%List<Phone> phoneList = u.getPhones();
			String phoneNumbers = "";
			for(Phone p : phoneList) {
				phoneNumbers = phoneNumbers + " " + p.getNumber();
			} %>    
			<%=phoneNumbers %>      
   		</liferay-ui:search-container-column-text>
    </liferay-ui:search-container-row>
     
    <%
    	portletURL.setParameter(UserModuleConstants.CUR, String.valueOf(cur));        
    	searchContainer.setIteratorURL(portletURL);    
    %>
    <liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />		
	
</liferay-ui:search-container>