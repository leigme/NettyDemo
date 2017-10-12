package cn.com.yhcloud.netty.comm;

import java.io.Serializable;

public class ConfigBean implements Serializable {

    private String driver;

    private String dbUrl;

    private int classlistId;

    private String userName;

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public int getClasslistId() {
        return classlistId;
    }

    public void setClasslistId(int classlistId) {
        this.classlistId = classlistId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
