SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE SCHEMA IF NOT EXISTS `empresarial` DEFAULT CHARACTER SET utf8mb4;
USE `empresarial`;
-- -----------------------------------------------------
-- Inicio Hotelerìa
  
  -- -----------------------------------------------------
  -- Table `empresarial`.`Piso`
  -- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_piso` (
   `PK_id_piso` INT NOT NULL,
   `cantidad_habitaciones_piso` INT NULL DEFAULT NULL,
   `descripcion_piso` VARCHAR(200) NULL DEFAULT NULL,
   `estado_piso` TINYINT NULL DEFAULT NULL,
   PRIMARY KEY (`PK_id_piso`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;
INSERT INTO
  `empresarial`.`tbl_piso`
VALUES
  ('1', '100', 'Habitaciones pequeñas', '1'),
  ('2', '100', 'Habitaciones medianas', '1'),
  ('3', '100', 'Habitaciones grandes', '1');

  -- -----------------------------------------------------
  -- Table `empresarial`.`horario`
  -- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_horario` (
   `PK_id_horario` INT NOT NULL,
   `entrada_horario` VARCHAR(10) NULL DEFAULT NULL,
   `salida_horario` VARCHAR(10) NULL DEFAULT NULL,
   `horas_extras_horario` INT NULL DEFAULT NULL,
   `descripcion_horario` VARCHAR(200) NULL DEFAULT NULL,
   `estado_horario` TINYINT NULL DEFAULT NULL,
   PRIMARY KEY (`PK_id_horario`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;
INSERT INTO 
`empresarial`.`tbl_horario` 
VALUES 
('1', '8 am', '8 pm', '8', 'Horario matutino', '1'),
('2', '12 am', '12 pm', '1', 'Horario de tarde', '1'),
('3', '9 am', '9 pm', '5', 'Horario nocturno', '1');

-- -----------------------------------------------------
  -- Table `empresarial`.`tbl_metodo_de_pago`
  -- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_metodo_de_pago` (
   `PK_id_metodo` INT NOT NULL,
   `nombre_metodo` VARCHAR(50) NULL DEFAULT NULL,
   `descripcion_metodo` VARCHAR(100) NULL DEFAULT NULL,
   `estado_metodo` TINYINT NULL DEFAULT NULL,
   PRIMARY KEY (`PK_id_metodo`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;
INSERT INTO
`empresarial`.`tbl_metodo_de_pago`
VALUES
('1', 'Tarjeta', 'Pago con tarjeta', '1'),
('2', 'Efectivo', 'Pago en efectivo', '1'),
('3','Criptomoneda Ethereum','Fase beta del método de prueba con CriptoMoneda Ethereum','0'),
('4','PAYPAL','Forma de pago PayPal a nuestra cuenta en brasil','0'),
('5','MovilPay','Pago en fase alpha para pagar mediante el celular.','0');
  
  -- -----------------------------------------------------
  -- Table `empresarial`.`tbl_servicios`
  -- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_servicio` (
   `PK_id_servicio` INT NOT NULL,
   `nombre_servicio` VARCHAR(50) NULL DEFAULT NULL,
   `descripcion_servicio` VARCHAR(100) NULL DEFAULT NULL,
   `precio_servicio` INT NOT NULL,
   `tipo_servicio` TINYINT NOT NULL,
   `estado_servicio` TINYINT NOT NULL,
   PRIMARY KEY (`PK_id_servicio`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;
INSERT INTO
`empresarial`.`tbl_servicio`
VALUES
('1', 'Internet', '50mg', '150', '1', '1'),
('2','Niñera','Cuido de niños menores de 10 años','250','2','1'),
('3','Acceso VIP del Restaurante','acceso VIP del restaurante durante una noche','375','2','1'),
('4','SPA','SPA para un máximo de 10 personas','500','2','2'),
('5','Sector para Fumadores','Amplio sector para personas puedan fumar tranquilamente','150','2','1');

-- -----------------------------------------------------
  -- Table `empresarial`.`tbl_mantenimiento_habitacion`
  -- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_mantenimiento_habitacion` (
   `PK_id_habitacion` INT NOT NULL,
   `precio_habitacion` INT NULL DEFAULT NULL,
   `PK_id_piso` INT NULL DEFAULT NULL,
   `estado_habitacion` TINYINT NULL DEFAULT NULL,
   `estado_limpieza` TINYINT NULL DEFAULT NULL,
   `tipo_de_habitacion` INT NULL DEFAULT NULL,
   `cantidad_maxima_persona` INT NULL DEFAULT NULL,
PRIMARY KEY (`PK_id_habitacion`),
FOREIGN KEY (`PK_id_piso`) REFERENCES `tbl_piso`(`PK_id_piso`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;
INSERT INTO
`empresarial`.`tbl_mantenimiento_habitacion`
VALUES
('1', '250', '1', '0', '1', '1', '5'),
('2', '250', '4', '1', '2', '1', '6'),
('3', '250', '1', '0', '1', '2', '7'),
('4', '250', '4', '1', '2', '2', '8'),
('5', '250', '1', '0', '1', '2', '9');

  -- -----------------------------------------------------
  -- Table `empresarial`.`tbl_huespedes`
  -- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_huesped` (
   `PK_no_identificacion` INT NOT NULL,
   `nombre_huesped` VARCHAR(50) NULL DEFAULT NULL,
   `apellido_huesped` VARCHAR(100) NULL DEFAULT NULL,
   `nacionalidad_huesped` VARCHAR(100) NULL DEFAULT NULL,
   `direccion_huesped` VARCHAR(100) NULL DEFAULT NULL,
   `sexo_huesped` VARCHAR(5) NULL DEFAULT NULL,
   `telefono_huesped` INT DEFAULT NULL,
   `cumpleaños_huesped` DATE NULL DEFAULT NULL,
   PRIMARY KEY (`PK_no_identificacion`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;
INSERT INTO
`empresarial`.`tbl_huesped`
VALUES
('1','Alberto','Suarez','Mexicano','alberto@gmail.com','M','12345678','2000-6-28'),
('12','Luis Carlos','lee','Japones','leeluis@gmail.com','M','87654321','2000-6-28'),
('123','Leonel','Gomez','Nigeriano','leo@gmail.com','M','123456789','2000-6-28'),
('1234','Jefferson','Davila','Aleman','jeff@gmail.com','M','612345678','2000-6-28'),
('12345','Gerson','Dominguez','Chileno','meda@gmail.com','M','1234585678','2000-6-28');

  -- -----------------------------------------------------
  -- Table `empresarial`.`tbl_menu_restaurante`
  -- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_menu_restaurante` (
   `PK_codigo_correlativo` INT NOT NULL,
   `nombre_plato` VARCHAR(100) NULL DEFAULT NULL,
   `descripcion_plato` VARCHAR(100) NULL DEFAULT NULL,
   `precio_plato` INT NOT NULL,
   `estado_plato` TINYINT NULL DEFAULT NULL,
   PRIMARY KEY (`PK_codigo_correlativo`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;
INSERT INTO
`empresarial`.`tbl_menu_restaurante`
VALUES
('1', 'pizza', 'pizza clasica', '50', '1'),
('12', 'burrito', 'burrito clasico', '20', '1'),
('123','hamburguesa','hamburguesa clasica','30','0'),
('1234', 'lasaña', 'lasaña clasica', '20', '0'),
('12345', 'tacos', 'tacos clasicos', '10', '0');
  
-- -----------------------------------------------------
-- Table `empresarial`.`tbl_tarifa`
-- -----------------------------------------------------
  CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_tarifa` (
    `PK_id_tarifa` INT AUTO_INCREMENT NOT NULL,
    `id_habitacion_tarifa` INT NOT NULL,
    `nombre_tarifa` VARCHAR(60) NULL DEFAULT NULL,
    `estado_tarifa` TINYINT NULL DEFAULT NULL,
    PRIMARY KEY (`PK_id_tarifa`),
    FOREIGN KEY (id_habitacion_tarifa) REFERENCES tbl_mantenimiento_habitacion(PK_id_habitacion)
  ) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

-- -----------------------------------------------------
-- Table `empresarial`.`tbl_paquete_servicio`
-- -----------------------------------------------------
  CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_paquete_servicios` (
    `PK_correlativo_paquete` INT AUTO_INCREMENT NOT NULL,
    `id_tarifa_paquete` INT NOT NULL,
    `id_servicio_paquete` INT NOT NULL,
    PRIMARY KEY (`PK_correlativo_paquete`),
    FOREIGN KEY (id_tarifa_paquete) REFERENCES tbl_tarifa(PK_id_tarifa),
    FOREIGN KEY (id_servicio_paquete) REFERENCES tbl_servicio(PK_id_servicio)
  ) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

-- -----------------------------------------------------
-- Table `empresarial`.`tbl_reservacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_reservacion` (
    `PK_id_reservacion` INT NOT NULL,
    `fecha_reservacion` DATE NOT NULL,
    `fecha_entrada_reservacion` DATE NOT NULL,
    `fecha_salida_reservacion` DATE NOT NULL,
    `identificacion_huesped_reservacion` INT NOT NULL,
    `cantidad_personas_reservacion` INT NOT NULL,
    `estado_reservacion` TINYINT NULL DEFAULT NULL,
    PRIMARY KEY (`PK_id_reservacion`),   
    FOREIGN KEY (identificacion_huesped_reservacion) REFERENCES tbl_huesped(PK_no_identificacion)
  ) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

-- -----------------------------------------------------
-- Table `empresarial`.`tbl_detalle_reservacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_detalle_reservacion` (
    `Pk_correlativo_detalle` INT AUTO_INCREMENT NOT NULL,
    `id_reservacion_detalle` INT NOT NULL,
    `id_tarifa_detalle` INT NOT NULL,
    PRIMARY KEY (`Pk_correlativo_detalle`),
    FOREIGN KEY (id_tarifa_detalle) REFERENCES tbl_tarifa(PK_id_tarifa),
    FOREIGN KEY (id_reservacion_detalle) REFERENCES tbl_reservacion(PK_id_reservacion)
  ) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

-- FIN Hotelerìa
-- -----------------------------------------------------

-- --------------------------------------------------------------- --
-- --------------------------------------------------------------- --
-- ----------------------- Area Financiera ----------------------- --
-- --------------------------------------------------------------- --
-- --------------------------------------------------------------- --

--
-- Estructura de tabla para la tabla `cierre_registrocontable`
--

CREATE TABLE `empresarial`.`cierre_registrocontable` (
  `Correlatiivo_DetalleRegistro` int NOT NULL,
  `Glosa_Partida` varchar(128) NOT NULL,
  `Monto_Cuadre` decimal(20,8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clasificacion_cuenta`
--

CREATE TABLE `empresarial`.`clasificacion_cuenta` (
  `Codigo_ClasificacionCuenta` int NOT NULL,
  `Clasificacion_Cuenta` varchar(128) NOT NULL,
  `Observaciones_Clasificacion` varchar(128) NOT NULL,
  `Estado_Clasificacion` tinyint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuenta_contable`
--

CREATE TABLE `empresarial`.`cuenta_contable` (
  `Codigo_CuentaContable` int NOT NULL,
  `Codigo_Clasificacion` int NOT NULL,
  `Correlativo_Subclasificacion` int NOT NULL,
  `Estado_CuentaContable` tinyint NOT NULL,
  `Monto_CuentaContable` decimal(20,2) NOT NULL,
  `Efecto_CuentaContable` tinyint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_registrocontable`
--

CREATE TABLE `empresarial`.`detalle_registrocontable` (
  `Correlativo_Registro` int NOT NULL,
  `Codigo_Encabezado` int NOT NULL,
  `Codigo_CuentaContable` int NOT NULL,
  `Monto_Registro` decimal(20,2) NOT NULL,
  `Lado_Monto` tinyint NOT NULL,
  `Descripcion_Registro` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `divisa`
--

CREATE TABLE `empresarial`.`divisa` (
  `Codigo_Divisa` int NOT NULL,
  `Nombre_Divisa` varchar(50) NOT NULL,
  `Simbolo_Divisa` varchar(1) NOT NULL,
  `Estado_Divisa` tinyint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `encabezado_registrocontable`
--

CREATE TABLE `empresarial`.`encabezado_registrocontable` (
  `Codigo_EncabezadoRegistro` int NOT NULL,
  `Codigo_PeriodoFiscal` int NOT NULL,
  `Codigo_Divisa` int NOT NULL,
  `Mes_Registro` int NOT NULL,
  `Descripcion_Registro` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `impuesto`
--

CREATE TABLE `empresarial`.`impuesto` (
  `Codigo_Impuesto` int NOT NULL,
  `Nombre_Impuesto` varchar(128) NOT NULL,
  `Porcentaje_Impuesto` decimal(3,3) NOT NULL,
  `Concepto_Impuesto` varchar(100) NOT NULL,
  `Estado_Impuesto` tinyint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `periodo_fiscal`
--

CREATE TABLE `empresarial`.`periodo_fiscal` (
  `Codigo_PeriodoFiscal` int NOT NULL,
  `Inicio_PeriodoFiscal` date NOT NULL,
  `Fin_PeriodoFiscal` date NOT NULL,
  `Estado_PeriodoFiscal` tinyint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `subclasificacion_cuenta`
--

CREATE TABLE `empresarial`.`subclasificacion_cuenta` (
  `Codigo_Subclasificacion` int NOT NULL,
  `Clasificacion_Cuenta` int NOT NULL,
  `Subclasificacion_Cuenta` varchar(50) CHARACTER SET utf8mb4 NOT NULL,
  `Observacion_Subclasificacion` varchar(128) CHARACTER SET utf8mb4 NOT NULL,
  `Estado_Subclasificacion` tinyint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------------- --
-- --------------------------------------------------------------- --
-- ---------------------- Area de bancos ------------------------- --
-- --------------------------------------------------------------- --
-- --------------------------------------------------------------- --

/*Área de Bancos*/
create table `empresarial`.`moneda`(
	`id_moneda` varchar(10) primary key,
    `nombre_moneda` varchar(20) not null,
    `Abreviatura` varchar(20) not null,
    `tipo_cambio` float,
    `estatus_moneda` char(1)
)engine = InnoDB default charset=utf8mb4;


create table `empresarial`.`Documento_bancario`(
	`codigo_Documento` varchar(10) primary key,
    `nombre_Documento` varchar(50),
    `afecta` char(1),  -- + o - a la cuenta
    `estatus_documento` char(1)

) engine = InnoDB default char set=utf8mb4;

create table `empresarial`.`mov_bancEnc`( -- solo que mov se realizo y cual es el monto 
	`id_movEnc` varchar(10) primary key,
    `codigo_Documento` varchar(10),
    `fecha` date,
    `monto` float,
    `descripcion` varchar(80),
    
    foreign key (`codigo_Documento`) references `Documento_bancario` (`codigo_Documento`)
	
) engine = InnoDB default char set=utf8mb4;

create table `empresarial`.`mov_bancDet`( -- cuentas involucradas y partida contable 
	`id_movEnc` varchar(10),
    `codigo_concepto` varchar(10),
    `saldo_deudor` float,
	`saldo_acreedor` float, 
    
    primary key (`id_movEnc`, `codigo_concepto`), -- clave compuesta y agruparemos por tipo de saldo 
    
    foreign key (`id_movEnc`) references `mov_bancEnc`(`id_movEnc`),
    foreign key (`codigo_concepto`) references `concepto_bancario`(`codigo_concepto`)
    
) engine = InnoDB default char set=utf8mb4;

create table `empresarial`.`forma_pago`(
	`id_formapago` varchar(10) primary key,
    `tipo_pago` varchar(35) /*cheque, efectivo, tarjeta, nota de credito, otro*/
) engine = InnoDB default char set=utf8mb4;

create table `empresarial`.`banco`(
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

create table `empresarial`.`conciliacion_bancenc`(
	`id_encabezado` varchar(10) primary key,
    `cargo_conciliar` float,
    `abono_conciliar` float,
    `saldo_corte` float,
    `cargo_conciliado` float,
    `abono_conciliado` float,
    `saldo_final` float
) engine = InnoDB default char set=utf8mb4;

create table `empresarial`.`conciliacion_bancaria_det`(
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
-- ---------------------- Area de Nomina ------------------------- --
-- --------------------------------------------------------------- --
-- --------------------------------------------------------------- --

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_puesto` (
  `PK_id_puesto` INT NOT NULL AUTO_INCREMENT,
  `nombre_puesto` VARCHAR(45) NULL DEFAULT NULL,
  `salario_puesto` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`PK_id_puesto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;
INSERT INTO
  `empresarial`.`tbl_puesto`
VALUES
  ('1', 'Gobernanta', '1000'), ('2', 'Ama de Llave', '1000'), ('3', 'Seguridad', '1000');

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_empleado` (
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
INSERT INTO
`empresarial`.`tbl_empleado`
VALUES
('1', 'Karol', 'Garcia', '12345', 'karol@gmail.com', 'Ama de Llave', '1', '2021-10-19'),
('2', 'Darlyn', 'Garcia', '12345', 'karolq@gmail.com', 'Gobernanta', '1', '2021-10-19'),
('3', 'Karla', 'Garcia', '12345', 'karolq@gmail.com', 'Ama de Llave', '0', '2021-10-19'),
('4', 'Esmeralda', 'Garcia', '12345', 'karolq@gmail.com', 'Ama de Llave', '1', '2021-10-19'),
('5', 'Yury', 'Garcia', '12345', 'karolq@gmail.com', 'Gobernanta', '0', '2021-10-19');

/*Área de Nómina*/
create table `empresarial`.`concepto_planilla`(
	`id_conceptoPlanilla` varchar(10) primary key,
	`nombre_concepto` varchar(20),
	`tipo_concepto` varchar (10),
	`clase_concepto` varchar(25),
	`Valor_concepto` float
	-- aplicacion_concepto varchar(20)
) engine = InnoDB default char set=utf8mb4;

create table `empresarial`.`planilla_enc`(
	`id_planillaenc` varchar(10) primary key,
	`total_percepcion` float,
	`total_deduccion` float,
	`total_liquido`  float
) engine = InnoDB default char set=utf8mb4;

create table `empresarial`.`planilla_det`(
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

/*AREA COMERCIAL*/

-- -----------------------------------------------------
-- Table `empresarial`.`linea`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_linea` (
 `PK_codigo_linea` INT  NOT NULL,
   `nombre_linea` VARCHAR(35) NULL DEFAULT NULL,
  `estatus_linea` TINYINT NOT NULL,
  PRIMARY KEY (`PK_codigo_linea`))

ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

INSERT INTO `empresarial`.`tbl_linea` 
VALUES 
('1', 'blanca', '1'),
 ('2', 'electronica', '1'),
 ('3', 'deportiva', '1'),
 ('4', 'cosmeticos', '1');

-- -----------------------------------------------------
-- Table `administracion`.`marca`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_marca` (
 `PK_codigo_marca` INT  NOT NULL,
   `nombre_marca` VARCHAR(35) NULL DEFAULT NULL,
  `estatus_marca` TINYINT NOT NULL,
  PRIMARY KEY (`PK_codigo_marca`))
ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

INSERT INTO `empresarial`.`tbl_marca` 
VALUES 
 ('1', 'cocacola', '1'),
 ('2', 'señorial', '1'),
('3', 'lala', '1'),
 ('4', 'sears', '1'),
('5', 'kerns', '1');

-- -----------------------------------------------------
-- Table `administracion`.`bodega`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_bodega` (
 `PK_codigo_bodega` INT  NOT NULL,
   `nombre_bodega` VARCHAR(35) NULL DEFAULT NULL,
  `estatus_bodega` TINYINT NOT NULL,
  PRIMARY KEY (`PK_codigo_bodega`))
ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

INSERT INTO
 `empresarial`.`tbl_bodega` 
 VALUES
 ('1', 'zona1', '1'),
 ('2', 'zona3', '1'),
 ('3', 'zona10', '1'),
 ('4', 'central', '1');


-- -----------------------------------------------------
-- Table `administracion`.`unidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_unidad` (
 `PK_codigo_unidad` INT  NOT NULL,
 `nombre_unidad` VARCHAR(35) NULL DEFAULT NULL, 
 `medida_acronimo` VARCHAR(35) NULL DEFAULT NULL, 
 `estatus_unidad` TINYINT NOT NULL,
  PRIMARY KEY (`PK_codigo_unidad`))
ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

INSERT INTO `empresarial`.`tbl_unidad` 
VALUES 
('1', 'litros', 'ltr', '1'),
 ('2', 'libras', 'lbr', '1'),
 ('3', 'gramos', 'ltr', '1');

-- -----------------------------------------------------
-- Table `administracion`.`tbl_transporte`
-- -----------------------------------------------------
 CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_transporte` (
	`PK_codigo_transporte` INT  NOT NULL,
    `clase_transporte` VARCHAR(35) NULL DEFAULT NULL,/*ejemplo camioneta*/
    `marca_transporte` VARCHAR(35) NULL DEFAULT NULL,
    `modelo_transporte` VARCHAR(35) NULL DEFAULT NULL,/*año del vehiculo*/
    `tipo_transporte` VARCHAR(35) NULL DEFAULT NULL,
    `placa_transporte` VARCHAR(10) NULL DEFAULT NULL,
    `color_transporte` VARCHAR(35) NULL DEFAULT NULL,
    `estado_transporte` VARCHAR(35) NULL DEFAULT NULL, /*buen estado, dañado*/
    `numero_motor_transporte` VARCHAR(35) NULL DEFAULT NULL, 
    `estatus_transporte` TINYINT NOT NULL,
	PRIMARY KEY (`PK_codigo_transporte`))
	ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `administracion`.`transporte_ruta`
-- -----------------------------------------------------
 CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_transporteruta` (
	`PK_codigo_transporteruta` INT  NOT NULL,
    `nombre_conductoruta` VARCHAR(35) NULL DEFAULT NULL,  /* nomina */
    `nombre_transporteruta` VARCHAR(35) NULL DEFAULT NULL, /*  */
    `tipo_transporteruta` VARCHAR(35) NULL DEFAULT NULL,
    `ubicacion_transporteruta` VARCHAR(35) NULL DEFAULT NULL, /*ubicacion donde se encuentra*/
    `direccion_transporteruta` VARCHAR(35) NULL DEFAULT NULL, /* direccion a donde va el vehiculo*/
	`hora_salida_transporteruta` DATETIME NULL DEFAULT NULL,
	`hora_entrada_transporteruta` DATETIME DEFAULT NULL,
    `estatus_transporteruta` TINYINT NOT NULL,
	PRIMARY KEY (`PK_codigo_transporteruta`))
	ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;
    
    
    -- -----------------------------------------------------
-- Table `administracion`.`inventario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_inventario` (
  `PK_codigo_inventario` INT  NOT NULL,
  `PK_codigo_producto` INT  NOT NULL,
  `PK_codigo_bodega` INT  NOT NULL,
  `PK_codigo_existencia` INT  NOT NULL,
  `PK_codigo_linea` INT  NOT NULL,
  `PK_codigo_marca` INT  NOT NULL,
  `PK_codigo_unidad` INT  NOT NULL,
  `estatus_inventario` TINYINT NOT NULL,
  PRIMARY KEY(
  PK_codigo_inventario,
  PK_codigo_producto,
  PK_codigo_bodega,
  PK_codigo_existencia,
  PK_codigo_linea,
  PK_codigo_marca,
  PK_codigo_unidad
  ),
FOREIGN KEY (`PK_codigo_producto`)
REFERENCES `empresarial`.`tbl_producto` (`PK_codigo_producto`),
FOREIGN KEY (`PK_codigo_bodega`)
REFERENCES `empresarial`.`tbl_bodega` (`PK_codigo_bodega`),
FOREIGN KEY (`PK_codigo_existencia`)
REFERENCES `empresarial`.`tbl_existencia` (`PK_codigo_existencia`),
FOREIGN KEY (`PK_codigo_linea`)
REFERENCES `empresarial`.`tbl_linea` (`PK_codigo_linea`)

  ) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

-- -----------------------------------------------------
-- Table `administracion`.`producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_producto` (
  `PK_codigo_producto` INT  NOT NULL, /*codigo barras - hace unico al producto*/
  `nombre_producto` VARCHAR(35) NULL DEFAULT NULL, /*nombre_tipoproducto*/
  `descripcion_producto` VARCHAR(35) NULL DEFAULT NULL,
  `precio_producto` INT DEFAULT NULL,
  `costo_producto` INT DEFAULT NULL,
  `estatus_producto` TINYINT NOT NULL,
  `codigo_linea` INT NULL DEFAULT NULL,
  `codigo_marca` INT NULL DEFAULT NULL,
  `codigo_bodega` INT NULL DEFAULT NULL,
  `codigo_unidad` INT NULL DEFAULT NULL,
  
  PRIMARY KEY (
  `PK_codigo_producto`
  
),

FOREIGN KEY (`codigo_linea`)
REFERENCES `empresarial`.`tbl_linea` (`PK_codigo_linea`),


FOREIGN KEY (`codigo_marca`)
REFERENCES `empresarial`.`tbl_marca` (`PK_codigo_marca`),   
  

FOREIGN KEY (`codigo_bodega`)
REFERENCES `empresarial`.`tbl_bodega` (`PK_codigo_bodega`),
 

FOREIGN KEY (`codigo_unidad`)
REFERENCES `empresarial`.`tbl_unidad` (`PK_codigo_unidad`)
  ) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

INSERT INTO `empresarial`.`tbl_producto` 
VALUES ('1', 'planchas', 'ingreso 17/08/2021', '120', '120', '1', '2', '4', '4', '2'),
('2', 'jugos', 'ingreso 12/09/2021', '12', '12', '1', '1', '5', '4', '1');


-- -----------------------------------------------------
-- Table `administracion`.`existencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_existencia` (
`Pk_codigo_existencia` INT  NOT NULL,
`Pk_codigo_producto` INT  NOT NULL,
`Pk_codigo_bodega` INT  NOT NULL,
`cantidad_existencia` INT NULL DEFAULT NULL,
`fecha_entrada_existencia` DATE DEFAULT NULL,
`fecha_salida_existencia` DATE DEFAULT NULL,
`estatus_existencia` TINYINT NOT NULL,
  PRIMARY KEY ( 
  Pk_codigo_existencia,
  Pk_codigo_producto,
  Pk_codigo_bodega
),
  FOREIGN KEY (`PK_codigo_producto`)
  REFERENCES `empresarial`.`tbl_producto` (`PK_codigo_producto`),
  FOREIGN KEY (`PK_codigo_bodega`)
  REFERENCES `empresarial`.`tbl_bodega` (`PK_codigo_bodega`)
  ) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

INSERT INTO `empresarial`.`tbl_existencia` 
VALUES 
('1', '1', '1', '10', '2021/10/5', '2021/10/2', '1'),
 ('2', '2', '2', '20', '2021/8/15', '2021/9/30', '1'),
('3', '3', '3', '30', '2021/7/5', '2021/8/10', '1');

-- -----------------------------------------------------
-- Table `administracion`.`movimiento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_movimiento` (
`Pk_codigo_movimiento` INT  NOT NULL,

`estatus_movimiento` TINYINT NOT NULL,
  PRIMARY KEY ( 
  Pk_codigo_movimiento
)
  ) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

-- -----------------------------------------------------
-- Table `administracion`.`movimiento_detalle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_movimiento_detalle` (
`Pk_codigo_movimiento_detalle` INT  NOT NULL,

`estatus_movimiento_detalle` TINYINT NOT NULL,
  PRIMARY KEY ( 
  Pk_codigo_movimiento_detalle
)
  ) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;
  
-- -----------------------------------------------------
-- Table `administracion`.`proveedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_proveedor` (
 `PK_codigo_proveedor` INT NOT NULL,
   `nombre_proveedor` VARCHAR(35) NULL DEFAULT NULL,
   `direccion_proveedor` VARCHAR(35) NULL DEFAULT NULL,
   `telefono_proveedor` VARCHAR(35) NULL DEFAULT NULL,
   `nit_proveedor` INT NOT NULL,
   `email_proveedor` VARCHAR(35) NULL DEFAULT NULL,
   `representante_proveedor` VARCHAR(35) NULL DEFAULT NULL,
   `estatus_proveedor` TINYINT NOT NULL,
  PRIMARY KEY (`PK_codigo_proveedor`))
ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;
INSERT INTO 
`empresarial`.`tbl_proveedor` 
VALUES 
('1', 'serveceria gallo', 'zona 2 3-00', '51169327', '456789', 'gallo@gmial.com', 'Esteban Chilero', '1'),
('2', 'cañareal', 'zona12 8-00', '2200800', '7890', 'cañareal@gmail.com', 'Dania Castillo', '1'),
('3', 'walmart', 'zona6', '51169326', '26008785', 'walmartl@gmail.com', 'Marisol Caal', '1');

-- -----------------------------------------------------
-- Table `administracion`.`forma_pago`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_forma_pago` (
 `PK_codigo_pago` INT NOT NULL,
   `tipo_pago` VARCHAR(35) NULL DEFAULT NULL,
   `descripcion_pago` VARCHAR(35) NULL DEFAULT NULL,
   `fecha_pago` VARCHAR(35) NULL DEFAULT NULL,
   `estatus_pago` TINYINT NOT NULL,
  PRIMARY KEY (`PK_codigo_pago`))
ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;
INSERT INTO 
`empresarial`.`tbl_forma_pago` 
VALUES ('1', 'cheque', 'vence el dia', '12/08/2021', '1'),
('2', 'tarjeta', 'banco banrural', '16/08/2021','1'),
('3', 'efectivo', 'exactos', '20/09/2021', '1');


-- -----------------------------------------------------
-- Table `administracion`.`compra_factura_encabezado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_compra_factura_encabezado` (
 `PK_codigo_factura` INT NOT NULL,
  `PK_codigo_bodega` INT NOT NULL,
 `codigo_proveedor` INT NOT NULL,
   `fecha_emision` VARCHAR(35) NULL DEFAULT NULL,
   `fecha_vencimiento` VARCHAR(35) NULL DEFAULT NULL,
   `codigo_pago` INT NOT NULL,
   `subtotal_encabezado` INT NOT NULL,
   `estatus_factura` TINYINT NOT NULL,

  PRIMARY KEY (
  `PK_codigo_factura`,
  `Pk_codigo_bodega`
  ),
  
FOREIGN KEY (`codigo_proveedor`)
REFERENCES `empresarial`.`tbl_proveedor` (`PK_codigo_proveedor`),
FOREIGN KEY (`codigo_pago`)
REFERENCES `empresarial`.`tbl_pago` (`PK_codigo_pago`)

  )
  ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

-- -----------------------------------------------------
-- Table `administracion`.`compra_factura_detalle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_compra_factura_detalle` (
`correlativo` INT AUTO_INCREMENT,
 `PK_codigo_factura` INT NOT NULL,
 `PK_codigo_producto` INT NOT NULL,
 `PK_codigo_bodega` INT NOT NULL,
 `cantidad_detalle` INT NOT NULL,
`costo_detalle` INT NOT NULL,
	 	
  PRIMARY KEY (
  `correlativo`,
  `PK_codigo_factura`,
 `PK_codigo_producto` ,
 `Pk_codigo_bodega`
  ),
  
FOREIGN KEY (`Pk_codigo_factura`)
REFERENCES `empresarial`.`tbl_compra_factura_encabezado` (`PK_codigo_factura`),

FOREIGN KEY (`Pk_codigo_producto`)
REFERENCES `empresarial`.`tbl_producto` (`PK_codigo_producto`),

FOREIGN KEY (`PK_codigo_bodega`)
REFERENCES `empresarial`.`tbl_bodega` (`PK_codigo_bodega`)   
  )
  
ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `administracion`.`ordencompra_encabezado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_ordencompra_encabezado` (
 `PK_codigo_ordenCompra` INT NOT NULL,
 `codigo_proveedor` INT NOT NULL,
 `PK_codigo_bodega` INT NOT NULL,
   `fecha_emision` VARCHAR(35) NULL DEFAULT NULL,
   `fecha_entrega` VARCHAR(35) NULL DEFAULT NULL,
   `subtotal_encabezado` INT NOT NULL,
   `estatus_ordecompra` TINYINT NOT NULL,

  PRIMARY KEY (
  `PK_codigo_ordenCompra`,
  `Pk_codigo_bodega`
  ),

FOREIGN KEY (`codigo_proveedor`)
REFERENCES `empresarial`.`tbl_proveedor` (`PK_codigo_proveedor`)

  )
  ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;
-- -----------------------------------------------------
-- Table `administracion`.`ordencompra_detalle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_ordencompra_detalle` (
`correlativo` INT AUTO_INCREMENT,
`PK_codigo_ordenCompra` INT NOT NULL,
 `PK_codigo_producto` INT NOT NULL,
 `PK_codigo_bodega` INT NOT NULL,
 `cantidad_detalle` INT NOT NULL,
 `costo_detalle` INT NOT NULL,

	 	
  PRIMARY KEY (
 `correlativo` ,
 `PK_codigo_ordenCompra`,
 `PK_codigo_producto` ,
  `Pk_codigo_bodega`
  ),
  
FOREIGN KEY (`PK_codigo_ordenCompra`)
REFERENCES `empresarial`.`tbl_ordencompra_encabezado` (`PK_codigo_ordenCompra`),

FOREIGN KEY (`Pk_codigo_producto`)
REFERENCES `empresarial`.`tbl_producto` (`PK_codigo_producto`),

FOREIGN KEY (`PK_codigo_bodega`)
REFERENCES `empresarial`.`tbl_bodega` (`PK_codigo_bodega`)   
  )
  
ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `administracion`.`recepcioncompra_encabezado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_recepcioncompra_encabezado` (
 `PK_codigo_recepcionCompra` INT NOT NULL,
 `codigo_proveedor` INT NOT NULL,
 `PK_codigo_bodega` INT NOT NULL,
   `fecha_emision` VARCHAR(35) NULL DEFAULT NULL,
   `fecha_entrega` VARCHAR(35) NULL DEFAULT NULL,
   `subtotal_encabezado` INT NOT NULL,
   `estatus_ordecompra` TINYINT NOT NULL,

  PRIMARY KEY (
  `PK_codigo_recepcionCompra`,
  `Pk_codigo_bodega`
  ),
  
  FOREIGN KEY (`codigo_proveedor`)
REFERENCES `empresarial`.`tbl_proveedor` (`PK_codigo_proveedor`)

  )
  ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;
-- -----------------------------------------------------
-- Table `administracion`.`recepcioncompra_detalle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_recepcioncompra_detalle` (
`correlativo` INT AUTO_INCREMENT,
`PK_codigo_recepcionCompra` INT NOT NULL,
 `PK_codigo_producto` INT NOT NULL,
 `PK_codigo_bodega` INT NOT NULL,
 `cantidad_detalle` INT NOT NULL,
 `costo_detalle` INT NOT NULL,
PRIMARY KEY (
 `correlativo` ,
 `PK_codigo_recepcionCompra`,
 `PK_codigo_producto` ,
  `Pk_codigo_bodega`
  ),
  
FOREIGN KEY (`PK_codigo_recepcionCompra`)
REFERENCES `empresarial`.`tbl_recepcioncompra_encabezado` (`PK_codigo_recepcionCompra`),

FOREIGN KEY (`Pk_codigo_producto`)
REFERENCES `empresarial`.`tbl_producto` (`PK_codigo_producto`),

FOREIGN KEY (`PK_codigo_bodega`)
REFERENCES `empresarial`.`tbl_bodega` (`PK_codigo_bodega`)   
  )
  ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;
-- -----------------------------------------------------
-- Table `administracion`.`devolucioncompra_encabezado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_devolucioncompra_encabezado` (
 `PK_codigo_devolucionCompra` INT NOT NULL,
 `codigo_proveedor` INT NOT NULL,
 `PK_codigo_bodega` INT NOT NULL,
   `fecha_emision` VARCHAR(35) NULL DEFAULT NULL,
   `fecha_entrega` VARCHAR(35) NULL DEFAULT NULL,
   `subtotal_encabezado` INT NOT NULL,
   `estatus_ordecompra` TINYINT NOT NULL,
PRIMARY KEY (
  `PK_codigo_devolucionCompra`,
  `Pk_codigo_bodega`
  ),
  
  FOREIGN KEY (`codigo_proveedor`)
REFERENCES `empresarial`.`tbl_proveedor` (`PK_codigo_proveedor`)

  )
  ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;
-- -----------------------------------------------------
-- Table `administracion`.`devolucioncompra_detalle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_devolucioncompra_detalle` (
`correlativo` INT AUTO_INCREMENT,
`PK_codigo_devolucionCompra` INT NOT NULL,
 `PK_codigo_producto` INT NOT NULL,
 `PK_codigo_bodega` INT NOT NULL,
 `cantidad_detalle` INT NOT NULL,
 `costo_detalle` INT NOT NULL,
PRIMARY KEY (
 `correlativo` ,
 `PK_codigo_devolucionCompra`,
 `PK_codigo_producto` ,
  `Pk_codigo_bodega`
  ),
  
FOREIGN KEY (`PK_codigo_devolucionCompra`)
REFERENCES `empresarial`.`tbl_devolucioncompra_encabezado` (`PK_codigo_devolucionCompra`),

FOREIGN KEY (`Pk_codigo_producto`)
REFERENCES `empresarial`.`tbl_producto` (`PK_codigo_producto`),

FOREIGN KEY (`PK_codigo_bodega`)
REFERENCES `empresarial`.`tbl_bodega` (`PK_codigo_bodega`)   
  )
  
ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `administracion`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_cliente` (
 `PK_codigo_cliente`  INT  NOT NULL ,
   `nombre_cliente` VARCHAR(35) NULL ,
  `direccion_cliente` VARCHAR(35) NULL DEFAULT NULL,
    `telefono_cliente` VARCHAR(35) NULL DEFAULT NULL,
  `nit_cliente` INT DEFAULT NULL,
    `email_cliente` VARCHAR(35) NULL DEFAULT NULL,
  `saldo_cliente` INT DEFAULT NULL,
  `cuenta_cliente` INT DEFAULT NULL,
  `estatus_cliente` TINYINT NOT NULL,
  PRIMARY KEY (`PK_codigo_cliente`))

 ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;
 INSERT INTO `empresarial`.`tbl_cliente`
 VALUES 
('1', 'JUAN', 'ZONA 6', '1232445', '4453453', 'A', '0', '12424', '1'),
('2', 'CARLOS', 'ZONA 5', '532434', '3435334', 'A', '0', '34243', '1'),
('3', 'VERA', 'ZONA 4', '645544', '4343435', 'A', '0', '3434', '1'),
('4', 'DIEGO', 'ZONA 8', '434355', '7676655', 'A', '0', '3423', '1'),
('5', 'IVAN', 'ZONA 9', '665544', '6565454', 'A', '0', '3343', '1');

-- -----------------------------------------------------
-- Table `administracion`.`cobrador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS  `empresarial`.`tbl_cobrador` (
 `PK_codigo_cobrador`  INT   NOT NULL ,
   `nombre_cobrador` VARCHAR(35) NULL DEFAULT NULL,
  `estatus_cobrador` TINYINT NOT NULL,
  PRIMARY KEY (`PK_codigo_cobrador`))
 ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;
 INSERT INTO `empresarial`.`tbl_cobrador`
 VALUES 
('1', 'JUAN',  '1'),
('2', 'CARLOS','1'),
('3', 'VERA', '1'),
('4', 'DIEGO',  '1'),
('5', 'IVAN', '1');

-- -----------------------------------------------------
-- Table `administracion`.`vendedores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS  `empresarial`.`tbl_vendedor` (
 `PK_codigo_vendedor` INT   NOT NULL ,
   `nombre_vendedor` VARCHAR(35) NULL DEFAULT NULL,
  `estatus_vendedor` TINYINT NOT NULL,
  PRIMARY KEY (`PK_codigo_vendedor`))
 ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;
 INSERT INTO `empresarial`.`tbl_vendedor`
 VALUES 
('1', 'JUAN', '1'),
('2', 'CARLOS','1'),
('3', 'VERA','1'),
('4', 'DIEGO','1'),
('5', 'IVAN','1');
-- -----------------------------------------------------
-- Table `administracion`.`control_precio_encabezado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS  `empresarial`.`tbl_control_precio_encabezado` (
 `PK_codigo_producto_precio_encabezado` INT NOT NULL ,
   `codigo_producto`INT   NOT NULL,
   `fecha_emision` VARCHAR(35) NULL DEFAULT NULL,
	`fecha_vencer` VARCHAR(35) NULL DEFAULT NULL,
     
  PRIMARY KEY (
  `PK_codigo_producto_precio_encabezado`,
  `codigo_producto`
),
FOREIGN KEY (`codigo_producto`)
REFERENCES  `empresarial`.`tbl_producto` (`PK_codigo_producto`)
  )ENGINE = InnoDB
 ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

-- -----------------------------------------------------
-- Table `administracion`.`tbl_control_precio_detalle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS  `empresarial`.`tbl_control_precio_detalle` (
 `PK_codigo_producto_precio_detalle` INT NOT NULL ,
  `nombre_producto` VARCHAR(35) NULL DEFAULT NULL,
	`precio_producto` VARCHAR(35) NULL DEFAULT NULL,
   `costo_producto` VARCHAR(35) NULL DEFAULT NULL,
PRIMARY KEY (
 `PK_codigo_producto_precio_detalle`
))
 ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

-- -----------------------------------------------------
-- Table `administracion`.`cotizacion_encabezado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS  `empresarial`.`tbl_cotizacion_encabezado` (
`no_serie` INT AUTO_INCREMENT  NOT NULL ,
`PK_codigo_cotizacion_encabezado`INT   NOT NULL ,
`codigo_cliente`INT NULL DEFAULT NULL,
`codigo_cobrador`INT NULL DEFAULT NULL,
`codigo_vendedor`INT NULL DEFAULT NULL,
`fecha_emision` VARCHAR(35) NULL DEFAULT NULL,
`fecha_vencimiento` VARCHAR(35) NULL DEFAULT NULL,
`impuesto_iva_encabezado` FLOAT NULL DEFAULT NULL,
`subtotal_encabezado` FLOAT NULL DEFAULT NULL,
`estatus_factura` TINYINT NOT NULL,
  PRIMARY KEY (
`no_serie`,
`PK_codigo_cotizacion_encabezado`
),
    FOREIGN KEY (`codigo_cliente`)
REFERENCES  `empresarial`.`tbl_cliente` (`PK_codigo_cliente`),
FOREIGN KEY ( `codigo_vendedor`)
REFERENCES  `empresarial`.`tbl_vendedor` (`PK_codigo_vendedor`),
 FOREIGN KEY ( `codigo_cobrador`)
REFERENCES  `empresarial`.`tbl_cobrador` ( `PK_codigo_cobrador`)
  )
 ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

-- -----------------------------------------------------
-- Table `administracion`.`cotizacion_detalle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS  `empresarial`.`tbl_cotizacion_detalle` (
`no_serie`INT NOT NULL ,
`codigo_cotizacion_encabezado`INT   NOT NULL ,
`cantidad_servicio` FLOAT NULL DEFAULT NULL,
`precio_servicio` FLOAT NULL DEFAULT NULL,
  PRIMARY KEY (
`no_serie`
),
 FOREIGN KEY (`no_serie`)
REFERENCES  `empresarial`.`tbl_factura_encabezado` (`no_serie`)
  )
  ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

-- -----------------------------------------------------
-- Table `administracion`.`pedido_encabezado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS  `empresarial`.`tbl_pedido_encabezado` (
`no_serie` INT AUTO_INCREMENT  NOT NULL ,
`PK_codigo_pedido_encabezado`INT    NOT NULL ,
`codigo_cliente`INT NULL DEFAULT NULL,
`codigo_cobrador`INT NULL DEFAULT NULL,
`codigo_vendedor`INT NULL DEFAULT NULL,
`fecha_emision` VARCHAR(35) NULL DEFAULT NULL,
`fecha_vencimiento` VARCHAR(35) NULL DEFAULT NULL,
`impuesto_iva_encabezado` FLOAT NULL DEFAULT NULL,
`subtotal_encabezado` FLOAT NULL DEFAULT NULL,
`estatus_factura` TINYINT NOT NULL,
  PRIMARY KEY (
`no_serie`,
`PK_codigo_pedido_encabezado`
),
    FOREIGN KEY (`codigo_cliente`)
REFERENCES  `empresarial`.`tbl_cliente` (`PK_codigo_cliente`),
FOREIGN KEY ( `codigo_vendedor`)
REFERENCES  `empresarial`.`tbl_vendedor` (`PK_codigo_vendedor`),
 FOREIGN KEY ( `codigo_cobrador`)
REFERENCES  `empresarial`.`tbl_cobrador` ( `PK_codigo_cobrador`)
  )
 ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

-- -----------------------------------------------------
-- Table `administracion`.`pedido_detalle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS  `empresarial`.`tbl_pedido_detalle` (
`no_serie` INT AUTO_INCREMENT  NOT NULL ,
`codigo_pedido_encabezado`INT   NOT NULL ,
`cantidad_servicio` FLOAT NULL DEFAULT NULL,
`precio_servicio` FLOAT NULL DEFAULT NULL,
  PRIMARY KEY (
`no_serie`
),
 FOREIGN KEY (`no_serie`)
REFERENCES  `empresarial`.`tbl_factura_encabezado` (`no_serie`)
  )
  ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

-- -----------------------------------------------------
-- Table `administracion`.`factura_encabezado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS  `empresarial`.`tbl_factura_encabezado` (
`no_serie` INT AUTO_INCREMENT  NOT  NULL ,
`PK_codigo_factura_encabezado`INT   NOT NULL ,
`codigo_cliente`INT NULL DEFAULT NULL,
`codigo_cobrador`INT NULL DEFAULT NULL,
`codigo_vendedor`INT NULL DEFAULT NULL,
`fecha_emision` VARCHAR(35) NULL DEFAULT NULL,
`fecha_vencimiento` VARCHAR(35) NULL DEFAULT NULL,
`impuesto_iva_encabezado` FLOAT NULL DEFAULT NULL,
`subtotal_encabezado` FLOAT NULL DEFAULT NULL,
`estatus_factura` TINYINT NOT NULL,
  PRIMARY KEY (
`no_serie`,
`PK_codigo_factura_encabezado`
),
    FOREIGN KEY (`codigo_cliente`)
REFERENCES  `empresarial`.`tbl_cliente` (`PK_codigo_cliente`),
FOREIGN KEY ( `codigo_vendedor`)
REFERENCES  `empresarial`.`tbl_vendedor` (`PK_codigo_vendedor`),
 FOREIGN KEY ( `codigo_cobrador`)
REFERENCES  `empresarial`.`tbl_cobrador` ( `PK_codigo_cobrador`)
  )
 ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

-- -----------------------------------------------------
-- Table `administracion`.`factura_detalle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS  `empresarial`.`tbl_factura_detalle` (
`no_serie` INT AUTO_INCREMENT  NOT NULL ,
`codigo_factura_encabezado`INT   NOT NULL ,
`cantidad_servicio` FLOAT NULL DEFAULT NULL,
`precio_servicio` FLOAT NULL DEFAULT NULL,
  PRIMARY KEY (
`no_serie`
),
 FOREIGN KEY (`no_serie`)
REFERENCES  `empresarial`.`tbl_factura_encabezado` (`no_serie`)
  )
 ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;
-- -----------------------------------------------------
-- Table `administracion`.`devolucion_venta_encabezado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS  `empresarial`.`tbl_devolucion_venta_encabezado` (
`no_serie` INT AUTO_INCREMENT  NOT NULL ,
`PK_codigo_devolucion_venta_encabezado`INT   NOT NULL ,
`codigo_cliente`INT NULL DEFAULT NULL,
`codigo_cobrador`INT NULL DEFAULT NULL,
`codigo_vendedor`INT NULL DEFAULT NULL,
`fecha_emision` VARCHAR(35) NULL DEFAULT NULL,
`fecha_vencimiento` VARCHAR(35) NULL DEFAULT NULL,
`impuesto_iva_encabezado` FLOAT NULL DEFAULT NULL,
`subtotal_encabezado` FLOAT NULL DEFAULT NULL,
`estatus_devolucion_venta` TINYINT NOT NULL,
  PRIMARY KEY (
`no_serie`,
`PK_codigo_devolucion_venta_encabezado`
),
    FOREIGN KEY (`codigo_cliente`)
REFERENCES  `empresarial`.`tbl_cliente` (`PK_codigo_cliente`),
FOREIGN KEY ( `codigo_vendedor`)
REFERENCES  `empresarial`.`tbl_vendedor` (`PK_codigo_vendedor`),
 FOREIGN KEY ( `codigo_cobrador`)
REFERENCES  `empresarial`.`tbl_cobrador` ( `PK_codigo_cobrador`)
  )

 ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;
-- -----------------------------------------------------
-- Table `administracion`.`devolucion_venta_detalle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS  `empresarial`.`tbl_devolucion_venta_detalle` (
`no_serie` INT AUTO_INCREMENT  NOT NULL ,
`codigo_devolucion_venta_encabezado`INT   NOT NULL ,
`cantidad_servicio` FLOAT NULL DEFAULT NULL,
`precio_servicio` FLOAT NULL DEFAULT NULL,
  PRIMARY KEY (
`no_serie`
),
 FOREIGN KEY (`no_serie`)
REFERENCES  `empresarial`.`tbl_factura_encabezado` (`no_serie`)
  )
 ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;
-- -----------------------------------------------------
-- Table `administracion`.`control pago`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS  `empresarial`.`tbl_control_pago` (
`no_serie` INT  NOT NULL ,
`PK_codigo_comprobacion`INT   NOT NULL ,
`codigo_devolucion_venta`INT NULL DEFAULT NULL,
`codigo_factura_encabezado`INT NULL DEFAULT NULL,
`codigo_cliente`INT NULL DEFAULT NULL,
`fecha_emision` VARCHAR(35) NULL DEFAULT NULL,
`fecha_vencimiento` VARCHAR(35) NULL DEFAULT NULL,
`saldo_comprobacion` FLOAT NULL DEFAULT NULL,
`estatus_pago` TINYINT NOT NULL,
  PRIMARY KEY (
`no_serie`,
`PK_codigo_comprobacion`
),
   
  FOREIGN KEY (`codigo_cliente`)
REFERENCES  `empresarial`.`tbl_cliente` (`PK_codigo_cliente`)

  )
 ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

-- -----------------------------------------------------
-- Table `administracion`.`balance_saldo_cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS  `empresarial`.`tbl_balance_saldo_cliente` (
`PK_codigo_salgo_cliente` INT  NOT NULL ,
`PK_codigo_comprobacion`INT NULL DEFAULT NULL,
`PK_codigo_cliente`INT NULL DEFAULT NULL,
`fecha_vencimiento` VARCHAR(35) NULL DEFAULT NULL,
`saldo_total` VARCHAR(35) NULL DEFAULT NULL,
`estatus_saldo` TINYINT NOT NULL,
  PRIMARY KEY (
   `PK_codigo_salgo_cliente`
  )
  )
 ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;
 
 -- -------------------------------------------
-- PROCESOS
-- -------------------------------------------
CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_solicitud_viaje`(
   `PK_id_solicitud` INT NOT NULL,
   `PK_id_reservacion` INT NOT NULL,
   `id_destino`INT NOT NULL,
   `id_transporte` INT NOT NULL,
   `precio_viaje` INT NOT NULL,
   PRIMARY KEY (`Pk_id_solicitud`),
   FOREIGN KEY (PK_id_reservacion) REFERENCES tbl_reservacion(PK_id_reservacion)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_menu_orden`(
   `PK_id_orden` INT NOT NULL,
   `PK_id_menu` INT NOT NULL,
   `cantidad_orden` INT NOT NULL,
   `no_mesa` INT NOT NULL,
   `horario_orden` VARCHAR(10) NOT NULL,
   `fecha_orden` DATE NOT NULL,
   `PK_id_metodo_pago` INT NOT NULL,
   `PK_id_habitacion` INT DEFAULT NULL,
   `total_orden` INT NOT NULL,
   PRIMARY KEY (`PK_id_orden`),
   FOREIGN KEY (PK_id_menu) REFERENCES tbl_menu_restaurante(PK_codigo_correlativo)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE `empresarial`.`tbl_asignacion_gobernanta` (
`PK_id_asignacion_gobernanta` INT NOT NULL AUTO_INCREMENT,
`PK_id_gobernanta` INT NOT NULL,
`PK_id_ama_de_llave` INT NOT NULL,
`estado_asignacion_gobernanta` TINYINT NOT NULL,
PRIMARY KEY (`PK_id_asignacion_gobernanta`),
FOREIGN KEY (`PK_id_gobernanta`) REFERENCES `tbl_empleado`(`PK_id_empleado`),
FOREIGN KEY (`PK_id_ama_de_llave`) REFERENCES `tbl_empleado`(`PK_id_empleado`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE `empresarial`.`tbl_asignacion_limpieza` (
`PK_id_asignacion_limpieza` INT NOT NULL,
`PK_id_asignacion_gobernanta` INT NOT NULL,
`PK_id_piso` INT NOT NULL,
`PK_id_horario` INT NOT NULL,
PRIMARY KEY (`PK_id_asignacion_limpieza`),
FOREIGN KEY (`PK_id_asignacion_gobernanta`) REFERENCES `tbl_asignacion_gobernanta`(`PK_id_asignacion_gobernanta`),
FOREIGN KEY (`PK_id_piso`) REFERENCES `tbl_piso`(`PK_id_piso`),
FOREIGN KEY (`PK_id_horario`) REFERENCES `tbl_horario`(`PK_id_horario`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;
