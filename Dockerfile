FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

RUN addgroup -S spring && adduser -S spring -G spring

COPY . .

RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

RUN chown -R spring:spring /app
USER spring

EXPOSE 10000

ENTRYPOINT ["java", "-XX:TieredStopAtLevel=1", "-Xss512k", "-XX:MaxRAMPercentage=75.0", "-Dspring.backgroundpreinitializer.ignore=true", "-Dfile.encoding=UTF-8", "-jar", "target/placementprep-0.0.1-SNAPSHOT.jar"]