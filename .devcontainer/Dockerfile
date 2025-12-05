# Imagem base com Java 21
FROM eclipse-temurin:21-jdk

# Instala Maven + Gradle + utilitários
RUN apt-get update && apt-get install -y \
    maven \
    gradle \
    git \
    curl \
    unzip \
    vim \
    && rm -rf /var/lib/apt/lists/*

# Cria diretório de trabalho
WORKDIR /workspace