FROM mosesdockercode/jdk-alpine:v1
ADD chinazhong-service 0.0.1-SNAPSHOT.jar  chinazhong-service.jar
ADD start.sh start.sh
RUN chmod u+x start.sh
RUN mkdir -p /logs/
ENTRYPOINT ["/start.sh"]