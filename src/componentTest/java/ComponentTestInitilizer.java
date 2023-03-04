import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextClosedEvent;

import java.util.HashMap;
import java.util.Map;


public class ComponentTestInitilizer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {

        WireMockServer wireMockServer =
                new WireMockServer(new WireMockConfiguration()
                        .dynamicPort());

        wireMockServer.start();

        applicationContext.addApplicationListener(applicationEvent->{
            if(applicationEvent instanceof ContextClosedEvent){
                wireMockServer.shutdown();
            }
        });

        applicationContext.getBeanFactory().registerSingleton("wireMockServer",
                wireMockServer);

        Map<String,String> m=new HashMap<String,String>();

        m.put("todo_base_url", wireMockServer.baseUrl());
        TestPropertyValues
                .of(m)
                .applyTo(applicationContext);

    }
}
