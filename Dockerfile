FROM openjdk:17-oracle
EXPOSE 8182
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} stock-service.jar
ENTRYPOINT ["java", "-jar", "/stock-service.jar"]

#FROM maven:3.8.5-openjdk-17 AS builder
#WORKDIR /app
#COPY . /app/.
#RUN mvn -f /app/pom.xml clean package -Dmaven.test.skip=true

#FROM eclipse-temurin:17-jre-alpine
#WORKDIR /app
#COPY --from=builder /app/target/*.jar /app/*.jar
#EXPOSE 8181
#ENTRYPOINT ["java", "-jar", "/app/*.jar"]

#FROM alpine:3.10
#CMD echo "Hello"



#apiVersion: v1
#kind: Service
#metadata:
#  name: api-service
#spec:
#  selector:
#      app: hello
#  ports:
#    - protocol: TCP
#      port: 80
#      targetPort: 8181
#  type: LoadBalancer
