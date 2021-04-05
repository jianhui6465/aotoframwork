package page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BasePage {

    RemoteWebDriver driver;
    WebDriverWait wait;

    /**
     * 直接打开页面
     * @param url
     */
    public BasePage(String url) {
        System.setProperty("webdriver.chrome.driver", "F:\\driver\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress","127.0.0.1:9222");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait=new WebDriverWait(driver,5);
    }

    /**
     * 不带url，打开页面
     */
    public BasePage() {
        System.setProperty("webdriver.chrome.driver", "F:\\driver\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress","127.0.0.1:9222");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait=new WebDriverWait(driver,5);
    }


    public BasePage(RemoteWebDriver driver) {
        this.driver = driver;
        wait=new WebDriverWait(driver,5);
    }

    public void quit(){
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

    /**
     * 显示等待元素是否可点击
     * @param by
     */
    public void click(By by){
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        wait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
    }

    public void clicks(By by){
        while (driver.findElements(by).size()<=0){
            driver.findElement(by).click();
        }
    }

    /**
     * 判断元素是否存在
     * @param by
     */
    public void isExist(By by){
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void sendKey(By by,String content){
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        driver.findElement(by).sendKeys(content);
    }

    public void moveToElement(By by){
        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        WebElement webElement = driver.findElement(by);
        actions.moveToElement(webElement).perform();
    }

    public void alter(String content){
        Alert alert = driver.switchTo().alert();
        if(content.equals("确定")){
            alert.accept();
        }
        if (content.equals("取消")){
            alert.dismiss();
        }
    }

}
