/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the "Elastic License
 * 2.0", the "GNU Affero General Public License v3.0 only", and the "Server Side
 * Public License v 1"; you may not use this file except in compliance with, at
 * your election, the "Elastic License 2.0", the "GNU Affero General Public
 * License v3.0 only", or the "Server Side Public License, v 1".
 */

package org.elasticsearch.kibana;

import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.indices.SystemIndexDescriptor;
import org.elasticsearch.test.ESTestCase;

import static org.hamcrest.Matchers.contains;

public class KibanaPluginTests extends ESTestCase {

    public void testKibanaIndexNames() {
        assertThat(
            new KibanaPlugin().getSystemIndexDescriptors(Settings.EMPTY).stream().map(SystemIndexDescriptor::getIndexPattern).toList(),
            contains(".kibana_*", ".reporting-*", ".chat-*", ".apm-agent-configuration*", ".apm-custom-link*")
        );
    }
}
