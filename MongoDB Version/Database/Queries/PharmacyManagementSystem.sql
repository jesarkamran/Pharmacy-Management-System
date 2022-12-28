CREATE TABLE person(
    ssn int PRIMARY KEY,
    bdate date NOT NULL,
    email varchar(255),
    user_password varchar(255),
    phone VARCHAR(255),
    sex varchar(255),
    personType varchar(255)
);

CREATE TABLE name(
    ssn int PRIMARY KEY REFERENCES PERSON(ssn),
    fname varchar(255) NOT NULL,
    mname varchar(255),
    lname varchar(255)
);

CREATE TABLE address(
    ssn int PRIMARY KEY REFERENCES PERSON(ssn),
    street varchar(255),
    state varchar(255),
    zip int
);


CREATE TABLE employee(
    emp_id int PRIMARY KEY REFERENCES PERSON(ssn),
    rank varchar(255) NOT NULL,
    hiredate date NOT NULL,
    salary int NOT NULL
);

CREATE TABLE supplier_drug_details(
    supplier_drug_details_id int PRIMARY KEY,
    drug_id int NOT NULL,
    drug_name VARCHAR(255) NOT NULL,
    drug_expiryDate DATE NOT NULL,
    drug_ManufacterDate DATE NOT NULL,
    drug_manufactered_price int NOT NULL,
    drug_b2b_price int NOT NULL,
    drug_b2c_price int NOT NULL,
    drug_manufacterer_company_id int NOT NULL,
    drug_manufacterer_company_name varchar(255) NOT NULL
);

CREATE TABLE seller_drug_details(
    seller_drug_details_id int PRIMARY KEY,
    drug_id int NOT NULL,
    drug_name VARCHAR(255) NOT NULL,
    drug_expiryDate DATE NOT NULL,
    drug_ManufacterDate DATE NOT NULL,
    drug_manufactered_price int NOT NULL,
    drug_b2b_price int NOT NULL,
    drug_b2c_price int NOT NULL,
    drug_manufacterer_company_id int NOT NULL,
    drug_manufacterer_company_name varchar(255) NOT NULL
);

CREATE TABLE distributor_drug_details(
    distributor_drug_details_id int PRIMARY KEY,
    drug_id int NOT NULL,
    drug_name VARCHAR(255) NOT NULL,
    drug_expiryDate DATE NOT NULL,
    drug_ManufacterDate DATE NOT NULL,
    drug_manufactered_price int NOT NULL,
    drug_b2b_price int NOT NULL,
    drug_b2c_price int NOT NULL,
    drug_manufacterer_company_id int NOT NULL,
    drug_manufacterer_company_name varchar(255) NOT NULL
);

CREATE TABLE doctor_drug_details(
    doctor_drug_details_id int PRIMARY KEY,
    drug_id int NOT NULL,
    drug_name VARCHAR(255) NOT NULL,
    drug_expiryDate DATE NOT NULL,
    drug_ManufacterDate DATE NOT NULL,
    drug_price int NOT NULL,
    drug_manufacterer_company_name varchar(255) NOT NULL
);

CREATE TABLE customer_drug_details(
    customer_drug_details_id int PRIMARY KEY,
    drug_name VARCHAR(255) NOT NULL,
    drug_expiryDate DATE NOT NULL,
    drug_ManufacterDate DATE NOT NULL,
    drug_bought_price int NOT NULL,
    drug_manufacterer_company_name varchar(255) NOT NULL
);

CREATE TABLE company_drug_details(
    company_drug_details_id int PRIMARY KEY,
    drug_id int NOT NULL,
    drug_name VARCHAR(255) NOT NULL,
    drug_expiryDate DATE NOT NULL,
    drug_ManufacterDate DATE NOT NULL,
    drug_manufactered_price int NOT NULL,
    drug_b2b_price int NOT NULL,
    drug_b2c_price int NOT NULL,
    drug_sell_to_person_id int NOT NULL
);

CREATE TABLE drug(
    drug_id int PRIMARY KEY,
    drug_name varchar(255) NOT NULL
);

CREATE TABLE drug_dates(
    drug_id int PRIMARY KEY REFERENCES drug(drug_id),
    manufactered_date date NOT NULL,
    expiry_date date NOT NULL
);

CREATE TABLE drug_manufacter_details(
    drug_id int PRIMARY KEY REFERENCES drug(drug_id),
    manufacterer_company_id varchar(255) NOT NULL,
    manufacterer_company_name varchar(255) NOT NULL
);

CREATE TABLE drug_price(
    drug_id int PRIMARY KEY REFERENCES drug(drug_id),
    drug_manufactered_price int NOT NULL,
    drug_b2b_price int NOT NULL,
    drug_b2c_price int NOT NULL
);

CREATE TABLE company(
    company_id int PRIMARY KEY,
    company_name VARCHAR(255) NOT NULL,
    company_drug_id int REFERENCES drug(drug_id)
);

CREATE TABLE company_contacter(
    company_contacter_id int PRIMARY KEY,
    years_of_experience int NOT NULL,
    years_of_education int NOT NULL,
    company_id int REFERENCES company(company_id)
);

CREATE TABLE supplier(
    supplier_id int PRIMARY KEY REFERENCES Employee(emp_id),
    total_deals int NOT NULL,
    pending_deals int NOT NULL,
    supplier_drugs int REFERENCES supplier_drug_details(supplier_drug_details_id) NOT NULL
);

CREATE TABLE company_sells_to_supplier(
    supplier_id int REFERENCES supplier(supplier_id),
    company_id int REFERENCES company(company_id),
    PRIMARY KEY(supplier_id, company_id)
);

CREATE TABLE supplier_buys_from_company(
    supplier_id int REFERENCES supplier(supplier_id),
    company_id int REFERENCES company(company_id),
    PRIMARY KEY(supplier_id, company_id)
);

CREATE TABLE seller(
    seller_id int PRIMARY KEY REFERENCES Employee(emp_id),
    sales_per_day int NOT NULL,
    total_sales int NOT NULL,
    commision int NOT NULL,
    seller_drugs int REFERENCES seller_drug_details(seller_drug_details_id) NOT NULL
);

CREATE TABLE supplier_sells_to_seller(
    supplier_id int REFERENCES supplier(supplier_id),
    seller_id int REFERENCES seller(seller_id),
    PRIMARY KEY(supplier_id, seller_id)
);

CREATE TABLE seller_buys_from_supplier(
    supplier_id int REFERENCES supplier(supplier_id),
    seller_id int REFERENCES seller(seller_id),
    PRIMARY KEY(supplier_id, seller_id)
);

CREATE TABLE customer(
    cust_id int PRIMARY KEY REFERENCES PERSON(ssn),
    visited_date date NOT NULL,
    customer_drugs int REFERENCES customer_drug_details(customer_drug_details_id) NOT NULL
);

CREATE TABLE customer_buys_from_seller(
    cust_id int REFERENCES customer(cust_id),
    seller_id int REFERENCES seller(seller_id),
    PRIMARY KEY(cust_id, seller_id)
);

CREATE TABLE seller_sells_to_customer(
    cust_id int REFERENCES customer(cust_id),
    seller_id int REFERENCES seller(seller_id),
    PRIMARY KEY(cust_id, seller_id)
);

CREATE TABLE distributor(
    distributor_id int PRIMARY KEY REFERENCES PERSON(ssn),
    works_with_coperate varchar(255) NOT NULL,
     years_of_experience int NOT NULL,
    years_of_education int NOT NULL,
    distributor_drugs int REFERENCES distributor_drug_details(distributor_drug_details_id) NOT NULL
);

CREATE TABLE distributor_buys_from_supplier(
    supplier_id int REFERENCES supplier(supplier_id),
    distributor_id int REFERENCES distributor(distributor_id),
    PRIMARY KEY(supplier_id, distributor_id)
);  


CREATE TABLE supplier_sells_to_distributor(
    supplier_id int REFERENCES supplier(supplier_id),
    distributor_id int REFERENCES distributor(distributor_id),
    PRIMARY KEY(supplier_id, distributor_id)
);


CREATE TABLE doctor(
    doctor_id int PRIMARY KEY REFERENCES PERSON(ssn),
    specialization_field varchar(255) NOT NULL,
    year_of_experience int NOT NULL,
    doctor_drugs int REFERENCES doctor_drug_details(doctor_drug_details_id) NOT NULL
);

CREATE TABLE doctor_buys_from_distributor(
    doctor_id int REFERENCES doctor(doctor_id),
    distributor_id int REFERENCES distributor(distributor_id),
    PRIMARY KEY(doctor_id, distributor_id)
);  

CREATE TABLE distributor_sells_to_doctor(
    doctor_id int REFERENCES doctor(doctor_id),
    distributor_id int REFERENCES distributor(distributor_id),
    PRIMARY KEY(doctor_id, distributor_id)
);

CREATE TABLE doctor_buys_from_seller(
    doctor_id int REFERENCES doctor(doctor_id),
    seller_id int REFERENCES seller(seller_id),
    PRIMARY KEY(doctor_id, seller_id)
);

CREATE TABLE seller_sells_to_doctor(
    doctor_id int REFERENCES doctor(doctor_id),
    seller_id int REFERENCES seller(seller_id),
    PRIMARY KEY(doctor_id, seller_id)
);