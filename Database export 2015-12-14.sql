--------------------------------------------------------
--  File created - Monday-December-14-2015   
--------------------------------------------------------
DROP TABLE "F57_SUSPEND";
DROP TABLE "F57_BORROWER";
DROP TABLE "F57_AUDIT_CASE";
DROP TABLE "F57_AUDIT";
DROP TABLE "F57_REF_INIT_TYPE";
DROP TABLE "F57_AGENCY";
DROP TABLE "F57_REF_CASE_CODE";

CREATE TABLE f57_agency
(
	tx_agency_code       CHAR(2) NOT NULL ,
	tx_name              VARCHAR2(25) NOT NULL ,
	tx_contact           VARCHAR2(25) NOT NULL ,
	tx_phone             CHAR(10) NULL ,
	nu_poc_digits        NUMBER(1) NULL ,
	nu_avg_loan          NUMBER(6,2) NULL ,
	nu_avg_bal           NUMBER(6,2) NULL ,
	nu_avg_loss          NUMBER(6,2) NULL ,
	tx_audit_tape        CHAR(1) NULL ,
	nu_users_loaded      NUMBER(6) NULL ,
	nu_ssns_loaded       NUMBER(7) NULL ,
	nu_tx_tip            NUMBER(7) NULL ,
	nu_tx_batch          NUMBER(7) NULL ,
	nu_tx_elect          NUMBER(7) NULL ,
	nu_tx_screen         NUMBER(7) NULL ,
	nu_hits              NUMBER(7) NULL ,
	nu_suppress_ctr      NUMBER(2) NULL ,
CONSTRAINT  pk_agency PRIMARY KEY (tx_agency_code)
);



CREATE TABLE f57_ref_case_code
(
	tx_case_code         CHAR(1) NOT NULL ,
	tx_description       VARCHAR2(20) NULL ,
CONSTRAINT  pk_ref_case_code PRIMARY KEY (tx_case_code)
);



CREATE TABLE f57_borrower
(
	tx_ssn               CHAR(9) NOT NULL ,
	tx_agency_code       CHAR(2) NOT NULL ,
	tx_case_no           VARCHAR2(9) NOT NULL ,
	tx_case_code         CHAR(1) NOT NULL ,
	tx_suspend_code      CHAR(1) DEFAULT  '0'  NOT NULL ,
	tx_ssn_taxid_ind     CHAR(1) NOT NULL ,
CONSTRAINT  pk_borrower PRIMARY KEY (tx_ssn,tx_ssn_taxid_ind,tx_case_no,tx_agency_code,tx_case_code),
CONSTRAINT fk_agency_borrower FOREIGN KEY (tx_agency_code) REFERENCES f57_agency (tx_agency_code),
CONSTRAINT fk_case_code_borrower FOREIGN KEY (tx_case_code) REFERENCES f57_ref_case_code (tx_case_code)
);



CREATE TABLE f57_suspend
(
	tx_ssn               CHAR(9) NOT NULL ,
	tx_case_no           VARCHAR2(9) NOT NULL ,
	tx_case_code         CHAR(1) NOT NULL ,
	tx_agency_code       CHAR(2) NOT NULL ,
	tx_ssn_taxid_ind     CHAR(1) NOT NULL ,
	dt_created           DATE NULL ,
	dt_expire            DATE NULL ,
	tx_user_id           CHAR(3) NULL ,
	tx_caller_phone      CHAR(10) NULL ,
	nu_reason_code       NUMBER(1) NULL ,
	nu_repay_code        NUMBER(1) NULL ,
	nu_repay_amount      NUMBER(6,2) NULL ,
	tx_web_id            CHAR(6) NULL ,
CONSTRAINT  pk_suspend PRIMARY KEY (tx_ssn,tx_case_no,tx_agency_code,tx_ssn_taxid_ind,tx_case_code),
CONSTRAINT fk_borrower_suspend FOREIGN KEY (tx_ssn, tx_ssn_taxid_ind, tx_case_no, tx_agency_code, tx_case_code) REFERENCES f57_borrower (tx_ssn, tx_ssn_taxid_ind, tx_case_no, tx_agency_code, tx_case_code),
CONSTRAINT fk_agency_suspend FOREIGN KEY (tx_agency_code) REFERENCES f57_agency (tx_agency_code),
CONSTRAINT fk_case_code_suspend FOREIGN KEY (tx_case_code) REFERENCES f57_ref_case_code (tx_case_code)
);



CREATE TABLE f57_ref_init_type
(
	tx_init_type         CHAR(1) NOT NULL ,
	tx_description       VARCHAR2(20) NULL ,
CONSTRAINT  pk_ref_init_type PRIMARY KEY (tx_init_type)
);



CREATE TABLE f57_audit
(
	tx_access_code       CHAR(10) NULL ,
	tx_lender_id         CHAR(10) NULL ,
	tx_process_type      CHAR(2) NOT NULL ,
	tx_init_type         CHAR(1) NOT NULL ,
	dt_created           TIMESTAMP NULL ,
	tx_julian_day        CHAR(3) NOT NULL ,
	tx_ssn               CHAR(9) NULL ,
	tx_ssn_taxid_ind     CHAR(1) NULL ,
	tx_seqno             CHAR(6) NOT NULL ,
	tx_audit_result      CHAR(1) NOT NULL ,
CONSTRAINT  pk_audit PRIMARY KEY (tx_audit_result,tx_julian_day,tx_seqno),
CONSTRAINT fk_agency_audit FOREIGN KEY (tx_process_type) REFERENCES f57_agency (tx_agency_code),
CONSTRAINT fk_case_code_audit FOREIGN KEY (tx_audit_result) REFERENCES f57_ref_case_code (tx_case_code),
CONSTRAINT fk_init_type_audit FOREIGN KEY (tx_init_type) REFERENCES f57_ref_init_type (tx_init_type)
);



CREATE TABLE f57_audit_case
(
	tx_case_no           VARCHAR2(9) NOT NULL ,
	tx_agency_code       CHAR(2) NOT NULL ,
	tx_audit_result      CHAR(1) NOT NULL ,
	tx_case_code         CHAR(1) NOT NULL ,
	tx_julian_day        CHAR(3) NOT NULL ,
	tx_seqno             CHAR(6) NOT NULL ,
CONSTRAINT  pk_audit_case PRIMARY KEY (tx_audit_result,tx_julian_day,tx_seqno,tx_case_no),
CONSTRAINT fk_agency_audit_case FOREIGN KEY (tx_agency_code) REFERENCES f57_agency (tx_agency_code),
CONSTRAINT fk_audit_audit_case FOREIGN KEY (tx_audit_result, tx_julian_day, tx_seqno) REFERENCES f57_audit (tx_audit_result, tx_julian_day, tx_seqno),
CONSTRAINT fk_case_code_audit_case FOREIGN KEY (tx_case_code) REFERENCES f57_ref_case_code (tx_case_code)
);


REM INSERTING into F57_AGENCY
SET DEFINE OFF;
Insert into F57_AGENCY (TX_AGENCY_CODE,TX_NAME,TX_CONTACT,TX_PHONE,NU_POC_DIGITS,NU_AVG_LOAN,NU_AVG_BAL,NU_AVG_LOSS,TX_AUDIT_TAPE,NU_USERS_LOADED,NU_SSNS_LOADED,NU_TX_TIP,NU_TX_BATCH,NU_TX_ELECT,NU_TX_SCREEN,NU_HITS,NU_SUPPRESS_CTR) values ('01','FHA TITLE I','MIKE DEMARCO  EXT. 4259','8006695152',null,null,null,null,null,null,null,null,null,null,null,null,null);
Insert into F57_AGENCY (TX_AGENCY_CODE,TX_NAME,TX_CONTACT,TX_PHONE,NU_POC_DIGITS,NU_AVG_LOAN,NU_AVG_BAL,NU_AVG_LOSS,TX_AUDIT_TAPE,NU_USERS_LOADED,NU_SSNS_LOADED,NU_TX_TIP,NU_TX_BATCH,NU_TX_ELECT,NU_TX_SCREEN,NU_HITS,NU_SUPPRESS_CTR) values ('02','FHA SINGLE FAMILY','JOANNE KUCZMA EXT 2137','8002255342',null,null,null,null,null,null,null,null,null,null,null,null,null);
Insert into F57_AGENCY (TX_AGENCY_CODE,TX_NAME,TX_CONTACT,TX_PHONE,NU_POC_DIGITS,NU_AVG_LOAN,NU_AVG_BAL,NU_AVG_LOSS,TX_AUDIT_TAPE,NU_USERS_LOADED,NU_SSNS_LOADED,NU_TX_TIP,NU_TX_BATCH,NU_TX_ELECT,NU_TX_SCREEN,NU_HITS,NU_SUPPRESS_CTR) values ('03','HUD 312 REHABILITATION','WILLIAM RUDY EXT.4635','2027080614',null,null,null,null,null,null,null,null,null,null,null,null,null);
Insert into F57_AGENCY (TX_AGENCY_CODE,TX_NAME,TX_CONTACT,TX_PHONE,NU_POC_DIGITS,NU_AVG_LOAN,NU_AVG_BAL,NU_AVG_LOSS,TX_AUDIT_TAPE,NU_USERS_LOADED,NU_SSNS_LOADED,NU_TX_TIP,NU_TX_BATCH,NU_TX_ELECT,NU_TX_SCREEN,NU_HITS,NU_SUPPRESS_CTR) values ('04','DEPT OF VETERAN''S AFFAIRS','WILLIAM WHITE','8008270648',null,null,null,null,null,null,null,null,null,null,null,null,null);
Insert into F57_AGENCY (TX_AGENCY_CODE,TX_NAME,TX_CONTACT,TX_PHONE,NU_POC_DIGITS,NU_AVG_LOAN,NU_AVG_BAL,NU_AVG_LOSS,TX_AUDIT_TAPE,NU_USERS_LOADED,NU_SSNS_LOADED,NU_TX_TIP,NU_TX_BATCH,NU_TX_ELECT,NU_TX_SCREEN,NU_HITS,NU_SUPPRESS_CTR) values ('05','USDA - RURAL DEVELOPMENT','ESTHER MCQUAID','3145396217',null,null,null,null,null,null,null,null,null,null,null,null,null);
Insert into F57_AGENCY (TX_AGENCY_CODE,TX_NAME,TX_CONTACT,TX_PHONE,NU_POC_DIGITS,NU_AVG_LOAN,NU_AVG_BAL,NU_AVG_LOSS,TX_AUDIT_TAPE,NU_USERS_LOADED,NU_SSNS_LOADED,NU_TX_TIP,NU_TX_BATCH,NU_TX_ELECT,NU_TX_SCREEN,NU_HITS,NU_SUPPRESS_CTR) values ('06','USDA - FARM SERVICES','KAREN JOHNISEE','3145396217',null,null,null,null,null,null,null,null,null,null,null,null,null);
Insert into F57_AGENCY (TX_AGENCY_CODE,TX_NAME,TX_CONTACT,TX_PHONE,NU_POC_DIGITS,NU_AVG_LOAN,NU_AVG_BAL,NU_AVG_LOSS,TX_AUDIT_TAPE,NU_USERS_LOADED,NU_SSNS_LOADED,NU_TX_TIP,NU_TX_BATCH,NU_TX_ELECT,NU_TX_SCREEN,NU_HITS,NU_SUPPRESS_CTR) values ('07','DEPT OF ED. - GUARANTEED','KATHY GRIFFIN','2027088471',null,null,null,null,null,null,null,null,null,null,null,null,null);
Insert into F57_AGENCY (TX_AGENCY_CODE,TX_NAME,TX_CONTACT,TX_PHONE,NU_POC_DIGITS,NU_AVG_LOAN,NU_AVG_BAL,NU_AVG_LOSS,TX_AUDIT_TAPE,NU_USERS_LOADED,NU_SSNS_LOADED,NU_TX_TIP,NU_TX_BATCH,NU_TX_ELECT,NU_TX_SCREEN,NU_HITS,NU_SUPPRESS_CTR) values ('08','DEPT OF ED. - TYPE B','TO BE ANNOUNCED','2027084766',null,null,null,null,null,null,null,null,null,null,null,null,null);
Insert into F57_AGENCY (TX_AGENCY_CODE,TX_NAME,TX_CONTACT,TX_PHONE,NU_POC_DIGITS,NU_AVG_LOAN,NU_AVG_BAL,NU_AVG_LOSS,TX_AUDIT_TAPE,NU_USERS_LOADED,NU_SSNS_LOADED,NU_TX_TIP,NU_TX_BATCH,NU_TX_ELECT,NU_TX_SCREEN,NU_HITS,NU_SUPPRESS_CTR) values ('09','SMALL BUSINESS ADMIN.','WALTER INTLEKOFER','2022057541',null,null,null,null,null,null,null,null,null,null,null,null,null);
Insert into F57_AGENCY (TX_AGENCY_CODE,TX_NAME,TX_CONTACT,TX_PHONE,NU_POC_DIGITS,NU_AVG_LOAN,NU_AVG_BAL,NU_AVG_LOSS,TX_AUDIT_TAPE,NU_USERS_LOADED,NU_SSNS_LOADED,NU_TX_TIP,NU_TX_BATCH,NU_TX_ELECT,NU_TX_SCREEN,NU_HITS,NU_SUPPRESS_CTR) values ('10','DEPT OF JUSTICE - JMD','DIANNE WATSON    EXT. 101','3015852391',null,null,null,null,null,null,null,null,null,null,null,null,null);
Insert into F57_AGENCY (TX_AGENCY_CODE,TX_NAME,TX_CONTACT,TX_PHONE,NU_POC_DIGITS,NU_AVG_LOAN,NU_AVG_BAL,NU_AVG_LOSS,TX_AUDIT_TAPE,NU_USERS_LOADED,NU_SSNS_LOADED,NU_TX_TIP,NU_TX_BATCH,NU_TX_ELECT,NU_TX_SCREEN,NU_HITS,NU_SUPPRESS_CTR) values ('11','FDIC','TEST PHASE 2','2029423885',null,null,null,null,null,null,null,null,null,null,null,null,null);
Insert into F57_AGENCY (TX_AGENCY_CODE,TX_NAME,TX_CONTACT,TX_PHONE,NU_POC_DIGITS,NU_AVG_LOAN,NU_AVG_BAL,NU_AVG_LOSS,TX_AUDIT_TAPE,NU_USERS_LOADED,NU_SSNS_LOADED,NU_TX_TIP,NU_TX_BATCH,NU_TX_ELECT,NU_TX_SCREEN,NU_HITS,NU_SUPPRESS_CTR) values ('12','DEPT OF JUSTICE - EOUSA','DARRELL CURTIS','8019649308',null,null,null,null,null,null,null,null,null,null,null,null,null);
Insert into F57_AGENCY (TX_AGENCY_CODE,TX_NAME,TX_CONTACT,TX_PHONE,NU_POC_DIGITS,NU_AVG_LOAN,NU_AVG_BAL,NU_AVG_LOSS,TX_AUDIT_TAPE,NU_USERS_LOADED,NU_SSNS_LOADED,NU_TX_TIP,NU_TX_BATCH,NU_TX_ELECT,NU_TX_SCREEN,NU_HITS,NU_SUPPRESS_CTR) values ('13','HUD GENERIC DEBT','JAY MENTES','8006695152',null,null,null,null,null,null,null,null,null,null,null,null,null);
Insert into F57_AGENCY (TX_AGENCY_CODE,TX_NAME,TX_CONTACT,TX_PHONE,NU_POC_DIGITS,NU_AVG_LOAN,NU_AVG_BAL,NU_AVG_LOSS,TX_AUDIT_TAPE,NU_USERS_LOADED,NU_SSNS_LOADED,NU_TX_TIP,NU_TX_BATCH,NU_TX_ELECT,NU_TX_SCREEN,NU_HITS,NU_SUPPRESS_CTR) values ('14','SYSTEM TEST','JOHNNY E. LEE  EXT 7158','7032701540',null,null,null,null,null,null,null,null,null,null,null,null,null);
Insert into F57_AGENCY (TX_AGENCY_CODE,TX_NAME,TX_CONTACT,TX_PHONE,NU_POC_DIGITS,NU_AVG_LOAN,NU_AVG_BAL,NU_AVG_LOSS,TX_AUDIT_TAPE,NU_USERS_LOADED,NU_SSNS_LOADED,NU_TX_TIP,NU_TX_BATCH,NU_TX_ELECT,NU_TX_SCREEN,NU_HITS,NU_SUPPRESS_CTR) values ('15','USDA - RURAL DEV. DEBT','ESTHER MCQUAID','3144574310',null,null,null,null,null,null,null,null,null,null,null,null,null);
Insert into F57_AGENCY (TX_AGENCY_CODE,TX_NAME,TX_CONTACT,TX_PHONE,NU_POC_DIGITS,NU_AVG_LOAN,NU_AVG_BAL,NU_AVG_LOSS,TX_AUDIT_TAPE,NU_USERS_LOADED,NU_SSNS_LOADED,NU_TX_TIP,NU_TX_BATCH,NU_TX_ELECT,NU_TX_SCREEN,NU_HITS,NU_SUPPRESS_CTR) values ('16','USDA GUAR. RH LOSS CLAIM','ESTHER MCQUAID','8665505887',null,null,null,null,null,null,null,null,null,null,null,null,null);
Insert into F57_AGENCY (TX_AGENCY_CODE,TX_NAME,TX_CONTACT,TX_PHONE,NU_POC_DIGITS,NU_AVG_LOAN,NU_AVG_BAL,NU_AVG_LOSS,TX_AUDIT_TAPE,NU_USERS_LOADED,NU_SSNS_LOADED,NU_TX_TIP,NU_TX_BATCH,NU_TX_ELECT,NU_TX_SCREEN,NU_HITS,NU_SUPPRESS_CTR) values ('17','CHUMS','ELLEN DEPEW','7035060088',null,null,null,null,null,null,null,null,null,null,null,null,null);
Insert into F57_AGENCY (TX_AGENCY_CODE,TX_NAME,TX_CONTACT,TX_PHONE,NU_POC_DIGITS,NU_AVG_LOAN,NU_AVG_BAL,NU_AVG_LOSS,TX_AUDIT_TAPE,NU_USERS_LOADED,NU_SSNS_LOADED,NU_TX_TIP,NU_TX_BATCH,NU_TX_ELECT,NU_TX_SCREEN,NU_HITS,NU_SUPPRESS_CTR) values ('18','HUD NATIVE AMERICAN PRGMS','DEANNA LUCERO  EXT 1615','8005615913',null,null,null,null,null,null,null,null,null,null,null,null,null);
Insert into F57_AGENCY (TX_AGENCY_CODE,TX_NAME,TX_CONTACT,TX_PHONE,NU_POC_DIGITS,NU_AVG_LOAN,NU_AVG_BAL,NU_AVG_LOSS,TX_AUDIT_TAPE,NU_USERS_LOADED,NU_SSNS_LOADED,NU_TX_TIP,NU_TX_BATCH,NU_TX_ELECT,NU_TX_SCREEN,NU_HITS,NU_SUPPRESS_CTR) values ('20','TREASURY CONTRACTOR SCRNG','PAT ERVIN','2029423896',null,null,null,null,null,null,null,null,null,null,null,null,null);
Insert into F57_AGENCY (TX_AGENCY_CODE,TX_NAME,TX_CONTACT,TX_PHONE,NU_POC_DIGITS,NU_AVG_LOAN,NU_AVG_BAL,NU_AVG_LOSS,TX_AUDIT_TAPE,NU_USERS_LOADED,NU_SSNS_LOADED,NU_TX_TIP,NU_TX_BATCH,NU_TX_ELECT,NU_TX_SCREEN,NU_HITS,NU_SUPPRESS_CTR) values ('21','HUD GOOD NEIGHBOR OND/TND','JAMES C. EVERETT  EXT','2027080614',null,null,null,null,null,null,null,null,null,null,null,null,null);
Insert into F57_AGENCY (TX_AGENCY_CODE,TX_NAME,TX_CONTACT,TX_PHONE,NU_POC_DIGITS,NU_AVG_LOAN,NU_AVG_BAL,NU_AVG_LOSS,TX_AUDIT_TAPE,NU_USERS_LOADED,NU_SSNS_LOADED,NU_TX_TIP,NU_TX_BATCH,NU_TX_ELECT,NU_TX_SCREEN,NU_HITS,NU_SUPPRESS_CTR) values ('22','FHA SF SUBORDINATE MTGES','MICHAEL REYES','4055537475',null,null,null,null,null,null,null,null,null,null,null,null,null);
Insert into F57_AGENCY (TX_AGENCY_CODE,TX_NAME,TX_CONTACT,TX_PHONE,NU_POC_DIGITS,NU_AVG_LOAN,NU_AVG_BAL,NU_AVG_LOSS,TX_AUDIT_TAPE,NU_USERS_LOADED,NU_SSNS_LOADED,NU_TX_TIP,NU_TX_BATCH,NU_TX_ELECT,NU_TX_SCREEN,NU_HITS,NU_SUPPRESS_CTR) values ('23','TREASURY DEBT CHECK','AL ESPINOSA','2027080614',null,null,null,null,null,null,null,null,null,null,null,null,null);
Insert into F57_AGENCY (TX_AGENCY_CODE,TX_NAME,TX_CONTACT,TX_PHONE,NU_POC_DIGITS,NU_AVG_LOAN,NU_AVG_BAL,NU_AVG_LOSS,TX_AUDIT_TAPE,NU_USERS_LOADED,NU_SSNS_LOADED,NU_TX_TIP,NU_TX_BATCH,NU_TX_ELECT,NU_TX_SCREEN,NU_HITS,NU_SUPPRESS_CTR) values ('24','HUD CFO','MICHAEL SIMMONS','2024023738',null,null,null,null,null,null,null,null,null,null,null,null,null);
Insert into F57_AGENCY (TX_AGENCY_CODE,TX_NAME,TX_CONTACT,TX_PHONE,NU_POC_DIGITS,NU_AVG_LOAN,NU_AVG_BAL,NU_AVG_LOSS,TX_AUDIT_TAPE,NU_USERS_LOADED,NU_SSNS_LOADED,NU_TX_TIP,NU_TX_BATCH,NU_TX_ELECT,NU_TX_SCREEN,NU_HITS,NU_SUPPRESS_CTR) values ('25','ELHP','BEN WINTER','2024026137',null,null,null,null,null,null,null,null,null,null,null,null,null);
Insert into F57_AGENCY (TX_AGENCY_CODE,TX_NAME,TX_CONTACT,TX_PHONE,NU_POC_DIGITS,NU_AVG_LOAN,NU_AVG_BAL,NU_AVG_LOSS,TX_AUDIT_TAPE,NU_USERS_LOADED,NU_SSNS_LOADED,NU_TX_TIP,NU_TX_BATCH,NU_TX_ELECT,NU_TX_SCREEN,NU_HITS,NU_SUPPRESS_CTR) values ('30','TEST AGENCY','TIM KAGARISE','5408097103',null,null,null,null,null,null,null,null,null,null,null,null,null);

REM INSERTING into F57_REF_CASE_CODE
SET DEFINE OFF;
Insert into F57_REF_CASE_CODE (TX_CASE_CODE,TX_DESCRIPTION) values ('C','CLAIM');
Insert into F57_REF_CASE_CODE (TX_CASE_CODE,TX_DESCRIPTION) values ('D','DEFAULT');
Insert into F57_REF_CASE_CODE (TX_CASE_CODE,TX_DESCRIPTION) values ('F','FORECLOSURE');
Insert into F57_REF_CASE_CODE (TX_CASE_CODE,TX_DESCRIPTION) values ('J','JUDGEMENT');
Insert into F57_REF_CASE_CODE (TX_CASE_CODE,TX_DESCRIPTION) values ('A','NO-PROBLEM');
Insert into F57_REF_CASE_CODE (TX_CASE_CODE,TX_DESCRIPTION) values ('B','MULTIPLE');

REM INSERTING into F57_REF_INIT_TYPE
SET DEFINE OFF;
Insert into F57_REF_INIT_TYPE (TX_INIT_TYPE,TX_DESCRIPTION) values ('B','BATCH');
Insert into F57_REF_INIT_TYPE (TX_INIT_TYPE,TX_DESCRIPTION) values ('T','TIP');
Insert into F57_REF_INIT_TYPE (TX_INIT_TYPE,TX_DESCRIPTION) values ('E','ELECTRONIC');
Insert into F57_REF_INIT_TYPE (TX_INIT_TYPE,TX_DESCRIPTION) values ('C','CHUMS');

REM INSERTING into F57_BORROWER
SET DEFINE OFF;
Insert into F57_BORROWER (TX_SSN,TX_AGENCY_CODE,TX_CASE_NO,TX_CASE_CODE,TX_SUSPEND_CODE,TX_SSN_TAXID_IND) values ('444444444','02','011522222','C','0','S');
Insert into F57_BORROWER (TX_SSN,TX_AGENCY_CODE,TX_CASE_NO,TX_CASE_CODE,TX_SUSPEND_CODE,TX_SSN_TAXID_IND) values ('222222222','02','105555555','D','0','S');
Insert into F57_BORROWER (TX_SSN,TX_AGENCY_CODE,TX_CASE_NO,TX_CASE_CODE,TX_SUSPEND_CODE,TX_SSN_TAXID_IND) values ('111111111','07','040000000','D','0','S');
Insert into F57_BORROWER (TX_SSN,TX_AGENCY_CODE,TX_CASE_NO,TX_CASE_CODE,TX_SUSPEND_CODE,TX_SSN_TAXID_IND) values ('333333333','09','016000001','D','0','T');
Insert into F57_BORROWER (TX_SSN,TX_AGENCY_CODE,TX_CASE_NO,TX_CASE_CODE,TX_SUSPEND_CODE,TX_SSN_TAXID_IND) values ('333333333','09','016000002','D','0','T');

COMMIT;
