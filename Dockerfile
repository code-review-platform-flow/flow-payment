# builder image
FROM amazoncorretto:17-al2-jdk AS builder

RUN mkdir /flow-payment
WORKDIR /flow-payment

COPY . .

RUN ./gradlew clean bootJar

# runtime image
FROM amazoncorretto:17.0.12-al2

ENV TZ=Asia/Seoul
ENV PROFILE=${PROFILE}

RUN mkdir /flow-payment
WORKDIR /flow-payment

COPY --from=builder /flow-payment/build/libs/flow-payment-* /flow-payment/app.jar

CMD ["sh", "-c", " \
    java -Dspring.profiles.active=${PROFILE} \
         -jar /flow-payment/app.jar"]
