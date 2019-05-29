DROP DATABASE IF EXISTS MERCADONA;
CREATE DATABASE MERCADONA;
use mercadona;
CREATE TABLE CLIENTES(
    id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    dni VARCHAR(9),
    nombre VARCHAR(20),
    apellidos VARCHAR(30),
    domicilio VARCHAR(50),
    fechaNacimiento DATE,
    esVip INT(1)
);
CREATE TABLE TRABAJADORES(
    id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    dni VARCHAR(9),
    nombre VARCHAR(20),
    apellidos VARCHAR(30),
    domicilio VARCHAR(50),
    fechaNacimiento DATE,
    fechaInicioContrato DATE,
    puesto VARCHAR(30)
);
CREATE TABLE LOGIN(
    id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    user VARCHAR(20),
    password VARCHAR(20)
);
CREATE TABLE FACTURAS(
	id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	dniDependiente VARCHAR(9),
	dniCliente VARCHAR(9),
	idFactura VARCHAR(2)
);
insert into login (user,password) values ('darknnesilver','12345');
INSERT INTO `TRABAJADORES` (`nombre`,`apellidos`,`domicilio`,`fechaNacimiento`,`fechaInicioContrato`,`puesto`,`dni`) 
VALUES 
("Kane","Duran","Ap 510-6199 Tempor Rd.","2019-05-23 07:01:01","2018-05-29 05:10:31","Apilador","75709411E"),("Amaya","Washington","4581 Et St.","2019-04-30 21:56:58","2018-12-28 12:22:27","Apilador","03428201Z"),("Dexter","Schroeder","160-1839 Aenean Av.","2018-08-03 13:58:06","2019-08-22 01:48:03","Apilador","15846519I"),("Roth","Maxwell","Ap #421-5600 Quisque Road","2020-05-05 17:33:36","2020-05-21 21:11:07","Encargado","22591668J"),("Leah","Stanton","6067 Ante Av.","2019-03-07 08:05:56","2018-07-21 05:37:33","Apilador","48003012O"),("Adam","Bates","Ap #169-9004 Massa Street","2019-10-14 21:33:06","2020-04-24 05:18:29","Encargado","75129050J"),("Wendy","Dillard","8053 Sit Road","2018-12-27 00:15:39","2019-08-08 05:10:41","Cajero","64514205Z"),("Sylvia","Becker","P.O. Box 121, 5177 Nullam Avenue","2019-05-18 11:06:06","2018-12-26 18:39:56","Cajero","86883745S"),("Summer","Rasmussen","7776 Nullam St.","2020-02-09 02:28:37","2019-08-17 06:46:23","Encargado","13138586D"),("Virginia","Conway","995-5948 Etiam Street","2019-09-10 15:25:51","2020-04-16 07:09:03","Apilador","76519316N"),("Caldwell","Nolan","9444 Mauris Road","2019-04-16 12:41:00","2019-02-04 15:23:51","Apilador","23203542V"),("Adrian","Watts","Ap #223-9236 Faucibus Av.","2019-01-17 16:39:55","2018-09-30 12:12:06","Encargado","51448674T"),("Isaiah","Burks","Ap #110-5301 Eget, Street","2019-03-10 15:49:23","2020-03-21 07:07:08","Cajero","01281370Q"),("Vance","Roberson","Ap #460-7694 Magnis Rd.","2019-12-04 21:19:33","2018-12-16 09:08:54","Encargado","15450265O"),("Lacy","Payne","P.O. Box 638, 8248 Commodo St.","2018-09-10 23:06:53","2018-07-03 03:20:02","Apilador","58728480I"),("Yardley","Myers","536-2069 Pharetra, St.","2020-02-17 14:25:27","2018-05-31 17:56:53","Cajero","75127019O"),("Ignacia","Vasquez","Ap #306-553 Eleifend Av.","2019-08-29 06:41:32","2019-08-17 08:54:57","Cajero","06267155Q"),("Chester","Jones","681-5205 At Avenue","2019-03-12 08:42:29","2018-12-30 11:44:47","Encargado","21550128E"),("Adara","Dillon","3439 Magna St.","2019-06-01 08:10:51","2020-04-09 04:57:42","Cajero","13522094C"),("Griffith","Mccoy","P.O. Box 298, 436 Auctor, Ave","2018-09-26 01:38:43","2018-11-25 19:52:12","Cajero","22343026H"),("Yuri","Brennan","878-6439 Morbi St.","2019-06-12 09:22:04","2019-02-08 04:41:25","Encargado","67994544U"),("Ferdinand","Wong","3861 Sit St.","2019-06-14 21:29:54","2018-11-14 20:16:48","Encargado","61612094P"),("Julian","Chase","7186 Velit Ave","2019-09-18 08:43:36","2019-12-19 03:52:22","Encargado","52309207H"),("Hilda","York","248 Sed Av.","2018-10-20 22:16:59","2019-04-05 06:18:28","Cajero","69035976M"),("Destiny","Dale","P.O. Box 750, 3070 Libero. Avenue","2019-02-25 17:45:57","2018-08-05 15:13:58","Encargado","97765507W"),("Tanya","Colon","Ap #649-4655 Risus. Av.","2019-10-02 07:23:47","2020-01-03 16:27:25","Encargado","81212244N"),("Jolie","Williams","Ap #534-4295 Consequat Rd.","2019-02-03 14:53:55","2019-11-04 20:32:54","Encargado","79426297H"),("Adrienne","Jackson","P.O. Box 981, 5301 Enim. Rd.","2020-03-26 02:10:02","2018-08-29 11:13:25","Cajero","67757381J"),("Raymond","Wilcox","950-1406 Nascetur Av.","2019-07-22 06:01:13","2018-09-05 05:28:57","Apilador","51465392Q"),("Carl","Mays","Ap #699-8852 In Street","2018-10-13 02:25:10","2019-07-20 21:02:16","Cajero","71134537B"),("Jerry","Vang","P.O. Box 456, 393 At, Road","2019-09-23 08:44:15","2019-12-30 22:31:29","Encargado","90575677N"),("Maxine","Patterson","127-9501 Tempus Rd.","2019-07-26 00:11:44","2019-08-16 21:47:00","Cajero","03193998X"),("Yen","Butler","582-6940 Eget Av.","2018-12-01 10:36:31","2018-08-14 04:57:12","Cajero","32915829R"),("Jolie","Castro","Ap #138-8450 Cursus Street","2019-11-08 20:22:01","2019-10-01 13:39:12","Apilador","64389511J"),("Kay","Dudley","4131 Suspendisse Street","2020-03-17 10:45:57","2018-11-30 16:49:16","Cajero","44303049Y"),("Bethany","Mcfadden","P.O. Box 498, 768 Augue Road","2018-07-29 08:49:58","2019-12-18 06:43:27","Encargado","33089528A"),("Odette","Cardenas","P.O. Box 672, 9420 Sem Street","2018-06-19 09:58:30","2018-06-10 13:39:07","Encargado","38289440R"),("Ray","Wilder","8349 Tortor. St.","2019-03-21 09:10:59","2018-09-27 13:54:36","Cajero","44136903H"),("Kalia","Frost","Ap #578-7431 Vel St.","2020-01-18 14:30:17","2019-02-01 15:57:41","Apilador","97746758U"),("Aidan","Atkins","P.O. Box 884, 7797 Nulla. Rd.","2020-03-14 23:05:52","2019-11-25 08:15:32","Encargado","65958699D"),("Hollee","Gay","7791 Donec Ave","2018-10-22 02:29:24","2019-06-22 00:30:01","Cajero","71993079G"),("Mannix","Spencer","2010 Praesent Street","2018-12-25 01:49:26","2019-05-05 05:51:16","Apilador","66417267G"),("Riley","Morse","451-2788 Eu, Street","2019-06-29 06:02:14","2019-08-01 01:53:00","Encargado","17627250D"),("Berk","Terry","9102 Enim Road","2018-09-27 14:45:35","2019-05-13 11:35:56","Cajero","17234614U"),("Serena","Dunlap","Ap #895-7688 Fringilla. Ave","2019-10-24 18:22:28","2019-08-20 06:53:17","Apilador","71331966W"),("Carolyn","James","3461 Nibh Road","2020-04-14 19:31:38","2019-10-25 04:23:07","Apilador","49419058F"),("Lee","Thornton","9414 Odio Av.","2019-12-13 13:29:53","2019-07-30 13:24:26","Encargado","87341638K"),("Tanek","Olson","3336 Quam Avenue","2020-05-08 21:33:38","2019-08-07 10:20:10","Cajero","86889587D"),("Audrey","Bowers","717 Non Street","2019-02-02 23:26:04","2019-07-21 23:11:03","Cajero","42994561O"),("Madaline","Wood","Ap #580-9164 Mattis. Av.","2019-10-28 15:52:05","2019-08-25 07:24:50","Apilador","91232719G"),("Hunter","Cardenas","P.O. Box 919, 3584 Nunc St.","2019-04-10 15:33:39","2019-06-11 02:36:42","Encargado","93765766R"),("Sarah","Shelton","446 Ut St.","2018-09-09 08:47:21","2019-08-19 15:24:13","Apilador","25415846L"),("Holmes","Fischer","806 Curabitur Ave","2019-12-10 02:20:31","2018-07-08 18:01:23","Encargado","04974125E"),("Curran","Curtis","P.O. Box 622, 5426 Ridiculus St.","2019-11-28 19:04:57","2018-11-19 15:38:51","Apilador","24791594V"),("Sage","Rollins","P.O. Box 115, 8686 Neque Rd.","2019-05-28 19:21:38","2018-07-08 18:40:01","Cajero","94032293F"),("Fulton","Houston","671-4836 Mauris. Road","2019-01-25 03:15:54","2019-11-01 10:52:30","Apilador","73209931V"),("Caesar","Keith","654-3347 Ac Avenue","2020-02-21 16:41:09","2018-08-29 04:51:20","Encargado","85946677T"),("Hoyt","Mack","401-5808 Ligula Road","2019-09-04 16:54:27","2019-07-14 17:06:59","Encargado","06920388R"),("Emily","Petty","351-1470 Sapien Rd.","2018-10-31 14:41:39","2019-02-17 21:32:41","Apilador","21755557S"),("Olympia","Patrick","Ap #684-6444 Non, Avenue","2018-07-03 14:24:17","2019-09-12 08:21:24","Apilador","18796943X"),("Quamar","Stephenson","Ap #263-5339 Nam St.","2018-09-19 02:32:24","2019-06-01 07:40:52","Encargado","87312694G"),("Venus","Pierce","1206 Eu St.","2020-04-23 21:54:05","2018-11-23 00:07:41","Encargado","10965662X"),("Raja","Gilbert","P.O. Box 917, 834 Quis, Rd.","2019-12-23 05:02:54","2019-11-10 23:20:24","Apilador","55539885T"),("Hyatt","Hall","P.O. Box 357, 4973 Lectus Rd.","2018-12-06 19:18:35","2019-11-29 04:01:35","Encargado","71834665E"),("Wendy","Robinson","P.O. Box 965, 9796 At Street","2018-12-22 23:01:18","2020-03-04 07:33:21","Cajero","66039075Y"),("Merrill","Padilla","P.O. Box 958, 8891 Praesent Ave","2018-09-29 20:03:38","2020-01-16 08:34:06","Apilador","18259765F"),("Carl","Winters","Ap #610-9541 Tellus Avenue","2019-05-05 04:58:43","2018-07-09 19:26:18","Encargado","68812380M"),("Barrett","Hodges","952-6299 Quisque Rd.","2019-09-28 16:47:43","2020-05-14 15:26:43","Cajero","42264443L"),("Chiquita","Sherman","125-5865 Congue Rd.","2018-10-27 12:46:09","2020-01-24 03:38:23","Cajero","45732407I"),("Reagan","England","Ap #309-8549 Ultricies St.","2018-07-22 05:32:33","2019-12-25 00:31:13","Apilador","17982181S"),("Reese","Lang","8938 Libero Road","2018-06-04 20:05:12","2019-08-20 15:53:38","Encargado","70188667M"),("Gillian","Hyde","P.O. Box 824, 6252 Volutpat. Av.","2020-01-03 05:37:59","2018-06-09 04:59:14","Encargado","35811822E"),("Sonia","Finley","P.O. Box 734, 8993 Nulla. Rd.","2018-10-08 18:49:12","2019-12-29 04:28:12","Cajero","06657600V"),("Vivien","Roth","9856 Porta Rd.","2020-01-23 18:26:31","2018-12-16 13:18:29","Cajero","74456453Q"),("Xanthus","Bruce","P.O. Box 360, 8009 Consectetuer Street","2018-10-28 12:54:21","2020-01-05 15:31:16","Encargado","41206454M"),("Richard","Bennett","Ap #360-9899 Luctus Avenue","2019-06-02 00:27:52","2019-04-19 14:10:58","Cajero","80242053A"),("Veronica","Cooley","953 Vulputate Road","2020-03-23 22:12:53","2020-04-15 01:57:11","Apilador","27268792N"),("Emily","Burns","114-8263 Ullamcorper St.","2018-07-21 13:37:19","2019-11-12 08:11:13","Cajero","98048777Z"),("Elton","Blanchard","Ap #383-2216 Pede. Av.","2019-10-20 19:23:17","2018-06-06 16:20:54","Apilador","00320248V"),("Charity","Fuller","199 Phasellus Avenue","2019-10-22 08:42:14","2019-08-01 23:53:34","Cajero","65850710D"),("Ezekiel","Quinn","Ap #225-7440 Imperdiet, Road","2018-11-12 00:58:37","2018-06-28 18:26:57","Apilador","19121397K"),("Illiana","Kim","Ap #623-1431 Aliquet Avenue","2019-03-28 02:05:21","2019-01-03 18:21:03","Cajero","31219495X"),("Piper","Yates","2073 Aenean St.","2019-12-03 03:08:26","2019-01-14 07:12:42","Cajero","77763618Q"),("Lisandra","Vaughan","484-7910 Sed, Avenue","2019-08-01 07:45:06","2019-09-30 04:02:23","Cajero","58862626N"),("Tanner","Lang","698 Dis Street","2019-12-19 00:36:28","2019-08-27 07:39:47","Encargado","43705634K"),("Ryan","Levine","P.O. Box 594, 2373 Ante St.","2019-03-01 00:04:27","2018-07-22 11:39:50","Apilador","74999298L"),("Amber","Duffy","603-2174 Id Street","2020-05-09 01:46:13","2020-04-10 13:19:56","Encargado","84460542A"),("Blaine","Nielsen","8668 Vitae Rd.","2019-07-04 19:15:41","2019-12-05 13:15:38","Cajero","27641928L"),("Marny","Estrada","Ap #330-4804 Non Road","2018-10-15 17:14:42","2019-08-09 23:59:57","Cajero","42044263S"),("Uriel","Berg","Ap #491-4892 Sed Rd.","2018-12-20 06:28:25","2018-08-26 14:26:16","Cajero","89261945L"),("Roth","Buckner","919-7414 Eu Road","2019-02-01 09:54:36","2018-11-13 21:04:04","Encargado","61281960Z"),("Dacey","Morrow","P.O. Box 108, 5343 Lacinia. Rd.","2018-05-28 03:56:30","2020-01-08 11:05:06","Cajero","22189026D"),("Ulric","Berger","P.O. Box 844, 3906 Auctor, Av.","2019-02-11 15:55:56","2019-06-08 23:20:16","Encargado","01118473I"),("Patricia","Underwood","5145 Pede. Rd.","2018-12-30 02:42:30","2019-03-08 09:07:40","Apilador","16356216E"),("Paul","Goodwin","640-101 Vitae Rd.","2018-11-12 20:20:53","2019-12-13 21:20:17","Apilador","66284267Y"),("Vance","Vincent","6674 Semper Av.","2020-03-16 02:56:07","2020-03-01 20:31:38","Encargado","42946531I"),("Rylee","Benjamin","460-834 Dignissim Ave","2018-07-03 11:03:27","2019-12-01 15:43:31","Apilador","35758820H"),("Marcia","Ware","P.O. Box 959, 442 Mus. Rd.","2019-01-19 18:15:04","2019-12-18 19:07:32","Cajero","42935638F"),("Ferris","Odom","P.O. Box 807, 3913 Arcu. Ave","2020-03-28 11:12:23","2020-01-04 09:42:30","Cajero","70788603Q"),("Kuame","English","6162 Aliquam Ave","2019-12-27 15:38:02","2020-02-10 04:11:44","Cajero","76096638Y");
INSERT INTO `CLIENTES` (`nombre`,`apellidos`,`domicilio`,`fechaNacimiento`,`dni`,`esVip`) VALUES ("Leilani","Christensen","877-4062 Libero Avenue","1998-08-03 22:02:00","791483952I",0),("Alvin","Alexander","Ap #559-1964 Nonummy Ave","1988-05-24 19:52:18","680338247O",0),("Mallory","Holmes","386-3536 Pede Street","1995-11-26 11:49:35","937834299Y",0),("Quyn","Hamilton","8710 Augue St.","1971-05-12 12:24:18","857503567B",0),("Sean","Cannon","6811 Erat Street","1998-07-19 16:20:58","528422425C",1),("Bell","Bush","465-393 Adipiscing Rd.","2000-01-02 10:57:11","538307683X",1),("Ulric","Sharpe","1398 Et Avenue","1997-12-09 02:29:10","674533427N",0),("Declan","Wynn","1267 Id, Street","1999-10-29 04:19:31","975378122Z",1),("Wayne","Witt","Ap #695-7568 Dui Rd.","1999-01-09 13:30:38","147841729J",0),("Brian","Jones","Ap #273-6490 Velit. Road","1983-07-23 20:51:11","718163918P",1),("Aurora","Hewitt","309-6108 Lacus. Av.","2000-09-07 09:26:19","618838963A",1),("Maxine","Berger","8882 Facilisis Rd.","1983-04-13 14:08:52","232979493E",0),("Colin","Pugh","Ap #543-9364 Tincidunt St.","2000-10-28 04:31:03","857590981K",1),("Aladdin","Humphrey","8304 Ullamcorper, St.","1974-06-25 17:22:44","592733823P",1),("Alvin","Lynch","Ap #138-9891 Elementum, St.","1977-06-23 17:17:38","749401929H",0),("Harriet","Watson","Ap #315-1393 Magna. Ave","1970-01-27 21:37:00","475675265K",0),("Lani","Carlson","Ap #991-7742 Vehicula St.","1989-12-16 20:49:53","354953808P",0),("Darius","Vazquez","2286 Morbi Street","1982-02-08 08:25:03","392287505I",1),("Xyla","Gill","P.O. Box 398, 5896 Augue Avenue","1995-09-05 18:41:37","635353435J",0),("Maggie","Mcknight","Ap #575-6529 Parturient Av.","1999-12-30 18:48:48","197140769J",0),("Grace","Buckley","769-5851 Auctor Street","1987-08-27 10:47:10","579735407V",1),("Kaitlin","Mueller","P.O. Box 121, 5487 Tincidunt St.","1993-07-24 07:03:32","254285833W",1),("Iliana","Newman","9650 Quis, Rd.","1992-01-20 07:47:31","929459781L",0),("Flynn","Bradford","4556 Consectetuer St.","1995-12-06 03:27:53","968767602C",1),("Cherokee","Compton","406 A Rd.","2000-08-17 14:09:01","998527118E",1),("Mikayla","Nguyen","P.O. Box 618, 5520 Sed Street","1986-04-08 19:18:20","193906626D",0),("Beverly","Robinson","916 Dui Rd.","1969-05-06 18:41:02","861513348Z",1),("Robin","Burt","595-6850 Ligula. Av.","1970-07-24 13:33:13","148316962A",1),("Hollee","Fuller","9534 Dolor St.","1995-06-26 21:43:46","877991937Q",1),("Gretchen","Hayden","790 Viverra. Avenue","1975-11-02 12:12:36","659477921U",1),("Sara","Barrera","2732 Vitae St.","1996-10-17 03:49:26","950102539A",1),("Ryan","Anderson","281-2818 Ante. Av.","1997-05-22 06:12:28","896110301E",1),("Wyatt","Nieves","P.O. Box 613, 4644 Sed Ave","1987-05-03 13:11:05","177448188V",1),("Savannah","Roberson","780-7033 Adipiscing Street","1988-11-18 23:00:59","139159724Q",1),("Karyn","Waters","724-8237 Non St.","1997-03-09 12:19:10","375358828W",0),("Roth","Manning","5118 Id, Rd.","1990-01-14 11:34:37","878559793Z",0),("Bernard","Riddle","592-5309 Aliquam St.","1974-02-08 19:19:31","427890907B",1),("Diana","Delgado","8670 Luctus St.","2000-04-22 02:12:59","425610335Q",1),("Jakeem","Abbott","876-3643 Eu St.","2000-01-05 05:21:39","726601613W",0),("Cassandra","Barton","7936 Fames Rd.","1972-06-17 18:04:00","571119959E",0),("Flavia","Roman","Ap #678-6491 Interdum. Street","1983-10-16 00:49:03","540908705M",1),("Tasha","Hinton","Ap #485-4093 Ut St.","1980-07-07 16:48:19","824593635U",0),("Edan","Boyd","687-9238 Erat Av.","1986-12-18 07:07:47","273544654Y",1),("Lacey","Gould","P.O. Box 525, 5303 Commodo St.","1995-05-25 12:06:45","998724624C",0),("Bert","Dennis","4632 Phasellus Road","1981-07-09 05:02:00","818428535B",1),("Dolan","Barker","801-5070 Vivamus Rd.","1971-06-27 18:11:55","588326331M",0),("Henry","Byrd","P.O. Box 974, 4866 Sed Avenue","1996-09-01 11:33:54","558214586P",1),("Nasim","Keller","6992 Ante Ave","1974-01-26 04:30:20","895456396Y",0),("Eugenia","Ayers","P.O. Box 331, 5558 Gravida Road","1987-12-31 16:20:32","674169465B",1),("Lara","Crawford","Ap #595-3432 Dui St.","1998-06-25 05:05:28","548790725M",1),("Barry","Turner","Ap #219-7786 Vehicula. Road","1991-05-12 08:58:49","535738883D",0),("Belle","Ochoa","559 Lacus Av.","1973-05-23 07:38:41","715451737L",1),("Gemma","Snow","4893 Penatibus Ave","1970-09-08 06:38:38","167420153J",0),("Lenore","Nelson","P.O. Box 949, 7796 Eget Rd.","1970-08-17 12:49:45","799676293M",1),("Bevis","James","P.O. Box 360, 1774 Sapien Road","1982-09-16 00:28:00","785753306P",1),("Nadine","Blackburn","2447 In Av.","1988-06-10 12:01:06","594498482B",1),("Kibo","Booker","2362 At Avenue","1997-01-24 06:08:25","151765193A",0),("Briar","Tyler","Ap #771-3168 Convallis, Street","1972-12-03 03:07:21","932181678U",1),("Reed","Williams","7356 Rutrum Street","1998-01-07 19:58:30","638560904Q",0),("Lee","Hatfield","1517 Phasellus St.","1994-03-24 14:42:35","649650343U",0),("Flynn","Lott","7006 Phasellus Av.","1978-02-01 18:31:15","473657598D",1),("Roanna","Cline","Ap #910-4049 Nonummy Road","1969-12-21 03:50:50","496264241F",0),("Darius","Cameron","6466 Adipiscing St.","1985-11-07 16:54:29","957766855D",1),("Elizabeth","Tillman","Ap #859-279 Cras St.","1992-12-10 23:44:31","746929162Q",1),("Barrett","England","648-7781 Ac Ave","1987-06-23 02:53:39","580565828M",0),("Kessie","Barrett","Ap #942-4586 Consequat St.","1988-08-05 03:04:16","964768588K",1),("Giselle","Johnson","P.O. Box 477, 2847 Cursus. St.","1997-06-24 04:12:18","882437445Y",0),("Amena","Cardenas","8650 Libero. Rd.","1997-08-04 20:43:12","576448184M",0),("Ian","Swanson","6487 Nulla St.","1971-10-25 22:04:15","137455854X",0),("Priscilla","Robertson","5905 Mauris. Street","1979-01-01 04:33:35","790267264Q",0),("Colorado","Shaffer","P.O. Box 389, 2200 Pede St.","2000-02-13 01:08:40","631208692L",0),("Ava","Jordan","Ap #952-606 Libero Avenue","1971-05-14 18:36:20","785334184K",1),("Yvonne","Slater","985-2964 Enim. Av.","1972-01-21 13:13:34","898744743N",1),("Baker","Kelley","P.O. Box 682, 6000 Congue, Av.","1985-10-25 14:04:09","928374676W",0),("Drew","Hayes","Ap #860-3678 Tempus, St.","1978-05-23 09:08:20","847834794G",0),("Colton","Kramer","P.O. Box 948, 9094 Convallis St.","1985-07-16 18:50:43","361359827F",1),("Armand","Snow","1126 Justo Avenue","1993-11-02 11:05:16","942699584D",0),("Vernon","Sykes","717-4010 Cras Av.","1990-04-28 01:04:20","757658332K",1),("Meredith","Mcgowan","Ap #213-6642 Magna. Road","1989-04-19 11:18:47","153752487Q",0),("Whitney","Martin","P.O. Box 442, 1972 Duis Rd.","1997-11-08 03:38:09","268412866L",1),("Oliver","Harrell","3422 Sodales. St.","1986-06-04 17:01:21","396982953I",1),("Maris","Luna","7675 Mauris Street","1981-08-22 23:00:16","624450808A",1),("Meghan","Horne","Ap #753-953 Accumsan Rd.","1978-08-15 03:36:59","662466358D",0),("William","Frye","1839 Aliquam Road","1978-06-16 00:01:57","433711122Z",1),("Zoe","Kennedy","P.O. Box 308, 8160 Ligula Road","1979-01-26 10:25:19","146740549I",0),("Indigo","Harding","188-1368 Parturient Av.","1981-07-15 01:49:20","460659399B",0),("Rhona","Rosario","190-3904 Id Avenue","1979-10-24 19:56:30","912420444V",0),("Gay","Huff","Ap #481-5003 Donec Avenue","1998-03-13 16:06:12","224914956M",1),("Dexter","Fuller","Ap #855-7232 Eu St.","1992-10-18 22:35:09","282622411S",0),("Gabriel","Douglas","9222 Sed Rd.","1983-04-19 14:50:33","594581604S",1),("Nathan","Snyder","6750 Lacus Road","1986-08-02 06:17:04","876444957M",1),("Wallace","Rivas","P.O. Box 770, 6807 Nec Av.","2000-04-18 05:51:00","137265174W",0),("Lucas","Avila","Ap #366-2448 Neque Av.","1969-07-19 16:59:33","541703986O",1),("Zachary","Hunt","P.O. Box 609, 8076 Augue Road","1969-09-30 15:13:39","255456276J",1),("Rafael","Klein","695-7635 Rutrum St.","1991-03-05 04:21:32","727687514Z",1),("Malik","Carver","685-4719 Ante. Rd.","1970-04-10 13:30:14","523339342O",1),("Candice","Riddle","151-8717 Nulla Road","1993-02-28 10:24:00","221312706U",1),("Bruno","Brady","Ap #879-742 Pharetra Road","1992-06-24 03:35:35","641851138A",0),("Kuame","Glenn","Ap #849-3220 Quisque St.","1969-12-22 21:33:51","780241266E",1),("Kaitlin","Jacobs","Ap #758-1832 Curabitur Road","1974-11-01 23:31:36","919974654M",0);
