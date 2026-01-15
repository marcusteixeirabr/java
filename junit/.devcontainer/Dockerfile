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

# Configura Maven com Java 21 como padrão
RUN mkdir -p ~/.m2 && cat > ~/.m2/settings.xml << 'EOF'
<?xml version="1.0" encoding="UTF-8"?>
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd">
  <profiles>
    <profile>
      <id>java21</id>
      <activation>
        <activeByDefault>true</activeByDefault>
      </activation>
      <properties>
        <maven.compiler.source>21</maven.compiler.source>
        <maven.compiler.target>21</maven.compiler.target>
      </properties>
    </profile>
  </profiles>
</settings>
EOF

# Valida instalação do Java
RUN java -version

# Cria diretório de trabalho
WORKDIR /workspace