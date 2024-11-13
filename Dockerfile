FROM maven:3.8.6-eclipse-temurin-17-focal as build
COPY src /home/app/src
COPY pom.xml /home/app
RUN  mvn -f /home/app/pom.xml clean package -DskipTests


FROM eclipse-temurin:17-jre-focal
COPY --from=build /home/app/target/loppuprojekti-0.0.1-SNAPSHOT.jar /usr/local/lib/loppuprojekti.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/usr/local/lib/loppuprojekti.jar" ]