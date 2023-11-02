INSERT INTO _group (id,name) select 1, 'Admin' where not exists (select * from _group where id = 1);
INSERT INTO _group (id,name) select 2, 'User' where not exists (select * from _group where id = 2);
