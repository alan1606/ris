use super_ris;

insert into tipoUsuario values
(1, "TECNICO"),
(2, "PACIENTE"),
(3, "MEDICO RADIOLOGO"),
(4, "RECEPCIONISTA");

INSERT INTO `usuario` (`id`, idTipoUsuario,  `nick`, `password`, `nip`, `email`, `call`, `active`, `string`, `validated`) VALUES #Inserción X
(1, 1, 'alboch', 'a06d6629ebc6867c771a2ee0979abd24', '0523', 'albertoochoa@legalforb.com', '0', 1,  '10321d8076ac61234ddd8ebaa9fe7d39', 1);

INSERT INTO `usuario` (`id`, idTipoUsuario,  `nick`, `password`, `nip`, `email`, `call`, `active`, `string`, `validated`) VALUES 	#Inserción de usuario para pacientes que no tienen usuario
(2, 2, '', '', '', '', '', 0,  '', 0);

INSERT INTO `usuario` (`id`, idTipoUsuario,  `nick`, `password`, `nip`, `email`, `call`, `active`, `string`, `validated`) VALUES #Médico de prueba
(3, 3, 'elMedico', '123456789', '1234', 'medico@correo.com', '6271234567', 1,  'fhsdgfksdfhghkfd', 1);

INSERT INTO `usuario` (`id`, idTipoUsuario,  `nick`, `password`, `nip`, `email`, `call`, `active`, `string`, `validated`) VALUES #No asignado
(4, 1, 'tecnicoNoAasignado', '123456789', '1234', 'tecnico@correo.com', '6271234566', 0,  'fhsdgfksdfhghkfdsdfdsf', 0);

INSERT INTO `usuario` (`id`, idTipoUsuario,  `nick`, `password`, `nip`, `email`, `call`, `active`, `string`, `validated`) VALUES #Idalia
(5, 3, 'idaliaRojo', 'idaliatprdiagnocons', '1728', 'irojo@grupodiagnocare.com', '6271234561', 1,  'asdaghkfd', 1);

INSERT INTO `usuario` (`id`, idTipoUsuario,  `nick`, `password`, `nip`, `email`, `call`, `active`, `string`, `validated`) VALUES #Daniela
(6, 3, 'daniTerrazas', 'danitpr123', '4679', 'dterrazas@grupodiagnocare.com', '6273214567', 1,  'safasdfhghkfd', 1);

INSERT INTO `usuario` (`id`, idTipoUsuario,  `nick`, `password`, `nip`, `email`, `call`, `active`, `string`, `validated`) VALUES #Mary
(7, 4, 'mary12', 'passwd12345', '2501', 'mvazquez@grupodiagnocare.com', '6273214589', 1,  'asdasd', 1);

INSERT INTO `usuario` (`id`, idTipoUsuario,  `nick`, `password`, `nip`, `email`, `call`, `active`, `string`, `validated`) VALUES #Linda
(8, 4, 'linda321', 'contraseña', '1687', 'hbastardo@grupodiagnocare.com', '6272314567', 1,  'asdasdqwe', 1);

insert into formaPago values(1, "EFECTIVO");
insert into formaPago values(2,"DÉBITO");
insert into formaPago values(3, "TRANSFERENCIA");

insert into departamento values
(1, "TAC", 20, "07:00","15:00"),
(2, "RM", 20, "08:00", "16:00"),
(3, "OT", 10, "07:00", "18:00");

insert into categoria values
(1, "PT", "PARTICULAR", 1),
(2, "PN", "PENSIONES", 1),
(3, "IM", "IMSS", 1),
(4, "IS", "ISSSTE", 1);

INSERT INTO `estado` (`id`, `nombre`, `abreviatura`, `activo`) VALUES
(1, 'Aguascalientes', 'AS', 1),
(2, 'Baja California', 'BC', 1),
(3, 'Baja California Sur', 'BS', 1),
(4, 'Campeche', 'CC', 1),
(5, 'Coahuila de Zaragoza', 'CL', 1),
(6, 'Colima', 'CM', 1),
(7, 'Chiapas', 'CS', 1),
(8, 'Chihuahua', 'CH', 1),
(9, 'Ciudad de México', 'DF', 1),
(10, 'Durango', 'DG', 1),
(11, 'Guanajuato', 'GT', 1),
(12, 'Guerrero', 'GR', 1),
(13, 'Hidalgo', 'HG', 1),
(14, 'Jalisco', 'JC', 1),
(15, 'México', 'MC', 1),
(16, 'Michoacán de Ocampo', 'MN', 1),
(17, 'Morelos', 'MS', 1),
(18, 'Nayarit', 'NT', 1),
(19, 'Nuevo León', 'NL', 1),
(20, 'Oaxaca', 'OC.', 1),
(21, 'Puebla', 'PL', 1),
(22, 'Querétaro', 'QO', 1),
(23, 'Quintana Roo', 'QR', 1),
(24, 'San Luis Potosí', 'SP', 1),
(25, 'Sinaloa', 'SL', 1),
(26, 'Sonora', 'SR', 1),
(27, 'Tabasco', 'TC', 1),
(28, 'Tamaulipas', 'TS', 1),
(29, 'Tlaxcala', 'TL', 1),
(30, 'Veracruz de Ignacio de la Llave', 'VZ', 1),
(31, 'Yucatán', 'YN', 1),
(32, 'Zacatecas', 'ZS', 1);

INSERT INTO datosFacturacion values
(1, "ALAN MAURICIO AGUIRRE ROBLES", "AURA000616P10", "33830", "mauri.ar3@gmail.com", "6272790112"),
(2, "PENSIONES CIVILES DEL ESTADO DE CHIHUAHUA", "PENS000819E12", "33800", "pensionesXD@gmail.com", "627271234567");

insert into persona values
(1, 2, 8, 1, "PID_PACS_123456", "ALAN", "MAURICIO",  "AGUIRRE",  "ROBLES", "2000-06-16", 'H', "AURA000616HCHGBLA6");

insert into convenio values(1, 2, 2, "PENSIONES");

insert into limiteEstudiosDiarios values
(1, 1, 2),
(2, 1, 5),
(3, 1, 10);

insert into caja values
(1, "KINES"),
(2, "CONS");

#HACE FALTA CREAR REFERENCIA A DATOS DE FACTURACIÓN VACÍOS
insert into ticket values
(1, 1, 1,"2021-06-01", "07:30", 1, 1, "3500"), #particular con factura
(2, 2, 2, "2021-06-01", "18:30", 1, 0, "5000"); #pensiones factura

insert into concepto values
(1, 1, "TAC DE TORAX", 3000),
(2, 1, "TAC DE CRÁNEO", 3000),
(3, 2, "RM DE ABDOMEN", 4000);

#1 = particular 2=pensiones

INSERT INTO item values
(1, 1, 1, 3500, 1), #TAC DE TORAX PARTICULAR 
(2, 1, 2, 3200, 1), #TAC DE TORAX DE PENSIONES 
(3, 3, 2, 4200, 1), #RM DE ABDOMEN PENSIONES
(4, 3, 1, 5000, 1) #RM ABDOMEN PARTICULAR
;

INSERT into pagoTicket values
(1,1,3000),
(1,2,500),
(2,3,5000);

insert into medicoRadiologo values
(1, 3, "MÉDICO", "",  "DE" , "PRUEBA", 'H',"MIFIRMA", "NEUROLOGÍA", "12344", "44321");

insert into tecnico values
(1, 4, "NO",  "ASIGNADO", "","", 'M'),
(2, 5, "IDALIA", "", "ROJO", "", 'M'),
(3, 6, "DANIELA", "", "TERRAZAS", "", 'M');

insert into estudio values
(1, 1, 1, 1, 2, "iuid_001", "2021-06-01", 0, 1, 0, "ZXAPDC", 3500),
(2, 3, 1, 2, 3, "iuid_002", "2021-06-01", 1, 1, 3, "ZXAPDD", 4200);


insert into dictamen values
(1,1,2,"2021-06-01","Este chavo está grave, ya se va a morir");

insert into agenda values
(1, "2021-06-01");

insert into agendaEnDepartamento values
(1, 1, "07:00", "16:00"),
(1, 2, "08:00", "18:00")
;

insert into recepcionista values
(1, 7, "MARY", "" , "VAZQUEZ", "", 'M', "1998-06-01"),
(2, 8, "HERLINDA", "", "BASTARDO", "", "M","1990-06-02");

 insert into cita values
(1, 1, 1,1, 1,"07:00",1),
(2, 1, 2,2, 2,"08:00",3);

insert into datos_facturacion (
razon_social ,
    rfc ,
    cp ,
    email ,
    telefono)
values
("El alan inc", "AURA000616PI0", "33800", "mauri.ar3@gmail.com", "6272790112");