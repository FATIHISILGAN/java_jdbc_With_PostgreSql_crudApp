
CREATE TABLE öğrenciler(
 
	id INT PRIMARY KEY,
ad VARCHAR(100) NOT NULL,
	soyad VARCHAR(100) NOT NULL,
	fakülteid INT NOT NULL,

CONSTRAINT fk_öğrenciler FOREIGN KEY (fakülteid) REFERENCES fakülteler(id)
--- bağlama işlemi
);

--- 1 ile 5 arasında girilmesi gerek yoksa hata verir
---çünkü 5 fakülte bulunmaktadır


CREATE TABLE fakülteler(
 
	id INT PRIMARY KEY,
    ad varchar(100) NOT NULL
	
 
);