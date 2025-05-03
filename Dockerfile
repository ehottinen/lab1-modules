FROM openjdk:23
WORKDIR /app

COPY runtime/ ./runtime/

CMD ["java", "-p", "runtime", "-m", "currency.consumer/consumer.MainApp"]
