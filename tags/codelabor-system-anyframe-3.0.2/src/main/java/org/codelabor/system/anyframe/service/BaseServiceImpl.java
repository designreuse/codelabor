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

package org.codelabor.system.anyframe.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;

import anyframe.core.idgen.IIdGenerationService;
import anyframe.core.properties.IPropertiesService;
import anyframe.core.query.IQueryService;

/**
 * 기본 서비스 구현 클래스
 * 
 * @author Shin Sang-jae
 * 
 */
public class BaseServiceImpl {
	/**
	 * 로거
	 */
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * 로거명
	 */
	protected String loggerName = this.getClass().getName();

	/**
	 * 메시지 소스
	 */
	protected MessageSource messageSource;
	/**
	 * 프로퍼티 서비스
	 */
	protected IPropertiesService propertiesService;
	/**
	 * 아이디 제네레이션 서비스
	 */
	protected IIdGenerationService idGenerationService;
	/**
	 * 쿼리 서비스
	 */
	protected IQueryService queryService;

	/**
	 * 로거명을 설정한다.
	 * 
	 * @param loggerName
	 *            로거명
	 */
	public void setLoggerName(String loggerName) {
		this.loggerName = loggerName;
		this.logger = LoggerFactory.getLogger(loggerName);
	}

	/**
	 * 메시지 소스를 가져온다.
	 * 
	 * @return 메시지 소스
	 */
	public MessageSource getMessageSource() {
		return messageSource;
	}

	/**
	 * 메시지 소스를 설정한다.
	 * 
	 * @param messageSource
	 *            메시지 소스
	 */
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	/**
	 * 프로퍼티 서비스를 가져온다.
	 * 
	 * @return 프로퍼티 서비스
	 */
	public IPropertiesService getPropertiesService() {
		return propertiesService;
	}

	/**
	 * 프로퍼티 서비스를 설정한다.
	 * 
	 * @param propertiesService
	 *            프로퍼티 서비스
	 */
	public void setPropertiesService(IPropertiesService propertiesService) {
		this.propertiesService = propertiesService;
	}

	/**
	 * 아이디 제네레이션 서비스를 가져온다.
	 * 
	 * @return Id 제네레이션 서비스
	 */
	public IIdGenerationService getIdGenerationService() {
		return idGenerationService;
	}

	/**
	 * Id 제네레이션 서비스를 설정한다.
	 * 
	 * @param sequenceIdGenerationService
	 *            Id 제네레이션 서비스
	 */
	public void setIdGenerationService(
			IIdGenerationService sequenceIdGenerationService) {
		this.idGenerationService = sequenceIdGenerationService;
	}

	/**
	 * 쿼리 서비스를 가져온다.
	 * 
	 * @return 쿼리 서비스
	 */
	public IQueryService getQueryService() {
		return queryService;
	}

	/**
	 * 쿼리 서비스를 설정한다.
	 * 
	 * @param queryService
	 *            쿼리 서비스
	 */
	public void setQueryService(IQueryService queryService) {
		this.queryService = queryService;
	}
}
