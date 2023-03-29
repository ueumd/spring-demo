/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80032
 Source Host           : localhost:3306
 Source Schema         : study_project

 Target Server Type    : MySQL
 Target Server Version : 80032
 File Encoding         : 65001

 Date: 29/03/2023 19:26:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ai_role
-- ----------------------------
DROP TABLE IF EXISTS `ai_role`;
CREATE TABLE `ai_role`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `role` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色定位',
  `scene` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '使用场景',
  `prompt` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '提示',
  `introduce` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '介绍',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `head_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '头像',
  `role_type` tinyint(0) NOT NULL COMMENT '角色类型1：自由练习 2情景模拟',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'AI角色配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ai_role
-- ----------------------------
INSERT INTO `ai_role` VALUES (1, 'Sara', 'travel', '你可以在这和Sara聊一聊关于“旅行”的话题，比如你去过哪些地方', 'I am an English beginner and you want to practice speaking English with me. \nYou can start with:\"Hi,I am nice to meeting you.\"+a simple question related to \"travel\". \nIf I go off-topic, you have to bring the topic back to \"travel\".\n\ntravel可以替换为sports,food,music,movies,TV shows,books,gaming,business,careers,hobbies,education,politics,medicine', '模拟在一个国家或城市旅游时与当地人交流的情景，练习询问路当地人交流的情景，练习询问路', b'0', '2023-03-24 17:32:46', 'https://file.talkme.ai/oss/static/header/head5.png', 2);
INSERT INTO `ai_role` VALUES (2, 'Karl', 'sports', '你可以在这和Karl聊一聊关于“运动”的话题，比如你喜欢的运动', 'I am an English beginner and you want to practice speaking English with me. \nYou can start with:\"Hi,I am nice to meeting you.\"+a simple question related to \"sports\". \nIf I go off-topic, you have to bring the topic back to \"sports\".\n', '模拟聚会、晚宴等社交场合，练习自我介绍、寒暄、问候等相关对话。', b'0', '2023-03-24 17:47:32', 'https://file.talkme.ai/oss/static/header/head1.png', 2);
INSERT INTO `ai_role` VALUES (3, 'Ross', 'food', '你可以在这和Karl聊一聊关于“美食”的话题，比如你喜欢的食物', 'I am an English beginner and you want to practice speaking English with me. \nYou can start with:\"Hi,I am nice to meeting you.\"+a simple question related to \"food\". \nIf I go off-topic, you have to bring the topic back to \"food\".\n', '模拟课堂场景，练习提问、回答、讲解等相关对话。', b'0', '2023-03-24 17:50:47', 'https://file.talkme.ai/oss/static/header/head6.png', 2);
INSERT INTO `ai_role` VALUES (4, 'Maria', 'movies', '你可以在这和Maria聊一聊关于“电影”的话题，比如你喜欢的电影明星', 'I am an English beginner and you want to practice speaking English with me. \nYou can start with:\"Hi,I am nice to meeting you.\"+a simple question related to \"movies\". \nIf I go off-topic, you have to bring the topic back to \"movies\".\n', '模拟电影场景，你可以在这和Maria聊一聊关于“电影”的话题，比如你喜欢的电影明星', b'0', '2023-03-24 17:53:24', 'https://file.talkme.ai/oss/static/header/head4.png', 2);
INSERT INTO `ai_role` VALUES (5, 'John', 'careers', '你可以在这和John聊一聊关于“职场”的话题，比如你的职业规划', 'I am an English beginner and you want to practice speaking English with me. \nYou can start with:\"Hi,I am nice to meeting you.\"+a simple question related to \"careers\". \nIf I go off-topic, you have to bring the topic back to \"careers\".\n', '模拟职场场景，你可以在这和John聊一聊关于“职场”的话题，比如你的职业规划', b'0', '2023-03-24 17:57:44', 'https://file.talkme.ai/oss/static/header/head3.png', 2);
INSERT INTO `ai_role` VALUES (6, 'Ava', 'books', '你可以在这和Ava聊一聊关于“读书”的话题，比如你喜欢的小说', 'I am an English beginner and you want to practice speaking English with me. \nYou can start with:\"Hi,I am nice to meeting you.\"+a simple question related to \"books\". \nIf I go off-topic, you have to bring the topic back to \"books\".\n', '模拟读书场景，你可以在这和Ava聊一聊关于“读书”的话题，比如你喜欢的小说', b'0', '2023-03-24 17:58:50', 'https://file.talkme.ai/oss/static/header/head2.png', 2);

-- ----------------------------
-- Table structure for ai_topic
-- ----------------------------
DROP TABLE IF EXISTS `ai_topic`;
CREATE TABLE `ai_topic`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '图标url',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '话题内容',
  `level` tinyint(0) NOT NULL COMMENT '1初级 2中级 3中级以上',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ai_topic
-- ----------------------------
INSERT INTO `ai_topic` VALUES (2, 'https://file.talkme.ai/oss/topic/Travel.png', 'Travel', 1, '2023-03-28 16:37:40');
INSERT INTO `ai_topic` VALUES (3, 'https://file.talkme.ai/oss/topic/Philosophy.png', 'Philosophy', 1, '2023-03-28 16:37:40');
INSERT INTO `ai_topic` VALUES (4, 'https://file.talkme.ai/oss/topic/Education.png', 'Education', 1, '2023-03-28 16:37:40');
INSERT INTO `ai_topic` VALUES (5, 'https://file.talkme.ai/oss/topic/Space.png', 'Space', 1, '2023-03-28 16:37:40');
INSERT INTO `ai_topic` VALUES (6, 'https://file.talkme.ai/oss/topic/Food.png', 'Food', 1, '2023-03-28 16:37:40');
INSERT INTO `ai_topic` VALUES (7, 'https://file.talkme.ai/oss/topic/Fitness.png', 'Fitness', 1, '2023-03-28 16:37:40');
INSERT INTO `ai_topic` VALUES (8, 'https://file.talkme.ai/oss/topic/Gaming.png', 'Gaming', 1, '2023-03-28 16:37:40');
INSERT INTO `ai_topic` VALUES (9, 'https://file.talkme.ai/oss/topic/Social Media.png', 'Social Media', 1, '2023-03-28 16:37:40');
INSERT INTO `ai_topic` VALUES (10, 'https://file.talkme.ai/oss/topic/Music.png', 'Music', 1, '2023-03-28 16:37:40');
INSERT INTO `ai_topic` VALUES (11, 'https://file.talkme.ai/oss/topic/Sports.png', 'Sports', 1, '2023-03-28 16:37:40');
INSERT INTO `ai_topic` VALUES (12, 'https://file.talkme.ai/oss/topic/Technology.png', 'Technology', 1, '2023-03-28 16:37:40');
INSERT INTO `ai_topic` VALUES (13, 'https://file.talkme.ai/oss/topic/Spirituality.png', 'Spirituality', 1, '2023-03-28 16:37:40');
INSERT INTO `ai_topic` VALUES (14, 'https://file.talkme.ai/oss/topic/Nature.png', 'Nature', 1, '2023-03-28 16:37:40');
INSERT INTO `ai_topic` VALUES (15, 'https://file.talkme.ai/oss/topic/Relationships.png', 'Relationships', 1, '2023-03-28 16:37:40');
INSERT INTO `ai_topic` VALUES (16, 'https://file.talkme.ai/oss/topic/News.png', 'News', 1, '2023-03-28 16:37:40');
INSERT INTO `ai_topic` VALUES (17, 'https://file.talkme.ai/oss/topic/Money.png', 'Money', 1, '2023-03-28 16:37:40');
INSERT INTO `ai_topic` VALUES (18, 'https://file.talkme.ai/oss/topic/Politics.png', 'Politics', 1, '2023-03-28 16:37:40');
INSERT INTO `ai_topic` VALUES (19, 'https://file.talkme.ai/oss/topic/Medicine.png', 'Medicine', 1, '2023-03-28 16:37:40');
INSERT INTO `ai_topic` VALUES (20, 'https://file.talkme.ai/oss/topic/History.png', 'History', 1, '2023-03-28 16:37:40');
INSERT INTO `ai_topic` VALUES (21, 'https://file.talkme.ai/oss/topic/Family.png', 'Family', 1, '2023-03-28 16:37:40');
INSERT INTO `ai_topic` VALUES (22, 'https://file.talkme.ai/oss/topic/Psychology.png', 'Psychology', 1, '2023-03-28 16:37:40');
INSERT INTO `ai_topic` VALUES (23, 'https://file.talkme.ai/oss/topic/Hobbies.png', 'Hobbies', 1, '2023-03-28 16:37:40');
INSERT INTO `ai_topic` VALUES (24, 'https://file.talkme.ai/oss/topic/Movies.png', 'Movies', 1, '2023-03-28 16:37:40');
INSERT INTO `ai_topic` VALUES (25, 'https://file.talkme.ai/oss/topic/Mental Health.png', 'Mental Health', 1, '2023-03-28 16:37:40');
INSERT INTO `ai_topic` VALUES (26, 'https://file.talkme.ai/oss/topic/Science.png', 'Science', 1, '2023-03-28 16:37:40');
INSERT INTO `ai_topic` VALUES (27, 'https://file.talkme.ai/oss/topic/Books.png', 'Books', 1, '2023-03-28 16:37:40');
INSERT INTO `ai_topic` VALUES (28, 'https://file.talkme.ai/oss/topic/Art.png', 'Art', 1, '2023-03-28 16:37:40');
INSERT INTO `ai_topic` VALUES (29, 'https://file.talkme.ai/oss/topic/Fashion.png', 'Fashion', 1, '2023-03-28 16:37:40');
INSERT INTO `ai_topic` VALUES (30, 'https://file.talkme.ai/oss/topic/TV Shows.png', 'TV Shows', 1, '2023-03-28 16:37:40');
INSERT INTO `ai_topic` VALUES (31, 'https://file.talkme.ai/oss/topic/Entertainment.png', 'Entertainment', 1, '2023-03-28 16:37:40');
INSERT INTO `ai_topic` VALUES (32, 'https://file.talkme.ai/oss/topic/Business.png', 'Business', 1, '2023-03-28 16:37:40');
INSERT INTO `ai_topic` VALUES (33, 'https://file.talkme.ai/oss/topic/Careers.png', 'Careers', 1, '2023-03-28 16:37:40');
INSERT INTO `ai_topic` VALUES (34, 'https://file.talkme.ai/oss/topic/DIY.png', 'DIY', 1, '2023-03-28 16:37:40');

-- ----------------------------
-- Table structure for t_common_config
-- ----------------------------
DROP TABLE IF EXISTS `t_common_config`;
CREATE TABLE `t_common_config`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `config_key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '键',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `config_value` json NULL COMMENT '值',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '活动创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unq_key`(`config_key`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '键值对 存储数据结构' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_common_config
-- ----------------------------
INSERT INTO `t_common_config` VALUES (1, 'start_chat', '初始化引导聊天', '{\"Wow!\": [{\"role\": \"AI\", \"time\": \"\", \"type\": \"text\", \"content\": \"I’m glad you like it.\", \"audioUrl\": \"\", \"nickname\": \"Jake\", \"replyLoad\": false, \"timestamp\": \"\", \"translate\": \"\", \"translateLoad\": false, \"translateShow\": false}, {\"role\": \"AI\", \"time\": \"\", \"type\": \"text\", \"content\": \"tip2：If you’re unsure how to answer in English, simply reply in Chinese!\", \"audioUrl\": \"\", \"nickname\": \"Jake\", \"replyLoad\": false, \"timestamp\": \"\", \"translate\": \"\", \"translateLoad\": false, \"translateShow\": false}], \"Sure!\": [{\"role\": \"AI\", \"time\": \"\", \"type\": \"text\", \"content\": \"tip1：Tapping any message would translate it to Chinese. \", \"audioUrl\": \"\", \"nickname\": \"Jake\", \"replyLoad\": false, \"timestamp\": \"\", \"translate\": \"\", \"translateLoad\": false, \"translateShow\": false}], \"hello\": [{\"role\": \"AI\", \"time\": \"\", \"type\": \"text\", \"content\": \"Hello\", \"audioUrl\": \"\", \"nickname\": \"Jake\", \"replyLoad\": false, \"timestamp\": \"\", \"translate\": \"\", \"translateLoad\": false, \"translateShow\": false}, {\"role\": \"AI\", \"time\": \"\", \"type\": \"text\", \"content\": \"Welcome to TalkMe\", \"audioUrl\": \"\", \"nickname\": \"Jake\", \"replyLoad\": false, \"timestamp\": \"\", \"translate\": \"\", \"translateLoad\": false, \"translateShow\": false}, {\"role\": \"AI\", \"time\": \"\", \"type\": \"text\", \"content\": \"I\'m Jack, one of the bots here at TalkMe\", \"audioUrl\": \"\", \"nickname\": \"Jake\", \"replyLoad\": false, \"timestamp\": \"\", \"translate\": \"\", \"translateLoad\": false, \"translateShow\": false}, {\"role\": \"AI\", \"time\": \"\", \"type\": \"text\", \"content\": \"Our goal is to help you practice English and become more confident speaking the language\", \"audioUrl\": \"\", \"nickname\": \"Jake\", \"replyLoad\": false, \"timestamp\": \"\", \"translate\": \"\", \"translateLoad\": false, \"translateShow\": false}], \"Oh, awesome!\": [{\"role\": \"AI\", \"time\": \"\", \"type\": \"text\", \"content\": \"You\'re probably here to practice, but we mostly want you to have fun!\", \"audioUrl\": \"\", \"nickname\": \"Jake\", \"replyLoad\": false, \"timestamp\": \"\", \"translate\": \"\", \"translateLoad\": false, \"translateShow\": false}], \"What can I do here\": [{\"role\": \"AI\", \"time\": \"\", \"type\": \"text\", \"content\": \"At TalkMe, you can chat with all sorts of AI bots to practice.😇\", \"audioUrl\": \"\", \"nickname\": \"Jake\", \"replyLoad\": false, \"timestamp\": \"\", \"translate\": \"\", \"translateLoad\": false, \"translateShow\": false}, {\"role\": \"AI\", \"time\": \"\", \"type\": \"text\", \"content\": \"We love chatting with humans, and we\'re always up for a good talk\", \"audioUrl\": \"\", \"nickname\": \"Jake\", \"replyLoad\": false, \"timestamp\": \"\", \"translate\": \"\", \"translateLoad\": false, \"translateShow\": false}], \"That sounds cool,thanks\": [{\"role\": \"AI\", \"time\": \"\", \"type\": \"text\", \"content\": \"No problems! I was designed especially for you 😉\", \"audioUrl\": \"\", \"nickname\": \"Jake\", \"replyLoad\": false, \"timestamp\": \"\", \"translate\": \"\", \"translateLoad\": false, \"translateShow\": false}, {\"role\": \"AI\", \"time\": \"\", \"type\": \"text\", \"content\": \"Different robots have different identities, so you can talk to anyone you\'re interested in.\", \"audioUrl\": \"\", \"nickname\": \"Jake\", \"replyLoad\": false, \"timestamp\": \"\", \"translate\": \"\", \"translateLoad\": false, \"translateShow\": false}, {\"role\": \"AI\", \"time\": \"\", \"type\": \"text\", \"content\": \"Before you start, I\'ve got a few tips for you, ready to hear?\", \"audioUrl\": \"\", \"nickname\": \"Jake\", \"replyLoad\": false, \"timestamp\": \"\", \"translate\": \"\", \"translateLoad\": false, \"translateShow\": false}]}', '2023-03-24 15:21:06');
INSERT INTO `t_common_config` VALUES (2, 'topic', '情景话题', '{\"simple\": [\"Travel\", \"Philosophy\", \"Education\", \"Space\", \"Food\", \"Fitness\", \"Gaming\", \"Social Media\", \"Music\", \"Sports\", \"Travel Destinations\", \"Technology\", \"Spirituality\", \"Nature\", \"Relationships\", \"News\", \"Money\", \"Politics\", \"Medicine\", \"History\", \"Family\", \"Psychology\", \"Hobbies\", \"Movies\", \"Self-Improvement\", \"Mental Health\", \"Science\", \"Books\", \"Art\", \"Fashion\", \"TV Shows\", \"Entertainment\", \"Business\", \"Careers\", \"DIY\"]}', '2023-03-28 15:08:21');
INSERT INTO `t_common_config` VALUES (3, 'prompt_choose', '可供选择的话题', '{\"message\": \"I am an English beginner and you want to practice speaking English with me. \\n I\'d like to talk about : #{hobby}.\\n You can start with:\\\"Hi,I am nice to meeting you.\\\"+a simple question related to the topic. \\n If I go off the topic, you have to bring the topic back to the topic.\"}', '2023-03-28 18:58:50');

-- ----------------------------
-- Table structure for user_message_record
-- ----------------------------
DROP TABLE IF EXISTS `user_message_record`;
CREATE TABLE `user_message_record`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `user_id` int(0) NOT NULL COMMENT '用户ID',
  `message` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文本消息',
  `audio_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '语音地址',
  `time_duration` int(0) NOT NULL DEFAULT 0 COMMENT '语音时长（s）',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '发送时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户消息记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_message_record
-- ----------------------------
INSERT INTO `user_message_record` VALUES (1, 0, '<speak version=\'1.0\' xml:lang=\'en-US\'><voice xml:lang=\'en-US\' xml:gender=\'Male\' name=\'en-US-ChristopherNeural\'> Microsoft Speech Service Text-to-Speech API </voice></speak>', 'https://file.bendiclass.com/oss/upload/audio/mp3/08bfaccef9dc4dbd9e7ab44f0e13cbb3.mp3', 0, '2023-03-29 15:55:49');

SET FOREIGN_KEY_CHECKS = 1;
