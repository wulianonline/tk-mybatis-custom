
CREATE DATABASE IF NOT EXISTS `tkmybatisdb1` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin ;

USE `tkmybatisdb1`;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(13) unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `age` int(5) DEFAULT NULL,
  `email` varchar(30) COLLATE utf8mb4_bin DEFAULT NULL,
  `mobile_phone` varchar(11) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `user` */

insert  into `user`(`id`,`user_name`,`age`,`email`,`mobile_phone`) values 
(1,'zhangsan',13,'zhangsan@qq.com','13454678932'),
(2,'lisi',43,'lisi@163.com','15287236578');
