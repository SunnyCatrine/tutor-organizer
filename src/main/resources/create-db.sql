CREATE TABLE student
(
    id         smallserial,
    first_name varchar(30) NOT NULL,
    last_name  varchar(30),
    status     boolean
);

ALTER TABLE student
    ADD PRIMARY KEY (id);

CREATE TABLE student_contact_info
(
    id         smallserial PRIMARY KEY,
    country    varchar(30) NOT NULL,
    city       varchar(30),
    phone_no   varchar(30),
    skype      varchar(30) NOT NULL,
    timezone   varchar(30) NOT NULL,
    student_id smallint REFERENCES student (id) ON DELETE CASCADE
);

CREATE TABLE subject
(
    id           smallserial PRIMARY KEY,
    subject_name varchar(30) NOT NULL,
    student_id   smallint,
    FOREIGN KEY (student_id) references student (id)
);

CREATE TABLE agent
(
    id         smallserial PRIMARY KEY,
    first_name varchar(30) NOT NULL,
    last_name  varchar(30),
    country    varchar(30) NOT NULL,
    city       varchar(30),
    phone_no   varchar(30) NOT NULL,
    timezone   varchar(30) NOT NULL,
    student_id smallserial,
    FOREIGN KEY (student_id) references student (id)
);

ALTER TABLE agent
    ALTER COLUMN student_id TYPE smallint;

CREATE TABLE lesson
(
    id             smallserial PRIMARY KEY,
    date           date     NOT NULL,
    time           time[0]  NOT NULL,
    payment_status boolean  NOT NULL,
    price          smallint NOT NULL,
    duration       decimal  NOT NULL,
    student_id     smallint REFERENCES student (id) ON DELETE CASCADE
);

ALTER TABLE agent
    ALTER COLUMN student_id SET NOT NULL;

ALTER TABLE lesson
    ALTER COLUMN student_id SET NOT NULL;

ALTER TABLE student_contact_info
    ALTER COLUMN student_id SET NOT NULL;

ALTER TABLE subject
    ALTER COLUMN student_id SET NOT NULL;

CREATE TABLE lesson_default_param
(
    id         smallserial PRIMARY KEY,
    price      smallint NOT NULL,
    duration   decimal  NOT NULL,
    student_id smallint NOT NULL REFERENCES student (id) ON DELETE CASCADE
);

CREATE TABLE schedule_unit
(
    id          smallserial PRIMARY KEY,
    day_of_week varchar(10) NOT NULL,
    time        time[0]     NOT NULL,
    duration    decimal     NOT NULL,
    price       smallint    NOT NULL,
    student_id  smallint    REFERENCES student (id) ON DELETE CASCADE
);

CREATE TABLE lessons_period
(
    id                smallserial PRIMARY KEY,
    first_lesson_date date     NOT NULL,
    last_lesson_date  date     NOT NULL,
    student_id        smallint NOT NULL,
    FOREIGN KEY (student_id) references student (id)
);

CREATE TABLE lesson_status
(
    id        smallserial PRIMARY KEY,
    status    varchar(30) NOT NULL,
    lesson_id smallint    REFERENCES lesson (id) ON DELETE CASCADE
);

CREATE TABLE class_work
(
    id        smallserial PRIMARY KEY,
    status    varchar(30) NOT NULL,
    topic     text        NOT NULL,
    lesson_id smallint    REFERENCES lesson (id) ON DELETE CASCADE
);

CREATE TABLE home_work
(
    id        smallserial PRIMARY KEY,
    status    varchar(30) NOT NULL,
    topic     text        NOT NULL,
    lesson_id smallint    REFERENCES lesson (id) ON DELETE CASCADE
);

ALTER TABLE student ALTER COLUMN status TYPE varchar(30);

ALTER TABLE subject DROP COLUMN student_id;

CREATE TABLE students_subjects (
                                   student_id smallint,
                                   subject_id smallint,
                                   first_lesson_date date,
                                   last_lesson_date date,
                                   FOREIGN KEY (student_id) REFERENCES student (id) ON DELETE CASCADE,
                                   FOREIGN KEY (subject_id) REFERENCES subject (id) ON DELETE CASCADE
);

DROP TABLE lessons_period;

ALTER TABLE agent DROP COLUMN student_id;

CREATE TABLE students_agents (
                                 student_id smallint,
                                 agent_id smallint,
                                 FOREIGN KEY (student_id) REFERENCES student (id) ON DELETE CASCADE ,
                                 FOREIGN KEY (agent_id) REFERENCES agent (id) ON DELETE CASCADE
);

ALTER TABLE student ADD COLUMN default_lesson_price smallint;

ALTER TABLE student ADD COLUMN default_lesson_duration_minutes smallint;

DROP TABLE lesson_default_param;