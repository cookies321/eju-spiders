package com.tt.common.utils;

import org.apache.http.HttpHost;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.CapabilityType.PROXY;


public class WebDriverUtils {

	private static final String PHANTOMJS_DRIVER = "E:\\Ksoftware\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe";
	private static final String FIREFOX_DRIVER = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";
	private static final String IE_DRIVER = "E:\\Ksoftware\\webdriver\\IEDriverServer.exe";
	//private static final String CHROME_DRIVER = "E:\\Ksoftware\\webdriver\\chromedriver.exe";
	private static final String CHROME_DRIVER = "E:\\Ksoftware\\webdriver\\72\\chromedriver.exe";
	/**
	 *
	 * 功能描述: 
	 *
	 * @param:
	 * @return: 
	 * @auther: 赵乐
	 * @date: 2018/12/6 11:27
	 */
	public static  WebDriver openChrome(HttpHost iPoolProxy){
		System.setProperty("webdriver.chrome.driver", CHROME_DRIVER);
		// 设置必要参数
		DesiredCapabilities dcaps = DesiredCapabilities.chrome();
		// ssl证书支持
		dcaps.setCapability("acceptSslCerts", true);
		// 截屏支持
		dcaps.setCapability("takesScreenshot", true);
		// css搜索支持
		dcaps.setCapability("cssSelectorsEnabled", true);
		// js支持
		dcaps.setJavascriptEnabled(true);
		// 驱动支持 --模拟浏览器的安装地址
		//dcaps.setCapability(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, CHROME_DRIVER);
		dcaps.setCapability("profile.managed_default_content_settings.images", 2);
		if (iPoolProxy!=null) {
			// 取出集合中的一个ip
			String hostName = iPoolProxy.getHostName();
			int port = iPoolProxy.getPort();

			// 创建代理对象
			Proxy proxy = new Proxy();
			// 选择代理类型为手动代理
			proxy.setProxyType(Proxy.ProxyType.MANUAL);
			// 关闭自动检测代理设置
			proxy.setAutodetect(false);
			// 设置代理ip及端口号
			String proxyIpAndProt=hostName+":"+port;
			proxy.setHttpProxy(proxyIpAndProt).setFtpProxy(proxyIpAndProt).setSslProxy(proxyIpAndProt);
			// 传入代理对象
			dcaps.setCapability(CapabilityType.PROXY, proxy);
		}else{
			System.err.println("未传入代理信息！返回系统代理");
		}
		//设置头部信息
		ChromeOptions options = new ChromeOptions();
		// 设置响应头 userAgent
		options.addArguments("--user-agent="+UserAgentUtils.randomGet());
		//不显示提示信息
		options.addArguments("--disable-infobars");
		// 创建无界面浏览器对象
		options.addArguments("--headless");
		options.addArguments("--disable-gpu");
		//设置编码格式
		options.addArguments("--lang=zh_CN.UTF-8");
		//地址栏显示"data:,"
		//options.addArguments("--user-data-dir=C:/Users/eju/AppData/Local/Google/Chrome/User Data/Default");

		dcaps.setCapability(ChromeOptions.CAPABILITY, options);
		WebDriver driver =new ChromeDriver(dcaps);

		driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		//driver.manage().window().setSize(new Dimension(1928,1048));
		//driver.manage().window().maximize();
		return driver;
	}
	
	/**
	 *
	 * 功能描述: 
	 * IE driver启动时候必须以100%大小启动
	 * 在IE浏览器中运行速度很慢，不建议使用
	 * @param: 
	 * @return: 
	 * @auther: 赵乐
	 * @date: 2018/12/6 11:27
	 */
	public static  WebDriver openIE(){
		System.setProperty("webdriver.ie.driver", IE_DRIVER);
		DesiredCapabilities dcaps = DesiredCapabilities.internetExplorer();
		dcaps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		//IE默认启动保护模式，要么手动在浏览器的设置中关闭保护模式，要么在代码中加上这一句，即可
		dcaps.setCapability("ignoreProtectedModeSettings", true);

		WebDriver driver =new InternetExplorerDriver(dcaps);
		return driver;
	}
	/**
	 *
	 * 功能描述: 
	 *
	 * @param: Firefox
	 * @return: 
	 * @auther: 赵乐
	 * @date: 2018/12/5 11:54
	 */
	public static WebDriver openFirefox(HttpHost iPoolProxy){
		System.setProperty("webdriver.firefox.bin", FIREFOX_DRIVER);
		//加载驱动
		System.setProperty("webdriver.gecko.driver","E:\\Ksoftware\\geckodriver.exe");

		WebDriver driver =new FirefoxDriver();
		return driver;
	}

	/**
	 *
	 * 功能描述: phantomjs
	 *
	 * @param: 
	 * @return:
	 * @auther: 赵乐
	 * @date: 2018/12/4 17:20
	 */
	public static WebDriver openPhantomJs(HttpHost iPoolProxy) {
		// 设置必要参数
		DesiredCapabilities dcaps = DesiredCapabilities.phantomjs();
		// ssl证书支持
		dcaps.setCapability("acceptSslCerts", true);
		// 截屏支持
		dcaps.setCapability("takesScreenshot", true);
		// css搜索支持
		dcaps.setCapability("cssSelectorsEnabled", true);
		// js支持
		dcaps.setJavascriptEnabled(true);
		// 驱动支持 --模拟浏览器的安装地址
		dcaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, PHANTOMJS_DRIVER);
		// 设置响应头 userAgent
		dcaps.setCapability("phantomjs.page.settings.userAgent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 "
				+ "(KHTML, like Gecko) Chrome/49.0.2623.221 Safari/537.36 SE 2.X MetaSr 1.0");

		// 不载入图片，爬页面速度会快很多
		dcaps.setCapability("phantomjs.page.settings.loadImages", false);
		if (iPoolProxy!=null) {
			// 取出集合中的一个ip
			String hostName = iPoolProxy.getHostName();
			int port = iPoolProxy.getPort();

			// 创建代理对象
			Proxy proxy = new Proxy();
			// 选择代理类型为手动代理
			proxy.setProxyType(Proxy.ProxyType.MANUAL);
			// 关闭自动检测代理设置
			proxy.setAutodetect(false);
			// 设置代理ip及端口号
			String proxyIpAndProt=hostName+":"+port;
			proxy.setHttpProxy(proxyIpAndProt).setFtpProxy(proxyIpAndProt).setSslProxy(proxyIpAndProt);
			// 传入代理对象
			dcaps.setCapability(PROXY, proxy);

		}else{
			System.err.println("未传入代理信息！返回系统代理");
		}
		// 创建无界面浏览器对象
		WebDriver driver = new PhantomJSDriver(dcaps);
		driver.manage().timeouts().pageLoadTimeout(120,TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(120, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().setSize(new Dimension(1920,1080));
		return driver;
	}
}
