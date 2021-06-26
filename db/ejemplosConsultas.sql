use super_ris;

#TRAER LOS ESTUDIOS A LOS QUE PERTENECE UN TICKET
SET @ID_TICKET = 1;
select * from estudio 
JOIN item on estudio.idItem=item.id
JOIN concepto on item.idConcepto = concepto.id
JOIN categoria on item.idCategoria = categoria.id
JOIN persona on persona.id = estudio.idPersona
where idTicket = @ID_TICKET;

#MOSTRAR LOS ESTUDIOS QUE SE HA TOMADO UN CLIENTE
SET @ID_PERSONA = 1;
select * from estudio 
JOIN item on estudio.idItem=item.id
JOIN concepto on item.idConcepto = concepto.id
JOIN categoria on item.idCategoria = categoria.id
JOIN persona on persona.id = estudio.idPersona
where idPersona = @ID_PERSONA;

#MOSTRAR LOS ESTUDIOS DE UNA CATEGORÍA DADA
SET @ID_CATEGORIA = 1;
SELECT * FROM item
JOIN concepto on item.idConcepto = concepto.id
WHERE idCategoria = @ID_CATEGORIA;

#MOSTRAR LAS INTERPRETACIONES DE UNA PERSONA 
SET @ID_PACIENTE=1;
select * from dictamen
join estudio on dictamen.idEstudio = estudio.id
join persona on persona.id = estudio.idPersona
join item on estudio.idItem=item.id
join concepto on item.idConcepto=concepto.id
WHERE persona.id=@ID_PACIENTE;

#MOSTRAR LOS ESTUDIOS QUE TIENE QUE INTERPRETAR X RADIÓLOGO
SET @ID_RADIOLOGO=1;
select * from dictamen
join estudio on dictamen.idEstudio = estudio.id
join persona on persona.id = estudio.idPersona
join item on estudio.idItem=item.id
join concepto on item.idConcepto=concepto.id
join medicoRadiologo on dictamen.idMedicoRadiologo = medicoRadiologo.id
WHERE medicoRadiologo.id=@ID_RADIOLOGO;

#MOSTRAR LOS ESTUDIOS QUE PERTENECEN A X TÉCNICO
SET @ID_TECNICO=2;
SET @FECHA="2021/06/01";
SELECT * from estudio where idTecnico = @ID_TECNICO and fecha = @FECHA;

#MOSTRAR LOS ESTUDIOS QUE HAY QUE HACER EN X DÍA
SET @FECHA="2021/06/01";
SELECT * from estudio where fecha = @FECHA and haSidoTomado = 0;

#MOSTRAR LAS CITAS AGENDADAS EN UNA FECHA EN UN DEPARTAMENTO
SET @FECHA="2021/06/01";
SET @ID_DEPARTAMENTO = 1;

select * from cita 
join departamento on idDepartamento = departamento.id
join agenda on idAgenda = agenda.id
JOIN agendaEnDepartamento on agenda.id = agendaEnDepartamento.idAgenda and agendaEnDepartamento.idDepartamento =departamento.id
where agenda.dia = @FECHA and departamento.id= @ID_DEPARTAMENTO;

#MOSTRAR LOS ESTUDIOS QUE HAN SIDO PAGADOS POR X CONVENIO
SET @ID_CONVENIO = 1;
select * from estudio 
join item on estudio.idItem = item.id
join categoria on categoria.id = item.idCategoria
join convenio on convenio.idCategoria = categoria.id
where convenio.id = @ID_CONVENIO; 