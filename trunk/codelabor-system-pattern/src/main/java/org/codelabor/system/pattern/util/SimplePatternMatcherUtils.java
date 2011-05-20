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
package org.codelabor.system.pattern.util;

import java.util.List;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Simple ���� ��ó ��ƿ��Ƽ
 * 
 * @author Shin Sang-jae
 * 
 */
public class SimplePatternMatcherUtils {
	/**
	 * �ΰ�
	 */
	static private Logger logger = LoggerFactory.getLogger(SimplePatternMatcherUtils.class);

	/**
	 * ���� ��ġ ���θ� Ȯ���Ѵ�.
	 * 
	 * @param pattern
	 *            ����
	 * @param inputString
	 *            Ȯ�� ��� ���ڿ�
	 * @return ���� ��ġ ����
	 */
	static public boolean matches(String pattern, String inputString) {
		return Pattern.matches(pattern, inputString);
	}

	/**
	 * ���� ��ġ ���θ� Ȯ���Ѵ�.
	 * 
	 * @param patternList
	 *            ���� List
	 * @param inputString
	 *            Ȯ�� ��� ���ڿ�
	 * @return ���� ��ġ ����
	 */
	static public boolean matches(List<String> patternList, String inputString) {
		return matches(patternList, null, inputString);
	}

	/**
	 * ���� ��ġ ���θ� Ȯ���Ѵ�.
	 * 
	 * @param includesPatternList
	 *            ������ ���� List
	 * @param excludesPatternList
	 *            ������ ���� List
	 * @param inputString
	 *            Ȯ�� ��� ���ڿ�
	 * @return ���� ��ġ ����
	 */
	static public boolean matches(List<String> includesPatternList, List<String> excludesPatternList, String inputString) {
		boolean isMatched = false;
		if (includesPatternList != null) {
			if (includesPatternList.contains(inputString)) {
				isMatched = true;
			}
			if (excludesPatternList != null && excludesPatternList.contains(inputString)) {
				isMatched = false;
			}
		}
		logger.debug("isMatched: {}", isMatched);
		return isMatched;
	}
}