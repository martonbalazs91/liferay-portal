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

package com.liferay.portal.workflow.kaleo.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for KaleoNode. This utility wraps
 * <code>com.liferay.portal.workflow.kaleo.service.impl.KaleoNodeLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see KaleoNodeLocalService
 * @generated
 */
public class KaleoNodeLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.portal.workflow.kaleo.service.impl.KaleoNodeLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the kaleo node to the database. Also notifies the appropriate model listeners.
	 *
	 * @param kaleoNode the kaleo node
	 * @return the kaleo node that was added
	 */
	public static com.liferay.portal.workflow.kaleo.model.KaleoNode
		addKaleoNode(
			com.liferay.portal.workflow.kaleo.model.KaleoNode kaleoNode) {

		return getService().addKaleoNode(kaleoNode);
	}

	public static com.liferay.portal.workflow.kaleo.model.KaleoNode
			addKaleoNode(
				long kaleoDefinitionVersionId,
				com.liferay.portal.workflow.kaleo.definition.Node node,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addKaleoNode(
			kaleoDefinitionVersionId, node, serviceContext);
	}

	/**
	 * Creates a new kaleo node with the primary key. Does not add the kaleo node to the database.
	 *
	 * @param kaleoNodeId the primary key for the new kaleo node
	 * @return the new kaleo node
	 */
	public static com.liferay.portal.workflow.kaleo.model.KaleoNode
		createKaleoNode(long kaleoNodeId) {

		return getService().createKaleoNode(kaleoNodeId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			createPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	public static void deleteCompanyKaleoNodes(long companyId) {
		getService().deleteCompanyKaleoNodes(companyId);
	}

	public static void deleteKaleoDefinitionVersionKaleoNodes(
		long kaleoDefinitionVersionId) {

		getService().deleteKaleoDefinitionVersionKaleoNodes(
			kaleoDefinitionVersionId);
	}

	/**
	 * Deletes the kaleo node from the database. Also notifies the appropriate model listeners.
	 *
	 * @param kaleoNode the kaleo node
	 * @return the kaleo node that was removed
	 */
	public static com.liferay.portal.workflow.kaleo.model.KaleoNode
		deleteKaleoNode(
			com.liferay.portal.workflow.kaleo.model.KaleoNode kaleoNode) {

		return getService().deleteKaleoNode(kaleoNode);
	}

	/**
	 * Deletes the kaleo node with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param kaleoNodeId the primary key of the kaleo node
	 * @return the kaleo node that was removed
	 * @throws PortalException if a kaleo node with the primary key could not be found
	 */
	public static com.liferay.portal.workflow.kaleo.model.KaleoNode
			deleteKaleoNode(long kaleoNodeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteKaleoNode(kaleoNodeId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.portal.workflow.kaleo.model.impl.KaleoNodeModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.portal.workflow.kaleo.model.impl.KaleoNodeModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.portal.workflow.kaleo.model.KaleoNode
		fetchKaleoNode(long kaleoNodeId) {

		return getService().fetchKaleoNode(kaleoNodeId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	public static java.util.List
		<com.liferay.portal.workflow.kaleo.model.KaleoNode>
			getKaleoDefinitionVersionKaleoNodes(long kaleoDefinitionVersionId) {

		return getService().getKaleoDefinitionVersionKaleoNodes(
			kaleoDefinitionVersionId);
	}

	/**
	 * Returns the kaleo node with the primary key.
	 *
	 * @param kaleoNodeId the primary key of the kaleo node
	 * @return the kaleo node
	 * @throws PortalException if a kaleo node with the primary key could not be found
	 */
	public static com.liferay.portal.workflow.kaleo.model.KaleoNode
			getKaleoNode(long kaleoNodeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getKaleoNode(kaleoNodeId);
	}

	/**
	 * Returns a range of all the kaleo nodes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.portal.workflow.kaleo.model.impl.KaleoNodeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of kaleo nodes
	 * @param end the upper bound of the range of kaleo nodes (not inclusive)
	 * @return the range of kaleo nodes
	 */
	public static java.util.List
		<com.liferay.portal.workflow.kaleo.model.KaleoNode> getKaleoNodes(
			int start, int end) {

		return getService().getKaleoNodes(start, end);
	}

	/**
	 * Returns the number of kaleo nodes.
	 *
	 * @return the number of kaleo nodes
	 */
	public static int getKaleoNodesCount() {
		return getService().getKaleoNodesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the kaleo node in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param kaleoNode the kaleo node
	 * @return the kaleo node that was updated
	 */
	public static com.liferay.portal.workflow.kaleo.model.KaleoNode
		updateKaleoNode(
			com.liferay.portal.workflow.kaleo.model.KaleoNode kaleoNode) {

		return getService().updateKaleoNode(kaleoNode);
	}

	public static KaleoNodeLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<KaleoNodeLocalService, KaleoNodeLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(KaleoNodeLocalService.class);

		ServiceTracker<KaleoNodeLocalService, KaleoNodeLocalService>
			serviceTracker =
				new ServiceTracker
					<KaleoNodeLocalService, KaleoNodeLocalService>(
						bundle.getBundleContext(), KaleoNodeLocalService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}