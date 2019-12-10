CREATE TABLE `library_management`.`e_book` (
  `callno` INT NOT NULL,
  `name` VARCHAR(100) NULL,
  `author` VARCHAR(100) NULL,
  `publisher` VARCHAR(100) NULL,
  `quantity` INT NULL,
  `issue` INT NULL,
  PRIMARY KEY (`callno`)
  );
CREATE TABLE `library_management`.`e_issuebook` (
  `callno` INT NOT NULL,
  `studentid` INT NULL,
  `studentname` VARCHAR(100) NULL,
  `studentmobile` VARCHAR(100) NULL,
  `issuedate` DATE NULL,
  `returnstatus` VARCHAR(20) NULL,
  PRIMARY KEY (`callno`)
  );
  CREATE TABLE `library_management`.`e_librarian` (
  `id` VARCHAR(100) NOT NULL,
  `name` VARCHAR(100) NULL,
  `password` VARCHAR(100) NULL,
  `email` VARCHAR(100) NULL,
  `mobile` VARCHAR(100) NULL,
  PRIMARY KEY (`id`));
