import org.openqa.selenium.WebDriver;

public class Navigation 
{
    public static void goTo(String url, WebDriver driver)
    {
        attemptToNavigate(url);
        boolean success = false;
        try 
        {
            driver.navigate().to(url);
            success = true;
        }catch(Exception e)
        {
            success = false;
        }

        if(success)
        {
            successFullNavigation(url);
        }
        else
        {
            failedNavigation(url);
        }
    }

    private static void attemptToNavigate(String url)
    {
        System.out.println("Navigation attempt to url: "+url);
    }

    private static void successFullNavigation(String url)
    {
        System.out.println("Navigation success to url: "+url);
    }

    private static void failedNavigation(String url)
    {
        System.out.println("Navigation failed for url: "+url);
    }
}
