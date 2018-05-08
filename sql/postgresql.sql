DROP TABLE IF EXISTS uaffairs_files;
create table uaffairs_files(
  id BIGSERIAL PRIMARY KEY ,
  file_name varchar(100) NOT NULL ,
  content bytea ,
  operate_time TIMESTAMP
);
