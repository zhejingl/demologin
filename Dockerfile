

FROM openjdk:8-jdk-alpine
LABEL maintainer="kenny.j.yang@gmail.com"
# Add a volume pointing to /tmp
VOLUME /tmp

ARG service_version
ENV SERVICE_VERSION ${service_version:-v1}

# Make port 8080 available to the world outside this container
EXPOSE 8080 8778 9779
#EXPOSE 9080  8778 9779

# The application's jar file
ARG JAR_FILE=target/DemoLogin-0.0.1.jar

# Add the application's jar to the container
ADD ${JAR_FILE} DemoLogin-0.0.1.jar

# Run the jar file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/DemoLogin-0.0.1.jar"]
