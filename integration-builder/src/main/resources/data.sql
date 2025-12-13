INSERT INTO integration_config (id, name, base_url, user_endpoint, auth_type, auth_token, pagination_style, pagination_param, page_size_param, active)
VALUES (1, 'calendly', 'https://api.calendly.com', '/users', 'BEARER_TOKEN', 'REPLACE_WITH_CALENDLY_TOKEN, 'LINKED', 'page_token', 'page_size', true);


INSERT INTO field_mapping (id, integration_id, external_field, internal_field) VALUES (1,1,'email','email');
INSERT INTO field_mapping (id, integration_id, external_field, internal_field) VALUES (2,1,'name','name');