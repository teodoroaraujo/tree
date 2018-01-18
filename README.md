# tree
Application tree using rest with java8, spring boot e maven.
O Desenvolvimento foi feito em spring boot versão 1.5.1.RELEASE, mysql e maven.
Para a criação do .war executar o seguinte comando.
-mvn package na estrutura da pasta onde se encontra o arquivo pom.xml
Foi utilizado o mysql para a manipulação dos dados
- Os arquivos para configuração do banco de dados se encontra no application.properties
- Para subir a aplicação é necessario criar o schema no mysql com o nome de "node".
- Depois de criado é so executar a aplicação.
Segue os passos para subir a aplicação
- No projeto tem um arquivo application.properties com uma propriedade com o nome:
    spring.jpa.hibernate.ddl-auto = create-drop
  Essa propriedade e para subir a aplicação criando o banco de dados.
- A aplicação está sendo executada na porta -8888, no application.properties existe uma propriedade com o nome server.port que pode ser modificada para não ter conflido na aplicação
- Executar a classe ApplicationConfig
- Foi utilizado o swagger para API Rest.
- Para verificar quais são os metodos que foram utilizado acessar a seguinte url depois que a aplicação estiver ativa:
- http://localhost:8888/swagger-ui.html


-OBS.: Se a aplicação for executada em um Tomcat externo vai ser considerado a porta que estiver configurada, o nome da aplicacação vai ser o nome que foi gerado no build pelo comando mvn. 
- Abaixo o exemplo do caminho para o Tomcat externo:
--http://localhost:8080/tree-spring-boot-rest-0.0.1-SNAPSHOT/node
