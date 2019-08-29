Esse projeto ilustra o uso do padrão Factory Method.

É criada uma API REST para exemplificar.

### Exemplo para rodar em Docker

Baixar o projeto: 
> git clone

Executar na própria máquina: 
> ./mvnw spring-boot:run

Criar a imagem: 
> docker build -t pagamentoimg .

Rodar aplicação em conteiner: 
> docker run --name pagamento -p 8080:8080 -d pagamentoimg

### References

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Web Starter](https://docs.spring.io/spring-boot/docs/{bootVersion}/reference/htmlsingle/#boot-features-developing-web-applications)

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

