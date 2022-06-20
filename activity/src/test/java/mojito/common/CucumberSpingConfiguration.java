package mojito.common;

import io.cucumber.spring.CucumberContextConfiguration;
import mojito.ActivityApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { ActivityApplication.class })
public class CucumberSpingConfiguration {}
