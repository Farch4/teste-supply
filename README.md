 Teste de desenvolvimento Supply Mida
 
 Objetivo: avaliar os conhecimentos tecnicos dos candidatos a desenvolvedor
 
 Pré-requisitos: 
  - Java JDK 11 ou superior
  - Wildfly 24 ou superior
  - Maven 3.0.2 ou superior
  
  Objetivo do teste
  - 1) ler e carregar na base de dados os contatos contidos no arquivo contatos.txt levando em consideração que o contato tem como chave primária o cpf/cnpj, e pode ter mais de um endereço.
    - no arquivo quando o contato tem mais de um endereço, os dados do contato se repete, o que não pode ocorrer na base de dados.
  - 2) exibir de forma tabular na página index.xhtml  os contatos e endereços.
    - já foi disponibilizada a biblioteca Primefaces 14.0 para auxiliar esta tarefa.
    
  Estrutura do projeto
  - pacote 'model' contém as entidade para servir ao projeto
  - pacote 'service' contém o serviço que pode fazer o serviço do DAO
  - pacote 'controller' contém o manager bean para servir a página /index.xhtml
  
  Executando o projeto
  - Para executar o projeto é necessário realizar o build (mvn install) e usar o artefato gerado em target/ no wildfly, o projeto já irá criar o banco de dados necessário para o teste, o perfil do wildfly pode ser o standalone.xml sem a necessidade de configurações extras
  - Para acessar o projeto, acsse viar browser a url http://localhost:8080/teste
