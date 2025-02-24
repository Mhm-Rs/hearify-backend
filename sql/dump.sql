-- MySQL dump 10.13  Distrib 8.0.41, for Linux (x86_64)
--
-- Host: mysql-1718f0b2-hearify.f.aivencloud.com    Database: defaultdb
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '0c4c3771-d839-11ef-843e-221dbe2fd3f4:1-22,
24ca948d-ad5a-11ef-a81d-12603e7cf52d:1-53,
5ab69598-cdd9-11ef-99c7-66d840af8f18:1-15,
966a0061-bfe2-11ef-a10d-0affd6a64d6f:1-58,
c70334a1-ef06-11ef-b3ef-ee9eab824ec3:1-96';

--
-- Table structure for table `albums`
--

DROP TABLE IF EXISTS `albums`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `albums` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `release_date` date DEFAULT NULL,
  `artist_id` int NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `cover_image` varchar(255) DEFAULT NULL,
  `saves` int DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `artist_id` (`artist_id`),
  CONSTRAINT `albums_ibfk_1` FOREIGN KEY (`artist_id`) REFERENCES `artists` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `albums`
--

LOCK TABLES `albums` WRITE;
/*!40000 ALTER TABLE `albums` DISABLE KEYS */;
INSERT INTO `albums` VALUES (1,'In the Wee Small Hours','1955-04-25',1,'2024-12-09 12:36:17','https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Fd24jnm9llkb1ub.cloudfront.net%2Ficpn%2F00602537975877%2F00602537975877-cover-zoom.jpg&f=1&nofb=1&ipt=f8105c0cae432ddb93a3bd30fc657ef9b222f43fdb20b75989fc425048cf1d08&ipo=images',10),(2,'If I Didn’t Care','1939-01-01',2,'2024-12-09 12:36:17','https://i.discogs.com/RNUR4dUs0MrNPUefHofBJbQ61kvvFrzKsmxR_x-uwV0/rs:fit/g:sm/q:90/h:583/w:600/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTU2MTE2/MDItMTM5Nzk0ODEy/NS01MDA2LmpwZWc.jpeg',10),(3,'Point of No Return','1962-05-03',1,'2024-12-25 16:44:21','https://3.bp.blogspot.com/-HnnGEBb3WPE/Wpxi0prEvDI/AAAAAAAASYE/6gegkcaZgHgPrTgxObq-suxL_VaSDP1EwCLcBGAs/s1600/Frank%2BSinatra%2B-%2BPoint%2BOf%2BNo%2BReturn%2B%2528frente%2529.jpg',11),(6,'Timeless','2031-03-23',3,'2025-02-22 15:13:44','https://www.kemifilani.ng/wp-content/uploads/2023/03/Davido-%E2%80%93-Timeless-Album.jpg',12),(7,'After Hours','2020-03-20',4,'2025-02-22 15:13:44','https://images.saymedia-content.com/.image/t_share/MTc2MjUwMzcwNjgxNzQyNzYx/the-weeknds-after-hours-album-review.jpg',38),(8,'QALF Infinity','2029-04-21',5,'2025-02-22 15:18:23','https://strikt.net/wp-content/uploads/2021/04/damso-qalf_infinity.jpeg',38);
/*!40000 ALTER TABLE `albums` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artists`
--

DROP TABLE IF EXISTS `artists`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `artists` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `bio` varchar(255) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `cover_image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artists`
--

LOCK TABLES `artists` WRITE;
/*!40000 ALTER TABLE `artists` DISABLE KEYS */;
INSERT INTO `artists` VALUES (1,'Frank Sinatra','Frank Sinatra was an American singer, actor, and producer, known as the \"Chairman of the Board\".','2024-12-09 12:36:17','https://upload.wikimedia.org/wikipedia/commons/c/c2/Frank_Sinatra_by_Gottlieb_c1947-_2.jpg'),(2,'The Ink Spots','The Ink Spots were an American vocal jazz group who gained international fame in the 1930s and 1940s.','2024-12-09 12:36:17','https://ichef.bbci.co.uk/images/ic/960x540/p01bqv81.jpg'),(3,'Davido','David Adedeji Adeleke OON (born November 21, 1992), known professionally as Davido, is a Nigerian-American singer, songwriter and record producer','2025-02-22 15:11:00','https://thevaultznews.com/wp-content/uploads/2021/02/1428-1140x570.jpg'),(4,'The Weeknd','Abel Makkonen Tesfaye (born February 16, 1990), known professionally as the Weeknd, is a Canadian singer-songwriter and actor.','2025-02-22 15:11:00','https://akns-images.eonline.com/eol_images/Entire_Site/2021330/rs_1200x1200-210430163406-1200-the-weeknd.jpg?fit=around%7C1080:1080&output-quality=90&crop=1080:1080;center,top'),(5,'Damso','William Kalubi Mwamba (born 10 May 1992 in Kinshasa), better known by his stage name Damso, is a Belgian-Congolese rapper, singer, and songwriter. He is popular in France, where all of his albums were certified at least platinum.','2025-02-22 15:15:55','https://upload.wikimedia.org/wikipedia/commons/2/27/Festival_des_Vieilles_Charrues_2018_-_Damso_-_009_%28cropped%29.jpg');
/*!40000 ALTER TABLE `artists` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `favorites`
--

DROP TABLE IF EXISTS `favorites`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `favorites` (
  `user_id` int NOT NULL,
  `track_id` int NOT NULL,
  `added_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`,`track_id`),
  KEY `track_id` (`track_id`),
  CONSTRAINT `favorites_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE,
  CONSTRAINT `favorites_ibfk_2` FOREIGN KEY (`track_id`) REFERENCES `tracks` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `favorites`
--

LOCK TABLES `favorites` WRITE;
/*!40000 ALTER TABLE `favorites` DISABLE KEYS */;
INSERT INTO `favorites` VALUES (1,2,'2025-01-01 19:24:12'),(2,5,'2024-12-09 12:40:27');
/*!40000 ALTER TABLE `favorites` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `playlist_tracks`
--

DROP TABLE IF EXISTS `playlist_tracks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `playlist_tracks` (
  `playlist_id` int NOT NULL,
  `track_id` int NOT NULL,
  `added_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`playlist_id`,`track_id`),
  KEY `track_id` (`track_id`),
  CONSTRAINT `playlist_tracks_ibfk_1` FOREIGN KEY (`playlist_id`) REFERENCES `playlists` (`id`) ON DELETE CASCADE,
  CONSTRAINT `playlist_tracks_ibfk_2` FOREIGN KEY (`track_id`) REFERENCES `tracks` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `playlist_tracks`
--

LOCK TABLES `playlist_tracks` WRITE;
/*!40000 ALTER TABLE `playlist_tracks` DISABLE KEYS */;
INSERT INTO `playlist_tracks` VALUES (1,2,'2025-02-23 21:54:20'),(1,3,'2025-02-23 21:54:20'),(1,5,'2025-02-23 21:54:20'),(1,6,'2025-02-23 21:54:20'),(1,14,'2025-02-23 21:54:20'),(3,6,'2025-02-23 23:04:32'),(3,11,'2025-02-23 23:04:32'),(3,19,'2025-02-23 23:04:32');
/*!40000 ALTER TABLE `playlist_tracks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `playlists`
--

DROP TABLE IF EXISTS `playlists`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `playlists` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `user_id` int NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `cover` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `playlists_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `playlists`
--

LOCK TABLES `playlists` WRITE;
/*!40000 ALTER TABLE `playlists` DISABLE KEYS */;
INSERT INTO `playlists` VALUES (1,'My Favorite Songs',1,'2024-12-09 12:36:19','https://i.pinimg.com/originals/2a/9d/4f/2a9d4f46643800653193bd6adb2179c7.jpg'),(3,'Chill Vibes',1,'2025-02-22 13:30:25','https://mir-s3-cdn-cf.behance.net/project_modules/max_1200/64c72857183915.59cbcc586d1d1.jpg'),(4,'The Summer Sounds',2,'2025-02-22 13:30:25','https://images.template.net/106601/free-summer-playlist-cover-asr6l.png');
/*!40000 ALTER TABLE `playlists` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tracks`
--

DROP TABLE IF EXISTS `tracks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tracks` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `duration` int NOT NULL,
  `album_id` int NOT NULL,
  `artist_id` int NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `track_play_id` varchar(255) DEFAULT NULL,
  `track_play_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `album_id` (`album_id`),
  KEY `artist_id` (`artist_id`),
  CONSTRAINT `tracks_ibfk_1` FOREIGN KEY (`album_id`) REFERENCES `albums` (`id`) ON DELETE CASCADE,
  CONSTRAINT `tracks_ibfk_2` FOREIGN KEY (`artist_id`) REFERENCES `artists` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tracks`
--

LOCK TABLES `tracks` WRITE;
/*!40000 ALTER TABLE `tracks` DISABLE KEYS */;
INSERT INTO `tracks` VALUES (1,'In the Wee Small Hours of the Morning',180,1,1,'2024-12-09 12:36:18','0Hsc0sIaxOxXBZbT3ms2oj','https://p.scdn.co/mp3-preview/14808b97ce16eca2b5bd2d18bdc4a23f7040578b'),(2,'Mood Indigo',210,1,1,'2024-12-09 12:36:18','2LuKtTtotMk41MxesmjCdR','https://p.scdn.co/mp3-preview/3610d53d16e3c8e6134d5ef7863c0be14ae07329'),(3,'Glad to Be Unhappy',195,1,1,'2024-12-09 12:36:18','0nyElOCpUSqLyzg1cD6dQe','https://p.scdn.co/mp3-preview/935d32409051c88d616954c6d75adc194ffa7dd4'),(4,'If I Didn’t Care',180,2,2,'2024-12-09 12:36:18','2jPgfwVXOKnUl2QLQsnIAT','https://p.scdn.co/mp3-preview/d3aa4e0193259e617c5b162b7eaf000d4b8802a3'),(5,'We Three (My Echo, My Shadow and Me)',195,2,2,'2024-12-09 12:36:18','43a4zqUZL1vHH93EKBFkLj','https://p.scdn.co/mp3-preview/8cbc2d6332f3e577ae1b19b5f112ae05b8a40f95'),(6,'Java Jive',200,2,2,'2024-12-09 12:36:18','5XvrvxNu3peNFyaelv8brK','https://p.scdn.co/mp3-preview/a43e0f38196f44cdf41c46b5b0babea8cd81d490'),(7,'(Ah, the Apple Trees) When the World Was Young\"',228,3,1,'2025-02-22 15:28:30','770vbFIaYsK28aDR1BlzUU','https://p.scdn.co/mp3-preview/9d4d37e26d0c3b955b99158848376a4bbfced136'),(8,'Ill Remember April',180,3,1,'2025-02-22 15:28:30','5lHeY8fPQ4pSMosezRwame','https://p.scdn.co/mp3-preview/6e95366d2101da11fefd12eeee62759ce37ba5b3'),(9,'Somewhere Along the Way',181,3,1,'2025-02-22 15:28:30','0OZWFT5f1V4m6TUNj9GrMz','https://p.scdn.co/mp3-preview/3341c6e29cd5408102f2bb46fbd560fe8087c7d1'),(10,'OVER DEM',208,6,3,'2025-02-22 16:01:53','1KCCxeit3q5wJXxDmRgbl3','https://p.scdn.co/mp3-preview/217d67ddb169b11adcd87117bbf164b53ddb0327'),(11,'UNAVAILABLE',169,6,3,'2025-02-22 16:01:53','2kaH2Z8ezDUKf6fNw250rZ','https://p.scdn.co/mp3-preview/f4b21794b26cd51251d3f537eeb0c3d8b6d8a811'),(12,'PRECISION',181,6,3,'2025-02-22 16:01:53','1PCUDCPFzwPbYbQqivdMxK','https://p.scdn.co/mp3-preview/c889760d458cb3bc3b3b1486b3ffab9876dde00b'),(13,'Alone Again',250,7,4,'2025-02-22 16:04:50','6b5P51m8xx2XA6U7sdNZ5E','https://p.scdn.co/mp3-preview/77e54c6064335e259d0f571768af5f96c22304d4'),(14,'Blinding Lights',200,7,4,'2025-02-22 16:04:50','0VjIjW4GlUZAMYd2vXMi3b','https://p.scdn.co/mp3-preview/51c08d92815cce4ac2de94a7335a430b81234624'),(15,'Save Your Tears',220,7,4,'2025-02-22 16:04:50','5QO79kh1waicV47BqGRL3g','https://p.scdn.co/mp3-preview/4bb5ee4441a2342502372f80f78a92cf3fe22549'),(16,'Σ.MOROSE',263,8,5,'2025-02-22 16:08:08','0oGwVSF6efXntXKxAZw9Hc','https://p.scdn.co/mp3-preview/1997506ef80502df1b3efd295e5ec843ccd30eb7'),(17,'YOUVOI',180,8,5,'2025-02-22 16:08:08','2CZT9lpixjDssmWFihv0U2','https://p.scdn.co/mp3-preview/7b47de74c659230ca8ca07d94b33b839e90a04ef'),(18,'COEUR EN MIETTES',208,8,5,'2025-02-22 16:08:08','3NV8nDR9XyuoHedgwjtPqS','https://p.scdn.co/mp3-preview/db44c2cdb258a8374a4d0164f236533538f06f1c'),(19,'BPM',182,8,5,'2025-02-22 16:08:08','5bw48y8A11NW6BvCK3z0pB','https://p.scdn.co/mp3-preview/5630b4d8670da7b1f9088767c1f38500eaa6344f');
/*!40000 ALTER TABLE `tracks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password_hash` varchar(255) NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `profile_pic` varchar(255) DEFAULT NULL,
  `followers` int DEFAULT '0',
  `following` int DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'user1','user1@example.com','administrator','2024-12-09 12:36:16','https://writestylesonline.com/wp-content/uploads/2016/08/Follow-These-Steps-for-a-Flawless-Professional-Profile-Picture-1024x1024.jpg',20,3),(2,'user2','user2@example.com','hashed_password2','2024-12-09 12:36:16','https://sm.askmen.com/t/askmen_in/article/f/facebook-p/facebook-profile-picture-affects-chances-of-gettin_fr3n.1200.jpg',1,0),(3,'user3','user3@example.com','hashed_password3','2024-12-09 12:36:16','https://3.bp.blogspot.com/-9YDmRdOQO5Y/W7ql9HZvhDI/AAAAAAAADJc/4WizmhdNBiArkst_o_3ArR2RmSyaYCCoACLcBGAs/s1600/-social%2Bmedia%2Bprofile%2Bpicture-3.jpg',0,1),(5,'monstar','damonster@him.fr','IcanSwallowAB0ttle?$','2024-12-25 16:35:06','https://wallpapers.com/images/hd/cute-cat-sunglasses-profile-picture-mw7qp9gjrp272zky.jpg',0,0);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-02-24 21:10:28
