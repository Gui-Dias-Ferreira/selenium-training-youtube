package ui;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoAutomation {

	public static void main(String[] args) {

//		System.setProperty("webdriver.gecko.driver", "C:\\browserdrivers\\geckodriver.exe");
//		Esse gerenciador tira a necessidade de ficar indicando o caminho dos drivers dos navegadores.
		WebDriverManager.chromedriver().setup();
		
//		A nova versão do Google (111.0.5563.65) está gerando um erro na hora da execução do Selenium para abrir o browser
//		A solução foi usar o ChromeOptions no momento.
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");	

		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.google.com/");

	}

}
