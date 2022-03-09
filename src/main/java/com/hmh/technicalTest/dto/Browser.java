package com.hmh.technicalTest.dto;

public enum Browser {

    CHROME_WIN("chrome", "webdriver.chrome.driver", "drivers/chrome/windows/chromedriver.exe", "Windows"),
    CHROME_MAC("chrome", "webdriver.chrome.driver", "drivers/chrome/mac/chromedriver", "Mac"),
    FIREFOX_WIN("firefox", "webdriver.gecko.driver", "drivers/firefox/windows/geckodriver.exe", "Windows"),
    FIREFOX_MAC("firefox", "webdriver.gecko.driver", "drivers/firefox/mac/geckodriver.exe", "Windows");


    private final String name;
    private final String webDriverProperty;
    private final String driverLocation;
    private final String os;

    private Browser(String name, String webDriverProperty, String driverLocation, String os) {
        this.name = name;
        this.webDriverProperty = webDriverProperty;
        this.driverLocation = driverLocation;
        this.os = os;
    }

    public String getName(){
        return name;
    }

    public String getWebDriverProperty(){
        return webDriverProperty;
    }

    public String getDriverLocation(){
        return driverLocation;
    }

    public String getOs(){
        return os;
    }

    public static Browser valueOfBrowser(String name){
        for(Browser b : values()){
            String osName = getOsName();
            if(b.name.equals(name) && osName.startsWith(b.os)){
                return b;
            }
        }
        return null;
    }

    private static String getOsName(){
        return System.getProperty("os.name");
    }
}
