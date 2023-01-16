-- CREATEs 
CREATE TABLE tb_user(
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
	s_name VARCHAR(60) NOT NULL, 
	s_login VARCHAR(60) NOT NULL UNIQUE,
	s_email VARCHAR(100) NOT NULL UNIQUE,
	s_password VARCHAR(255) NOT NULL,
	s_bio VARCHAR(150) NOT NULL,
	d_birthday DATE NOT NULL
);

CREATE TABLE tb_student(
	id INTEGER PRIMARY KEY, 
	s_enrollment VARCHAR(50) NOT NULL UNIQUE
);

ALTER TABLE tb_student
	ADD FOREIGN KEY fk_tb_student_id_user (id) 
		REFERENCES tb_user(id);

CREATE TABLE tb_teacher(
	id INTEGER PRIMARY KEY AUTO_INCREMENT, 
	s_siape CHAR(7) NOT NULL
);

ALTER TABLE tb_teacher
	ADD FOREIGN KEY fk_tb_teacher (id) 
		REFERENCES tb_user(id);
	
CREATE TABLE tb_subject(
	id INT PRIMARY KEY AUTO_INCREMENT,
	s_name VARCHAR(30) NOT NULL,
	s_abbreviation VARCHAR(5) NOT NULL
);

CREATE TABLE tb_topic(
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
	s_content VARCHAR(400) NOT NULL,
	s_privacy VARCHAR(30) NOT NULL, 
	t_creation DATETIME NOT NULL, 
	s_type_author VARCHAR(30) NOT NULL, 
	s_path_image VARCHAR(150),
	id_subject INTEGER NOT NULL,
	id_author INTEGER NOT NULL
);

ALTER TABLE tb_topic 
	ADD FOREIGN KEY fk_tb_question_id_subject (id_subject)
		REFERENCES tb_subject(id);

ALTER TABLE tb_topic 
	ADD FOREIGN KEY fk_tb_question_id_creator (id_author)
		REFERENCES tb_user(id);
	
ALTER TABLE tb_topic 
	ADD CONSTRAINT cc_s_type_author CHECK (s_type_author IN ('PUBLIC', 'ANONYMOUS'));

ALTER TABLE tb_topic 
	ADD CONSTRAINT cc_s_privacy CHECK (s_privacy IN ('PUBLIC', 'SUBJECT_TEACHERS', 'CLASSMATES', 'STUDENTS', 'TEACHERS'));
-- Todo: Completar depois
		
-- ALTERs
