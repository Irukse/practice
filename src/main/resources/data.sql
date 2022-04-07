INSERT INTO Type_document  (id, name_type, code, version) VALUES (1, 'Паспорт', '21', 0);
INSERT INTO Type_document  (id, name_type, code, version) VALUES (2, 'Загранпас', '22', 0);

INSERT INTO Country (id, name_country, code, version) VALUES (1, 'Российская Федерация', '643', 0);
INSERT INTO Country (id, name_country, code, version) VALUES (2, 'Греция', '520', 0);
INSERT INTO Organization (id, name_org, full_name, inn, kpp, address, phone, is_active, version) VALUES (1, 'Газпром', 'ООО ГазПромВладивосток', 11112222, 22221111, 'ул.Циолковского, д.21', '89213332113', true, 0 );
INSERT INTO Organization (id, name_org, full_name, inn, kpp, address, phone, is_active, version) VALUES (2, 'Apple', 'ООО Apple Inc', 33334444, 44443333, 'ул.Красного знамени, д.17', '89784540101', true, 0 );
INSERT INTO Organization (id, name_org, full_name, inn, kpp, address, phone, is_active, version) VALUES (3, 'Apple', 'ООО Apple Inc', 33334444, 44443333, 'ул.Красного знамени, д.17', '89784540101', false, 0 );
INSERT INTO Organization (id, name_org, full_name, inn, kpp, address, phone, is_active, version) VALUES (4, 'Apple', 'ООО Apple Inc', 11112222, 44443333, 'ул.Красного знамени, д.17', '89784540101', false, 0 );
INSERT INTO Organization (id, name_org, full_name, inn, kpp, address, phone, is_active, version) VALUES (5, 'Apple', 'ООО Apple Inc', 55556666, 44443333, 'ул.Красного знамени, д.17', '89784540101', false, 0 );

INSERT INTO Office (id, org_id, name_office, address, phone, is_active, version) VALUES (1, 1, 'Main office Gazprom', 'ул.Ленина, д.6', '89259063212', true, 0 );
INSERT INTO Office (id, org_id, name_office, address, phone, is_active, version) VALUES (2, 2, 'Main office Apple', 'ул.Гагарина, д.54', '89237304091', true, 0 );

INSERT INTO Employee (id, first_name, second_name, last_name, position, phone, citizenship_id, is_identified, version) VALUES (1, 'Коля', 'Сахаров', 'Кириллович', 'HR', '890723490-7', 1, true, 0 );
INSERT INTO Employee (id, first_name, second_name, last_name, position, phone, citizenship_id, is_identified, version) VALUES (2, 'Тайсон', 'Фьюри', 'Астапович', 'Security', '89073330909', 2, true, 0 );
INSERT INTO Employee (id, first_name, second_name, last_name, position, phone, citizenship_id, is_identified, version) VALUES (3, 'Максим', 'Стрыкало', 'Эдуардович', 'DevOps', '89992349022', 1, true, 0 );

INSERT INTO Doc_employee (emp_id, doc_number, doc_date, type_id, version ) VALUES (1, 11111111111, '1995-03-12', 1, 0);
INSERT INTO Doc_employee (emp_id, doc_number, doc_date, type_id, version) VALUES (2, 22222222222, '2000-09-02', 1, 0);
INSERT INTO Doc_employee (emp_id, doc_number, doc_date, type_id, version ) VALUES (3, 55555555555, '1998-08-09', 1, 0);






