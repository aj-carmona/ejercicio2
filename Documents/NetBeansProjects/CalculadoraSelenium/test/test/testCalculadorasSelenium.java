package test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author usuario
 */
@RunWith(Parameterized.class)

public class testCalculadorasSelenium {
    
    // atributo navegador para usarlo en los métodos 
    private WebDriver navegador;
    
    //atributos para cargar en el constructor los datos parametrizados
    private double base;
    private double altura;

    public testCalculadorasSelenium(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }
    
    
      @Parameterized.Parameters
   
      
      // Datos para 3 triángulos 
      
   public static Collection<Object[]> data() {
        Object[][] data = new Object[][] { 
            {2.5567, 3.5675}, 
            {10.4562, 2.1983}, 
            {145.6754, 56.6576} 
        } ;
        return Arrays.asList(data);
    }
    
   
    
    @BeforeClass
    public static void setUpClass() {
        
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        
    }
     @AfterClass
    public static void tearDownClass() {
    }
    
   
    
    //Antes de realizar el test abrimos el navegador . configuramos tiempo implicito 3 segundos y maximizamos la pantalla
    @Before
    public void setUp() {
        navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        navegador.manage().window().maximize();
        
    }
    //Después de cada test cerramos el navegador
     @After
    public void tearDown() {
        navegador.quit();
    }
    
    
    @Test
    public void testCalculadorasWebTriangulos(){
       
        
         // navagación en calcualdora Google
        navegador.get("https://google.es");
        navegador.findElement(By.id("L2AGLb")).click();
        
        WebElement cajaBusquedaGoogle = navegador.findElement(By.id("APjFqb"));
        cajaBusquedaGoogle.sendKeys("calculadora");
        cajaBusquedaGoogle.sendKeys(Keys.ENTER);

        WebElement inputCalculadoraGoogle = navegador.findElement(By.xpath("/html/body/div[5]/div/div[11]/div/div[2]/div[2]/div/div/div[1]/div/div/div/div[1]/div/div/div[1]/div[2]/div[2]/div"));
        
        WebElement botonMultiplica = navegador.findElement(By.xpath("/html/body/div[5]/div/div[11]/div/div[2]/div[2]/div/div/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[3]/td[4]/div/div"));
        WebElement botonDivide = navegador.findElement(By.xpath("/html/body/div[5]/div/div[11]/div/div[2]/div[2]/div/div/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[2]/td[4]/div/div"));
        WebElement botonIgual = navegador.findElement(By.xpath("/html/body/div[5]/div/div[11]/div/div[2]/div[2]/div/div/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[5]/td[3]/div/div"));

       inputCalculadoraGoogle.sendKeys(String.valueOf(this.base));
        
       botonMultiplica.click();
                
        
       inputCalculadoraGoogle.sendKeys(String.valueOf(this.altura));
        
       botonDivide.click();
       inputCalculadoraGoogle.sendKeys(String.valueOf(2));
       
       botonIgual.click();
       
       double resultadoGoogle = Double.parseDouble(inputCalculadoraGoogle.getText());
        
        
       // Navegación calculadora Web2.0
       
       navegador.get("https://web2.0calc.es/");
         navegador.findElement(By.className("fc-button-label")).click();
         
         WebElement inputCalculadoraWeb = navegador.findElement(By.id("input"));
         WebElement botonMultiplicaWeb = navegador.findElement(By.id("BtnMult"));
         WebElement botonDivideWeb = navegador.findElement(By.id("BtnDiv"));
         WebElement botonIgualWeb = navegador.findElement(By.id("BtnCalc"));
         
          
         inputCalculadoraWeb.sendKeys(String.valueOf(this.base));
         botonMultiplicaWeb.click();
         inputCalculadoraWeb.sendKeys(String.valueOf(this.altura));
         botonDivideWeb.click();
         inputCalculadoraWeb.sendKeys(String.valueOf(2));
         botonIgualWeb.click();
         
        inputCalculadoraWeb.click();
         
        double resultadoWeb = Double.parseDouble(inputCalculadoraWeb.getAttribute("value"));
       
        // Comparación y prueba , en este caso no hay un resultado experado porque son los dos resulados que obtenemos de las calculadoras
        assertEquals(resultadoGoogle, resultadoWeb, 0.000001);
        
        
    }

   
}
