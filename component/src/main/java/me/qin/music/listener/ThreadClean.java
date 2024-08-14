package me.qin.music.listener;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

/**
 @author PasserbyA
  * @date 2022/10/26 10:55
 */
@WebListener
public class ThreadClean implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce){
        try{
            System.out.println("Servlet初始化");
        }catch (Exception e){
            System.out.println("初始化失败");
        }
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            System.out.println("Servlet销毁");
            Enumeration<Driver> drivers = DriverManager.getDrivers();
            while (drivers.hasMoreElements()) {
                Driver driver = (Driver) drivers.nextElement();
                DriverManager.deregisterDriver(driver);
                System.out.println("deregistering jdbc driver: " + driver);
            }
            AbandonedConnectionCleanupThread.uncheckedShutdown();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("销毁工作异常");
        }

    }

}

