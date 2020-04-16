create table students(
student_id integer primary key,
student_name varchar(50),
street varchar(50),
state varchar(30),
zipcode varchar(7)
);

create table schools(
prior_school_id integer primary key,
prior_school_addr varchar(50),
gpa number(2)
);

create table applications(
app_no integer primary key,
app_year integer primary key,
student_id integer primary key,
reference_institution varchar(100) primary key,
reference_name varchar(60),
ref_statement varchar(300), 
FOREIGN KEY(student_id) REFERENCES students(student_id),
FOREIGN KEY(ref_institution) REFERENCES schools(prior_school_id)
);
