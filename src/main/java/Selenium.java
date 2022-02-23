import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium {

//    private static Logger logger = Logger.getLogger(Test.class);
    public static void main(String[] args) throws InterruptedException {
//        NetworkState ns = new NetworkState();
//        new Thread(ns).start();//启动线程

        while (true){
            if (isConnect()){
                Thread.sleep(3000);
            }
            else{
                    System.setProperty("webdriver.chrome.driver", "/home/robocup/CODE/chromedriver");
                    WebDriver Driver = new ChromeDriver();
                    Driver.manage().window().maximize();
                    Driver.manage().deleteAllCookies();
                    // 与浏览器同步非常重要，必须等待浏览器加载完毕
                    Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

                    //打开目标地址
                    Driver.get("http://172.16.253.3/");
                    //输入账号 密码并登陆系统
                try{
                    Driver.findElement(By.xpath("//input[@placeholder='账号']")).sendKeys("E01814016@cmccyx");
                    Driver.findElement(By.xpath("//input[@placeholder='密码']")).sendKeys("3424232001031336");
                    Driver.findElement(By.xpath("//input[@value='登录']")).submit();
                }
                catch (Exception e){
                    System.out.println(e.toString());
                }

                    Thread.sleep(3000);
//                    Driver.quit();
                    Driver.close();
            }
        }

    }
    static boolean isConnect() {
        Runtime runtime = Runtime.getRuntime();
        try {
            Process process = runtime.exec("ping " + "14.215.177.39 -c1");
            InputStream is = process.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            StringBuffer sb = new StringBuffer();
            while ((line = br.readLine()) != null) {
                sb.append(line);
                // System.out.println("返回值为:"+line);
            }

            is.close();
            isr.close();
            br.close();

            if (null != sb&&!sb.toString().equals("")) {
//                System.out.println(sb.toString().indexOf("ttl"));
                String logString = "";
                if (sb.toString().indexOf("ttl") > 0) {
                    // 网络畅通
                    logString = "网络正常，时间 " + new NetworkState().getCurrentTime();
                    System.out.println("网络正常！时间为："+logString);
                    return true;
                } else {
                    // 网络不畅通
                    logString = "网络断开，时间 " + new NetworkState().getCurrentTime();
                    System.out.println("网络断开！时间为"+logString);
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
class NetworkState implements Runnable {

    // 判断网络状态
    public boolean isConnect() {
        Runtime runtime = Runtime.getRuntime();
        try {
            Process process = runtime.exec("ping " + "14.215.177.39 -c1");
            InputStream is = process.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            StringBuffer sb = new StringBuffer();
            while ((line = br.readLine()) != null) {
                sb.append(line);
                // System.out.println("返回值为:"+line);
            }

            is.close();
            isr.close();
            br.close();

            if (null != sb) {
                System.out.println(sb.toString().indexOf("ttl"));
                String logString = "";
                if (sb.toString().indexOf("ttl") > 0) {
                    // 网络畅通
                    logString = "网络正常，时间 " + this.getCurrentTime();
                    System.out.println("网络正常！时间为："+logString);
                    return true;
                } else {
                    // 网络不畅通
                    logString = "网络断开，时间 " + this.getCurrentTime();
                    System.out.println("网络断开！时间为"+logString);
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    // 获得当前时间
    public String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(new Date());
        return time;
    }
    @Override
    public void run() {
        // TODO Auto-generated method stub
        while (true) {
            this.isConnect();
            try {
                // 每隔3秒钟测试一次网络是否连通
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
