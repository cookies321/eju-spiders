package com.tt.vo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author NJ
 * @create 2018-08-14 16:05
 **/
public class Context {

    private static final Logger LOGGER = LoggerFactory.getLogger(Context.class);

    private byte[] data;

    public String filename;

    private String basename;
    private String contenttype;

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getBasename() {
        return basename;
    }

    public void setBasename(String basename) {
        this.basename = basename;
    }

    public String getContenttype() {
        return contenttype;
    }

    public void setContenttype(String contenttype) {
        this.contenttype = contenttype;
    }
}
