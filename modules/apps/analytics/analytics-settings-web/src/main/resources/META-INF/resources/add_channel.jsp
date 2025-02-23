<%--
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
--%>

<%@ include file="/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");

portletDisplay.setShowBackIcon(true);
portletDisplay.setURLBack(ParamUtil.getString(request, "backURL", redirect));

PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(resourceBundle, "synced-sites"), redirect);
PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(resourceBundle, "add-new-property"), currentURL);
%>

<portlet:actionURL name="/analytics/add_channel" var="addChannelURL" />

<div class="container-fluid container-fluid-max-xl">
	<div class="col-12">
		<div id="breadcrumb">
			<liferay-ui:breadcrumb
				showCurrentGroup="<%= false %>"
				showGuestGroup="<%= false %>"
				showLayout="<%= false %>"
				showPortletBreadcrumb="<%= true %>"
			/>
		</div>
	</div>
</div>

<aui:form action="<%= addChannelURL %>" method="post" name="fm">
	<liferay-portlet:renderURL varImpl="selectSitesURL">
		<portlet:param name="mvcRenderCommandName" value="/view_configuration_screen" />
		<portlet:param name="configurationScreenKey" value="synced-sites" />
	</liferay-portlet:renderURL>

	<aui:input name="redirect" type="hidden" value="<%= selectSitesURL %>" />

	<div class="portlet-analytics-settings sheet sheet-lg">
		<h2 class="autofit-row">
			<liferay-ui:message key="new-property" />
		</h2>

		<p class="mt-3 text-secondary">
			<liferay-ui:message key="select-new-property-organization-type-and-sites-to-sync.sites-can-only-be-assigned-to-a-single-property-at-a-time" />
		</p>

		<div class="mb-5 mt-4 radio-buttons">
			<label class="d-block mb-3">
				<aui:input checked="<%= true %>" label="combined-property" name="channelType" type="radio" value="combined" />

				<small class="text-secondary">
					<liferay-ui:message key="all-selected-sites-will-be-combined-in-to-a-single-property" />
				</small>
			</label>

			<label class="d-block mb-3">
				<aui:input label="multiple-properties" name="channelType" type="radio" value="multiple" />

				<small class="text-secondary">
					<liferay-ui:message key="each-site-selected-will-become-its-own-property" />
				</small>
			</label>
		</div>

		<%
		GroupDisplayContext groupDisplayContext = new GroupDisplayContext(renderRequest, renderResponse);
		%>

		<clay:management-toolbar
			displayContext="<%= new GroupManagementToolbarDisplayContext(request, liferayPortletRequest, liferayPortletResponse, groupDisplayContext) %>"
		/>

		<liferay-ui:search-container
			id="selectGroups"
			searchContainer="<%= groupDisplayContext.getGroupSearch() %>"
			var="groupSearchContainer"
		>
			<liferay-ui:search-container-row
				className="com.liferay.portal.kernel.model.Group"
				escapedModel="<%= true %>"
				keyProperty="groupId"
				modelVar="group"
			>
				<liferay-ui:search-container-column-text
					cssClass="table-cell-expand"
					name="site-name"
					value="<%= HtmlUtil.escape(group.getDescriptiveName(locale)) %>"
				/>

				<liferay-ui:search-container-column-text
					cssClass="table-cell-expand"
					name="site-friendly-url"
					value="<%= HtmlUtil.escape(group.getFriendlyURL()) %>"
				/>

				<liferay-ui:search-container-column-text
					cssClass="table-cell-expand"
					name="assigned-property"
					value="<%= HtmlUtil.escape(groupDisplayContext.getChannelName(group.getGroupId())) %>"
				/>

				<liferay-ui:search-container-column-text
					cssClass="table-cell-expand-smaller table-cell-ws-nowrap"
					name="child-sites"
					value="<%= String.valueOf(group.getChildrenWithLayoutsCount(true)) %>"
				/>
			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator
				markupView="lexicon"
				searchResultCssClass="show-quick-actions-on-hover table table-autofit"
			/>
		</liferay-ui:search-container>

		<div class="text-right">
			<aui:button-row>
				<liferay-portlet:renderURL varImpl="cancel">
					<portlet:param name="mvcRenderCommandName" value="/view_configuration_screen" />
					<portlet:param name="configurationScreenKey" value="synced-sites" />
				</liferay-portlet:renderURL>

				<aui:button href="<%= cancel.toString() %>" value="cancel" />

				<aui:button type="submit" value="done" />
			</aui:button-row>
		</div>
	</div>
</aui:form>