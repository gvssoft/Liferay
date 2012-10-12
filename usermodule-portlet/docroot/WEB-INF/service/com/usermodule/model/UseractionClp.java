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

package com.usermodule.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.usermodule.service.UseractionLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author admin
 */
public class UseractionClp extends BaseModelImpl<Useraction>
	implements Useraction {
	public UseractionClp() {
	}

	public Class<?> getModelClass() {
		return Useraction.class;
	}

	public String getModelClassName() {
		return Useraction.class.getName();
	}

	public long getPrimaryKey() {
		return _userActionId;
	}

	public void setPrimaryKey(long primaryKey) {
		setUserActionId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_userActionId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userActionId", getUserActionId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userclickaction", getUserclickaction());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userActionId = (Long)attributes.get("userActionId");

		if (userActionId != null) {
			setUserActionId(userActionId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String userclickaction = (String)attributes.get("userclickaction");

		if (userclickaction != null) {
			setUserclickaction(userclickaction);
		}
	}

	public long getUserActionId() {
		return _userActionId;
	}

	public void setUserActionId(long userActionId) {
		_userActionId = userActionId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getUserclickaction() {
		return _userclickaction;
	}

	public void setUserclickaction(String userclickaction) {
		_userclickaction = userclickaction;
	}

	public BaseModel<?> getUseractionRemoteModel() {
		return _useractionRemoteModel;
	}

	public void setUseractionRemoteModel(BaseModel<?> useractionRemoteModel) {
		_useractionRemoteModel = useractionRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			UseractionLocalServiceUtil.addUseraction(this);
		}
		else {
			UseractionLocalServiceUtil.updateUseraction(this);
		}
	}

	@Override
	public Useraction toEscapedModel() {
		return (Useraction)Proxy.newProxyInstance(Useraction.class.getClassLoader(),
			new Class[] { Useraction.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		UseractionClp clone = new UseractionClp();

		clone.setUserActionId(getUserActionId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setUserclickaction(getUserclickaction());

		return clone;
	}

	public int compareTo(Useraction useraction) {
		long primaryKey = useraction.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		UseractionClp useraction = null;

		try {
			useraction = (UseractionClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = useraction.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{userActionId=");
		sb.append(getUserActionId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", userclickaction=");
		sb.append(getUserclickaction());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.usermodule.model.Useraction");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>userActionId</column-name><column-value><![CDATA[");
		sb.append(getUserActionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userclickaction</column-name><column-value><![CDATA[");
		sb.append(getUserclickaction());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _userActionId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _userclickaction;
	private BaseModel<?> _useractionRemoteModel;
}