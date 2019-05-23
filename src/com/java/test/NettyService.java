package com.java.test;

import javax.net.ssl.SSLContext;

import org.jboss.resteasy.plugins.server.netty.NettyJaxrsServer;
import org.jboss.resteasy.spi.ResteasyDeployment;

public class NettyService {
	
	private static String						rootResourcePath	= "/";
	private static String						hostName			= "";
	private static int							port				= 8000;
	private static int							ioWorkerCount		= Runtime.getRuntime().availableProcessors() * 4;
	private static int							executorThreadCount	= 10;
	private static SSLContext					sslContext			= null;
	private static int							maxRequestSize		= 10 * 1024 * 1024;

	public static void main(String[] args) {
		NettyJaxrsServer			nettyServer;
		ResteasyDeployment deployment = new ResteasyDeployment();
		//将REST资源类加入服务
		deployment.getResources().add(new RESTeasy());
		
		nettyServer = new NettyJaxrsServer();
		nettyServer.setDeployment(deployment);
		nettyServer.setPort(port);
		nettyServer.setRootResourcePath(rootResourcePath);
		nettyServer.setIoWorkerCount(ioWorkerCount);
		nettyServer.setExecutorThreadCount(executorThreadCount);
		nettyServer.setMaxRequestSize(maxRequestSize);
		nettyServer.setSSLContext(sslContext);
		nettyServer.setKeepAlive(false);
		if (hostName != null && "".equals(hostName)) nettyServer.setHostname(hostName.trim());
		nettyServer.setSecurityDomain(null);
		nettyServer.start();
	}
}
