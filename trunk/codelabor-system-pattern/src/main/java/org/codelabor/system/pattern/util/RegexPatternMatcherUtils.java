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

import org.codelabor.system.util.ListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Shin Sang-jae
 * 
 */
public class RegexPatternMatcherUtils {
	static private Logger logger = LoggerFactory.getLogger(RegexPatternMatcherUtils.class);

	static public boolean matches(String pattern, String inputString) {
		return Pattern.matches(pattern, inputString);
	}

	static public boolean matches(List<String> patternList, String inputString) {
		return matches(patternList, null, inputString);
	}

	static public boolean matches(List<String> includesPatternList, List<String> excludesPatternList, String inputString) {
		boolean isMatched = false;

		if (excludesPatternList != null) {
			if (ListUtils.containsByRegexpPattern(excludesPatternList, inputString)) {
				// bypass
			} else {
				if (includesPatternList != null) {
					if (ListUtils.containsByRegexpPattern(includesPatternList, inputString)) {
						isMatched = true;
					} else {
						isMatched = false;
					}
				} else {
					isMatched = true;
				}
			}
		} else {
			if (includesPatternList != null) {
				if (ListUtils.containsByRegexpPattern(includesPatternList, inputString)) {
					isMatched = true;
				} else {
					isMatched = false;
				}
			} else {
				isMatched = true;
			}
		}
		logger.debug("isMatched: {}", isMatched);
		return isMatched;
	}
}
