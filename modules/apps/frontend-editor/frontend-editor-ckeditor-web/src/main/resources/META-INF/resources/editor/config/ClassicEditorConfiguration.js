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

export function CLASSIC_EDITOR_CONFIG(CKEDITOR) {
	CKEDITOR.dtd['a']['div'] = 1;
	CKEDITOR.disableAutoInline = true;
	CKEDITOR.dtd.$removeEmpty.i = 0;
	CKEDITOR.dtd.$removeEmpty.span = 0;

	CKEDITOR.getNextZIndex = function () {
		return CKEDITOR.dialog._.currentZIndex
			? CKEDITOR.dialog._.currentZIndex + 10
			: Liferay.zIndex.WINDOW + 10;
	};
}
