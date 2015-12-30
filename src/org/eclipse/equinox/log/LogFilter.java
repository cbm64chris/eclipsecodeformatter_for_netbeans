/**
 * *****************************************************************************
 * Copyright (c) 2006, 2011 IBM Corporation and others All rights reserved. This
 * program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * ****************************************************************************
 */
package org.eclipse.equinox.log;

import org.osgi.framework.Bundle;
import org.osgi.service.log.LogEntry;

/**
 * HACK: Include to fullfill the runtime-dependencies of the formatter from
 * Eclipse Mars 4.5. This formatter plugin cannot include a OSGI implementation,
 * so we have to use the implementation provided by NetBeans itself. And we fake
 * the missing class, which does not seem to be included in the NetBeans
 * distribution.
 */
/**
 * A <code>LogFilter</code> is used to pre-filter log requests before sending
 * events to a <code>LogListener</code>.
 *
 * @ThreadSafe
 * @see
 * ExtendedLogReaderService#addLogListener(org.osgi.service.log.LogListener,
 * LogFilter)
 * @since 3.7
 */
public interface LogFilter {

    /**
     * @param bundle The logging bundle
     * @param loggerName The name of the <code>Logger<code>
     * @param logLevel The log level or severity
     * @see LogEntry
     * @see Logger
     * @see
     * ExtendedLogReaderService#addLogListener(org.osgi.service.log.LogListener,
     * LogFilter)
     */
    boolean isLoggable(Bundle bundle, String loggerName, int logLevel);
}
