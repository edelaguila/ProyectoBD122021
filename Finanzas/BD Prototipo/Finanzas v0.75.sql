SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `finanzas` DEFAULT CHARACTER SET utf8mb4 ;
USE `finanzas` ;

-- --------------------------------------------------------------- --
-- --------------------------------------------------------------- --
-- ------------------- Area de contabilidad ---------------------- --
-- --------------------------------------------------------------- --
-- --------------------------------------------------------------- --

--
-- Estructura de tabla para la tabla `cierre_registrocontable`
--

CREATE TABLE `cierre_registrocontable` (
  `Correlatiivo_DetalleRegistro` int(11) NOT NULL,
  `Glosa_Partida` varchar(128) NOT NULL,
  `Monto_Cuadre` decimal(20,8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clasificacion_cuenta`
--

CREATE TABLE `clasificacion_cuenta` (
  `Codigo_ClasificacionCuenta` int(11) NOT NULL,
  `Clasificacion_Cuenta` varchar(128) NOT NULL,
  `Observaciones_Clasificacion` varchar(128) NOT NULL,
  `Estado_Clasificacion` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuenta_contable`
--

CREATE TABLE `cuenta_contable` (
  `Codigo_CuentaContable` int(11) NOT NULL,
  `Codigo_Clasificacion` int(11) NOT NULL,
  `Correlativo_Subclasificacion` int(11) NOT NULL,
  `Estado_CuentaContable` tinyint(4) NOT NULL,
  `Monto_CuentaContable` decimal(20,2) NOT NULL,
  `Efecto_CuentaContable` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_registrocontable`
--

CREATE TABLE `detalle_registrocontable` (
  `Correlativo_Registro` int(11) NOT NULL,
  `Codigo_Encabezado` int(11) NOT NULL,
  `Codigo_CuentaContable` int(11) NOT NULL,
  `Monto_Registro` decimal(20,2) NOT NULL,
  `Lado_Monto` tinyint(4) NOT NULL,
  `Descripcion_Registro` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `divisa`
--

CREATE TABLE `divisa` (
  `Codigo_Divisa` int(11) NOT NULL,
  `Nombre_Divisa` varchar(50) NOT NULL,
  `Simbolo_Divisa` varchar(1) NOT NULL,
  `Estado_Divisa` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `encabezado_registrocontable`
--

CREATE TABLE `encabezado_registrocontable` (
  `Codigo_EncabezadoRegistro` int(11) NOT NULL,
  `Codigo_PeriodoFiscal` int(11) NOT NULL,
  `Codigo_Divisa` int(11) NOT NULL,
  `Mes_Registro` int(11) NOT NULL,
  `Descripcion_Registro` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `impuesto`
--

CREATE TABLE `impuesto` (
  `Codigo_Impuesto` int(11) NOT NULL,
  `Nombre_Impuesto` varchar(128) NOT NULL,
  `Porcentaje_Impuesto` decimal(3,3) NOT NULL,
  `Concepto_Impuesto` varchar(100) NOT NULL,
  `Estado_Impuesto` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `periodo_fiscal`
--

CREATE TABLE `periodo_fiscal` (
  `Codigo_PeriodoFiscal` int(11) NOT NULL,
  `Inicio_PeriodoFiscal` date NOT NULL,
  `Fin_PeriodoFiscal` date NOT NULL,
  `Estado_PeriodoFiscal` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `subclasificacion_cuenta`
--

CREATE TABLE `subclasificacion_cuenta` (
  `Codigo_Subclasificacion` int(11) NOT NULL,
  `Clasificacion_Cuenta` int(11) NOT NULL,
  `Subclasificacion_Cuenta` varchar(50) CHARACTER SET utf8mb4 NOT NULL,
  `Observacion_Subclasificacion` varchar(128) CHARACTER SET utf8mb4 NOT NULL,
  `Estado_Subclasificacion` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------------- --
-- --------------------------------------------------------------- --
-- ---------------------- Area de bancos ------------------------- --
-- --------------------------------------------------------------- --
-- --------------------------------------------------------------- --

/*Área de Bancos*/
create table `moneda`(
	`id_moneda` varchar(10) primary key,
    `nombre_moneda` varchar(20) not null,
    `Abreviatura` varchar(20) not null,
    `tipo_cambio` float,
    `estatus_moneda` char(1)
)engine = InnoDB default charset=utf8mb4;


create table `Documento_bancario`(
	`codigo_Documento` varchar(10) primary key,
    `nombre_Documento` varchar(50),
    `afecta` char(1),  -- + o - a la cuenta
    `estatus_documento` char(1)

) engine = InnoDB default char set=utf8mb4;

create table `mov_bancEnc`( -- solo que mov se realizo y cual es el monto 
	`id_movEnc` varchar(10) primary key,
    `codigo_Documento` varchar(10),
    `fecha` date,
    `monto` float,
    `descripcion` varchar(80),
    
    foreign key (`codigo_Documento`) references `Documento_bancario` (`codigo_Documento`)
	
) engine = InnoDB default char set=utf8mb4;

-- drop table mov_bancEnc;
-- drop table mov_bancDet;

create table `mov_bancDet`( -- cuentas involucradas y partida contable 
	`id_movEnc` varchar(10),
    `codigo_concepto` varchar(10),
    `saldo_deudor` float,
	`saldo_acreedor` float, 
    
    primary key (`id_movEnc`, `codigo_concepto`), -- clave compuesta y agruparemos por tipo de saldo 
    
    foreign key (`id_movEnc`) references `mov_bancEnc`(`id_movEnc`),
    foreign key (`codigo_concepto`) references `concepto_bancario`(`codigo_concepto`)
    
) engine = InnoDB default char set=utf8mb4;

/*create table `concepto_movimiento`(
	`id_concepto` varchar(10) primary key,
    `nombre_concepto` varchar(35), /*clientes, anticipo, cobro a clientes
    -- `tipo_concepto` varchar(50) /*cargo, abono
) engine = InnoDB default char set=latin1;*/


create table `forma_pago`(
	`id_formapago` varchar(10) primary key,
    `tipo_pago` varchar(35) /*cheque, efectivo, tarjeta, nota de credito, otro*/
) engine = InnoDB default char set=utf8mb4;

/*create table `movimientos_bancarios`(
	`id_concepto` varchar(10), -- foranea
    `fecha` date,
    `fecha_aplicacion` datetime,
    `descripcion` varchar(80),
    `estado` char(1),
    `id_formapago` varchar(10), -- foranea
	`abono` float, 
    `cargo` float,
    `saldo` float,
    
    foreign key (`id_concepto`) references `concepto_movimiento`(`id_concepto`),
    foreign key (`id_formapago`) references `forma_pago`(`id_formapago`)
) engine = InnoDB default char set=latin1;*/

-- drop table banco;
create table `banco`(
	`id_banco` varchar(10) primary key,
	`nombre_banco` varchar(50),
    `nombre_cuenta` varchar(50), /*Cuenta maestra*/
    `clave_banco` varchar(10),
    `funcionario` varchar(50),
    `telefono` int,
    `numero_plaza` int,
    `numero_sucursal` int,
    `saldo_inicial` float,
    `id_moneda` varchar(10),
    `id_movEnc` varchar(10), /*Movimientos*/
    
    foreign key (`id_moneda`) references `moneda`(`id_moneda`),
    foreign key (`id_movEnc`) references `mov_bancEnc`(`id_movEnc`)
) engine = InnoDB default char set=utf8mb4;

create table `conciliacion_bancenc`(
	`id_encabezado` varchar(10) primary key,
    `cargo_conciliar` float,
    `abono_conciliar` float,
    `saldo_corte` float,
    `cargo_conciliado` float,
    `abono_conciliado` float,
    `saldo_final` float
) engine = InnoDB default char set=utf8mb4;

create table `conciliacion_bancaria_det`(
	`id_encabezado` varchar(10), /*foranea*/
	`codigo_concepto` varchar(10), /*foranea*/
    `fecha_aplicacion` date,
    `descripcion` varchar(50),
    `id_formapago` varchar(10), /*foranea*/
    `beneficiario` varchar(35),
    `estado_conciliacion` char(1),
    `cargo` float,
    `abono` float,
    
    primary key (`id_encabezado`, `codigo_concepto`, `id_formapago`),
    
	foreign key (`codigo_concepto`) references `concepto_bancario`(`codigo_concepto`),
    foreign key(`id_formapago`) references `forma_pago` (`id_formapago`),
    foreign key(`id_encabezado`) references `conciliacion_bancenc` (`id_encabezado`)
) engine = InnoDB default char set=utf8mb4;

-- --------------------------------------------------------------- --
-- --------------------------------------------------------------- --
-- ---------------------- Area de empleados ---------------------- --
-- --------------------------------------------------------------- --
-- --------------------------------------------------------------- --

CREATE TABLE IF NOT EXISTS `finanzas`.`tbl_puesto` (
  `PK_id_puesto` INT NOT NULL AUTO_INCREMENT,
  `nombre_puesto` VARCHAR(45) NULL DEFAULT NULL,
  `salario_puesto` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`PK_id_puesto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `finanzas`.`tbl_empleado` (
  `PK_id_empleado` INT NOT NULL AUTO_INCREMENT,
  `nombre_empleado` VARCHAR(45) NULL DEFAULT NULL,
  `apellido_empleado` VARCHAR(45) NULL DEFAULT NULL,
  `dpi_empleado` VARCHAR(15) NULL DEFAULT NULL,
  `correo_empleado` VARCHAR(45) NULL DEFAULT NULL,
  `puesto_empleado` VARCHAR(15) NULL DEFAULT NULL,
  `estado_empleado` TINYINT NULL DEFAULT NULL,
  `fechacontrato_empleado` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`PK_id_empleado`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

-- --------------------------------------------------------------- --
-- --------------------------------------------------------------- --
-- ---------------------- Area de Nomina ------------------------- --
-- --------------------------------------------------------------- --
-- --------------------------------------------------------------- --

/*Área de Nómina*/
create table `concepto_planilla`(
	`id_conceptoPlanilla` varchar(10) primary key,
	`nombre_concepto` varchar(20),
	`tipo_concepto` varchar (10),
	`clase_concepto` varchar(25),
	`Valor_concepto` float
	-- aplicacion_concepto varchar(20)
) engine = InnoDB default char set=utf8mb4;

create table `planilla_enc`(
	`id_planillaenc` varchar(10) primary key,
	`total_percepcion` float,
	`total_deduccion` float,
	`total_liquido`  float
    -- id_concepto varchar(10),
    
    -- foreign key (id_concepto) references concepto_movimiento(id_concepto)
) engine = InnoDB default char set=utf8mb4;

create table `planilla_det`(
	`id_planillaDe` varchar(10),
	`id_planillaenc` varchar(10),
	`id_empleado` varchar(10),
    `id_conceptoPlanilla` varchar(10),
	`valor_conceptoDet` float,
    
    primary key (`id_planillaDe`, `id_planillaenc`, `id_empleado`, `id_conceptoPlanilla`),
    
    foreign key (`id_planillaenc`) references `planilla_enc`(`id_planillaenc`),
	foreign key(`id_conceptoPlanilla`) references `Concepto_Planilla`(`id_conceptoPlanilla`),
	foreign key(`id_empleado`) references `empleado_contratado`(`id_empleado`)
) engine = InnoDB default char set=utf8mb4;



-- --------------------------------------------------------------- --
-- --------------------------------------------------------------- --
-- ---------------------- tablas volcadas ------------------------ --
-- --------------------------------------------------------------- --
-- --------------------------------------------------------------- --


--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cierre_registrocontable`
--
ALTER TABLE `cierre_registrocontable`
  ADD KEY `fk_correlativodetalle` (`Correlatiivo_DetalleRegistro`);

--
-- Indices de la tabla `clasificacion_cuenta`
--
ALTER TABLE `clasificacion_cuenta`
  ADD PRIMARY KEY (`Codigo_ClasificacionCuenta`);

--
-- Indices de la tabla `cuenta_contable`
--
ALTER TABLE `cuenta_contable`
  ADD PRIMARY KEY (`Codigo_CuentaContable`),
  ADD KEY `fk_clasificacionct` (`Codigo_Clasificacion`),
  ADD KEY `fk_subclasificacionct` (`Correlativo_Subclasificacion`);

--
-- Indices de la tabla `detalle_registrocontable`
--
ALTER TABLE `detalle_registrocontable`
  ADD PRIMARY KEY (`Correlativo_Registro`),
  ADD KEY `fk_encabezado` (`Codigo_Encabezado`),
  ADD KEY `fk_cuentact` (`Codigo_CuentaContable`);

--
-- Indices de la tabla `divisa`
--
ALTER TABLE `divisa`
  ADD PRIMARY KEY (`Codigo_Divisa`);

--
-- Indices de la tabla `encabezado_registrocontable`
--
ALTER TABLE `encabezado_registrocontable`
  ADD PRIMARY KEY (`Codigo_EncabezadoRegistro`),
  ADD KEY `fk_periodofiscal` (`Codigo_PeriodoFiscal`),
  ADD KEY `fk_divisa` (`Codigo_Divisa`);

--
-- Indices de la tabla `impuesto`
--
ALTER TABLE `impuesto`
  ADD PRIMARY KEY (`Codigo_Impuesto`);

--
-- Indices de la tabla `periodo_fiscal`
--
ALTER TABLE `periodo_fiscal`
  ADD PRIMARY KEY (`Codigo_PeriodoFiscal`);

--
-- Indices de la tabla `subclasificacion_cuenta`
--
ALTER TABLE `subclasificacion_cuenta`
  ADD PRIMARY KEY (`Codigo_Subclasificacion`),
  ADD KEY `fk_clasificacion` (`Clasificacion_Cuenta`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `clasificacion_cuenta`
--
ALTER TABLE `clasificacion_cuenta`
  MODIFY `Codigo_ClasificacionCuenta` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `cuenta_contable`
--
ALTER TABLE `cuenta_contable`
  MODIFY `Codigo_CuentaContable` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `detalle_registrocontable`
--
ALTER TABLE `detalle_registrocontable`
  MODIFY `Correlativo_Registro` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `divisa`
--
ALTER TABLE `divisa`
  MODIFY `Codigo_Divisa` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `encabezado_registrocontable`
--
ALTER TABLE `encabezado_registrocontable`
  MODIFY `Codigo_EncabezadoRegistro` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `impuesto`
--
ALTER TABLE `impuesto`
  MODIFY `Codigo_Impuesto` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `periodo_fiscal`
--
ALTER TABLE `periodo_fiscal`
  MODIFY `Codigo_PeriodoFiscal` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `subclasificacion_cuenta`
--
ALTER TABLE `subclasificacion_cuenta`
  MODIFY `Codigo_Subclasificacion` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cierre_registrocontable`
--
ALTER TABLE `cierre_registrocontable`
  ADD CONSTRAINT `fk_correlativodetalle` FOREIGN KEY (`Correlatiivo_DetalleRegistro`) REFERENCES `detalle_registrocontable` (`Correlativo_Registro`);

--
-- Filtros para la tabla `cuenta_contable`
--
ALTER TABLE `cuenta_contable`
  ADD CONSTRAINT `fk_clasificacionct` FOREIGN KEY (`Codigo_Clasificacion`) REFERENCES `clasificacion_cuenta` (`Codigo_ClasificacionCuenta`),
  ADD CONSTRAINT `fk_subclasificacionct` FOREIGN KEY (`Correlativo_Subclasificacion`) REFERENCES `subclasificacion_cuenta` (`Codigo_Subclasificacion`);

--
-- Filtros para la tabla `detalle_registrocontable`
--
ALTER TABLE `detalle_registrocontable`
  ADD CONSTRAINT `fk_cuentact` FOREIGN KEY (`Codigo_CuentaContable`) REFERENCES `cuenta_contable` (`Codigo_CuentaContable`),
  ADD CONSTRAINT `fk_encabezado` FOREIGN KEY (`Codigo_Encabezado`) REFERENCES `encabezado_registrocontable` (`Codigo_EncabezadoRegistro`);

--
-- Filtros para la tabla `encabezado_registrocontable`
--
ALTER TABLE `encabezado_registrocontable`
  ADD CONSTRAINT `fk_divisa` FOREIGN KEY (`Codigo_Divisa`) REFERENCES `divisa` (`Codigo_Divisa`),
  ADD CONSTRAINT `fk_periodofiscal` FOREIGN KEY (`Codigo_PeriodoFiscal`) REFERENCES `periodo_fiscal` (`Codigo_PeriodoFiscal`);

--
-- Filtros para la tabla `subclasificacion_cuenta`
--
ALTER TABLE `subclasificacion_cuenta`
  ADD CONSTRAINT `fk_clasificacion` FOREIGN KEY (`Clasificacion_Cuenta`) REFERENCES `clasificacion_cuenta` (`Codigo_ClasificacionCuenta`);