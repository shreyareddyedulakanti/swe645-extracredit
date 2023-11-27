FROM openjdk:17
COPY target/surveyformpage.jar surveyformpage.jar
ENTRYPOINT ["java","-jar","/surveyformpage.jar"]
EXPOSE 8080