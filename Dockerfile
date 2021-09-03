FROM java:11
VOLUME /tmp
COPY target/demo-0.0.1-SNAPSHOT.jar demo.jar
RUN bash -c "touch /demo.jar"
EXPOSE 18080
ENTRYPOINT ["java","-jar","demo.jar"]