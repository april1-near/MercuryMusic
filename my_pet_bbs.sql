/*
 Navicat Premium Data Transfer

 Source Server         : pet_db
 Source Server Type    : MySQL
 Source Server Version : 80032
 Source Host           : mysql.sqlpub.com:3306
 Source Schema         : my_pet_bbs

 Target Server Type    : MySQL
 Target Server Version : 80032
 File Encoding         : 65001

 Date: 16/05/2023 15:55:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for lost_and_found
-- ----------------------------
DROP TABLE IF EXISTS `lost_and_found`;
CREATE TABLE `lost_and_found`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `description` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `image` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `contact_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `contact_phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `contact_email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lost_and_found
-- ----------------------------

-- ----------------------------
-- Table structure for pet
-- ----------------------------
DROP TABLE IF EXISTS `pet`;
CREATE TABLE `pet`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `breed` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `color` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `age` int NOT NULL,
  `gender` int NOT NULL,
  `sterilized` int NOT NULL,
  `chip_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `description` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `image` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pet
-- ----------------------------
INSERT INTO `pet` VALUES (2, '秀英', '狗', 'FcnYfVXdtM', 'Light Coral', 90, 1, 0, 'mKCdwwYtpt', 'v10e0IdN7c', 'C:\\Users\\Administrator\\Pictures\\img_033863.jpg', '2011-12-30 10:15:32', '2021-11-03 04:32:15');
INSERT INTO `pet` VALUES (3, '天樂', '狗', 'HNpjIIJW5m', 'Bronze', 49, 1, 1, 'sD3gGSK0IW', 'pPTjCSdzLR', 'C:\\Users\\Administrator\\Pictures\\img_198389.png', '2012-10-16 07:13:56', '2013-05-08 06:11:57');
INSERT INTO `pet` VALUES (4, '宇宁', '狗', 'nup3dbx73H', 'Light Coral', 36, 1, 1, '8nQ4VFhL0N', 'OlWtLhhWJx', 'C:\\Users\\Administrator\\Pictures\\img_408907.jpg', '2007-12-10 17:08:43', '2004-10-27 08:50:59');
INSERT INTO `pet` VALUES (5, '天榮', '猫', 'ef1lg2dpZE', 'Lime', 30, 0, 1, 'Hd75qHLQF0', 'EFtCHQlVbE', 'C:\\Users\\Administrator\\Pictures\\img_971657.png', '2015-05-28 06:46:28', '2005-06-05 18:24:37');
INSERT INTO `pet` VALUES (6, '嘉伦', '狗', 'jFs2IlZZBv', 'Peach', 55, 1, 0, 'ebKpSTOm6c', 'YaDOZW8oBN', 'C:\\Users\\Administrator\\Pictures\\img_635810.jpg', '2015-01-06 10:36:29', '2012-04-25 05:46:56');
INSERT INTO `pet` VALUES (7, '淑怡', '狗', 'A5E0KTdpmU', 'Persimmon', 34, 1, 1, 'FV3GQnhUUB', 'blFOYXB8ic', 'C:\\Users\\Administrator\\Pictures\\img_041703.jpg', '2020-03-19 22:09:37', '2018-03-30 10:34:51');
INSERT INTO `pet` VALUES (8, '震南', '狗', 'q6PgynUu70', 'Sepia', 91, 1, 1, 'KGnS4EvgbC', 'w8A3RUkA4n', 'C:\\Users\\Administrator\\Pictures\\img_381602.png', '2013-06-21 21:02:47', '2000-05-20 21:59:01');
INSERT INTO `pet` VALUES (9, '詩涵', '猫', 'LMcM6xdWg3', 'Tropical Orange', 61, 0, 0, 'kxWc7ELZGn', 'Lnb8OLfSEt', 'C:\\Users\\Administrator\\Pictures\\img_792711.jpg', '2020-04-18 01:42:10', '2007-03-04 15:08:34');
INSERT INTO `pet` VALUES (10, '致远', '狗', 'RR5JzeTnZr', 'Orange', 32, 1, 0, 'wH3iacaBbb', 'Wp0d3U3zzF', 'C:\\Users\\Administrator\\Pictures\\img_222313.png', '2008-03-09 15:21:43', '2015-08-24 07:56:32');
INSERT INTO `pet` VALUES (11, '思妤', '狗', 'yFUFT8n16w', 'Yellow', 23, 0, 0, 'd6PxjAEvPf', 'GTSTYOO1MF', 'C:\\Users\\Administrator\\Pictures\\img_095327.png', '2008-08-19 02:04:34', '2016-04-15 18:20:15');
INSERT INTO `pet` VALUES (12, '璐', '狗', '74n9QlNFw0', 'Iron', 37, 0, 0, '3AiBo7XSEY', 'UePrOidjx3', 'C:\\Users\\Administrator\\Pictures\\img_670705.png', '2020-08-27 21:41:13', '2017-03-10 03:17:28');
INSERT INTO `pet` VALUES (13, '浩然', '狗', 'w633qiish9', 'Brown', 59, 0, 0, 'V6N3rOVaDE', 'lMQxSGVLLq', 'C:\\Users\\Administrator\\Pictures\\img_182133.png', '2005-06-07 07:46:47', '2023-01-11 21:48:30');
INSERT INTO `pet` VALUES (14, '嘉欣', '猫', '6luI5TjC2A', 'Red', 39, 1, 1, 'YNmg6ifmaj', 'hCwpkTwVL6', 'C:\\Users\\Administrator\\Pictures\\img_921093.png', '2015-12-07 08:37:15', '2015-05-26 16:45:57');
INSERT INTO `pet` VALUES (15, '富城', '狗', 'TIJo1KJydj', 'Orange Red', 77, 1, 1, 'WtItm944OV', '66BUnyL2ME', 'C:\\Users\\Administrator\\Pictures\\img_202460.jpg', '2016-06-17 21:22:04', '2012-12-16 19:20:01');
INSERT INTO `pet` VALUES (16, '霆鋒', '猫', 'BPZoXG7VrP', 'Rosy Brown', 65, 0, 1, 'IGFIuUsEoz', '2bZkHfR2mI', 'C:\\Users\\Administrator\\Pictures\\img_338360.jpg', '2011-07-07 16:17:55', '2020-07-26 06:34:13');
INSERT INTO `pet` VALUES (17, '麗欣', '猫', 'T0rcJmRB0Y', 'Maroon', 66, 1, 1, 'dDMpCeZ5fA', 'ZqukQfZjA0', 'C:\\Users\\Administrator\\Pictures\\img_287600.jpg', '2008-06-03 18:43:01', '2022-09-19 17:19:36');
INSERT INTO `pet` VALUES (18, '杰宏', '狗', 'vYorIuhPTn', 'Vermilion', 37, 0, 1, '33xd2IORXo', 'fb76pKNz93', 'C:\\Users\\Administrator\\Pictures\\img_401405.png', '2022-03-16 16:45:34', '2012-02-22 07:08:12');
INSERT INTO `pet` VALUES (19, '榮發', '狗', 'RQ45h4CylA', 'Dark Red', 91, 1, 1, 'cXYttQhle6', 'uXWW22zlTR', 'C:\\Users\\Administrator\\Pictures\\img_265322.jpg', '2010-11-08 12:50:15', '2006-11-26 14:05:45');
INSERT INTO `pet` VALUES (20, '岚', '狗', '7dEM6BEgxd', 'Apricot', 31, 1, 1, '0SaWTcnKTU', 'dm6WHblnIp', 'C:\\Users\\Administrator\\Pictures\\img_923557.jpg', '2019-10-29 05:49:53', '2005-06-16 22:21:51');
INSERT INTO `pet` VALUES (21, '汤姆', '狗', '柴犬', '红', 2, 1, 1, '1', NULL, NULL, NULL, NULL);
INSERT INTO `pet` VALUES (22, '汤姆', '狗', '柴犬', '红', 2, 1, 1, '1', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for pet_rescue
-- ----------------------------
DROP TABLE IF EXISTS `pet_rescue`;
CREATE TABLE `pet_rescue`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `description` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `image` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `contact_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `contact_phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `contact_email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pet_rescue
-- ----------------------------
INSERT INTO `pet_rescue` VALUES (1, 'Kiwi', 'ELSvecJBGf', 'C:\\Users\\Administrator\\Pictures\\img_153987.png', '江嘉伦', '196-0287-7074', 'jialun3@outlook.com', '2015-05-31 02:29:45', '2006-01-13 01:49:47');
INSERT INTO `pet_rescue` VALUES (2, 'Mazgo premium', 'j3RYbvtYuj', 'C:\\Users\\Administrator\\Pictures\\img_345418.png', '姜秀英', '769-347-1073', 'jxiuyi@outlook.com', '2016-04-27 00:28:24', '2015-02-22 16:43:21');
INSERT INTO `pet_rescue` VALUES (3, 'mherry', 'N3QtguolPA', 'C:\\Users\\Administrator\\Pictures\\img_516223.jpg', '熊致远', '173-1965-8748', 'xiong7@yahoo.com', '2019-06-02 23:04:52', '2000-09-21 21:41:25');
INSERT INTO `pet_rescue` VALUES (4, 'Kiwi', 'Oh3r4CZHrY', 'C:\\Users\\Administrator\\Pictures\\img_691325.png', '赵云熙', '162-4463-1853', 'yunxi10@yahoo.com', '2006-06-18 10:01:42', '2011-06-12 08:30:00');
INSERT INTO `pet_rescue` VALUES (5, 'Grape core', 'Q2u7bfBkIn', 'C:\\Users\\Administrator\\Pictures\\img_533864.jpg', '佘國權', '10-093-7885', 'sheh802@hotmail.com', '2017-10-07 17:28:57', '2015-08-10 13:37:18');
INSERT INTO `pet_rescue` VALUES (6, 'Rambrtan', 'mtNzVsrtZg', 'C:\\Users\\Administrator\\Pictures\\img_351834.jpg', '蕭天樂', '146-2334-6684', 'siuti@yahoo.com', '2013-02-21 10:39:40', '2019-08-06 19:44:40');
INSERT INTO `pet_rescue` VALUES (7, 'Raspberry pro', 'XKlBFZnfSC', 'C:\\Users\\Administrator\\Pictures\\img_081791.png', '顾杰宏', '10-251-9459', 'guj4@icloud.com', '2009-10-31 10:15:22', '2021-03-04 22:50:31');
INSERT INTO `pet_rescue` VALUES (8, 'rango', 'FuFEOyiM0Q', 'C:\\Users\\Administrator\\Pictures\\img_570678.png', '葉天榮', '170-1825-3155', 'yitinwing@mail.com', '2013-10-08 19:29:13', '2015-06-18 11:14:53');
INSERT INTO `pet_rescue` VALUES (9, 'Rascberry mini', 'nkjVe9psYq', 'C:\\Users\\Administrator\\Pictures\\img_863449.png', '崔致远', '169-3722-3532', 'zc3@gmail.com', '2007-07-30 20:16:17', '2011-08-12 00:05:58');
INSERT INTO `pet_rescue` VALUES (10, 'tango', '512z2xBENa', 'C:\\Users\\Administrator\\Pictures\\img_698773.jpg', '邵子韬', '186-6261-9379', 'szi71@hotmail.com', '2008-11-04 04:41:33', '2001-06-24 19:20:04');
INSERT INTO `pet_rescue` VALUES (11, 'Raspberry', 'vMxtnbtStO', 'C:\\Users\\Administrator\\Pictures\\img_652430.png', '黎璐', '755-821-0918', 'luli4@gmail.com', '2019-08-28 16:31:48', '2011-05-25 17:06:45');
INSERT INTO `pet_rescue` VALUES (12, 'Rambutfn mini', 'vEMzvTU4hz', 'C:\\Users\\Administrator\\Pictures\\img_418470.jpg', '莫嘉欣', '185-1642-7514', 'kymok@gmail.com', '2001-12-12 13:57:31', '2006-03-11 00:50:47');
INSERT INTO `pet_rescue` VALUES (13, 'Strawberry', 'inhFMcCCrr', 'C:\\Users\\Administrator\\Pictures\\img_269467.png', '黃曉彤', '136-8857-9893', 'hiutung9@gmail.com', '2007-02-05 03:11:01', '2002-06-28 03:35:41');
INSERT INTO `pet_rescue` VALUES (14, 'ambi-cango', 'TlTTXtOi2e', 'C:\\Users\\Administrator\\Pictures\\img_743197.png', '卢秀英', '165-8454-7570', 'xiuying89@mail.com', '2018-06-23 02:10:09', '2015-04-16 14:07:18');
INSERT INTO `pet_rescue` VALUES (15, 'Apple', '61qLqUdV6G', 'C:\\Users\\Administrator\\Pictures\\img_661383.png', '夏子异', '28-3295-7656', 'ziyi2@gmail.com', '2014-08-13 11:14:08', '2022-03-27 06:17:27');
INSERT INTO `pet_rescue` VALUES (16, 'ihpple', 'kZPx13EO39', 'C:\\Users\\Administrator\\Pictures\\img_305103.jpg', '古梓軒', '28-187-1956', 'ku83@gmail.com', '2007-06-25 17:50:56', '2014-01-28 04:20:24');
INSERT INTO `pet_rescue` VALUES (17, 'Strawberry', '86Mkl8rew1', 'C:\\Users\\Administrator\\Pictures\\img_474074.png', '藍安琪', '197-2688-0511', 'oklam@outlook.com', '2001-07-11 16:04:09', '2004-08-06 14:59:44');
INSERT INTO `pet_rescue` VALUES (18, 'orape pro', 'cY7I5SWMoz', 'C:\\Users\\Administrator\\Pictures\\img_308554.jpg', '梅詩君', '195-7246-8129', 'skmui@icloud.com', '2009-01-01 08:19:02', '2005-10-19 22:05:10');
INSERT INTO `pet_rescue` VALUES (19, 'hherry', 'uX7wwcapj1', 'C:\\Users\\Administrator\\Pictures\\img_325610.png', '成慧嫻', '182-0064-2089', 'shing10@gmail.com', '2002-10-20 21:15:06', '2009-01-21 01:54:59');
INSERT INTO `pet_rescue` VALUES (20, 'qherry air', '5p0X9boHn4', 'C:\\Users\\Administrator\\Pictures\\img_895116.jpg', '田晓明', '135-6594-7071', 'xiaoming8@outlook.com', '2019-09-17 08:34:01', '2020-04-09 13:10:48');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `gender` int NULL DEFAULT NULL,
  `avatar` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '3434545', '45565677676', 'erere@qq.com', '23435454', NULL, NULL, 'dfdsafawe', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
