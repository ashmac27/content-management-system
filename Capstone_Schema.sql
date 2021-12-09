DROP SCHEMA IF EXISTS Capstone;
CREATE SCHEMA Capstone;

USE Capstone;

CREATE TABLE IF NOT EXISTS users(
	UserId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    FirstName VARCHAR(20) NOT NULL,
    LastName VARCHAR(20) NOT NULL,
    `Role` VARCHAR(10) NOT NULL
);

CREATE TABLE IF NOT EXISTS posts(
  PostId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  Title VARCHAR(100),
  Content MEDIUMTEXT NOT NULL,
  CreationDate DATETIME NOT NULL,
  Approved BOOLEAN NOT NULL,
  PublishDate DATETIME DEFAULT NULL,
  ExpireDate DATETIME DEFAULT NULL,
  UserId INT NOT NULL,
  FOREIGN KEY (UserId) REFERENCES Users(UserId)
);

CREATE TABLE IF NOT EXISTS hashtags (
  PostId INT NOT NULL,
  Tag VARCHAR(150) NOT NULL,
  PRIMARY KEY (PostId, Tag),
  FOREIGN KEY (PostId) REFERENCES Posts(PostId)
);