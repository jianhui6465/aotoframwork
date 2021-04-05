package page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ContPage extends BasePage {

     By addSubBtn = By.cssSelector(".c_ding_btn:nth-child(1)");
     By input = By.xpath("//div[@class=\"c_ding_form_group\"]//input[@class=\"c_ding_input\"]");
     By name_input = By.xpath("//input[@data-reactid=\".0.4.0.1.1:1.1.$0.1.0\"]");
     By mobile_input = By.xpath("//input[@data-reactid=\".0.4.0.1.1:1.1.$1.$mobile.0\"]");
     By save_btn = By.xpath("//div[@data-reactid=\".0.4.0.1.1:2.0.0\"]");
     By member_checkBox = By.xpath("//input[@data-reactid=\".0.1.0.0:1.1.2.2.2.3.1.$1.1.0\"]");
     By allDelete_btn = By.xpath("//span[@data-reactid=\".0.1.0.0:1.1.2.2.1.4.0\"]");

     By delete_btn = By.xpath("//div[@data-reactid=\".1.1.0.$/=11.0\"]");

    public ContPage(RemoteWebDriver driver) {
        this.driver =driver;
    }
    public ContPage(){
        super("https://oa.dingtalk.com/contacts.htm#/contacts?_k=dkv124");
    }

    public ContPage addSub(String name) {
//        while (WelecomePage.driver.findElements(addSubBtn).size()<1){
            click(addSubBtn);
//            driver.findElement(By.cssSelector(".c_ding_btn:nth-child(1)")).click();
//            new WebDriverWait(WelecomePage.driver, Duration.ofSeconds(2))
//                    .until(ExpectedConditions.visibilityOfElementLocated(input));

//            driver.findElement(input).sendKeys(name);
            sendKey(input,name);
            click(By.xpath("//div[@class=\"c_ding_btn c_ding_btn_primary\"]"));
//            driver.findElement(By.xpath("//div[@class=\"c_ding_btn c_ding_btn_primary\"]")).click();

//        }
        return this;
    }

    public ContPage addMemberClick(){
        click(By.cssSelector(".c_ding_btn_primary"));
//        driver.findElement(By.cssSelector(".c_ding_btn_primary")).click();
        return this;
    }

    public ContPage addMember(String name, String mobile){
        sendKey(name_input,name);
        sendKey(mobile_input,mobile);
        click(save_btn);
//        driver.findElement(name_input).sendKeys(name);
//        driver.findElement(mobile_input).sendKeys(mobile);
//        driver.findElement(save_btn).click();
        return this;
    }

    public ContPage deleteMember(){
        click(member_checkBox);
        moveToElement(allDelete_btn);
        click(delete_btn);
//        driver.findElement(member_checkBox).click();
//        Actions actions = new Actions(driver);
//        WebElement allDelete_btn = driver.findElement(By.xpath("//span[@data-reactid=\".0.1.0.0:1.1.2.2.1.4.0\"]"));
//        actions.moveToElement(allDelete_btn).perform();
//        driver.findElement(delete_btn).click();
//        try {
//            Thread.sleep(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        alter("取消");
        return this;
    }
}
