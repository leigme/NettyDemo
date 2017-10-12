package cn.com.yhcloud.netty;

import org.apache.log4j.Logger;

import java.nio.ByteBuffer;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

public class NetDecoder extends LengthFieldBasedFrameDecoder {

	public final static Logger log = Logger.getLogger(NetDecoder.class);
	
    private static final int FRAME_MAX_LENGTH = 16777216;

    public NetDecoder() {
        super(FRAME_MAX_LENGTH, 0, 4, 0, 0);
    }
    
    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
    	ByteBuf frame = null;
        try {
            frame = (ByteBuf) super.decode(ctx, in);
            if (null == frame) {
                return null;
            }

            ByteBuffer byteBuffer = frame.nioBuffer();
            byte[] outData = new byte[byteBuffer.remaining()];
            byteBuffer.get(outData, 0, outData.length);

            NetCommand netCommand = new NetCommand();
            netCommand.decodeCmd(outData);
            
            return netCommand;
        } catch (Exception e) {
        	e.printStackTrace();
            log.error("decode exception, " + BBBNetUtil.parseChannelRemoteAddr(ctx.channel()), e);
            BBBNetUtil.closeChannel(ctx.channel());
        } finally {
            if (null != frame) {
                frame.release();
            }
        }

        return null;
    }

}
