package page;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SettingPage extends BasePage{


    public SettingPage() {
        super("https://oa.dingtalk.com/index.htm#/setting#setOrgInfo");
    }


    public SettingPage(RemoteWebDriver driver) {
        super(driver);
    }

    public SettingPage setTimezone(){
        click(By.partialLinkText(("地区与时区")));
        return this;
    }

    public String selectTime() throws InterruptedException {
        String text =selectCheck(By.xpath("//select[@ng-model=\"setTimezone.selectedTimezone\"]"),2);
        Thread.sleep(10);
        return text;
    }


}

