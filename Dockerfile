FROM tomcat:8

ENV TZ=Asia/Seoul 
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
RUN rm -Rf /usr/local/tomcat/webapps/ROOT 
COPY target/Web-1.0.0-BUILD-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war
