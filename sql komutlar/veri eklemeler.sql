INSERT INTO fakülteler(id,ad)
VALUES
(1,'Bilgisayar'),
(2,'TIP'),
(3,'Coğrafya'),
(4,'Sosyal bilimler'),
(5,'Fen edebiyat');


INSERT INTO öğrenciler(id,ad,soyad,fakülteid)
VALUES
(1,'Fatih','Işılgan',1),
(2,'Serap','Işılgan',1),
(3,'Murat','Işılgan',1),
(4,'Salih','Işılgan',2),
(5,'Murat','Köz',2),
(6,'Asım','Işılgan',2),
(7,'Murat','Yücedağ',3),
(8,'İhsan','Cengiz',3),
(9,'Orkun','Ispıt',3),
(10,'Serap','Miraj',4),
(11,'Tahsin','Savcı',4),
(12,'Osman','Arı',4),
(13,'Gordon','Freeman',5),
(14,'Daniela','Ablow',5),
(15,'Ahmet','Yeşil',5);
--- fakülte id'ler 1 ile 5 arasında girilerek ilişkili veritabanına uygun olmuş oldu
