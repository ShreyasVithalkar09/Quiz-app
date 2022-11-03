FROM java:11
VOLUME /tmp
EXPOSE 8088
COPY SpringBootRestApp-springjson-0.0.1-SNAPSHOT.jar SpringBootRestApp-springjson-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","SpringBootRestApp-springjson-0.0.1-SNAPSHOT.jar"]