-- ----------------------------------------------------------
-- MDB Tools - A library for reading MS Access database files
-- Copyright (C) 2000-2011 Brian Bruns and others.
-- Files in libmdb are licensed under LGPL and the utilities under
-- the GPL, see COPYING.LIB and COPYING files respectively.
-- Check out http://mdbtools.sourceforge.net
-- ----------------------------------------------------------

-- That file uses encoding UTF-8

CREATE TABLE [Locker]
 (
	[DocNumber]			Text (8), 
	[UserName]			Text (30)
);

CREATE TABLE [Login]
 (
	[UserName]			Text (30), 
	[UpdateAuth]			Text (1), 
	[PassWord]			Text (20), 
	[AddedOn]			DateTime, 
	[AddedBy]			Text (30), 
	[UpdatedOn]			DateTime, 
	[UpdatedBy]			Text (30)
);

CREATE TABLE [LVPO]
 (
	[PONumber]			Text (11), 
	[PODate]			DateTime, 
	[DocNumber]			Text (8), 
	[BY]			Text (4), 
	[ProvNumber]			Text (16), 
	[VendorName]			Text (30), 
	[VendorNumber]			Text (10), 
	[VendorAddrInd]			Text (1), 
	[VendorType]			Text (2), 
	[Items]			Text (25), 
	[DollarAmount]			Double, 
	[DateCompleted]			DateTime, 
	[Comments]			Memo/Hyperlink (255), 
	[CreatedBy]			Text (30), 
	[CreatedOn]			DateTime, 
	[UpdatedBy]			Text (30), 
	[UpdatedOn]			DateTime
);

CREATE TABLE [LVPOnumbers]
 (
	[PONumber]			Long Integer, 
	[Used]			Text (1)
);

CREATE TABLE [PORegnumbers]
 (
	[POnumber]			Long Integer, 
	[Used]			Text (1)
);

CREATE TABLE [PriorYears]
 (
	[DocNumber]			Text (8), 
	[FiscalYear]			Text (9), 
	[DocDate]			DateTime, 
	[Vendor]			Text (30), 
	[VendorNumber]			Text (10), 
	[VendorAddrInd]			Text (1), 
	[Program]			Text (20), 
	[Description]			Text (30), 
	[ReqDate]			DateTime, 
	[ReqNumber]			Text (11), 
	[NumberLines]			Double, 
	[PONumber]			Text (11), 
	[PODate]			DateTime, 
	[Amount]			Double, 
	[FiscalRU]			Text (6), 
	[DeptID]			Text (16), 
	[A]			Text (1), 
	[Object]			Text (6), 
	[DateReceived]			DateTime, 
	[DatePaid]			DateTime, 
	[InvoiceNumber]			Text (30), 
	[Comments]			Memo/Hyperlink (255), 
	[CreatedBy]			Text (30), 
	[CreatedOn]			DateTime, 
	[UpdatedBy]			Text (30), 
	[UpdatedOn]			DateTime
);

CREATE TABLE [PriorYearsArchive]
 (
	[DocNumber]			Text (8), 
	[FiscalYear]			Text (9), 
	[DocDate]			DateTime, 
	[Vendor]			Text (30), 
	[VendorNumber]			Text (10), 
	[VendorAddrInd]			Text (1), 
	[Program]			Text (20), 
	[Description]			Text (30), 
	[ReqDate]			DateTime, 
	[ReqNumber]			Text (11), 
	[NumberLines]			Double, 
	[PONumber]			Text (11), 
	[PODate]			DateTime, 
	[Amount]			Double, 
	[FiscalRU]			Text (6), 
	[DeptID]			Text (16), 
	[A]			Text (1), 
	[Object]			Text (6), 
	[DateReceived]			DateTime, 
	[DatePaid]			DateTime, 
	[InvoiceNumber]			Text (30), 
	[Comments]			Memo/Hyperlink (255), 
	[CreatedBy]			Text (30), 
	[CreatedOn]			DateTime, 
	[UpdatedBy]			Text (30), 
	[UpdatedOn]			DateTime
);

CREATE TABLE [PriorYearsSAVE]
 (
	[DocNumber]			Text (8), 
	[FiscalYear]			Text (9), 
	[DocDate]			DateTime, 
	[Vendor]			Text (30), 
	[VendorNumber]			Text (10), 
	[VendorAddrInd]			Text (1), 
	[Program]			Text (20), 
	[Description]			Text (30), 
	[ReqDate]			DateTime, 
	[ReqNumber]			Text (11), 
	[NumberLines]			Double, 
	[PONumber]			Text (11), 
	[PODate]			DateTime, 
	[Amount]			Double, 
	[FiscalRU]			Text (6), 
	[A]			Text (1), 
	[Object]			Text (5), 
	[DateReceived]			DateTime, 
	[DatePaid]			DateTime, 
	[InvoiceNumber]			Text (30), 
	[Comments]			Memo/Hyperlink (255), 
	[CreatedBy]			Text (30), 
	[CreatedOn]			DateTime, 
	[UpdatedBy]			Text (30), 
	[UpdatedOn]			DateTime
);

CREATE TABLE [ReqList]
 (
	[DocNumber]			Text (8), 
	[DocDate]			DateTime, 
	[Vendor]			Text (30), 
	[VendorNumber]			Text (10), 
	[VendorAddrInd]			Text (1), 
	[Program]			Text (20), 
	[Description]			Text (30), 
	[DeptID]			Text (16), 
	[ReqDate]			DateTime, 
	[ReqNumber]			Text (11), 
	[NumberLines]			Double, 
	[PONumber]			Text (11), 
	[PODate]			DateTime, 
	[Amount]			Double, 
	[FiscalRU]			Text (6), 
	[A]			Text (1), 
	[Object]			Text (6), 
	[DateReceived]			DateTime, 
	[DatePaid]			DateTime, 
	[InvoiceNumber]			Text (30), 
	[Comments]			Memo/Hyperlink (255), 
	[CreatedBy]			Text (30), 
	[CreatedOn]			DateTime, 
	[UpdatedBy]			Text (30), 
	[UpdatedOn]			DateTime
);

CREATE TABLE [MSysCompactError]
 (
	[ErrorCode]			Long Integer, 
	[ErrorDescription]			Memo/Hyperlink (255), 
	[ErrorTable]			Text (255), 
	[ErrorRecid]			Binary
);

CREATE TABLE [POReg]
 (
	[PONumber]			Double, 
	[PODate]			DateTime, 
	[DEPT]			Double, 
	[ReqNumber]			Text (8), 
	[VendorName]			Text (30), 
	[VendorType]			Double, 
	[Description]			Text (25), 
	[Comments]			Memo/Hyperlink (255), 
	[CreatedBy]			Text (30), 
	[CreatedOn]			DateTime, 
	[UpdatedBy]			Text (30), 
	[UpdatedOn]			DateTime
);

CREATE TABLE [ProviderMaster]
 (
	[FiscalRU]			Text (6), 
	[Vendor Number]			Text (10), 
	[VendorAddrInd]			Text (1), 
	[ProgramName]			Text (20), 
	[CC]			Text (3), 
	[Name]			Text (45), 
	[DeptID]			Text (16), 
	[Inactive]			Text (1), 
	[InactiveDate]			DateTime, 
	[InactiveComment]			Memo/Hyperlink (255)
);

CREATE TABLE [Conversion Errors]
 (
	[Object Type]			Text (255), 
	[Object Name]			Text (255), 
	[Error Description]			Memo/Hyperlink (255)
);

CREATE TABLE [Conversion Errors1]
 (
	[Object Type]			Text (255), 
	[Object Name]			Text (255), 
	[Error Description]			Memo/Hyperlink (255)
);


