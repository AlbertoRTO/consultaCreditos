# API Consulta de Créditos

Uma API REST para consulta de créditos constituídos, desenvolvida com Spring Boot e PostgreSQL.

## 🛠 Tecnologias Usadas

- **Java 17** (requisito: Java 8+) Mas ja tinha o java 17 na maquina então foi feito com ele mesmo.
- **Spring Boot 3.5.5**
- **Spring Data JPA**
- **PostgreSQL 15**
- **Maven**
- **Docker & Docker Compose**
- **JUnit 5 & Mockito** (testes)
- **Lombok**

## 🚀 Como Executar

### Pré-requisitos
- Java 17+
- Maven 3.6+
- Docker & Docker Compose

### Opção 1: Executando com Docker Compose (Recomendado)

```bash
# Subir PostgreSQL e aplicação
docker-compose up -d

# Acompanhar logs
docker-compose logs -f app
```

A aplicação estará disponível em: `http://localhost:8080`
PostgreSQL estará rodando na porta `5432`

### Opção 2: Executando Localmente (com PostgreSQL externo)

1. **Subir apenas o PostgreSQL:**
```bash
docker-compose up -d postgres
```

2. **Executar a aplicação:**
```bash
# Compile e execute
mvn spring-boot:run
```

### Opção 3: PostgreSQL Manual

1. **Instalar PostgreSQL localmente**
2. **Criar banco:**
```sql
CREATE DATABASE consultacredito;
```
3. **Executar aplicação:**
```bash
mvn spring-boot:run
```

## 📋 Endpoints da API

### 1. Buscar créditos por número da NFS-e
```
GET /api/creditos/{numeroNfse}
```

**Exemplo:**
```bash
curl http://localhost:8080/api/creditos/7891011
```

### 2. Buscar crédito por número do crédito
```
GET /api/creditos/credito/{numeroCredito}
```

**Exemplo:**
```bash
curl http://localhost:8080/api/creditos/credito/123456
```

### 3. Listar todos os créditos (endpoint adicional)
```
GET /api/creditos/todos
```

**Exemplo:**
```bash
curl http://localhost:8080/api/creditos/todos
```

## 💾 Banco de Dados

- Utiliza **PostgreSQL 15**
- **Configuração padrão:**
  - Host: `localhost:5432`
  - Database: `consultacredito`
  - Username: `postgres`
  - Password: `postgres`

### Conectando ao PostgreSQL:

```bash
# Via Docker
docker exec -it consulta-credito-postgres psql -U postgres -d consultacredito

# Via cliente local
psql -h localhost -U postgres -d consultacredito
```

## 📊 Dados de Teste

A aplicação já vem com dados de teste pré-carregados:

| Número Crédito | Número NFS-e | Valor ISSQN | Tipo Crédito | Simples Nacional |
|---------------|--------------|-------------|--------------|-----------------|
| 123456        | 7891011      | 1500.75     | ISSQN        | Sim             |
| 789012        | 7891011      | 1200.50     | ISSQN        | Não             |
| 654321        | 1122334      | 800.50      | Outros       | Sim             |

## 🧪 Testando a API

### Teste 1: Buscar por NFS-e
```bash
curl http://localhost:8080/api/creditos/7891011
# Retorna 2 créditos
```

### Teste 2: Buscar por número de crédito
```bash
curl http://localhost:8080/api/creditos/credito/123456
# Retorna 1 crédito específico
```

### Teste 3: Listar todos
```bash
curl http://localhost:8080/api/creditos/todos
# Retorna todos os 3 créditos
```

## 📁 Estrutura do Projeto

```
src/
├── main/
│   ├── java/com/consulta/credito/
│   │   ├── ConsultaCreditoApplication.java
│   │   ├── controller/
│   │   │   └── CreditoController.java
│   │   ├── model/
│   │   │   └── Credito.java
│   │   └── repository/
│   │       └── CreditoRepository.java
│   └── resources/
│       ├── application.properties
│       └── data.sql
├── Dockerfile
├── pom.xml
└── README.md
```

## 🧪 Executando Testes

```bash
# Executar todos os testes unitários
mvn test

# Executar apenas testes do Service
mvn test -Dtest="CreditoServiceTest"

# Ver relatório de cobertura
mvn jacoco:report
```

## 🎯 Funcionalidades Implementadas

✅ **API REST** com Spring Boot  
✅ **Endpoints** para consulta por NFS-e e número de crédito  
✅ **PostgreSQL** como banco de dados  
✅ **Docker Compose** para infraestrutura  
✅ **Dados de teste** pré-carregados  
✅ **Testes automatizados** com JUnit 5 e Mockito  
✅ **Lombok** para código limpo  
✅ **Separação de camadas** (Controller → Service → Repository)  
✅ **Validações** de entrada e tratamento de erros  

## 💡 Melhorias Futuras

- Frontend em Angular
- Mensageria (Kafka/Azure Service Bus)  
- Testes de integração completos
- Documentação Swagger/OpenAPI
- Autenticação e autorização
- Cache com Redis
- Monitoramento com Actuator

## 🏗️ Arquitetura

```
┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│   Controller    │───▶│    Service      │───▶│   Repository    │
│   (REST API)    │    │ (Lógica Negócio)│    │ (Acesso Dados)  │
└─────────────────┘    └─────────────────┘    └─────────────────┘
                                                        │
                                               ┌─────────────────┐
                                               │   PostgreSQL    │
                                               │   (Database)    │
                                               └─────────────────┘
```

## 📝 Conformidade com Requisitos

✅ **Java 17** (requisito: Java 8+)  
✅ **Spring Boot, Spring Data JPA, Hibernate**  
✅ **PostgreSQL** (requisito: PostgreSQL ou MariaDB)  
✅ **Docker** para containerização  
✅ **Testes automatizados** com JUnit e Mockito  
✅ **Padrões de projeto** (MVC, Repository, Dependency Injection)  
✅ **Endpoints especificados** funcionando corretamente  
✅ **Estrutura de dados** conforme modelagem  

## 🚀 Como Contribuir

1. Fork do projeto
2. Criar branch para feature (`git checkout -b feature/nova-funcionalidade`)
3. Commit das mudanças (`git commit -m 'Adiciona nova funcionalidade'`)
4. Push para branch (`git push origin feature/nova-funcionalidade`)
5. Abrir Pull Request
