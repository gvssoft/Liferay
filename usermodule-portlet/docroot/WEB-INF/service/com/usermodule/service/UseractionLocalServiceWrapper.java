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
 * This class is a wrapper for {@link UseractionLocalService}.
 * </p>
 *
 * @author    admin
 * @see       UseractionLocalService
 * @generated
 */
public class UseractionLocalServiceWrapper implements UseractionLocalService,
	ServiceWrapper<UseractionLocalService> {
	public UseractionLocalServiceWrapper(
		UseractionLocalService useractionLocalService) {
		_useractionLocalService = useractionLocalService;
	}

	/**
	* Adds the useraction to the database. Also notifies the appropriate model listeners.
	*
	* @param useraction the useraction
	* @return the useraction that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.usermodule.model.Useraction addUseraction(
		com.usermodule.model.Useraction useraction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _useractionLocalService.addUseraction(useraction);
	}

	/**
	* Creates a new useraction with the primary key. Does not add the useraction to the database.
	*
	* @param userActionId the primary key for the new useraction
	* @return the new useraction
	*/
	public com.usermodule.model.Useraction createUseraction(long userActionId) {
		return _useractionLocalService.createUseraction(userActionId);
	}

	/**
	* Deletes the useraction with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userActionId the primary key of the useraction
	* @return the useraction that was removed
	* @throws PortalException if a useraction with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.usermodule.model.Useraction deleteUseraction(long userActionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _useractionLocalService.deleteUseraction(userActionId);
	}

	/**
	* Deletes the useraction from the database. Also notifies the appropriate model listeners.
	*
	* @param useraction the useraction
	* @return the useraction that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.usermodule.model.Useraction deleteUseraction(
		com.usermodule.model.Useraction useraction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _useractionLocalService.deleteUseraction(useraction);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _useractionLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _useractionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _useractionLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _useractionLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _useractionLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.usermodule.model.Useraction fetchUseraction(long userActionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _useractionLocalService.fetchUseraction(userActionId);
	}

	/**
	* Returns the useraction with the primary key.
	*
	* @param userActionId the primary key of the useraction
	* @return the useraction
	* @throws PortalException if a useraction with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.usermodule.model.Useraction getUseraction(long userActionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _useractionLocalService.getUseraction(userActionId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _useractionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the useractions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of useractions
	* @param end the upper bound of the range of useractions (not inclusive)
	* @return the range of useractions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.usermodule.model.Useraction> getUseractions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _useractionLocalService.getUseractions(start, end);
	}

	/**
	* Returns the number of useractions.
	*
	* @return the number of useractions
	* @throws SystemException if a system exception occurred
	*/
	public int getUseractionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _useractionLocalService.getUseractionsCount();
	}

	/**
	* Updates the useraction in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param useraction the useraction
	* @return the useraction that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.usermodule.model.Useraction updateUseraction(
		com.usermodule.model.Useraction useraction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _useractionLocalService.updateUseraction(useraction);
	}

	/**
	* Updates the useraction in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param useraction the useraction
	* @param merge whether to merge the useraction with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the useraction that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.usermodule.model.Useraction updateUseraction(
		com.usermodule.model.Useraction useraction, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _useractionLocalService.updateUseraction(useraction, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _useractionLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_useractionLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _useractionLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public com.usermodule.model.Useraction create(
		com.usermodule.model.Useraction model)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _useractionLocalService.create(model);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public UseractionLocalService getWrappedUseractionLocalService() {
		return _useractionLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedUseractionLocalService(
		UseractionLocalService useractionLocalService) {
		_useractionLocalService = useractionLocalService;
	}

	public UseractionLocalService getWrappedService() {
		return _useractionLocalService;
	}

	public void setWrappedService(UseractionLocalService useractionLocalService) {
		_useractionLocalService = useractionLocalService;
	}

	private UseractionLocalService _useractionLocalService;
}