DROP TABLE `door_key`;
DROP TABLE `map`;
create table `door_key` (`id` bigint not null auto_increment, `keycard` bit not null, `name` varchar(255) not null, map_id bigint, primary key (id));
create table `map` (`id` bigint not null auto_increment, `name` varchar(255) not null, primary key (id));
alter table `door_key` add constraint FKi9eh0jayv7337nenm6ri0xqie foreign key (map_id) references map (id);