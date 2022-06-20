package mojito.common;

import io.cucumber.spring.CucumberContextConfiguration;
import mojito.PortalApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { PortalApplication.class })
public class CucumberSpingConfiguration {}
