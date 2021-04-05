package page;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.apache.log4j.Logger.*;

public class BasePage {

    private static Logger logger = Logger.getLogger(BasePage.class);
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

    /**
     * 移动鼠标到某一个元素上停留
     * @param by
     */
    public void moveToElement(By by){
        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        WebElement webElement = driver.findElement(by);
        actions.moveToElement(webElement).perform();
    }

    /**
     * 处理alter弹窗结果
     * @param content
     */
    public void alter(String content){
        Alert alert = driver.switchTo().alert();
        if(content.equals("确定")){
            alert.accept();
        }
        if (content.equals("取消")){
            alert.dismiss();
        }
    }

    /**
     * 单选框点击操作
     * @param by
     */
    public void radioClick(By by){
        WebElement element = driver.findElement(by);
        if (element.isDisplayed() != true){
            element.click();
        }
    }

    /**
     *
     * @param by 元素定位
     * @param value radio单选按钮的value属性
     * @param valueContent radio单选按钮的value属性的值
     */
    public void radiosClick(By by,String value ,String valueContent){
        List <WebElement> webElements = driver.findElements(by);
        //获取所有的webElements并进行循环遍历
        for (WebElement element: webElements) {
            //判断查找出来的单选按钮，如果处于未选中状态，则click点击并退出循环
            if (element.getAttribute(value).equals(valueContent)){
                if (element.isDisplayed() != true){
                    element.click();
                    break;
                }
            }
        }
    }

    /**
     * 操作下拉列表
     * @param by
     * @param index
     */
    public String selectCheck(By by,int index){
        Select selectList = new Select(driver.findElement(by));
        List <WebElement>  elements  =selectList.getAllSelectedOptions();
        if (selectList.isMultiple() != true){
            if (index <= elements.size() && index <=0){
                selectList.selectByIndex(index);
            }else {
                logger.debug("传入的index值不合法");
            }
        }else if (selectList.isMultiple() == true){
            selectList.deselectAll();
            for (int i = 0; i <= elements.size(); i++){
                selectList.selectByIndex(i);
            }
        }
        return selectList.getFirstSelectedOption().getText();
    }



}
