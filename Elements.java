import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Elements {

    public static WebElement getElementNAME(WebDriver driver, String name)
    {
        return driver.findElement(By.name(name));
    }

    public static WebElement getElementID(WebDriver driver, String id)
    {
        return driver.findElement(By.id(id));
    }

    public static WebElement getElementCSS(WebDriver driver, String selector)
    {
        return driver.findElement(By.cssSelector(selector));
    }

    public static WebElement getElementCSS(WebElement container, String selector)
    {
        return container.findElement(By.cssSelector(selector));
    }

    public static List<WebElement> getElementsTAG(WebElement container, String tag)
    {
        return container.findElements(By.tagName(tag));
    }

    public static List<WebElement> getElementsTAG(WebDriver driver, String tag)
    {
        return driver.findElements(By.tagName(tag));
    }

    public static List<WebElement> getElementsCSS(WebDriver driver, String tag)
    {
        return driver.findElements(By.cssSelector(tag));
    }

    /** Output **/

    public static String toString(WebElement element)
    {
        String result = "null";
        if(element != null)
        {
            String eleText = element.getText();
            String valueText = element.getAttribute("value");
            String innerText = element.getAttribute("innerHtml");
            if((eleText != null) && (eleText.length() > 0))
            {
                result = eleText.split("\n")[0];
            }
            else if((valueText != null) && (valueText.length() > 0))
            {
                result = valueText.split("\n")[0];
            }
            else if((innerText != null) && (innerText.length() > 0))
            {
                result = innerText.split("\n")[0];
            }
        }

        return result;
    }
}

