-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Dim 04 Juin 2017 à 23:47
-- Version du serveur :  10.1.19-MariaDB
-- Version de PHP :  5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `projetjee`
--
CREATE DATABASE IF NOT EXISTS `projetjee` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `projetjee`;

-- --------------------------------------------------------

--
-- Structure de la table `recipe`
--

CREATE TABLE IF NOT EXISTS `recipe` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `time` int(50) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  `people` int(11) DEFAULT NULL,
  `resume` varchar(500) DEFAULT NULL,
  `id_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `recipe`
--

INSERT INTO `recipe` (`id`, `name`, `time`, `rating`, `people`, `resume`, `id_type`) VALUES
(1, 'Salade lyonnaise', 15, 4, 4, 'Trier et bien laver les pissenlits à l''eau vinaigrée.\r\nPréparer une vinaigrette moutardée.\r\nDétailler le lard en lardons, le pain en dés. Faire rissoler les lardons dans une poêle anti-adhésive, puis revenir les croûtons dans la même poêle dans le gras rendu par le lard.\r\nPendant ce temps, faire pocher les oeufs : porter à ébullition une casserole d''eau additionnée de vinaigre d''alcool. Casser l''oeuf dans une tasse, utiliser la tasse pour le transvaser dans l''eau bouillante sans le disperser (si', 1),
(2, 'Saumon en papillote', 45, 4, 4, '1 Préchauffez le four à 180 °C.\r\n2 Dans un bol, préparez une sauce : mélangez l''huile d''olive, le jus de citron, le vinaigre balsamique avec une pincée de sel et du poivre.\r\n3 Ciselez finement l''oignon.\r\n4 Découpez 4 feuilles de papier sulfurisé. Déposez les pavés de saumon sur chacune. Recouvrez-les de crème épaisse, d''oignon ciselé et de sauce. Ajoutez un brin de thym par papillote puis refermez-les en les maintenant à l''aide d''un cure-dents.\r\n5 Déposez les papillotes dans un plat, enfournez p', 3),
(3, 'Mousse au chocolat', 30, 4, 3, 'Séparer les blancs des jaunes d''oeufs.\r\nFaire ramollir le chocolat dans une casserole au bain-marie.\r\nHors du feu, incorporer les jaunes et le sucre.\r\nBattre les blancs en neige ferme et les ajouter délicatement au mélange à l''aide d''une spatule.\r\nVerser dans une terrine ou des verrines et mettre au frais 1 heure ou 2 minimum.', 4),
(4, 'Boeuf braisé aux carottes', 170, 5, 6, 'Couper la viande en morceaux égaux. La faire revenir dans une cocotte en fonte, dans laquelle vous avez fait chauffer la matière grasse.\r\nUne fois les morceaux revenus de tous les côtés, les retirer et faire revenir les oignons émincés et les lardons.\r\nPréparer le bouillon de boeuf avec 1/2 litre d''eau.\r\nAjouter la viande dans la cocotte, y verser le bouillon, le concentré de tomates, les carottes épluchées et coupées en tronçons, l''ail et les herbes.\r\nAssaisonner avec le sel etle poivre, mélang', 2),
(5, 'Tajine de poulet', 60, 3, 4, 'Faire revenir le poulet à feu moyen pour qu''il soit un peu doré.\r\nPendant ce temps, peler et couper les légumes : couper les carottes en 2 , puis dans le sens de la longueur. Idem pour les courgettes. Couper les oignons en lamelles et les pommes de terres en 4.\r\nMettre les légumes avec le poulet, rajouter les épices à tajine et le cumin. Mettez également un peu d''eau (3/4 verre d''eau).\r\nLaisser cuire environ 1 heure et voilà, c''est prêt !', 2),
(6, 'Salade niçoise', 25, 4, 4, 'Pour réaliser la salade niçoise, il suffit de rassembler tous les ingrédients, puis de procéder de la manière suivante...\r\nFaire durcir les oeufs (6 à 8 minutes après ébullition de l''eau), puis les faire bien refroidir à l''eau froide.\r\nHacher les cébettes et les disposer au fond du plat.\r\nAjouter les févettes, le poivron vert finement coupé, les radis coupés en rondelles et le thon bien égouté et émietté. Mélanger grossièrement tous ces ingrédients avec du sel et du poivre.\r\nCouper les tomates e', 1),
(7, 'Glace vanille', 30, 5, 1, 'Mettre une boule vanille dans une coupe. Miaaaaaaaaaaam.', 4),
(8, 'Cordon bleu', 45, 3, 4, 'Dans chaque tranche de poulet mettre deux tranches de bacon l''une à côté de l''autre et poser dessus une tranche de fromage.\r\nRefermer le tout en pliant la tranche en deux.\r\nPrévoir 3 assiettes et mettre dedans la farine, l''oeuf battu et la chapelure.\r\nTremper chaque escalope d''abord dans la farine, puis dans l''oeuf et pour finir dans la chapelure.\r\nLes faire cuire quelques minutes de chaque côté dans une poêle avec un peu de beurre.\r\nDéguster immédiatement.', 2),
(9, 'Tajine de poulet3', NULL, 158, 64, 'Pareil que lautre, mais en mieux', NULL),
(10, 'CrÃ¨me sautÃ©', NULL, 5, 4, 'Faite de la crÃ¨me lancÃ© la', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `recipe_comments`
--

CREATE TABLE IF NOT EXISTS `recipe_comments` (
  `id` int(11) NOT NULL,
  `id_recipe` int(11) DEFAULT NULL,
  `id_user` int(11) DEFAULT NULL,
  `date` varchar(50) DEFAULT NULL,
  `comment` varchar(500) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `type_recipe`
--

CREATE TABLE IF NOT EXISTS `type_recipe` (
  `id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `type_recipe`
--

INSERT INTO `type_recipe` (`id`, `name`) VALUES
(1, 'salad'),
(2, 'meal'),
(3, 'fish'),
(4, 'dessert');

-- --------------------------------------------------------

--
-- Structure de la table `userreg`
--

CREATE TABLE IF NOT EXISTS `userreg` (
  `name` varchar(64) NOT NULL,
  `pass` varchar(64) NOT NULL,
  `nom` varchar(32) NOT NULL,
  `email` varchar(64) NOT NULL,
  `age` int(4) DEFAULT NULL,
  `admin` tinyint(1) NOT NULL DEFAULT '0',
  `Lastconnection` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`name`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `userreg`
--

INSERT INTO `userreg` (`name`, `pass`, `nom`, `email`, `age`, `admin`, `Lastconnection`) VALUES
('Test1', 'null', 'Erico', 'eric@testo.de', 22, 0, '2017-06-04 13:51:26');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
