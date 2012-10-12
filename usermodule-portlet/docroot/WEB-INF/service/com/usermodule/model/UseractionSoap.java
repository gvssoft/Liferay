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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.usermodule.service.http.UseractionServiceSoap}.
 *
 * @author    admin
 * @see       com.usermodule.service.http.UseractionServiceSoap
 * @generated
 */
public class UseractionSoap implements Serializable {
	public static UseractionSoap toSoapModel(Useraction model) {
		UseractionSoap soapModel = new UseractionSoap();

		soapModel.setUserActionId(model.getUserActionId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUserclickaction(model.getUserclickaction());

		return soapModel;
	}

	public static UseractionSoap[] toSoapModels(Useraction[] models) {
		UseractionSoap[] soapModels = new UseractionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UseractionSoap[][] toSoapModels(Useraction[][] models) {
		UseractionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UseractionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UseractionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UseractionSoap[] toSoapModels(List<Useraction> models) {
		List<UseractionSoap> soapModels = new ArrayList<UseractionSoap>(models.size());

		for (Useraction model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UseractionSoap[soapModels.size()]);
	}

	public UseractionSoap() {
	}

	public long getPrimaryKey() {
		return _userActionId;
	}

	public void setPrimaryKey(long pk) {
		setUserActionId(pk);
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

	private long _userActionId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _userclickaction;
}