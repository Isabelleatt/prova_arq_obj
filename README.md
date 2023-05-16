# Avaliação 2 - Arquitetura de Objetos


**PERGUNTA 1**

Crie uma API REST com o Spring que contenha as seguintes rotas:

`GET /hotel` -> lista todos os filmes cadastrados. Esta rota deve ter dois query params, um que filtra os hoteis pelo número de estrelas, de 1 a 5, e outro que filtra pelo valor minímo da diária.

`GET /hotel/{idHotel}` -> Recupera um hotel específico.POST /hotel -> Cria um hotel, podem definir os dados que serão salvos, mas no minímo deve ter o número de estrelas e o valor da diária.

`DELETE /hotel` -> Deleta um hotel do banco de dados.

A API deve acessar um banco de dados H2.

Path: `hotel/src/main/java/api/avaliacao/hotel`

1. Classe principal da aplicação:

    Nome do arquivo: HotelApplication.java

2. Controlador (Controller) para as rotas:

    Nome do arquivo: HotelController.java

3. Classe de serviço (Service) para manipular a lógica de negócio:

    Nome do arquivo: HotelService.java

4. Classe de modelo (Model) para representar a entidade Hotel:

    Nome do arquivo: Hotel.java

Acesso ao banco de dados H2:

Para realizar as modificações para acesso ao banco de dados H2 realizei as seguintes alterações:

1. Adicionei a dependencia do H2 no arquivo pom.xml:

    Nome do arquivo: pom.xml

    * `<dependency>`: Adiciona a dependência do H2 no projeto.

    * `<scope>`: Define o escopo da dependência. No caso, "runtime" indica que a dependência é necessária apenas em tempo de execução.

    ```
    	<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>
    ```

1. Modifiquei o arquivo de configuração do banco de dados:

    Nome do arquivo: application.properties

    * `spring.datasource.url`: Define a URL de conexão com o banco de dados H2. No exemplo, jdbc:h2:mem:testdb indica que estamos usando o H2 em memória e o nome do banco de dados é "testdb".

    * `spring.datasource.driverClassName`: Define a classe do driver JDBC a ser utilizada para se conectar ao H2. Nesse caso, org.h2.Driver é o driver JDBC do H2.

    * `spring.datasource.username`: Define o nome de usuário para a conexão com o H2. No exemplo, está definido como "sa".

    * `spring.datasource.password`: Define a senha para a conexão com o H2. No exemplo, está em branco, indicando que não há senha configurada.

    * `spring.jpa.database-platform`: Define a plataforma de banco de dados que será utilizada pelo Spring Data JPA. No caso do H2, estamos usando org.hibernate.dialect.H2Dialect.

    * `spring.h2.console.enabled`: Define se o console do H2 está habilitado. No exemplo, está configurado como "true".

    * `spring.h2.console.path`: Define o caminho (path) para acessar o console do H2. No exemplo, está configurado como "/h2-console".

2. Criei o arquivo aplication.yml no diretório src/main/resources para configurar o console do H2:

    Nome do arquivo: application.yml

    * `spring.h2.console.enabled`: Define se o console do H2 está habilitado. No exemplo, está configurado como "true".

    * `spring.h2.console.path`: Define o caminho (path) para acessar o console do H2. No exemplo, está configurado como "/h2-console".

**PERGUNTA 2**

Implemente um Front End com duas telas, uma que salva um hotel, usando a API desenvolvida no exercício anterior e outra que lista um hotel.

Path: `hotel_front/`

```
    hotel-frontend/
    ├── index.html
    ├── scripts/
    │   └── main.js
    └── styles/
        └── main.css
```
1. index.html: Arquivo HTML que contém a estrutura da página.

2. main.css: Arquivo CSS que contém a estilização da página.

3. main.js: Arquivo JavaScript que contém a lógica da página.

