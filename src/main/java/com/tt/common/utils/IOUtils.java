package com.tt.common.utils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author NJ
 * @create 2018-08-23 10:34
 **/
public class IOUtils {

    /**
     * 写入文件到本地
     *
     * @param targetUrl
     * @param path
     */
    public static void writeFile(String targetUrl, String path, String fileName) throws IOException {
        URL url = null;
        HttpURLConnection httpUrl = null;
        InputStream in = null;

        //输出流
        OutputStream out = null;
        try {
            url = new URL(targetUrl);
            httpUrl = (HttpURLConnection) url.openConnection();
            httpUrl.connect();
            httpUrl.getInputStream();
            in = httpUrl.getInputStream();

            out = new FileOutputStream(path + fileName, true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            byte[] buffer = new byte[1024];
            while (true) {
                int byteRead = in.read(buffer);
                if (byteRead == -1) break;
                try {
                    out.write(buffer, 0, byteRead);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            if (in != null)
                in.close();
            if (out != null) {
                out.close();
            }
        }
    }

    /**
     * 写入文件到本地
     *
     * @param path
     */
    public static void writeFile2(File file, String path, String fileName) throws IOException {
        InputStream in = new FileInputStream(file.getAbsolutePath());
        //输出流
        OutputStream out = null;
        try {
            out = new FileOutputStream(path + fileName, true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            byte[] buffer = new byte[1024];
            while (true) {
                int byteRead = in.read(buffer);
                if (byteRead == -1) break;
                try {
                    out.write(buffer, 0, byteRead);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            if (in != null) in.close();
            if (out != null) {
                out.close();
            }
        }
    }
}
