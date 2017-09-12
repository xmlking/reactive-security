-- ----------------------------------------------------------
-- MDB Tools - A library for reading MS Access database files
-- Copyright (C) 2000-2011 Brian Bruns and others.
-- Files in libmdb are licensed under LGPL and the utilities under
-- the GPL, see COPYING.LIB and COPYING files respectively.
-- Check out http://mdbtools.sourceforge.net
-- ----------------------------------------------------------

-- That file uses encoding UTF-8

DROP TABLE IF EXISTS `Locker`;
CREATE TABLE `Locker`
 (
	`DocNumber`			varchar (8), 
	`UserName`			varchar (30)
);

DROP TABLE IF EXISTS `Login`;
CREATE TABLE `Login`
 (
	`UserName`			varchar (30), 
	`UpdateAuth`			varchar (1), 
	`PassWord`			varchar (20), 
	`AddedOn`			datetime, 
	`AddedBy`			varchar (30), 
	`UpdatedOn`			datetime, 
	`UpdatedBy`			varchar (30)
);

DROP TABLE IF EXISTS `LVPO`;
CREATE TABLE `LVPO`
 (
	`PONumber`			varchar (11), 
	`PODate`			date, 
	`DocNumber`			varchar (8), 
	`BY`			varchar (4), 
	`ProvNumber`			varchar (16), 
	`VendorName`			varchar (30), 
	`VendorNumber`			varchar (10), 
	`VendorAddrInd`			varchar (1), 
	`VendorType`			varchar (2), 
	`Items`			varchar (25), 
	`DollarAmount`			float, 
	`DateCompleted`			date, 
	`Comments`			text (255), 
	`CreatedBy`			varchar (30), 
	`CreatedOn`			datetime, 
	`UpdatedBy`			varchar (30), 
	`UpdatedOn`			datetime
);

DROP TABLE IF EXISTS `LVPOnumbers`;
CREATE TABLE `LVPOnumbers`
 (
	`PONumber`			int, 
	`Used`			varchar (1)
);

DROP TABLE IF EXISTS `PORegnumbers`;
CREATE TABLE `PORegnumbers`
 (
	`POnumber`			int, 
	`Used`			varchar (1)
);

DROP TABLE IF EXISTS `PriorYears`;
CREATE TABLE `PriorYears`
 (
	`DocNumber`			varchar (8), 
	`FiscalYear`			varchar (9), 
	`DocDate`			datetime, 
	`Vendor`			varchar (30), 
	`VendorNumber`			varchar (10), 
	`VendorAddrInd`			varchar (1), 
	`Program`			varchar (20), 
	`Description`			varchar (30), 
	`ReqDate`			datetime, 
	`ReqNumber`			varchar (11), 
	`NumberLines`			float, 
	`PONumber`			varchar (11), 
	`PODate`			datetime, 
	`Amount`			float, 
	`FiscalRU`			varchar (6), 
	`DeptID`			varchar (16), 
	`A`			varchar (1), 
	`Object`			varchar (6), 
	`DateReceived`			datetime, 
	`DatePaid`			datetime, 
	`InvoiceNumber`			varchar (30), 
	`Comments`			text (255), 
	`CreatedBy`			varchar (30), 
	`CreatedOn`			datetime, 
	`UpdatedBy`			varchar (30), 
	`UpdatedOn`			datetime
);

DROP TABLE IF EXISTS `PriorYearsArchive`;
CREATE TABLE `PriorYearsArchive`
 (
	`DocNumber`			varchar (8), 
	`FiscalYear`			varchar (9), 
	`DocDate`			datetime, 
	`Vendor`			varchar (30), 
	`VendorNumber`			varchar (10), 
	`VendorAddrInd`			varchar (1), 
	`Program`			varchar (20), 
	`Description`			varchar (30), 
	`ReqDate`			datetime, 
	`ReqNumber`			varchar (11), 
	`NumberLines`			float, 
	`PONumber`			varchar (11), 
	`PODate`			datetime, 
	`Amount`			float, 
	`FiscalRU`			varchar (6), 
	`DeptID`			varchar (16), 
	`A`			varchar (1), 
	`Object`			varchar (6), 
	`DateReceived`			datetime, 
	`DatePaid`			datetime, 
	`InvoiceNumber`			varchar (30), 
	`Comments`			text (255), 
	`CreatedBy`			varchar (30), 
	`CreatedOn`			datetime, 
	`UpdatedBy`			varchar (30), 
	`UpdatedOn`			datetime
);

DROP TABLE IF EXISTS `PriorYearsSAVE`;
CREATE TABLE `PriorYearsSAVE`
 (
	`DocNumber`			varchar (8), 
	`FiscalYear`			varchar (9), 
	`DocDate`			datetime, 
	`Vendor`			varchar (30), 
	`VendorNumber`			varchar (10), 
	`VendorAddrInd`			varchar (1), 
	`Program`			varchar (20), 
	`Description`			varchar (30), 
	`ReqDate`			datetime, 
	`ReqNumber`			varchar (11), 
	`NumberLines`			float, 
	`PONumber`			varchar (11), 
	`PODate`			datetime, 
	`Amount`			float, 
	`FiscalRU`			varchar (6), 
	`A`			varchar (1), 
	`Object`			varchar (5), 
	`DateReceived`			datetime, 
	`DatePaid`			datetime, 
	`InvoiceNumber`			varchar (30), 
	`Comments`			text (255), 
	`CreatedBy`			varchar (30), 
	`CreatedOn`			datetime, 
	`UpdatedBy`			varchar (30), 
	`UpdatedOn`			datetime
);

DROP TABLE IF EXISTS `ReqList`;
CREATE TABLE `ReqList`
 (
	`DocNumber`			varchar (8), 
	`DocDate`			datetime, 
	`Vendor`			varchar (30), 
	`VendorNumber`			varchar (10), 
	`VendorAddrInd`			varchar (1), 
	`Program`			varchar (20), 
	`Description`			varchar (30), 
	`DeptID`			varchar (16), 
	`ReqDate`			datetime, 
	`ReqNumber`			varchar (11), 
	`NumberLines`			float, 
	`PONumber`			varchar (11), 
	`PODate`			datetime, 
	`Amount`			float, 
	`FiscalRU`			varchar (6), 
	`A`			varchar (1), 
	`Object`			varchar (6), 
	`DateReceived`			datetime, 
	`DatePaid`			datetime, 
	`InvoiceNumber`			varchar (30), 
	`Comments`			text (255), 
	`CreatedBy`			varchar (30), 
	`CreatedOn`			datetime, 
	`UpdatedBy`			varchar (30), 
	`UpdatedOn`			datetime
);

DROP TABLE IF EXISTS `MSysCompactError`;
CREATE TABLE `MSysCompactError`
 (
	`ErrorCode`			int, 
	`ErrorDescription`			text (255), 
	`ErrorTable`			varchar (255), 
	`ErrorRecid`			varchar (255)
);

DROP TABLE IF EXISTS `POReg`;
CREATE TABLE `POReg`
 (
	`PONumber`			float, 
	`PODate`			datetime, 
	`DEPT`			float, 
	`ReqNumber`			varchar (8), 
	`VendorName`			varchar (30), 
	`VendorType`			float, 
	`Description`			varchar (25), 
	`Comments`			text (255), 
	`CreatedBy`			varchar (30), 
	`CreatedOn`			datetime, 
	`UpdatedBy`			varchar (30), 
	`UpdatedOn`			datetime
);

DROP TABLE IF EXISTS `ProviderMaster`;
CREATE TABLE `ProviderMaster`
 (
	`FiscalRU`			varchar (6), 
	`Vendor Number`			varchar (10), 
	`VendorAddrInd`			varchar (1), 
	`ProgramName`			varchar (20), 
	`CC`			varchar (3), 
	`Name`			varchar (45), 
	`DeptID`			varchar (16), 
	`Inactive`			varchar (1), 
	`InactiveDate`			datetime, 
	`InactiveComment`			text (255)
);

DROP TABLE IF EXISTS `Conversion Errors`;
CREATE TABLE `Conversion Errors`
 (
	`Object Type`			varchar (255), 
	`Object Name`			varchar (255), 
	`Error Description`			text (255)
);

DROP TABLE IF EXISTS `Conversion Errors1`;
CREATE TABLE `Conversion Errors1`
 (
	`Object Type`			varchar (255), 
	`Object Name`			varchar (255), 
	`Error Description`			text (255)
);


