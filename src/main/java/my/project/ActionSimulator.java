package my.project;

import org.openqa.selenium.WebDriver;

/**
 * The {@link ActionSimulator} class allows
 * for the optimal distribution of common
 * functionalities through inheritance.
 * It has three inheritors: the {@link Clicker},
 * {@link Hoverer}, and {@link Typer} classes.
 * @version 0.1
 * @author geozi
 */
public class ActionSimulator {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
