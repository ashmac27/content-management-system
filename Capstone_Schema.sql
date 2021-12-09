DROP SCHEMA IF EXISTS Capstone;
CREATE SCHEMA Capstone;

USE Capstone;

CREATE TABLE IF NOT EXISTS users(
	UserID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    FirstName VARCHAR(20) NOT NULL,
    LastName VARCHAR(20) NOT NULL,
    `Role` VARCHAR(10) NOT NULL
);

CREATE TABLE IF NOT EXISTS posts(
  PostID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  Title VARCHAR(100),
  Content MEDIUMTEXT NOT NULL,
  CreationDate DATETIME NOT NULL,
  Approved BOOLEAN NOT NULL,
  PublishDate DATETIME DEFAULT NULL,
  ExpirationDate DATETIME DEFAULT NULL,
  UserID INT NOT NULL,
  FOREIGN KEY (UserID) REFERENCES Users(UserID)
);

CREATE TABLE IF NOT EXISTS tags (
  PostID INT NOT NULL,
  Tag VARCHAR(150) NOT NULL,
  PRIMARY KEY (PostID, Tag),
  FOREIGN KEY (PostID) REFERENCES Posts(PostID)
);