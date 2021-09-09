use christoskotsoudatabase;

-- For Student, please change '?' wiht your choose number
SELECT * FROM student; -- find everthing about student
SELECT * FROM student WHERE id = ? ;  -- find student about id
INSERT INTO student (firstname, lastname, dateOfBirth, tuitionFees) VALUES (?, ?, ?, ?); -- create a student

SELECT * FROM student
join CoursesPerStudents on  student.id= CoursesPerStudents.student_id
join course on  course.id = CoursesPerStudents.course_id                 
where course.id = ? ; -- find students per course

select * from student
join coursesperstudents on  student.id= coursesperstudents.student_id
join course on  course.id = coursesperstudents.course_id
where student.id = ?; -- student that belong up to a course

INSERT INTO coursesperstudents(Course_id,student_id)
values (?,?); -- insert student to a course



-- For assignment, please change '?' wiht your choose number
SELECT * FROM assignment; -- find everthing about assignment
SELECT * FROM assignment WHERE id = ?; -- find assignment about id
INSERT INTO assignment (title, description, subDateTime, oralMark, totalMark) VALUES (?, ?, ?, ?, ?); -- create a assignment

select * from assignment
join coursesperassignments on  assignment.id= coursesperassignments.assignment_id
join course on  course.id = coursesperassignments.course_id
where course.id = ? ; -- find assignments per course

select * from course
join coursesperstudents on course.id = coursesperstudents.course_id
join coursesperassignments on course.id = coursesperassignments.course_id
join student on student.id = coursesperstudents.student_id
join assignment on assignment.id = coursesperassignments.Assignment_ID
where student.id = ?; -- assignments per student

INSERT INTO coursesperassignments(Course_id,assignment_id)
values (?,?); -- insert assignment to a course



-- For Trainer, please change '?' wiht your choose number
SELECT * FROM trainer; -- find everting abou trainer
SELECT * FROM trainer WHERE id = ?; -- find trainer about id
INSERT INTO trainer (firstName, lastName, subject) VALUES (?, ?, ?); -- create a trainer

select * from trainer
join CoursesPerTrainers on  trainer.id= CoursesPerTrainers.trainer_id
join course on  course.id = CoursesPerTrainers.course_id
where course.id = ? ; -- find trainers per course

insert into coursespertrainers(Course_id,trainer_id)
values (?,?); -- insert trainer to a course




-- For course, please change '?' wiht your choose number
SELECT * FROM course; -- find everthing about course
SELECT * FROM course WHERE id = ?; -- find course about id
INSERT INTO course (title, stream, type, startDate, endDate) VALUES (?, ?, ?, ?, ?); -- create a course





