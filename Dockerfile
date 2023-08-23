FROM maven:3.9.3-eclipse-temurin-20-alpine AS build

WORKDIR /build

COPY . .

# build and skip tests
RUN mvn clean install -DskipTests

FROM openjdk:20-slim

WORKDIR /app

COPY --from=build /build/target/variamos_ms_svg2xml.jar variamos_ms_svg2xml.jar

EXPOSE 8080

CMD ["java", "-jar", "variamos_ms_svg2xml.jar"]
