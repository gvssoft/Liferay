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

package com.usermodule.service.persistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.usermodule.NoSuchUseractionException;

import com.usermodule.model.Useraction;
import com.usermodule.model.impl.UseractionImpl;
import com.usermodule.model.impl.UseractionModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the useraction service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author admin
 * @see UseractionPersistence
 * @see UseractionUtil
 * @generated
 */
public class UseractionPersistenceImpl extends BasePersistenceImpl<Useraction>
	implements UseractionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UseractionUtil} to access the useraction persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UseractionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UseractionModelImpl.ENTITY_CACHE_ENABLED,
			UseractionModelImpl.FINDER_CACHE_ENABLED, UseractionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UseractionModelImpl.ENTITY_CACHE_ENABLED,
			UseractionModelImpl.FINDER_CACHE_ENABLED, UseractionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UseractionModelImpl.ENTITY_CACHE_ENABLED,
			UseractionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the useraction in the entity cache if it is enabled.
	 *
	 * @param useraction the useraction
	 */
	public void cacheResult(Useraction useraction) {
		EntityCacheUtil.putResult(UseractionModelImpl.ENTITY_CACHE_ENABLED,
			UseractionImpl.class, useraction.getPrimaryKey(), useraction);

		useraction.resetOriginalValues();
	}

	/**
	 * Caches the useractions in the entity cache if it is enabled.
	 *
	 * @param useractions the useractions
	 */
	public void cacheResult(List<Useraction> useractions) {
		for (Useraction useraction : useractions) {
			if (EntityCacheUtil.getResult(
						UseractionModelImpl.ENTITY_CACHE_ENABLED,
						UseractionImpl.class, useraction.getPrimaryKey()) == null) {
				cacheResult(useraction);
			}
			else {
				useraction.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all useractions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(UseractionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(UseractionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the useraction.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Useraction useraction) {
		EntityCacheUtil.removeResult(UseractionModelImpl.ENTITY_CACHE_ENABLED,
			UseractionImpl.class, useraction.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Useraction> useractions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Useraction useraction : useractions) {
			EntityCacheUtil.removeResult(UseractionModelImpl.ENTITY_CACHE_ENABLED,
				UseractionImpl.class, useraction.getPrimaryKey());
		}
	}

	/**
	 * Creates a new useraction with the primary key. Does not add the useraction to the database.
	 *
	 * @param userActionId the primary key for the new useraction
	 * @return the new useraction
	 */
	public Useraction create(long userActionId) {
		Useraction useraction = new UseractionImpl();

		useraction.setNew(true);
		useraction.setPrimaryKey(userActionId);

		return useraction;
	}

	/**
	 * Removes the useraction with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userActionId the primary key of the useraction
	 * @return the useraction that was removed
	 * @throws com.usermodule.NoSuchUseractionException if a useraction with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Useraction remove(long userActionId)
		throws NoSuchUseractionException, SystemException {
		return remove(Long.valueOf(userActionId));
	}

	/**
	 * Removes the useraction with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the useraction
	 * @return the useraction that was removed
	 * @throws com.usermodule.NoSuchUseractionException if a useraction with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Useraction remove(Serializable primaryKey)
		throws NoSuchUseractionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Useraction useraction = (Useraction)session.get(UseractionImpl.class,
					primaryKey);

			if (useraction == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUseractionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(useraction);
		}
		catch (NoSuchUseractionException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Useraction removeImpl(Useraction useraction)
		throws SystemException {
		useraction = toUnwrappedModel(useraction);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, useraction);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(useraction);

		return useraction;
	}

	@Override
	public Useraction updateImpl(com.usermodule.model.Useraction useraction,
		boolean merge) throws SystemException {
		useraction = toUnwrappedModel(useraction);

		boolean isNew = useraction.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, useraction, merge);

			useraction.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(UseractionModelImpl.ENTITY_CACHE_ENABLED,
			UseractionImpl.class, useraction.getPrimaryKey(), useraction);

		return useraction;
	}

	protected Useraction toUnwrappedModel(Useraction useraction) {
		if (useraction instanceof UseractionImpl) {
			return useraction;
		}

		UseractionImpl useractionImpl = new UseractionImpl();

		useractionImpl.setNew(useraction.isNew());
		useractionImpl.setPrimaryKey(useraction.getPrimaryKey());

		useractionImpl.setUserActionId(useraction.getUserActionId());
		useractionImpl.setCompanyId(useraction.getCompanyId());
		useractionImpl.setUserId(useraction.getUserId());
		useractionImpl.setUserName(useraction.getUserName());
		useractionImpl.setCreateDate(useraction.getCreateDate());
		useractionImpl.setModifiedDate(useraction.getModifiedDate());
		useractionImpl.setUserclickaction(useraction.getUserclickaction());

		return useractionImpl;
	}

	/**
	 * Returns the useraction with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the useraction
	 * @return the useraction
	 * @throws com.liferay.portal.NoSuchModelException if a useraction with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Useraction findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the useraction with the primary key or throws a {@link com.usermodule.NoSuchUseractionException} if it could not be found.
	 *
	 * @param userActionId the primary key of the useraction
	 * @return the useraction
	 * @throws com.usermodule.NoSuchUseractionException if a useraction with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Useraction findByPrimaryKey(long userActionId)
		throws NoSuchUseractionException, SystemException {
		Useraction useraction = fetchByPrimaryKey(userActionId);

		if (useraction == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + userActionId);
			}

			throw new NoSuchUseractionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				userActionId);
		}

		return useraction;
	}

	/**
	 * Returns the useraction with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the useraction
	 * @return the useraction, or <code>null</code> if a useraction with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Useraction fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the useraction with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userActionId the primary key of the useraction
	 * @return the useraction, or <code>null</code> if a useraction with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Useraction fetchByPrimaryKey(long userActionId)
		throws SystemException {
		Useraction useraction = (Useraction)EntityCacheUtil.getResult(UseractionModelImpl.ENTITY_CACHE_ENABLED,
				UseractionImpl.class, userActionId);

		if (useraction == _nullUseraction) {
			return null;
		}

		if (useraction == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				useraction = (Useraction)session.get(UseractionImpl.class,
						Long.valueOf(userActionId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (useraction != null) {
					cacheResult(useraction);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(UseractionModelImpl.ENTITY_CACHE_ENABLED,
						UseractionImpl.class, userActionId, _nullUseraction);
				}

				closeSession(session);
			}
		}

		return useraction;
	}

	/**
	 * Returns all the useractions.
	 *
	 * @return the useractions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Useraction> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Useraction> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the useractions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of useractions
	 * @param end the upper bound of the range of useractions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of useractions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Useraction> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Useraction> list = (List<Useraction>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_USERACTION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERACTION;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Useraction>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Useraction>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the useractions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Useraction useraction : findAll()) {
			remove(useraction);
		}
	}

	/**
	 * Returns the number of useractions.
	 *
	 * @return the number of useractions
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_USERACTION);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the useraction persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.usermodule.model.Useraction")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Useraction>> listenersList = new ArrayList<ModelListener<Useraction>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Useraction>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(UseractionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = UseractionPersistence.class)
	protected UseractionPersistence useractionPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_USERACTION = "SELECT useraction FROM Useraction useraction";
	private static final String _SQL_COUNT_USERACTION = "SELECT COUNT(useraction) FROM Useraction useraction";
	private static final String _ORDER_BY_ENTITY_ALIAS = "useraction.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Useraction exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(UseractionPersistenceImpl.class);
	private static Useraction _nullUseraction = new UseractionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Useraction> toCacheModel() {
				return _nullUseractionCacheModel;
			}
		};

	private static CacheModel<Useraction> _nullUseractionCacheModel = new CacheModel<Useraction>() {
			public Useraction toEntityModel() {
				return _nullUseraction;
			}
		};
}