package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
//		Abrindo o navegador
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.saucedemo.com/");
		
//		Preenchendo os inputs
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		
//		Clicando no botão de "Login"
		driver.findElement(By.id("login-button")).click();
		
//		Fechar o navegador
		driver.close();
	}

}
