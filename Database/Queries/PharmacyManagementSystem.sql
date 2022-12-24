CREATE TABLE person(
    ssn int PRIMARY KEY,
    bdate date NOT NULL,
    email varchar(255),
    phone VARCHAR(255),
    sex varchar(10)
);

CREATE TABLE name(
    ssn int PRIMARY KEY REFERENCES PERSON(ssn),
    fname varchar(255) NOT NULL,
    mname varchar(255),
    lname varchar(255)
);

CREATE TABLE address(
    ssn int PRIMARY KEY REFERENCES PERSON(ssn),
    "NO" int,
    street varchar(255),
    apt_no int,
    city varchar(255),
    state varchar(255),
    zip int
);

CREATE TABLE employee(
    emp_id int PRIMARY KEY REFERENCES PERSON(ssn),
    rank varchar(255) NOT NULL,
    foffice varchar(255),
    hiredate date NOT NULL,
    salary int NOT NULL
);

CREATE TABLE stock(
    stock_id int PRIMARY KEY,
    stock_items_qunatity int NOT NULL,
    items_to_be_delivered int NOT NULL,
    most_sale_item int NOT NULL
);

CREATE TABLE item_details(
    item_details_id int PRIMARY KEY,
    manufactered_date date NOT NULL,
    expiry_date date NOT NULL
);

CREATE TABLE manufactorer_details(
    manufactorer_details_id int PRIMARY KEY,
    manufacterer_company_id varchar(255) NOT NULL,
    manufacterer_company_name varchar(255) NOT NULL
);

CREATE TABLE price_details(
    price_details_id int PRIMARY KEY,
    manufactered_price int NOT NULL,
    b2b_price int NOT NULL,
    b2c_price int NOT NULL
);

CREATE TABLE drug(
    drug_id int PRIMARY KEY,
    drug_price int REFERENCES PRICE_DETAILS(price_details_id) NOT NULL,
    item_details int REFERENCES item_details(item_details_id) NOT NULL,
    manufactorer_details int REFERENCES manufactorer_details(manufactorer_details_id) NOT NULL
);


CREATE TABLE supplier(
    supplier_id int PRIMARY KEY REFERENCES Employee(emp_id),
    supplier_status varchar(255) NOT NULL,
    total_deals int NOT NULL,
    pending_deals int NOT NULL,
    checks int REFERENCES Stock(stock_id),
    drug_availability_id int REFERENCES drug(drug_id) NOT NULL
);


CREATE TABLE sales_details(
    sales_details_id int PRIMARY KEY,
    profit_earned int NOT NULL,
    seller_name VARCHAR(255) NOT NULL,
    drug_name VARCHAR(255) NOT NULL,
    drug_qunatity int NOT NULL
);

CREATE TABLE seller(
    seller_id int PRIMARY KEY REFERENCES Employee(emp_id),
    sales_per_day int NOT NULL,
    total_sales int NOT NULL,
    commision int NOT NULL,
    drug_account_id int REFERENCES Drug(drug_id) NOT NULL,
    sales int REFERENCES sales_details(sales_details_id) NOT NULL
);

CREATE TABLE order_details(
    order_details_id int PRIMARY KEY,
    quantity int NOT NULL,
    purchase_date DATE NOT NULL,
    drug_type VARCHAR(255) NOT NULL,
    order_bill int NOT NULL
);

CREATE TABLE customer(
    cust_id int PRIMARY KEY REFERENCES PERSON(ssn),
    rank varchar(255) NOT NULL,
    visited_date date NOT NULL,
    number_of_visits int NOT NULL
);

CREATE TABLE customer_order(
    customer_order int PRIMARY KEY,
    cust_id int REFERENCES customer(cust_id) NOT NULL,
    order_details_id int REFERENCES order_details(order_details_id) NOT NULL,
    drug_id int REFERENCES drug(drug_id) NOT NULL
);

CREATE TABLE qa(
    qa_id int PRIMARY KEY,
    drug_reviewed_id int NOT NULL,
    qa_reviews VARCHAR(255) NOT NULL
);

CREATE TABLE drug_manager(
    drug_manager_id int PRIMARY KEY,
    drug_managed_id int NOT NULL,
    drug_passed_review VARCHAR(20) NOT NULL
);

CREATE TABLE company(
    company_id int PRIMARY KEY,
    qa_company int REFERENCES qa(qa_id) NOT NULL,
    drug_manager_company int REFERENCES drug_manager(drug_manager_id) NOT NULL
);

CREATE TABLE distributor(
    distributor_id int PRIMARY KEY REFERENCES PERSON(ssn),
    works_with_coperate varchar(20) NOT NULL,
    reputation varchar(20) NOT NULL,
    demand_quantity int NOT NULL,
    drug_demand_ids varchar(20) NOT NULL,
    deal_company int REFERENCES company(company_id) NOT NULL,
    deal_supplier int REFERENCES supplier(supplier_id) NOT NULL
);

CREATE TABLE doctor(
    doctor_id int PRIMARY KEY REFERENCES PERSON(ssn),
    specialization_field varchar(255) NOT NULL,
    year_of_experience int NOT NULL,
    deal_distributor int REFERENCES distributor(distributor_id) NOT NULL,
    deal_supplier int REFERENCES supplier(supplier_id) NOT NULL
);
