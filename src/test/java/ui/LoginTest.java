package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	
	/*
	  WebDriver: interface principal para testes web, com essa interface ajuda
	  a controlar o navegador, selecionar os elementos da página;
	  Também ajuda na hora de instanciar diferentes drivers dos navegadores para teste.
	  
	 */
	
	public static String browser = "Chrome";
	public static WebDriver driver;

	public static void main(String[] args) {
		
		if(browser.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			
			driver = new ChromeDriver(options);
			
		} else if (browser.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
//		Relative locator: são úteis quando não é fácil construir um localizador para o elemento desejado, 
//		mas é fácil descrever espacialmente onde o elemento está em relação a um elemento que possui um localizador facilmente construído
		
		driver.get("https://www.saucedemo.com/");
		WebElement password = driver.findElement(By.id("password"));
		By username = RelativeLocator.with(By.tagName("input")).above(password);
		driver.findElement(username).sendKeys("Testing");
//
				
//		Abrindo o navegador
//		ChromeDriver driver = new ChromeDriver(options);
//		driver.get("https://www.saucedemo.com/");
//		
////		Preenchendo os inputs
//		driver.findElement(By.id("user-name")).sendKeys("standard_user");
//		driver.findElement(By.id("password")).sendKeys("secret_sauce");
//		
////		Clicando no botão de "Login"
//		driver.findElement(By.id("login-button")).click();
		
//		Fechar o navegador
		driver.close();
	}

}
