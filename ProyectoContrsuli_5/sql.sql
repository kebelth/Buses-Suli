/*Se crea la base de datos */
drop schema contrasuli;
drop user admin_contrasuli;

/*Se crea la base de datos */
CREATE SCHEMA `contrasuli` ;

USE contrasuli;

/*Se crea un usuario para la base de datos llamado "admin_contrasuli" y tiene la contraseña "admin_C."*/
create user 'admin_contrasuli'@'%' identified by 'admin_C.';
/*Se asignan los prvilegios sobr ela base de datos TechShop al usuario creado */
grant all privileges on contrasuli.* to 'admin_contrasuli'@'%';
flush privileges;

/*se crea la tabla de usuarios*/
CREATE TABLE tab_usuario(
	usu_ced INT NOT NULL PRIMARY KEY,
	usu_nmombre VARCHAR(20) NOT NULL,
	usu_apellido1 VARCHAR(20) NOT NULL,
	usu_apellido2 VARCHAR(20),
	usu_correo VARCHAR(40) NOT NULL,
    usu_edad INT NOT NULL
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;

INSERT INTO tab_usuario VALUES (123456,"Pedro", "Londres", "Mora","plondmora@gmail.com", 22);
INSERT INTO tab_usuario VALUES (234567,"Juan", "Porras", "Porras","plondmora@gmail.com", 22);
INSERT INTO tab_usuario VALUES (345678,"Maria", "Rodriguez", "Saborio","plondmora@gmail.com", 22);
INSERT INTO tab_usuario VALUES (4567896,"Lorena", "Hernandez", "Solano","plondmora@gmail.com", 22);


/*Se crea la tabla para las rutas */
DROP TABLE IF EXISTS tab_ruta;
CREATE TABLE tab_ruta(
	rut_id INT NOT NULL AUTO_INCREMENT  PRIMARY KEY,
	rut_cod INT NOT NULL,
    rut_nombre VARCHAR(30) NOT NULL
);

INSERT INTO tab_ruta VALUES (1,145, "San Jose a Puriscal");
INSERT INTO tab_ruta VALUES (2,239, "San Jose Palmichal");
INSERT INTO tab_ruta VALUES (3,240, "San Jose a Cuidad Colon");

/*Se crea la tabla para los buses*/
CREATE TABLE tab_bus(
	bus_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	bus_unidad INT NOT NULL,
	rut_id INT NOT NULL,
    bus_capacidad INT NOT NULL,
    FOREIGN KEY (rut_id) REFERENCES tab_ruta(rut_id)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;

INSERT INTO tab_bus VALUES (1,110, 1, 60);
INSERT INTO tab_bus VALUES (2,120, 1, 55);
INSERT INTO tab_bus VALUES (3,130, 2, 60);
INSERT INTO tab_bus VALUES (4,220, 3, 50);
INSERT INTO tab_bus VALUES (5,210, 2, 62);

/*Se crea la tabla para los horarios */
CREATE TABLE tab_horario(
	hor_codigo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	rut_id INT NOT NULL,
    bus_id INT NOT NULL,
    hor_hora VARCHAR(10) NOT NULL,
    hor_servicio VARCHAR(20) NOT NULL,
    FOREIGN KEY (rut_id) REFERENCES tab_ruta(rut_id),
    FOREIGN KEY (bus_id) REFERENCES tab_bus(bus_id)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;

INSERT INTO tab_horario VALUES (1, "1",1, "10:50AM", "Colectivo");
INSERT INTO tab_horario VALUES (2, "2", 4,"2:50PM", "Colectivo");
INSERT INTO tab_horario VALUES (3, "3", 5,"4:50PM", "Colectivo");

/*Se crea la tabla para las paradas*/
CREATE TABLE tab_parada(
	id_parada INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	rut_id INT NOT NULL,
    par_nombre VARCHAR(30) NOT NULL,
    FOREIGN KEY (rut_id) REFERENCES tab_ruta(rut_id)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;

INSERT INTO tab_parada VALUES (1, 1,"Ciudad Colon");
INSERT INTO tab_parada VALUES (2, 2,"Puente de Pozos");
INSERT INTO tab_parada VALUES (3, 1,"El alto de Quitirricí");
INSERT INTO tab_parada VALUES (4, 2,"Brazil de Mora");
INSERT INTO tab_parada VALUES (5, 3,"San Antonio");
INSERT INTO tab_parada VALUES (6, 1,"San José");

/*Se crea la tabla para las tarifas*/
CREATE TABLE tab_tarifa(
	tar_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    tar_precio INT NOT NULL,
    id_parada INT NOT NULL,
    rut_id INT NOT NULL,
    FOREIGN KEY (id_parada) REFERENCES tab_parada(id_parada),
    FOREIGN KEY (rut_id) REFERENCES tab_ruta(rut_id))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;

INSERT INTO tab_tarifa VALUES (1, "510", 1, 1);
INSERT INTO tab_tarifa VALUES (2, 750,"3", 3);
INSERT INTO tab_tarifa VALUES (3, 1050,"6", 2);

CREATE TABLE tab_tiket(
	tik_id INT NOT NULL AUTO_INCREMENT,
    tik_nombre VARCHAR (20) NOT NULL,
    tik_apellido VARCHAR (20) NOT NULL,
    tik_correo VARCHAR (20) NOT NULL,
    tik_cantidad INT NOT NULL,
    rut_id INT NOT NULL,
    PRIMARY KEY (tik_id),
   FOREIGN KEY (rut_id) REFERENCES tab_ruta(rut_id))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;