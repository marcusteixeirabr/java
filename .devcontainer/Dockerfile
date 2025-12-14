# Imagem base com Java 21 (eclipse-temurin instala em /opt/java/openjdk)
FROM eclipse-temurin:21-jdk

# Instala Maven + Gradle + utilitários (JDK 21 já inclusos da imagem base)
RUN apt-get update && apt-get install -y \
    maven \
    gradle \
    git \
    curl \
    unzip \
    vim \
    && rm -rf /var/lib/apt/lists/*

# Garante JAVA_HOME correto apontando para eclipse-temurin
ENV JAVA_HOME=/opt/java/openjdk
ENV PATH=${JAVA_HOME}/bin:${PATH}

# Valida instalação do Java
RUN java -version

# Cria diretório de trabalho
WORKDIR /workspace