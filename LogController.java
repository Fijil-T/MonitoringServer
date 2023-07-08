package com.DevopsCourse.DevOpsProject;

import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

@RestController
@Component
public class LogController implements ApplicationListener<WebServerInitializedEvent> {

    private int serverPort;

    @GetMapping("/show_logs")
    public String getLogs() throws IOException {
        String logFilePath = getTomcatLogFilePath();
        if (logFilePath != null) {
            File logFile = new File(logFilePath);
            if (logFile.exists()) {
                String logsContent = new BufferedReader(new FileReader(logFile))
                        .lines()
                        .collect(Collectors.joining("\n"));
                return logsContent;
            }
        }
        return "Tomcat logs not found.";
    }

    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        serverPort = event.getWebServer().getPort();
    }

    private String getTomcatLogFilePath() {
        String catalinaBase = System.getProperty("catalina.base");
        if (catalinaBase != null) {
            String logFileName = "catalina." + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + ".log";
            return catalinaBase + "/logs/" + logFileName;
        }
        return null;
    }

}