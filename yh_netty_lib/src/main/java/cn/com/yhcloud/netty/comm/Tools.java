package cn.com.yhcloud.netty.comm;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

public class Tools {

    /**
     * 序列化对象到文件,JSON格式
     *
     * @param filePath
     * @param content
     * @throws IOException
     */
    public static void serializeFile(String filePath, String content) throws
            IOException {

        File file = new File(filePath);

        if (file.exists() && file.isDirectory()) {
            throw new IOException("传入的路径不是可访问的文件路径");
        }

        if (!file.exists()) {
            file.createNewFile();
        }

        FileOutputStream fos = new FileOutputStream(file);
        OutputStreamWriter write = new OutputStreamWriter(fos,"utf8");

        BufferedWriter writer = new BufferedWriter(write);

        writer.write(content);
        writer.close();
        write.close();
        fos.close();
    }

    /**
     * JSON格式文件转换字符串方法
     *
     * @param filePath
     * @return
     * @throws IOException
     */
    public static String fileToString(String filePath) throws IOException {

        FileInputStream fis = new FileInputStream(filePath);
        InputStreamReader isr = new InputStreamReader(fis, "utf8");
        BufferedReader bre = new BufferedReader(isr);

        String str;

        StringBuffer sb = new StringBuffer();

        while (null != (str = bre.readLine())) {
            if ("".equals(str)) {
                continue;
            }
            sb.append(str);
        }

        return sb.toString();
    }

    /**
     * 随机数生成方法
     *
     * @param size
     * @return
     */
    public static int randomNum(int size) {

        Random rand = new Random();

        return rand.nextInt(size);
    }

    /**
     * 给对象设置值
     *
     * @param mClass
     * @param object
     * @param key
     * @param value
     */
    public static void setValue(Class mClass, Object object, String key,
                          String value) {

        String str = key.substring(0, 1).toUpperCase() + key.substring(1);

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
