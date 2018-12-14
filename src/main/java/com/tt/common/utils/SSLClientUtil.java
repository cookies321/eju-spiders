package com.tt.common.utils;

import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import static org.eclipse.jetty.util.URIUtil.HTTPS;

public class SSLClientUtil {


    public static CloseableHttpClient createSSLClientDefault(){

        try {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {

                //信任所有
                public boolean isTrusted(X509Certificate[] chain,String authType) throws CertificateException {
                    return true;
                }
            }).build();

            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext,new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.2"}, null, NoopHostnameVerifier.INSTANCE);

            Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("http", new PlainConnectionSocketFactory())
                    .register(HTTPS, sslsf)
                    .build();

            PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(registry);
            cm.setMaxTotal(500);// 连接池最大并发连接数
            cm.setDefaultMaxPerRoute(300);// 单路由最大并发数

            //设置超时时间
            SocketConfig socketConfig = SocketConfig.custom()
                    .setSoKeepAlive(true)
                    .setSoLinger(1)
                    .setSoReuseAddress(true)
                    .setSoTimeout(3000)
                    .setTcpNoDelay(true).build();

            return HttpClients.custom().
                    setSSLSocketFactory(sslsf)
                    .setConnectionManager(cm)
                    .setDefaultSocketConfig(socketConfig)
                    .setConnectionManagerShared(true).build();

        } catch (KeyManagementException e) {

            e.printStackTrace();

        } catch (NoSuchAlgorithmException e) {

            e.printStackTrace();

        } catch (KeyStoreException e) {

            e.printStackTrace();

        }
        return  HttpClients.createDefault();
    }
}
