SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE SCHEMA IF NOT EXISTS `hoteleria` DEFAULT CHARACTER SET utf8;
USE `hoteleria`;

  -- -----------------------------------------------------
  -- Table `hoteleria`.`Piso`
  -- -----------------------------------------------------
  CREATE TABLE IF NOT EXISTS `hoteleria`.`tbl_piso` (
    `PK_id_piso` INT NOT NULL,
    `cantidad_habitaciones_piso` INT NULL DEFAULT NULL,
    `descripcion_piso` VARCHAR(200) NULL DEFAULT NULL,
    `estado_piso` TINYINT NULL DEFAULT NULL,
    PRIMARY KEY (`PK_id_piso`)
  ) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;
INSERT INTO 
`hoteleria`.`tbl_piso` (
`PK_id_piso`, 
`cantidad_habitaciones_piso`, 
`descripcion_piso`, 
`estado_piso`) 
VALUES ('1', '100', 'Habitaciones grandes', '1'),
('2', '200', 'Habitaciones mediana', '1'),
('3', '300', 'Habitaciones pequeña', '1'),
('4', '50', 'Habitaciones VIP', '1');

  -- -----------------------------------------------------
  -- Table `hoteleria`.`horario`
  -- -----------------------------------------------------
  CREATE TABLE IF NOT EXISTS `hoteleria`.`tbl_horario` (
    `PK_id_horario` INT NOT NULL,
    `entrada_horario` VARCHAR(10) NULL DEFAULT NULL,
    `salida_horario` VARCHAR(10) NULL DEFAULT NULL,
    `horas_extras_horario` INT NULL DEFAULT NULL,
    `descripcion_horario` VARCHAR(200) NULL DEFAULT NULL,
    `estado_horario` TINYINT NULL DEFAULT NULL,
    PRIMARY KEY (`PK_id_horario`)
  ) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;
  INSERT INTO 
`hoteleria`.`tbl_horario` (
`PK_id_horario`, 
`entrada_horario`, 
`salida_horario`, 
`horas_extras_horario`, 
`descripcion_horario`, 
`estado_horario`) 
VALUES ('1', '8 am', '8 pm', '8', 'Horario matutino', '1'),
('2', '12 am', '12 pm', '1', 'Horario de tarde', '1'),
('3', '9 am', '9 pm', '5', 'Horario nocturno', '1');

 -- -----------------------------------------------------
  -- Table `hoteleria`.`impuesto`
  -- -----------------------------------------------------
  CREATE TABLE IF NOT EXISTS `hoteleria`.`tbl_impuesto` (
    `PK_id_impuesto` INT NOT NULL,
    `nombre_impuesto` VARCHAR(45) NULL DEFAULT NULL,
    `valor_impuesto` DECIMAL NULL DEFAULT NULL,
    `descripcion_impuesto` VARCHAR(200) NULL DEFAULT NULL,
    `estado_impuesto` TINYINT NULL DEFAULT NULL,
    PRIMARY KEY (`PK_id_impuesto`)
  ) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
  -- Table `hoteleria`.`tbl_metodo_de_pago`
  -- -----------------------------------------------------
  CREATE TABLE IF NOT EXISTS `hoteleria`.`tbl_metodo_de_pago` (
    `PK_id_metodo` INT NOT NULL,
    `nombre_metodo` VARCHAR(50) NULL DEFAULT NULL,
    `descripcion_metodo` VARCHAR(100) NULL DEFAULT NULL,
    `estado_metodo` TINYINT NULL DEFAULT NULL,
    PRIMARY KEY (`PK_id_metodo`)
  ) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;
INSERT INTO
  `hoteleria`.`tbl_metodo_de_pago` (
    `PK_id_metodo`,
    `nombre_metodo`,
    `descripcion_metodo`,
    `estado_metodo`
  )
VALUES
  ('1', 'Tarjeta', 'Pago con tarjeta', '1'),
  ('2', 'Efectivo', 'Pago en efectivo', '1'),
  ('3','Criptomoneda Ethereum','Fase beta del método de prueba con CriptoMoneda Ethereum','0'),
  ('4','PAYPAL','Forma de pago PayPal a nuestra cuenta en brasil','0'),
  ('5','MovilPay','Pago en fase alpha para pagar mediante el celular.','0');
  
  -- -----------------------------------------------------
  -- Table `hoteleria`.`tbl_servicios`
  -- -----------------------------------------------------
  CREATE TABLE IF NOT EXISTS `hoteleria`.`tbl_servicio` (
    `PK_id_servicio` INT NOT NULL,
    `nombre_servicio` VARCHAR(50) NULL DEFAULT NULL,
    `descripcion_servicio` VARCHAR(100) NULL DEFAULT NULL,
    `precio_servicio` INT NOT NULL,
    `tipo_servicio` TINYINT NOT NULL,
    `estado_servicio` TINYINT NOT NULL,
    PRIMARY KEY (`PK_id_servicio`)
  ) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;
INSERT INTO
  `tbl_servicio` (
    `PK_id_servicio`,
    `nombre_servicio`,
    `descripcion_servicio`,
    `precio_servicio`,
    `tipo_servicio`,
    `estado_servicio`
  )
VALUES
  ('1', 'Internet', '50mg', '150', '1', '1'),
  ('2','Niñera','Cuido de niños menores de 10 años','250','2','1'),
  ('3','Acceso VIP del Restaurante','acceso VIP del restaurante durante una noche','375','2','1'),
  ('4','SPA','SPA para un máximo de 10 personas','500','2','2'),
  ('5','Sector para Fumadores','Amplio sector para personas puedan fumar tranquilamente','150','2','1');

-- -----------------------------------------------------
  -- Table `hoteleria`.`tbl_mantenimiento_habitacion`
  -- -----------------------------------------------------
  CREATE TABLE IF NOT EXISTS `hoteleria`.`tbl_mantenimiento_habitacion` (
    `PK_id_habitacion` INT NOT NULL,
    `precio_habitacion` INT(45) NULL DEFAULT NULL,
    `PK_id_piso` INT NULL DEFAULT NULL,
    `estado_habitacion` TINYINT NULL DEFAULT NULL,
    `estado_limpieza` TINYINT NULL DEFAULT NULL,
    `tipo_de_habitacion` INT(5) NULL DEFAULT NULL,
    `cantidad_maxima_persona` INT(5) NULL DEFAULT NULL,
    PRIMARY KEY (`PK_id_habitacion`),
    FOREIGN KEY (`PK_id_piso`) REFERENCES `tbl_piso`(`PK_id_piso`)
  ) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;
INSERT INTO
  `tbl_mantenimiento_habitacion` (
    `PK_id_habitacion`,
    `precio_habitacion`,
    `PK_id_piso`,
    `estado_habitacion`,
    `estado_limpieza`,
    `tipo_de_habitacion`,
    `cantidad_maxima_persona`
  )
VALUES
  ('1', '250', '1', '0', '1', '1', '5'),
  ('2', '250', '4', '1', '2', '1', '6'),
  ('3', '250', '1', '0', '1', '2', '7'),
  ('4', '250', '4', '1', '2', '2', '8'),
  ('5', '250', '1', '0', '1', '2', '9');

  -- -----------------------------------------------------
  -- Table `hoteleria`.`tbl_huespedes`
  -- -----------------------------------------------------
  CREATE TABLE IF NOT EXISTS `hoteleria`.`tbl_huesped` (
    `PK_no_identificacion` INT NOT NULL,
    `nombre_huesped` VARCHAR(50) NULL DEFAULT NULL,
    `apellido_huesped` VARCHAR(100) NULL DEFAULT NULL,
    `nacionalidad_huesped` VARCHAR(100) NULL DEFAULT NULL,
    `direccion_huesped` VARCHAR(100) NULL DEFAULT NULL,
    `sexo_huesped` VARCHAR(5) NULL DEFAULT NULL,
    `telefono_huesped` INT DEFAULT NULL,
    `cumpleaños_huesped` DATE NULL DEFAULT NULL,
    PRIMARY KEY (`PK_no_identificacion`)
  ) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;
INSERT INTO
  `hoteleria`.`tbl_huesped` (
    `PK_no_identificacion`,
    `nombre_huesped`,
    `apellido_huesped`,
    `nacionalidad_huesped`,
    `direccion_huesped`,
    `sexo_huesped`,
    `telefono_huesped`,
    `cumpleaños_huesped`
  )
VALUES
  ('1','Alberto','Suarez','Mexicano','alberto@gmail.com','M','12345678','2000-6-28'),
  ('12','Luis Carlos','lee','Guatemalteco','leeluis@gmail.com','M','87654321','2000-6-28'),
  ('123','Leonel','Dominguez','Guatemalteco','leo@gmail.com','M','123456789','2000-6-28'),
  ('1234','Jefferson','Davila','Jamaiquino','jeff@gmail.com','M','612345678','2000-6-28'),
  ('12345','Gerson','Meda','Español','meda@gmail.com','M','1234585678','2000-6-28');

  -- -----------------------------------------------------
  -- Table `hoteleria`.`tbl_menu_restaurante`
  -- -----------------------------------------------------
  CREATE TABLE IF NOT EXISTS `hoteleria`.`tbl_menu_restaurante` (
    `PK_codigo_correlativo` INT NOT NULL,
    `nombre_plato` VARCHAR(100) NULL DEFAULT NULL,
    `descripcion_plato` VARCHAR(100) NULL DEFAULT NULL,
    `precio_plato` INT NOT NULL,
    `estado_plato` TINYINT NULL DEFAULT NULL,
    PRIMARY KEY (`PK_codigo_correlativo`)
  ) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;
INSERT INTO
  `hoteleria`.`tbl_menu_restaurante` (
    `PK_codigo_correlativo`,
    `nombre_plato`,
    `descripcion_plato`,
    `precio_plato`,
    `estado_plato`
  )
VALUES
  ('1', 'pizza', 'pizza clasica', '50', '1'),
  ('12', 'burrito', 'burrito clasico', '20', '1'),
  ('123','hamburguesa','hamburguesa clasica','30','0'),
  ('1234', 'lasaña', 'lasaña clasica', '20', '0'),
  ('12345', 'tacos', 'tacos clasicos', '10', '0');
  
  -- -----------------------------------------------------
  -- Table `hoteleria`.`tbl_tarifa`
  -- -----------------------------------------------------
  CREATE TABLE IF NOT EXISTS `hoteleria`.`tbl_tarifa` (
    `PK_id_tarifa` INT NOT NULL,
    `id_habitacion_tarifa` INT NOT NULL,
    `nombre_tarifa` VARCHAR(60) NULL DEFAULT NULL,
    `sub_total_tarifa` FLOAT DEFAULT NULL,
    PRIMARY KEY (`PK_id_tarifa`),
    FOREIGN KEY (id_habitacion_tarifa) REFERENCES tbl_mantenimiento_habitacion(PK_id_habitacion)
  ) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
  -- Table `hoteleria`.`tbl_paquete_servicio`
  -- -----------------------------------------------------
  CREATE TABLE IF NOT EXISTS `hoteleria`.`tbl_paquete` (
    `PK_correlativo_paquete` INT AUTO_INCREMENT NOT NULL,
    `id_tarifa_paquete` INT NOT NULL,
    `id_servicio_paquete` INT NOT NULL,
    `sub_total_paquete` FLOAT DEFAULT NULL,
    PRIMARY KEY (`PK_correlativo_paquete`),
    FOREIGN KEY (id_tarifa_paquete) REFERENCES tbl_tarifa(PK_id_tarifa),
    FOREIGN KEY (id_servicio_paquete) REFERENCES tbl_servicio(PK_id_servicio)
  ) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;

  -- -----------------------------------------------------
  -- Table `hoteleria`.`tbl_reservacion`
  -- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hoteleria`.`tbl_reservacion` (
    `PK_id_reservacion` INT NOT NULL,
    `fecha_entrada_reservacion` DATE NOT NULL,
    `fecha_salida_reservacion` DATE NOT NULL,
    `identificacion_huesped_reservacion` INT NOT NULL,
    `cantidad_personas_reservacion` INT NOT NULL,
    `total_reservacion` INT NOT NULL,
    `estado_reservacion` TINYINT NULL DEFAULT NULL,
    PRIMARY KEY (`PK_id_reservacion`),   
    FOREIGN KEY (identificacion_huesped_reservacion) REFERENCES tbl_huesped(PK_no_identificacion)
  ) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;

  -- -----------------------------------------------------
  -- Table `hoteleria`.`tbl_detalle_reservacion`
  -- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hoteleria`.`tbl_detalle_reservacion` (
    `Pk_correlativo_detalle` INT AUTO_INCREMENT NOT NULL,
    `id_reservacion_detalle` INT NOT NULL,
    `id_tarifa_detalle` INT NOT NULL,
    `sub_total_detalle` FLOAT NOT NULL,
    PRIMARY KEY (`Pk_correlativo_detalle`),
    FOREIGN KEY (id_tarifa_detalle) REFERENCES tbl_tarifa(PK_id_tarifa),
    FOREIGN KEY (id_reservacion_detalle) REFERENCES tbl_reservacion(PK_id_reservacion)
  ) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `hoteleria`.`tbl_solicitud_viaje`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hoteleria`.`tbl_solicitud_viaje`(
	`PK_id_solicitud` INT NOT NULL,
    `PK_id_reservacion` INT NOT NULL,
    `id_destino`INT NOT NULL,
    `id_transporte` INT NOT NULL,
    `precio_viaje` INT NOT NULL,
    PRIMARY KEY (`Pk_id_solicitud`),
    FOREIGN KEY (PK_id_reservacion) REFERENCES tbl_reservacion(PK_id_reservacion)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `hoteleria`.`tbl_factura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hoteleria`.`tbl_factura`(
	`PK_id_factura` INT NOT NULL,
    `fecha_emision_factura` DATE NOT NULL,
    `PK_id_reservacion` INT NOT NULL,
    `PK_id_asignar_servicio` INT NOT NULL,
    `PK_id_impuesto` INT NOT NULL,
    PRIMARY KEY (`PK_id_factura`),
    FOREIGN KEY (PK_id_reservacion) REFERENCES tbl_reservacion(PK_id_reservacion)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `hoteleria`.`tbl_menu_orden`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hoteleria`.`tbl_menu_orden`(
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
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;