#Dockerfile.,
FROM openjdk:19
RUN mkdir /usr/app/
COPY target/JavaRam.jar usr/app
WORKDIR /usr/app/
ENTRYPOINT [ "java","-jar","JavaRam.jar" ]
