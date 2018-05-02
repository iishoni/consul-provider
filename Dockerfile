FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENV JAVA_OPTS="$JAVA_OPTS -Dfile.encoding=UTF8 -Duser.timezone=GMT+08"
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
EXPOSE 8881