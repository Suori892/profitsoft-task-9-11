create table if not exists Buyer(
    buyer_id bigint auto_increment primary key,
    name varchar(255) not null,
    email varchar(255) not null unique check(email like '%@gmail.com')
    );

insert into Buyer(name, email) values ('John', 'john232@gmail.com'),
                                      ('Michael', 'michael897@gmail.com'),
                                      ('Bob', 'bobbb24@gmail.com'),
                                      ('Ann', 'ann90@gmail.com'),
                                      ('Albert', 'albert8975@gmail.com'),
                                      ('Rafael', 'raffy89@gmail.com'),
                                      ('Maria', 'maria8712@gmail.com');

create table if not exists Item(
    item_id bigint auto_increment primary key,
    buyer_id bigint not null references Buyer(buyer_id),
    item_name varchar(255),
    item_category varchar(255)
    );

insert into Item(buyer_id, item_name, item_category) values (1, 'headphones', 'electronics'),
                                                                        (1, 'iphone', 'electronics'),
                                                                        (2, 'pan', 'kitchen'),
                                                                        (2, 'headphones', 'electronics'),
                                                                        (3, 'pot', 'kitchen'),
                                                                        (4, 'book', 'education'),
                                                                        (4, 'iphone', 'electronics'),
                                                                        (5, 'notebook', 'education'),
                                                                        (5, 'book', 'education'),
                                                                        (5, 'pan', 'kitchen'),
                                                                        (6, 'book', 'education'),
                                                                        (6, 'notebook', 'education'),
                                                                        (6, 'book', 'education'),
                                                                        (7, 'pot', 'kitchen'),
                                                                        (7, 'pen', 'education'),
                                                                        (7, 'pen', 'education'),
                                                                        (7, 'iphone', 'electronics');