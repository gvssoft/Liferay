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

import com.liferay.portal.kernel.exception.SystemException;

import com.usermodule.model.Useraction;

import com.usermodule.service.UseractionLocalServiceUtil;

/**
 * The extended model base implementation for the Useraction service. Represents a row in the &quot;usermodule_Useraction&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link UseractionImpl}.
 * </p>
 *
 * @author admin
 * @see UseractionImpl
 * @see com.usermodule.model.Useraction
 * @generated
 */
public abstract class UseractionBaseImpl extends UseractionModelImpl
	implements Useraction {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a useraction model instance should use the {@link Useraction} interface instead.
	 */
	public void persist() throws SystemException {
		if (this.isNew()) {
			UseractionLocalServiceUtil.addUseraction(this);
		}
		else {
			UseractionLocalServiceUtil.updateUseraction(this);
		}
	}
}