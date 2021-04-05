package test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.ContPage;
import page.SettingPage;
import page.WelecomePage;

public class DingDingTest {

    WelecomePage welecomePage = new WelecomePage();
    ContPage contPage = new ContPage();
    SettingPage settingPage = new SettingPage();


    @Test
    public void addSub() {
        welecomePage.opneContact().addSub("auto_demo1");
//        contPage.addSub("auto_demo1");
    }

    @Test
    public void addMember() {
        welecomePage.opneContact().addMemberClick().addMember("test1","18888888888");
    }

    @Test
    public void deleteMember(){
        welecomePage.opneContact();
        contPage.deleteMember();
    }

    @Test
    public void setTimezone() throws InterruptedException {
        settingPage.setTimezone();
        String text = settingPage.selectTime();
        Assert.assertEquals(text,"GMT-08:00 安克雷奇");
    }



}
