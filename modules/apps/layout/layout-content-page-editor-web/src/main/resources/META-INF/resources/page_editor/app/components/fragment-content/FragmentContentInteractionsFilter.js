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

import PropTypes from 'prop-types';
import React, {useEffect, useMemo} from 'react';

import {EDITABLE_FRAGMENT_ENTRY_PROCESSOR} from '../../config/constants/editableFragmentEntryProcessor';
import {ITEM_TYPES} from '../../config/constants/itemTypes';
import {useSelector} from '../../store/index';
import {
	useActiveItemId,
	useActiveItemType,
	useHoverItem,
	useIsActive,
	useSelectItem,
} from '../Controls';
import {useSetEditableProcessorUniqueId} from './EditableProcessorContext';
import {getEditableElement} from './getEditableElement';
import getEditableElementId from './getEditableElementId';
import getEditableUniqueId from './getEditableUniqueId';

export default function FragmentContentInteractionsFilter({
	children,
	editableElements,
	fragmentEntryLinkId,
	itemId,
}) {
	const hoverItem = useHoverItem();
	const isActive = useIsActive();
	const activeItemId = useActiveItemId();
	const activeItemType = useActiveItemType();
	const selectItem = useSelectItem();
	const setEditableProcessorUniqueId = useSetEditableProcessorUniqueId();

	const editableValues = useSelector(state =>
		state.fragmentEntryLinks[fragmentEntryLinkId]
			? state.fragmentEntryLinks[fragmentEntryLinkId].editableValues[
					EDITABLE_FRAGMENT_ENTRY_PROCESSOR
			  ]
			: {}
	);

	useEffect(() => {
		let activeEditableElement;

		const enableProcessor = event => {
			const editableElement = getEditableElement(event.target);

			if (editableElement) {
				const editableElementId = getEditableElementId(editableElement);
				const editableValue = editableValues[editableElementId] || {};

				const isMapped =
					(editableValue.classNameId &&
						editableValue.classPK &&
						editableValue.fieldId) ||
					editableValue.mappedField;

				if (isMapped) {
					return;
				}
				const editableClickPosition = {
					clientX: event.clientX,
					clientY: event.clientY,
				};
				const editableUniqueId = getEditableUniqueId(
					fragmentEntryLinkId,
					getEditableElementId(editableElement)
				);

				if (isActive(editableUniqueId)) {
					setEditableProcessorUniqueId(
						editableUniqueId,
						editableClickPosition
					);
				}
			}
		};

		if (activeItemId && activeItemType === ITEM_TYPES.editable) {
			activeEditableElement = editableElements.find(editableElement =>
				isActive(
					getEditableUniqueId(
						fragmentEntryLinkId,
						getEditableElementId(editableElement)
					)
				)
			);

			if (activeEditableElement) {
				requestAnimationFrame(() => {
					activeEditableElement.addEventListener(
						'dblclick',
						enableProcessor
					);
				});
			}
		}

		return () => {
			if (activeEditableElement) {
				activeEditableElement.removeEventListener(
					'dblclick',
					enableProcessor
				);
			}
		};
	}, [
		activeItemId,
		activeItemType,
		editableElements,
		editableValues,
		fragmentEntryLinkId,
		isActive,
		itemId,
		setEditableProcessorUniqueId,
	]);

	const siblingIds = useMemo(
		() => [
			itemId,
			...editableElements.map(editableElement =>
				getEditableUniqueId(
					fragmentEntryLinkId,
					getEditableElementId(editableElement)
				)
			),
		],
		[itemId, editableElements, fragmentEntryLinkId]
	);

	const hoverEditable = event => {
		const editableElement = getEditableElement(event.target);

		if (editableElement) {
			event.stopPropagation();

			hoverItem(
				getEditableUniqueId(
					fragmentEntryLinkId,
					getEditableElementId(editableElement)
				),
				{itemType: ITEM_TYPES.editable}
			);
		}
	};

	const selectEditable = event => {
		const editableElement = getEditableElement(event.target);

		if (editableElement) {
			event.stopPropagation();

			const editableUniqueId = getEditableUniqueId(
				fragmentEntryLinkId,
				getEditableElementId(editableElement)
			);

			if (isActive(editableUniqueId)) {
				event.stopPropagation();
			}
			else {
				selectItem(editableUniqueId, {
					itemType: ITEM_TYPES.editable,
					multiSelect: event.shiftKey,
				});
			}
		}
	};

	const props = {};

	if (siblingIds.some(isActive)) {
		props.onClickCapture = selectEditable;
		props.onMouseOverCapture = hoverEditable;
	}

	return <div {...props}>{children}</div>;
}

FragmentContentInteractionsFilter.propTypes = {
	element: PropTypes.instanceOf(HTMLElement),
	fragmentEntryLinkId: PropTypes.string.isRequired,
	itemId: PropTypes.string.isRequired,
};
