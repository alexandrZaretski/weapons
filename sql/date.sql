-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema gun_store
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema gun_store
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `gun_store` DEFAULT CHARACTER SET latin1 ;
USE `gun_store` ;

-- -----------------------------------------------------
-- Table `gun_store`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gun_store`.`product` (
  `id_product` INT(10) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) NOT NULL,
  `price` INT(30) NULL DEFAULT NULL,
  PRIMARY KEY (`id_product`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `gun_store`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gun_store`.`role` (
  `id_role` INT(10) NOT NULL AUTO_INCREMENT,
  `role_name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id_role`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `gun_store`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gun_store`.`users` (
  `id_users` INT(10) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  `phone` INT(45) NOT NULL,
  `adress` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  `id_role` INT(10) NOT NULL,
  PRIMARY KEY (`id_users`),
  INDEX `id_role` (`id_role` ASC),
  CONSTRAINT `users_ibfk_1`
    FOREIGN KEY (`id_role`)
    REFERENCES `gun_store`.`role` (`id_role`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `gun_store`.`transaction`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gun_store`.`transaction` (
  `id_transaction` INT(10) NOT NULL AUTO_INCREMENT,
  `summ` INT(100) NOT NULL,
  `id_of_product` INT(10) NOT NULL,
  `id_of_user` INT(10) NOT NULL,
  `count` INT(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id_transaction`),
  INDEX `id_of_product` (`id_of_product` ASC),
  INDEX `id_of_user` (`id_of_user` ASC),
  CONSTRAINT `transaction_ibfk_1`
    FOREIGN KEY (`id_of_product`)
    REFERENCES `gun_store`.`product` (`id_product`),
  CONSTRAINT `transaction_ibfk_2`
    FOREIGN KEY (`id_of_user`)
    REFERENCES `gun_store`.`users` (`id_users`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;