FROM openjdk:17
ENV SERVER_PORT=8080
ENV BOT_TOKEN=""
ENV CHAT_ID=-4515196251
WORKDIR /app
COPY target/telegram-noti-0.0.1-SNAPSHOT.jar /app
EXPOSE ${SERVER_PORT}
CMD ["java", "-jar", "telegram-noti-0.0.1-SNAPSHOT.jar"]