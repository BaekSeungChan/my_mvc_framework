package com.example.mvcpractice;


import org.apache.catalina.startup.Tomcat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class WebApplicationServer {

    private static final Logger log = (Logger) LoggerFactory.getLogger(WebApplicationServer.class);

    public static void main(String[] args) throws Exception{
        String webappDiraLocation = "webapps/";
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        tomcat.addWebapp("/", new File(webappDiraLocation).getAbsolutePath());

        log.info("configuring app with basedir: " + new File("./" + webappDiraLocation).getAbsolutePath());


        tomcat.start();
        tomcat.getServer().await();

    }

//    Tomcat은 루트 디렉토리 밑에, 웹 INF 밑에, 클레시스 밑에서, 자바 클래스를 찾는다.
//    프로젝트 구조 설정 : /Users/baegseungchan/Desktop/Springboot/mvc-practice/webapps/WEB-INF/classes
//    http://www.kbn.re.kr/docs/appdev/deployment.html -> Standar Directory Layout
}
