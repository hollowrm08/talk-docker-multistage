-- INSERTs
-- tb_user
INSERT INTO tb_user VALUES (1, 'Rodrigo Mello', 'hollowrm', 'hollowrm08@gmail.com', '$2a$10$UrAkJnRik63ljf591HG94.6jTBtde5GsbHK4HIjj0s2MGdcNJEVVe', 'O criador desse sistema',  STR_TO_DATE('08/04/2003', '%d/%m/%Y'));
INSERT INTO tb_user VALUES (2, 'Iury Xaviel Pereira', 'quitgame', 'quitgame@gmail.com', '$2a$10$Xr4y4HH23hB7KJlHDVV6NuP4If5NRPkdLk639bas11.sX6wBWJTPW', 'voce foi hackeado',  STR_TO_DATE('29/12/2002', '%d/%m/%Y'));
INSERT INTO tb_user VALUES (3, 'João Vitor Schmidt Cecconello', 'cecconello', 'cecconello@gmail.com', '$2a$10$rNbkDUG0vTFAKtRCoLiDyOZUV4555VaadMhT4eXePlZLSqHt0vJNW', 'Fui criado na campanha',  STR_TO_DATE('12/09/2002', '%d/%m/%Y'));
INSERT INTO tb_user VALUES (5, 'Raquel Calloni', 'raqs', 'raquelcalloni@ifsul.edu.br', '$2a$10$jBvy6E2TbDMXLwYJlEwdku/oOJek4ZjZUteqlEm5.K0P6v1x7xfEq', 'relatorios!',  STR_TO_DATE('05/04/1983', '%d/%m/%Y'));

-- tb_student
INSERT INTO tb_student VALUES (1, '20181GR.TII_I0459');
INSERT INTO tb_student VALUES (2, '20181GR.TII_I0068');
INSERT INTO tb_student VALUES (3, '20181GR.TII_I0076');

-- tb_teacher
INSERT INTO tb_teacher VALUES (5, '3063343');

-- tb_subject
INSERT INTO tb_subject VALUES (1, 'Matemática', 'MAT');
INSERT INTO tb_subject VALUES (2, 'Português', 'PTG');
INSERT INTO tb_subject VALUES (3, 'Física', 'FIS');
INSERT INTO tb_subject VALUES (4, 'Educação Física', 'EDF');
INSERT INTO tb_subject VALUES (5, 'Biologia', 'BIO');
INSERT INTO tb_subject VALUES (6, 'Filosofia', 'FIL');
INSERT INTO tb_subject VALUES (7, 'Sociologia', 'SOC');
INSERT INTO tb_subject VALUES (8, 'Química', 'QUI');
-- Todo: Completar

-- tb_question
INSERT INTO tb_topic VALUES (1, 'A primeira pergunta do site: Deu certo?', 'PUBLIC', STR_TO_DATE('18/10/2021T9:49', '%d/%m/%YT%H:%i'), 'PUBLIC', NULL, 1, 1);

-- SELECTs 
SELECT * FROM tb_user;
SELECT * FROM tb_student;
SELECT * FROM tb_teacher;
SELECT * FROM tb_subject;
SELECT * FROM tb_topic;