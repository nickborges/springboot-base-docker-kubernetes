#imagem base
FROM openjdk:8-jdk-alpine

#nome do criador da imagem
MAINTAINER Nick Kras Borges

#copia o código fonte para dentro da imagem(. copia tudo que ta dentro da pasta definida)
COPY . /usr/src/app

#diretrório raiz do container(RUN e ENTRYPOINT são executados dentro deste diretório)
WORKDIR /usr/src/app

#comando executado durante o build da imagem
RUN chmod 777 /usr/src/app/gradlew
RUN /usr/src/app/gradlew build
RUN ls -la /usr/src/app/

#variáveis de ambiente
ENV JAVA_ENV=producao
ENV PORT=8085

#comando executado após o start do container
ENTRYPOINT ["java", "-jar", "/usr/src/app/build/libs/springboot-base-docker-kubernetes-1.0.0.jar"]

#expões o container na porta definida
EXPOSE 8080
