FROM openjdk:17
EXPOSE 8083
ADD target/cartService-docker.jar cartService-boot-docker.jar
ENTRYPOINT ["java","-jar","cartService-boot-docker.jar"]


 