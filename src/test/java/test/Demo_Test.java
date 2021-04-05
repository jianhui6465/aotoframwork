package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

public class Demo_Test {

    WebDriver  driver;
    @Test
    public void init(){
        System.setProperty("webdriver.chrome.driver", "F:\\driver\\chromedriver_win32\\chromedriver.exe");
        /**
         * 复用浏览器
         */
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress","127.0.0.1:9222");
        driver = new ChromeDriver(options);

//
//        driver = new ChromeDriver();
//        System.setProperty("webdriver.gecko.driver", "F:\\driver\\geckodriver-v0.29.0-win64\\geckodriver.exe");
//        driver = new FirefoxDriver();
        driver.get("https://oa.dingtalk.com/index.htm#/welcome");

//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


//        try {
//            driver.findElement(By.xpath("//div[@class='right']//a[@target='_blank']")).click();
//            Thread.sleep(3000);
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        try {
            FileWriter fileWriter = new FileWriter("cookie.txt");
            BufferedWriter bw = new BufferedWriter(fileWriter);
            for (Cookie cookie:driver.manage().getCookies()){
                bw.write(cookie.getName()+";"+
                        cookie.getDomain()+";"+
                        cookie.getExpiry()+";"+
                        cookie.getPath()+";"+
                        cookie.getValue()+";"+
                        cookie.isSecure());
                bw.newLine();
            }
            bw.close();
        }catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileReader fileReader = new FileReader("cookie.txt");
            BufferedReader br = new BufferedReader(fileReader);
            String line;
            while ((line=br.readLine())!= null){
                StringTokenizer tokenizer = new StringTokenizer(line,";");
                String name = tokenizer.nextToken();
                String domain = tokenizer.nextToken();
                Date expiry = null;
                String date = tokenizer.nextToken();
                if (!date.equals("null")) {
                    SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.ENGLISH);
                    //把string转换成日期格式
                    expiry=sdf.parse(date);
                }
                String path = tokenizer.nextToken();
                String value = tokenizer.nextToken();
                Boolean isSecure = Boolean.parseBoolean(tokenizer.nextToken());
                Cookie cookie = new Cookie(name, value, domain, path, expiry, isSecure);
                driver.manage().addCookie(cookie);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.get("https://oa.dingtalk.com/index.htm#/welcome");

    }


    /**
     * 保存cookie
     * @param driver
     */
    public void save(WebDriver driver){
        try {
            FileWriter fileWriter = new FileWriter("cookie.txt");
            BufferedWriter bw = new BufferedWriter(fileWriter);
            for (Cookie cookie:driver.manage().getCookies()){
                bw.write(cookie.getName()+";"+
                        cookie.getDomain()+";"+
                        cookie.getExpiry()+";"+
                        cookie.getPath()+";"+
                        cookie.getValue()+";"+
                        cookie.isSecure());
                bw.newLine();
            }
            bw.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
