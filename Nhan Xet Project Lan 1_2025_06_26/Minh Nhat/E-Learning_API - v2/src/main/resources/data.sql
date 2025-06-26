-- =========================
-- ACCOUNT (10 người dùng)
-- =========================
INSERT INTO account (username, password, role, email, create_at, update_at, date_of_birth, address)
VALUES
    ('admin', 'hashed_admin', 'ADMIN', 'admin@elearn.com', NOW(), NOW(), '1985-01-01', 'Hà Nội'),
    ('alice', 'hashed_pass1', 'USER', 'alice@gmail.com', NOW(), NOW(), '1995-03-15', 'TP HCM'),
    ('bob', 'hashed_pass2', 'USER', 'bob@gmail.com', NOW(), NOW(), '1990-07-12', 'Đà Nẵng'),
    ('charlie', 'hashed_pass3', 'USER', 'charlie@gmail.com', NOW(), NOW(), '1998-10-22', 'Cần Thơ'),
    ('david', 'hashed_pass4', 'USER', 'david@gmail.com', NOW(), NOW(), '1992-09-05', 'Hải Phòng'),
    ('eve', 'hashed_pass5', 'USER', 'eve@gmail.com', NOW(), NOW(), '1996-12-01', 'Huế'),
    ('frank', 'hashed_pass6', 'USER', 'frank@gmail.com', NOW(), NOW(), '1988-11-11', 'Quảng Ninh'),
    ('grace', 'hashed_pass7', 'USER', 'grace@gmail.com', NOW(), NOW(), '1994-04-04', 'Nha Trang'),
    ('henry', 'hashed_pass8', 'USER', 'henry@gmail.com', NOW(), NOW(), '1993-06-06', 'Buôn Ma Thuột'),
    ('ivy', 'hashed_pass9', 'USER', 'ivy@gmail.com', NOW(), NOW(), '1999-08-08', 'Vũng Tàu');

-- =========================
-- CATEGORY (5 thể loại)
-- =========================
INSERT INTO category (name)
VALUES
    ('Backend Development'),
    ('Frontend Development'),
    ('Data Science'),
    ('Mobile App'),
    ('DevOps');

-- =========================
-- COURSE (10 khoá học)
-- =========================
INSERT INTO course (name, number_of_sessions, duration_hours, description, category_id)
VALUES
    ('Spring Boot Basics', 12, 24, 'Learn REST APIs with Spring Boot', 1),
    ('Advanced Java', 15, 30, 'Java multi-threading and design patterns', 1),
    ('ReactJS Essentials', 10, 20, 'Frontend with ReactJS', 2),
    ('VueJS from Zero to Hero', 12, 25, 'VueJS for beginners and pros', 2),
    ('Python for Data Science', 14, 28, 'pandas, matplotlib, scikit-learn', 3),
    ('Machine Learning 101', 20, 40, 'Intro to ML with Python', 3),
    ('Android Development', 16, 32, 'Build Android apps with Kotlin', 4),
    ('iOS Swift Basics', 14, 28, 'iOS apps with Swift', 4),
    ('CI/CD with Jenkins', 8, 16, 'Automate deployment pipelines', 5),
    ('Docker & Kubernetes', 10, 20, 'Containers and orchestration', 5);

-- =========================
-- CERTIFICATE (20 chứng chỉ)
-- =========================
INSERT INTO certificate (type, score, issue_date, account_id, course_id)
VALUES
-- alice
('MASTER', 91.2, '2024-06-01', 2, 1),
('PROFESSIONAL', 78.5, '2024-06-05', 2, 5),
('ASSOCIATE', 60.0, '2024-06-12', 2, 9),

-- bob
('PROFESSIONAL', 75.0, '2024-06-02', 3, 2),
('MASTER', 88.3, '2024-06-07', 3, 6),

-- charlie
('ASSOCIATE', 68.0, '2024-06-03', 4, 3),
('PROFESSIONAL', 74.5, '2024-06-09', 4, 7),

-- david
('MASTER', 90.0, '2024-06-10', 5, 4),
('ASSOCIATE', 62.0, '2024-06-13', 5, 8),

-- eve
('PROFESSIONAL', 71.0, '2024-06-04', 6, 1),
('MASTER', 92.5, '2024-06-06', 6, 5),

-- frank
('ASSOCIATE', 58.0, '2024-06-08', 7, 10),
('MASTER', 89.9, '2024-06-11', 7, 2),

-- grace
('PROFESSIONAL', 76.3, '2024-06-15', 8, 6),
('ASSOCIATE', 66.0, '2024-06-16', 8, 3),

-- henry
('MASTER', 95.0, '2024-06-18', 9, 7),
('ASSOCIATE', 60.5, '2024-06-19', 9, 8),

-- ivy
('PROFESSIONAL', 73.0, '2024-06-20', 10, 4),
('MASTER', 90.1, '2024-06-21', 10, 9);
