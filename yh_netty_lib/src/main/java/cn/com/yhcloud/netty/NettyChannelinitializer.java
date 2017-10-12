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

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

/**
 * 运算节点 连接渠道 初期化类
 * 
 * @author lifeng
 * @version 20161017
 */
public class NettyChannelinitializer extends ChannelInitializer<SocketChannel> {

    // 上下文环境
    private ChannelHandlerContext ctx;

	private ConfigBean mConfigBean;

	/**
	 * 构造方法
	 * @param ctx
	 */
	public NettyChannelinitializer(ChannelHandlerContext ctx, ConfigBean configBean) {
		super();
		this.ctx = ctx;
		this.mConfigBean = configBean;
	}


	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		
		// 配置信息对象
		ConfigBean configBean = new ConfigBean();
		
		// 空闲超时时间的控制
		ch.pipeline().addLast(
			 "idleStateHandler",
			 new IdleStateHandler(
					 mConfigBean.getMaxReadIdleTimeSeconds(),
					 mConfigBean.getMaxWriteIdleTimeSeconds(),
					 mConfigBean.getMaxAllIdleTimeSeconds()));
		
        ch.pipeline().addLast(
                //
//                                        defaultEventExecutorGroup, //
        		new NetEncoder(), //
//        		netEncoder,
        		new NetDecoder(), //
//        		netDecoder,
//                new IdleStateHandler(0, 0, logicNodeData.getMaxIdleTimeSeconds()), //
//                new TreeConnetManageHandler(), //
        		//new NettyMessageHandler(applicationContext,taskExecutor)
        		new NettyMessageHandler(ctx, configBean)
//        		logicNodeMessageHandler
                );
	}
}
