USE propertydb;

INSERT INTO `property` (`propertyId`,`description`) VALUES (1,'RCC buildings');
INSERT INTO `property` (`propertyId`,`description`) VALUES (2,'RCC buildings with cement or red-oxide flooring');
INSERT INTO `property` (`propertyId`,`description`) VALUES (3,'Tiled/Sheet of all kinds');

INSERT INTO `zone` (`zoneId`,`zoneName`) VALUES (1,'Zone A');
INSERT INTO `zone` (`zoneId`,`zoneName`) VALUES (2,'Zone B');
INSERT INTO `zone` (`zoneId`,`zoneName`) VALUES (3,'Zone C');

INSERT INTO `zonedetails` (`id`,`rate`,`status`,`property_propertyId`,`zone_zoneId`) VALUES (1,5,0,1,1);
INSERT INTO `zonedetails` (`id`,`rate`,`status`,`property_propertyId`,`zone_zoneId`) VALUES (2,4,0,1,2);
INSERT INTO `zonedetails` (`id`,`rate`,`status`,`property_propertyId`,`zone_zoneId`) VALUES (3,3.6,0,1,3);
INSERT INTO `zonedetails` (`id`,`rate`,`status`,`property_propertyId`,`zone_zoneId`) VALUES (4,2.5,1,1,1);
INSERT INTO `zonedetails` (`id`,`rate`,`status`,`property_propertyId`,`zone_zoneId`) VALUES (5,2,1,1,2);
INSERT INTO `zonedetails` (`id`,`rate`,`status`,`property_propertyId`,`zone_zoneId`) VALUES (6,1.8,1,1,3);
INSERT INTO `zonedetails` (`id`,`rate`,`status`,`property_propertyId`,`zone_zoneId`) VALUES (7,4,0,2,1);
INSERT INTO `zonedetails` (`id`,`rate`,`status`,`property_propertyId`,`zone_zoneId`) VALUES (8,3.5,0,2,2);
INSERT INTO `zonedetails` (`id`,`rate`,`status`,`property_propertyId`,`zone_zoneId`) VALUES (9,3,0,2,3);
INSERT INTO `zonedetails` (`id`,`rate`,`status`,`property_propertyId`,`zone_zoneId`) VALUES (10,1.8,1,2,1);
INSERT INTO `zonedetails` (`id`,`rate`,`status`,`property_propertyId`,`zone_zoneId`) VALUES (11,1.6,1,2,2);
INSERT INTO `zonedetails` (`id`,`rate`,`status`,`property_propertyId`,`zone_zoneId`) VALUES (12,1.2,1,2,3);
INSERT INTO `zonedetails` (`id`,`rate`,`status`,`property_propertyId`,`zone_zoneId`) VALUES (13,3,0,3,1);
INSERT INTO `zonedetails` (`id`,`rate`,`status`,`property_propertyId`,`zone_zoneId`) VALUES (14,2.5,0,3,2);
INSERT INTO `zonedetails` (`id`,`rate`,`status`,`property_propertyId`,`zone_zoneId`) VALUES (15,2,0,3,3);
INSERT INTO `zonedetails` (`id`,`rate`,`status`,`property_propertyId`,`zone_zoneId`) VALUES (16,1.25,1,3,1);
INSERT INTO `zonedetails` (`id`,`rate`,`status`,`property_propertyId`,`zone_zoneId`) VALUES (17,1,1,3,2);
INSERT INTO `zonedetails` (`id`,`rate`,`status`,`property_propertyId`,`zone_zoneId`) VALUES (18,0.75,1,3,3);
