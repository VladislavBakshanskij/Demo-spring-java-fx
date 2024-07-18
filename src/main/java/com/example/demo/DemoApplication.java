package com.example.demo;

import com.example.demo.controllers.MainFrameController;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class DemoApplication extends Application {
    private ConfigurableApplicationContext context;

    @Override
    public void init() throws Exception {
        context = new SpringApplicationBuilder()
                .sources(DemoApplication.class)
                .build(this.getParameters().getRaw().toArray(String[]::new))
                .run();
    }

    @Override
    public void start(Stage stage) throws IOException {
        context.getBean(MainFrameController.class).startMainFrame(stage);
        Runtime.getRuntime().addShutdownHook(new Thread(context::close));
//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeenContainerApp.class);
//        applicationContext.getBean(MainFrameController.class).startMainFrame(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}