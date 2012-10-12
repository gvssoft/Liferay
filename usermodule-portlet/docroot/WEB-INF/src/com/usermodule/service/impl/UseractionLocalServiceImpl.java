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
import com.usermodule.service.base.UseractionLocalServiceBaseImpl;
import com.usermodule.service.persistence.UseractionUtil;

/**
 * The implementation of the useraction local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.usermodule.service.UseractionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author admin
 * @see com.usermodule.service.base.UseractionLocalServiceBaseImpl
 * @see com.usermodule.service.UseractionLocalServiceUtil
 */
public class UseractionLocalServiceImpl extends UseractionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.usermodule.service.UseractionLocalServiceUtil} to access the useraction local service.
	 */
	public Useraction create(Useraction model) throws SystemException{
		UseractionUtil.update(model, true);
		return model;
	}
}