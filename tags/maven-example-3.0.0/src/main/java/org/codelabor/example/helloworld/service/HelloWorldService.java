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
package org.codelabor.example.helloworld.service;

/**
 * HelloWorld 서비스 인터페이스
 * 
 * @author Shin Sang-jae
 * 
 */
public interface HelloWorldService {
	/**
	 * 인사를 한다.
	 * 
	 * @return 인삿말
	 */
	public String sayHello();

	/**
	 * 인사를 한다.
	 * 
	 * @param name
	 *            이름
	 * @return 인삿말
	 */
	public String sayHello(String name);
}