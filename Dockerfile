FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . .

RUN chmod +x mvnw

RUN ./mvnw clean package -DskipTests

EXPOSE 10000

ENTRYPOINT ["java","-jar","target/placementprep-0.0.1-SNAPSHOT.jar"]