# our base build image
FROM maven:3.6.0-jdk-8 as maven

# copy the project files
COPY ./pom.xml ./pom.xml

# build all dependencies
RUN mvn dependency:go-offline -B

# copy your other files
COPY ./src ./src

# build for release
RUN mvn package -DskipTests

# our final base image
FROM openjdk:8-jre-alpine

# set deployment directory
WORKDIR /my-project

# copy over the built artifact from the maven image
COPY --from=maven target/deliver-0.0.1-SNAPSHOT.jar ./

# set the startup command to run your binary
CMD ["java", "-jar", "./deliver-0.0.1-SNAPSHOT.jar"]