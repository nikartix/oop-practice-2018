
# Using database test_db
USE test_db;

# Inserting courses
INSERT INTO courses 
	(course_id, course_name, course_credit, course_type)
VALUES
	(1, 'Linear Algebra', 6, 'MATH'),
	(2, 'Discrete Mathematics', 7, 'MATH'),
	(3, 'Probability and Statistics', 6, 'MATH'),
	(4, 'Programming Paradigms', 7, 'CS'),
	(5, 'OOP', 7, 'CS'),
    (6, 'Information Theory', 5, 'CS');

# Inserting students
INSERT INTO students
	(student_id, idnumber, firstname, lastname)
VALUES
	(1, '01234567890', 'David', 'Backham'),
	(2, '11111111111', 'Michael', 'Jordan'),
	(3, '22222222222', 'Steven', 'Wonder'),
	(4, '33333333333', 'Kelly', 'Rowland'),
	(5, '44444444444', 'Elaine', 'Ban'),
	(6, '55555555555', 'Emma', 'Watson');

# Inserting student courses (inserting result of query)
INSERT INTO student_courses
	(course_id, student_id)
SELECT c.id, s.id
	FROM students AS s
    INNER JOIN courses AS c
    WHERE 
		(s.firstname = 'David' AND c.course_type = 'MATH') OR
        (s.firstname = 'Michael' AND c.course_type = 'CS') OR
        (s.student_id % 2 = 0 AND c.course_credit > 6) OR
        (s.student_id % 2 = 1 AND c.course_credit <= 6);
