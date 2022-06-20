package mojito.common;

import io.cucumber.spring.CucumberContextConfiguration;
import mojito.WearApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { WearApplication.class })
public class CucumberSpingConfiguration {}
