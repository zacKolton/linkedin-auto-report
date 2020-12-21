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

