
# Creating new database
# Character set: UTF8
# Collation is used to compare two strings of utf8mb4 characters.
CREATE DATABASE test_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE test_db;

# Creating courses table
CREATE TABLE courses (
	id INT PRIMARY KEY AUTO_INCREMENT,
    course_id INT NOT NULL,
    course_name VARCHAR(255) NOT NULL,
    course_credit INT NOT NULL DEFAULT 0,
    course_type VARCHAR(255),
    --
    CONSTRAINT courses_uk1 UNIQUE (course_id)
);

# Creating students table
CREATE TABLE students (
	id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT NOT NULL,
    idnumber CHAR(11) NOT NULL,
    firstname VARCHAR(100) NOT NULL,
    lastname VARCHAR(100) NOT NULL,
    register_date DATETIME NOT NULL DEFAULT NOW(),
    --
    CONSTRAINT students_uv1 UNIQUE (student_id),
    CONSTRAINT students_uv2 UNIQUE (idnumber)
);

# Create student courses table
CREATE TABLE student_courses (
	id INT PRIMARY KEY AUTO_INCREMENT,
    course_id INT NOT NULL,
    student_id INT NOT NULL,
    --
    CONSTRAINT student_courses_uk1 UNIQUE (course_id, student_id),
    CONSTRAINT student_courses_fk1 FOREIGN KEY (course_id)
		REFERENCES courses (id),
	CONSTRAINT student_courses_fk2 FOREIGN KEY (student_id)
		REFERENCES students (id)
)
