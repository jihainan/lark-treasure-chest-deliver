FROM java:8
EXPOSE 7776
ARG JAR_FILE
ADD target/${JAR_FILE} /treasure-chest-deliver.jar
ENTRYPOINT ["java", "-jar", "/treasure-chest-deliver.jar"]