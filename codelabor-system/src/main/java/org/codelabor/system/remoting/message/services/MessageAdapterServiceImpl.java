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
package org.codelabor.system.remoting.message.services;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codelabor.system.remoting.message.dtos.DataDTO;
import org.codelabor.system.remoting.message.dtos.HeaderDTO;
import org.codelabor.system.remoting.message.dtos.KsfcHeaderDTO;
import org.codelabor.system.remoting.tcp.services.SimpleSocketAdapterServiceImpl;
import org.codelabor.system.remoting.tcp.services.SocketAdapterService;
import org.codelabor.system.spring.utils.SecurityContextUtil;

import anyframe.core.idgen.IIdGenerationService;

/**
 * @author bomber
 * 
 */
public class MessageAdapterServiceImpl implements MessageAdapterService {
	private final Log log = LogFactory.getLog(MessageAdapterServiceImpl.class);
	private SocketAdapterService socketAdapterService;
	private IIdGenerationService idGenerationService;
	private String charsetName = "EUC-KR";

	public void setIdGenerationService(IIdGenerationService idGenerationService) {
		this.idGenerationService = idGenerationService;
	}

	public MessageAdapterServiceImpl() {
		socketAdapterService = new SimpleSocketAdapterServiceImpl();
	}

	public void setCharsetName(String charsetName) {
		this.charsetName = charsetName;
	}

	public void setSocketAdapterService(SocketAdapterService socketAdapterService) {
		this.socketAdapterService = socketAdapterService;
	}

	public void call(HeaderDTO inputHeaderDTO, DataDTO inputDataDTO, HeaderDTO outputHeaderDTO, DataDTO outputDataDTO) throws Exception {

		// stnd_tlg_thwh_len
		KsfcHeaderDTO ksfcInputHeaderDTO = (KsfcHeaderDTO) inputHeaderDTO;
		int stndTlgThwhLen = ksfcInputHeaderDTO.getLength() + inputDataDTO.toBytes().length;
		ksfcInputHeaderDTO.getSystemHeaderDTO().setStndTlgThwhLen(stndTlgThwhLen);

		// tlg_dscd
		ksfcInputHeaderDTO.getSystemHeaderDTO().setTlgDscd("S");

		// itn_incd
		ksfcInputHeaderDTO.getSystemHeaderDTO().setItnIncd("KSF");

		// sys_dscd
		ksfcInputHeaderDTO.getSystemHeaderDTO().setSysDscd("UA");

		// tr_id
		String nextId = idGenerationService.getNextStringId();
		String pid = nextId.substring(3, 11);
		ksfcInputHeaderDTO.getSystemHeaderDTO().setTrIdChCode(nextId.substring(0, 3));
		ksfcInputHeaderDTO.getSystemHeaderDTO().setTrIdPid(pid);
		ksfcInputHeaderDTO.getSystemHeaderDTO().setTrIdReqDt(nextId.substring(11, 17));
		ksfcInputHeaderDTO.getSystemHeaderDTO().setTrIdReqTm(nextId.substring(17, 25));
		ksfcInputHeaderDTO.getSystemHeaderDTO().setTrIdSeq(nextId.substring(25, 27));

		// og_tr_id
		ksfcInputHeaderDTO.getSystemHeaderDTO().setOgTrId(nextId);

		// cd_vl_stup_dscd
		ksfcInputHeaderDTO.getSystemHeaderDTO().setCdVlStupDscd(0);

		// sync_dscd
		ksfcInputHeaderDTO.getSystemHeaderDTO().setSyncDscd("S");

		// tmnl_ip
		ksfcInputHeaderDTO.getSystemHeaderDTO().setTmnlIp(SecurityContextUtil.getRemoteAddress());

		// tr_rqs_chnl_cd
		ksfcInputHeaderDTO.getSystemHeaderDTO().setTrRqsChnlCd("IUS");

		// og_tr_rqs_chnl_cd
		ksfcInputHeaderDTO.getSystemHeaderDTO().setOgTrRqsChnlCd("IUS");

		// lgn_yn
		ksfcInputHeaderDTO.getTransactionHeaderDTO().setLgnYn(BooleanUtils.toInteger(SecurityContextUtil.isAuthenticated()));

		byte[] inputHeaderBytes = inputHeaderDTO.toBytes();
		byte[] inputDataBytes = inputDataDTO.toBytes();
		byte[] inputMessageBytes = ArrayUtils.addAll(inputHeaderBytes, inputDataBytes);

		String inputMessage = new String(inputMessageBytes, charsetName);
		String outputMessage = socketAdapterService.send(inputMessage);
		if (log.isDebugEnabled()) {
			StringBuilder sb = new StringBuilder();
			sb.append("input message: ").append(inputMessage);
			log.debug(sb.toString());
			sb = new StringBuilder();
			sb.append("output message: ").append(outputMessage);
			log.debug(sb.toString());
		}

		byte[] outputMessageBytes = outputMessage.getBytes(charsetName);
		byte[] outputHeaderBytes = ArrayUtils.subarray(outputMessageBytes, 0, outputHeaderDTO.getLength());
		byte[] outputDataBytes = ArrayUtils.subarray(outputMessageBytes, outputHeaderDTO.getLength(), outputMessageBytes.length);
		outputHeaderDTO.fromBytes(outputHeaderBytes);
		if (!outputHeaderDTO.isError()) {
			outputDataDTO.fromBytes(outputDataBytes);
		}
	}
}
