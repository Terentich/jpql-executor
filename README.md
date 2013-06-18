jpql-executor
=============

Description
-----------
The simple CLI-application for executing JPQL ([Java Persistence Query Language](http://en.wikipedia.org/wiki/Java_Persistence_Query_Language)) queries to databases.

Requirements
------------
It needs a Java Virtual Machine of at least version 1.6 ([Java SE 6.0](http://www.oracle.com/technetwork/java/javase/downloads/index.html)).
If you want to build the jar from source, you will also need [Maven](http://maven.apache.org/).

Usage
-----

1. Build with [Maven](http://maven.apache.org/):

   ```bash
   mvn package
   ```
2. Unpack created archive jpql-executor*.zip.
3. Place the required [JDBC](http://en.wikipedia.org/wiki/Java_Database_Connectivity)-driver for your database into the lib directory.
4. Run application with following syntax:
   ```bash
   jpql-executor.bat <entities archive> <unit name> <JPQL query>
   ```   
   Where:  
   **entities archive** - the jar-file with entity classes ([@Entity](http://docs.oracle.com/javaee/6/api/javax/persistence/Entity.html)),  
   **unit name** - the persistence unit name described in the [persistence.xml](http://docs.oracle.com/javaee/6/tutorial/doc/bnbqw.html#bnbrj) inside jar-file with entity classes,  
   **JPQL query** - the query string

   Example:
   
   ```bash
   jpql-executor.bat entity.jar default "SELECT entity FROM Entity entity"
   ```

Restrictions
------------

The application is execute in unmanaged environment as JavaSE program (without application container).  
**Therefore possible to use only persistence.xml with explicit database 
[properties](http://wiki.eclipse.org/EclipseLink/Examples/JPA/Configure) 
(url, user, password) and not with JNDI and other EE technologies**.

License
-------

The MetaJ library publish under the [Apache Software License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.txt).

Continuous Integration
------
Last build status on [Travis CI](https://travis-ci.org/Terentich/jpql-executor/builds):

[![Build Status](https://travis-ci.org/Terentich/jpql-executor.png)](https://travis-ci.org/Terentich/jpql-executor)
