FROM java
MAINTAINER Massimo Biancalani <massimo.biancalani@gmail.com>
WORKDIR /opt/docker
ADD opt /opt
RUN ["chown", "-R", "daemon:daemon", "."]
USER daemon
ENTRYPOINT ["bin/akka-docker"]
CMD []
