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

package org.codelabor.system.web.struts.forms;

import java.io.Serializable;

/**
 * String 타입 Id 배열 Form 클래스
 * 
 * @author Shin Sangjae
 * 
 */
public class StringIDArrayForm implements Serializable {

	/**
	 * 시리얼 버전 UID
	 */
	private static final long serialVersionUID = -2028609881040973550L;
	/**
	 * Id 배열
	 */
	private String[] id;

	/**
	 * Id를 가져온다.
	 * 
	 * @return Id 배열
	 */
	public String[] getId() {
		return id;
	}

	/**
	 * Id를 설정한다.
	 * 
	 * @param id
	 *            Id 배열
	 */
	public void setId(String[] id) {
		this.id = id;
	}

	/**
	 * Constructs a <code>String</code> with all attributes in name = value
	 * format.
	 * 
	 * @return a <code>String</code> representation of this object.
	 */
	@Override
	public String toString() {
		final String TAB = "    ";

		StringBuilder retValue = new StringBuilder();

		retValue.append("StringIDArrayForm ( ").append(super.toString())
				.append(TAB).append("id = ").append(this.id).append(TAB)
				.append(" )");

		return retValue.toString();
	}

}
