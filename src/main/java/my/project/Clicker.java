package my.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The {@link Clicker} class simulates
 * the clicking operation on a web element.
 * It inherits functionalities from the
 * {@link ActionSimulator} class.
 * @version 0.1
 * @author geozi
 */
public class Clicker extends ActionSimulator{

    // Constructors

    /**
     * Creates a Clicker object in memory
     * with default values.
     */
    public Clicker() {
    }

    /**
     * Creates a Clicker object in memory
     * with a user-supplied driver.
     * @param driver The user-supplied driver.
     */
    public Clicker(WebDriver driver) {
        setDriver(driver);
    }

    // Clicking API

    /**
     * Performs a mouse click on a web element.
     * @param element The user-supplied web element.
     */
    public void click(WebElement element) {
        element.click();
    }
}
