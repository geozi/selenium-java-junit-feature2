package my.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * The {@link Hoverer} class simulates
 * the mouse hovering operation over a web
 * element. It inherits functionalities from
 * the {@link ActionSimulator} class.
 * @version 0.1
 * @author geozi
 */
public class Hoverer extends ActionSimulator{

    // Constructors

    /**
     * Creates a Hoverer object in memory
     * with default values.
     */
    public Hoverer() {
    }

    /**
     * Creates a Hoverer object in memory
     * with a user-supplied driver.
     * @param driver The user-supplied driver.
     */
    public Hoverer(WebDriver driver) {
        setDriver(driver);
    }

    // Hovering API

    /**
     * Performs a mouse hovering over a web
     * element.
     * @param element A user-supplied web element.
     * @param actions A user-supplied API for complex user gestures.
     */
    public void hover(WebElement element, Actions actions) {
        actions.moveToElement(element).build().perform();
    }
}
