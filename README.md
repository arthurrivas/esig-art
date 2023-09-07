# esig-art

Aplicação web Java usando a especificação JSF (JavaServer Faces) para gerenciar informações de Pessoas, Cargos e seus respectivos salários.

## Pré-requisitos

- JDK 8 ou superior
- Servidor de aplicação Tomcat 8.5
- Banco de dados relacional PostgreSQL
- Maven

## Passos de Configuração

1. **Abra a IDE:**

   Abra o Eclipse IDE (ou sua IDE preferida)

2. **Adicione o Servidor:**

   - No Eclipse, vá para a perspectiva "Servers" (Servidores).
   - Clique com o botão direito na área "Servers" e selecione "New" (Novo) > "Server" (Servidor).
   - Selecione o servidor de aplicação que você deseja configurar (nesse caso, Apache Tomcat 8.4) e clique em "Next" (Próximo).

3. **Configurar Detalhes do Servidor:**

   - Selecione o diretório de instalação do servidor (onde o servidor foi instalado).
   - Clique em "Finish" (Concluir) para adicionar o servidor.

4. **Configurar o Projeto:**

   - Volte para a perspectiva "Java EE" ou "Java".
   - Clique com o botão direito no projeto JSF e vá para "Properties" (Propriedades).
   - No painel esquerdo, selecione "Project Facets" (Facetas do Projeto).
   - Marque a opção "Dynamic Web Module" (Módulo Web Dinâmico).
   - Clique em "Apply" (Aplicar) e depois em "OK".

5. **Adicione o Projeto ao Servidor:**

   - Volte para a perspectiva "Servers" (Servidores).
   - Arraste e solte o projeto JSF para o servidor que você configurou na lista de servidores.

6. **Inicie o Servidor:**

   - Clique com o botão direito no servidor na aba "Servers" e selecione "Start" (Iniciar) para iniciar o servidor, ou "Run as --> Run on Server" na pasta do projeto.

7. **Acesse a Aplicação:**

   - Abra um navegador da web e acesse a aplicação usando a URL http://localhost:8080/esig-art/Pessoa.xhtml.


## Configuração do Banco de Dados

1. **Estrutura do Banco de Dados:**

   - Um arquivo de restore ja esta configurado para popular o banco toda vez que o servidor ser reiniciado.
   - Certifique-se de que você tenha um banco de dados PostgreSQL configurado.

2. **Configuração da Conexão:**

   - Ajuste as configurações de conexão no arquivo `src/main/resources/META-INF/persistence.xml` de acordo com as informações do seu banco de dados. Procure a seção `<jta-data-source>` e atualize-a com o nome da sua DataBase, nome de usuário e senha.
  
# Funcionalidades Principais

## Listagem de Salários

A aplicação oferece uma tela de Listagem de Salários que exibe informações detalhadas sobre Pessoas, Cargos e seus respectivos salários calculados.

## Cálculo de Salários

A funcionalidade de cálculo de salários está disponível na tela de Listagem de Salários. Quando essa opção é selecionada, a tabela `pessoa_salario` é preenchida automaticamente com os dados provenientes das tabelas `pessoa`, `cargo` e `vencimento`. Isso permite que os salários sejam calculados e atualizados de acordo com as regras estabelecidas.

# Diferenciais Implementados (opcionais)
## CRUD de Pessoa

Implementado um CRUD (Create, Read, Update, Delete) completo para a entidade Pessoa, que inclui a validação de campos. Isso garante que os dados fornecidos para a criação ou atualização de uma pessoa estejam de acordo com as regras estabelecidas. Caso haja campos inválidos ou ausentes, a validação impedirá a submissão dos dados.
