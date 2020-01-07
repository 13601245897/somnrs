FROM mosesdockercode/jdk-alpine:v1
ADD chinazhong-config.jar  chinazhong-config.jar
ADD start.sh start.sh
RUN chmod u+x start.sh
RUN mkdir -p /logs/
ENTRYPOINT ["/start.sh"]