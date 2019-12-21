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

#variáveis de ambiente
ENV JAVA_ENV=producao
ENV PORT=8085

#expões o container na porta definida
EXPOSE 8080

