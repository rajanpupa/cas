/**
 * Licensed to Jasig under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Jasig licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a
 * copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.jasig.cas.server.session;

import java.io.Serializable;
import java.util.List;

import org.jasig.cas.server.authentication.Service;

/**
 * Interface for a service that can be registered by the Services Management
 * interface.
 * 
 * @author Scott Battaglia
 * @version $Revision$ $Date$
 * @since 3.1
 */
public interface RegisteredService extends Cloneable, Serializable {

    /**
     * Is this application currently allowed to use CAS?
     * 
     * @return true if it can use CAS, false otherwise.
     */
    boolean isEnabled();

    /**
     * Determines whether the service is allowed anonymous or priveleged access
     * to user information. Anonymous access should not return any identifying
     * information such as user id.
     */
    boolean isAnonymousAccess();
    
    /**
     * Sets whether we should bother to read the attribute list or not.
     * 
     * @return true if we should read it, false otherwise.
     */
    boolean isIgnoreAttributes();

    /**
     * Returns the list of allowed attributes.
     * 
     * @return the list of attributes
     */
    List<String> getAllowedAttributes();

    /**
     * Is this application allowed to take part in the proxying capabilities of
     * CAS?
     * 
     * @return true if it can, false otherwise.
     */
    boolean isAllowedToProxy();

    /**
     * The unique identifier for this service.
     * 
     * @return the unique identifier for this service.
     */
    String getServiceId();

    long getId();

    /**
     * Returns the name of the service.
     * 
     * @return the name of the service.
     */
    String getName();

    /**
     * Returns a short theme name. Services do not need to have unique theme
     * names.
     * 
     * @return the theme name associated with this service.
     */
    String getTheme();

    /**
     * Does this application participate in the SSO session?
     * 
     * @return true if it does, false otherwise.
     */
    boolean isSsoEnabled();

    /**
     * Returns the description of the service.
     * 
     * @return the description of the service.
     */
    String getDescription();
   
    /**
     * Gets the relative evaluation order of this service when determining
     * matches.
     * @return Evaluation order relative to other registered services.
     * Services with lower values will be evaluated for a match before others.
     */
    int getEvaluationOrder();

    /**
     * Returns whether the service matches the registered service.
     * <p>Note, as of 3.1.2, matches are case insensitive.
     * 
     * @param access the service to match.
     * @return true if they match, false otherwise.
     */
    boolean matches(final Access access);

    /**
     * Returns whether the service matches the registered service.
     * <p>Note, as of 3.1.2, matches are case insensitive.
     *
     * @param access the service to match.
     * @return true if they match, false otherwise.
     */
    boolean matches(final String access);
    
    Object clone() throws CloneNotSupportedException;
}