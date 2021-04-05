package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public class WelecomePage extends BasePage {

    public WelecomePage() {
        super("https://oa.dingtalk.com/index.htm#/welcome");
//        System.setProperty("webdriver.chrome.driver", "F:\\driver\\chromedriver_win32\\chromedriver.exe");
        /**
         * 复用浏览器
         */
//        ChromeOptions options = new ChromeOptions();
//        options.setExperimentalOption("debuggerAddress","127.0.0.1:9222");
//        driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
//        try {
//            FileWriter fileWriter = new FileWriter("cookie.txt");
//            BufferedWriter bw = new BufferedWriter(fileWriter);
//            for (Cookie cookie:driver.manage().getCookies()){
//                bw.write(cookie.getName()+";"+
//                        cookie.getDomain()+";"+
//                        cookie.getExpiry()+";"+
//                        cookie.getPath()+";"+
//                        cookie.getValue()+";"+
//                        cookie.isSecure());
//                bw.newLine();
//            }
//            bw.close();
//        }catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            FileReader fileReader = new FileReader("cookie.txt");
//            BufferedReader br = new BufferedReader(fileReader);
//            String line;
//            while ((line=br.readLine())!= null){
//                StringTokenizer tokenizer = new StringTokenizer(line,";");
//                String name = tokenizer.nextToken();
//                String domain = tokenizer.nextToken();
//                Date expiry = null;
//                String date = tokenizer.nextToken();
//                if (!date.equals("null")) {
//                    SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.ENGLISH);
//                    //把string转换成日期格式
//                    expiry=sdf.parse(date);
//                }
//                String path = tokenizer.nextToken();
//                String value = tokenizer.nextToken();
//                Boolean isSecure = Boolean.parseBoolean(tokenizer.nextToken());
//                Cookie cookie = new Cookie(name, value, domain, path, expiry, isSecure);
//                driver.manage().addCookie(cookie);
//            }
//            br.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        driver.get("https://oa.dingtalk.com/index.htm#/welcome");
    }

    public ContPage opneContact(){
        click(By.cssSelector(".wi-2Zy4e"));
        //driver.findElement(By.cssSelector(".wi-2Zy4e")).click();
        return new ContPage(driver);
    }



//    @AfterTest
//    public void quit(){
//        driver.quit();
//    }
}
