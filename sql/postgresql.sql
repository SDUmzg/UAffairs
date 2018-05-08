DROP TABLE IF EXISTS uaffairs_files;
create table uaffairs_files(
  id BIGSERIAL PRIMARY KEY ,
  file_name varchar(100) NOT NULL ,
  content bytea ,
  operate_time TIMESTAMP
);





/*- id                   serial
- file_name        varchar(100)
- content           bytea
- operate_time   timestamp*/