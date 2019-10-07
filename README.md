# Configuração do JAAS e Data Source
Repositório dos projetos utilizados como exemplo na disciplina de Desenvolvimento de Aplicações Web II no curso técnico integrado em informática do IFPB Campus Esperança.

-  NÃO implante a aplicação ainda antes de realizar todas essas configurações;
-  Certifique-se que o Wildfly está executando;
-  As configurações serão feitas via linha de comando. Para isso, acessem a pasta WILDFLY_HOME\bin e executem o seguinte comando:

`jboss-cli.bat` 
No Windows
`./jboss-cli.sh` 
No Linux

- Execute os seguintes comandos:

`connect`


Para adicionar a dependência do Postgres:

- No Windows:
`module add --name=org.postgres --resources=C:\Users\Aluno\.m2\repository\org\postgresql\postgresql\9.4.1212\postgresql-9.4.1212.jar --dependencies=javax.api,javax.transaction.api`
- Ou no Linux:
`module add --name=org.postgres --resources=/home/arthurmts/.m2/repository/org/postgresql/postgresql/9.4.1212/postgresql-9.4.1212.jar --dependencies=javax.api,javax.transaction.api_

Para cadastrar o driver:

`/subsystem=datasources/jdbc-driver=postgres:add(driver-name="postgres", driver-module-name="org.postgres", driver-class-name="org.postgresql.Driver")`

/subsystem=datasources/data-source=PostgreSQLPool:add(driver-name="postgres", jndi-name="java:/karthugoDS", connection-url="jdbc:postgresql://localhost:5432/CRUDPCs ", user-name="postgres", password="postgres")

`/subsystem=security/security-domain=karthugoJdbcRealm/:add(cache-type=default)`

/subsystem=security/security-domain=karthugoJdbcRealm/authentication=classic:add(login-modules=[{code=Database, flag=Required, module-options={ \
    dsJndiName="java:/karthugoDS", \
    principalsQuery="select password from usuario where username = ?", \
    rolesQuery="select grupo, 'Roles' from usuario where username = ?", \
    hashAlgorithm="SHA-256", \
    hashEncoding="base64" \
}}])

reload

quit


