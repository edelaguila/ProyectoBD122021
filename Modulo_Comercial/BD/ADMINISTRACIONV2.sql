SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `administracion` DEFAULT CHARACTER SET utf8 ;
USE `administracion` ;

-- -----------------------------------------------------
-- Table `administracion`.`linea`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `administracion`.`tbl_linea` (
 `PK_codigo_linea` INT NULL DEFAULT NULL,
   `nombre_linea` VARCHAR(35) NULL DEFAULT NULL,
  `estatus_linea` TINYINT(2) NOT NULL,
  PRIMARY KEY (`PK_codigo_linea`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `administracion`.`marca`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `administracion`.`tbl_marca` (
 `PK_codigo_marca` INT NULL DEFAULT NULL,
   `nombre_marca` VARCHAR(35) NULL DEFAULT NULL,
  `estatus_marca` TINYINT(2) NOT NULL,
  PRIMARY KEY (`PK_codigo_marca`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `administracion`.`bodega`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `administracion`.`tbl_bodega` (
 `PK_codigo_bodega` INT NULL DEFAULT NULL,
   `nombre_bodega` VARCHAR(35) NULL DEFAULT NULL,
  `estatus_bodega` TINYINT(2) NOT NULL,
  PRIMARY KEY (`PK_codigo_bodega`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `administracion`.`unidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `administracion`.`tbl_unidad` (
 `PK_codigo_unidad` INT NULL DEFAULT NULL,
   `unidad_entrada` VARCHAR(35) NULL DEFAULT NULL,
  `unidad_salida` VARCHAR(35) NULL DEFAULT NULL,
  PRIMARY KEY (`PK_codigo_unidad`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `administracion`.`transporte_fecha`
-- -----------------------------------------------------
 CREATE TABLE IF NOT EXISTS `administracion`.`tbl_transportefecha` (
	`PK_codigo_transportefecha` INT NULL DEFAULT NULL,
    `nombre_transportefecha` VARCHAR(35) NULL DEFAULT NULL,
    `fecha_transportefecha` VARCHAR(35) NULL DEFAULT NULL,
    `estatus_transportefecha` TINYINT(2) NOT NULL,
	PRIMARY KEY (`PK_codigo_transportefecha`))
	ENGINE = InnoDB
	DEFAULT CHARACTER SET = utf8;
-- -----------------------------------------------------
-- Table `administracion`.`transporte_tipo`
-- -----------------------------------------------------
 CREATE TABLE IF NOT EXISTS `administracion`.`tbl_transportetipo` (
	`PK_codigo_transporte_tipo` INT NULL DEFAULT NULL,
    `nombre_transportetipo` VARCHAR(35) NULL DEFAULT NULL,
    `tipo_transportetipo` VARCHAR(35) NULL DEFAULT NULL,
    `estatus_transportefecha` TINYINT(2) NOT NULL,
	PRIMARY KEY (`PK_codigo_transporte_tipo`))
	ENGINE = InnoDB
	DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `administracion`.`transporte_ruta`
-- -----------------------------------------------------
 CREATE TABLE IF NOT EXISTS `administracion`.`tbl_transporteruta` (
	`PK_codigo_transporteruta` INT NULL DEFAULT NULL,
    `nombre_transporteruta` VARCHAR(35) NULL DEFAULT NULL,
    `direccion_transporteruta` VARCHAR(35) NULL DEFAULT NULL,
    `costo_transporteruta` TINYINT(2) NOT NULL,
	PRIMARY KEY (`PK_codigo_transporteruta`))
	ENGINE = InnoDB
	DEFAULT CHARACTER SET = utf8;











-- -----------------------------------------------------
-- Table `administracion`.`transporte`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `administracion`.`tbl_transporte` (
 `PK_codigo_transporte` INT NULL DEFAULT NULL,
   `nombre_transporte` VARCHAR(35) NULL DEFAULT NULL,
  `tipo_transporte` VARCHAR(35) NULL DEFAULT NULL,
  `estatus_transporte` TINYINT(2) NOT NULL,
  `PK_codigo_transportefecha` INT NULL DEFAULT NULL,
  `PK_codigo_transporte_tipo` INT NULL DEFAULT NULL,
  `PK_codigo_transporte_ruta` INT NULL DEFAULT NULL,
  PRIMARY KEY (`PK_codigo_transporte`
  ,`PK_codigo_transportefecha`
  , `PK_codigo_transporte_tipo`
  , `PK_codigo_transporte_ruta`
  ),
  CONSTRAINT `PK_codigo_transportefecha`
  FOREIGN KEY (`PK_codigo_transportefecha`)
REFERENCES `administracion`.`tbl_transportefecha` (`PK_codigo_transportefecha`),
    CONSTRAINT `PK_codigo_transporte_tipo`
  FOREIGN KEY (`PK_codigo_transporte_tipo`)
REFERENCES `administracion`.`tbl_transportetipo` (`PK_codigo_transporte_tipo`),
  CONSTRAINT `tbl_transporteruta1`
  FOREIGN KEY (`PK_codigo_transporte_ruta`)
REFERENCES `administracion`.`tbl_transporteruta` (`PK_codigo_transporteruta`)
  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;





-- -----------------------------------------------------
-- Table `administracion`.`producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `administracion`.`tbl_producto` (
 `PK_codigo_producto` INT NULL DEFAULT NULL,
   `nombre_producto` VARCHAR(35) NULL DEFAULT NULL,
  `descripcion_producto` VARCHAR(35) NULL DEFAULT NULL,
  `precio_producto` INT(10) DEFAULT NULL,
  `costo_producto` INT (10) DEFAULT NULL,
  `estatus_producto` TINYINT(2) NOT NULL,
  `codigo_linea` INT NULL DEFAULT NULL,
  `codigo_marca` INT NULL DEFAULT NULL,
  `codigo_bodega` INT NULL DEFAULT NULL,
  `codigo_unidad` INT NULL DEFAULT NULL,
  
  PRIMARY KEY (
  `PK_codigo_producto`,
  `codigo_linea`,
  `codigo_marca`,
  `codigo_bodega`,
  `codigo_unidad`
),
  CONSTRAINT `fk_codigo_linea`
  FOREIGN KEY (`codigo_linea`)
REFERENCES `administracion`.`tbl_linea` (`PK_codigo_linea`),

CONSTRAINT `fk_codigo_marca`
FOREIGN KEY (`codigo_marca`)
REFERENCES `administracion`.`tbl_marca` (`PK_codigo_marca`),   
  
CONSTRAINT `fk_codigo_bodega` 
FOREIGN KEY (`codigo_bodega`)
REFERENCES `administracion`.`tbl_bodega` (`PK_codigo_bodega`),
 
 CONSTRAINT `fk_codigo_unidad1` 
 FOREIGN KEY (`codigo_unidad`)
REFERENCES `administracion`.`tbl_unidad` (`PK_codigo_unidad`)
   
  
  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `administracion`.`existencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `administracion`.`tbl_existencia` (

`Pk_codigo_producto` INT NULL DEFAULT NULL,
`Pk_codigo_bodega` INT NULL DEFAULT NULL,
`existencia_cantidad`INT NULL DEFAULT NULL,
  PRIMARY KEY (
 
  `Pk_codigo_producto` ,
  `Pk_codigo_bodega`

),
CONSTRAINT `fk_PK_codigo_producto1` 
  FOREIGN KEY (`Pk_codigo_producto`)
REFERENCES `administracion`.`tbl_producto` (`PK_codigo_producto`),
CONSTRAINT `fk_PK_codigo_bodega1` 
FOREIGN KEY (`PK_codigo_bodega`)
REFERENCES `administracion`.`tbl_bodega` (`PK_codigo_bodega`)   
  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `administracion`.`proveedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `administracion`.`tbl_proveedor` (
 `PK_codigo_proveedor` INT NULL DEFAULT NULL,
   `nombre_proveedor` VARCHAR(35) NULL DEFAULT NULL,
   `direccion_proveedor` VARCHAR(35) NULL DEFAULT NULL,
   `telefono_proveedor` VARCHAR(35) NULL DEFAULT NULL,
   `nit_proveedor` INT(10) DEFAULT NULL,
   `email_proveedor` VARCHAR(35) NULL DEFAULT NULL,
   `saldo_proveedor` FLOAT DEFAULT NULL,
   `estatus_proveedor` TINYINT(2) NOT NULL,
  PRIMARY KEY (`PK_codigo_proveedor`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `administracion`.`forma_pago`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `administracion`.`tbl_pago` (
 `PK_codigo_pago` INT NULL DEFAULT NULL,
   `tipo_pago` VARCHAR(35) NULL DEFAULT NULL,
   `descripcion_pago` VARCHAR(35) NULL DEFAULT NULL,
   `fecha_pago` VARCHAR(35) NULL DEFAULT NULL,
   `estatus_pago` TINYINT(2) NOT NULL,
  PRIMARY KEY (`PK_codigo_pago`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `administracion`.`compra_factura_encabezado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `administracion`.`compra_factura_encabezado` (
 `PK_codigo_factura` INT NULL DEFAULT NULL,
  `PK_codigo_bodega` INT NULL DEFAULT NULL,
 `codigo_proveedor` INT NULL DEFAULT NULL,
   `fecha_emision` VARCHAR(35) NULL DEFAULT NULL,
   `fecha_vencimiento` VARCHAR(35) NULL DEFAULT NULL,
   `tipo_pago` VARCHAR(35) NULL DEFAULT NULL,

  PRIMARY KEY (
  `PK_codigo_factura`,
  `Pk_codigo_bodega`,
  `codigo_proveedor`
  ),
  
  CONSTRAINT `fk_PK_codigo_proveedor1` 
  FOREIGN KEY (`codigo_proveedor`)
REFERENCES `administracion`.`tbl_proveedor` (`PK_codigo_proveedor`)

  )
  
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `administracion`.`compra_factura_detalle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `administracion`.`compra_factura_detalle` (
 `PK_codigo_factura` INT NULL DEFAULT NULL,
 `PK_codigo_producto` INT NULL DEFAULT NULL,
 `PK_codigo_bodega` INT NULL DEFAULT NULL,
 `cantidad_detalle` INT(20) NULL DEFAULT NULL,
`costo_detalle` INT(20) NULL DEFAULT NULL,
`total_detalle` FLOAT (20)NULL DEFAULT NULL,
	 	
  PRIMARY KEY (
  `PK_codigo_factura`,
 `PK_codigo_producto` ,
  `Pk_codigo_bodega`
  ),
  
  CONSTRAINT `fk_PK_codigo_factura10` 
  FOREIGN KEY (`Pk_codigo_factura`)
REFERENCES `administracion`.`compra_factura_encabezado` (`PK_codigo_factura`),

CONSTRAINT `fk_PK_codigo_producto2` 
  FOREIGN KEY (`Pk_codigo_producto`)
REFERENCES `administracion`.`tbl_producto` (`PK_codigo_producto`),

CONSTRAINT `fk_PK_codigo_bodega2` 
FOREIGN KEY (`PK_codigo_bodega`)
REFERENCES `administracion`.`tbl_bodega` (`PK_codigo_bodega`)   
  )
  
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `administracion`.`ordencompra_encabezado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `administracion`.`ordencompra_encabezado` (
 `PK_codigo_ordenCompra` INT NULL DEFAULT NULL,
 `PK_codigo_proveedor` INT NULL DEFAULT NULL,
 `PK_codigo_bodega` INT NULL DEFAULT NULL,
   `fecha_emision` VARCHAR(35) NULL DEFAULT NULL,
   `fecha_entrega` VARCHAR(35) NULL DEFAULT NULL,
   `forma_pago` VARCHAR(35) NULL DEFAULT NULL,
   `estatus_ordecompra` TINYINT(2) NOT NULL,

  PRIMARY KEY (
  `PK_codigo_ordenCompra`,
  `PK_codigo_proveedor`,
  `Pk_codigo_bodega`
  ),
  
  CONSTRAINT `fk_PK_codigo_proveedor2` 
  FOREIGN KEY (`Pk_codigo_proveedor`)
REFERENCES `administracion`.`tbl_proveedor` (`PK_codigo_proveedor`)

  )
  
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `administracion`.`ordencompra_detalle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `administracion`.`ordencompra_detalle` (
 `PK_codigo_ordenCompra` INT NULL DEFAULT NULL,
 `PK_codigo_producto` INT NULL DEFAULT NULL,
 `PK_codigo_bodega` INT NULL DEFAULT NULL,
 `cantidad_detalle` INT(20) NULL DEFAULT NULL,
`precio_detalle` INT(20) NULL DEFAULT NULL,
/* subtotal detalle */
`subtotal_detalle` FLOAT (20)NULL DEFAULT NULL,
`iva_detalle` FLOAT (20)NULL DEFAULT NULL,
`desceunto_detalle` FLOAT (20)NULL DEFAULT NULL,
`total_detalle` FLOAT (20)NULL DEFAULT NULL,
	 	
  PRIMARY KEY (
  `PK_codigo_ordenCompra`,
 `PK_codigo_producto` ,
  `Pk_codigo_bodega`
  ),
  
  CONSTRAINT `fk_PK_codigo_ordenCompra1` 
  FOREIGN KEY (`PK_codigo_ordenCompra`)
REFERENCES `administracion`.`ordencompra_encabezado` (`PK_codigo_ordenCompra`),

CONSTRAINT `fk_PK_codigo_producto21` 
  FOREIGN KEY (`Pk_codigo_producto`)
REFERENCES `administracion`.`tbl_producto` (`PK_codigo_producto`),

CONSTRAINT `fk_PK_codigo_bodega12` 
FOREIGN KEY (`PK_codigo_bodega`)
REFERENCES `administracion`.`tbl_bodega` (`PK_codigo_bodega`)   
  )
  
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;














































-- -----------------------------------------------------
-- Table `administracion`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `administracion`.`tbl_cliente` (
 `PK_codigo_cliente` INT NULL DEFAULT NULL,
   `nombre_cliente` VARCHAR(35) NULL DEFAULT NULL,
  `direccion_cliente` VARCHAR(35) NULL DEFAULT NULL,
    `telefono_cliente` VARCHAR(35) NULL DEFAULT NULL,
  `nit_cliente` INT(10) DEFAULT NULL,
    `email_cliente` VARCHAR(35) NULL DEFAULT NULL,
  `saldo_cliente` INT DEFAULT NULL,
  `cuenta_cliente` INT DEFAULT NULL,
  `estatus_cliente` TINYINT(2) NOT NULL,
  PRIMARY KEY (`PK_codigo_cliente`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `administracion`.`cobrador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `administracion`.`tbl_cobrador` (
 `PK_codigo_cobrador` INT NULL DEFAULT NULL,
   `nombre_cobrador` VARCHAR(35) NULL DEFAULT NULL,
  `estatus_cobrador` TINYINT(2) NOT NULL,
  PRIMARY KEY (`PK_codigo_cobrador`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
-- -----------------------------------------------------
-- Table `administracion`.`vendedores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `administracion`.`tbl_vendedor` (
 `PK_codigo_vendedor` INT NULL DEFAULT NULL,
   `nombre_vendedor` VARCHAR(35) NULL DEFAULT NULL,
  `estatus_vendedor` TINYINT(2) NOT NULL,
  PRIMARY KEY (`PK_codigo_vendedor`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
-- -----------------------------------------------------
-- Table `administracion`.`control_precio_detalle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `administracion`.`tbl_control_precio_detalle` (
 `PK_codigo_producto_precio_detalle` INT NULL DEFAULT NULL,
   `PK_codigo_producto`INT NULL DEFAULT NULL,
  PRIMARY KEY (
  `PK_codigo_producto_precio_detalle`,
  `PK_codigo_producto`
),
    CONSTRAINT `fk_PK_codigo_producto_precio` 
  FOREIGN KEY (`PK_codigo_producto`)
REFERENCES `administracion`.`tbl_producto` (`PK_codigo_producto`)
  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `administracion`.`control_cotizacion_detalle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `administracion`.`tbl_control_cotizacion_encabezado` (
 `PK_codigo_cotizacion_encabezado` INT NULL DEFAULT NULL,
   `PK_codigo_cliente`INT NULL DEFAULT NULL,
   `PK_codigo_vendedor`INT NULL DEFAULT NULL,
   `fecha_emision` VARCHAR(35) NULL DEFAULT NULL,
  PRIMARY KEY (
 `PK_codigo_cotizacion_encabezado`,
   `PK_codigo_cliente`,
   `PK_codigo_vendedor`
),
    CONSTRAINT `Fk_PK_codigo_clienteq` 
  FOREIGN KEY (`PK_codigo_cliente`)
REFERENCES `administracion`.`tbl_cliente` (`PK_codigo_cliente`),
CONSTRAINT `FK_PK_codigo_vendedorq` 
  FOREIGN KEY ( `PK_codigo_vendedor`)
REFERENCES `administracion`.`tbl_vendedor` (`PK_codigo_vendedor`)
  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
CREATE TABLE IF NOT EXISTS `administracion`.`tbl_control_pedido_encabezado` (
 `PK_codigo_cotizacion_encabezado` INT NULL DEFAULT NULL,
   `PK_codigo_cliente`INT NULL DEFAULT NULL,
   `PK_codigo_vendedor`INT NULL DEFAULT NULL,
   `fecha_emision` VARCHAR(35) NULL DEFAULT NULL,
  PRIMARY KEY (
 `PK_codigo_cotizacion_encabezado`,
   `PK_codigo_cliente`,
   `PK_codigo_vendedor`
),
    CONSTRAINT `Fk_PK_codigo_clientew` 
  FOREIGN KEY (`PK_codigo_cliente`)
REFERENCES `administracion`.`tbl_cliente` (`PK_codigo_cliente`),
CONSTRAINT `FK_PK_codigo_vendedorw` 
  FOREIGN KEY ( `PK_codigo_vendedor`)
REFERENCES `administracion`.`tbl_vendedor` (`PK_codigo_vendedor`)

  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
CREATE TABLE IF NOT EXISTS `administracion`.`tbl_control_factura_encabezado` (
 `PK_codigo_cotizacion_encabezado` INT NULL DEFAULT NULL,
   `PK_codigo_cliente`INT NULL DEFAULT NULL,
   `PK_codigo_cobrador`INT NULL DEFAULT NULL,
   `PK_codigo_vendedor`INT NULL DEFAULT NULL,
   `fecha_emision` VARCHAR(35) NULL DEFAULT NULL,
  PRIMARY KEY (
 `PK_codigo_cotizacion_encabezado`,
   `PK_codigo_cliente`,
   `PK_codigo_vendedor`,
	
      `PK_codigo_cobrador`
),
    CONSTRAINT `Fk_PK_codigo_clienter` 
  FOREIGN KEY (`PK_codigo_cliente`)
REFERENCES `administracion`.`tbl_cliente` (`PK_codigo_cliente`),
CONSTRAINT `FK_PK_codigo_vendedorr` 
  FOREIGN KEY ( `PK_codigo_vendedor`)
REFERENCES `administracion`.`tbl_vendedor` (`PK_codigo_vendedor`),
CONSTRAINT  `FK_PK_codigo_cobradorr`
 FOREIGN KEY ( `PK_codigo_cobrador`)
REFERENCES `administracion`.`tbl_cobrador` ( `PK_codigo_cobrador`)
  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
CREATE TABLE IF NOT EXISTS `administracion`.`tbl_cotizacion_detalle` (
 `PK_codigo_cotizacion_detalle` INT NULL DEFAULT NULL,
   `cantidad_detalle` FLOAT(15) NULL DEFAULT NULL,
    `iva_detalle` FLOAT(15) NULL DEFAULT NULL,
   `subtotal_detalle` FLOAT(15) NULL DEFAULT NULL,
  PRIMARY KEY (
 `PK_codigo_cotizacion_detalle` 
   
)
   
  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `administracion`.`tbl_pedido_detalle` (
 `PK_codigo_pedido_detalle` INT NULL DEFAULT NULL,
  `PK_codigo_cotizacion_detalle` INT NULL DEFAULT NULL,
   `cantidad_detalle` FLOAT(15) NULL DEFAULT NULL,
    `iva_detalle` FLOAT(15) NULL DEFAULT NULL,
   `subtotal_detalle` FLOAT(15) NULL DEFAULT NULL,
  PRIMARY KEY (
 `PK_codigo_pedido_detalle` ,
 `PK_codigo_cotizacion_detalle` ),
 
CONSTRAINT `FK_PK_codigo_cotizacion_detalleZ` 
  FOREIGN KEY ( `PK_codigo_cotizacion_detalle`)
REFERENCES `administracion`.`tbl_cotizacion_detalle` (`PK_codigo_cotizacion_detalle`) 
  )
  ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `administracion`.`tbl_factura_detalle` (
 `PK_codigo_factura_detalle` INT NULL DEFAULT NULL,
  `PK_codigo_pedido_detalle` INT NULL DEFAULT NULL,
   `cantidad_detalle` FLOAT(15) NULL DEFAULT NULL,
    `iva_detalle` FLOAT(15) NULL DEFAULT NULL,
   `subtotal_detalle` FLOAT(15) NULL DEFAULT NULL,
  PRIMARY KEY (
 `PK_codigo_factura_detalle`,
 `PK_codigo_pedido_detalle` 
   
),
  CONSTRAINT `FK_PK_codigo_pedido_detalleZ` 
  FOREIGN KEY ( `PK_codigo_pedido_detalle`)
REFERENCES `administracion`.`tbl_pedido_detalle` (`PK_codigo_pedido_detalle`) 

  
  )
  ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
CREATE TABLE IF NOT EXISTS `administracion`.`tbl_pedido_detalle` (
 `PK_codigo_pedido_detalle` INT NULL DEFAULT NULL,
  `PK_codigo_cotizacion_detalle` INT NULL DEFAULT NULL,
   `cantidad_detalle` FLOAT(15) NULL DEFAULT NULL,
    `iva_detalle` FLOAT(15) NULL DEFAULT NULL,
   `subtotal_detalle` FLOAT(15) NULL DEFAULT NULL,
  PRIMARY KEY (
 `PK_codigo_pedido_detalle` ,
 `PK_codigo_cotizacion_detalle` 
),
  
 CONSTRAINT `FK_PK_codigo_cotizacion_detalleo` 
  FOREIGN KEY ( `PK_codigo_cotizacion_detalle`)
REFERENCES `administracion`.`tbl_cotizacion_detalle` (`PK_codigo_cotizacion_detalle`) 
  
  )
  
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
CREATE TABLE IF NOT EXISTS `administracion`.`tbl_factura` (
 `PK_codigo_factura` INT NULL DEFAULT NULL,
  `PK_codigo_existencia` INT NULL DEFAULT NULL,
   `PK_codigo_producto`  INT NULL DEFAULT NULL,
    `PK_codigo_precio`  INT NULL DEFAULT NULL,
   `PK_cantidad` INT  NULL DEFAULT NULL,
  PRIMARY KEY (
 `PK_codigo_factura`,
 `PK_codigo_existencia`,
 `PK_codigo_producto`,
 `PK_codigo_precio`
),
  CONSTRAINT `FK_PK_codigo_existenciax` 
  FOREIGN KEY ( `PK_codigo_existencia`)
REFERENCES `administracion`.`tbl_pedido_existencia` (`PK_codigo_existencia`) ,

 CONSTRAINT `FK_PK_codigo_productox`
  FOREIGN KEY ( `PK_codigo_producto`)
REFERENCES `administracion`.`tbl_producto` (`PK_codigo_producto`) 
 
  )
  
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
/*
CREATE TABLE IF NOT EXISTS `administracion`.`tbl_pedido` (
 `PK_codigo_pedido` INT NULL DEFAULT NULL,
  `PK_codigo_existencia` INT NULL DEFAULT NULL,
   `PK_codigo_producto`  INT NULL DEFAULT NULL,
    `PK_codigo_precio`  INT NULL DEFAULT NULL,
   `cantidad` INT  NULL DEFAULT NULL,
  PRIMARY KEY (
 `PK_codigo_pedido`,
 `PK_codigo_existencia`,
 `PK_codigo_producto`,
 `PK_codigo_precio`
),
  CONSTRAINT `FK_PK_codigo_existenciax` 
  FOREIGN KEY ( `PK_codigo_existencia`)
REFERENCES `administracion`.`tbl_pedido_existencia` (`PK_codigo_existencia`) ,

 CONSTRAINT `FK_PK_codigo_productox`
  FOREIGN KEY ( `PK_codigo_producto`)
REFERENCES `administracion`.`tbl_producto` (`PK_codigo_producto`) 
 
  )
  
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `administracion`.`tbl_devolucion_venta` (
 `PK_codigo_devolucion` INT NULL DEFAULT NULL,
 `PK_codigo_factura` INT NULL DEFAULT NULL,
  `PK_codigo_existencia` INT NULL DEFAULT NULL,
   `PK_codigo_producto`  INT NULL DEFAULT NULL,
    `PK_codigo_precio`  INT NULL DEFAULT NULL,
   `cantidad` INT  NULL DEFAULT NULL,
  PRIMARY KEY (
 `PK_codigo_factura`,
 `PK_codigo_existencia`,
 `PK_codigo_producto`,
 `PK_codigo_precio`
),
  CONSTRAINT `FK_PK_codigo_existenciax` 
  FOREIGN KEY ( `PK_codigo_existencia`)
REFERENCES `administracion`.`tbl_pedido_existencia` (`PK_codigo_existencia`) ,

 CONSTRAINT `FK_PK_codigo_productox`
  FOREIGN KEY ( `PK_codigo_producto`)
REFERENCES `administracion`.`tbl_producto` (`PK_codigo_producto`) 
 
  )
  
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
*/



