package Page;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageTsoft {
public static WebDriver driver;
	
	public static void AbrirUrl() throws IOException {
		 
		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		String url = "https://www.phptravels.net/admin-portal/admin";
		driver.get(url);			
	}
	
	
	public static void LoginMenu() throws Exception {		
				
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div[1]/form[1]/button")));
				
		WebElement TxtUser = driver.findElement(By.name("email"));
		TxtUser.sendKeys("admin@phptravels.com"); 
		
		WebElement TxtPassword = driver.findElement(By.name("password"));
		TxtPassword.sendKeys("demoadmin");		
		
		WebElement BtnLogin = driver.findElement(By.xpath("//html/body/div[1]/form[1]/button"));
		BtnLogin.click();
				
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='social-sidebar-menu']/li[3]/a")));	
		WebElement MenuItem = driver.findElement(By.xpath("//*[@id='social-sidebar-menu']/li[3]/a"));
		MenuItem.click();
		
		//ACA DEBE IR EL MOVER EL MOUSE
		WebElement subModulo = driver.findElement(By.xpath("//*[@id='social-sidebar-menu']/li[8]/a"));
		Actions mouse = new Actions(driver);
		mouse.moveToElement(subModulo);
		subModulo.click();
 		 
//		WebElement subModulo = driver.findElement(By.xpath("//*[@id='social-sidebar-menu']/li[8]/a"));
//        Coordinates coord = ((RemoteWebElement)subModulo).getCoordinates();
//        ((RemoteWebDriver) driver).getMouse().mouseMove(coord);
 		
 		Thread.sleep(2000);
 		WebElement SubMenuItem = driver.findElement(By.xpath("//*[@id='Flights']/li[6]/a")); 		
		JavascriptExecutor js = ((JavascriptExecutor) driver);        
        js.executeScript("arguments[0].scrollIntoView();", SubMenuItem);//Baja el  scroll hasta que encuentra el  elemento
 		SubMenuItem.click();
		 
	}
	
 
	public static void IngresoVuelo() throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='content']/div[2]/div[2]/div/div/div[1]/div[1]/a")));
		
		WebElement BtnADD = driver.findElement(By.xpath("//*[@id='content']/div[2]/div[2]/div/div/div[1]/div[1]/a"));
		BtnADD.click();
		
		//espera a que cargue la pantalla de ingreso
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("cHRfZmxpZ2h0cy50aXRsZQ--")));
				 
		WebElement TxtTitle = driver.findElement(By.name("cHRfZmxpZ2h0cy50aXRsZQ--"));
		TxtTitle.sendKeys("Prueba Daniel Manzo");
															
		WebElement TxtPrecio = driver.findElement(By.name("cHRfZmxpZ2h0cy5wcmljZQ--"));
		TxtPrecio.sendKeys("750");
																										
		WebElement ComboStatus = driver.findElement(By.name("cHRfZmxpZ2h0cy5zdGF0dXM-"));
		Select OpStatus = new Select(ComboStatus);
		OpStatus.selectByVisibleText("No");
		
		Thread.sleep(3000);		
		WebElement BtnSaveReturn = driver.findElement(By.xpath("//a[@class='btn btn-primary xcrud-action']"));
		BtnSaveReturn.click();
						
	}
	
	public static void BuscarVuelo() throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);			
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='xcrud-search-toggle btn btn-default']")));
					
		WebElement BtnSearch = driver.findElement(By.xpath("//a[@class='xcrud-search-toggle btn btn-default']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);        
        js.executeScript("arguments[0].scrollIntoView();", BtnSearch);//Baja el  scroll hasta que encuentra el  elemento
        BtnSearch.click();			
        
		//espera a que cargue el input de busqueda
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("phrase")));				 
		WebElement TxtBuscar = driver.findElement(By.name("phrase"));
		TxtBuscar.sendKeys("Daniel"); 
		
		Thread.sleep(5000);
		
		JavascriptExecutor js2 = ((JavascriptExecutor) driver);        
		WebElement BtnGO = driver.findElement(By.xpath("//a[@class='xcrud-action btn btn-primary']"));
        js2.executeScript("arguments[0].scrollIntoView();", BtnGO);//Baja el  scroll hasta que encuentra el  elemento
        BtnGO.click();

		Thread.sleep(8000);		
		WebElement BtnLupa = driver.findElement(By.cssSelector(".fa-search"));
		BtnLupa.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-warning xcrud-action']")));
		WebElement BtnReturn = driver.findElement(By.xpath("//a[@class='btn btn-warning xcrud-action']"));
		BtnReturn.click();
		 		 
	}
	
	public static void ModificarVuelo() throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".fa-edit")));
		
		WebElement BtnEditar = driver.findElement(By.cssSelector(".fa-edit"));
		BtnEditar.click();	
		
		//espera a que cargue la pantalla de ingreso
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("cHRfZmxpZ2h0cy50aXRsZQ--")));
				 
		WebElement TxtTitle = driver.findElement(By.name("cHRfZmxpZ2h0cy50aXRsZQ--"));
		TxtTitle.clear();
		TxtTitle.sendKeys("PRUEBA TSOFT AUTOMATIZADOR DANIEL");
															
		WebElement TxtPrecio = driver.findElement(By.name("cHRfZmxpZ2h0cy5wcmljZQ--"));
		TxtPrecio.clear();
		TxtPrecio.sendKeys("180619");
																										
		WebElement ComboStatus = driver.findElement(By.name("cHRfZmxpZ2h0cy5zdGF0dXM-"));
		Select OpStatus = new Select(ComboStatus);
		OpStatus.selectByVisibleText("Yes");
		
		Thread.sleep(3000);		
		WebElement BtnSaveReturn = driver.findElement(By.xpath("//a[@class='btn btn-primary xcrud-action']"));
		BtnSaveReturn.click();
				 
	}
	
	
	public static void BorrarVuelo() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-danger > .fa")));
		WebElement BtnEliminar = driver.findElement(By.cssSelector(".btn-danger > .fa"));
		BtnEliminar.click();			
		Thread.sleep(2000);		
		driver.switchTo().alert().accept();		
		
		WebElement BtnLogout = driver.findElement(By.cssSelector(".fa-sign-out"));
		BtnLogout.click();	

	}
	
	
}
