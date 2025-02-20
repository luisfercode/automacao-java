package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LinkedInLoginTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {



        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));




    }

    @Test
    public void testLinkedInLogin() throws InterruptedException {
        // Acessa a página de login do LinkedIn
        driver.get("https://www.linkedin.com/login");

        // Localiza os campos de e-mail e senha e insere os dados
        WebElement emailField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

        emailField.sendKeys("dev.fernando.js@gmail.com");  // Substitua pelo seu e-mail
        passwordField.sendKeys("b1l4h3443311@");        // Substitua pela sua senha
        loginButton.click();

        // Aguarda um tempo para visualizar o resultado (apenas para fins de teste)
        Thread.sleep(3000);

        // Verifica se o login foi bem-sucedido procurando um elemento da página inicial
        boolean isLoggedIn = driver.findElements(By.id("global-nav-typeahead")).size() > 0;
        assertTrue(isLoggedIn, "O login falhou!");

        // Aguarda mais um tempo para visualizar o resultado
        Thread.sleep(2000);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
