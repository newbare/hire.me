# Instruções
Não é necessário instalar um banco de dados ou fazer qualquer alteração para rodar a aplicação.
<br>
Caso queira mudar a porta do Tomcat basta alterar a primeira linha do arquivo application.properties.

## Tecnologias 
1. Java JDK 8
2. SpringBoot 1.5.1
3. Spring Data JPA
4. Spring Web MVC
5. SGDB Relacional H2 com servelet de console: http://localhost:8080/console 
6. Postman client Rest e Soap: https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop



## Bonus Points

1. Crie *testcases* para todas as funcionalidades criadas
   Feito
2. Crie um *endpoint* que mostre as dez *URL's* mais acessadas R = http://localhost:8080/dashaboard

3. Crie um *client* para chamar sua API - R =  foi utlizada a ferramanta Postman: Postman client Rest e Soap:  https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop

4. Faça um diagrama de sequencia da implementação feita nos casos de uso (Dica, use o https://www.websequencediagrams.com/)
  ![Short URL](https://github.com/newbare/hire.me/blob/master/Shortener/src/main/resources/docs/Shorten.png)
  ![Retrive URL](https://github.com/newbare/hire.me/blob/master/Shortener/src/main/resources/docs/recuperar.png)
  
5. Monte um deploy da sua solução utilizando containers 
 ![Deploy URL](https://github.com/newbare/hire.me/blob/master/Shortener/src/main/resources/docs/Deployment%20Shortener%20API.png)
