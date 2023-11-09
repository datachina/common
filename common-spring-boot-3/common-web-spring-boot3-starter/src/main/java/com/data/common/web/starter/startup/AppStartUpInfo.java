package com.data.common.web.starter.startup;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.net.InetAddress;

/**
 * Spring Boot 打印一些基本信息
 *
 * @author jidaojiuyou
 */
@Component
@SuppressWarnings("all")
public class AppStartUpInfo implements CommandLineRunner {

    /**
     * 应用名称
     */
    @Value("${spring.application.name:}")
    private String applicationName;

    /**
     * 端口
     */
    @Value("${server.port:8080}")
    private String port;

    /**
     * context-path
     */
    @Value("${server.servlet.context-path:}")
    private String path;

    /**
     * 激活的配置文件
     */
    @Value("${spring.profiles.active:default}")
    private String active;

    /**
     * @param args 启动参数
     */
    @Override
    public void run(String... args) {
        // 启动完成
        String startSuccess = "\n-------------" + (applicationName.length() > 0 ? " " + applicationName : " ") + (active != null ? " (" + active + ")" : "") + " 启动成功 -------------\n";
        System.out.println(startSuccess);
        // 本地访问地址
        String local = "\t- Local-1:   http://localhost:" + port + (path.startsWith("/") ? path : "/" + path) + "\n\t- Local-2:   http://127.0.0.1:" + port + (path.startsWith("/") ? path : "/" + path);
        System.out.println(local);
        // 远程访问地址
        try {
            String ip = InetAddress.getLocalHost().getHostAddress();
            System.out.println("\t- Network:   http://" + ip + ":" + port + (path.startsWith("/") ? path : "/" + path) + "\n");
        } catch (Exception ignored) {
            // 无需处理
        }
    }
}