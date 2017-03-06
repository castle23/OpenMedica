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
    
