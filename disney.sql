-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         8.0.26 - MySQL Community Server - GPL
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Volcando datos para la tabla disney.genero: ~6 rows (aproximadamente)
/*!40000 ALTER TABLE `genero` DISABLE KEYS */;
INSERT INTO `genero` (`id`, `nombre`, `imagen`) VALUES
	(1, 'Aventura', 'ruta://'),
	(2, 'Ciencia Ficcion', 'ruta://'),
	(3, 'Comedia', 'ruta://'),
	(4, 'Fantasía', 'ruta://'),
	(5, 'Musical', 'ruta://'),
	(6, 'Acción', 'ruta://');
/*!40000 ALTER TABLE `genero` ENABLE KEYS */;

-- Volcando datos para la tabla disney.metraje: ~15 rows (aproximadamente)
/*!40000 ALTER TABLE `metraje` DISABLE KEYS */;
INSERT INTO `metraje` (`id`, `titulo`, `imagen`, `fecha`, `calificacion`) VALUES
	(1, 'Fantansia', 'ruta...', '2021-08-30', 5),
	(2, 'Moana', 'ruta...', '2021-08-30', 4),
	(3, 'Avengers Infinity war', '//algo....', '2019-09-03', 5),
	(4, 'Avengers Endgame', '//algo....', '2020-06-03', 5),
	(5, 'Mulan', '//algo....', '2021-05-10', 5),
	(6, 'Blancanieves', '//algo....', '1937-12-20', 4),
	(8, 'La bella y la bestia', '//algo modificado', '1991-12-20', 4),
	(9, 'El rey leon', '//ruta', '1993-12-31', 4),
	(10, 'Star wars El imperio contraataca', '//ruta', '1980-01-01', 4),
	(12, 'Star wars El retorno del Jedi', '//ruta', '1983-01-01', 4),
	(14, 'Star wars La amenaza fantasma', '//ruta modif', '1999-01-01', 5),
	(15, 'Star wars El ataque de los clones', '//ruta', '2002-01-01', 4.5),
	(16, 'Star wars La venganza de los Sith', '//ruta mod', '2005-01-01', 5),
	(18, 'Lilo y Stich', '//ruta', '2000-01-01', 4.5),
	(19, 'Pelicula01', '//ruta', '2000-01-01', 4);
/*!40000 ALTER TABLE `metraje` ENABLE KEYS */;

-- Volcando datos para la tabla disney.metraje_genero: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `metraje_genero` DISABLE KEYS */;
/*!40000 ALTER TABLE `metraje_genero` ENABLE KEYS */;

-- Volcando datos para la tabla disney.metraje_personaje: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `metraje_personaje` DISABLE KEYS */;
INSERT INTO `metraje_personaje` (`id`, `metraje_id`, `personaje_id`) VALUES
	(1, 1, 2),
	(2, 1, 3);
/*!40000 ALTER TABLE `metraje_personaje` ENABLE KEYS */;

-- Volcando datos para la tabla disney.personaje: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `personaje` DISABLE KEYS */;
INSERT INTO `personaje` (`id`, `nombre`, `imagen`, `edad`, `peso`, `historia`) VALUES
	(2, 'Mickey Mouse', 'ruta...', 92, 1, 'bla bla bla'),
	(3, 'Minnie Mouse', 'asldka', 90, 0.5, 'sarasa'),
	(4, 'Iron Man', 'asd', 51, 84, 'jasdjklasjkl'),
	(5, 'personaje1', 'ruta...', 21, 80, 'bla bla bla');
/*!40000 ALTER TABLE `personaje` ENABLE KEYS */;

-- Volcando datos para la tabla disney.usuario: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`id`, `name`, `last_name`, `mail`, `username`, `password`) VALUES
	(1, 'Axel', 'Lopez', 'lopez.b.axel@gmail.com', 'laxel', '1234');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
