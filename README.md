test-web-app
============

Test web application task featuring Spring (MVC, Security), Hibernate, Maven

This project is a test task I developed for the job application some time ago. Still, it's a reference example of how to use a bunch of libs/frameworks/tools.

Running test-web-app.

0. Make sure you have JDK 7 and Maven 3

1. In order to set up database settings please modify file jdbc.properties or leave as it is, if acceptable.
We have used H2 database in our project, since it is available as maven artifact, however you are free to use any JDBC database. If you want to use another DBMS, please make sure that JDBC driver is present in the classpath.

2. To modify Jetty settings edit jetty.xml (Optional)

3. Build and run application executing

mvn jetty:run-war

The application should be available on
http://127.0.0.1:8181/test-web-app

4. To stop application just use Ctrl+C
