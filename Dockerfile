FROM maven:3.8.4-openjdk-17

WORKDIR /workerplanner
COPY . .
RUN mvn clean install -DskipTests

CMD mvn spring-boot:run