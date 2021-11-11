SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE SCHEMA IF NOT EXISTS `empresarial` DEFAULT CHARACTER SET utf8mb4;
USE `empresarial`;

-- -----------------------------------------------------
-- INICIO MANTENIMIENTOS
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_piso` (
`PK_id_piso` INT NOT NULL,
`cantidad_habitaciones_piso` INT NOT NULL,
`descripcion_piso` VARCHAR(200) NOT NULL,
`estado_piso` TINYINT NOT NULL,
PRIMARY KEY (`PK_id_piso`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;
INSERT INTO
`empresarial`.`tbl_piso`
VALUES
('1', '100', 'Habitaciones pequeñas', '1'),
('2', '100', 'Habitaciones medianas', '1'),
('3', '100', 'Habitaciones grandes', '1'),
('4', '10', 'Habitaciones presidenciales', '1');

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_horario` (
`PK_id_horario` INT NOT NULL,
`entrada_horario` VARCHAR(10) NOT NULL,
`salida_horario` VARCHAR(10) NOT NULL,
`horas_extras_horario` INT NOT NULL,
`descripcion_horario` VARCHAR(200) NOT NULL,
`estado_horario` TINYINT NOT NULL,
PRIMARY KEY (`PK_id_horario`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;
ALTER TABLE `empresarial`.`tbl_horario` DROP COLUMN `horas_extras_horario`;
INSERT INTO 
`empresarial`.`tbl_horario` 
VALUES 
('1', '1 am', '9 am', 'Horario matutino', '1'),
('2', '8 am', '4 pm', 'Horario de tarde', '1');

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_metodo_de_pago` (
`PK_id_metodo` INT NOT NULL,
`nombre_metodo` VARCHAR(50) NOT NULL,
`descripcion_metodo` VARCHAR(100) NOT NULL,
`estado_metodo` TINYINT NOT NULL,
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

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_servicio` (
`PK_id_servicio` INT NOT NULL,
`nombre_servicio` VARCHAR(50) NOT NULL,
`descripcion_servicio` VARCHAR(100) NOT NULL,
`precio_servicio` INT NOT NULL,
`tipo_servicio` TINYINT NOT NULL,
`estado_servicio` TINYINT NOT NULL,
PRIMARY KEY (`PK_id_servicio`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;
INSERT INTO
`empresarial`.`tbl_servicio`
VALUES
('1', 'Internet', '50mg', '150', '1', '1'),('2','Niñera','Cuido de niños menores de 10 años','250','2','1'),('3','Acceso VIP del Restaurante','acceso VIP del restaurante durante una noche','375','2','1'),('4','SPA','SPA para un máximo de 10 personas','500','1','1'),('5','Sector para Fumadores','Amplio sector para personas puedan fumar tranquilamente','150','1','1');

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_mantenimiento_habitacion` (
`PK_id_habitacion` INT NOT NULL,
`precio_habitacion` INT NOT NULL,
`PK_id_piso` INT NOT NULL,
`estado_habitacion` TINYINT NOT NULL,
`estado_limpieza` TINYINT NOT NULL,
`tipo_de_habitacion` INT NOT NULL,
`cantidad_maxima_persona` INT NOT NULL,
PRIMARY KEY (`PK_id_habitacion`),
FOREIGN KEY (`PK_id_piso`) REFERENCES `tbl_piso`(`PK_id_piso`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;
INSERT INTO
`empresarial`.`tbl_mantenimiento_habitacion`
VALUES
('1', '250', '1', '0', '1', '1', '5'),
('2', '250', '2', '1', '2', '1', '6'),
('3', '250', '3', '0', '1', '2', '7'),
('4', '250', '4', '1', '2', '2', '8'),
('5', '250', '1', '0', '1', '2', '9'),
('6', '250', '2', '0', '1', '1', '5'),
('7', '250', '3', '1', '2', '1', '6'),
('8', '250', '4', '0', '1', '2', '7'),
('9', '250', '1', '1', '2', '2', '8');

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_huesped` (
`PK_no_identificacion` INT NOT NULL,
`nombre_huesped` VARCHAR(50) NOT NULL,
`apellido_huesped` VARCHAR(100) NOT NULL,
`nacionalidad_huesped` VARCHAR(100) NOT NULL,
`direccion_huesped` VARCHAR(100) NOT NULL,
`sexo_huesped` VARCHAR(5) NOT NULL,
`telefono_huesped` INT DEFAULT NULL,
`cumpleaños_huesped` DATE DEFAULT NULL,
PRIMARY KEY (`PK_no_identificacion`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;
INSERT INTO
`empresarial`.`tbl_huesped`
VALUES
('1','Alberto','Suarez','Mexicano','alberto@gmail.com','M','12345678','2000-6-28'),('12','Luis Carlos','lee','Japones','leeluis@gmail.com','M','87654321','2000-6-28'),('123','Leonel','Gomez','Nigeriano','leo@gmail.com','M','123456789','2000-6-28'),('1234','Jefferson','Davila','Aleman','jeff@gmail.com','M','612345678','2000-6-28'),('12345','Gerson','Dominguez','Chileno','meda@gmail.com','M','1234585678','2000-6-28');

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_menu_restaurante` (
`PK_codigo_correlativo` INT NOT NULL,
`nombre_plato` VARCHAR(100) NOT NULL,
`descripcion_plato` VARCHAR(100) NOT NULL,
`precio_plato` INT NOT NULL,
`estado_plato` TINYINT NOT NULL,
PRIMARY KEY (`PK_codigo_correlativo`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;
INSERT INTO `empresarial`.`tbl_menu_restaurante` VALUES ('1', 'pizza', 'pizza clasica', '50', '1'),('12', 'burrito', 'burrito clasico', '20', '1'),('123','hamburguesa','hamburguesa clasica','30','0'),('1234', 'lasaña', 'lasaña clasica', '20', '0'),('12345', 'tacos', 'tacos clasicos', '10', '0');

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
('4', 'cosmeticos', '1'),
('5', 'libreria', '1'),
('6', 'medicamento', '1'),
('7', 'samsung', '1'),
('8', 'bebidas', '1'),
('9', 'ropa ', '1'),
('10', 'Coffe', '1'),
('11', 'Comida', '1'),
('12', 'Enbultidos', '1'),
('13', 'Dos Pinos', '1'),
('14', 'Carnes', '1'),
('15', 'Harinas', '1'),
('16', 'Fruta', '1'),
('17', 'Salsa', '1'),
('18', 'Verdura', '1'),
('19', 'Pan', '1'),
('20', 'Granos', '1'),
('21', 'Fideos', '1');


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
('5', 'kerns', '1'),
('6', 'bic', '1'),
('7', 'la granja', '1'),
('8', 'bimbo', '1'),
('9', 'claro ', '1'),
('10', 'splash', '1'),
('11', 'Toledo', '1'),
('12', 'Bremen', '1'),
('13', 'Virginia', '1'),
('14', 'FUD', '1'),
('15', 'Dos Pinos Pizza', '1'),
('16', 'Natural', '1'),
('17', 'Piña´s', '1'),
('18', 'Hambueguesa', '1'),
('19', 'Hass', '1'),
('20', 'La Chula', '1');


CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_bodega` (
`PK_codigo_bodega` INT  NOT NULL,
`nombre_bodega` VARCHAR(35) NULL DEFAULT NULL,
`estatus_bodega` TINYINT NOT NULL,
PRIMARY KEY (`PK_codigo_bodega`))
ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;
INSERT INTO
`empresarial`.`tbl_bodega` 
VALUES
('1', 'zona11', '1'),
('2', 'zona3', '1'),
('3', 'zona10', '1'),
('4', 'central', '1'),
('5', 'zona 15', '1'),
('6', 'zona 2', '1'),
('7', 'zona 5', '1'),
('8', 'zona 6', '1'),
('9', 'carretera el salvador', '1'),
('10', 'calzada la paz', '1');


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
('3', 'gramos', 'gr', '1'),
('4', 'arroba', '@', '1'),
('5', 'unidades', 'u', '1'),
('6', 'kilogramo', 'kg', '1'),
('7', 'onza', 'onz', '1'),
('8', 'miligramos', 'mili', '1');


CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_transporte` (
`PK_codigo_transporte` INT  NOT NULL,
`clase_transporte` VARCHAR(35) NULL DEFAULT NULL,
`marca_transporte` VARCHAR(35) NULL DEFAULT NULL,
`modelo_transporte` VARCHAR(35) NULL DEFAULT NULL,
`tipo_transporte` VARCHAR(35) NULL DEFAULT NULL,
`placa_transporte` VARCHAR(10) NULL DEFAULT NULL,
`color_transporte` VARCHAR(35) NULL DEFAULT NULL,
`estado_transporte` VARCHAR(35) NULL DEFAULT NULL,
`numero_motor_transporte` VARCHAR(35) NULL DEFAULT NULL, 
`estatus_transporte` TINYINT NOT NULL,
PRIMARY KEY (`PK_codigo_transporte`))
ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;
INSERT INTO 
`empresarial`.`tbl_transporte`
(`PK_codigo_transporte`, `clase_transporte`, `marca_transporte`,
 `modelo_transporte`, `tipo_transporte`, `placa_transporte`, `color_transporte`, 
 `estado_transporte`, `numero_motor_transporte`, `estatus_transporte`) 
 VALUES 
('1', 'Liviano 4 puertas', 'Volvo', '2019', 'Liviano', '584PHP', 'Azul', 'Buen estado', '854555568', '1'),
('2', 'PickUp 4X4', 'Honda', '2017', 'PickUp', '854SJK', 'Negro', 'Buen Estado', '745558944452', '1'),
('3', 'Camioneta', 'Mitsubishi Lanser', '2020', 'Liviano', '852ETY', 'Plateado', 'Buen Estado', '45877744', '1');
    
    
CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_producto` (
`PK_codigo_producto` INT  NOT NULL, 
`nombre_producto` VARCHAR(35) NULL DEFAULT NULL,
`descripcion_producto` VARCHAR(35) NULL DEFAULT NULL,
`precio_producto` INT DEFAULT NULL,
`costo_producto` INT DEFAULT NULL,
`estatus_producto` TINYINT NOT NULL,
`codigo_linea` INT NULL DEFAULT NULL,
`codigo_marca` INT NULL DEFAULT NULL,
`codigo_bodega` INT NULL DEFAULT NULL,
`codigo_unidad` INT NULL DEFAULT NULL,
PRIMARY KEY (
`PK_codigo_producto`),
FOREIGN KEY (`codigo_linea`)
REFERENCES `empresarial`.`tbl_linea` (`PK_codigo_linea`),
FOREIGN KEY (`codigo_marca`)
REFERENCES `empresarial`.`tbl_marca` (`PK_codigo_marca`),   
FOREIGN KEY (`codigo_bodega`)
REFERENCES `empresarial`.`tbl_bodega` (`PK_codigo_bodega`),
FOREIGN KEY (`codigo_unidad`)
REFERENCES `empresarial`.`tbl_unidad` (`PK_codigo_unidad`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;
INSERT INTO 
`empresarial`.`tbl_producto` 
(`PK_codigo_producto`, `nombre_producto`, `descripcion_producto`,
 `precio_producto`, `costo_producto`, `estatus_producto`, `codigo_linea`, 
 `codigo_marca`, `codigo_bodega`, `codigo_unidad`) 
 VALUES 
('1', 'base liquida', 'base liquida tono 2A', '800', '200', '1', '1', '1', '1', '1'),
('2', 'jugo ', 'jugo naranja', '20', '10', '1', '2', '2', '2', '2'),
('3', 'Frijoles', 'Frijol negro ducal', '25', '20', '1', '1', '2', '4', '2'),
('4', 'Lapicero', 'Lapicero azul', '20', '10', '1', '5', '6', '2', '5'),
('5', 'Television', 'Televisión LG 2000', '5000', '1000', '1', '2', '4', '5', '5'),
('6', 'Tennis Deportivos', 'Tenis Nike Color Negro', '1000', '500', '1', '2', '4', '7', '5'),
('7', 'SalAndrews', 'Medicamento', '20', '12', '1', '6', '3', '2', '5'),
('8', 'Tortilla', 'Tortilla de harina', '200', '50', '1', '15', '16', '2', '5'),
('9', 'Cafe frio', 'Caffe Moka Frio', '15', '12', '1', '10', '1', '8', '1'),
('10', 'Harina', 'Harina para tacos', '300', '100', '1', '15', '16', '2', '3'),
('11', 'Carne Molida', 'Carne Molida', '80', '20', '1', '14', '13', '1', '2'),
('12', 'Queso', 'Queso Mozarella', '100', '40', '1', '13', '15', '2', '5'),
('13', 'Peperoni', 'Peperoni ', '120', '80', '1', '11', '13', '2', '5'),
('14', 'Salsa', 'Salsa de Tomate', '200', '80', '1', '17', '16', '2', '5'),
('15', 'Harina ', 'Harina para Pizza', '200', '80', '1', '15', '16', '2', '2'),
('16', 'Piña', 'Piña dulce', '100', '80', '1', '16', '17', '2', '5'),
('17', 'Harina', 'Harina para tortilla', '100', '70', '1', '15', '8', '2', '2'),
('18', 'Aguacate', 'Aguacate Mexicano', '100', '80', '1', '18', '19', '2', '2'),
('19', 'Pan', 'Pan para hamburguesa', '120', '80', '1', '19', '18', '2', '5'),
('20', 'Fideos', 'Fideos para lasagna', '100', '80', '1', '21', '16', '2', '5'),
('21', 'frijol', 'Frijol Volteado', '200', '90', '1', '20', '20', '2', '5'),
('22', 'lechuga', 'lechuga grande', '150', '90', '1', '18', '16', '2', '2');



CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_existencia` (
`Pk_codigo_producto` INT  NOT NULL,
`Pk_codigo_bodega` INT  NOT NULL,
`cantidad_existencia` INT NULL DEFAULT NULL,
`fecha_entrada_existencia` DATE DEFAULT NULL,
`fecha_salida_existencia` DATE DEFAULT NULL,
`estatus_existencia` TINYINT NOT NULL,
PRIMARY KEY ( 
`Pk_codigo_producto`,
`Pk_codigo_bodega`),
FOREIGN KEY (`PK_codigo_producto`)
REFERENCES `empresarial`.`tbl_producto` (`PK_codigo_producto`),
FOREIGN KEY (`PK_codigo_bodega`)
REFERENCES `empresarial`.`tbl_bodega` (`PK_codigo_bodega`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;
INSERT INTO `empresarial`.`tbl_existencia` 
VALUES 
( '1', '1', '10', '2021/10/5', '2021/10/2', '1'),
('2', '2', '20', '2021/8/15', '2021/9/30', '1'),
('3', '3', '30', '2021/7/5', '2021/8/10', '1');


CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_ingredientes_menu` (
`PK_codigo_correlativo` INT AUTO_INCREMENT NOT NULL,
`id_plato_menu` INT NOT NULL,
`id_codigo_producto` INT NOT NULL,
`cantidad_ingrediente` FLOAT NOT NULL,
PRIMARY KEY (`PK_codigo_correlativo`),
FOREIGN KEY (`id_plato_menu`) REFERENCES `tbl_menu_restaurante`(`PK_codigo_correlativo`),
FOREIGN KEY (`id_codigo_producto`) REFERENCES `tbl_producto`(`PK_codigo_producto`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

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
('3', 'walmart', 'zona6', '51169326', '26008785', 'walmartl@gmail.com', 'Marisol Caal', '1'),
('4', 'Sears', 'zona1', '26007089', '56667899', 'sears@gmail.com', 'Francisco Rodriguez', '1'),
('5', 'Distefano', 'zona17', '22001234', '77009000', 'distefano@gmail.com', 'Matias Montalvo', '1');

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
('1', 'Gobernanta', '1000'), 
('2', 'Ama de Llave', '1000'), 
('3', 'Seguridad', '1000');

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_moneda` (
  `Codigo_Moneda` INT NOT NULL AUTO_INCREMENT,
  `Nombre_Moneda` VARCHAR(100) NOT NULL,
  `Simbolo_Moneda` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`Codigo_Moneda`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_tipo_asiento` (
  `Codigo_TipoAsiento` INT NOT NULL AUTO_INCREMENT,
  `Tipo_AsientoDesc` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`Codigo_TipoAsiento`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_clasificacioncuenta` (
  `Codigo_clasificacion` INT NOT NULL AUTO_INCREMENT,
  `Clasificacion_CuentaNombre` VARCHAR(100) NOT NULL,
  `Descripcion_Clasificacion` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`Codigo_clasificacion`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_periodofiscal` (
  `Codigo_PeriodoFiscal` INT NOT NULL AUTO_INCREMENT,
  `Fecha_inicioPF` VARCHAR(100) NOT NULL,
  `Fecha_finPF` VARCHAR(100) NOT NULL,
  `Estado_PeriodoFiscal` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`Codigo_PeriodoFiscal`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_banco` (
  `Codigo_Banco` INT NOT NULL AUTO_INCREMENT,
  `Nombre_Banco` VARCHAR(100) NOT NULL,
  `Clave_Banco` VARCHAR(100) NOT NULL,
  `Telefono_Banco` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`Codigo_Banco`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_tipopersona` (
  `Codigo_TipoPersona` INT NOT NULL AUTO_INCREMENT,
  `TipoPersona_Nombres` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`Codigo_TipoPersona`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_deposito` (
`ID_DOCUMENTO` INT NOT NULL AUTO_INCREMENT,
 `Codigo_CuentaHabiente` VARCHAR(10) NOT NULL,
  `Balance` VARCHAR(100) NOT NULL,
  `Transaccion` VARCHAR(100) NOT NULL,
  `fecha` DATE NOT NULL,
    PRIMARY KEY (`ID_DOCUMENTO`),
     FOREIGN KEY (`Codigo_CuentaHabiente`)
    REFERENCES `empresarial1`.`bl_cuentahabiente` (`Codigo_CuentaHabiente`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_tipotransaccion` (
  `Codigo_TipoTransaccion` INT NOT NULL AUTO_INCREMENT,
  `Transaccion_Tipo` VARCHAR(100) NOT NULL,
  `Efecto_TipoTransaccion` INT(11) NOT NULL,
  PRIMARY KEY (`Codigo_TipoTransaccion`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_departamento`(
`id_departamento` INT NOT NULL AUTO_INCREMENT,
`nombre_departamento` VARCHAR(60) NOT NULL,
`estado_departamento` VARCHAR(1) NOT NULL,
PRIMARY KEY (`id_departamento`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_concepto`(
`id_concepto` INT NOT NULL AUTO_INCREMENT,
`nombre_concepto` VARCHAR(40) NOT NULL,
`efecto_concepto` VARCHAR(10) NOT NULL,
PRIMARY KEY (`id_concepto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_concepto_planilla`(
`id_conceptoPlanilla` INT NOT NULL AUTO_INCREMENT,
`nombre_concepto` VARCHAR(20),
`tipo_concepto`  VARCHAR(10),
`clase_concepto` VARCHAR(25),
`Valor_concepto` FLOAT(10,2),
PRIMARY KEY (`id_conceptoPlanilla`))
ENGINE = InnoDB 
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_planilla_enc`(
`id_planillaenc` INT NOT NULL AUTO_INCREMENT,
`total_percepcion` FLOAT(10,2),
`total_deduccion` FLOAT(10,2),
`total_liquido`  FLOAT(10,2),
PRIMARY KEY (`id_planillaenc`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

-- -----------------------------------------------------
-- FIN MANTENIMIENTOS
-- -----------------------------------------------------


-- -----------------------------------------------------
-- INICIO PROCESOS
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_empleado` (
`PK_id_empleado` INT NOT NULL AUTO_INCREMENT,
`nombre_empleado` VARCHAR(45) NULL DEFAULT NULL,
`apellido_empleado` VARCHAR(45) NULL DEFAULT NULL,
`dpi_empleado` VARCHAR(15) NULL DEFAULT NULL,
`correo_empleado` VARCHAR(45) NULL DEFAULT NULL,
`puesto_empleado` INT NULL DEFAULT NULL,
`estado_empleado` TINYINT NULL DEFAULT NULL,
`fechacontrato_empleado` DATE NULL DEFAULT NULL,
PRIMARY KEY (`PK_id_empleado`),
FOREIGN KEY (`puesto_empleado`) REFERENCES `tbl_puesto`(`PK_id_puesto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;
INSERT INTO
`empresarial`.`tbl_empleado`
VALUES
('1', 'Karol', 'Garcia', '12345', 'karol@gmail.com', '1', '1', '2021-10-19'),
('2', 'Darlyn', 'Garcia', '12345', 'karolq@gmail.com', '2', '1', '2021-10-19'),
('3', 'Karla', 'Garcia', '12345', 'karolq@gmail.com', '2', '1', '2021-10-19'),
('4', 'Esmeralda', 'Garcia', '12345', 'karolq@gmail.com', '2', '1', '2021-10-19'),
('5', 'Yury', 'Garcia', '12345', 'karolq@gmail.com', '2', '1', '2021-10-19'),
('6', 'karmen', 'Garcia', '12345', 'karol@gmail.com', '1', '1', '2021-10-19'),
('7', 'tulio', 'Garcia', '12345', 'karolq@gmail.com', '2', '1', '2021-10-19'),
('8', 'herbert', 'Garcia', '12345', 'karolq@gmail.com', '2', '1', '2021-10-19'),
('9', 'luis', 'Garcia', '12345', 'karolq@gmail.com', '2', '1', '2021-10-19'),
('10', 'nicolas', 'Garcia', '12345', 'karolq@gmail.com', '1', '1', '2021-10-19');

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_tarifa` (
`PK_id_tarifa` INT AUTO_INCREMENT NOT NULL,
`id_habitacion_tarifa` INT NOT NULL,
`nombre_tarifa` VARCHAR(60) NULL DEFAULT NULL,
`estado_tarifa` TINYINT NULL DEFAULT NULL,
PRIMARY KEY (`PK_id_tarifa`),
FOREIGN KEY (id_habitacion_tarifa) REFERENCES tbl_mantenimiento_habitacion(PK_id_habitacion)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;
INSERT INTO `tbl_tarifa` VALUES ('1', '1', 'BARATA HABITACIÓN 1', '1'), ('2', '2', 'BARATA HABITACIÓN 2', '1'), ('3', '3', 'BARATA HABITACIÓN 3', '1'), ('4', '4', 'CARA HABITACIÓN 4', '1');

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_paquete_servicios` (
`PK_correlativo_paquete` INT AUTO_INCREMENT NOT NULL,
`id_tarifa_paquete` INT NOT NULL,
`id_servicio_paquete` INT NOT NULL,
PRIMARY KEY (`PK_correlativo_paquete`),
FOREIGN KEY (id_tarifa_paquete) REFERENCES tbl_tarifa(PK_id_tarifa),
FOREIGN KEY (id_servicio_paquete) REFERENCES tbl_servicio(PK_id_servicio)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;
INSERT INTO `tbl_paquete_servicios` VALUES ('1', '1', '1'), ('2', '2', '1'), ('3', '3', '1'), ('4', '3', '5'), ('5', '4', '1'), ('6', '4', '4'), ('7', '4', '5');

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
INSERT INTO `tbl_reservacion` VALUES ('1', '2021-11-05', '2021-11-05', '2021-11-12', '1', '2', '1'), ('2', '2021-11-05', '2021-11-05', '2021-11-12', '12345', '2', '1');

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_detalle_reservacion` (
`Pk_correlativo_detalle` INT AUTO_INCREMENT NOT NULL,
`id_reservacion_detalle` INT NOT NULL,
`id_tarifa_detalle` INT NOT NULL,
PRIMARY KEY (`Pk_correlativo_detalle`),
FOREIGN KEY (id_tarifa_detalle) REFERENCES tbl_tarifa(PK_id_tarifa),
FOREIGN KEY (id_reservacion_detalle) REFERENCES tbl_reservacion(PK_id_reservacion)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;
INSERT INTO `tbl_detalle_reservacion` VALUES ('1', '1', '1'), ('2', '1', '2'), ('3', '2', '3'), ('4', '2', '4');

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_registro_tarjetas` (
`PK_id_reservacion` INT AUTO_INCREMENT NOT NULL,
`no_tarjeta` INT NOT NULL,
PRIMARY KEY (`PK_id_reservacion`),
FOREIGN KEY (PK_id_reservacion) REFERENCES tbl_reservacion(PK_id_reservacion)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;
INSERT INTO `tbl_registro_tarjetas` VALUES ('1', '123456789'), ('2', '123456780');

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_detalle_servicioextra` (
`Pk_correlativo_detalle` INT AUTO_INCREMENT NOT NULL,
`id_reservacion` INT NOT NULL,
`id_servicio` INT NOT NULL,
PRIMARY KEY (`Pk_correlativo_detalle`),
FOREIGN KEY (id_reservacion) REFERENCES tbl_reservacion(PK_id_reservacion),
FOREIGN KEY (id_servicio) REFERENCES tbl_servicio(PK_id_servicio)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_menu_orden_encabezado`(
`PK_id_orden_encabezado` INT AUTO_INCREMENT,
`id_habitacion` INT NOT NULL,
`mesa_orden` VARCHAR(10) NOT NULL,
`fecha_orden` DATE NOT NULL,
`horario_orden` TIME NOT NULL,
PRIMARY KEY (`PK_id_orden_encabezado`),
FOREIGN KEY (id_habitacion) REFERENCES tbl_mantenimiento_habitacion(PK_id_habitacion)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_menu_orden_detalle`(
`PK_id_orden_detalle` INT AUTO_INCREMENT,
`id_orden_encabezado` INT NOT NULL,
`id_menu` INT NOT NULL,
`cantidad_orden` INT NOT NULL,
`estado_orden` TINYINT NOT NULL,
PRIMARY KEY (`PK_id_orden_detalle`),
FOREIGN KEY (id_orden_encabezado) REFERENCES tbl_menu_orden_encabezado(PK_id_orden_encabezado),
FOREIGN KEY (id_menu) REFERENCES tbl_menu_restaurante(PK_codigo_correlativo)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_cocina_restaurante` (
`Pk_correlativo_cocina` INT AUTO_INCREMENT NOT NULL,
`hora_despacho` TIME NOT NULL,
`id_orden` INT NOT NULL,
`PK_id_menu` INT NOT NULL,
PRIMARY KEY (`Pk_correlativo_cocina`),
FOREIGN KEY (id_orden) REFERENCES tbl_menu_orden_detalle(PK_id_orden_detalle),
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
INSERT INTO `tbl_asignacion_gobernanta` 
VALUES ('1', '1', '2', '1'), 
('2', '1', '4', '1'), 
('3', '6', '3', '1'), 
('4', '6', '7', '1'), 
('5', '10', '8', '1'),
('6', '1', '5', '1'), 
('7', '1', '9', '1'),
('8', '1', '8', '1');

CREATE TABLE `empresarial`.`tbl_asignacion_limpieza` (
`PK_id_asignacion_limpieza` INT NOT NULL AUTO_INCREMENT,
`PK_id_asignacion_gobernanta` INT NOT NULL,
`PK_id_piso` INT NOT NULL,
`PK_id_horario` INT NOT NULL,
`estado_asignacion_limpieza` TINYINT NOT NULL,
PRIMARY KEY (`PK_id_asignacion_limpieza`),
FOREIGN KEY (`PK_id_asignacion_gobernanta`) REFERENCES `tbl_empleado`(`PK_id_empleado`),
FOREIGN KEY (`PK_id_piso`) REFERENCES `tbl_piso`(`PK_id_piso`),
FOREIGN KEY (`PK_id_horario`) REFERENCES `tbl_horario`(`PK_id_horario`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE `empresarial`.`tbl_detalle_limpieza` (
`PK_id_detalle_limpieza` INT AUTO_INCREMENT,
`id_asignacion_gobernanta` INT DEFAULT NULL,
`id_asignacion_limpieza` INT DEFAULT NULL,
PRIMARY KEY (`PK_id_detalle_limpieza`),
FOREIGN KEY (`id_asignacion_gobernanta`) REFERENCES `tbl_asignacion_gobernanta`(`PK_id_asignacion_gobernanta`),
FOREIGN KEY (`id_asignacion_limpieza`) REFERENCES `tbl_asignacion_limpieza`(`PK_id_asignacion_limpieza`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_objeto_perdido` (
`PK_id_objeto` INT NOT NULL,
`PK_id_habitacion` INT NOT NULL,
`PK_id_ama_de_llaves` INT NOT NULL,
`fecha_encontrado` DATE NOT NULL,
`objeto` VARCHAR(50) NOT NULL,
`identificacion` VARCHAR(50) DEFAULT NULL,
`estado` TINYINT NOT NULL,
`Fecha_Entregado` DATE DEFAULT NULL,
PRIMARY KEY (`PK_id_objeto`),
FOREIGN KEY (PK_id_habitacion) REFERENCES tbl_mantenimiento_habitacion(PK_id_habitacion))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
INSERT INTO 
`empresarial`.`tbl_objeto_perdido` 
VALUES
('1', '1', '1', '2021-04-17', 'Telefono', '12345678', '2', '2021-04-18'),
('2', '1', '1', '2021-04-17', 'Juguete', '123', '2', '2021-04-18'),
('3', '1', '1', '2021-04-17', 'Computadora', 'NULL', '1', '1111-11-11'),
('4', '1', '1', '2021-04-17', 'Telefono', '123', '2', '2021-04-18'),
('5', '1', '1', '2021-04-20', 'Audifonos', '12345678', '2', '2021-04-21');

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_check_in_out` (
  `PK_correlativo` INT AUTO_INCREMENT NOT NULL,
  `id_reservacion_detalle` INT NOT NULL,
  `validacion_entrada` DATE DEFAULT NULL,
  `validacion_salida` DATE DEFAULT NULL,
  `id_tarifa_detalle` INT NOT NULL,
  `estado` TINYINT NOT NULL,
   PRIMARY KEY (`PK_correlativo`),
   FOREIGN KEY (id_tarifa_detalle) REFERENCES tbl_tarifa(PK_id_tarifa),
   FOREIGN KEY (id_reservacion_detalle) REFERENCES tbl_reservacion(PK_id_reservacion)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO `tbl_check_in_out` VALUES ('1', '1', null , null , '1', '0'), ('2', '1', null , null , '2', '0'), ('3', '2', null , null , '3', '0'), ('4', '2', null , null , '4', '0' );

 CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_transporteruta` (
`PK_codigo_transporteruta` INT  NOT NULL,
`nombre_conductoruta` VARCHAR(35) NULL DEFAULT NULL,  
`nombre_transporteruta` VARCHAR(35) NULL DEFAULT NULL, 
`tipo_transporteruta` VARCHAR(35) NULL DEFAULT NULL,
`ubicacion_transporteruta` VARCHAR(35) NULL DEFAULT NULL, 
`direccion_transporteruta` VARCHAR(35) NULL DEFAULT NULL, 
`hora_salida_transporteruta` TIME NULL DEFAULT NULL,     
`hora_entrada_transporteruta` TIME NULL DEFAULT NULL,
`estatus_transporteruta` TINYINT NOT NULL,
PRIMARY KEY (`PK_codigo_transporteruta`))
ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;
INSERT INTO
`empresarial`.`tbl_transporteruta`
VALUES
('1', 'Luis', 'Volvo', 'Liviano', 'Zona 10', 'Zona 1', '03:00:00', '02:10:00', '1'),
('2', 'Marcos', 'Toyota', 'Liviano', 'Zona 5', 'Zona 15', '11:00:00', '10:00:00', '1'),
('3', 'Maria', 'Hyunday', 'Liviano', 'Zona 10', 'Antigua Guatemala', '12:30:00', '10:20:00', '1'); 

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_solicitud_viaje`(
`PK_id_solicitud` INT NOT NULL,
`PK_id_habitacion` INT NOT NULL,
`PK_id_transporte` INT NOT NULL,
`destino_viaje`VARCHAR (100) NOT NULL,
`precio_viaje` INT NOT NULL,
PRIMARY KEY (`Pk_id_solicitud`),
FOREIGN KEY (PK_id_habitacion) REFERENCES tbl_mantenimiento_habitacion(PK_id_habitacion),
FOREIGN KEY (PK_id_transporte) REFERENCES tbl_transporte(PK_codigo_transporte)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_movimiento_encabezado_inventario` (
`Pk_codigo_movimiento_encabezado_inventario` INT  NOT NULL,
`Pk_codigo_tipo_documento` INT  NOT NULL,
`estatus_movimiento` TINYINT(2) NOT NULL,
  PRIMARY KEY ( 
  `Pk_codigo_movimiento_encabezado_inventario`,
 `Pk_codigo_tipo_documento`
),
FOREIGN KEY (Pk_codigo_tipo_documento) REFERENCES tbl_tipo_documento (Pk_codigo_tipo_documento)

  ) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;


CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_movimiento_detalle_inventario` (
`Pk_codigo_movimiento_detalle_inventario` INT  NOT NULL,
`PK_codigo_producto` INT  NOT NULL,
`estatus_movimiento_detalle` TINYINT(2) NOT NULL,
  PRIMARY KEY ( 
  `Pk_codigo_movimiento_detalle_inventario`,
   `PK_codigo_producto`
),
FOREIGN KEY (PK_codigo_producto) REFERENCES tbl_producto(PK_codigo_producto)

  ) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;
  
 
CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_tipo_documento` (
`Pk_codigo_tipo_documento` INT  NOT NULL,
`nombre_tipo_documento` VARCHAR(35) NULL DEFAULT NULL,
`estatus_tipo_documento` TINYINT(2) NOT NULL,
  PRIMARY KEY ( Pk_codigo_tipo_documento)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_compra_encabezado` (
`PK_codigo_factura` INT NOT NULL,
`PK_codigo_bodega` INT NOT NULL,
`codigo_proveedor` INT NOT NULL,
`fecha_emision` DATE DEFAULT NULL,
`fecha_vencimiento` DATE DEFAULT NULL,
`codigo_pago` INT NOT NULL,
`estatus_factura` TINYINT NOT NULL,
PRIMARY KEY (
`PK_codigo_factura`,
`Pk_codigo_bodega`
),
FOREIGN KEY (`codigo_proveedor`)
REFERENCES `empresarial`.`tbl_proveedor` (`PK_codigo_proveedor`),
FOREIGN KEY (`codigo_pago`)
REFERENCES `empresarial`.`tbl_forma_pago` (`PK_codigo_pago`)
)ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_compra_detalle` (
`correlativo` INT AUTO_INCREMENT,
`PK_codigo_factura` INT NOT NULL,
`PK_codigo_producto` INT NOT NULL,
`PK_codigo_bodega` INT NOT NULL,
`cantidad_detalle` INT NOT NULL,
`costo_detalle` INT NOT NULL,
`total_detalle` INT NOT NULL,
PRIMARY KEY (
`correlativo`,
`PK_codigo_factura`,
`PK_codigo_producto` ,
`Pk_codigo_bodega`
),
FOREIGN KEY (`Pk_codigo_factura`)
REFERENCES `empresarial`.`tbl_compra_encabezado` (`PK_codigo_factura`),
FOREIGN KEY (`Pk_codigo_producto`)
REFERENCES `empresarial`.`tbl_producto` (`PK_codigo_producto`),
FOREIGN KEY (`PK_codigo_bodega`)
REFERENCES `empresarial`.`tbl_bodega` (`PK_codigo_bodega`)   
)ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_ordencompra_encabezado` (
`PK_codigo_ordencompra` INT NOT NULL,
`PK_codigo_bodega` INT NOT NULL,
`codigo_proveedor` INT NOT NULL,
`fecha_emision` DATE DEFAULT NULL,
`fecha_entrega` DATE DEFAULT NULL,
`codigo_pago`INT NOT NULL,
`estatus_ordencompra` TINYINT NOT NULL,
PRIMARY KEY (
`PK_codigo_ordencompra`,
`Pk_codigo_bodega`),
FOREIGN KEY (`codigo_proveedor`)
REFERENCES `empresarial`.`tbl_proveedor` (`PK_codigo_proveedor`),
FOREIGN KEY (`codigo_pago`)
REFERENCES `empresarial`.`tbl_forma_pago` (`PK_codigo_pago`)
)ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_ordencompra_detalle` (
`correlativo` INT AUTO_INCREMENT,
`PK_codigo_ordencompra` INT NOT NULL,
`PK_codigo_producto` INT NOT NULL,
`PK_codigo_bodega` INT NOT NULL,
`cantidad_detalle` INT NOT NULL,
`costo_detalle` INT NOT NULL,
`total_detalle` INT NOT NULL,
PRIMARY KEY (
`correlativo` ,
`PK_codigo_ordencompra`,
`PK_codigo_producto` ,
`Pk_codigo_bodega`),
FOREIGN KEY (`PK_codigo_ordencompra`)
REFERENCES `empresarial`.`tbl_ordencompra_encabezado` (`PK_codigo_ordencompra`),
FOREIGN KEY (`Pk_codigo_producto`)
REFERENCES `empresarial`.`tbl_producto` (`PK_codigo_producto`),
FOREIGN KEY (`PK_codigo_bodega`)
REFERENCES `empresarial`.`tbl_bodega` (`PK_codigo_bodega`)   
)ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_autorizacion_ordencompra` (
`PK_codigo_autorizacion` INT NOT NULL,
`codigo_ordencompra` INT NOT NULL,
`nombre_autorizacion` VARCHAR(35) NULL DEFAULT NULL,
`departamento_autorizacion` VARCHAR(35) NULL DEFAULT NULL,
`fecha_autorizacion` VARCHAR(35) NULL DEFAULT NULL,
`estatus_autorizacion` TINYINT NOT NULL,
PRIMARY KEY (`PK_codigo_autorizacion`),
FOREIGN KEY (`codigo_ordencompra`)
REFERENCES `empresarial`.`tbl_ordencompra_encabezado` (`PK_codigo_ordenCompra`))
ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;


CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_recepcioncompra_encabezado` (
`PK_codigo_recepcioncompra` INT NOT NULL,
`PK_codigo_bodega` INT NOT NULL,
`codigo_proveedor` INT NOT NULL,
`fecha_emision` DATE DEFAULT NULL,
`fecha_entrega` DATE DEFAULT NULL,
`estatus_recepcion` TINYINT NOT NULL,
PRIMARY KEY (
`PK_codigo_recepcioncompra`,
`Pk_codigo_bodega`),
FOREIGN KEY (`codigo_proveedor`)
REFERENCES `empresarial`.`tbl_proveedor` (`PK_codigo_proveedor`)
)ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_recepcioncompra_detalle` (
`correlativo` INT AUTO_INCREMENT,
`PK_codigo_recepcioncompra` INT NOT NULL,
`PK_codigo_producto` INT NOT NULL,
`PK_codigo_bodega` INT NOT NULL,
`cantidad_detalle` INT NOT NULL,
`costo_detalle` INT NOT NULL,
`total_detalle` INT NOT NULL,
PRIMARY KEY (
`correlativo` ,
`PK_codigo_recepcioncompra`,
`PK_codigo_producto` ,
`Pk_codigo_bodega`),
FOREIGN KEY (`PK_codigo_recepcioncompra`)
REFERENCES `empresarial`.`tbl_recepcioncompra_encabezado` (`PK_codigo_recepcioncompra`),
FOREIGN KEY (`Pk_codigo_producto`)
REFERENCES `empresarial`.`tbl_producto` (`PK_codigo_producto`),
FOREIGN KEY (`PK_codigo_bodega`)
REFERENCES `empresarial`.`tbl_bodega` (`PK_codigo_bodega`)   
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_devolucioncompra_encabezado` (
`PK_codigo_devolucioncompra` INT NOT NULL,
`PK_codigo_bodega` INT NOT NULL,
`codigo_proveedor` INT NOT NULL,
`fecha_emision` DATE DEFAULT NULL,
`fecha_entrega` DATE DEFAULT NULL,
`estatus_devolucion` TINYINT NOT NULL,
PRIMARY KEY (
`PK_codigo_devolucioncompra`,
`Pk_codigo_bodega`),
FOREIGN KEY (`codigo_proveedor`)
REFERENCES `empresarial`.`tbl_proveedor` (`PK_codigo_proveedor`)
)ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_devolucioncompra_detalle` (
`correlativo` INT AUTO_INCREMENT,
`PK_codigo_devolucioncompra` INT NOT NULL,
`PK_codigo_producto` INT NOT NULL,
`PK_codigo_bodega` INT NOT NULL,
`cantidad_detalle` INT NOT NULL,
`costo_detalle` INT NOT NULL,
`total_detalle` INT NOT NULL,
PRIMARY KEY (
`correlativo` ,
`PK_codigo_devolucioncompra`,
`PK_codigo_producto` ,
`Pk_codigo_bodega`),
FOREIGN KEY (`PK_codigo_devolucioncompra`)
REFERENCES `empresarial`.`tbl_devolucioncompra_encabezado` (`PK_codigo_devolucioncompra`),
FOREIGN KEY (`Pk_codigo_producto`)
REFERENCES `empresarial`.`tbl_producto` (`PK_codigo_producto`),
FOREIGN KEY (`PK_codigo_bodega`)
REFERENCES `empresarial`.`tbl_bodega` (`PK_codigo_bodega`)   
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_control_pagos_proveedores` (
`folio` INT AUTO_INCREMENT,
`codigo_proveedor` INT   NOT NULL ,
`transaccion`	Varchar(25),
`fecha_emision` DATE DEFAULT NULL ,
`fecha_atraso` DATE DEFAULT NULL ,
`dias_vencidos` varchar(25),
`total_detalle` INT NOT NULL,
PRIMARY KEY (
`folio`),
FOREIGN KEY (`codigo_proveedor`)
REFERENCES `empresarial`.`tbl_proveedor` (`PK_codigo_proveedor`)
)ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_balance_saldo_proveedores` (
`PK_codigo_documento` INT   NOT NULL ,
`codigo_proveedor` INT   NOT NULL ,
`transaccion`	Varchar(25),
`fecha_emision` DATE DEFAULT NULL ,
`fecha_atraso` DATE DEFAULT NULL ,
`dias_vencidos` varchar(25),
`total_detalle` INT NOT NULL,
PRIMARY KEY (
`PK_codigo_documento`),
FOREIGN KEY (`codigo_proveedor`)
REFERENCES `empresarial`.`tbl_proveedor` (`PK_codigo_proveedor`)
)ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS  `empresarial`.`tbl_control_precio_encabezado` (
 `no_serie` INT NOT NULL ,
   `codigo_servicio`INT   NOT NULL,
    `precio` Float(35) NULL DEFAULT NULL,
   `precio_cambio` Float(35) NULL DEFAULT NULL,
   `fecha_emision` VARCHAR(35) NULL DEFAULT NULL,
	`estatus_precio` TINYINT(2) NOT NULL,
     
  PRIMARY KEY (
  `no_serie`
)

  )ENGINE = InnoDB
 ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;



CREATE TABLE IF NOT EXISTS  `empresarial`.`tbl_cotizacion_encabezado` (
`no_serie` INT AUTO_INCREMENT  NOT NULL ,
`codigo_reservacion`INT  NOT NULL ,

`PK_codigo_cotizacion_encabezado`INT   NOT NULL ,
`codigo_cliente`INT NULL DEFAULT NULL,
`codigo_cobrador`INT NULL DEFAULT NULL,
`codigo_vendedor`INT NULL DEFAULT NULL,
`fecha_emision` VARCHAR(35) NULL DEFAULT NULL,
`fecha_vencimiento` VARCHAR(35) NULL DEFAULT NULL,
`codigo_servicio`INT NULL DEFAULT NULL,
`impuesto_iva_encabezado` FLOAT(35) NULL DEFAULT NULL,
`subtotal_encabezado` FLOAT(35) NULL DEFAULT NULL,
`estatus_cotizacion` TINYINT(2) NOT NULL,
  PRIMARY KEY (
`no_serie`
),
    FOREIGN KEY (`codigo_cliente`)
REFERENCES  `empresarial`.`tbl_cliente` (`PK_codigo_cliente`),
FOREIGN KEY ( `codigo_vendedor`)
REFERENCES  `empresarial`.`tbl_vendedor` (`PK_codigo_vendedor`),
 FOREIGN KEY ( `codigo_cobrador`)
REFERENCES  `empresarial`.`tbl_cobrador` ( `PK_codigo_cobrador`)
  )
 ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;


CREATE TABLE IF NOT EXISTS  `empresarial`.`tbl_cotizacion_detalle` (
`no_serie`INT NOT NULL ,
`codigo_cotizacion_encabezado`INT   NOT NULL ,
`cantidad_servicio` FLOAT(15) NULL DEFAULT NULL,
`precio_servicio` FLOAT(15) NULL DEFAULT NULL,
  PRIMARY KEY (
`no_serie`
)
 
  )
  ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;


CREATE TABLE IF NOT EXISTS  `empresarial`.`tbl_pedido_encabezado` (
`no_serie`   INT   NOT NULL ,
`codigo_reservacion`INT  NOT NULL ,
`PK_codigo_pedido_encabezado`INT  NOT NULL ,
`codigo_cliente` INT   NOT NULL ,
`codigo_cobrador` INT   NOT NULL ,
`codigo_vendedor`INT   NOT NULL ,
`fecha_emision` VARCHAR(35) NULL DEFAULT NULL,
`fecha_vencimiento` VARCHAR(35) NULL DEFAULT NULL,
`codigo_servicio`INT   NOT NULL ,
`impuesto_iva_encabezado` FLOAT(35)    NOT NULL ,
`subtotal_encabezado` FLOAT(35)   NOT NULL ,
`estatus_pedido` TINYINT(2)    NOT NULL ,
  PRIMARY KEY (
`no_serie`

),
    FOREIGN KEY (`codigo_cliente`)
REFERENCES  `empresarial`.`tbl_cliente` (`PK_codigo_cliente`),
FOREIGN KEY ( `codigo_vendedor`)
REFERENCES  `empresarial`.`tbl_vendedor` (`PK_codigo_vendedor`),
 FOREIGN KEY ( `codigo_cobrador`)
REFERENCES  `empresarial`.`tbl_cobrador` ( `PK_codigo_cobrador`)
  )
 ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;


CREATE TABLE IF NOT EXISTS  `empresarial`.`tbl_pedido_detalle` (
`no_serie` INT  NOT NULL ,
`codigo_pedido_encabezado`INT   NOT NULL ,
`cantidad_servicio` FLOAT(15) NULL DEFAULT NULL,
`precio_servicio` FLOAT(15) NULL DEFAULT NULL,
  PRIMARY KEY (
`no_serie`
),
 FOREIGN KEY (`no_serie`)
REFERENCES  `empresarial`.`tbl_pedido_encabezado` (`no_serie`)
  )
  ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;


CREATE TABLE IF NOT EXISTS  `empresarial`.`tbl_factura_encabezado` (
`no_serie`   INT   NOT NULL ,
`codigo_reservacion`INT  NOT NULL ,
`PK_codigo_factura_encabezado`INT  NOT NULL ,
`codigo_cliente` INT   NOT NULL ,
`codigo_cobrador` INT   NOT NULL ,
`codigo_vendedor`INT   NOT NULL ,
`fecha_emision` VARCHAR(35) NULL DEFAULT NULL,
`fecha_vencimiento` VARCHAR(35) NULL DEFAULT NULL,
`codigo_servicio`INT   NOT NULL ,
`impuesto_iva_encabezado` FLOAT(35)    NOT NULL ,
`subtotal_encabezado` FLOAT(35)   NOT NULL ,
`estatus_factura` TINYINT(2)    NOT NULL ,
  PRIMARY KEY (
`no_serie`
),

   FOREIGN KEY (`codigo_cliente`)
REFERENCES  `empresarial`.`tbl_cliente` (`PK_codigo_cliente`),
FOREIGN KEY ( `codigo_vendedor`)
REFERENCES  `empresarial`.`tbl_vendedor` (`PK_codigo_vendedor`),
 FOREIGN KEY ( `codigo_cobrador`)
REFERENCES  `empresarial`.`tbl_cobrador` ( `PK_codigo_cobrador`)
  )
 ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;


CREATE TABLE IF NOT EXISTS  `empresarial`.`tbl_factura_detalle` (

`no_serie` INT   NOT NULL ,
`codigo_factura_encabezado`INT NOT NULL ,
`cantidad_servicio` FLOAT(15) NULL DEFAULT NULL,
`precio_servicio` FLOAT(15) NULL DEFAULT NULL,
  PRIMARY KEY (
`no_serie`
),
 
 FOREIGN KEY (`no_serie`)
 REFERENCES  `empresarial`.`tbl_factura_encabezado` (`no_serie`)
  )
 ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS  `empresarial`.`tbl_devolucion_venta_encabezado` (
`no_serie` INT AUTO_INCREMENT  NOT NULL ,
`codigo_reservacion`INT  NOT NULL ,
`PK_codigo_devolucion_encabezado`INT   NOT NULL ,
`codigo_cliente`INT NULL DEFAULT NULL,
`codigo_cobrador`INT NULL DEFAULT NULL,
`codigo_vendedor`INT NULL DEFAULT NULL,
`fecha_emision` VARCHAR(35) NULL DEFAULT NULL,
`fecha_vencimiento` VARCHAR(35) NULL DEFAULT NULL,
`codigo_servicio`INT   NOT NULL ,
`impuesto_iva_encabezado` FLOAT(35) NULL DEFAULT NULL,
`subtotal_encabezado` FLOAT(35) NULL DEFAULT NULL,
`estatus_devolucion` TINYINT(2) NOT NULL,
  PRIMARY KEY (
`no_serie`

),
    FOREIGN KEY (`codigo_cliente`)
REFERENCES  `empresarial`.`tbl_cliente` (`PK_codigo_cliente`),
FOREIGN KEY ( `codigo_vendedor`)
REFERENCES  `empresarial`.`tbl_vendedor` (`PK_codigo_vendedor`),
 FOREIGN KEY ( `codigo_cobrador`)
REFERENCES  `empresarial`.`tbl_cobrador` ( `PK_codigo_cobrador`)
  )

 ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS  `empresarial`.`tbl_devolucion_venta_detalle` (
`no_serie` INT AUTO_INCREMENT  NOT NULL ,
`codigo_devolucion_encabezado`INT   NOT NULL ,
`cantidad_servicio` FLOAT(15) NULL DEFAULT NULL,
`precio_servicio` FLOAT(15) NULL DEFAULT NULL,
  PRIMARY KEY (
`no_serie`
)
  )
 ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS  `empresarial`.`tbl_control_pago` (
`no_serie` INT  NOT NULL ,
`PK_codigo_comprobacion`INT   NOT NULL ,
`codigo_devolucion_venta`INT NULL DEFAULT NULL,
`codigo_factura_encabezado`INT NULL DEFAULT NULL,
`codigo_cliente`INT NULL DEFAULT NULL,
`fecha_emision` VARCHAR(35) NULL DEFAULT NULL,
`fecha_vencimiento` VARCHAR(35) NULL DEFAULT NULL,
`saldo_comprobacion` FLOAT(35) NULL DEFAULT NULL,
`estatus_pago` TINYINT(2) NOT NULL,
  PRIMARY KEY (
`no_serie`,
`PK_codigo_comprobacion`
),
   
  FOREIGN KEY (`codigo_cliente`)
REFERENCES  `empresarial`.`tbl_cliente` (`PK_codigo_cliente`)

  )
 ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS  `empresarial`.`tbl_balance_saldo_cliente` (
`no_serie` INT  NOT NULL ,
`PK_codigo_comprobacion`INT NULL DEFAULT NULL,
`PK_codigo_cliente`INT NULL DEFAULT NULL,
`fecha_vencimiento` VARCHAR(35) NULL DEFAULT NULL,
`saldo_total` VARCHAR(35) NULL DEFAULT NULL,
`estatus_saldo` TINYINT(2) NOT NULL,
  PRIMARY KEY (
`no_serie`
  )
  )
 ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;
 
 
 CREATE TABLE IF NOT EXISTS  `empresarial`.`tbl_cartera_venta` (
`no_correlativo` INT  NOT NULL ,
`codigo_cliente` INT   NOT NULL ,
`nombre_cliente` VARCHAR(35) NULL ,
`codigo_cobrador` INT   NOT NULL ,
`nombre_cobrador` VARCHAR(35) NULL ,
`codigo_vendedor`INT   NOT NULL ,
`nombre_vendedor` VARCHAR(35) NULL ,
`estatus_cartera` TINYINT(2) NOT NULL,
  PRIMARY KEY (
   `no_correlativo` 
  ),FOREIGN KEY (`codigo_cliente`)
REFERENCES  `empresarial`.`tbl_cliente` (`PK_codigo_cliente`),
FOREIGN KEY ( `codigo_vendedor`)
REFERENCES  `empresarial`.`tbl_vendedor` (`PK_codigo_vendedor`),
 FOREIGN KEY ( `codigo_cobrador`)
REFERENCES  `empresarial`.`tbl_cobrador` ( `PK_codigo_cobrador`)
  )
 ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;
 

 
/*SELECT  PK_id_reservacion,fecha_entrada_reservacion , PK_id_servicio , precio_servicio , PK_id_menu , cantidad_orden ,fecha_orden,total_orden,PK_id_tarifa,nombre_tarifa FROM tbl_reservacion INNER JOIN tbl_servicio 
	ON tbl_reservacion.PK_id_reservacion = tbl_servicio.PK_id_servicio
    INNER JOIN tbl_menu_orden ON tbl_servicio.PK_id_servicio = tbl_menu_orden.PK_id_orden
     INNER JOIN tbl_tarifa ON tbl_servicio.PK_id_servicio = tbl_menu_orden.PK_id_orden;
	*/
    
 CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_registro_movimientos_venta` (
  `no_serie` INT NOT NULL AUTO_INCREMENT,
  `accion` VARCHAR(50) NULL DEFAULT NULL,
  `tabla` VARCHAR(45) NULL DEFAULT NULL,
`total` FLOAT NULL DEFAULT NULL,
PRIMARY KEY (`no_serie`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
/*
INSERT INTO `empresarial`.`tbl_tarifa` (`PK_id_tarifa`, `id_habitacion_tarifa`, `nombre_tarifa`, `estado_tarifa`) VALUES ('1', '1', '1', '1');

INSERT INTO `empresarial`.`tbl_reservacion` (`PK_id_reservacion`, `fecha_reservacion`, `fecha_entrada_reservacion`, `fecha_salida_reservacion`, `identificacion_huesped_reservacion`, `cantidad_personas_reservacion`, `estado_reservacion`) VALUES ('1', '2020-03-07', '2020-03-07', '2020-03-07', '1', '1', '1');
INSERT INTO `empresarial`.`tbl_menu_orden` (`PK_id_orden`, `PK_id_menu`, `cantidad_orden`, `no_mesa`, `horario_orden`, `fecha_orden`, `PK_id_metodo_pago`, `PK_id_habitacion`, `total_orden`) VALUES ('1', '1', '1', '1', '10:30', '2020-07-09', '1', '1', '50');

*/

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_planilla_det`(
`id_planillaDe` INT NOT NULL AUTO_INCREMENT,
`id_planillaenc` INT NOT NULL,
`PK_id_empleado` INT NOT NULL,
`id_conceptoPlanilla` INT NOT NULL,
`valor_conceptoDet` FLOAT(10,2),
PRIMARY KEY (`id_planillaDe`),
FOREIGN KEY (`id_planillaenc`) REFERENCES `empresarial`.`tbl_planilla_enc`(`id_planillaenc`),
FOREIGN KEY (`id_conceptoPlanilla`) REFERENCES `empresarial`.`tbl_Concepto_Planilla`(`id_conceptoPlanilla`),
FOREIGN KEY (`PK_id_empleado`) REFERENCES `empresarial`.`tbl_empleado`(`PK_id_empleado`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_encabezadoasientocontable` (
`Codigo_EncabezadoAsiento` INT NOT NULL AUTO_INCREMENT,
`Fecha_AsientoContable` VARCHAR(100) NOT NULL,
`Moneda_Asiento` INT NOT NULL,
`Descripcion_Asiento` VARCHAR(100) NOT NULL,
PRIMARY KEY (`Codigo_EncabezadoAsiento`),
CONSTRAINT `fk_encabezadoasientocontable_moneda1`
FOREIGN KEY (`Moneda_Asiento`) REFERENCES `empresarial`.`tbl_moneda` (`Codigo_Moneda`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_cuentacontable` (
  `Codigo_CuentaContable` INT NOT NULL AUTO_INCREMENT,
  `Nombre_CuentaContable` VARCHAR(100) NULL DEFAULT NULL,
  `Clasificacion_CuentaContable` INT NULL DEFAULT NULL,
  `Estado_CuentaContable` VARCHAR(100) NULL DEFAULT NULL,
  `Monto_CuentaContable` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`Codigo_CuentaContable`),
  CONSTRAINT `fk_cuentacontable_clasificacioncuenta1`
    FOREIGN KEY (`Clasificacion_CuentaContable`)
    REFERENCES `empresarial`.`tbl_clasificacioncuenta` (`Codigo_clasificacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_partidacontable` (
  `Codigo_PartidaContable` INT NOT NULL AUTO_INCREMENT,
  `Fecha_PartidaContable` DATE NOT NULL,
  `Periodo_FiscalPartida` INT NOT NULL,
  `Glosa_PartidaContable` VARCHAR(100) NOT NULL,
  `Monto_DeCuadre` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`Codigo_PartidaContable`),
  CONSTRAINT `fk_partidacontable_periodofiscal1`
    FOREIGN KEY (`Periodo_FiscalPartida`)
    REFERENCES `empresarial`.`tbl_periodofiscal` (`Codigo_PeriodoFiscal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_asientocontabledetalle` (
  `Codigo_DetalleAsiento` INT NOT NULL AUTO_INCREMENT,
  `CuentaContable_Asiento` INT NOT NULL,
  `Partida_Asiento` INT NOT NULL,
  `Encabezado_Asiento` INT NOT NULL,
  `Tipo_Asiento` INT NOT NULL,
  `Monto_Debe` VARCHAR(100) NOT NULL,
  `Monto_Haber` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`Codigo_DetalleAsiento`),
  CONSTRAINT `asientocontabledetalle_ibfk_1`
    FOREIGN KEY (`Encabezado_Asiento`)
    REFERENCES `empresarial`.`tbl_encabezadoasientocontable` (`Codigo_EncabezadoAsiento`),
  CONSTRAINT `fk_asientocontabledetalle_tipo_asiento1`
    FOREIGN KEY (`Tipo_Asiento`)
    REFERENCES `empresarial`.`tbl_tipo_asiento` (`Codigo_TipoAsiento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_asientocontabledetalle_cuentacontable1`
    FOREIGN KEY (`CuentaContable_Asiento`)
    REFERENCES `empresarial`.`tbl_cuentacontable` (`Codigo_CuentaContable`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_asientocontabledetalle_partidacontable1`
    FOREIGN KEY (`Partida_Asiento`)
    REFERENCES `empresarial`.`tbl_partidacontable` (`Codigo_PartidaContable`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_cuentahabiente` (
  `Codigo_CuentaHabiente` INT NOT NULL AUTO_INCREMENT,
  `Nombre_CuentaHabiente` VARCHAR(100) NOT NULL,
  `ApellidoP_CuentaHabiente` VARCHAR(100) NOT NULL,
  `ApellidoM_CuentaHabiente` VARCHAR(100) NOT NULL,
  `TipoPersona_CuentaHabiente` INT NOT NULL,
  `Saldo_Habilitado` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`Codigo_CuentaHabiente`),
  CONSTRAINT `fk_cuentahabiente_tipopersona1`
    FOREIGN KEY (`TipoPersona_CuentaHabiente`)
    REFERENCES `empresarial`.`tbl_tipopersona` (`Codigo_TipoPersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_cuentabancaria` (
  `Numero_CuentaBancaria` INT NOT NULL AUTO_INCREMENT,
  `Moneda_Cuenta` INT NOT NULL,
  `CuentaHabiente_Cuenta` INT NOT NULL,
  `Banco_Cuenta` INT NOT NULL,
  `Saldo_Cuenta` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`Numero_CuentaBancaria`),
    FOREIGN KEY (`CuentaHabiente_Cuenta`)
    REFERENCES `empresarial`.`tbl_cuentahabiente` (`Codigo_CuentaHabiente`),
    FOREIGN KEY (`Moneda_Cuenta`)
    REFERENCES `empresarial`.`tbl_moneda` (`Codigo_Moneda`),
    FOREIGN KEY (`Banco_Cuenta`)
    REFERENCES `empresarial`.`tbl_banco` (`Codigo_Banco`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_cheque` (
   `Numero_Cheque` INT NOT NULL AUTO_INCREMENT,
  `Fecha_Cheque` DATE NOT NULL,
  `FK_Banco` INT NOT NULL,
  `FK_Cuentahabiente` INT NOT NULL,
  `Monto_Cheque` FLOAT(10,2) NOT NULL,
  PRIMARY KEY (`Numero_Cheque`),
    FOREIGN KEY (`FK_Banco`)
    REFERENCES `empresarial1`.`tbl_banco` (`Codigo_Banco`),
    FOREIGN KEY (`FK_Cuentahabiente`)
    REFERENCES `empresarial1`.`tbl_cuentahabiente` (`Codigo_CuentaHabiente`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_transaccionbancaria` (
  `Codigo_Transaccion` INT NOT NULL AUTO_INCREMENT,
  `Fecha_Transaccion` DATE NOT NULL,
  `Beneficiario` VARCHAR(100) NOT NULL,
  `Cuenta_Bancaria` INT NOT NULL,
  `Tipo_Transaccion` INT NOT NULL,
  `Monto_Transaccion` VARCHAR(100) NOT NULL,
  `Concepto_Transaccion` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`Codigo_Transaccion`),
  FOREIGN KEY (`Tipo_Transaccion`)
  REFERENCES `empresarial`.`tbl_tipotransaccion` (`Codigo_TipoTransaccion`),
  FOREIGN KEY (`Cuenta_Bancaria`)
  REFERENCES `empresarial`.`tbl_cuentabancaria` (`Numero_CuentaBancaria`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_MovimientoBancarioEncabezado` (
	`id_movEnc` INT NOT NULL AUTO_INCREMENT,
    `Documento` VARCHAR(50) NOT NULL,
    `fecha` DATE NOT NULL,
    `monto` FLOAT NOT NULL,
    `Detalle` VARCHAR(100) NOT NULL,
   PRIMARY KEY (`id_movEnc`),
     CONSTRAINT `tbl_MovimientoBancarioEncabezadotbl_concepto1`
    FOREIGN KEY (`Documento`) REFERENCES `bl_concepto` (`nombre_concepto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_MovimientoBancarioDETALLE` (
	`id_movEnc` INT NOT NULL AUTO_INCREMENT,
    `codigo_concepto` VARCHAR(10) NOT NULL,
    `CREDITO` FLOAT NOT NULL,
	`DEBITO` FLOAT NOT NULL, 
   PRIMARY KEY (`id_movEnc`,`codigo_concepto`),
    FOREIGN KEY (`id_movEnc`) REFERENCES `bl_MovimientoBancarioEncabezado` (`id_movEnc`),
    FOREIGN KEY (`codigo_concepto`) REFERENCES `bl_concepto` (`nombre_concepto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_NotasDeCredito` (
  `NumeroDeDocumento`  INT NOT NULL AUTO_INCREMENT,
  `NumeroDeCuenta` VARCHAR(100) NOT NULL,
  `Beneficiario` VARCHAR(100) NOT NULL,
  `Fecha` VARCHAR(100) NOT NULL,
  `MontoPositivo` VARCHAR(100) NOT NULL,
  `Descripcion` VARCHAR(100) NOT NULL,
   PRIMARY KEY (`NumeroDeDocumento`),
     CONSTRAINT `ftbl_NotasDeCreditotbl_cuentabancaria1`
    FOREIGN KEY (`NumeroDeCuenta`) REFERENCES `bl_cuentabancaria` (`Numero_CuentaBancaria`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_NotasDeDebito` (
  `NumeroDeDocumento`  INT NOT NULL AUTO_INCREMENT,
  `NumeroDeCuenta` VARCHAR(100) NOT NULL,
  `Beneficiario` VARCHAR(100) NOT NULL,
  `Fecha` VARCHAR(100) NOT NULL,
  `MontoNegativo` VARCHAR(100) NOT NULL,
  `Descripcion` VARCHAR(100) NOT NULL,
   PRIMARY KEY (`NumeroDeDocumento`),
     CONSTRAINT `tbl_NotasDeDebitotbl_cuentabancaria1`
    FOREIGN KEY (`NumeroDeCuenta`) REFERENCES `bl_cuentabancaria` (`Numero_CuentaBancaria`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;
-- --------------------------------------------------------
-- Estructura de tabla para la tabla `ConciliacionBancaria`
-- --------------------------------------------------------

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_ConciBancariaEncabezado` (
`No_ConciliacionBan` INT NOT NULL AUTO_INCREMENT,
`NumeroDeCuenta` INT NOT NULL,
`FechaInicio` DATE NOT NULL,
`FechaFinal` DATE NOT NULL,
`Codigo_Banco` INT NOT NULL,
`SaldoCuenta` VARCHAR(100) NOT NULL,
`TotalDebito` FLOAT NOT NULL,
`TotalCredito` FLOAT NOT NULL,
`SaldoContable` FLOAT NOT NULL,
PRIMARY KEY (`No_ConciliacionBan`),
FOREIGN KEY (`NumeroDeCuenta`)REFERENCES `empresarial`.`tbl_cuentabancaria` (`Numero_CuentaBancaria`),
FOREIGN KEY (`Codigo_Banco`) REFERENCES `empresarial`.`tbl_banco` (`Codigo_Banco`)

)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_ConciBancariaDetalle` (
`No_ConciliacionBdet` INT NOT NULL AUTO_INCREMENT,
`Codigo_concepto` VARCHAR(100) NOT NULL,
`Fecha` DATE NOT NULL,
`Movimiento` INT NOT NULL,
`CreditoC` VARCHAR(100) NOT NULL,
`DebitoC` VARCHAR(100) NOT NULL,
`SaldoConciliacion` FLOAT NOT NULL,
PRIMARY KEY (`No_ConciliacionBdet`),
FOREIGN KEY(`No_ConciliacionBdet`) REFERENCES `tbl_ConciBancariaEncabezado` (`No_ConciliacionBan`),
FOREIGN KEY (`Movimiento`) REFERENCES `tbl_MovimientoBancarioEncabezado` (`id_movEnc`)

)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;
-- -----------------------------------------------------
-- FIN PROCESOS
-- -----------------------------------------------------

-- ---------------------
-- PROCESOS ALMACENADOS
-- ---------------------
-- ----------------------------------------------1
DELIMITER $$
USE `empresarial`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getValidarReservacion`(IN no_reservacion INT, IN no_tarifa INT, OUT validacion INT)
BEGIN
DECLARE fecha_inicio, fecha_fin DATE;
SELECT
tbl_reservacion.fecha_entrada_reservacion, tbl_reservacion.fecha_salida_reservacion
INTO
fecha_inicio, fecha_fin
FROM 
empresarial.tbl_reservacion
WHERE
tbl_reservacion.PK_id_reservacion=no_reservacion;
SELECT
SUM(if(tbl_detalle_reservacion.id_reservacion_detalle != no_reservacion 
OR tbl_detalle_reservacion.id_tarifa_detalle=no_tarifa, 1, 0)) INTO validacion
FROM 
empresarial.tbl_detalle_reservacion, empresarial.tbl_reservacion
WHERE
tbl_detalle_reservacion.id_tarifa_detalle=no_tarifa AND
tbl_detalle_reservacion.id_reservacion_detalle = tbl_reservacion.PK_id_reservacion AND
(tbl_reservacion.fecha_entrada_reservacion BETWEEN fecha_inicio AND fecha_fin) OR 
(tbl_reservacion.fecha_salida_reservacion BETWEEN fecha_inicio AND fecha_fin) AND
tbl_detalle_reservacion.id_tarifa_detalle=no_tarifa AND
tbl_detalle_reservacion.id_reservacion_detalle = tbl_reservacion.PK_id_reservacion
;
END$$
DELIMITER ;

-- ----------------------------------------------2
DELIMITER $$
USE `empresarial`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getValidacionGobernanta`(IN idGobernanta INT, OUT validacion BOOLEAN)
BEGIN 
DECLARE cantidadAsignaciones INT; 
SELECT if(COUNT(PK_id_gobernanta)  < 5, TRUE, FALSE)
INTO validacion
FROM empresarial.tbl_asignacion_gobernanta 
WHERE PK_id_gobernanta=idGobernanta;
END$$
DELIMITER ;

-- ----------------------------------------------3
DELIMITER $$
USE `empresarial`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getValidarEntrega`(IN IdReservacion int,IN fechaactual date, out validacion int)
BEGIN
DECLARE fecha_inicio, fecha_fin DATE;
SELECT
tbl_reservacion.fecha_entrada_reservacion, tbl_reservacion.fecha_salida_reservacion
INTO
fecha_inicio, fecha_fin
FROM 
empresarial.tbl_reservacion 
WHERE
tbl_reservacion.PK_id_reservacion=IdReservacion;
select PK_id_reservacion into validacion from tbl_reservacion 
where PK_id_reservacion = IdReservacion and fechaactual between fecha_inicio and fecha_fin;
END$$
DELIMITER ;

-- ----------------------area administrativa--------3
DELIMITER $$
USE `empresarial`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `pa_limite_stock`()
BEGIN 
select * from tbl_existencia
where cantidad_existencia<=20;
END$$
DELIMITER ;
;
call empresarial.pa_limite_stock();
USE `empresarial`;
DROP procedure IF EXISTS `Actualizar_existencia_compras`;

DELIMITER $$
USE `empresarial`$$
CREATE PROCEDURE `Actualizar_existencia_compras`(cantidad int, costo int,
 codigo_producto int, codigo_producto_existencia int)
BEGIN
DECLARE nueva_existencia int;
DECLARE nueva_total int;
DECLARE Total_Cancelar decimal(10,2);

DECLARE cant_actual int;
DECLARE costo_actual int;

DECLARE actual_existencia int;
DECLARE actual_costo int;

SELECT costo_producto INTO actual_costo from tbl_producto where PK_codigo_producto = codigo_producto;
SELECT cantidad_existencia INTO actual_existencia from tbl_existencia where PK_codigo_producto = codigo_producto_existencia;

SET nueva_existencia = actual_existencia + cantidad;
SET nueva_total = (actual_existencia * actual_costo) + (cantidad * costo);
SET Total_Cancelar = nueva_total;
UPDATE tbl_existencia SET cantidad_existencia = nueva_existencia WHERE PK_codigo_producto = codigo_producto_existencia;
 
 SELECT nueva_existencia,codigo_producto_existencia;
END$$

DELIMITER ;

-- -------------------------
-- FUNCIONES ALMACENADAS
-- -------------------------
DELIMITER $$
USE `empresarial`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `getImpuestoTarifa`(no_tarifa INT) RETURNS float
BEGIN
DECLARE ImpuestoTarifa, totalServicios, totalHabitacion, noTarifa FLOAT;
SELECT 
tbl_tarifa.PK_id_tarifa, 
sum(tbl_servicio.precio_servicio) as total_servicios, 
max(tbl_mantenimiento_habitacion.precio_habitacion) as total_habitacion
INTO noTarifa, totalServicios, totalHabitacion
FROM empresarial.tbl_tarifa, empresarial.tbl_paquete_servicios, 
empresarial.tbl_servicio, empresarial.tbl_mantenimiento_habitacion

WHERE tbl_tarifa.PK_id_tarifa=no_tarifa AND tbl_paquete_servicios.id_tarifa_paquete = PK_id_tarifa
AND tbl_servicio.PK_id_servicio = tbl_paquete_servicios.id_servicio_paquete 
AND tbl_mantenimiento_habitacion.PK_id_habitacion = tbl_tarifa.id_habitacion_tarifa
GROUP BY PK_id_tarifa;

SELECT sum(totalServicios+totalHabitacion)*0.10 into ImpuestoTarifa;
RETURN ImpuestoTarifa;
END$$

DELIMITER ;