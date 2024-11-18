/*
 Navicat Premium Data Transfer

 Source Server         : Test1
 Source Server Type    : MySQL
 Source Server Version : 90100
 Source Host           : localhost:3306
 Source Schema         : userdata

 Target Server Type    : MySQL
 Target Server Version : 90100
 File Encoding         : 65001

 Date: 04/11/2024 16:05:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for students
-- ----------------------------
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `age` int NOT NULL,
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of students
-- ----------------------------
INSERT INTO `students` VALUES (3, '张伟', 20, 'zhangwei@example.com');
INSERT INTO `students` VALUES (4, '李娜', 22, 'lina@example.com');
INSERT INTO `students` VALUES (5, '王磊', 21, 'wanglei@example.com');
INSERT INTO `students` VALUES (6, '赵敏', 19, 'zhaomin@example.com');
INSERT INTO `students` VALUES (7, '刘洋', 23, 'liuyang@example.com');
INSERT INTO `students` VALUES (8, '陈刚', 24, 'chengang@example.com');
INSERT INTO `students` VALUES (9, '周杰', 22, 'zhoujie@example.com');
INSERT INTO `students` VALUES (10, '徐静', 20, 'xujing@example.com');
INSERT INTO `students` VALUES (11, '孙悦', 21, 'sunyue@example.com');
INSERT INTO `students` VALUES (12, '马超', 25, 'machao@example.com');
INSERT INTO `students` VALUES (13, '李易峰', 21, 'liyifeng@example.com');
INSERT INTO `students` VALUES (14, '杨紫', 22, 'yangzi@example.com');
INSERT INTO `students` VALUES (15, '王俊凯', 20, 'wangjunkai@example.com');
INSERT INTO `students` VALUES (16, '张艺兴', 23, 'zhangyixing@example.com');
INSERT INTO `students` VALUES (17, '迪丽热巴', 24, 'dilireba@example.com');
INSERT INTO `students` VALUES (18, '蔡徐坤', 22, 'caixukun@example.com');
INSERT INTO `students` VALUES (19, '朱一龙', 21, 'zhuyilong@example.com');
INSERT INTO `students` VALUES (20, '陈飞宇', 20, 'chenfeiyu@example.com');
INSERT INTO `students` VALUES (21, '王源', 19, 'wangyuan@example.com');
INSERT INTO `students` VALUES (22, '刘涛', 23, 'liutao@example.com');
INSERT INTO `students` VALUES (23, '张伟', 20, 'zhangwei@example.com');
INSERT INTO `students` VALUES (24, '李娜', 22, 'lina@example.com');
INSERT INTO `students` VALUES (25, '赵云', 23, 'zhaoyun@example.com');
INSERT INTO `students` VALUES (26, '陈晨', 24, 'chenchen@example.com');
INSERT INTO `students` VALUES (27, '黄晓明', 21, 'huangxiaoming@example.com');
INSERT INTO `students` VALUES (28, '范冰冰', 25, 'fanbingbing@example.com');
INSERT INTO `students` VALUES (29, '张涵予', 22, 'zhanghanyu@example.com');
INSERT INTO `students` VALUES (30, '林更新', 20, 'lingengxin@example.com');
INSERT INTO `students` VALUES (31, '彭于晏', 23, 'pengyuyan@example.com');
INSERT INTO `students` VALUES (32, '李宇春', 24, 'liyuchun@example.com');
INSERT INTO `students` VALUES (33, '周迅', 22, 'zhouxun@example.com');
INSERT INTO `students` VALUES (34, '吴亦凡', 21, 'wuyifan@example.com');
INSERT INTO `students` VALUES (35, '杨幂', 20, 'yangmi@example.com');
INSERT INTO `students` VALUES (36, '宋慧乔', 19, 'songhuiqiao@example.com');
INSERT INTO `students` VALUES (37, '刘诗诗', 23, 'liushishi@example.com');
INSERT INTO `students` VALUES (38, '王凯', 24, 'wangkai@example.com');
INSERT INTO `students` VALUES (39, '郭麒麟', 22, 'guoqilin@example.com');
INSERT INTO `students` VALUES (40, '黄渤', 21, 'huangbo@example.com');


-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (16, '2@2', '$2a$10$J96jeRcQNkbJGyHLrqE1seV.D8Wmt5TXiAQRblDuotyUqJM.MgdXO', '2');

SET FOREIGN_KEY_CHECKS = 1;
