INSERT INTO demo.roles (name) VALUES ('ROLE_ACTUATOR');
INSERT INTO demo.roles (name) VALUES ('ROLE_ADMIN');
INSERT INTO demo.roles (name) VALUES ('ROLE_USER');
INSERT INTO demo.users (account_expired, account_locked, company, create_date, email, enabled, first_name, last_name, password, password_expired, photo_url, update_date, username) VALUES (false, false, '', '2017-09-22 06:47:13', 'sumo@demo.com', true, 'sumo', 'demo', '$2a$10$SsAqGoc.RQUadt866n.XIOTUbVblL7W08QaeyXR7BPwY88ZmcJ.gK', false, '', '2017-09-22 06:47:13', 'sumo');
INSERT INTO demo.users (account_expired, account_locked, company, create_date, email, enabled, first_name, last_name, password, password_expired, photo_url, update_date, username) VALUES (false, false, '', '2017-09-22 06:47:13', 'actuator@demo.com', true, 'actuator', 'actuator', '$2a$10$h/BQCaiCsGMRvxizjauDc.DXUXCdtzgcfqQx/owjgGLw1DvVNZ61W', false, '', '2017-09-22 06:47:13', 'actuator');
INSERT INTO demo.users (account_expired, account_locked, company, create_date, email, enabled, first_name, last_name, password, password_expired, photo_url, update_date, username) VALUES (false, false, '', '2017-09-22 06:47:13', 'sumo1@demo.com', true, 'sumo1', 'demo1', '$2a$10$qgeULY2CURWxsOXe7NA/5uCR2F5nZmm/4wXS8ea0IO0S9CEeeKfWu', false, '', '2017-09-22 06:47:13', 'sumo1');
INSERT INTO demo.users (account_expired, account_locked, company, create_date, email, enabled, first_name, last_name, password, password_expired, photo_url, update_date, username) VALUES (false, false, '', '2017-09-22 06:47:13', 'admin@demo.com', true, 'admin', 'admin', '$2a$10$wjtdJ0ulHMMMA8x2ykWiDelqVPIVFHmhs0hqUU8Rtp51ANJHfUqzK', false, '', '2017-09-22 06:47:13', 'admin');
INSERT INTO demo.user_role (user_id, role_id) VALUES (1, 3);
INSERT INTO demo.user_role (user_id, role_id) VALUES (3, 1);
INSERT INTO demo.user_role (user_id, role_id) VALUES (4, 2);
INSERT INTO demo.user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO demo.user_role (user_id, role_id) VALUES (3, 3);