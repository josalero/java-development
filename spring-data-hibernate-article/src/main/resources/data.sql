
INSERT INTO `role` (`role_id`, `role`)
VALUES
	(1,'ADMIN');


INSERT INTO `user` (`user_id`, `name`, `password`)
VALUES
	(1,'Sam','sam'),
	(2,'youtube','youtube');
	
INSERT INTO `user_role` (`user_id`, `role_id`)
VALUES
	(1,1);