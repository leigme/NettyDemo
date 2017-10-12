package cn.com.yhcloud.netty;

import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleStateEvent;

public class NettyMessageHandler extends SimpleChannelInboundHandler<NetCommand> {

	public final static Logger log = Logger.getLogger(NettyServer.class);

	// 环境变量
	private ChannelHandlerContext ctx;

	private ConfigBean mConfigBean;

	public NettyMessageHandler() {
		super();
	}


	public NettyMessageHandler(ChannelHandlerContext ctx, ConfigBean configBean) {
		super();
		this.ctx = ctx;
		this.mConfigBean = configBean;
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		final String remoteAddress = BBBNetUtil.parseChannelRemoteAddr(ctx.channel());
	}
	
	
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, NetCommand command) throws Exception {
		final String remoteAddress = BBBNetUtil.parseChannelRemoteAddr(ctx.channel());
        log.debug("TreeServerHandler 接收到数据 : channelActive, the channel[" + remoteAddress + "]");
        log.debug("接收到数据==> : " + command.toString());
        
        
        log.debug("消息类型===> : " + command.getCmdType());
        
        // 心跳类型
        if (mConfigBean.HEART_COMMAND == command.getCmdType()) {
        	
        	// 一个心跳包发送过来了
        	handleHeartMsg(ctx);
        	
        } else { // 其他命令类型
        	handleData(ctx, command);
        }

	}

	/**
	 * 进入和出去的正常数据的处理
	 *
	 * @param ctx
	 * @param command
	 */
	protected void handleData(ChannelHandlerContext ctx, NetCommand command) {
		ctx.channel().writeAndFlush(command);
	}


    
    /**
     * 处理心跳响应信息
     * 
     * @param context
     */
    private void handleHeartMsg(ChannelHandlerContext context) {
    	
    	//log.info("处理心跳响应信息");
    	
    	// 准备发送命令
		NetCommand netCommand = new NetCommand();
		netCommand.setVersion(2);
		// 命令Id
		netCommand.setCmdId("00000001");
		// 命令类型(心跳)
		netCommand.setCmdType(mConfigBean.HEART_COMMAND);
		// 命令编号(CT00000001 心跳响应包)
		netCommand.setCmdCode("CT00000001");
		// 命令参数
		NetCmdDataHeartDP.NetCmdDataHeartDto.Builder netCmdDataHeartDtoBuilder 
			= NetCmdDataHeartDP.NetCmdDataHeartDto.newBuilder();
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// new Date()为获取当前系统时间
		String nowTime = df.format(System.currentTimeMillis());
		netCmdDataHeartDtoBuilder.setTime(nowTime);
		// 21 服务器 到 客户端  12 客户端 到 服务器
		netCmdDataHeartDtoBuilder.setDirection(21);
		
		NetCmdDataHeartDP.NetCmdDataHeartDto netCmdDataHeartDto 
			= netCmdDataHeartDtoBuilder.build();
		
		netCommand.setData(netCmdDataHeartDto.toByteArray());
		
		context.channel().writeAndFlush(netCommand);
		
    }
	
	/**
	 * 异常的处理
	 */
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		// TODO Auto-generated method stub
		//super.exceptionCaught(ctx, cause);
		cause.printStackTrace();
		
		log.error("错误信息 : " + cause.getMessage());
	}
	
	/**
	 * 空闲事件处理
	 */
	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
		// IdleStateHandler 所产生的 IdleStateEvent 的处理逻辑.
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent e = (IdleStateEvent) evt;
            switch (e.state()) {
                case READER_IDLE:
                    handleReaderIdle(ctx);
                    break;
                case WRITER_IDLE:
                    handleWriterIdle(ctx);
                    break;
                case ALL_IDLE:
                    handleAllIdle(ctx);
                    break;
                default:
                    break;
            }
        }
	}
	
    protected void handleReaderIdle(ChannelHandlerContext ctx) {
        log.info("---READER_IDLE---");
        log.info("---client " + ctx.channel().remoteAddress().toString() + " reader timeout, close it---");
        // 客户端连接超时,关闭与客户端的连接
        ctx.close();
    }

    protected void handleWriterIdle(ChannelHandlerContext ctx) {
    	log.info("---WRITER_IDLE---");
    }

    protected void handleAllIdle(ChannelHandlerContext ctx) {
    	log.info("---ALL_IDLE---");
    }

}
