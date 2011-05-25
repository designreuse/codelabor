package org.codelabor.system.login.web.filters;

import java.io.IOException;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codelabor.system.login.dtos.LoginDTO;
import org.codelabor.system.web.SessionConstants;
import org.codelabor.system.web.filters.BaseFilterImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Shin Sangjae
 * 
 */
public class AuthenticationFilter extends BaseFilterImpl {

	private final Logger logger = LoggerFactory
			.getLogger(AuthenticationFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public boolean isAuthenticated(HttpServletRequest request,
			HttpServletResponse response) {
		boolean isAuthenticated = false;
		HttpSession session = request.getSession(false);
		if (session != null) {
			if (session.getAttribute(SessionConstants.SESSION_LOGIN_INFO) != null) {
				isAuthenticated = true;
			}
		}
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("isAuthenticated: ").append(isAuthenticated);
		if (logger.isDebugEnabled()) {
			logger.debug(stringBuilder.toString());
		}

		return isAuthenticated;
	}

	@Override
	public void postprocessFilterChain(ServletRequest request,
			ServletResponse response) throws IOException, ServletException {
	}

	@Override
	public void preprocessFilterChain(ServletRequest request,
			ServletResponse response) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		if (!isAuthenticated(httpRequest, httpResponse)) {
			LoginDTO loginDTO = new LoginDTO();
			// TODO fetch user id
			loginDTO.setUserId("tester");
			loginDTO.setIpAddress(httpRequest.getRemoteAddr());
			httpRequest.getSession().setAttribute(
					SessionConstants.SESSION_LOGIN_INFO, loginDTO);

		}
	}
}