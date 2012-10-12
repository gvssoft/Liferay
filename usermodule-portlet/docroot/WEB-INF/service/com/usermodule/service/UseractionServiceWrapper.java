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

package com.usermodule.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link UseractionService}.
 * </p>
 *
 * @author    admin
 * @see       UseractionService
 * @generated
 */
public class UseractionServiceWrapper implements UseractionService,
	ServiceWrapper<UseractionService> {
	public UseractionServiceWrapper(UseractionService useractionService) {
		_useractionService = useractionService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _useractionService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_useractionService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _useractionService.invokeMethod(name, parameterTypes, arguments);
	}

	public com.usermodule.model.Useraction create(
		com.usermodule.model.Useraction model)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _useractionService.create(model);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public UseractionService getWrappedUseractionService() {
		return _useractionService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedUseractionService(UseractionService useractionService) {
		_useractionService = useractionService;
	}

	public UseractionService getWrappedService() {
		return _useractionService;
	}

	public void setWrappedService(UseractionService useractionService) {
		_useractionService = useractionService;
	}

	private UseractionService _useractionService;
}