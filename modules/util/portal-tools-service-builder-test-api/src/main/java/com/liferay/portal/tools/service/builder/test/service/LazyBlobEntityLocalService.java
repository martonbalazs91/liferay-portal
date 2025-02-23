/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.liferay.portal.tools.service.builder.test.service;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.tools.service.builder.test.model.LazyBlobEntity;
import com.liferay.portal.tools.service.builder.test.model.LazyBlobEntityBlob1BlobModel;
import com.liferay.portal.tools.service.builder.test.model.LazyBlobEntityBlob2BlobModel;

import java.io.InputStream;
import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for LazyBlobEntity. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see LazyBlobEntityLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface LazyBlobEntityLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LazyBlobEntityLocalServiceUtil} to access the lazy blob entity local service. Add custom service methods to <code>com.liferay.portal.tools.service.builder.test.service.impl.LazyBlobEntityLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	 * Adds the lazy blob entity to the database. Also notifies the appropriate model listeners.
	 *
	 * @param lazyBlobEntity the lazy blob entity
	 * @return the lazy blob entity that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public LazyBlobEntity addLazyBlobEntity(LazyBlobEntity lazyBlobEntity);

	public LazyBlobEntity addLazyBlobEntity(
		long groupId, byte[] bytes, ServiceContext serviceContext);

	/**
	 * Creates a new lazy blob entity with the primary key. Does not add the lazy blob entity to the database.
	 *
	 * @param lazyBlobEntityId the primary key for the new lazy blob entity
	 * @return the new lazy blob entity
	 */
	@Transactional(enabled = false)
	public LazyBlobEntity createLazyBlobEntity(long lazyBlobEntityId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Deletes the lazy blob entity from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lazyBlobEntity the lazy blob entity
	 * @return the lazy blob entity that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public LazyBlobEntity deleteLazyBlobEntity(LazyBlobEntity lazyBlobEntity);

	/**
	 * Deletes the lazy blob entity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lazyBlobEntityId the primary key of the lazy blob entity
	 * @return the lazy blob entity that was removed
	 * @throws PortalException if a lazy blob entity with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public LazyBlobEntity deleteLazyBlobEntity(long lazyBlobEntityId)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.portal.tools.service.builder.test.model.impl.LazyBlobEntityModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.portal.tools.service.builder.test.model.impl.LazyBlobEntityModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public LazyBlobEntity fetchLazyBlobEntity(long lazyBlobEntityId);

	/**
	 * Returns the lazy blob entity matching the UUID and group.
	 *
	 * @param uuid the lazy blob entity's UUID
	 * @param groupId the primary key of the group
	 * @return the matching lazy blob entity, or <code>null</code> if a matching lazy blob entity could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public LazyBlobEntity fetchLazyBlobEntityByUuidAndGroupId(
		String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public LazyBlobEntityBlob1BlobModel getBlob1BlobModel(
		Serializable primaryKey);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public LazyBlobEntityBlob2BlobModel getBlob2BlobModel(
		Serializable primaryKey);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns a range of all the lazy blob entities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.portal.tools.service.builder.test.model.impl.LazyBlobEntityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lazy blob entities
	 * @param end the upper bound of the range of lazy blob entities (not inclusive)
	 * @return the range of lazy blob entities
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<LazyBlobEntity> getLazyBlobEntities(int start, int end);

	/**
	 * Returns the number of lazy blob entities.
	 *
	 * @return the number of lazy blob entities
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getLazyBlobEntitiesCount();

	/**
	 * Returns the lazy blob entity with the primary key.
	 *
	 * @param lazyBlobEntityId the primary key of the lazy blob entity
	 * @return the lazy blob entity
	 * @throws PortalException if a lazy blob entity with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public LazyBlobEntity getLazyBlobEntity(long lazyBlobEntityId)
		throws PortalException;

	/**
	 * Returns the lazy blob entity matching the UUID and group.
	 *
	 * @param uuid the lazy blob entity's UUID
	 * @param groupId the primary key of the group
	 * @return the matching lazy blob entity
	 * @throws PortalException if a matching lazy blob entity could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public LazyBlobEntity getLazyBlobEntityByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	@Transactional(readOnly = true)
	public InputStream openBlob1InputStream(long lazyBlobEntityId);

	@Transactional(readOnly = true)
	public InputStream openBlob2InputStream(long lazyBlobEntityId);

	/**
	 * Updates the lazy blob entity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param lazyBlobEntity the lazy blob entity
	 * @return the lazy blob entity that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public LazyBlobEntity updateLazyBlobEntity(LazyBlobEntity lazyBlobEntity);

}