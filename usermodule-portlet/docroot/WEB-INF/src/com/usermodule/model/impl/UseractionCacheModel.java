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

package com.usermodule.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.usermodule.model.Useraction;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Useraction in entity cache.
 *
 * @author admin
 * @see Useraction
 * @generated
 */
public class UseractionCacheModel implements CacheModel<Useraction>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{userActionId=");
		sb.append(userActionId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", userclickaction=");
		sb.append(userclickaction);
		sb.append("}");

		return sb.toString();
	}

	public Useraction toEntityModel() {
		UseractionImpl useractionImpl = new UseractionImpl();

		useractionImpl.setUserActionId(userActionId);
		useractionImpl.setCompanyId(companyId);
		useractionImpl.setUserId(userId);

		if (userName == null) {
			useractionImpl.setUserName(StringPool.BLANK);
		}
		else {
			useractionImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			useractionImpl.setCreateDate(null);
		}
		else {
			useractionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			useractionImpl.setModifiedDate(null);
		}
		else {
			useractionImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (userclickaction == null) {
			useractionImpl.setUserclickaction(StringPool.BLANK);
		}
		else {
			useractionImpl.setUserclickaction(userclickaction);
		}

		useractionImpl.resetOriginalValues();

		return useractionImpl;
	}

	public long userActionId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String userclickaction;
}