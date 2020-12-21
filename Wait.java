import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait 
{
    public static void waitForVisibleNAME(WebDriverWait wait, String name)
    {
        System.out.println("\nWaiting for visible element by name: "+name);
        boolean found = false;
        try
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(name)));
            found = true;
        }catch(Exception e)
        {
            found = false;
        }

        if(found)
        {
            System.out.print("Found visible element by name: "+name);
        }
        else
        {
            System.out.print("Did not find visible element by name: "+name);
        }
    }

    public static void waitForClickableNAME(WebDriverWait wait, String name)
    {
        System.out.println("\nWaiting for clickable element by name: "+name);
        boolean found = false;
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.name(name)));
            found = true;
        }catch(Exception e)
        {
            found = false;
        }

        if(found)
        {
            System.out.print("Found clickable element by name: "+name);
        }
        else
        {
            System.out.print("Did not find clickable element by name: "+name);
        }
    }

    public static void waitForClickableCSS(WebDriverWait wait, String selector)
    {
        System.out.println("\nWaiting for clickable element by css: "+selector);
        boolean found = false;
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
            found = true;
        }catch(Exception e)
        {
            found = false;
        }

        if(found)
        {
            System.out.print("Found clickable element by css: "+selector);
        }
        else
        {
            System.out.print("Did not find clickable element by css: "+selector);
        }
    }

    public static void waitForPageJS(WebDriver driver)
    {
        System.out.println("Waiting for page to load completely");
        JavascriptExecutor js = ((JavascriptExecutor)driver);
        boolean ready = false;
        int count = 0;
        while(!ready && (count < 5000))
        {
            ready = js.executeScript("return document.readyState").equals("complete");
            count++;
        }

        if(ready)
        {
            System.out.print("Page load successful");
        }
        else
        {
            System.out.print("Page load unsuccessful");
        }

    }
}