-- streamworx_test.post definition

CREATE TABLE `post` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL,
  `body` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO streamworx_test.post
(id, user_id, body, title)
VALUES(1, 1, 'this is body update', 'Test update');
INSERT INTO streamworx_test.post
(id, user_id, body, title)
VALUES(2, 1, 'est rerum tempore
vitae
sequi sint nihil reprehenderit
dolor beatae ea dolores neque
fugiat', 'qui est esse');
INSERT INTO streamworx_test.post
(id, user_id, body, title)
VALUES(5, 1, 'this is body', 'Test insert');
INSERT INTO streamworx_test.post
(id, user_id, body, title)
VALUES(6, 1, 'this is body', 'Test insert');
INSERT INTO streamworx_test.post
(id, user_id, body, title)
VALUES(7, 1, 'this is body', 'Test insert');
INSERT INTO streamworx_test.post
(id, user_id, body, title)
VALUES(8, 1, 'this is body', 'Test insert');
INSERT INTO streamworx_test.post
(id, user_id, body, title)
VALUES(10, 2, 'this is body 2', 'Test insert 2');