# OpenMedica

Para crear el acceso a la BD se de agregar lo siguiente en el archivo dominio.xml de su servidor glassfish

    <jdbc-resource pool-name="jdbc/coderappco" jndi-name="jdbc/coderappco"></jdbc-resource>
    <jdbc-connection-pool is-isolation-level-guaranteed="false" datasource-classname="org.postgresql.ds.PGSimpleDataSource" name="jdbc/coderappco" res-type="javax.sql.DataSource">
      <property name="PortNumber" value="5432"></property>
      <property name="Password" value="password"></property>
      <property name="User" value="user"></property>
      <property name="serverName" value="localhost"></property>
      <property name="DatabaseName" value="databaseName"></property>
      <property name="URL" value="jdbc:postgresql://localhost:5432/databaseName"></property>
    </jdbc-connection-pool>
    
Al igual que se debe cambiar los valores del archivo OpenMedica/OpenMedica-web/src/main/webapp/WEB-INF/glassfish-resources.xml por los de su conexion

<resources>
    <jdbc-connection-pool allow-non-component-callers="false" associate-with-thread="false" connection-creation-retry-attempts="0" connection-creation-retry-interval-in-seconds="10" connection-leak-reclaim="false" connection-leak-timeout-in-seconds="0" connection-validation-method="auto-commit" datasource-classname="org.postgresql.ds.PGSimpleDataSource" fail-all-connections="false" idle-timeout-in-seconds="300" is-connection-validation-required="false" is-isolation-level-guaranteed="true" lazy-connection-association="false" lazy-connection-enlistment="false" match-connections="false" max-connection-usage-count="0" max-pool-size="32" max-wait-time-in-millis="60000" name="post-gre-sql_coderappco_postgresPool" non-transactional-connections="false" pool-resize-quantity="2" res-type="javax.sql.DataSource" statement-timeout-in-seconds="-1" steady-pool-size="8" validate-atmost-once-period-in-seconds="0" wrap-jdbc-objects="false">
        <property name="serverName" value="localhost"/>
        <property name="portNumber" value="5432"/>
        <property name="databaseName" value="databaseName"/>
        <property name="User" value="user"/>
        <property name="Password" value="password"/>
        <property name="URL" value="jdbc:postgresql://localhost:5432/databaseName"/>
        <property name="driverClass" value="org.postgresql.Driver"/>
    </jdbc-connection-pool>
    <jdbc-resource enabled="true" jndi-name="jdbc/coderappco" object-type="user" pool-name="post-gre-sql_coderappco_postgresPool"/>
</resources>

