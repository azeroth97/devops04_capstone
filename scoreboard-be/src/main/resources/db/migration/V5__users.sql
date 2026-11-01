drop table if exists users;
create table users (
    id serial primary key
  , username text
  , password text
  , created_at timestamp default now()
  , updated_at timestamp default now()
);