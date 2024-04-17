/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoraselenium;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author usuario
 * 
 */
public class ExamenCalculadorasSelenium {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //navegador.manage().window().fullscreen();
        navegador.manage().window().maximize();
        /*
        navegador.get("https://google.es");
        navegador.findElement(By.id("L2AGLb")).click();
        
        WebElement cajaBusquedaGoogle = navegador.findElement(By.id("APjFqb"));
        cajaBusquedaGoogle.sendKeys("calculadora");
        cajaBusquedaGoogle.sendKeys(Keys.ENTER);

        WebElement inputCalculadoraGoogle = navegador.findElement(By.xpath("/html/body/div[5]/div/div[11]/div/div[2]/div[2]/div/div/div[1]/div/div/div/div[1]/div/div/div[1]/div[2]/div[2]/div"));
        double base = 12.5678;
        double altura = 20.5555;
        WebElement botonMultiplica = navegador.findElement(By.xpath("/html/body/div[5]/div/div[11]/div/div[2]/div[2]/div/div/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[3]/td[4]/div/div"));
        WebElement botonDivide = navegador.findElement(By.xpath("/html/body/div[5]/div/div[11]/div/div[2]/div[2]/div/div/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[2]/td[4]/div/div"));
        WebElement botonIgual = navegador.findElement(By.xpath("/html/body/div[5]/div/div[11]/div/div[2]/div[2]/div/div/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[5]/td[3]/div/div"));

       inputCalculadoraGoogle.sendKeys(String.valueOf(base));
        
       botonMultiplica.click();
                
        
       inputCalculadoraGoogle.sendKeys(String.valueOf(altura));
        
       botonDivide.click();
       inputCalculadoraGoogle.sendKeys(String.valueOf(2));
       
       botonIgual.click();
       
       double resultadoGoogle = Double.parseDouble(inputCalculadoraGoogle.getText());
       
        System.out.println(resultadoGoogle);
        
         */
        navegador.get("https://web2.0calc.es/");
        navegador.findElement(By.className("fc-button-label")).click();

        WebElement inputCalculadoraWeb = navegador.findElement(By.id("input"));
        WebElement botonMultiplicaWeb = navegador.findElement(By.id("BtnMult"));
        WebElement botonDivideWeb = navegador.findElement(By.id("BtnDiv"));
        WebElement botonIgualWeb = navegador.findElement(By.id("BtnCalc"));

        double base = 12.5678;
        double altura = 20.5555;
        //Antonio Jesus Carmona Ontanilla

        inputCalculadoraWeb.sendKeys(String.valueOf(base));
        botonMultiplicaWeb.click();
        inputCalculadoraWeb.sendKeys(String.valueOf(altura));
        botonDivideWeb.click();
        inputCalculadoraWeb.sendKeys(String.valueOf(2));
        botonIgualWeb.click();

        inputCalculadoraWeb.click();

        double resultadoWeb = Double.parseDouble(inputCalculadoraWeb.getAttribute("value"));
        System.out.println(resultadoWeb);

    }

}
