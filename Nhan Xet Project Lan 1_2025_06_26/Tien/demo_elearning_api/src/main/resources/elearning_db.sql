CREATE DATABASE IF NOT EXISTS elearning_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE elearning_db;

CREATE TABLE category (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(255) NOT NULL
);

CREATE TABLE course (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        title VARCHAR(255) NOT NULL,
                        description TEXT,
                        category_id BIGINT,
                        CONSTRAINT fk_course_category FOREIGN KEY (category_id) REFERENCES category(id)
);

CREATE TABLE certificate (
                             id BIGINT AUTO_INCREMENT PRIMARY KEY,
                             type VARCHAR(50) NOT NULL,
                             course_id BIGINT,
                             CONSTRAINT fk_certificate_course FOREIGN KEY (course_id) REFERENCES course(id)
);

INSERT INTO category (name) VALUES ('Programming'), ('Design'), ('Marketing');

INSERT INTO course (title, description, category_id) VALUES
                                                         ('Spring Boot Basics', 'Learn the basics of Spring Boot', 1),
                                                         ('UI/UX Design Fundamentals', 'Introduction to UI/UX Design', 2),
                                                         ('Digital Marketing 101', 'Getting started with digital marketing', 3);



