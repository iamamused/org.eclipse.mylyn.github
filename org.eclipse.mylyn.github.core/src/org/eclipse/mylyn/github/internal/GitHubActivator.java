package org.eclipse.mylyn.github.internal;

import org.eclipse.core.net.proxy.IProxyService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class GitHubActivator implements BundleActivator {

	private static GitHubActivator instance;

	public static GitHubActivator getInstance() {
		return instance;
	}

	private ServiceTracker proxyServiceTracker;

	public GitHubActivator() {
	}

	public void start(BundleContext context) throws Exception {
		instance = this;
		
		proxyServiceTracker = new ServiceTracker(context,
				IProxyService.class.getName(), null);
		proxyServiceTracker.open();
	}

	public void stop(BundleContext context) throws Exception {
		proxyServiceTracker.close();
	}

	public IProxyService getProxyService() {
		return (IProxyService) proxyServiceTracker.getService();
	}
}
