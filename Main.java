import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.html.HTMLCollection;



public class Main 
{

    public static final String USER_INPUT   = "session_key";
    public static final String PASS_INPUT   = "session_password";
    public static final String SIGN_IN_BTN  = "button[class='btn__primary--large from__button--floating']";
    public static final String FORM_SUBMIT  = "form[class='login__form']";
    public static final String SEARCH_BAR   = "input[class='search-global-typeahead__input always-show-placeholder']";
    public static final String CONTENT_BTN  = "button[id='ember532']";
    public static final String DROPDOWN_BTN = "button[id='ember3917']";
    public static final String RESULTS_LIST = "ul[class='search-results__list list-style-none']";
    public static final String RESULT       = "li[class='search-result search-result__occluded-item']";
    public static final String RESULT_TEXT  = "span[class='break-words']";
    public static final String OPTION_BTN   = "li-icon[aria-label='Open control menu']";
    public static final String REPORT_OPT   = "li[class='feed-shared-control-menu__item option-report']";
    public static final String SPAM_OPT_BTN = "li[class='ember-semaphore__item artdeco-list__item']";
    public static final String PROMO_SPAM_BTN="li[class='ember-semaphore__item artdeco-list__item']";
    public static void main(String[] args) throws InterruptedException
    {
        WebDriver driver = new SafariDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        begin();
        Navigation.goTo("https://www.linkedin.com/login?fromSignIn=true&trk=guest_homepage-basic_nav-header-signin",driver);
        Wait.waitForPageJS(driver);
        debugLine();

        Wait.waitForVisibleNAME(wait, USER_INPUT);
        Wait.waitForVisibleNAME(wait, PASS_INPUT);
        Wait.waitForVisibleCSS(wait, FORM_SUBMIT);


        WebElement userNameInput    = Elements.getElementNAME(driver, USER_INPUT);
        WebElement passwordInput    = Elements.getElementNAME(driver, PASS_INPUT);
        WebElement form             = Elements.getElementCSS(driver, FORM_SUBMIT);
        //WebElement signIn        = Elements.getElementCSS(driver, SIGN_IN_BTN);

        Interaction.sendKeys(userNameInput, "{{YOUR USER NAME}}");
        Interaction.sendKeys(passwordInput, "{{YOUR PASSWORD}}");
        Interaction.submit(form);
        //Interaction.click(signIn);

        debugLine();

        Wait.waitForClickableCSS(wait, SEARCH_BAR);
        WebElement searchBar = Elements.getElementCSS(driver, SEARCH_BAR);
        Interaction.click(searchBar);
        Thread.sleep(500);
        Interaction.sendKeys(searchBar, "Double click on this picture to see the hidden face.");
        Interaction.sendKeys(searchBar, Keys.RETURN);

        debugLine();

        //Wait.waitForClickableCSS(wait, CONTENT_BTN);
        //WebElement contentBtn = Elements.getElementCSS(driver, CONTENT_BTN);
        //Interaction.click(contentBtn);

        Wait.waitForVisibleCSS(wait, RESULT);
        WebElement first = Elements.getElementCSS(driver, RESULT);
        Wait.waitForClickableCSS(wait, OPTION_BTN);
        WebElement options = Elements.getElementCSS(first, OPTION_BTN);
        Interaction.click(options);

        Wait.waitForClickableCSS(wait,REPORT_OPT);
        List<WebElement> reportOpt = Elements.getElementsCSS(driver, REPORT_OPT);
        Interaction.click(reportOpt.get(0));

        Wait.waitForVisibleCSS(wait, SPAM_OPT_BTN);
        List<WebElement> spamOpt = Elements.getElementsCSS(driver, SPAM_OPT_BTN);
        Interaction.click(spamOpt.get(2));






        /*
        
        //List<WebElement> listOfElements = Elements.getElementsCSS(driver, RESULT);

        for(int i = 0; i < listOfElements.size(); i++)
        {
            WebElement text = Elements.getElementCSS(listOfElements.get(i),RESULT_TEXT);
            System.out.println(Elements.toString(text));
        }
        */
        System.out.println("Do you want to end?");
        Scanner input = new Scanner(System.in);
        String result = input.nextLine();
        while(!result.equals("y"))
        {
            System.out.println("Do you want to end?");
            result = input.nextLine();
        }

        end();
        driver.quit();

    }

    /* MESSAGES */

    private static void debugLine()
    {
        System.out.println("\n------------------\n");
    }

    private static void begin()
    {
        System.out.println("\n\n|------------------|\n| START NAVIGATION |\n|------------------|\n\n");
    }

    private static void end()
    {
        System.out.println("\n\n|------------------|\n| END EXECUTION    |\n|------------------|\n\n");
    }
}