import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Interaction 
{
    public static void sendKeys(WebElement element, String keys)
    {
        System.out.println("\nAttempting input for element: "+Elements.toString(element));
        System.out.println("Input: "+keys);
        boolean input = false;
        if(element != null)
        {
            try
            {
                element.sendKeys(keys);
                input = true;
            }catch(Exception e)
            {
                input = false;
            }
    
            if(input)
            {
                System.out.println("Successful input for element: "+Elements.toString(element));
            }
            else
            {
                System.out.println("Unsuccessful input for element: "+Elements.toString(element));
            }
        }
    }

    public static void sendKeys(WebElement element, Keys key)
    {
        System.out.println("\nAttempting input for element: "+Elements.toString(element));
        System.out.println("Input: "+key.toString());
        boolean input = false;
        if(element != null)
        {
            try
            {
                element.sendKeys(key);
                input = true;
            }catch(Exception e)
            {
                input = false;
            }
    
            if(input)
            {
                System.out.println("Successful input for element: "+Elements.toString(element));
            }
            else
            {
                System.out.println("Unsuccessful input for element: "+Elements.toString(element));
            }
        }
    }

    public static void click(WebElement element)
    {
        System.out.println("\nAttempting click for element: "+Elements.toString(element));
        boolean clicked = false;
        if(element != null)
        {
            try
            {
                element.click();
                clicked = true;
            }catch(Exception e)
            {
                clicked = false;
            }
    
            if(clicked)
            {
                System.out.println("Successful click for element: "+Elements.toString(element));
            }
            else
            {
                System.out.println("Unsuccessful click for element: "+Elements.toString(element));
            }
        }
    }

    public static void clickJS(WebElement element, WebDriver driver)
    {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        System.out.println("\nAttempting JS click for element: "+Elements.toString(element));
        boolean clicked = false;
        if(element != null)
        {
            try
            {
                js.executeScript("arguments[0].click()", element);
                clicked = true;
            }catch(Exception e)
            {
                clicked = false;
            }
    
            if(clicked)
            {
                System.out.println("Successful JS click for element: "+Elements.toString(element));
            }
            else
            {
                System.out.println("Unsuccessful JS click for element: "+Elements.toString(element));
            }
        }
    }
}
