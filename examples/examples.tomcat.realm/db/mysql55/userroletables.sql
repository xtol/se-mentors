<!-- DB is assumed to be named 'authority'.  If another DB name is  -->
<!-- used, then the information in the <tomcathome>/conf/server.xml -->
<!-- under the Realm element, connectionURL should be changed from  -->
<!-- jdbc:mysql://localhost/authority?user=root       to            -->
<!-- jdbc:mysql://localhost/<newdbname>?user=root                   -->
create table users (
  user_name         varchar(15) not null primary key,
  user_pass         varchar(15) not null
);

create table user_roles (
  user_name         varchar(15) not null,
  role_name         varchar(15) not null,
  primary key (user_name, role_name)
);