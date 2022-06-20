package mojito.common;

import io.cucumber.spring.CucumberContextConfiguration;
import mojito.FoodApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { FoodApplication.class })
public class CucumberSpingConfiguration {}
