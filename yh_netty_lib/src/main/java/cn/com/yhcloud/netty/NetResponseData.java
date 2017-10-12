package cn.com.yhcloud.netty;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class NetResponseData {
	
	// 协议版本
	private int version;
	// 命令类型
	private int cmdType;
	// 命令编码  C0101001
	private String cmdCode;
	// 命令数据
	private byte[] data;
	
	/**
	 * 编码协议
	 * 
	 * @return
	 */
	public byte[] encodeCmd() {
	 
		// 命令数据长度
		int dataLength = 0;
		
		if (null != data && data.length > 0) {
			dataLength = data.length;
		}
		
		// 整个命令的长度
		int totleCmdLength = 4+4+4 +this.cmdCode.getBytes().length+4+dataLength;
		
		 // 版本 
		 ByteBuffer cmdBuffer = ByteBuffer.allocateDirect(4+4+4+4+8+4+dataLength);
		 
		 // 整个命令长度 4
		 cmdBuffer.putInt(totleCmdLength);
		 // 版本 4
		 cmdBuffer.putInt(this.version);
		 // 命令类型 4
		 cmdBuffer.putInt(this.cmdType);
		 
		 // 命令编码  C0101001 8
		 cmdBuffer.putInt(this.cmdCode.getBytes().length);
		 cmdBuffer.put(this.cmdCode.getBytes());
		 
		 // 命令数据长度 4
		 cmdBuffer.putInt(dataLength);
		 
		 if (null != data && data.length > 0) {
			 // 命令数据
			 cmdBuffer.put(data,0,data.length);
		 }
		 cmdBuffer.flip();
		 
		 byte[] outData = new byte[cmdBuffer.remaining()];
		 cmdBuffer.get(outData, 0, outData.length);
			
		 return outData;
	 }
	
	
	
	/**
	 * 解码协议
	 * 
	 * @return
	 */
	public NetResponseData decodeCmd(byte[] datas) {
	 
		 ByteBuffer cmdBuffer = ByteBuffer.wrap(datas);
		 
		 // 整个命令长度 4
		 cmdBuffer.getInt();
		 
		 // 版本
		 int _ver = cmdBuffer.getInt();
		 this.version = _ver;
		 
		 // 命令类型 4
		 int _cmdType = cmdBuffer.getInt();
		 this.cmdType = _cmdType;
		
		 // 命令编码  C0101001 8
		 int cmdCodeLength = cmdBuffer.getInt();
		 byte[] _bCmdCode = new byte[cmdCodeLength];
		 for (int index = 0; index < cmdCodeLength; index++) {
			 _bCmdCode[index] = cmdBuffer.get(); 
		 }
		 String _cmdCode = new String(_bCmdCode);
		 this.cmdCode = _cmdCode;
		 
		 //  命令数据长度
		 int _dataLength = cmdBuffer.getInt();

		 if (_dataLength > 0) {
			this.data = new byte[_dataLength];
			for (int index = 0; index < _dataLength; index++) {
				this.data[index] = cmdBuffer.get();
			}
		 }
		 
		 return this;
	 }

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getCmdType() {
		return cmdType;
	}

	public void setCmdType(int cmdType) {
		this.cmdType = cmdType;
	}

	public String getCmdCode() {
		return cmdCode;
	}

	public void setCmdCode(String cmdCode) {
		this.cmdCode = cmdCode;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "NetResponseData [version=" + version + ", cmdType=" + cmdType + ", cmdCode=" + cmdCode + ", data="
				+ Arrays.toString(data) + "]";
	}
}
