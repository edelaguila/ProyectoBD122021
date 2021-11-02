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
('3', '100', 'Habitaciones grandes', '1'),
('4', '10', 'Habitaciones presidenciales', '1');

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_horario` (
`PK_id_horario` INT NOT NULL,
`entrada_horario` VARCHAR(10) NULL DEFAULT NULL,
`salida_horario` VARCHAR(10) NULL DEFAULT NULL,
`horas_extras_horario` INT NULL DEFAULT NULL,
`descripcion_horario` VARCHAR(200) NULL DEFAULT NULL,
`estado_horario` TINYINT NULL DEFAULT NULL,
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
('3', 'gramos', 'gr', '1');

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
INSERT INTO `empresarial`.`tbl_producto` 
VALUES ('1', 'planchas', 'ingreso 17/08/2021', '120', '120', '1', '2', '4', '4', '2'),
('2', 'jugos', 'ingreso 12/09/2021', '12', '12', '1', '1', '5', '4', '1');

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_existencia` (
`Pk_codigo_existencia` INT  NOT NULL,
`Pk_codigo_producto` INT  NOT NULL,
`Pk_codigo_bodega` INT  NOT NULL,
`cantidad_existencia` INT NULL DEFAULT NULL,
`fecha_entrada_existencia` DATE DEFAULT NULL,
`fecha_salida_existencia` DATE DEFAULT NULL,
`estatus_existencia` TINYINT NOT NULL,
PRIMARY KEY ( 
`Pk_codigo_existencia`,
`Pk_codigo_producto`,
`Pk_codigo_bodega`),
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
('5', 'Yury', 'Garcia', '12345', 'karolq@gmail.com', 'Gobernanta', '1', '2021-10-19');

-- -----------------------------------------------------
-- FIN MANTENIMIENTOS
-- -----------------------------------------------------


-- -----------------------------------------------------
-- INICIO PROCESOS
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_tarifa` (
`PK_id_tarifa` INT AUTO_INCREMENT NOT NULL,
`id_habitacion_tarifa` INT NOT NULL,
`nombre_tarifa` VARCHAR(60) NULL DEFAULT NULL,
`estado_tarifa` TINYINT NULL DEFAULT NULL,
PRIMARY KEY (`PK_id_tarifa`),
FOREIGN KEY (id_habitacion_tarifa) REFERENCES tbl_mantenimiento_habitacion(PK_id_habitacion)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_paquete_servicios` (
`PK_correlativo_paquete` INT AUTO_INCREMENT NOT NULL,
`id_tarifa_paquete` INT NOT NULL,
`id_servicio_paquete` INT NOT NULL,
PRIMARY KEY (`PK_correlativo_paquete`),
FOREIGN KEY (id_tarifa_paquete) REFERENCES tbl_tarifa(PK_id_tarifa),
FOREIGN KEY (id_servicio_paquete) REFERENCES tbl_servicio(PK_id_servicio)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

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

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_detalle_reservacion` (
`Pk_correlativo_detalle` INT AUTO_INCREMENT NOT NULL,
`id_reservacion_detalle` INT NOT NULL,
`id_tarifa_detalle` INT NOT NULL,
PRIMARY KEY (`Pk_correlativo_detalle`),
FOREIGN KEY (id_tarifa_detalle) REFERENCES tbl_tarifa(PK_id_tarifa),
FOREIGN KEY (id_reservacion_detalle) REFERENCES tbl_reservacion(PK_id_reservacion)
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
`PK_id_detalle_limpieza` INT NOT NULL AUTO_INCREMENT,
`id_asignacion_gobernanta` INT NOT NULL,
`id_asignacion_limpieza` INT NOT NULL,
PRIMARY KEY (`PK_id_detalle_limpieza`),
FOREIGN KEY (`id_asignacion_gobernanta`) REFERENCES `tbl_asignacion_gobernanta`(`PK_id_asignacion_gobernanta`),
FOREIGN KEY (`id_asignacion_limpieza`) REFERENCES `tbl_asignacion_limpieza`(`PK_id_asignacion_limpieza`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_objeto_perdido` (
  `PK_id_objeto` INT NOT NULL AUTO_INCREMENT,
  `PK_id_habitacion` INT DEFAULT NULL,
  `PK_id_ama_de_llaves` INT DEFAULT NULL,
  `fecha_encontrado` date NULL DEFAULT NULL,
  `objeto` VARCHAR(50) NULL DEFAULT NULL,
  `identificacion` VARCHAR(50) NULL DEFAULT NULL,
  `nombre` VARCHAR(50) NULL DEFAULT NULL,
  `estado` TINYINT NULL DEFAULT NULL,
  PRIMARY KEY (`PK_id_objeto`),
    FOREIGN KEY (`PK_id_habitacion`) REFERENCES `tbl_mantenimiento_habitacion`(`PK_id_habitacion`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
INSERT INTO `empresarial`.`tbl_objeto_perdido` (`PK_id_objeto`, `PK_id_habitacion`, `PK_id_ama_de_llaves`, `fecha_encontrado`, `objeto`, `identificacion`, `nombre`, `estado`) VALUES ('1', '1', '1', '2021-04-17', 'Telefono', '12345678', 'Luis', '2');
INSERT INTO `empresarial`.`tbl_objeto_perdido` (`PK_id_objeto`, `PK_id_habitacion`, `PK_id_ama_de_llaves`, `fecha_encontrado`, `objeto`, `identificacion`, `nombre`, `estado`) VALUES ('2', '1', '1', '2021-04-18', 'Juguete', 'null', 'null', '1');
INSERT INTO `empresarial`.`tbl_objeto_perdido` (`PK_id_objeto`, `PK_id_habitacion`, `PK_id_ama_de_llaves`, `fecha_encontrado`, `objeto`, `identificacion`, `nombre`, `estado`) VALUES ('3', '1', '1', '2021-04-19', 'Computadora', 'null', 'null', '1');
INSERT INTO `empresarial`.`tbl_objeto_perdido` (`PK_id_objeto`, `PK_id_habitacion`, `PK_id_ama_de_llaves`, `fecha_encontrado`, `objeto`, `identificacion`, `nombre`, `estado`) VALUES ('4', '1', '1', '2021-04-20', 'Telefono', 'null', 'null', '1');
INSERT INTO `empresarial`.`tbl_objeto_perdido` (`PK_id_objeto`, `PK_id_habitacion`, `PK_id_ama_de_llaves`, `fecha_encontrado`, `objeto`, `identificacion`, `nombre`, `estado`) VALUES ('5', '1', '1', '2021-04-21', 'Audifonos', '124345678', 'Juan', '2');

 CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_transporteruta` (
`PK_codigo_transporteruta` INT  NOT NULL,
`nombre_conductoruta` VARCHAR(35) NULL DEFAULT NULL,  
`nombre_transporteruta` VARCHAR(35) NULL DEFAULT NULL, 
`tipo_transporteruta` VARCHAR(35) NULL DEFAULT NULL,
`ubicacion_transporteruta` VARCHAR(35) NULL DEFAULT NULL, 
`direccion_transporteruta` VARCHAR(35) NULL DEFAULT NULL, 
`hora_salida_transporteruta` DATETIME NULL DEFAULT NULL,
`hora_entrada_transporteruta` DATETIME DEFAULT NULL,
`estatus_transporteruta` TINYINT NOT NULL,
PRIMARY KEY (`PK_codigo_transporteruta`))
ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_solicitud_viaje`(
`PK_id_solicitud` INT NOT NULL,
`PK_id_reservacion` INT NOT NULL,
`id_destino`INT NOT NULL,
`id_transporte` INT NOT NULL,
`precio_viaje` INT NOT NULL,
PRIMARY KEY (`Pk_id_solicitud`),
FOREIGN KEY (PK_id_reservacion) REFERENCES tbl_reservacion(PK_id_reservacion)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

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
`PK_codigo_inventario`,
`PK_codigo_producto`,
`PK_codigo_bodega`,
`PK_codigo_existencia`,
`PK_codigo_linea`,
`PK_codigo_marca`,
`PK_codigo_unidad`
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

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_movimiento` (
`Pk_codigo_movimiento` INT  NOT NULL,
`estatus_movimiento` TINYINT NOT NULL,
PRIMARY KEY ( 
`Pk_codigo_movimiento`
)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `empresarial`.`tbl_movimiento_detalle` (
`Pk_codigo_movimiento_detalle` INT  NOT NULL,
`estatus_movimiento_detalle` TINYINT NOT NULL,
PRIMARY KEY ( 
`Pk_codigo_movimiento_detalle`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

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
)ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

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
)ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

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
`Pk_codigo_bodega`),
FOREIGN KEY (`codigo_proveedor`)
REFERENCES `empresarial`.`tbl_proveedor` (`PK_codigo_proveedor`)
)ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

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
`Pk_codigo_bodega`),
FOREIGN KEY (`PK_codigo_ordenCompra`)
REFERENCES `empresarial`.`tbl_ordencompra_encabezado` (`PK_codigo_ordenCompra`),
FOREIGN KEY (`Pk_codigo_producto`)
REFERENCES `empresarial`.`tbl_producto` (`PK_codigo_producto`),
FOREIGN KEY (`PK_codigo_bodega`)
REFERENCES `empresarial`.`tbl_bodega` (`PK_codigo_bodega`)   
)ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

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
`Pk_codigo_bodega`),
FOREIGN KEY (`codigo_proveedor`)
REFERENCES `empresarial`.`tbl_proveedor` (`PK_codigo_proveedor`)
)ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

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
`Pk_codigo_bodega`),
FOREIGN KEY (`PK_codigo_recepcionCompra`)
REFERENCES `empresarial`.`tbl_recepcioncompra_encabezado` (`PK_codigo_recepcionCompra`),
FOREIGN KEY (`Pk_codigo_producto`)
REFERENCES `empresarial`.`tbl_producto` (`PK_codigo_producto`),
FOREIGN KEY (`PK_codigo_bodega`)
REFERENCES `empresarial`.`tbl_bodega` (`PK_codigo_bodega`)   
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

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
`Pk_codigo_bodega`),
FOREIGN KEY (`codigo_proveedor`)
REFERENCES `empresarial`.`tbl_proveedor` (`PK_codigo_proveedor`)
)ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

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
`Pk_codigo_bodega`),
FOREIGN KEY (`PK_codigo_devolucionCompra`)
REFERENCES `empresarial`.`tbl_devolucioncompra_encabezado` (`PK_codigo_devolucionCompra`),
FOREIGN KEY (`Pk_codigo_producto`)
REFERENCES `empresarial`.`tbl_producto` (`PK_codigo_producto`),
FOREIGN KEY (`PK_codigo_bodega`)
REFERENCES `empresarial`.`tbl_bodega` (`PK_codigo_bodega`)   
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS  `empresarial`.`tbl_control_precio_encabezado` (
`PK_codigo_producto_precio_encabezado` INT NOT NULL ,
`codigo_producto`INT   NOT NULL,
`fecha_emision` VARCHAR(35) NULL DEFAULT NULL,
`fecha_vencer` VARCHAR(35) NULL DEFAULT NULL,
PRIMARY KEY (
`PK_codigo_producto_precio_encabezado`,
`codigo_producto`),
FOREIGN KEY (`codigo_producto`)
REFERENCES  `empresarial`.`tbl_producto` (`PK_codigo_producto`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS  `empresarial`.`tbl_control_precio_detalle` (
`PK_codigo_producto_precio_detalle` INT NOT NULL ,
`nombre_producto` VARCHAR(35) NULL DEFAULT NULL,
`precio_producto` VARCHAR(35) NULL DEFAULT NULL,
`costo_producto` VARCHAR(35) NULL DEFAULT NULL,
PRIMARY KEY (
`PK_codigo_producto_precio_detalle`)
)ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

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
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS  `empresarial`.`tbl_cotizacion_detalle` (
`no_serie`INT NOT NULL ,
`codigo_cotizacion_encabezado`INT   NOT NULL ,
`cantidad_servicio` FLOAT NULL DEFAULT NULL,
`precio_servicio` FLOAT NULL DEFAULT NULL,
PRIMARY KEY (
`no_serie`),
FOREIGN KEY (`no_serie`)
REFERENCES  `empresarial`.`tbl_factura_encabezado` (`no_serie`)
)ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

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
`PK_codigo_pedido_encabezado`),
FOREIGN KEY (`codigo_cliente`)
REFERENCES  `empresarial`.`tbl_cliente` (`PK_codigo_cliente`),
FOREIGN KEY ( `codigo_vendedor`)
REFERENCES  `empresarial`.`tbl_vendedor` (`PK_codigo_vendedor`),
FOREIGN KEY ( `codigo_cobrador`)
REFERENCES  `empresarial`.`tbl_cobrador` ( `PK_codigo_cobrador`)
)ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

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
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

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
`PK_codigo_factura_encabezado`),
FOREIGN KEY (`codigo_cliente`)
REFERENCES  `empresarial`.`tbl_cliente` (`PK_codigo_cliente`),
FOREIGN KEY ( `codigo_vendedor`)
REFERENCES  `empresarial`.`tbl_vendedor` (`PK_codigo_vendedor`),
FOREIGN KEY ( `codigo_cobrador`)
REFERENCES  `empresarial`.`tbl_cobrador` ( `PK_codigo_cobrador`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

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
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

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
`PK_codigo_devolucion_venta_encabezado`),
FOREIGN KEY (`codigo_cliente`)
REFERENCES  `empresarial`.`tbl_cliente` (`PK_codigo_cliente`),
FOREIGN KEY ( `codigo_vendedor`)
REFERENCES  `empresarial`.`tbl_vendedor` (`PK_codigo_vendedor`),
FOREIGN KEY ( `codigo_cobrador`)
REFERENCES  `empresarial`.`tbl_cobrador` ( `PK_codigo_cobrador`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

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
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

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
`PK_codigo_comprobacion`),
FOREIGN KEY (`codigo_cliente`)
REFERENCES  `empresarial`.`tbl_cliente` (`PK_codigo_cliente`)
)ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS  `empresarial`.`tbl_balance_saldo_cliente` (
`PK_codigo_salgo_cliente` INT  NOT NULL ,
`PK_codigo_comprobacion`INT NULL DEFAULT NULL,
`PK_codigo_cliente`INT NULL DEFAULT NULL,
`fecha_vencimiento` VARCHAR(35) NULL DEFAULT NULL,
`saldo_total` VARCHAR(35) NULL DEFAULT NULL,
`estatus_saldo` TINYINT NOT NULL,
PRIMARY KEY (
`PK_codigo_salgo_cliente`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

-- -----------------------------------------------------
-- FIN PROCESOS
-- -----------------------------------------------------