/*
 Navicat Premium Data Transfer

 Source Server         : 118.190.200.190
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : 118.190.200.190:3306
 Source Schema         : coins

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 24/10/2018 12:23:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for base_coins
-- ----------------------------
DROP TABLE IF EXISTS `base_coins`;
CREATE TABLE `base_coins`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `website` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网站',
  `enable` int(8) NULL DEFAULT NULL COMMENT '是否启用（1：启用，0关闭，2：永久关闭）',
  `update_time` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name_website`(`name`, `website`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 163 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for kline_10m
-- ----------------------------
DROP TABLE IF EXISTS `kline_10m`;
CREATE TABLE `kline_10m`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `website` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网站，比如币安,火币等',
  `type` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交易类型,比如：usdt_eth',
  `name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'name',
  `time_long` bigint(16) NULL DEFAULT NULL COMMENT '时间',
  `volume` double(32, 16) NULL DEFAULT NULL COMMENT '量',
  `close` double(32, 16) NULL DEFAULT NULL COMMENT '闭盘价',
  `open` double(32, 16) NULL DEFAULT NULL COMMENT '开盘价',
  `high` double(32, 16) NULL DEFAULT NULL COMMENT '最高价',
  `low` double(32, 16) NULL DEFAULT NULL COMMENT '最低阶',
  `time_str` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '时间 非时间戳',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `special`(`website`, `type`, `name`, `time_long`) USING BTREE,
  INDEX `website`(`website`) USING BTREE,
  INDEX `type`(`type`) USING BTREE,
  INDEX `name`(`name`) USING BTREE,
  INDEX `time_long`(`time_long`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for kline_12h
-- ----------------------------
DROP TABLE IF EXISTS `kline_12h`;
CREATE TABLE `kline_12h`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `website` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网站，比如币安,火币等',
  `type` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交易类型,比如：usdt_eth',
  `name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'name',
  `time_long` bigint(16) NULL DEFAULT NULL COMMENT '时间',
  `volume` double(32, 16) NULL DEFAULT NULL COMMENT '量',
  `close` double(32, 16) NULL DEFAULT NULL COMMENT '闭盘价',
  `open` double(32, 16) NULL DEFAULT NULL COMMENT '开盘价',
  `high` double(32, 16) NULL DEFAULT NULL COMMENT '最高价',
  `low` double(32, 16) NULL DEFAULT NULL COMMENT '最低阶',
  `time_str` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '时间 非时间戳',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `special`(`website`, `type`, `name`, `time_long`) USING BTREE,
  INDEX `website`(`website`) USING BTREE,
  INDEX `type`(`type`) USING BTREE,
  INDEX `name`(`name`) USING BTREE,
  INDEX `time_long`(`time_long`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for kline_1h
-- ----------------------------
DROP TABLE IF EXISTS `kline_1h`;
CREATE TABLE `kline_1h`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `website` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网站，比如币安,火币等',
  `type` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交易类型,比如：usdt_eth',
  `name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'name',
  `time_long` bigint(16) NULL DEFAULT NULL COMMENT '时间',
  `volume` double(32, 16) NULL DEFAULT NULL COMMENT '量',
  `close` double(32, 16) NULL DEFAULT NULL COMMENT '闭盘价',
  `open` double(32, 16) NULL DEFAULT NULL COMMENT '开盘价',
  `high` double(32, 16) NULL DEFAULT NULL COMMENT '最高价',
  `low` double(32, 16) NULL DEFAULT NULL COMMENT '最低阶',
  `time_str` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '时间 非时间戳',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `special`(`website`, `type`, `name`, `time_long`) USING BTREE,
  INDEX `website`(`website`) USING BTREE,
  INDEX `type`(`type`) USING BTREE,
  INDEX `name`(`name`) USING BTREE,
  INDEX `time_long`(`time_long`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for kline_1m
-- ----------------------------
DROP TABLE IF EXISTS `kline_1m`;
CREATE TABLE `kline_1m`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `website` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网站，比如币安,火币等',
  `type` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交易类型,比如：usdt_eth',
  `name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'name',
  `time_long` bigint(32) NULL DEFAULT NULL COMMENT '时间',
  `volume` double(32, 16) NULL DEFAULT NULL COMMENT '量',
  `close` double(32, 16) NULL DEFAULT NULL COMMENT '闭盘价',
  `open` double(32, 16) NULL DEFAULT NULL COMMENT '开盘价',
  `high` double(32, 16) NULL DEFAULT NULL COMMENT '最高价',
  `low` double(32, 16) NULL DEFAULT NULL COMMENT '最低阶',
  `time_str` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '时间 非时间戳',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `special`(`website`, `type`, `name`, `time_long`) USING BTREE,
  INDEX `website`(`website`) USING BTREE,
  INDEX `type`(`type`) USING BTREE,
  INDEX `name`(`name`) USING BTREE,
  INDEX `time_long`(`time_long`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for kline_24h
-- ----------------------------
DROP TABLE IF EXISTS `kline_24h`;
CREATE TABLE `kline_24h`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `website` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网站，比如币安,火币等',
  `type` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交易类型,比如：usdt_eth',
  `name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'name',
  `time_long` bigint(16) NULL DEFAULT NULL COMMENT '时间',
  `volume` double(32, 16) NULL DEFAULT NULL COMMENT '量',
  `close` double(32, 16) NULL DEFAULT NULL COMMENT '闭盘价',
  `open` double(32, 16) NULL DEFAULT NULL COMMENT '开盘价',
  `high` double(32, 16) NULL DEFAULT NULL COMMENT '最高价',
  `low` double(32, 16) NULL DEFAULT NULL COMMENT '最低阶',
  `time_str` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '时间 非时间戳',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `special`(`website`, `type`, `name`, `time_long`) USING BTREE,
  INDEX `website`(`website`) USING BTREE,
  INDEX `type`(`type`) USING BTREE,
  INDEX `name`(`name`) USING BTREE,
  INDEX `time_long`(`time_long`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for kline_2h
-- ----------------------------
DROP TABLE IF EXISTS `kline_2h`;
CREATE TABLE `kline_2h`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `website` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网站，比如币安,火币等',
  `type` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交易类型,比如：usdt_eth',
  `name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'name',
  `time_long` bigint(16) NULL DEFAULT NULL COMMENT '时间',
  `volume` double(32, 16) NULL DEFAULT NULL COMMENT '量',
  `close` double(32, 16) NULL DEFAULT NULL COMMENT '闭盘价',
  `open` double(32, 16) NULL DEFAULT NULL COMMENT '开盘价',
  `high` double(32, 16) NULL DEFAULT NULL COMMENT '最高价',
  `low` double(32, 16) NULL DEFAULT NULL COMMENT '最低阶',
  `time_str` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '时间 非时间戳',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `special`(`website`, `type`, `name`, `time_long`) USING BTREE,
  INDEX `website`(`website`) USING BTREE,
  INDEX `type`(`type`) USING BTREE,
  INDEX `name`(`name`) USING BTREE,
  INDEX `time_long`(`time_long`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for kline_30m
-- ----------------------------
DROP TABLE IF EXISTS `kline_30m`;
CREATE TABLE `kline_30m`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `website` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网站，比如币安,火币等',
  `type` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交易类型,比如：usdt_eth',
  `name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'name',
  `time_long` bigint(16) NULL DEFAULT NULL COMMENT '时间',
  `volume` double(32, 16) NULL DEFAULT NULL COMMENT '量',
  `close` double(32, 16) NULL DEFAULT NULL COMMENT '闭盘价',
  `open` double(32, 16) NULL DEFAULT NULL COMMENT '开盘价',
  `high` double(32, 16) NULL DEFAULT NULL COMMENT '最高价',
  `low` double(32, 16) NULL DEFAULT NULL COMMENT '最低阶',
  `time_str` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '时间 非时间戳',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `special`(`website`, `type`, `name`, `time_long`) USING BTREE,
  INDEX `website`(`website`) USING BTREE,
  INDEX `type`(`type`) USING BTREE,
  INDEX `name`(`name`) USING BTREE,
  INDEX `time_long`(`time_long`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for kline_4h
-- ----------------------------
DROP TABLE IF EXISTS `kline_4h`;
CREATE TABLE `kline_4h`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `website` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网站，比如币安,火币等',
  `type` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交易类型,比如：usdt_eth',
  `name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'name',
  `time_long` bigint(16) NULL DEFAULT NULL COMMENT '时间',
  `volume` double(32, 16) NULL DEFAULT NULL COMMENT '量',
  `close` double(32, 16) NULL DEFAULT NULL COMMENT '闭盘价',
  `open` double(32, 16) NULL DEFAULT NULL COMMENT '开盘价',
  `high` double(32, 16) NULL DEFAULT NULL COMMENT '最高价',
  `low` double(32, 16) NULL DEFAULT NULL COMMENT '最低阶',
  `time_str` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '时间 非时间戳',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `special`(`website`, `type`, `name`, `time_long`) USING BTREE,
  INDEX `website`(`website`) USING BTREE,
  INDEX `type`(`type`) USING BTREE,
  INDEX `name`(`name`) USING BTREE,
  INDEX `time_long`(`time_long`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for kline_5m
-- ----------------------------
DROP TABLE IF EXISTS `kline_5m`;
CREATE TABLE `kline_5m`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `website` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网站，比如币安,火币等',
  `type` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交易类型,比如：usdt_eth',
  `name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'name',
  `time_long` bigint(16) NULL DEFAULT NULL COMMENT '时间',
  `volume` double(32, 16) NULL DEFAULT NULL COMMENT '量',
  `close` double(32, 16) NULL DEFAULT NULL COMMENT '闭盘价',
  `open` double(32, 16) NULL DEFAULT NULL COMMENT '开盘价',
  `high` double(32, 16) NULL DEFAULT NULL COMMENT '最高价',
  `low` double(32, 16) NULL DEFAULT NULL COMMENT '最低阶',
  `time_str` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '时间 非时间戳',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `special`(`website`, `type`, `name`, `time_long`) USING BTREE,
  INDEX `website`(`website`) USING BTREE,
  INDEX `type`(`type`) USING BTREE,
  INDEX `name`(`name`) USING BTREE,
  INDEX `time_long`(`time_long`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for warning
-- ----------------------------
DROP TABLE IF EXISTS `warning`;
CREATE TABLE `warning`  (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `website` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `volume` int(8) NULL DEFAULT NULL,
  `price` int(8) NULL DEFAULT NULL,
  `count` int(16) NULL DEFAULT NULL,
  `isEmail` int(2) NOT NULL COMMENT '0:未发送，1：已发送',
  `marks` tinytext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `timelong` bigint(32) NULL DEFAULT NULL,
  `time_str` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 151 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
