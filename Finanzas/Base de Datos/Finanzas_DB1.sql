CREATE SCHEMA IF NOT EXISTS `finanzas_db1` DEFAULT CHARACTER SET utf8 ;
USE `finanzas_db1` ;

-- -----------------------------------------------------
-- Table `finanzas_db1`.`moneda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finanzas_db1`.`moneda` (
  `Codigo_Moneda` VARCHAR(100) NOT NULL,
  `Nombre_Moneda` VARCHAR(100) NOT NULL,
  `Simbolo_Moneda` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`Codigo_Moneda`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `finanzas_db1`.`encabezadoasientocontable`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finanzas_db1`.`encabezadoasientocontable` (
  `Codigo_EncabezadoAsiento` VARCHAR(100) NOT NULL,
  `Fecha_AsientoContable` VARCHAR(100) NOT NULL,
  `Moneda_Asiento` VARCHAR(100) NOT NULL,
  `Descripcion_Asiento` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`Codigo_EncabezadoAsiento`),
  CONSTRAINT `fk_encabezadoasientocontable_moneda1`
    FOREIGN KEY (`Moneda_Asiento`)
    REFERENCES `finanzas_db1`.`moneda` (`Codigo_Moneda`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `finanzas_db1`.`tipo_asiento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finanzas_db1`.`tipo_asiento` (
  `Codigo_TipoAsiento` VARCHAR(100) NOT NULL,
  `Tipo_AsientoDesc` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`Codigo_TipoAsiento`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `finanzas_db1`.`clasificacioncuenta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finanzas_db1`.`clasificacioncuenta` (
  `Codigo_clasificacion` VARCHAR(100) NOT NULL,
  `Clasificacion_CuentaNombre` VARCHAR(100) NULL DEFAULT NULL,
  `Descripcion_Clasificacion` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`Codigo_clasificacion`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `finanzas_db1`.`cuentacontable`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finanzas_db1`.`cuentacontable` (
  `Codigo_CuentaContable` VARCHAR(100) NOT NULL,
  `Nombre_CuentaContable` VARCHAR(100) NULL DEFAULT NULL,
  `Clasificacion_CuentaContable` VARCHAR(100) NULL DEFAULT NULL,
  `Estado_CuentaContable` VARCHAR(100) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `Monto_CuentaContable` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`Codigo_CuentaContable`),
  CONSTRAINT `fk_cuentacontable_clasificacioncuenta1`
    FOREIGN KEY (`Clasificacion_CuentaContable`)
    REFERENCES `finanzas_db1`.`clasificacioncuenta` (`Codigo_clasificacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `finanzas_db1`.`periodofiscal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finanzas_db1`.`periodofiscal` (
  `Codigo_PeriodoFiscal` VARCHAR(100) NOT NULL,
  `Fecha_inicioPF` VARCHAR(100) NOT NULL,
  `Fecha_finPF` VARCHAR(100) NOT NULL,
  `Estado_PeriodoFiscal` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`Codigo_PeriodoFiscal`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `finanzas_db1`.`partidacontable`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finanzas_db1`.`partidacontable` (
  `Codigo_PartidaContable` VARCHAR(100) NOT NULL,
  `Fecha_PartidaContable` VARCHAR(100) NOT NULL,
  `Periodo_FiscalPartida` VARCHAR(100) NOT NULL,
  `Glosa_PartidaContable` VARCHAR(100) NOT NULL,
  `Monto_DeCuadre` VARCHAR(100) CHARACTER SET 'utf8' NOT NULL,
  PRIMARY KEY (`Codigo_PartidaContable`),
  CONSTRAINT `fk_partidacontable_periodofiscal1`
    FOREIGN KEY (`Periodo_FiscalPartida`)
    REFERENCES `finanzas_db1`.`periodofiscal` (`Codigo_PeriodoFiscal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `finanzas_db1`.`asientocontabledetalle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finanzas_db1`.`asientocontabledetalle` (
  `Codigo_DetalleAsiento` VARCHAR(100) NOT NULL,
  `CuentaContable_Asiento` VARCHAR(100) NOT NULL,
  `Partida_Asiento` VARCHAR(100) NOT NULL,
  `Encabezado_Asiento` VARCHAR(100) NOT NULL,
  `Tipo_Asiento` VARCHAR(100) NOT NULL,
  `Monto_Debe` VARCHAR(100) NOT NULL,
  `Monto_Haber` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`Codigo_DetalleAsiento`),
  CONSTRAINT `asientocontabledetalle_ibfk_1`
    FOREIGN KEY (`Encabezado_Asiento`)
    REFERENCES `finanzas_db1`.`encabezadoasientocontable` (`Codigo_EncabezadoAsiento`),
  CONSTRAINT `fk_asientocontabledetalle_tipo_asiento1`
    FOREIGN KEY (`Tipo_Asiento`)
    REFERENCES `finanzas_db1`.`tipo_asiento` (`Codigo_TipoAsiento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_asientocontabledetalle_cuentacontable1`
    FOREIGN KEY (`CuentaContable_Asiento`)
    REFERENCES `finanzas_db1`.`cuentacontable` (`Codigo_CuentaContable`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_asientocontabledetalle_partidacontable1`
    FOREIGN KEY (`Partida_Asiento`)
    REFERENCES `finanzas_db1`.`partidacontable` (`Codigo_PartidaContable`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `finanzas_db1`.`banco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finanzas_db1`.`banco` (
  `Codigo_Banco` VARCHAR(100) NOT NULL,
  `Nombre_Banco` VARCHAR(100) NOT NULL,
  `Clave_Banco` VARCHAR(100) NOT NULL,
  `Telefono_Banco` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`Codigo_Banco`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `finanzas_db1`.`tipopersona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finanzas_db1`.`tipopersona` (
  `Codigo_TipoPersona` VARCHAR(100) NOT NULL,
  `TipoPersona_Nombres` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`Codigo_TipoPersona`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `finanzas_db1`.`cuentahabiente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finanzas_db1`.`cuentahabiente` (
  `Codigo_CuentaHabiente` VARCHAR(100) NOT NULL,
  `Nombre_CuentaHabiente` VARCHAR(100) NOT NULL,
  `ApellidoP_CuentaHabiente` VARCHAR(100) NOT NULL,
  `ApellidoM_CuentaHabiente` VARCHAR(100) NOT NULL,
  `TipoPersona_CuentaHabiente` VARCHAR(100) NOT NULL,
  `Saldo_Habilitado` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`Codigo_CuentaHabiente`),
  CONSTRAINT `fk_cuentahabiente_tipopersona1`
    FOREIGN KEY (`TipoPersona_CuentaHabiente`)
    REFERENCES `finanzas_db1`.`tipopersona` (`Codigo_TipoPersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `finanzas_db1`.`cuentabancaria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finanzas_db1`.`cuentabancaria` (
  `Numero_CuentaBancaria` VARCHAR(100) NOT NULL,
  `Moneda_Cuenta` VARCHAR(100) NOT NULL,
  `CuentaHabiente_Cuenta` VARCHAR(100) NOT NULL,
  `Banco_Cuenta` VARCHAR(100) NOT NULL,
  `Saldo_Cuenta` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`Numero_CuentaBancaria`),
  CONSTRAINT `fk_cuentabancaria_cuentahabiente1`
    FOREIGN KEY (`CuentaHabiente_Cuenta`)
    REFERENCES `finanzas_db1`.`cuentahabiente` (`Codigo_CuentaHabiente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cuentabancaria_moneda1`
    FOREIGN KEY (`Moneda_Cuenta`)
    REFERENCES `finanzas_db1`.`moneda` (`Codigo_Moneda`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cuentabancaria_banco1`
    FOREIGN KEY (`Banco_Cuenta`)
    REFERENCES `finanzas_db1`.`banco` (`Codigo_Banco`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `finanzas_db1`.`cheque`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finanzas_db1`.`cheque` (
  `Numero_Cheque` VARCHAR(255) NOT NULL,
  `Fecha_Cheque` VARCHAR(255) NOT NULL,
  `FK_Banco` VARCHAR(255) NOT NULL,
  `FK_Cuenta` VARCHAR(255) NOT NULL,
  `FK_Cuentahabiente` VARCHAR(255) NOT NULL,
  `Monto_Cheque` FLOAT NOT NULL,
  PRIMARY KEY (`Numero_Cheque`),
  CONSTRAINT `fk_cheque_banco1`
    FOREIGN KEY (`FK_Banco`)
    REFERENCES `finanzas_db1`.`banco` (`Codigo_Banco`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cheque_cuentabancaria1`
    FOREIGN KEY (`FK_Cuenta`)
    REFERENCES `finanzas_db1`.`cuentabancaria` (`Numero_CuentaBancaria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cheque_cuentahabiente1`
    FOREIGN KEY (`FK_Cuentahabiente`)
    REFERENCES `finanzas_db1`.`cuentahabiente` (`Codigo_CuentaHabiente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `finanzas_db1`.`deposito`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finanzas_db1`.`deposito` (
  `Codigo_CuentaHabiente` VARCHAR(100) NOT NULL,
  `Balance` VARCHAR(100) NOT NULL,
  `Transaccion` VARCHAR(100) NOT NULL,
  `fecha` VARCHAR(100) NOT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `finanzas_db1`.`tipotransaccion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finanzas_db1`.`tipotransaccion` (
  `Codigo_TipoTransaccion` VARCHAR(100) NOT NULL,
  `Transaccion_Tipo` VARCHAR(100) NOT NULL,
  `Efecto_TipoTransaccion` INT(11) NOT NULL,
  PRIMARY KEY (`Codigo_TipoTransaccion`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `finanzas_db1`.`transaccionbancaria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finanzas_db1`.`transaccionbancaria` (
  `Codigo_Transaccion` VARCHAR(100) NOT NULL,
  `Fecha_Transaccion` VARCHAR(100) NOT NULL,
  `Beneficiario` VARCHAR(100) NOT NULL,
  `Cuenta_Bancaria` VARCHAR(100) NOT NULL,
  `Tipo_Transaccion` VARCHAR(100) NOT NULL,
  `Monto_Transaccion` VARCHAR(100) NOT NULL,
  `Concepto_Transaccion` VARCHAR(100) NOT NULL,
  CONSTRAINT `fk_transaccionbancaria_tipotransaccion1`
    FOREIGN KEY (`Tipo_Transaccion`)
    REFERENCES `finanzas_db1`.`tipotransaccion` (`Codigo_TipoTransaccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_transaccionbancaria_cuentabancaria1`
    FOREIGN KEY (`Cuenta_Bancaria`)
    REFERENCES `finanzas_db1`.`cuentabancaria` (`Numero_CuentaBancaria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE departamento
(id_departamento Varchar(10) Primary Key,
nombre_departamento Varchar(60) Not Null,
estado_departamento Varchar(1) Not Null
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE puesto
(id_puesto Varchar(10) Primary Key,
nombre_puesto Varchar(60) Not Null,
estado_puesto Varchar(1) Not Null
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE empleado
(carnet_empleado Varchar(15) Primary Key,
dpi_empleado Varchar(15) Not Null Unique,
nombre_empleado Varchar(75) Not Null,
apellidos_empleado Varchar(75) Not Null,
domicilio_empleado Varchar(50) Not Null,
telefono_empleado int(8) Not Null,
celular_empleado int(8) Not Null,
fecha_nacimiento date Not Null,
estatus_empleado Varchar(1) Not Null,
fk_puesto Varchar(10) not null,
fk_departamento Varchar(10) not null,
sueldo_base float(10,2) not null,
FOREIGN KEY (fk_puesto) REFERENCES puesto(id_puesto),
FOREIGN KEY (fk_departamento) REFERENCES departamento(id_departamento)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE concepto
(id_concepto Varchar(10) Primary Key,
nombre_concepto Varchar(40) Not Null,
efecto_concepto Varchar(10) Not Null
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE nomina
(id_nomina Varchar(20) Primary Key,
fecha_inicio date Not Null,
fecha_fin date Not Null
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE nomina_empleado
(id_nomEmp Varchar(15) Primary Key,
fk_empleado Varchar(15) Not Null,
fk_nomina Varchar(20) Not Null
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE detalle_nomina
(id_detalle Varchar(15) Primary Key,
fk_nominae Varchar(15) Not Null,
fk_concepto Varchar(10) Not Null,
valor_concepto float(10,2) Not Null
)ENGINE=InnoDB DEFAULT CHARSET=latin1;


ALTER TABLE nomina_empleado
ADD CONSTRAINT fk_nomina
FOREIGN KEY (fk_nomina) REFERENCES nomina(id_nomina);

ALTER TABLE nomina_empleado
ADD CONSTRAINT fk_empleado
FOREIGN KEY (fk_empleado) REFERENCES empleado(carnet_empleado);

ALTER TABLE detalle_nomina
ADD CONSTRAINT fk_concepto
FOREIGN KEY (fk_concepto) REFERENCES concepto(id_concepto);

ALTER TABLE detalle_nomina
ADD CONSTRAINT fk_nominae
FOREIGN KEY (fk_nominae) REFERENCES nomina_empleado(id_nomEmp);

ALTER TABLE nomina_empleado
ADD CONSTRAINT fk_nominaemp
FOREIGN KEY (fk_nomina) REFERENCES nomina(id_nomina);

ALTER TABLE detalle_nomina
MODIFY COLUMN id_detalle int auto_increment;

CREATE TABLE impresion_nomina
(id_impresion int auto_increment primary key,
fk_nomEmp varchar(15) not null,
ingresos_totales float(10,2) not null,
egresos_totales float(10,2) not null,
total_liquido float(10,2) not null
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

ALTER TABLE impresion_nomina
ADD CONSTRAINT fk_nomEmp
FOREIGN KEY (fk_nomEmp) REFERENCES nomina_empleado(id_nomEmp);

-- ----- SEGURIDAD --------------
CREATE TABLE `tbl_aplicacion` (
  `PK_id_aplicacion` int(11) NOT NULL,
  `nombre_aplicacion` varchar(45) DEFAULT NULL,
  `descripcion_aplicacion` varchar(200) DEFAULT NULL,
  `no_reporteAsociado` int(11) DEFAULT NULL,
  `estado_aplicacion` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tbl_aplicacion_a_modulos` (
  `PK_id_modulo` int(25) NOT NULL,
  `PK_id_aplicacion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tbl_bitacora` (
  `PK_id_bitacora` int(11) NOT NULL,
  `PK_id_usuario` varchar(25) NOT NULL,
  `fecha` varchar(25) DEFAULT NULL,
  `hora` varchar(25) DEFAULT NULL,
  `host1` varchar(45) DEFAULT NULL,
  `ip` varchar(25) DEFAULT NULL,
  `accion` varchar(50) DEFAULT NULL,
  `tabla` varchar(45) DEFAULT NULL,
  `PK_id_Modulo` int(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tbl_modulo` (
  `PK_id_Modulo` int(11) NOT NULL,
  `nombre_modulo` varchar(45) DEFAULT NULL,
  `descripcion_modulo` varchar(200) DEFAULT NULL,
  `estado_modulo` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `tbl_perfil_detalle` (
  `PK_id_perfil` int(11) NOT NULL,
  `PK_id_aplicacion` int(11) NOT NULL,
  `ingresar` tinyint(4) DEFAULT NULL,
  `consultar` tinyint(4) DEFAULT NULL,
  `modificar` tinyint(4) DEFAULT NULL,
  `eliminar` tinyint(4) DEFAULT NULL,
  `imprimir` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tbl_perfil_encabezado` (
  `PK_id_perfil` int(11) NOT NULL,
  `nombre_perfil` varchar(45) DEFAULT NULL,
  `descripcion_perfil` varchar(200) DEFAULT NULL,
  `estado_perfil` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tbl_usuario` (
  `PK_id_usuario` varchar(25) NOT NULL,
  `nombre_usuario` varchar(45) DEFAULT NULL,
  `apellido_usuario` varchar(45) DEFAULT NULL,
  `username_usuario` varchar(45) DEFAULT NULL,
  `password_usuario` varchar(45) DEFAULT NULL,
  `correo_usuario` varchar(45) DEFAULT NULL,
  `cambio_password` tinyint(4) DEFAULT NULL,
  `estado_usuario` tinyint(4) DEFAULT NULL,
  `ultima_conexion` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tbl_usuario_aplicacion` (
  `PK_id_usuario` varchar(25) NOT NULL,
  `PK_id_aplicacion` int(11) NOT NULL,
  `ingresar` tinyint(4) DEFAULT NULL,
  `consulta` tinyint(4) DEFAULT NULL,
  `modificar` tinyint(4) DEFAULT NULL,
  `eliminar` tinyint(4) DEFAULT NULL,
  `imprimir` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tbl_usuario_perfil` (
  `PK_id_usuario` varchar(25) NOT NULL,
  `PK_id_perfil` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `tbl_aplicacion`
  ADD PRIMARY KEY (`PK_id_aplicacion`);

--
-- Indices de la tabla `tbl_aplicacion_a_modulos`
--
ALTER TABLE `tbl_aplicacion_a_modulos`
  ADD PRIMARY KEY (`PK_id_modulo`,`PK_id_aplicacion`),
  ADD KEY `fk_tbl_aplicacion_a_modulos_aplicacion1` (`PK_id_aplicacion`);

--
-- Indices de la tabla `tbl_bitacora`
--
ALTER TABLE `tbl_bitacora`
  ADD PRIMARY KEY (`PK_id_bitacora`),
  ADD KEY `fk_PK_id_Modulo` (`PK_id_Modulo`);

--
-- Indices de la tabla `tbl_modulo`
--
ALTER TABLE `tbl_modulo`
  ADD PRIMARY KEY (`PK_id_Modulo`);

--
-- Indices de la tabla `tbl_perfil_detalle`
--
ALTER TABLE `tbl_perfil_detalle`
  ADD PRIMARY KEY (`PK_id_perfil`,`PK_id_aplicacion`),
  ADD KEY `fk_Perfil_detalle_Aplicacion1` (`PK_id_aplicacion`);

--
-- Indices de la tabla `tbl_perfil_encabezado`
--
ALTER TABLE `tbl_perfil_encabezado`
  ADD PRIMARY KEY (`PK_id_perfil`);

--
-- Indices de la tabla `tbl_usuario`
--
ALTER TABLE `tbl_usuario`
  ADD PRIMARY KEY (`PK_id_usuario`);

--
-- Indices de la tabla `tbl_usuario_aplicacion`
--
ALTER TABLE `tbl_usuario_aplicacion`
  ADD PRIMARY KEY (`PK_id_usuario`,`PK_id_aplicacion`),
  ADD KEY `fk_tbl_usuario_aplicacion_tbl_aplicacion1` (`PK_id_aplicacion`);

--
-- Indices de la tabla `tbl_usuario_perfil`
--
ALTER TABLE `tbl_usuario_perfil`
  ADD PRIMARY KEY (`PK_id_usuario`,`PK_id_perfil`),
  ADD KEY `fk_Usuario_perfil_Perfil1` (`PK_id_perfil`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tbl_bitacora`
--
ALTER TABLE `tbl_bitacora`
  MODIFY `PK_id_bitacora` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=132;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tbl_aplicacion_a_modulos`
--
ALTER TABLE `tbl_aplicacion_a_modulos`
  ADD CONSTRAINT `fk_tbl_aplicacion_a_modulos_aplicacion1` FOREIGN KEY (`PK_id_aplicacion`) REFERENCES `tbl_aplicacion` (`PK_id_aplicacion`),
  ADD CONSTRAINT `fk_tbl_aplicacion_a_modulos_modulo` FOREIGN KEY (`PK_id_modulo`) REFERENCES `tbl_modulo` (`PK_id_Modulo`);

--
-- Filtros para la tabla `tbl_bitacora`
--
ALTER TABLE `tbl_bitacora`
  ADD CONSTRAINT `fk_PK_id_Modulo` FOREIGN KEY (`PK_id_Modulo`) REFERENCES `tbl_modulo` (`PK_id_Modulo`);

--
-- Filtros para la tabla `tbl_perfil_detalle`
--
ALTER TABLE `tbl_perfil_detalle`
  ADD CONSTRAINT `fk_Perfil_detalle_Aplicacion1` FOREIGN KEY (`PK_id_aplicacion`) REFERENCES `tbl_aplicacion` (`PK_id_aplicacion`),
  ADD CONSTRAINT `fk_Perfil_detalle_Perfil1` FOREIGN KEY (`PK_id_perfil`) REFERENCES `tbl_perfil_encabezado` (`PK_id_perfil`);

--
-- Filtros para la tabla `tbl_usuario_aplicacion`
--
ALTER TABLE `tbl_usuario_aplicacion`
  ADD CONSTRAINT `fk_Usuario_aplicacion_Usuario1` FOREIGN KEY (`PK_id_usuario`) REFERENCES `tbl_usuario` (`PK_id_usuario`),
  ADD CONSTRAINT `fk_tbl_usuario_aplicacion_tbl_aplicacion1` FOREIGN KEY (`PK_id_aplicacion`) REFERENCES `tbl_aplicacion` (`PK_id_aplicacion`);

--
-- Filtros para la tabla `tbl_usuario_perfil`
--
ALTER TABLE `tbl_usuario_perfil`
  ADD CONSTRAINT `fk_Usuario_perfil_Perfil1` FOREIGN KEY (`PK_id_perfil`) REFERENCES `tbl_perfil_encabezado` (`PK_id_perfil`),
  ADD CONSTRAINT `fk_Usuario_perfil_Usuario1` FOREIGN KEY (`PK_id_usuario`) REFERENCES `tbl_usuario` (`PK_id_usuario`);