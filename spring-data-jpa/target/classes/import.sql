insert into library (id,library_name) values (1, 'Biblioteka Miejska');

insert into author (id, name, surname) values (1, 'Adam', 'Mickiewicy');
insert into author (id, name, surname) values (2, 'Jan', 'Kowalski');

insert into book (id, title,library_id) values (1, 'Pierwsza książka',1);
insert into book (id, title,library_id) values (2, 'Druga książka',1);
insert into book (id, title,library_id) values (3, 'Trzecia książka',1);

insert into book_author_relation (book_id, author_id) values (1, 1);
insert into book_author_relation (book_id, author_id) values (1, 2);
insert into book_author_relation (book_id, author_id) values (2, 2);
insert into book_author_relation (book_id, author_id) values (3, 2);

