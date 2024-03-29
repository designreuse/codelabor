/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.codelabor.system.web;

/**
 * 요청 관련 상수
 *
 * @author Shin Sang-jae
 *
 */
public class RequestConstants {

	/**
	 * 요청 받은 속성 Map
	 */
	public static final String REQUEST_ATTRIBUTE_MAP = "org.codelabor.system.web.REQUEST_ATTRIBUTE_MAP";
	/**
	 * 요청 받은 파라미터 Map
	 */
	public static final String REQUEST_PARAMETER_MAP = "org.codelabor.system.web.REQUEST_PARAMETER_MAP";
	/**
	 * 요청 받은 URI
	 */
	public static final String REQUEST_URI_KEY = "org.codelabor.system.web.REQUEST_URI";

	public static final String PRINCIPAL_NAME = "principalName";
	public static final String QUERY_STRING = "queryString";
	public static final String REMOTE_ADDR = "remoteAddr";
	public static final String REMOTE_HOST = "remoteHost";
	public static final String REQUEST_URI = "requestUri";
	public static final String REQUEST_URL = "requestUrl";
}