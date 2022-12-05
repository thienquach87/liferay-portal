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

package com.liferay.portal.file.install.internal.configuration;

import com.liferay.portal.kernel.util.ModuleFrameworkPropsValues;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.test.rule.LiferayUnitTestRule;
import com.liferay.portal.util.PropsUtil;

import java.io.File;

import java.nio.file.Files;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

/**
 * @author Thien Quach
 */
public class ConfigurationFileInstallerTest {

	@ClassRule
	@Rule
	public static final LiferayUnitTestRule liferayUnitTestRule =
		LiferayUnitTestRule.INSTANCE;

	@ClassRule
	public static TemporaryFolder temporaryFolder = new TemporaryFolder();

	@Test
	public void testCanTransformURL() throws Exception {
		File configDir = temporaryFolder.newFolder("configs");

		File testDir = temporaryFolder.newFolder("tests");

		PropsUtil.set(
			PropsKeys.MODULE_FRAMEWORK_CONFIGS_DIR, configDir.getPath());

		File configFile1 = new File(configDir, "test.config");
		File configFile2 = new File(testDir, "test.config");

		Files.write(configFile1.toPath(), "".getBytes());
		Files.write(configFile2.toPath(), "".getBytes());

		ConfigurationFileInstaller configurationFileInstaller =
			new ConfigurationFileInstaller(
				null,
				ModuleFrameworkPropsValues.
					MODULE_FRAMEWORK_FILE_INSTALL_CONFIG_ENCODING);

		Assert.assertTrue(
			configurationFileInstaller.canTransformURL(configFile1));
		Assert.assertFalse(
			configurationFileInstaller.canTransformURL(configFile2));
	}

}