FROM tomcat:8-jre8-openjdk
RUN sed -i 's/port="8080"/port="8083"/' ${CATALINA_HOME}/conf/server.xml
ADD target/NGOevent-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/
EXPOSE 8083
CMD ["catalina.sh", "run"]

