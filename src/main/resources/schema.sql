USE heroku_954c820b76f9b7e ;

CREATE TABLE IF NOT EXISTS heroku_954c820b76f9b7e.lists (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  user_id INT UNSIGNED NOT NULL,
  list_id INT UNSIGNED NOT NULL,
  name VARCHAR(45) NOT NULL,
  color VARCHAR(45) NOT NULL,
  is_checked BOOLEAN NOT NULL DEFAULT FALSE,
  created_utc TIMESTAMP  NOT NULL,
  modified_utc TIMESTAMP  NOT NULL,
  PRIMARY KEY(id));

CREATE TABLE IF NOT EXISTS heroku_954c820b76f9b7e.list_items (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  list_id INT UNSIGNED NOT NULL,
  contents VARCHAR(45) NOT NULL,
  priority INT NOT NULL,
  is_checked BOOLEAN NOT NULL DEFAULT FALSE,
  created_utc TIMESTAMP NOT NULL,
  modified_utc TIMESTAMP NOT NULL,
  PRIMARY KEY (id));

CREATE TABLE IF NOT EXISTS heroku_954c820b76f9b7e.notes (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  item_id INT UNSIGNED NOT NULL,
  body VARCHAR(1000) NOT NULL,
  created_utc TIMESTAMP NOT NULL,
  modified_utc TIMESTAMP NOT NULL,
  PRIMARY KEY (id));