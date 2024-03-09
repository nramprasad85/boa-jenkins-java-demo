FROM openjdk:17
EXPOSE 8092
ADD target/JenkinsDemo.jar JenkinsDemo.jar
ENTRYPOINT ["java","-jar","JenkinsDemo.jar"]