drop database if exists super_ris;

create database if not exists super_ris;

use super_ris;

create table forma_pago(
	id int unsigned not null auto_increment,
    descripcion varchar(20) not null,
    constraint pk_id primary key (id)
)comment "Se refiere a las formas de pago admitidas como efectivo, crédito, débito..."
;

insert into forma_pago values(0, "efectivo");

create table departamento (
	id int unsigned not null auto_increment,
    nombre varchar(15) not null,
	duracion_minutos smallint unsigned not null default 0 comment "Para aproximar los lugares de la agenda, se da por hecho que todos los estudios del mismo tipo duran lo mismo, ejemplo: una tac 25 minutos", 
    constraint pk_id primary key (id)
)comment "Es un área del gabinete, por ejemplo, RX, TAC";

create table categoria(
	id int unsigned not null auto_increment,
	clave varchar(10) not null default "AAA000" comment "Es una clave para hacer una identificación que puede ser usada por los contadores",    
	descripcion varchar(20) not null, 
    activo boolean not null comment "Se le puede dejar de dar servicio a un convenio que no haya pagado",
    constraint pk_id primary key (id)
)comment "Se refiere a la procedencia del paciente: particular, pensiones, imss...";


CREATE TABLE `estado` (
  `id` int UNSIGNED NOT NULL,
  `nombre` varchar(40) NOT NULL COMMENT 'Nombre de la entidad',
  `abreviatura` varchar(3) NOT NULL COMMENT 'Preparada para curp',
  `activo` boolean NOT NULL DEFAULT '1'
) COMMENT='Tabla de Estados de la República Mexicana';

--
-- Volcado de datos para la tabla `estados`
--

INSERT INTO `estados` (`id`, `nombre`, `abrev`, `activo`) VALUES
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

create table datos_facturacion(
	id bigint unsigned not null,
    razon_social varchar(100) not null,
    rfc varchar(13) not null,
    cp varchar(8) not null,
    email varchar(60) not null,
    telefono varchar(13) not null,
    constraint pk_id primary key(id)
);

create table persona(
	id bigint unsigned not null,
    id_estado int unsigned not null,
    id_datos_facturacion bigint unsigned not null,
    p_id varchar(30) not null comment "El id generado para vincular con el pacs",
	nombres varchar(65) not null,
    apellidos varchar(65) not null,
    fecha_nacimiento date not null,
    sexo enum('H','M') not null comment "Lista para curp",
    rfc varchar(13) not null default "" comment "Sólo se pide si se va a facturar, de lo contrario se llena vacío",
    email varchar(40) not null default "",
    telefono varchar(15) not null default "",
    curp varchar(20) not null,
    #otros campos necesarios, estos solamente son necesarios para hacer el match
    constraint pk_id primary key(id),
    constraint fk_id_datos_facturacion_persona foreign key (id_datos_facturacion) references facturacion (id)
)comment "Es un paciente o alguien que paga un conjunto de estudios";



create table convenio(
	id bigint unsigned not null,
    id_categoria int unsigned not null,
    nombre varchar(30) not null,
    constraint pk_id primary key (id),
    constraint fk_id_categoria_convenio foreign key (id_categoria) references categoria(id)
);

create table ticket(
	id bigint unsigned not null auto_increment,
	id_datos_facturacion bigint unsigned not null comment "Un ticket es pagado solo por una persona, que puede ser o no quien se realice los estudios",
    fecha date not null comment "La fecha de creación",
    requiere_factura boolean not null default false comment "Si requiere factura poner en true, por defecto es false",
    estado char(1) not null comment "Por ejemplo; 0 = pendiente, 1 = pagado, 2 = cancelado, 3 = cortesia",
    total double not null default 0,
    constraint pk_id primary key (id),
    constraint fk_id_datos_facturacion_ticket foreign key(id_datos_facturacion) references datos_facturacion (id)
)comment "Es un conjunto de estudios";


create table concepto(
	id int unsigned not null auto_increment,
    id_departamento int unsigned not null,
    detalle varchar (100) not null comment "Descripcion general, ejemplo: rx columna lumbar", 
	costo double not null comment "Cúanto cuesta producirlo?",
    constraint pk_id primary key (id),
    constraint fk_id_departamento_estudio foreign key (id_departamento) references departamento(id)
)comment "Es un estudio dentro de un departamento, por ejempo: tac de torax";

create table item(
	id bigint unsigned not null auto_increment,
    id_concepto int unsigned not null,
	id_categoria int unsigned not null,
    precio_venta double not null comment "El precio final del estudio, varía respecto a cada categoría",
    activo boolean not null default true comment "Por si se desea dejar de vender ese estudio temporalmente en x convencio",
    constraint fk_id_categoria_concepto_categoria foreign key (id_categoria) references categoria(id),
    constraint fk_id_concepto foreign key (id_concepto) references concepto(id),
    constraint pk_categoria primary key (id)
)comment "Relaciona conceptos con categorías para habilitar que un mismo estudio pertenezca a particular, pensiones...";


create table pago_ticket(
	id_ticket bigint unsigned not null,
    id_forma_pago int unsigned not null,
    cantidad double not null comment "Qué cantidad del total se paga con esa forma de pago",
    constraint fk_id_ticket_pago_ticket foreign key(id_ticket) references ticket(id),
    constraint fk_id_forma_pago_pago_pago_ticket foreign key(id_forma_pago) references forma_pago(id)
)comment "Debido a que un ticket se puede pagar con varias formas de pago, esta tabla registra los pagos parciales";

create table medico_radiologo(
	id int unsigned not null auto_increment,
    nombres varchar(65) not null, 
    apellidos varchar(65) not null,
    firma varchar(20) not null,
    correo varchar(100) not null,
    especialidad varchar(50) not null default "", 
    cedula_federal varchar(20) not null default "", 
    cedula_estatal varchar(20) not null default "", 
    constraint pk_id primary key (id)
)comment "Almacenamiento de los médicos que interpretan";

#Se puede crear uno por defecto para cuando un técnico aún no haya tomado un estudio
create table tecnico(
	id int unsigned not null auto_increment,
    nombres varchar(65) not null,
    apellidos varchar(65) not null, 
    correo varchar(100) not null,
    constraint pk_id primary key (id)
)comment "Datos del técnico que toma un estudio";
insert into tecnico values(1, "NO ASIGNADO", "", "");

create table estudio(
	id bigint unsigned not null auto_increment,
	id_item bigint unsigned not null comment "Referencia a un estudio en cierta categoría: tac de abdomen de particular",
    id_persona bigint unsigned not null comment "La persona que se va a tomar el estudio, puede ser quien pagó o no",
    id_ticket bigint unsigned not null comment "Todo estudio pertenece a un conjunto de estudios, aunque sea solo uno",
    id_tecnico int unsigned not null default 1 comment "Referencia al técnico que tomará el etudio",
	dicom_id varchar(50) not null comment "Id del estudio para mostrar en visor, obtenido del pacs",
    fecha date not null,
	interpretado boolean not null default false,
    ha_sido_tomado boolean not null default false,
    prioridad char(1) not null default 0 comment  "Por ejemplo: 0=normal, 1=media, 2=alta, 3=urgente",
    clave varchar(50) not null comment "La clave exterior para evitar que desde afuera accedan a estudios que no se debería",
    constraint pk_id primary key(id),
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
    id_medico_radiologo int unsigned not null,
    id_estudio bigint unsigned not null,
    fecha date not null,
    interpretacion mediumtext not null comment "16.777.215 caracteres",
    constraint pk_id primary key(id),
    constraint fk_id_medico_radiologo_dictamen foreign key (id_medico_radiologo) references medico_radiologo(id),
    constraint fk_id_estudio_dictamen foreign key (id_estudio) references estudio(id)
)comment "Es el cuerpo de una interpretación";

create table agenda(
	id bigint unsigned not null auto_increment,
    dia date not null comment "Solo puede haber una agenda por día",
    constraint pk_id primary key(id),
    constraint uq_dia unique(dia)
) comment "Es una agenda, se declara solamente que pertenece a un día";

create table agenda_en_departamento(
	id_agenda bigint unsigned not null,
    id_departamento int unsigned not null,
    hora_inicio time not null comment "La hora en que se puede comenzar a establecer citas",
    hora_fin time not null comment "La hora en que se permite agendar la última cita",
    constraint fk_id_agenda_agenda_en_departamento foreign key (id_agenda) references agenda(id),
    constraint fk_id_departamento foreign key(id_departamento) references departamento(id)
) comment "Una agenda cambia respecto a cada departamento, puede cambiar su hora de inicio y de fin; algunos días pueden cambiar también su horario";

create table recepcionista(
	id int unsigned not null auto_increment,
    nombres varchar(50) not null,
    apellidos varchar(50) not null,
    fecha_nacimiento date not null,
    correo varchar(60) not null,
    telefono varchar(13) not null,
    constraint pk_id primary key (id)
) comment "Se usa esta tabla para almacenar el dato de la persona que agendó x cita";

create table cita(
	id bigint unsigned not null,
    id_agenda bigint unsigned not null,
    id_estudio bigint unsigned not null,
    id_recepcionista int unsigned not null,
    hora time not null comment "La hora en que se asigna la cita",
    estado char(1) not null comment "Puede ser 0=agendado, 1=confirmado, 2=llegó la persona, 3=finalizado, 4=cancelado",
    constraint pk_id primary key (id),
    constraint fk_id_agenda_cita foreign key (id_agenda) references agenda(id),
    constraint fk_id_estudio_cita foreign key (id_estudio) references estudio(id),
    constraint fk_id_recepcionista foreign key(id_recepcionista) references recepcionista(id)
) comment "Se relaciona un estudio que ya pertence a una persona y trae todos los datos con una agenda";
 
