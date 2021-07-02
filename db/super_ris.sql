drop database if exists super_ris;

create database if not exists super_ris;

use super_ris;

create table tipo_usuario(
	id bigint unsigned not null auto_increment,
    tipo varchar(40) not null,
    primary key(id)
);

insert into tipo_Usuario values
(1, "ADMINISTRADOR");

CREATE TABLE usuario (
  id bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  id_tipo_usuario bigint unsigned  NOT NULL DEFAULT 1, #Va a otra tabla extra
  nick varchar(25)  NOT NULL DEFAULT '0',
  pass varchar(100)  NOT NULL DEFAULT '0',
  nip varchar(4)  NOT NULL DEFAULT '0',
  email varchar(30) NOT NULL DEFAULT '0',
  phone_number varchar(12) NOT NULL DEFAULT '0',
  active_user boolean NOT NULL DEFAULT TRUE,
  replace_id varchar(100) NOT NULL DEFAULT '0' comment "Cadena que sustituyen al id Principal",
  validated boolean NOT NULL DEFAULT FALSE comment "Si ha validado su usuario",
  PRIMARY KEY (`id`)
) COMMENT='Tabla que contendra a los usuarios con autorizacion para usar el sistema';

insert into usuario values
(1, 1, "alan1606", "hayquericopapi", "1234", "mauri.ar3@gmail.com", "6272790112", 1, "zxcasdqwe123", 1);

create table foto_usuario(
	id bigint unsigned not null auto_increment,
    id_usuario bigint unsigned not null,
    ruta varchar(40) not null,
    primary key(id),
    foreign key (id_usuario) references usuario(id)
);


ALTER TABLE `usuario`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

ALTER TABLE usuario 
	ADD FOREIGN KEY fk_id_tipo_usuario_usuario (id_tipo_usuario) references tipo_usuario(id),
    ADD UNIQUE uq_nick (nick),
    ADD UNIQUE uq_tel (phone_number),
    ADD UNIQUE uq_mail (email);

create table forma_pago(
	id bigint unsigned not null auto_increment,
    descripcion varchar(20) not null,
    constraint pk_id primary key (id)
)comment "Se refiere a las formas de pago admitidas como efectivo, crédito, débito..."
;

create table departamento (
	id bigint unsigned not null auto_increment,
    nombre varchar(15) not null,
	duracion_minutos smallint unsigned not null default 0 comment "Para aproximar los lugares de la agenda, se da por hecho que todos los estudios del mismo tipo duran lo mismo, ejemplo: una tac 25 minutos", 
    hora_inicio time not null default "00:00" comment "Es para crear la plantilla de horario por departamento en un día regular",
    hora_fin time not null default "00:00",
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

create table datos_facturacion(
	id bigint unsigned not null,
    razon_social varchar(100) not null,
    rfc varchar(13) not null,
    cp varchar(8) not null,
    email varchar(60) not null,
    telefono varchar(13) not null,
    constraint pk_id primary key(id)
);

create table persona(	#Si una persona tiene que tener un usuario se hace la relacion, si por mientras no, se puede crear un usuario por defecto para pacientes que no tienen usuario
	id bigint unsigned not null,
    id_usuario bigint unsigned not null,
    id_estado bigint unsigned not null,
    id_datos_facturacion bigint unsigned not null,
    patient_id varchar(30) not null comment "El id generado para vincular con el pacs",
	primer_nombre varchar(20) not null,
    segundo_nombre varchar(20) not null default "",
    apellido_paterno varchar(20) not null,
    apellido_materno varchar(20) not null,
    fecha_nacimiento date not null,
    sexo enum('H','M') not null comment "Lista para curp H=hombre M=mujer",
    curp varchar(20) not null,
    constraint pk_id primary key(id),
    constraint uq_patient_id unique (patient_id),
    constraint uq_curp unique (curp),
    constraint fk_id_estado_persona foreign key (id_estado) references estado(id),
    constraint fk_id_datos_facturacion_persona foreign key (id_datos_facturacion) references datos_facturacion (id),
    constraint fk_idUsuario foreign key (id_usuario) references usuario(id)
)comment "Es un paciente o alguien que paga un conjunto de estudios";

create table convenio(
	id bigint unsigned not null,
    id_categoria bigint unsigned not null,
    id_datos_facturacion bigint unsigned not null,
    nombre varchar(30) not null,
    constraint pk_id primary key (id),
	constraint fk_id_datos_facturacion_convenio foreign key (id_datos_facturacion) references datos_facturacion (id),
    constraint fk_id_categoria_convenio foreign key (id_categoria) references categoria(id)
);

create table limite_estudios_diarios(
	id_departamento bigint unsigned not null,
    id_convenio bigint unsigned not null,
    limite mediumint unsigned not null,
    constraint pk_departamento_y_convenio primary key (id_departamento, id_convenio),
    constraint fk_id_departamento_limite_estudios_diarios foreign key(id_departamento) references departamento(id),
    constraint fk_id_convenio_limite_estudios_diarios foreign key(id_convenio) references convenio(id)
);

create table agenda(
	id bigint unsigned not null auto_increment,
    dia date not null comment "Solo puede haber una agenda por día",
    constraint pk_id primary key(id),
    constraint uq_dia unique(dia)
) comment "Es una agenda, se declara solamente que pertenece a un día";

create table agenda_en_departamento(
	id_agenda bigint unsigned not null,
    id_departamento bigint unsigned not null,
    hora_inicio time not null comment "La hora en que se puede comenzar a establecer citas",
    hora_fin time not null comment "La hora en que se permite agendar la última cita",
    constraint pk_agenda_departamento primary key(id_agenda,id_departamento),
    constraint fk_id_agenda_agenda_en_departamento foreign key (id_agenda) references agenda(id),
    constraint fk_id_departamento foreign key(id_departamento) references departamento(id)
) comment "Una agenda cambia respecto a cada departamento, puede cambiar su hora de inicio y de fin; algunos días pueden cambiar también su horario";



create table turno(
	id bigint unsigned not null auto_increment,
    descripcion varchar(30) not null,
    hora_inicio time not null,
    hora_fin time not null,
    primary key(id),
    constraint uq_descripcion unique (descripcion)
);


create table recepcionista(
	id bigint unsigned not null auto_increment,
    id_usuario bigint unsigned not null,
    primer_nombre varchar(20) not null,
    segundo_nombre varchar(20) not null default "",
    apellido_paterno varchar(20) not null,
    apellido_materno varchar(20) not null,
	sexo enum('H','M') not null,
    fecha_nacimiento date not null,
    constraint pk_id primary key (id),
    constraint fk_idUsuario_recepcionista foreign key (id_usuario) references usuario(id)
) comment "Se usa esta tabla para almacenar el dato de la persona que agendó x cita";

create table recepcionista_departamento(
	id_recepcionista bigint unsigned not null,
    id_departamento bigint unsigned not null,
    activo boolean default true not null,
    primary key(id_recepcionista,id_departamento),
    foreign key(id_recepcionista) references recepcionista (id),
    foreign key(id_departamento) references departamento (id)
);

create table corte(
	id bigint unsigned not null auto_increment,
    id_turno bigint unsigned not null,
    id_recepcionista_responsable bigint unsigned not null,
    dia date not null,
    fondo_caja double not null,
    primary key(id),
    foreign key id_turno_corte (id_turno) references turno(id),
    constraint uq_corte unique (id_turno, dia, id_recepcionista_responsable),
    foreign key id_recepcionista_corte (id_recepcionista_responsable) references recepcionista (id)
);

create table movimiento(
	id bigint unsigned not null,
    id_corte bigint unsigned not null,
    cantidad double not null,
    descripcion varchar(60) not null,
    hora time not null,
    entrada boolean not null comment "Si está en cierto el movimiento es una entrada, en falso es salida",
    primary key(id),
    foreign key(id_corte) references corte(id)
);

create table ticket(
	id bigint unsigned not null auto_increment,
	id_datos_facturacion bigint unsigned not null comment "Un ticket es pagado solo por una persona, que puede ser o no quien se realice los estudios",
    fecha date not null comment "La fecha de creación",
    hora time not null,
    requiere_factura boolean not null default false comment "Si requiere factura poner en true, por defecto es false",
    estado char(1) not null comment "Por ejemplo; 0 = pendiente, 1 = pagado, 2 = cancelado, 3 = cortesia",
    total double not null default 0,
    constraint pk_id primary key (id),
	index (fecha),
    constraint fk_id_datos_facturacion_ticket foreign key(id_datos_facturacion) references datos_facturacion (id)
)comment "Es un conjunto de estudios";

create table concepto(
	id bigint unsigned not null auto_increment,
    id_departamento bigint unsigned not null,
    detalle varchar (100) not null comment "Descripcion general, ejemplo: rx columna lumbar", 
	costo double not null comment "Cúanto cuesta producirlo?",
    constraint pk_id primary key (id),
    constraint fk_id_departamento_estudio foreign key (id_departamento) references departamento(id),
    constraint uq_detalle_por_departamento unique (id_departamento, detalle)
)comment "Es un estudio dentro de un departamento, por ejempo: tac de torax";

create table item(
	id bigint unsigned not null auto_increment,
    id_concepto bigint unsigned not null,
	id_categoria bigint unsigned not null,
    precio_venta double not null comment "El precio final del estudio, varía respecto a cada categoría",
    activo boolean not null default true comment "Por si se desea dejar de vender ese estudio temporalmente en x convencio",
    constraint fk_id_categoria_concepto_categoria foreign key (id_categoria) references categoria(id),
    constraint fk_id_concepto foreign key (id_concepto) references concepto(id),
    constraint pk_categoria primary key (id),
    constraint uq_concepto_en_categoria unique(id_concepto, id_categoria) #Se da por hecho que solo puede existir una tac de torax de pensiones, por ejemplo
)comment "Relaciona conceptos con categorías para habilitar que un mismo estudio pertenezca a particular, pensiones...";

create table pago_ticket(
	id_ticket bigint unsigned not null,
    id_forma_pago bigint unsigned not null,
    cantidad double not null comment "Qué cantidad del total se paga con esa forma de pago",
    constraint pk_ticket_pagado primary key(id_ticket, id_forma_pago),
    constraint fk_id_ticket_pago_ticket foreign key(id_ticket) references ticket(id),
    constraint fk_id_forma_pago_pago_pago_ticket foreign key(id_forma_pago) references forma_pago(id)
)comment "Debido a que un ticket se puede pagar con varias formas de pago, esta tabla registra los pagos parciales";

create table medico_radiologo(
	id bigint unsigned not null auto_increment,
    id_usuario bigint unsigned not null,
    primer_nombre varchar(20) not null,
    segundo_nombre varchar(20) not null default "",
    apellido_paterno varchar(20) not null,
    apellido_materno varchar(20) not null,
    sexo enum('H','M') not null comment "Lista para curp H=hombre M=mujer",
    firma varchar(20) not null,
    especialidad varchar(50) not null default "", 
    cedula_federal varchar(20) not null default "", 
    cedula_estatal varchar(20) not null default "", 
    constraint pk_id primary key (id),
    constraint fk_idUsuario_medico_radiologo foreign key (id_usuario) references usuario(id),
    constraint uq_cedula_federal unique (cedula_federal),
    constraint uq_cedula_estatal unique (cedula_estatal)
)comment "Almacenamiento de los médicos que interpretan";

#Se puede crear uno por defecto para cuando un técnico aún no haya tomado un estudio
create table tecnico(
	id bigint unsigned not null auto_increment,
    id_usuario bigint unsigned not null,
    primer_nombre varchar(20) not null,
    segundo_nombre varchar(20) not null default "",
    apellido_paterno varchar(20) not null,
    apellido_materno varchar(20) not null,
    sexo enum('H','M') not null comment "Lista para curp H=hombre M=mujer",
    constraint pk_id primary key (id),
    constraint fk_idUsuario_tecnico foreign key (id_usuario) references usuario(id)
)comment "Datos del técnico que toma un estudio";

create table estudio(
	id bigint unsigned not null auto_increment,
	id_item bigint unsigned not null comment "Referencia a un estudio en cierta categoría: tac de abdomen de particular",
    id_persona bigint unsigned not null comment "La persona que se va a tomar el estudio, puede ser quien pagó o no",
    id_ticket bigint unsigned not null comment "Todo estudio pertenece a un conjunto de estudios, aunque sea solo uno",
    id_tecnico bigint unsigned not null default 1 comment "Referencia al técnico que tomará el etudio",
	dicom_id varchar(50) not null comment "Id del estudio para mostrar en visor, obtenido del pacs",
    fecha date not null,
	interpretado boolean not null default false,
    tomado boolean not null default false,
    prioridad char(1) not null default 0 comment  "Por ejemplo: 0=normal, 1=media, 2=alta, 3=urgente",
    clave varchar(50) not null comment "La clave exterior para evitar que desde afuera accedan a estudios que no se debería",
    precio_venta double not null default 0 comment "Es para que se quede el precio congelado en el tiempo, copia automáticamente de item",
    constraint pk_id primary key(id),
    constraint uq_clave_estudio unique (clave),
    index (fecha),
    constraint fk_id_tecnico_estudio  foreign key(id_tecnico) references tecnico(id),
    constraint fk_id_persona_estudio foreign key(id_persona) references persona(id),
    constraint fk_id_ticket_estudio foreign key(id_ticket) references ticket(id),
    constraint fk_id_item_estudio foreign key(id_item) references item(id)
)comment "Es la tabla principal";

create table foto_estudio(
	id bigint unsigned not null auto_increment,
    id_estudio bigint unsigned not null,
    ruta varchar(40) not null,
    constraint pk_id primary key (id),
    constraint fk_id_estudio_foto_estudio foreign key (id_estudio) references estudio(id)
)comment "Detalle de cada estudio en particular, puede ser una orden única o una foto del proceso";

create table foto_ticket(
	id bigint unsigned not null auto_increment,
    id_ticket bigint unsigned not null,
    ruta varchar(40) not null,
    constraint pk_id primary key (id),
    constraint fk_id_ticket_foto_ticket foreign key (id_ticket) references ticket(id)
)comment "Se puede guardar la ruta de la foto de la orden, conviene en esta tabla ya que se guardaría aquí una sola foto por conjunto de estudios";

create table dictamen(
	id bigint unsigned not null,
    id_medico_radiologo bigint unsigned not null,
    id_estudio bigint unsigned not null,
    fecha date not null,
    interpretacion mediumtext not null comment "16.777.215 caracteres",
    constraint pk_id primary key(id),
    index (fecha),
    constraint fk_id_medico_radiologo_dictamen foreign key (id_medico_radiologo) references medico_radiologo(id),
    constraint fk_id_estudio_dictamen foreign key (id_estudio) references estudio(id)
)comment "Es el cuerpo de una interpretación";


create table cita(
	id bigint unsigned not null,
    id_agenda bigint unsigned not null,
    id_estudio bigint unsigned not null,
    id_recepcionista bigint unsigned not null,
    id_departamento bigint unsigned not null,
    hora time not null comment "La hora en que se asigna la cita",
    estado char(1) not null comment "Puede ser 0=agendado, 1=confirmado, 2=llegó la persona, 3=finalizado, 4=cancelado",
    constraint pk_id primary key (id),
    constraint fk_id_agenda_en_departamento_cita foreign key (id_agenda) references agenda(id),
    constraint fk_id_estudio_cita foreign key (id_estudio) references estudio(id),
    constraint fk_id_recepcionista foreign key(id_recepcionista) references recepcionista(id),
    constraint fk_id_departamento_cita foreign key(id_departamento) references departamento(id),
    constraint uq_cita unique (id_agenda,id_departamento, hora)
) comment "Se relaciona un estudio que ya pertence a una persona y trae todos los datos con una agenda";

create table permiso(
	id bigint unsigned not null,
    permiso varchar(30) not null,
    primary key (id)
);


insert into permiso values
(1, "a ser joto"),(2, "a estar todo meco")
;
create table permiso_usuario(
	id_usuario bigint unsigned not null,
    id_permiso bigint unsigned not null,
    foreign key (id_usuario) references usuario(id),
    foreign key(id_permiso) references permiso(id)
) comment "Vincula un permiso con un usuario, si un registro existe aquí significa que el usuario tiene ese permiso";

create table plantilla_permisos_tipo_usuario(
	id_tipo_usuario bigint unsigned not null,
    id_permiso bigint unsigned not null,
    foreign key (id_tipo_usuario) references tipo_usuario(id),
    foreign key(id_permiso) references permiso(id)
) comment "Vincula un permiso con un usuario, si un registro existe aquí significa que el usuario tiene ese permiso";
