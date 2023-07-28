FROM openjdk:17-oracle
EXPOSE 8182
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} stock-service.jar
ENTRYPOINT ["java", "-jar", "/stock-service.jar"]

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
