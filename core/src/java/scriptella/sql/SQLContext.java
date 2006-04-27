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
package scriptella.sql;

import scriptella.execution.ScriptsContext;
import scriptella.expressions.ParametersCallback;

import java.sql.Connection;


/**
 * Represents execution context for SQL elements.
 *
 * @author Fyodor Kupolov
 * @version 1.0
 */
public class SQLContext implements ParametersCallback {
    protected ScriptsContext globalContext;

    protected SQLContext() {
    }

    public SQLContext(ScriptsContext globalContext) {
        this.globalContext = globalContext;
    }

    public Object getParameter(final String name) {
        return globalContext.getParameter(name);
    }

    public Connection getConnection() {
        final ConnectionFactory cf = globalContext.getSqlEngine()
                .getConnection(null);

        return cf.getConnection();
    }

    public Connection getNewConnection() {
        final ConnectionFactory cf = globalContext.getSqlEngine()
                .getConnection(null);

        return cf.newConnection();
    }

    public DialectIdentifier getDialectIdentifier() {
        final ConnectionFactory cf = globalContext.getSqlEngine()
                .getConnection(null);

        return cf.getDialectIdentifier();
    }
}