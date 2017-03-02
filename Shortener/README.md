# Instruções
Não é necessário instalar um banco de dados ou fazer qualquer alteração para rodar a aplicação.
<br>
Caso queira mudar a porta do Tomcat basta alterar a primeira linha do arquivo application.properties.
<br>
Caso não queira utilizar o Cliente da aplicação recomendo o uso do Postman!
<br>
Caso queira utilizar um servidor de aplicação, ex: wildfly, será necessário configurar o datasource para acessar o seguinte JNDI:
<br>
spring.datasource.jndi-name=java:jboss/datasources/shortenerDB basta ativar o profile de produção:
<br>                        
mvn -Dspring.profiles.active=dev-persistent spring-boot:run <br>
rodar Wildfly por exemplo:<br>
mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=production


## Maven 
Criação do  H2 para desenvolvimento:
<br>
mvn -Dspring.datasource.url=jdbc:h2:./shortenDB -Dspring.jpa.hibernate.ddl-auto=create clean test
Run: <br>
mvn spring-boot:run
<br>
Rodar o banco com persistência:
<br>
mvn -Dspring.profiles.active=dev-persistent spring-boot:run

## Endpoints
POST: http://localhost:8080/create?url= <br>
POST: http://localhost:8080/create?url=&alias= <br>
GET: http://localhost:8080/retrive?url=&alias= <br>
GET: http://localhost:8080/dashaboard <br>
console H2: http://localhost:8080/console


## Tecnologias 
1. Java JDK 8
2. SpringBoot 1.5.1
3. Spring Data JPA
4. Spring Web MVC
5. SGDB Relacional H2 com servelet de console: http://localhost:8080/console 
6. YAML - Configuração e profiles https://hoserdude.com/2014/06/19/spring-boot-configurationproperties-and-profile-management-using-yaml/
7. Postman client Rest e Soap: https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop



## Bonus Points

1. Crie *testcases* para todas as funcionalidades criadas<br>
   Feito
2. Crie um *endpoint* que mostre as dez *URL's* mais acessadas <br>R = http://localhost:8080/dashaboard

3. Crie um *client* para chamar sua API <br> 
R =  localhost:8080/client.html (Bootstrap + Jquery)<br>
foi utlizada a ferramanta Postman: Postman client Rest e Soap:  https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop

4. Faça um diagrama de sequencia da implementação feita nos casos de uso (Dica, use o https://www.websequencediagrams.com/)
  ![Short URL](https://github.com/newbare/hire.me/blob/master/Shortener/src/main/resources/docs/Shorten.png)
  ![Retrive URL](https://github.com/newbare/hire.me/blob/master/Shortener/src/main/resources/docs/recuperar.png)
  
5. Monte um deploy da sua solução utilizando containers 
 ![Deploy URL](https://github.com/newbare/hire.me/blob/master/Shortener/src/main/resources/docs/Deployment%20Shortener%20API.png)
