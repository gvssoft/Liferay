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

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Useraction}.
 * </p>
 *
 * @author    admin
 * @see       Useraction
 * @generated
 */
public class UseractionWrapper implements Useraction, ModelWrapper<Useraction> {
	public UseractionWrapper(Useraction useraction) {
		_useraction = useraction;
	}

	public Class<?> getModelClass() {
		return Useraction.class;
	}

	public String getModelClassName() {
		return Useraction.class.getName();
	}

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

	/**
	* Returns the primary key of this useraction.
	*
	* @return the primary key of this useraction
	*/
	public long getPrimaryKey() {
		return _useraction.getPrimaryKey();
	}

	/**
	* Sets the primary key of this useraction.
	*
	* @param primaryKey the primary key of this useraction
	*/
	public void setPrimaryKey(long primaryKey) {
		_useraction.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the user action ID of this useraction.
	*
	* @return the user action ID of this useraction
	*/
	public long getUserActionId() {
		return _useraction.getUserActionId();
	}

	/**
	* Sets the user action ID of this useraction.
	*
	* @param userActionId the user action ID of this useraction
	*/
	public void setUserActionId(long userActionId) {
		_useraction.setUserActionId(userActionId);
	}

	/**
	* Returns the company ID of this useraction.
	*
	* @return the company ID of this useraction
	*/
	public long getCompanyId() {
		return _useraction.getCompanyId();
	}

	/**
	* Sets the company ID of this useraction.
	*
	* @param companyId the company ID of this useraction
	*/
	public void setCompanyId(long companyId) {
		_useraction.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this useraction.
	*
	* @return the user ID of this useraction
	*/
	public long getUserId() {
		return _useraction.getUserId();
	}

	/**
	* Sets the user ID of this useraction.
	*
	* @param userId the user ID of this useraction
	*/
	public void setUserId(long userId) {
		_useraction.setUserId(userId);
	}

	/**
	* Returns the user uuid of this useraction.
	*
	* @return the user uuid of this useraction
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _useraction.getUserUuid();
	}

	/**
	* Sets the user uuid of this useraction.
	*
	* @param userUuid the user uuid of this useraction
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_useraction.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this useraction.
	*
	* @return the user name of this useraction
	*/
	public java.lang.String getUserName() {
		return _useraction.getUserName();
	}

	/**
	* Sets the user name of this useraction.
	*
	* @param userName the user name of this useraction
	*/
	public void setUserName(java.lang.String userName) {
		_useraction.setUserName(userName);
	}

	/**
	* Returns the create date of this useraction.
	*
	* @return the create date of this useraction
	*/
	public java.util.Date getCreateDate() {
		return _useraction.getCreateDate();
	}

	/**
	* Sets the create date of this useraction.
	*
	* @param createDate the create date of this useraction
	*/
	public void setCreateDate(java.util.Date createDate) {
		_useraction.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this useraction.
	*
	* @return the modified date of this useraction
	*/
	public java.util.Date getModifiedDate() {
		return _useraction.getModifiedDate();
	}

	/**
	* Sets the modified date of this useraction.
	*
	* @param modifiedDate the modified date of this useraction
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_useraction.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the userclickaction of this useraction.
	*
	* @return the userclickaction of this useraction
	*/
	public java.lang.String getUserclickaction() {
		return _useraction.getUserclickaction();
	}

	/**
	* Sets the userclickaction of this useraction.
	*
	* @param userclickaction the userclickaction of this useraction
	*/
	public void setUserclickaction(java.lang.String userclickaction) {
		_useraction.setUserclickaction(userclickaction);
	}

	public boolean isNew() {
		return _useraction.isNew();
	}

	public void setNew(boolean n) {
		_useraction.setNew(n);
	}

	public boolean isCachedModel() {
		return _useraction.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_useraction.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _useraction.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _useraction.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_useraction.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _useraction.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_useraction.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new UseractionWrapper((Useraction)_useraction.clone());
	}

	public int compareTo(com.usermodule.model.Useraction useraction) {
		return _useraction.compareTo(useraction);
	}

	@Override
	public int hashCode() {
		return _useraction.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.usermodule.model.Useraction> toCacheModel() {
		return _useraction.toCacheModel();
	}

	public com.usermodule.model.Useraction toEscapedModel() {
		return new UseractionWrapper(_useraction.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _useraction.toString();
	}

	public java.lang.String toXmlString() {
		return _useraction.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_useraction.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Useraction getWrappedUseraction() {
		return _useraction;
	}

	public Useraction getWrappedModel() {
		return _useraction;
	}

	public void resetOriginalValues() {
		_useraction.resetOriginalValues();
	}

	private Useraction _useraction;
}