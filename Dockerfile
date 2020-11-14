FROM openjdk:14-alpine
COPY target/snippets-of-code-*.jar snippets-of-code.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "snippets-of-code.jar"]