/**********************************************************************
*	湖南长沙阳环科技实业有限公司
*	@Copyright (c) 2003-2017 yhcloud, Inc. All rights reserved.
*	
*	This copy of Ice is licensed to you under the terms described in the
*	ICE_LICENSE file included in this distribution.
*	
*	@license http://www.yhcloud.com.cn/license/
**********************************************************************/

package cn.com.yhcloud.netty;

import org.apache.log4j.Logger;

import java.net.InetSocketAddress;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;


/**
 * 运算节点服务器
 * 
 * @author xwood
 * @version 20161017
 *
 */
public class NettyServer {

	public final static Logger log = Logger.getLogger(NettyServer.class);
	
	// 当前运算节点的上下文环境
	private ChannelHandlerContext ctx = null;

	// 2个工作组
	private EventLoopGroup eventLoopGroupBoss  = null;
	private EventLoopGroup eventLoopGroupWorker  = null;
	
	// 服务器端
	private ServerBootstrap serverBootstrap = null;

	private ConfigBean mConfigBean;

	public NettyServer() {
				
		this.eventLoopGroupBoss  = new NioEventLoopGroup();
		this.eventLoopGroupWorker  = new NioEventLoopGroup();
		
		this.serverBootstrap = new ServerBootstrap();
	}

	public NettyServer(ConfigBean configBean) {
		
		this.mConfigBean = configBean;
		
		this.eventLoopGroupBoss  = new NioEventLoopGroup();
		this.eventLoopGroupWorker  = new NioEventLoopGroup();
		
		this.serverBootstrap = new ServerBootstrap();
	}
	
	/**
	 * 构造方法
	 * @param ctx
	 */
	public NettyServer(ChannelHandlerContext ctx) {
		
		this.ctx = ctx;
		
		this.eventLoopGroupBoss  = new NioEventLoopGroup();
		this.eventLoopGroupWorker  = new NioEventLoopGroup();
		
		this.serverBootstrap = new ServerBootstrap();
	}
	
	/**
	 * 服务器开始
	 */
	public void startService () {
		
		try{
			
			if (null == eventLoopGroupBoss) {
				log.error("NettyServer startService 启动失败 eventLoopGroupBoss 为空!");
				return;
			}
			
			if (null == eventLoopGroupWorker) {
				log.error("NettyServer startService 启动失败 eventLoopGroupWorker 为空!");
				return;
			}
			
	        ServerBootstrap childHandler = 
	                this.serverBootstrap
	                .group(this.eventLoopGroupBoss, this.eventLoopGroupWorker)
	                .channel(NioServerSocketChannel.class)
	                // BACKLOG用于构造服务端套接字ServerSocket对象，标识当服务器请求处理线程全满时，用于临时存放已完成三次握手的请求的队列的最大长度。如果未设置或所设置的值小于1，Java将使用默认值50。
	                .option(ChannelOption.SO_BACKLOG, 1024)
	                // 地址是否可复用（UDP socket address绑定时用到）
	                // 作用是重用处于TIME_WAIT但是未完全关闭的socket地址
	                .option(ChannelOption.SO_REUSEADDR, true)
	                // 长连接
	                .option(ChannelOption.SO_KEEPALIVE, false)
	                // 设置封包 使用一次大数据的写操作，而不是多次小数据的写操作
	                .childOption(ChannelOption.TCP_NODELAY, true)
	                // 发送和接受的缓冲大小
	                .option(ChannelOption.SO_SNDBUF, mConfigBean.getSocketSendBufferSize())
	                //
	                .option(ChannelOption.SO_RCVBUF,  mConfigBean.getSocketRecvBufferSize())
	                // 绑定地址和端口
	                .localAddress(new InetSocketAddress(mConfigBean.getServicePort()))
	                // 
//	                .childHandler((NettyChannelinitializer)content.getBean("logicNodeChannelinitializer"));
//	        		.childHandler(logicNodeChannelinitializer);
//	                .childHandler(
//	                		new NettyChannelinitializer(
//	                				this.taskExecutor,
//	                				this.context));
			        .childHandler(
		            		new NettyChannelinitializer(ctx, mConfigBean));
	        
	        // 绑定端口，开始接收进来的连接
	        ChannelFuture	 channelFuture = childHandler.bind(mConfigBean.getServicePort()).sync();	//	(7)
			
			//	等待服务器		socket	关闭	。												
			//	在这个例子中，这不会发生，但你可以优雅地关闭你的服务器。												
			channelFuture.channel().closeFuture().sync();
						
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
//			this.eventLoopGroupBoss.shutdownGracefully();
//			this.eventLoopGroupWorker.shutdownGracefully();
		}
	}
	
	
	public void stopService() {
		
		this.eventLoopGroupBoss.shutdownGracefully();
		this.eventLoopGroupWorker.shutdownGracefully();
		
	}
}
