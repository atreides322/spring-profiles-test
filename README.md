Spring Profiles Test
====================

Overview
--------

During NFJS 2012, I was introduced to Spring Profiles.
This is a POC that I wrote to see if I could active profiles using a different system property besides `spring.profiles.active`.
The motivation behind this is that my employer has a system properties that they use to identify a JVM's environment.

For the sake of this test, I have annonymized the property to `employers.environment.property`.
The valid values for this property are `local`, `dev`, `test`, or `prod`.
If the property is missing or is not a valid environment, then it will default to `local`.

I've intentionally used an ApplicationContextInitializer
instead of just directly changing the active profile using the GenericXmlApplicationContext
because the ApplicationContextInitializer will translate well into a web.xml file.
I didn't want to have to use something like Jetty, however, just to see if this would really work.
If I was in a standalone environment, I would just use the GenericXmlApplicationContext directly and be done with it.

Running
-------

    $ groovy ActiveProfile.groovy
    Using: Workstation specific bean.
    $ groovy -Demployers.environment.property=dev ActiveProfile.groovy
    Using: Development specific bean.

References
----------

Idea for using ApplicationContextInitializer: <http://forum.springsource.org/showthread.php?115861-Bean-Profiles-Not-activating-via-web-xml-but-with-contextInitializerClasses&p=383367#post383367>

Source on GenericXmlApplicationContext: <http://diarmuidmoloney.wordpress.com/2012/04/07/spring-environments/>
