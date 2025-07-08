package projetobasico.core;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {
	
	//private static WebDriver driver;
	
	private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>() {
		@Override	
		protected synchronized WebDriver initialValue() {
			return initDriver();
		}
	};
	
	private DriverFactory() {}
	
	public static WebDriver getDriver() {
		return threadDriver.get();
	}
	
	public static WebDriver initDriver() {
		WebDriver driver = null;
		
		switch (Propriedades.browser) {
			case EDGE: driver = new EdgeDriver();
			break;
			
			case CHROME: driver = new ChromeDriver();
			break;
		default:
			break;
		}
		
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		return driver;
	}
	
	public static void killDriver() {
		WebDriver driver = getDriver();
		
		if(driver != null) {
			driver.quit();
			driver = null;
		}
		
		if(threadDriver != null) {
			threadDriver.remove();
		}
	}

}
