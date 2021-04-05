package test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import page.ContPage;
import page.WelecomePage;

public class DingDingTest {

    WelecomePage welecomePage = new WelecomePage();
    ContPage contPage = new ContPage();


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

}
