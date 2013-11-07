package org.codelabor.example.lifecycle.context;

import junit.framework.Assert;

public class UserContextHolder {
	private static final ThreadLocal<UserContext> contextHolder = new ThreadLocal<UserContext>();

	public static UserContext getContext() {
		UserContext context = contextHolder.get();
		if (context == null) {
			context = new UserContext();
			setContext(context);
			return context;
		} else {
			return context;
		}
	}

	public static void setContext(UserContext userContext) {
		Assert.assertNotNull(userContext);
		contextHolder.set(userContext);
	}
	
	public static void removeContext() {
		contextHolder.remove();
	}
}