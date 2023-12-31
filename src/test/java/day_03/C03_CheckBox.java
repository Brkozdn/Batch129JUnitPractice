package day_03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C03_CheckBox {


    /*
    CheckBox ==> BİRDEN FAZLA HANEYE TİK ATILABİLİR
     */


    // https://demo.guru99.com/test/radio.html adresine gidin
    // checkbox elementlerini locate edin
    // checkbox1 ve checkbox3  secili degil ise secin
    // checkbox1 ve checkbox3 elementlerinin secili oldugunu Test edin
    // checkbox2 elementinin secili olmadıgını test edin



    WebDriver driver;



    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }






    @After
    public void tearDown() throws Exception {
       // driver.close();
    }






    @Test
    public void name() {



        // https://demo.guru99.com/test/radio.html adresine gidin

        driver.get("https://demo.guru99.com/test/radio.html");










        // checkbox elementlerini locate edin

        WebElement checkbox1 = driver.findElement(By.xpath("//input[@id='vfb-6-0']"));

        WebElement checkbox2 = driver.findElement(By.xpath("//input[@id='vfb-6-1']"));

        WebElement checkbox3 = driver.findElement(By.xpath("//input[@id='vfb-6-2']"));











        // checkbox1 ve checkbox3  secili degil ise secin

        if(!checkbox1.isSelected()){
            checkbox1.click();
        }





        if(!checkbox3.isSelected()){
            checkbox3.click();
        }












        // checkbox1 ve checkbox3 elementlerinin secili oldugunu Test edin

        Assert.assertTrue(checkbox1.isSelected());

        Assert.assertTrue(checkbox3.isSelected());













        // checkbox2 elementinin secili olmadıgını test edin

        Assert.assertFalse(checkbox2.isSelected());


    }



}
