insert into shoppinglist.lists (user_id, name, color, created_utc, modified_utc) values (1, 'Test List', '#000000', '2016-11-30 03:42:56', '2016-11-30 03:42:56');

insert into shoppinglist.list_items (list_id, contents, priority, is_checked, created_utc, modified_utc) values (1, 'Hello there', 1, false, '2016-11-30 03:42:56', '2016-11-30 03:42:56');

insert into shoppinglist.notes (item_id, body, created_utc, modified_utc) values (1, 'this is where my paragraph would go', '2016-11-30 03:42:56', '2016-11-30 03:42:56');
