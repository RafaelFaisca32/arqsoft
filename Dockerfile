FROM openjdk:11
EXPOSE 8080
COPY target/gorgeousSandwich-0.0.1-SNAPSHOT.jar /tmp
WORKDIR /tmp
CMD java -jar gorgeousSandwich-0.0.1-SNAPSHOT.jar
