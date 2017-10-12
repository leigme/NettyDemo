package cn.com.yhcloud.netty.comm;

import org.apache.log4j.Logger;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ConfigAnalysis {

    private final static Logger log = Logger.getLogger(ConfigAnalysis.class);

    private String mConfigPath;

    // 文件操作对象
    private FileInputStream fis = null;

    private InputStreamReader isr = null;

    private BufferedReader bre = null;

    private String fileString;

    /**
     * 解析构造函数
     *
     * @param configPath
     */
    public ConfigAnalysis(String configPath) {
        mConfigPath = configPath;
    }

    /**
     * 开始解析配置文件
     *
     * @return
     */
    public ConfigBean startAnalysis() throws IOException {
        // 准备返回数据
        ConfigBean configBean = new ConfigBean();

        File confFile = new File(mConfigPath);

        if (!confFile.exists()) {
            log.error("配置文件不存在...");
            throw new IOException("配置文件不存在...");
        }

        fis = new FileInputStream(mConfigPath);
        isr = new InputStreamReader(fis, "UTF-8");
        bre = new BufferedReader(isr);

        Class mClass = ConfigBean.class;

        // 判断最后一行不存在，为空结束循环
        while ((fileString = bre.readLine()) != null) {
            if ("".equals(fileString)) {
                continue;
            }
            if(fileString.contains("=")) {
                String[] strs = fileString.split("=");
                String key = strs[0];
                String value = "";
                for (int i = 1; i < strs.length; i++) {
                    value += strs[i];
                    if (i < strs.length - 1) {
                        value += "=";
                    }
                }
                setValue(mClass, configBean, key, value);
            }
        }

        return configBean;
    }

    private void setValue(Class mClass, Object object, String key,
                          String value) {

        String str = key.substring(0,1).toUpperCase() + key.substring(1);

        Method method;

        try {
            Field field = mClass.getDeclaredField(key);
            if (String.class == field.getType()) {
                method = mClass.getMethod("set" + str, String.class);
                method.invoke(object, value);
            } else if (int.class == field.getType()) {
                method = mClass.getMethod("set" + str, int.class);
                method.invoke(object, Integer.parseInt(value));
            } else if (boolean.class == field.getType()) {
                method = mClass.getMethod("set" + str, boolean.class);
                if ("true".equals(value)) {
                    method.invoke(object, true);
                } else {
                    method.invoke(object, false);
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
