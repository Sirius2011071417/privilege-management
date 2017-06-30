# 基于过滤器(PrivilegeFilter)的权限管理
## sql
```
create database privilege CHARSET=utf8;

create table privilege (
id varchar(40) primary key,
name varchar(100),
description varchar(200)
) CHARSET=utf8;

create table role (
id varchar(40) primary key,
name varchar(100),
description varchar(200)
) CHARSET=utf8;

create table user (
id varchar(40) primary key,
username varchar(100),
password varchar(100)
) CHARSET=utf8;
-- user(多)-role(多)
create table user_role (
user_id varchar(40),
role_id varchar(40),
primary key (`user_id`, `role_id`),
CONSTRAINT user_fk foreign key (`user_id`) references user(`id`),
CONSTRAINT role_fk foreign key (`role_id`) references role(`id`)
) CHARSET=utf8;
-- role(多)-privilege(多)
create table role_privilege (
role_id varchar(40),
privilege_id varchar(40),
primary key (`role_id`, `privilege_id`),
CONSTRAINT role_id_fk foreign key (`role_id`) references role(`id`),
CONSTRAINT privilege_id_fk foreign key (`privilege_id`) references privilege(`id`)
) CHARSET=utf8;
```
## 后台 http://localhost:8080/pri/manager.jsp
## 前台 http://localhost:8080/pri/index.jsp