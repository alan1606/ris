drop database if exists super_ris;

create database if not exists super_ris;

use super_ris;

create table tipoUsuario(
	id bigint unsigned not null auto_increment,
    tipo varchar(40) not null,
    primary key(id)
);



CREATE TABLE usuario (
  id bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  idTipoUsuario bigint unsigned  NOT NULL DEFAULT 1, #Va a otra tabla extra
  nick varchar(25)  NOT NULL DEFAULT '0',
  pass varchar(100)  NOT NULL DEFAULT '0',
  nip varchar(4)  NOT NULL DEFAULT '0',
  email varchar(30) NOT NULL DEFAULT '0',
  phoneNumber varchar(12) NOT NULL DEFAULT '0',
  activeUser boolean NOT NULL DEFAULT TRUE,
  replaceId varchar(100) NOT NULL DEFAULT '0' comment "Cadena que sustituyen al id Principal",
  validated boolean NOT NULL DEFAULT FALSE comment "Si ha validado su usuario",
  PRIMARY KEY (`id`)
) COMMENT='Tabla que contendra a los usuarios con autorizacion para usar el sistema';

create table fotoUsuario(
	id bigint unsigned not null auto_increment,
    idUsuario bigint unsigned not null,
    ruta varchar(40) not null,
    primary key(id),
    foreign key (idUsuario) references usuario(id)
);


ALTER TABLE `usuario`
  MODIFY `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT;

ALTER TABLE usuario 
	ADD FOREIGN KEY fk_id_tipo_usuario_usuario (idTipoUsuario) references tipoUsuario(id),
    ADD UNIQUE uq_nick (nick),
    ADD UNIQUE uq_tel (phoneNumber),
    ADD UNIQUE uq_mail (email);

create table formaPago(
	id bigint unsigned not null auto_increment,
    descripcion varchar(20) not null,
    constraint pk_id primary key (id)
)comment "Se refiere a las formas de pago admitidas como efectivo, crédito, débito..."
;

create table departamento (
	id bigint unsigned not null auto_increment,
    nombre varchar(15) not null,
	duracion_minutos smallint unsigned not null default 0 comment "Para aproximar los lugares de la agenda, se da por hecho que todos los estudios del mismo tipo duran lo mismo, ejemplo: una tac 25 minutos", 
    horaInicio time not null default "00:00" comment "Es para crear la plantilla de horario por departamento en un día regular",
    horaFin time not null default "00:00",
    constraint pk_id primary key (id),
    constraint uq_nombre unique (nombre)
)comment "Es un área del gabinete, por ejemplo, RX, TAC";

create table categoria(
	id bigint unsigned not null auto_increment,
	clave varchar(10) not null default "AAA000" comment "Es una clave para hacer una identificación que puede ser usada por los contadores",    
	descripcion varchar(20) not null, 
    activo boolean not null comment "Se le puede dejar de dar servicio a un convenio que no haya pagado",
    constraint pk_id primary key (id),
    constraint uq_clave unique (clave),
    constraint uq_descripcion unique (descripcion)
)comment "Se refiere a la procedencia del paciente: particular, pensiones, imss...";

CREATE TABLE `estado` (
  `id` bigint UNSIGNED NOT NULL,
  `nombre` varchar(40) NOT NULL COMMENT 'Nombre de la entidad',
  `abreviatura` varchar(3) NOT NULL COMMENT 'Preparada para curp',
  `activo` boolean NOT NULL DEFAULT '1',
  constraint pk_id primary key (id)
) COMMENT='Tabla de Estados de la República Mexicana';

create table datosFacturacion(
	id bigint unsigned not null auto_increment,
    razonSocial varchar(100) not null,
    rfc varchar(13) not null,
    cp varchar(8) not null,
    email varchar(60) not null,
    telefono varchar(13) not null,
    constraint pk_id primary key(id)
);

create table persona(	#Si una persona tiene que tener un usuario se hace la relacion, si por mientras no, se puede crear un usuario por defecto para pacientes que no tienen usuario
	id bigint unsigned not null auto_increment,
    idUsuario bigint unsigned not null,
    idEstado bigint unsigned not null,
    idDatosFacturacion bigint unsigned not null,
    patientId varchar(30) not null comment "El id generado para vincular con el pacs",
	primerNombre varchar(20) not null,
    segundoNombre varchar(20) not null default "",
    apellidoPaterno varchar(20) not null,
    apellidoMaterno varchar(20) not null,
    fechaNacimiento date not null,
    sexo enum('H','M') not null comment "Lista para curp H=hombre M=mujer",
    curp varchar(20) not null,
    constraint pk_id primary key(id),
    constraint uq_patient_id unique (patientId),
    constraint uq_curp unique (curp),
    constraint fk_id_estado_persona foreign key (idEstado) references estado(id),
    constraint fk_id_datos_facturacion_persona foreign key (idDatosFacturacion) references datosFacturacion (id),
    constraint fk_idUsuario foreign key (idUsuario) references usuario(id)
)comment "Es un paciente o alguien que paga un conjunto de estudios";

create table convenio(
	id bigint unsigned not null auto_increment,
    idCategoria bigint unsigned not null,
    idDatosFacturacion bigint unsigned not null,
    nombre varchar(30) not null,
    constraint pk_id primary key (id),
	constraint fk_id_datos_facturacion_convenio foreign key (idDatosFacturacion) references datosFacturacion (id),
    constraint fk_id_categoria_convenio foreign key (idCategoria) references categoria(id)
);

create table limiteEstudiosDiarios(
	id bigint unsigned not null auto_increment,
	idDepartamento bigint unsigned not null,
    idConvenio bigint unsigned not null,
    limite mediumint unsigned not null,
    constraint pk_id primary key (id),
    constraint fk_id_departamento_limite_estudios_diarios foreign key(idDepartamento) references departamento(id),
    constraint fk_id_convenio_limite_estudios_diarios foreign key(idConvenio) references convenio(id)
);

create table agenda(
	id bigint unsigned not null auto_increment,
    dia date not null comment "Solo puede haber una agenda por día",
    constraint pk_id primary key(id),
    constraint uq_dia unique(dia)
) comment "Es una agenda, se declara solamente que pertenece a un día";

create table agendaEnDepartamento(
	id bigint unsigned not null auto_increment,
	idAgenda bigint unsigned not null,
    idDepartamento bigint unsigned not null,
    horaInicio time not null comment "La hora en que se puede comenzar a establecer citas",
    horaFin time not null comment "La hora en que se permite agendar la última cita",
    constraint pk_id primary key(id),
    constraint fk_id_agenda_agenda_en_departamento foreign key (idAgenda) references agenda(id),
    constraint fk_id_departamento foreign key(idDepartamento) references departamento(id)
) comment "Una agenda cambia respecto a cada departamento, puede cambiar su hora de inicio y de fin; algunos días pueden cambiar también su horario";



create table turno(
	id bigint unsigned not null auto_increment,
    descripcion varchar(30) not null,
    horaInicio time not null,
    horaFin time not null,
    primary key(id),
    constraint uq_descripcion unique (descripcion)
);


create table recepcionista(
	id bigint unsigned not null auto_increment,
    idUsuario bigint unsigned not null,
    primerNombre varchar(20) not null,
    segundoNombre varchar(20) not null default "",
    apellidoPaterno varchar(20) not null,
    apellidoMaterno varchar(20) not null,
	sexo enum('H','M') not null,
    fechaNacimiento date not null,
    constraint pk_id primary key (id),
    constraint fk_idUsuario_recepcionista foreign key (idUsuario) references usuario(id)
) comment "Se usa esta tabla para almacenar el dato de la persona que agendó x cita";

create table recepcionistaDepartamento(
	id bigint unsigned not null auto_increment,
	idRecepcionista bigint unsigned not null,
    idDepartamento bigint unsigned not null,
    activo boolean default true not null,
    primary key(id),
    foreign key(idRecepcionista) references recepcionista (id),
    foreign key(idDepartamento) references departamento (id)
);

create table corte(
	id bigint unsigned not null auto_increment,
    idTurno bigint unsigned not null,
    idRecepcionistaResponsable bigint unsigned not null,
    dia date not null,
    fondoCaja double not null,
    primary key(id),
    foreign key id_turno_corte (idTurno) references turno(id),
    constraint uq_corte unique (idTurno, dia, idRecepcionistaResponsable),
    foreign key id_recepcionista_corte (idRecepcionistaResponsable) references recepcionista (id)
);

create table movimiento(
	id bigint unsigned not null auto_increment,
    idCorte bigint unsigned not null,
    cantidad double not null,
    descripcion varchar(60) not null,
    hora time not null,
    entrada boolean not null comment "Si está en cierto el movimiento es una entrada, en falso es salida",
    primary key(id),
    foreign key(idCorte) references corte(id)
);

create table ticket(
	id bigint unsigned not null auto_increment,
	idDatosFacturacion bigint unsigned not null comment "Un ticket es pagado solo por una persona, que puede ser o no quien se realice los estudios",
    fecha date not null comment "La fecha de creación",
    hora time not null,
    requiereFactura boolean not null default false comment "Si requiere factura poner en true, por defecto es false",
    estado char(1) not null comment "Por ejemplo; 0 = pendiente, 1 = pagado, 2 = cancelado, 3 = cortesia",
    total double not null default 0,
    constraint pk_id primary key (id),
	index (fecha),
    constraint fk_id_datos_facturacion_ticket foreign key(idDatosFacturacion) references datosFacturacion (id)
)comment "Es un conjunto de estudios";

create table concepto(
	id bigint unsigned not null auto_increment,
    idDepartamento bigint unsigned not null,
    detalle varchar (100) not null comment "Descripcion general, ejemplo: rx columna lumbar", 
	costo double not null comment "Cúanto cuesta producirlo?",
    constraint pk_id primary key (id),
    constraint fk_id_departamento_estudio foreign key (idDepartamento) references departamento(id),
    constraint uq_detalle_por_departamento unique (idDepartamento, detalle)
)comment "Es un estudio dentro de un departamento, por ejempo: tac de torax";

create table item(
	id bigint unsigned not null auto_increment,
    idConcepto bigint unsigned not null,
	idCategoria bigint unsigned not null,
    precioVenta double not null comment "El precio final del estudio, varía respecto a cada categoría",
    activo boolean not null default true comment "Por si se desea dejar de vender ese estudio temporalmente en x convencio",
    constraint fk_id_categoria_concepto_categoria foreign key (idCategoria) references categoria(id),
    constraint fk_id_concepto foreign key (idConcepto) references concepto(id),
    constraint pk_id primary key (id),
    constraint uq_concepto_en_categoria unique(idConcepto, idCategoria) #Se da por hecho que solo puede existir una tac de torax de pensiones, por ejemplo
)comment "Relaciona conceptos con categorías para habilitar que un mismo estudio pertenezca a particular, pensiones...";

create table pagoTicket(
	id bigint unsigned not null auto_increment,
	idTicket bigint unsigned not null,
    idFormaPago bigint unsigned not null,
    cantidad double not null comment "Qué cantidad del total se paga con esa forma de pago",
    constraint pk_ticket_pagado primary key(id),
    constraint fk_id_ticket_pago_ticket foreign key(idTicket) references ticket(id),
    constraint fk_id_forma_pago_pago_pago_ticket foreign key(idFormaPago) references formaPago(id)
)comment "Debido a que un ticket se puede pagar con varias formas de pago, esta tabla registra los pagos parciales";

create table medicoRadiologo(
	id bigint unsigned not null auto_increment,
    idUsuario bigint unsigned not null,
    primerNombre varchar(20) not null,
    segundoNombre varchar(20) not null default "",
    apellidoPaterno varchar(20) not null,
    apellidoMaterno varchar(20) not null,
    sexo enum('H','M') not null comment "Lista para curp H=hombre M=mujer",
    firma varchar(20) not null,
    especialidad varchar(50) not null default "", 
    cedulaFederal varchar(20) not null default "", 
    cedulaEstatal varchar(20) not null default "", 
    constraint pk_id primary key (id),
    constraint fk_idUsuario_medico_radiologo foreign key (idUsuario) references usuario(id),
    constraint uq_cedula_federal unique (cedulaFederal),
    constraint uq_cedula_estatal unique (cedulaEstatal)
)comment "Almacenamiento de los médicos que interpretan";

#Se puede crear uno por defecto para cuando un técnico aún no haya tomado un estudio
create table tecnico(
	id bigint unsigned not null auto_increment,
    idUsuario bigint unsigned not null,
    primerNombre varchar(20) not null,
    segundoNombre varchar(20) not null default "",
    apellidoPaterno varchar(20) not null,
    apellidoMaterno varchar(20) not null,
    sexo enum('H','M') not null comment "Lista para curp H=hombre M=mujer",
    constraint pk_id primary key (id),
    constraint fk_idUsuario_tecnico foreign key (idUsuario) references usuario(id)
)comment "Datos del técnico que toma un estudio";

create table estudio(
	id bigint unsigned not null auto_increment,
	idItem bigint unsigned not null comment "Referencia a un estudio en cierta categoría: tac de abdomen de particular",
    idPersona bigint unsigned not null comment "La persona que se va a tomar el estudio, puede ser quien pagó o no",
    idTicket bigint unsigned not null comment "Todo estudio pertenece a un conjunto de estudios, aunque sea solo uno",
    idTecnico bigint unsigned not null default 1 comment "Referencia al técnico que tomará el etudio",
	dicomId varchar(50) not null comment "Id del estudio para mostrar en visor, obtenido del pacs",
    fecha date not null,
	interpretado boolean not null default false,
    haSidoTomado boolean not null default false,
    prioridad char(1) not null default 0 comment  "Por ejemplo: 0=normal, 1=media, 2=alta, 3=urgente",
    clave varchar(50) not null comment "La clave exterior para evitar que desde afuera accedan a estudios que no se debería",
    precioVenta double not null default 0 comment "Es para que se quede el precio congelado en el tiempo, copia automáticamente de item",
    constraint pk_id primary key(id),
    constraint uq_clave_estudio unique (clave),
    index (fecha),
    constraint fk_id_tecnico_estudio  foreign key(idTecnico) references tecnico(id),
    constraint fk_id_persona_estudio foreign key(idPersona) references persona(id),
    constraint fk_id_ticket_estudio foreign key(idTicket) references ticket(id),
    constraint fk_id_item_estudio foreign key(idItem) references item(id)
)comment "Es la tabla principal";

create table fotoEstudio(
	id bigint unsigned not null auto_increment,
    idEstudio bigint unsigned not null,
    ruta varchar(40) not null,
    constraint pk_id primary key (id),
    constraint fk_id_estudio_foto_estudio foreign key (idEstudio) references estudio(id)
)comment "Detalle de cada estudio en particular, puede ser una orden única o una foto del proceso";

create table fotoTicket(
	id bigint unsigned not null auto_increment,
    idTicket bigint unsigned not null,
    ruta varchar(40) not null,
    constraint pk_id primary key (id),
    constraint fk_id_ticket_foto_ticket foreign key (idTicket) references ticket(id)
)comment "Se puede guardar la ruta de la foto de la orden, conviene en esta tabla ya que se guardaría aquí una sola foto por conjunto de estudios";

create table dictamen(
	id bigint unsigned not null,
    idMedicoRadiologo bigint unsigned not null,
    idEstudio bigint unsigned not null,
    fecha date not null,
    interpretacion mediumtext not null comment "16.777.215 caracteres",
    constraint pk_id primary key(id),
    index (fecha),
    constraint fk_id_medico_radiologo_dictamen foreign key (idMedicoRadiologo) references medicoRadiologo(id),
    constraint fk_id_estudio_dictamen foreign key (idEstudio) references estudio(id)
)comment "Es el cuerpo de una interpretación";


create table cita(
	id bigint unsigned not null,
    idAgenda bigint unsigned not null,
    idEstudio bigint unsigned not null,
    idRecepcionista bigint unsigned not null,
    idDepartamento bigint unsigned not null,
    hora time not null comment "La hora en que se asigna la cita",
    estado char(1) not null comment "Puede ser 0=agendado, 1=confirmado, 2=llegó la persona, 3=finalizado, 4=cancelado",
    constraint pk_id primary key (id),
    constraint fk_id_agenda_en_departamento_cita foreign key (idAgenda) references agenda(id),
    constraint fk_id_estudio_cita foreign key (idEstudio) references estudio(id),
    constraint fk_id_recepcionista foreign key(idRecepcionista) references recepcionista(id),
    constraint fk_id_departamento_cita foreign key(idDepartamento) references departamento(id),
    constraint uq_cita unique (idAgenda,idDepartamento, hora)
) comment "Se relaciona un estudio que ya pertence a una persona y trae todos los datos con una agenda";

create table permiso(
	id bigint unsigned not null,
    permiso varchar(30) not null,
    primary key (id)
);

create table permisoUsuario(
	idUsuario bigint unsigned not null,
    idPermiso bigint unsigned not null,
    primary key pk_id (idUsuario,idPermiso),
    foreign key (idUsuario) references usuario(id),
    foreign key(idPermiso) references permiso(id)
) comment "Vincula un permiso con un usuario, si un registro existe aquí significa que el usuario tiene ese permiso";

create table plantillaPermisosTipoUsuario(
	idTipoUsuario bigint unsigned not null,
    idPermiso bigint unsigned not null,
    primary key pk_id (idTipoUsuario,idPermiso),
    foreign key (idTipoUsuario) references tipoUsuario(id),
    foreign key(idPermiso) references permiso(id)
) comment "Vincula un permiso con un usuario, si un registro existe aquí significa que el usuario tiene ese permiso";
