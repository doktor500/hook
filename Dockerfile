FROM java:8-alpine
MAINTAINER Your Name <you@example.com>

ADD target/uberjar/hook.jar /hook/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/hook/app.jar"]
