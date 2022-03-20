# hibernateOneToOne

Query
======================


CREATE DATABASE  IF NOT EXISTS `hb_instructor_tracker`;
USE `hb_instructor_tracker`;

DROP TABLE IF EXISTS instructor;

DROP TABLE IF EXISTS instructor_detail;

Create TABLE instructor_detail(
	id int(11) NOT NULL AUTO_INCREMENT,
    youtube_channel Varchar(128),
    hobby varchar(45),
    primary key(id)
);

Create TABLE instructor(
	id int(11) NOT NULL AUTO_INCREMENT,
    first_name varchar(45),
    last_name varchar(45),
    email varchar(45),
    instructor_detail_id int(11),
    primary key(id),
    foreign key(instructor_detail_id) references instructor_detail(id) 
    ON DELETE NO ACTION ON UPDATE NO ACTION
);
/*NO ACTION means if a row in the instructor_detail, the related row in instructor cannot be deleted.*/
