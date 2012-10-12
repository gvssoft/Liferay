package com.usermodule.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.persistence.GroupUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.usermodule.model.Useraction;
import com.usermodule.service.UseractionLocalServiceUtil;
import com.usermodule.service.persistence.UseractionUtil;
import com.usermodule.util.UserModuleConstants;

public class UserModulePortlet extends MVCPortlet {

	static Log log = LogFactoryUtil.getLog(UserModulePortlet.class);

	@Override
	public void render(RenderRequest request, RenderResponse response) throws PortletException, IOException {
		try {
			String action = ParamUtil.getString(request, UserModuleConstants.ACTION);
			String includeFile = "/view.jsp";					

			if(action.equals(UserModuleConstants.SEARCH_ACTION)) {
				search(request);
				includeFile = "/view.jsp";
			} 
			else if(action.equals(UserModuleConstants.DETAIL_VIEW)) {

				String user_id = ParamUtil.getString(request, UserModuleConstants.USER_ID);

				User u = UserLocalServiceUtil.getUser(Long.parseLong(user_id));
				request.setAttribute(UserModuleConstants.USER, u);
				includeFile = "/detailview.jsp";
			}
			else if(action.equals(UserModuleConstants.CONFIGURATION_ACTION)) {
				includeFile = "/configuration.jsp";
			}
			else if(action.equals(UserModuleConstants.UPDATE_CONFIGURATION_ACTION)) {

				updateConfiguration(request);

				request.setAttribute(UserModuleConstants.SUCCESS, "Configuration updated successfully");
				includeFile = "/configuration.jsp";
			}
			else {
				//get all users list
				List<User> userList = UserLocalServiceUtil.getUsers(0, UserLocalServiceUtil.getUsersCount());				
				request.setAttribute(UserModuleConstants.USER_LIST, userList);
				request.setAttribute(UserModuleConstants.CUR, 1);
			} 
			include(includeFile, request, response);
		}
		catch(Exception e) {
			e.printStackTrace();
			request.setAttribute(UserModuleConstants.ERROR_MESSAGE, "Wrong usage");
			include("/error.jsp", request, response);
		}
	}

	private void updateConfiguration(RenderRequest request) throws Exception {
		String useraction = ParamUtil.getString(request, "useraction");
		ThemeDisplay td = (ThemeDisplay) request.getAttribute("THEME_DISPLAY");

		List<Useraction> ua = UseractionLocalServiceUtil.getUseractions(0, UseractionLocalServiceUtil.getUseractionsCount());

		Useraction u = null;

		if(ua!=null && ua.size()>0) {
			u = (Useraction)(ua.get(0));
			u.setModifiedDate(new Date());
		}
		else {
			long id = CounterLocalServiceUtil.increment(Useraction.class.getName());
			u = UseractionUtil.create(id);	
			u.setCreateDate(new Date());
		}
		u.setCompanyId(td.getCompanyId());
		u.setUserId(td.getUserId());
		u.setUserName(td.getUser().getFirstName());
		u.setUserclickaction(useraction);

		UseractionLocalServiceUtil.create(u);
	}

	private void search(RenderRequest request) throws Exception {
		String keyword = ParamUtil.getString(request, UserModuleConstants.SEARCHBOOK);
		String special = ParamUtil.getString(request, UserModuleConstants.SPECIAL);

		Integer cur = 1;
		String specialId = "";

		if(ParamUtil.getString(request, UserModuleConstants.CUR).length()>0 && ParamUtil.getString(request, UserModuleConstants.CUR)!=null) {
			cur = Integer.parseInt(ParamUtil.getString(request, UserModuleConstants.CUR));
		}

		ThemeDisplay td = (ThemeDisplay) request.getAttribute("THEME_DISPLAY");
		User user = UserLocalServiceUtil.getUser(td.getUserId());

		LinkedHashMap userParams = new LinkedHashMap();

		userParams.put("Nip", keyword);
		userParams.put("Alamat", keyword);
		userParams.put("emailAddress", keyword);
		userParams.put("number_", keyword);

		if(!special.equals("All Users")) {
			specialId = special.substring(special.indexOf("_")+1, special.length());
			if(special.startsWith("org")) {
				userParams.put("usersOrgs", new Long(specialId));
			}
		}
		System.out.println("special : "+special);

		boolean asc = true;
		Sort sort = new Sort("lastName", Sort.STRING_TYPE, asc);

		Hits hits = UserLocalServiceUtil.search(user.getCompanyId(), keyword, WorkflowConstants.STATUS_APPROVED, userParams, 0, UserLocalServiceUtil.getUsersCount(),  sort);
		List<User> users = new ArrayList<User>();

		List<Document> hitsList = hits.toList();

		for (Document doc : hitsList) {
			long userId = GetterUtil.getLong(doc.get(Field.USER_ID));

			if(special.startsWith("group")) {
				if(UserLocalServiceUtil.hasGroupUser(new Long(specialId), userId)) {
					users.add(UserLocalServiceUtil.getUserById(userId));
				}
			}
			else {
				users.add(UserLocalServiceUtil.getUserById(userId));
			}
		}
		request.setAttribute(UserModuleConstants.USER_LIST, users);
		request.setAttribute(UserModuleConstants.SEARCH_KEYWORD, keyword);
		request.setAttribute(UserModuleConstants.CUR, cur);		
	}
}
