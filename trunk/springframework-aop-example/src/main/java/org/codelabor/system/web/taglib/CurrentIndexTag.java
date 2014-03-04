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
package org.codelabor.system.web.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Sang Jae Shin
 * 
 */
public class CurrentIndexTag extends SimpleTagSupport {

	private final static Logger logger = LoggerFactory
			.getLogger(CurrentIndexTag.class);

	protected String cssClass;
	protected String onclick;
	PaginationTag parent;

	/**
	 *
	 */
	public CurrentIndexTag() {
	}

	protected String generateAnchorTagForCurrentIndex(String queryString,
			int PageNo, int maxRowPerPage) throws JspException, IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("<a href=\"?").append(
				parent.replacePageNoInQueryString(queryString, PageNo,
						maxRowPerPage));
		sb.append("\"");
		if (!StringUtils.isBlank(cssClass)) {
			sb.append(" class=\"").append(cssClass).append("\"");
		}
		if (!StringUtils.isBlank(onclick)) {
			sb.append(" onclick=\"").append(onclick).append("\"");
		}
		sb.append(">");
		sb.append(PageNo);
		sb.append("</a>");
		return sb.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.jsp.tagext.SimpleTagSupport#doTag()
	 */
	@Override
	public void doTag() throws JspException, IOException {
		logger.debug("doTag");

		parent = (PaginationTag) getParent();
		JspWriter out = getJspContext().getOut();

		// first page number of previous
		logger.debug("firstPageNoOnCurrentIndex: {}",
				parent.getFirstPageNoOnCurrentIndex());
		StringBuilder sb = new StringBuilder();
		for (int i = parent.getFirstPageNoOnCurrentIndex(); (i <= parent
				.getLastPageNoOnCurrentIndex())
				&& (i <= parent.getLastPageNo()); i++) {
			logger.debug("pageNo: {}", i);
			sb.setLength(0);
			sb.trimToSize();
			if (i == parent.getCurrentPageNo()) {
				sb.append("<span>").append(i).append("</span>");
			} else {
				sb.append(this.generateAnchorTagForCurrentIndex(
						parent.getQueryString(), i, parent.getMaxRowPerPage()));
			}
			sb.append(System.getProperty("line.separator"));
			out.print(sb.toString());
		}
		logger.debug("lastPageNoOnCurrentIndex: {}",
				parent.getLastPageNoOnCurrentIndex());
	}

	/**
	 * @return the onclick
	 */
	public String getOnclick() {
		return onclick;
	}

	/**
	 * @param onclick
	 *            the onclick to set
	 */
	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}

	/**
	 * @return the cssClass
	 */
	public String getCssClass() {
		return cssClass;
	}

	/**
	 * @param cssClass
	 *            the cssClass to set
	 */
	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

}