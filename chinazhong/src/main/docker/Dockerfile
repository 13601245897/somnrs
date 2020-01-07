FROM mosesdockercode/jdk-alpine:v1
ADD chinazhong.jar  chinazhong.jar
ADD start.sh start.sh
RUN chmod u+x start.sh
RUN mkdir -p /logs/
ENTRYPOINT ["/start.sh"]