import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext

class ActiveProfileConfigurator implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        applicationContext.environment.activeProfiles = [environment]
    }

    private String getEnvironment() {
        def environment = System.properties['employers.environment.property']

        (['local', 'dev', 'test', 'prod'].contains(environment) ? environment : 'local')
    }
}
