/*
 * Copyright 2006 The Scriptella Project Team.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package scriptella.driver.xpath;

import scriptella.spi.AbstractConnection;
import scriptella.spi.ConnectionParameters;
import scriptella.spi.ParametersCallback;
import scriptella.spi.ProviderException;
import scriptella.spi.QueryCallback;
import scriptella.spi.Resource;

import java.util.IdentityHashMap;
import java.util.Map;

/**
 * Represents a connection to an XML file.
 * <p>For configuration details and examples see <a href="package-summary.html">overview page</a>.
 *
 * @author Fyodor Kupolov
 * @version 1.0
 */
public class XPathConnection extends AbstractConnection {
    private Map<Resource, Object> queriesCache = new IdentityHashMap<Resource, Object>();

    /**
     * For testing purposes only.
     */
    protected XPathConnection() {
    }

    public XPathConnection(ConnectionParameters parameters) {
        super(Driver.DIALECT, parameters);
    }

    public void executeScript(final Resource scriptContent, final ParametersCallback parametersCallback) throws ProviderException {
        throw new XPathProviderException("Script execution is not supported yet");
    }

    public void executeQuery(Resource queryContent, ParametersCallback parametersCallback, QueryCallback queryCallback) throws ProviderException {
    }

    public void close() throws ProviderException {
        queriesCache = null;
    }
}