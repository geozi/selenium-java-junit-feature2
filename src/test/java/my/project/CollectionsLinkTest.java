package my.project;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

@Order(4)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CollectionsLinkTest {

    private static ChromeDriver chromeDriver;
    private static Hoverer hoverer;
    private static Clicker clicker;
    private static Actions actions;
    private static WebDriverWait wait;
    private static WebElement element;

    @BeforeAll
    static void initializeFields() {
        System.out.println("\nRunning " + CollectionsLinkTest.class.getSimpleName() + "...");

        chromeDriver = new ChromeDriver();
        actions = new Actions(chromeDriver);
        clicker = new Clicker(chromeDriver);
        hoverer = new Hoverer(chromeDriver);
        wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));
    }

    @BeforeEach
    void setUpWaiting() {
        actions.pause(Duration.ofSeconds(3)).perform();
    }

    @Test
    @Order(1)
    @DisplayName("Opening the website")
    void openWebsite() {

        // Arrange
        String expectedWebsite = "https://oapen.org/";

        // Act
        System.out.println("Opening the website...");
        chromeDriver.get(expectedWebsite);
        String currentWebsite = chromeDriver.getCurrentUrl();

        // Assert
        assertAll(
                "Failure in correctly opening the website",
                () -> assertNotNull(currentWebsite),
                () -> assertEquals(currentWebsite, expectedWebsite)
        );
    }

    @Test
    @Order(2)
    @DisplayName("Maximize browser window")
    void maximizeBrowserWindow() {
        // Act
        try {
            System.out.println("Maximizing browser window...");
            chromeDriver.manage().window().maximize();
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    @Order(3)
    @DisplayName("Hover over the 'Collections' link")
    void hoverOverCollectionsLink() {
        // Act
        try {
            element = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Collections")));
            System.out.println("Hovering over the 'Collections' link...");
            hoverer.hover(element, actions);
        } catch (NoSuchElementException | ElementNotInteractableException e) {
            fail(e.getMessage());
        }
    }

    @Test
    @Order(4)
    @DisplayName("Click the 'Collections' link")
    void clickCollectionsLink() {
        // Act
        try {
            System.out.println("Clicking the 'Collections' link...");
            clicker.click(element);
        } catch(NoSuchElementException | ElementNotInteractableException e) {
            fail(e.getMessage());
        }
    }

    @Test
    @Order(5)
    @DisplayName("Check navigation to webpage")
    void checkNavigationToWebpage() {
        // Arrange
        String expectedWebsite = "https://library.oapen.org/browse?type=collection";

        // Act
        String currentWebsite = chromeDriver.getCurrentUrl();
        System.out.println("Checking if url is correct...");

        // Assert
        assertAll(
                "Failure in fetching the specified webpage",
                () -> assertNotNull(currentWebsite),
                () -> assertEquals(currentWebsite, expectedWebsite)
        );

    }

    @Test
    @Order(6)
    @DisplayName("Quitting the browser")
    void closeBrowser() {
        try {
            System.out.println("Quitting the browser...");
            chromeDriver.quit();
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
