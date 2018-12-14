package com.tt.vo;

/**
 * @author NJ
 * @create 2018-08-03 10:33
 **/
public class ProxyVo {

    private String ip;
    private int prot;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getProt() {
        return prot;
    }

    public void setProt(int prot) {
        this.prot = prot;
    }

    @Override
    public String toString() {
        return "Proxy{" +
                "ip='" + ip + '\'' +
                ", prot=" + prot +
                '}';
    }
}
