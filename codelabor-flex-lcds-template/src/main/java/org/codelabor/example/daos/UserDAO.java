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

package org.codelabor.example.daos;

import java.util.List;

import org.codelabor.example.dtos.UserDTO;

/**
 * @author SangJae Shin
 * 
 */
public interface UserDAO {
	public int insertUser(UserDTO userDTO) throws Exception;

	public int updateUser(UserDTO userDTO) throws Exception;

	public int deleteUser(String userId) throws Exception;

	public int deleteUser() throws Exception;

	public UserDTO selectUserByUserId(String userId) throws Exception;

	public List<UserDTO> selectUser() throws Exception;
}
