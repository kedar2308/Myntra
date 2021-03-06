INSERT INTO CATEGORY(CATEGORY_ID,CATEGORY_DESC,CATEGORY_NAME) VALUES('1','an item of clothing that covers at least the chest, but which usually covers most of the upper human body between the neck and the waistline.','Topwear');

INSERT INTO SUB_CATEGORY(SUB_CATEGORY_ID,SUB_CATEGORY_DESC,SUB_CATEGORY_NAME,CATEGORY_ID) VALUES('1','.a short-sleeved casual top, generally made of cotton, having the shape of a T when spread out flat.','T-Shirts','1');


INSERT INTO SUB_CATEGORY(SUB_CATEGORY_ID,SUB_CATEGORY_DESC,SUB_CATEGORY_NAME,CATEGORY_ID) VALUES('3','shirt with professional attire','Formal Shirt','1');


INSERT INTO CATEGORY(CATEGORY_ID,CATEGORY_DESC,CATEGORY_NAME) VALUES('2','like shorts and pants and stuff','Bottomwear');

INSERT INTO SUB_CATEGORY(SUB_CATEGORY_ID,SUB_CATEGORY_DESC,SUB_CATEGORY_NAME,CATEGORY_ID) VALUES('11','.nightwear.','trackpant','2');


INSERT INTO SUB_CATEGORY(SUB_CATEGORY_ID,SUB_CATEGORY_DESC,SUB_CATEGORY_NAME,CATEGORY_ID) VALUES('12','casual','shorts','2');

INSERT INTO BRAND(BRAND_ID,BRAND_DESC,BRAND_NAME) VALUES ('1','Sports Brand', 'Adidas');

INSERT INTO BRAND(BRAND_ID,BRAND_DESC,BRAND_NAME) VALUES ('2','Top Brand', 'H&M');

INSERT INTO CATALOG_INFO(CATALOG_INFO_ID, COLOR, DISCOUNT, GENDER, PRICE, SIZE,BRAND_ID, CATEGORY_ID, SUB_CATEGORY_ID) VALUES('1','red','30','male','400','30','1','1','1');

INSERT INTO CATALOG_INFO(CATALOG_INFO_ID, COLOR, DISCOUNT, GENDER, PRICE, SIZE,BRAND_ID, CATEGORY_ID, SUB_CATEGORY_ID) VALUES('2','green','32','female','800','32','1','1','3');

INSERT INTO CATALOG_INFO(CATALOG_INFO_ID, COLOR, DISCOUNT, GENDER, PRICE, SIZE,BRAND_ID, CATEGORY_ID, SUB_CATEGORY_ID) VALUES('3','red','32','male','2000','30','2','1','1');

INSERT INTO CATALOG_INFO(CATALOG_INFO_ID, COLOR, DISCOUNT, GENDER, PRICE, SIZE,BRAND_ID, CATEGORY_ID, SUB_CATEGORY_ID) VALUES('4','white','60','male','1200','28','2','2','11');

/*INSERT INTO CATALOG_INFO(CATALOG_INFO_ID, COLOR, DISCOUNT, GENDER, PRICE, SIZE,BRAND_ID, CATEGORY_ID, SUB_CATEGORY_ID) VALUES('5','red','60','male','1200','28','2','2','11');*/

INSERT INTO CATALOG(CATALOG_ID, COD_AVAILABILITY, CATALOG_DESCRIPTION, PRICE, STOCK , CATALOG_INFOID) VALUES('1','true','nice shirt','400','1000','1');

INSERT INTO CATALOG(CATALOG_ID, COD_AVAILABILITY, CATALOG_DESCRIPTION, PRICE, STOCK , CATALOG_INFOID) VALUES('2','true','cool shirt','800','800','2');

INSERT INTO CATALOG(CATALOG_ID, COD_AVAILABILITY, CATALOG_DESCRIPTION, PRICE, STOCK , CATALOG_INFOID) VALUES('3','true','cool pant','2000','10','3');

INSERT INTO CATALOG(CATALOG_ID, COD_AVAILABILITY, CATALOG_DESCRIPTION, PRICE, STOCK , CATALOG_INFOID) VALUES('4','false','nice pant','1200','1','4');

INSERT INTO CATALOG(CATALOG_ID, COD_AVAILABILITY, CATALOG_DESCRIPTION, PRICE, STOCK , CATALOG_INFOID) VALUES('5',false,'comfortable clothing','1200',900,null);