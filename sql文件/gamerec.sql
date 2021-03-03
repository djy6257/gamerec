/*
 Navicat Premium Data Transfer

 Source Server         : Mysql
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : gamerec

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 03/03/2021 16:47:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for game
-- ----------------------------
DROP TABLE IF EXISTS `game`;
CREATE TABLE `game`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `gamename` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `company` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `describe` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `score` int(0) NULL DEFAULT 10 COMMENT '评分',
  `hot` int(0) NULL DEFAULT 0 COMMENT '热度',
  `gamephoto` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `del_flag` int(0) NULL DEFAULT 0,
  `check` int(0) NULL DEFAULT 1 COMMENT '0：已过审；1：审核中',
  `creatTime` datetime(0) NULL DEFAULT NULL,
  `updateTime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of game
-- ----------------------------
INSERT INTO `game` VALUES (1, '1323', '13213312', '1313', 1313, 12313, 'XXXX', 0, 0, '2021-02-03 11:48:46', '2021-03-02 05:14:25');
INSERT INTO `game` VALUES (2, '1323', '13213312', '1313', 1313, 12313, 'XXXX', 1, 0, '2021-02-12 11:48:56', '2021-03-02 05:14:25');
INSERT INTO `game` VALUES (3, '1323', '13213312', '1313', 1313, 12313, 'XXXX', 1, 0, '2021-03-18 14:57:12', '2021-03-02 05:14:25');
INSERT INTO `game` VALUES (4, '1323', '13213312', '1313', 1313, 12313, 'XXXX', 0, 0, '2021-03-04 14:57:19', '2021-03-02 05:14:25');
INSERT INTO `game` VALUES (5, '1323', '13213312', '1313', 1313, 12313, 'XXXX', 0, 0, '2021-03-26 14:57:25', '2021-03-02 05:14:25');
INSERT INTO `game` VALUES (6, '1323', '13213312', '1313', 1313, 12313, 'XXXX', 0, 0, '2021-03-11 14:57:33', '2021-03-02 05:14:25');
INSERT INTO `game` VALUES (8, '1323', '13213312', '1313', 1313, 12313, 'XXXX', 1, 0, '2021-03-26 14:57:47', '2021-03-02 05:14:25');
INSERT INTO `game` VALUES (9, '1323', '13213312', '1313', 1313, 12313, 'XXXX', 1, 0, '2021-03-31 14:57:53', '2021-03-02 05:14:25');
INSERT INTO `game` VALUES (11, '1323', '13213312', '1313', 1313, 12313, 'XXXX', 1, 0, '2021-03-12 14:58:08', '2021-03-02 05:14:25');
INSERT INTO `game` VALUES (12, '1323', '13213312', '1313', 1313, 12313, 'XXXX', 1, 0, '2021-03-01 09:46:57', '2021-03-02 05:14:25');
INSERT INTO `game` VALUES (13, '1323', '13213312', '1313', 1313, 12313, 'XXXX', 1, 0, '2021-03-01 09:53:01', '2021-03-02 05:14:25');
INSERT INTO `game` VALUES (14, '1323', '13213312', '1313', 1313, 12313, 'XXXX', 0, 0, '2021-03-01 09:53:16', '2021-03-02 05:14:25');
INSERT INTO `game` VALUES (15, '1323', '13213312', '1313', 1313, 12313, 'XXXX', 0, 0, '2021-03-01 09:59:14', '2021-03-02 05:14:25');
INSERT INTO `game` VALUES (16, '1323', '13213312', '1313', 1313, 12313, 'XXXX', 0, 0, '2021-03-01 10:30:03', '2021-03-02 05:14:25');
INSERT INTO `game` VALUES (17, '1323', '13213312', '1313', 1313, 12313, 'XXXX', 0, 0, '2021-03-02 04:48:59', '2021-03-02 05:14:25');
INSERT INTO `game` VALUES (18, '12313', '13213', '321313', 2313, 21313, 'xxxx', 0, 1, '2021-03-02 07:12:34', '2021-03-02 07:12:34');
INSERT INTO `game` VALUES (19, '123', '3123', '31313', 123123, 21312, 'xxxx', 0, 1, '2021-03-02 07:12:43', '2021-03-02 07:12:43');
INSERT INTO `game` VALUES (20, '3121123', '213123', '3213123', 21313123, 213123, 'xxxx', 0, 1, '2021-03-02 07:12:50', '2021-03-02 07:12:50');
INSERT INTO `game` VALUES (21, '123', '333', '3213', 33213, 1312, 'xxxx', 0, 1, '2021-03-02 07:12:57', '2021-03-02 07:12:57');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `telephone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `qq` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `wechat` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `head` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `grade` int(0) NULL DEFAULT 1 COMMENT '1:普通，2：咸鱼，3：大佬，4：萌新',
  `del_flag` int(0) NULL DEFAULT 0 COMMENT '0,正常，1：待删除',
  `blocked` int(0) NULL DEFAULT 0 COMMENT '0.正常,1.封禁中',
  `updateTime` datetime(0) NULL DEFAULT NULL,
  `creatTime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (3, 'admin', '123', '32', '123', '312', '3', 'xxxx', 2, 1, 0, '2021-01-09 11:47:52', '2021-02-12 11:47:55');
INSERT INTO `user` VALUES (6, '123', '123', '32', '123', '312', '3', 'xxxx', 2, 1, 1, '2021-02-12 18:41:44', '2021-02-13 18:41:49');
INSERT INTO `user` VALUES (8, '为', '213', '32', '123', '312', '3', 'xxxx', 3, 1, 0, '2021-01-27 13:19:15', '2021-02-09 13:19:18');
INSERT INTO `user` VALUES (14, '为', '213', '32', '123', '312', '3', 'xxxx', 1, 1, 0, '2021-02-27 06:53:53', '2021-02-27 06:53:53');
INSERT INTO `user` VALUES (15, '为', '213', '32', '123', '312', '3', 'xxxx', 1, 1, 0, '2021-02-27 06:54:37', '2021-02-27 06:54:37');
INSERT INTO `user` VALUES (16, 'wrrrrrr', '213', '32', '123', '312', '3', 'xxxx', 1, 1, 0, '2021-02-27 06:56:36', '2021-02-27 06:56:36');
INSERT INTO `user` VALUES (17, '为', '213', '32', '123', '312', '3', 'xxxx', 1, 1, 0, '2021-02-27 06:57:32', '2021-02-27 06:57:32');
INSERT INTO `user` VALUES (18, '为', '213', '32', '123', '312', '3', 'xxxx', 1, 1, 0, '2021-02-27 06:58:16', '2021-02-27 06:58:16');
INSERT INTO `user` VALUES (19, '为', '213', '32', '123', '312', '3', 'xxxx', 1, 1, 1, '2021-02-27 07:04:44', '2021-02-27 07:04:44');
INSERT INTO `user` VALUES (20, '为', '213', '32', '123', '312', '3', 'xxxx', 1, 0, 1, '2021-02-27 07:08:13', '2021-02-27 07:08:13');
INSERT INTO `user` VALUES (22, 'asdsa', 'adsd', '1231', '123', '1231', '13123', 'xxxx', 1, 0, 0, '2021-03-01 03:15:01', '2021-03-01 03:15:01');
INSERT INTO `user` VALUES (23, '2132', '13123', '123213', '213123', '123123', '21312313', 'xxxx', 1, 1, 0, '2021-03-01 03:23:49', '2021-03-01 03:23:49');
INSERT INTO `user` VALUES (24, '123123', '1321', '213', '123123', '3213', '213132', 'xxxx', 1, 1, 0, '2021-03-01 03:26:09', '2021-03-01 03:26:09');
INSERT INTO `user` VALUES (25, '1231', '3123', '313', '213', '321', '313', 'xxxx', 1, 1, 0, '2021-03-01 03:43:04', '2021-03-01 03:43:04');
INSERT INTO `user` VALUES (26, '123', '3123', '123', '13123', '123213', '23113', 'xxxx', 2, 1, 0, '2021-03-01 03:43:14', '2021-03-01 03:43:14');
INSERT INTO `user` VALUES (27, '3455535', '345', '435', '54353', '53543', '53453535', 'xxxx', 1, 0, 0, '2021-03-01 03:43:35', '2021-03-01 03:43:35');
INSERT INTO `user` VALUES (28, 'admin345', '35', '534', '53453', '345345353', '45345', 'xxxx', 4, 0, 0, '2021-03-01 03:43:45', '2021-03-01 03:43:45');

SET FOREIGN_KEY_CHECKS = 1;
