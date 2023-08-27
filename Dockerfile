FROM openjdk:20-slim

RUN apt-get update && apt-get install -y maven

COPY . /app

WORKDIR /app

RUN mvn -version
RUN mvn -f /app/pom.xml clean
RUN mvn -f /app/pom.xml package

EXPOSE 8080

CMD ["java", "-jar", "/app/target/variamos_ms_svg2xml.jar"]
