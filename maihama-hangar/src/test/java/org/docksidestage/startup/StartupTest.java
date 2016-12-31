/*
 * Copyright 2015-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.docksidestage.startup;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.dbflute.infra.manage.refresh.DfRefreshResourceRequest;
import org.docksidestage.app.logic.startup.StartupLogic;
import org.docksidestage.unit.UnitHangarTestCase;

/**
 * @author jflute
 */
public class StartupTest extends UnitHangarTestCase {

    @Resource
    private StartupLogic startupLogic;

    public void test_startup_actually() throws Exception {
        final File repositoryDir = getProjectDir().getParentFile();
        final String domain = "dancingdb.org";
        final String serviceName = "showfire";
        final String appName = "mysticrhythms";
        startupLogic.fromHangar(repositoryDir, domain, serviceName, appName);
        refresh(serviceName, appName); // for retry
    }

    protected void refresh(String serviceName, String appName) {
        try {
            final List<String> projectNameList = Arrays.asList(serviceName + "-base", serviceName + "-common", serviceName + "-" + appName);
            new DfRefreshResourceRequest(projectNameList, "http://localhost:8386/").refreshResources();
        } catch (IOException | RuntimeException continued) {
            log("*Cannot refresh for Eclipse, but no problem so continue: " + continued.getMessage());
        }
    }
}
