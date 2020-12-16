Bem vindo ao SWAPI - Back!
===================

----------
Swagger - [demonstração](http://lb-spring-itau-315118071.us-east-2.elb.amazonaws.com:8080/swapi/swagger-ui/index.html)

## O que preciso para subir a aplicação

- Gerenciador de dependencias e build, Maven.

- Java 11

- MariaDB

## Configurações do Banco de Dados:

Configurações do banco de dados se encontram no application.yml conforme abaixo:

    spring:
        datasource:
            driver-class-name: <driver>
            url: <url>
            username: <username>
            password: <password>
    
## Gerando o Pacote
Sendo um projeto Maven, execute os goals clean e install na raiz do projeto para baixar as dependências e gerar jar do projeto

     $ mvn clean install
     
## Executando o Jar

Como se trata de um projeto Spring Boot, podemos simplismente executar o jar que foi gerado na pasta target e a 
aplicação irá subir em um tomcat embedded.

    #!/<folderProject>/target
    $ java -jar swapi-0.0.1-SNAPSHOT.jar

Configuração da porta da api se encontra no application.yml:
		
	server:
	    port: 8080

Pronto, a aplicação deve estar online na porta 9000.

## Consumir API

Para consumir a API basta acessar por exemplo a url para buscar todas as pessoas http://localhost:8080/swapi/peoples.
 - Documentaçao - [Swagger Link](http://lb-spring-itau-315118071.us-east-2.elb.amazonaws.com:8080/swapi/swagger-ui/index.html)

Dependências
-------------------
Abaixo as tecnologias que foram utilizadas no projeto:

 - MariaDB
 - Swagger
 - MapStruct
 - H2
 - Mockito
 - JUnit5
 - ArchUnit
 
Deploy
------------------- 
 - Github Action + (AWS) Fargate, Elastic Container Registry, Relational Database Service
