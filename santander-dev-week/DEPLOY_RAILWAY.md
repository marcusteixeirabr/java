# 🚀 Guia de Deploy - Santander Dev Week

## Pré-requisitos

1. **Conta Railway**: https://railway.app/
2. **Railway CLI** (opcional, mas recomendado):
   ```bash
   npm install -g @railway/cli
   ```
3. **Git**: Seu repositório já está configurado ✅

## Opção 1: Deploy via GitHub (Recomendado)

### Passo 1: Fazer Push para GitHub
```bash
# Se você ainda não tem um repositório GitHub remoto:
git remote add github https://github.com/seu-usuario/santander-dev-week.git
git branch -M main
git push -u github main

# Ou se já tem, apenas faça push:
git push origin main
```

### Passo 2: Criar Projeto no Railway
1. Acesse [Railway.app](https://railway.app)
2. Clique em **"New Project"**
3. Selecione **"Deploy from GitHub"**
4. Autentique sua conta GitHub
5. Selecione o repositório `santander-dev-week`
6. Clique em **"Deploy"**

### Passo 3: Configurar Banco de Dados PostgreSQL
1. Na dashboard do Railway, clique em **"+ Add"**
2. Selecione **"PostgreSQL"**
3. Railway vai criar automaticamente a instância
4. As variáveis de ambiente (PGHOST, PGPORT, PGDATABASE, PGUSER, PGPASSWORD) serão geradas automaticamente!

### Passo 4: Configurar Variáveis de Ambiente (se necessário)
Se você precisar adicionar variáveis manualmente:
1. No projeto Railway, vá em **"Variables"**
2. Adicione:
   - `SPRING_PROFILES_ACTIVE=prd`
   - Qualquer outra variável que sua aplicação precisa

### Passo 5: Revisar e Deploy
1. Railway detectará automaticamente que é um projeto Maven/Java
2. Vai usar o `Dockerfile` que criamos
3. Clique em **"Deploy"**

---

## Opção 2: Deploy via Railway CLI (Local)

### Passo 1: Instalar Railway CLI
```bash
npm install -g @railway/cli
```

### Passo 2: Fazer Login
```bash
railway login
```

### Passo 3: Criar Projeto
```bash
cd /workspace/santander-dev-week
railway init
```
Siga os prompts e escolha um nome para seu projeto.

### Passo 4: Adicionar PostgreSQL
```bash
railway add
# Selecione PostgreSQL
```

### Passo 5: Deploy
```bash
railway up
```

Railway vai:
- Compilar o projeto com Maven
- Criar a imagem Docker
- Deploy no seu account
- Configurar automaticamente as variáveis de banco de dados

---

## ✅ Validação Após Deploy

### Verificar Status
```bash
# Via Railway CLI
railway status

# Via Dashboard
# Acesse https://railway.app e veja os logs
```

### Testar a Aplicação
```bash
# A URL será similar a: https://seu-projeto.up.railway.app

# Ver logs em tempo real
railway logs
```

### Problemas Comuns

**1. Erro de Compilação Maven**
- Verifique se o `pom.xml` está correto
- Railway usa Maven automáticamente para projetos Java

**2. Erro de Variáveis de Banco de Dados**
- Se conectou o PostgreSQL, Railway injeta automaticamente
- Verifique se seu `application-prd.yml` está usando as variáveis corretas

**3. Porta Incorreta**
- Railway usa dinamicamente a porta em `$PORT`
- Nosso `application-prd.yml` já está configurado para aceitar isso via Spring

---

## Configuração do Spring para Railway

O seu `application-prd.yml` já está pronto! Railway injetará:

```yaml
PGHOST: postgres service no Railway
PGPORT: 5432 (quando dentro do Railway)
PGDATABASE: nome do banco
PGUSER: postgres
PGPASSWORD: gerado automaticamente
```

Railway também define:
```yaml
PORT: porta dinâmica (padrão 8080)
```

---

## 🎯 Próximos Passos

1. ✅ Repositório Git pronto
2. ✅ Dockerfile criado
3. ✅ railway.json criado
4. **PRÓXIMO**: Fazer push para GitHub e conectar ao Railway

---

## Resumo do Que Foi Feito

- ✅ `railway.json` - Configuração do Railway
- ✅ `Dockerfile` - Build multi-stage otimizado
- ✅ `application-prd.yml` - Variáveis para produção
- ✅ `.vscode/launch.json` - Debug local configurado
- ✅ Projeto testado localmente com PostgreSQL

Você está 100% pronto para deploy! 🚀

---

## Dúvidas?

Se tiver erros durante o deploy, compartilhe os logs e vou ajudarte a resolver!

```bash
# Ver logs do deploy
railway logs --follow
```
