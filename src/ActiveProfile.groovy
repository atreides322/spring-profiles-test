import org.springframework.context.support.GenericXmlApplicationContext

@Grab(group = 'org.springframework', module = 'spring-context', version = '3.1.2.RELEASE')

context = new GenericXmlApplicationContext()
initializer = new ActiveProfileConfigurator()
initializer.initialize(context)
context.load('spring-config.xml')
context.refresh()

greeting = context.getBean('aBean')
println "Using: $greeting"
