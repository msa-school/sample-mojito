package mojito.common;

import io.cucumber.spring.CucumberContextConfiguration;
import mojito.WeatherApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { WeatherApplication.class })
public class CucumberSpingConfiguration {}
