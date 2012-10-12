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

package com.usermodule.service.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.usermodule.model.Useraction;
import com.usermodule.service.UseractionLocalServiceUtil;
import com.usermodule.service.base.UseractionServiceBaseImpl;

/**
 * The implementation of the useraction remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.usermodule.service.UseractionService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author admin
 * @see com.usermodule.service.base.UseractionServiceBaseImpl
 * @see com.usermodule.service.UseractionServiceUtil
 */
public class UseractionServiceImpl extends UseractionServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.usermodule.service.UseractionServiceUtil} to access the useraction remote service.
	 */
	public Useraction create(Useraction model) throws SystemException{
		return UseractionLocalServiceUtil.create(model);
	}
}