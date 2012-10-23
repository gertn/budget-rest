create table Budget (
	id bigint generated by default as identity (start with 1), 
	description varchar(255), 
	name varchar(40) not null, 
	state varchar(255), 
	year integer check (year<=9999 AND year>=1900), 
	primary key (id)
)