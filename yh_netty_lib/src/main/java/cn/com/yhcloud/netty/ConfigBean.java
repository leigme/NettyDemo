package cn.com.yhcloud.netty;

/**
 * @author leig
 * @version 20170301
 */
public class ConfigBean {

    public final static int HEART_COMMAND = 1001;

    public final static String RES_OK = "OK";

    public final static String RES_NG = "NG";

    public final static int INT_SIZE = 4;

    private int MaxReadIdleTimeSeconds;

    private int MaxWriteIdleTimeSeconds;

    private int MaxAllIdleTimeSeconds;

    private int SocketSendBufferSize;

    private int SocketRecvBufferSize;

    private int ServicePort;

    public int getMaxReadIdleTimeSeconds() {
        return MaxReadIdleTimeSeconds;
    }

    public void setMaxReadIdleTimeSeconds(int maxReadIdleTimeSeconds) {
        MaxReadIdleTimeSeconds = maxReadIdleTimeSeconds;
    }

    public int getMaxWriteIdleTimeSeconds() {
        return MaxWriteIdleTimeSeconds;
    }

    public void setMaxWriteIdleTimeSeconds(int maxWriteIdleTimeSeconds) {
        MaxWriteIdleTimeSeconds = maxWriteIdleTimeSeconds;
    }

    public int getMaxAllIdleTimeSeconds() {
        return MaxAllIdleTimeSeconds;
    }

    public void setMaxAllIdleTimeSeconds(int maxAllIdleTimeSeconds) {
        MaxAllIdleTimeSeconds = maxAllIdleTimeSeconds;
    }

    public int getSocketSendBufferSize() {
        return SocketSendBufferSize;
    }

    public void setSocketSendBufferSize(int socketSendBufferSize) {
        SocketSendBufferSize = socketSendBufferSize;
    }

    public int getSocketRecvBufferSize() {
        return SocketRecvBufferSize;
    }

    public void setSocketRecvBufferSize(int socketRecvBufferSize) {
        SocketRecvBufferSize = socketRecvBufferSize;
    }

    public int getServicePort() {
        return ServicePort;
    }

    public void setServicePort(int servicePort) {
        ServicePort = servicePort;
    }
}
