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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the useraction local service. This utility wraps {@link com.usermodule.service.impl.UseractionLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author admin
 * @see UseractionLocalService
 * @see com.usermodule.service.base.UseractionLocalServiceBaseImpl
 * @see com.usermodule.service.impl.UseractionLocalServiceImpl
 * @generated
 */
public class UseractionLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.usermodule.service.impl.UseractionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the useraction to the database. Also notifies the appropriate model listeners.
	*
	* @param useraction the useraction
	* @return the useraction that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.usermodule.model.Useraction addUseraction(
		com.usermodule.model.Useraction useraction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addUseraction(useraction);
	}

	/**
	* Creates a new useraction with the primary key. Does not add the useraction to the database.
	*
	* @param userActionId the primary key for the new useraction
	* @return the new useraction
	*/
	public static com.usermodule.model.Useraction createUseraction(
		long userActionId) {
		return getService().createUseraction(userActionId);
	}

	/**
	* Deletes the useraction with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userActionId the primary key of the useraction
	* @return the useraction that was removed
	* @throws PortalException if a useraction with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.usermodule.model.Useraction deleteUseraction(
		long userActionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteUseraction(userActionId);
	}

	/**
	* Deletes the useraction from the database. Also notifies the appropriate model listeners.
	*
	* @param useraction the useraction
	* @return the useraction that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.usermodule.model.Useraction deleteUseraction(
		com.usermodule.model.Useraction useraction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteUseraction(useraction);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static com.usermodule.model.Useraction fetchUseraction(
		long userActionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchUseraction(userActionId);
	}

	/**
	* Returns the useraction with the primary key.
	*
	* @param userActionId the primary key of the useraction
	* @return the useraction
	* @throws PortalException if a useraction with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.usermodule.model.Useraction getUseraction(
		long userActionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUseraction(userActionId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.usermodule.model.Useraction> getUseractions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUseractions(start, end);
	}

	/**
	* Returns the number of useractions.
	*
	* @return the number of useractions
	* @throws SystemException if a system exception occurred
	*/
	public static int getUseractionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUseractionsCount();
	}

	/**
	* Updates the useraction in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param useraction the useraction
	* @return the useraction that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.usermodule.model.Useraction updateUseraction(
		com.usermodule.model.Useraction useraction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateUseraction(useraction);
	}

	/**
	* Updates the useraction in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param useraction the useraction
	* @param merge whether to merge the useraction with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the useraction that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.usermodule.model.Useraction updateUseraction(
		com.usermodule.model.Useraction useraction, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateUseraction(useraction, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.usermodule.model.Useraction create(
		com.usermodule.model.Useraction model)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().create(model);
	}

	public static void clearService() {
		_service = null;
	}

	public static UseractionLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					UseractionLocalService.class.getName());

			if (invokableLocalService instanceof UseractionLocalService) {
				_service = (UseractionLocalService)invokableLocalService;
			}
			else {
				_service = new UseractionLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(UseractionLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(UseractionLocalService service) {
	}

	private static UseractionLocalService _service;
}