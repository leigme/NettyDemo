package cn.com.yhcloud.netty;

import org.apache.log4j.Logger;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class NetEncoder extends MessageToByteEncoder<NetCommand> {
	
	public final static Logger log = Logger.getLogger(NetEncoder.class);
	
	@Override
	protected void encode(ChannelHandlerContext ctx, NetCommand msg, ByteBuf out) throws Exception {
			
		try {
			
			byte[] outData = msg.encodeCmd();

			out.writeBytes(outData);

        } catch (Exception e) {
        	e.printStackTrace();
            log.error("encode exception, " + BBBNetUtil.parseChannelRemoteAddr(ctx.channel()), e);
            if (null != msg) {
                log.error(msg.toString());
            }
            BBBNetUtil.closeChannel(ctx.channel());
        }
	}
}
