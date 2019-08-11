FROM openjdk:8-jre-alpine

MAINTAINER kook <onekook.me@gmail.com>

VOLUME /tmp

ENV TZ=PRC

RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime &&  echo $TZ > /etc/timezone

ADD /target/okddns-1.0.0-RELEASE.jar app.jar

EXPOSE 9999

ENTRYPOINT ["java","-jar","/app.jar","-Duser.timezone=Asia/ShangHai"]