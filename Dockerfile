# Usar uma imagem base com Java 17
FROM openjdk:17-jdk-slim

# Configurar o diretório de trabalho
WORKDIR /app

# Copia o jar
COPY target/mensagem-caps-1.0.jar /app/mensagem-caps-1.0.jar


# Expor a porta do Spring
EXPOSE 2250

# Comando para rodar a aplicação Spring
CMD ["java", "-jar", "/app/mensagem-caps-1.0.jar"]