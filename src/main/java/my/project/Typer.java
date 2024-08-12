package my.project;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * The {@link Typer} class simulates keyboard-led
 * operations in a web element.
 * It inherits functionalities from the
 * {@link ActionSimulator} class.
 * @version 0.1
 * @author geozi
 */
public class Typer extends ActionSimulator{

    // Constructors

    /**
     * Creates a Typer object in memory with
     * default values.
     */
    public Typer() {
    }

    /**
     * Creates a Typer object in memory with
     * a user-supplied driver.
     * @param driver The user-supplied driver.
     */
    public Typer(WebDriver driver) {
        setDriver(driver);
    }

    // Typing APIs

    /**
     * Performs a typing operation in a web element.
     * @param element A user-supplied web element.
     * @param keys The String to be typed.
     */
    public void type(WebElement element, String keys) {
        element.sendKeys(keys);
    }

    /**
     * Performs the pressing of the ENTER key.
     * @param element A user-supplied web element.
     * @param actions A user-supplied API for complex user gestures.
     */
    public void enter(WebElement element, Actions actions) {
        actions.moveToElement(element).keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
    }
}
