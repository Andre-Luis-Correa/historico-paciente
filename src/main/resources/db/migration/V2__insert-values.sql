-- Inserindo dados em unidade_federativa
INSERT INTO unidade_federativa (sigla_uf, nome_uf) VALUES
                                                       ('SP', 'São Paulo'),
                                                       ('RJ', 'Rio de Janeiro');

-- Inserindo dados em cidade
INSERT INTO cidade (id_cidade, nome_cidade, sigla_uf) VALUES
                                                          (1, 'São Paulo', 'SP'),
                                                          (2, 'Rio de Janeiro', 'RJ');

-- Inserindo dados em bairro
INSERT INTO bairro (id_bairro, nome_bairro) VALUES
                                                (1, 'Centro'),
                                                (2, 'Zona Sul');

-- Inserindo dados em tipo_logradouro
INSERT INTO tipo_logradouro (sigla_tipo_logradouro, nome_tipo_logradouro) VALUES
                                                                              ('R', 'Rua'),
                                                                              ('AV', 'Avenida');

-- Inserindo dados em logradouro
INSERT INTO logradouro (id_logradouro, nome_logradouro, sigla_tipo_logradouro) VALUES
                                                                                   (1, 'Paulista', 'AV'),
                                                                                   (2, 'Rio Branco', 'AV');

-- Inserindo dados em endereco
INSERT INTO endereco (id_endereco, cep_endereco, id_cidade, id_logradouro, id_bairro) VALUES
                                                                                          (1, '01311-000', 1, 1, 1),
                                                                                          (2, '20040-001', 2, 2, 2);

-- Inserindo dados em sexo
INSERT INTO sexo (id_sexo, nome_sexo) VALUES
                                          (1, 'Masculino'),
                                          (2, 'Feminino');

-- Inserindo dados em estado_civil
INSERT INTO estado_civil (id_estado_civil, nome_estado_civil) VALUES
                                                                  (1, 'Solteiro'),
                                                                  (2, 'Casado');

-- Inserindo dados em paciente
INSERT INTO paciente (numero_paciente, nome_paciente, data_nascimento_paciente, id_sexo, id_estado_civil, numero_documento_identidade_paciente, complemento_endereco_paciente, numero_endereco_paciente, id_endereco) VALUES
                                                                                                                                                                                                                          ('P001', 'João Silva', '1980-05-21', 1, 1, '123456789', 'Apto 101', '123', 1),
                                                                                                                                                                                                                          ('P002', 'Maria Oliveira', '1985-11-15', 2, 2, '987654321', 'Apto 202', '456', 2),
                                                                                                                                                                                                                          ('P003', 'Carlos Souza', '1992-07-30', 1, 1, '567891234', 'Casa', '789', 1),
                                                                                                                                                                                                                          ('P004', 'Ana Paula', '1975-09-10', 2, 2, '432198765', 'Casa', '321', 2),
                                                                                                                                                                                                                          ('P005', 'Fernanda Lima', '1990-01-05', 2, 1, '345678912', 'Apto 303', '654', 1);

-- Inserindo dados em ddi
INSERT INTO ddi (numero_ddi) VALUES
    ('+55');

-- Inserindo dados em ddd
INSERT INTO ddd (numero_ddd) VALUES
                                 ('11'),
                                 ('21');

-- Inserindo dados em telefone_paciente
INSERT INTO telefone_paciente (numero_telefone_paciente, numero_ddd, numero_ddi, numero_paciente) VALUES
                                                                                                      ('99992222', '11', '+55', 'P001'),
                                                                                                      ('99991111', '11', '+55', 'P001'),
                                                                                                      ('99993333', '11', '+55', 'P001'),
                                                                                                      ('88882222', '11', '+55', 'P002'),
                                                                                                      ('77773333', '21', '+55', 'P003'),
                                                                                                      ('66664444', '21', '+55', 'P004'),
                                                                                                      ('55555555', '11', '+55', 'P005');

-- Inserindo dados em email_paciente
INSERT INTO email_paciente (email_paciente, numero_paciente) VALUES
                                                                 ('joao.silva@example.com', 'P001'),
                                                                 ('joao.silva@gmail.com', 'P001'),
                                                                 ('joao.silva@hotmail.com', 'P001'),
                                                                 ('maria.oliveira@example.com', 'P002'),
                                                                 ('carlos.souza@example.com', 'P003'),
                                                                 ('ana.paula@example.com', 'P004'),
                                                                 ('fernanda.lima@example.com', 'P005');

-- Inserindo dados em tipo_exame_medico
INSERT INTO tipo_exame_medico (codigo_tipo_exame_medico, nome_tipo_exame_medico) VALUES
                                                                                     ('EX001', 'Hemograma Completo'),
                                                                                     ('EX002', 'Raio-X Tórax'),
                                                                                     ('EX003', 'Ultrassonografia Abdominal'),
                                                                                     ('EX004', 'Eletrocardiograma'),
                                                                                     ('EX005', 'Tomografia Computadorizada');

-- Inserindo dados em resultado_geral_exame_medico
INSERT INTO resultado_geral_exame_medico (id_resultado_geral_exame_medico, resultado_geral_exame_medico) VALUES
                                                                                                             (1, 'Normal'),
                                                                                                             (2, 'Alterado'),
                                                                                                             (3, 'Necessita acompanhamento'),
                                                                                                             (4, 'Necessita tratamento');

-- Inserindo dados em exame_medico para os pacientes
INSERT INTO exame_medico (numero_exame_medico, data_realizacao_exame_medico, codigo_tipo_exame_medico, id_resultado_geral_exame_medico, observacao_exame_medico, numero_paciente) VALUES
                                                                                                                                                                                      (1, '2023-01-10', 'EX001', 1, 'Sem alterações', 'P001'),
                                                                                                                                                                                      (2, '2023-02-15', 'EX002', 2, 'Opacidade pulmonar', 'P001'),
                                                                                                                                                                                      (3, '2023-03-20', 'EX003', 3, 'Nódulo hepático', 'P002'),
                                                                                                                                                                                      (4, '2023-04-05', 'EX004', 1, 'Normal', 'P002'),
                                                                                                                                                                                      (5, '2023-05-12', 'EX005', 4, 'Lesão tumoral', 'P003'),
                                                                                                                                                                                      (6, '2023-06-10', 'EX001', 1, 'Normal', 'P003'),
                                                                                                                                                                                      (7, '2023-07-18', 'EX002', 2, 'Pequena lesão', 'P004'),
                                                                                                                                                                                      (8, '2023-08-22', 'EX003', 3, 'Necessita acompanhamento', 'P004'),
                                                                                                                                                                                      (9, '2023-09-05', 'EX004', 1, 'Normal', 'P005'),
                                                                                                                                                                                      (10, '2023-10-15', 'EX005', 4, 'Alterações significativas', 'P005');

-- Inserindo dados em diagnostico_cid
INSERT INTO diagnostico_cid (codigo_diagnostico_cid, descricao_diagnostico_cid) VALUES
                                                                                    ('D001', 'Hipertensão Arterial'),
                                                                                    ('D002', 'Diabetes Mellitus'),
                                                                                    ('D003', 'Asma'),
                                                                                    ('D004', 'Gastrite Crônica'),
                                                                                    ('D005', 'Insuficiência Cardíaca');

-- Inserindo dados em medico
INSERT INTO medico (crm_medico, nome_medico, id_endereco, numero_endereco_medico, complemento_endereco_medico) VALUES
                                                                                                                   ('CRM001', 'Dr. Lucas Mendes', 1, '123', 'Apto 1'),
                                                                                                                   ('CRM002', 'Dra. Julia Santos', 2, '456', 'Apto 2'),
                                                                                                                   ('CRM003', 'Dr. Ricardo Costa', 1, '789', 'Sala 5');

-- Inserindo dados em telefone_medico
INSERT INTO telefone_medico (numero_telefone_medico, numero_ddd, numero_ddi, crm_medico) VALUES
                                                                                             ('99991111', '11', '+55', 'CRM001'),
                                                                                             ('88882222', '21', '+55', 'CRM002'),
                                                                                             ('77773333', '11', '+55', 'CRM003');

-- Inserindo dados em email_medico
INSERT INTO email_medico (email_medico, crm_medico) VALUES
                                                        ('lucas.mendes@example.com', 'CRM001'),
                                                        ('julia.santos@example.com', 'CRM002'),
                                                        ('ricardo.costa@example.com', 'CRM003');

-- Inserindo dados em consulta_medica para os pacientes
INSERT INTO consulta_medica (numero_consulta_medica, data_realizacao_consulta_medica, crm_medico, codigo_diagnostico_cid, numero_paciente) VALUES
                                                                                                                                               (1, '2023-01-15', 'CRM001', 'D001', 'P001'),
                                                                                                                                               (2, '2023-02-20', 'CRM002', 'D002', 'P001'),
                                                                                                                                               (3, '2023-03-25', 'CRM003', 'D003', 'P002'),
                                                                                                                                               (4, '2023-04-10', 'CRM001', 'D004', 'P002'),
                                                                                                                                               (5, '2023-05-05', 'CRM002', 'D005', 'P003'),
                                                                                                                                               (6, '2023-06-12', 'CRM003', 'D001', 'P003'),
                                                                                                                                               (7, '2023-07-22', 'CRM001', 'D002', 'P004'),
                                                                                                                                               (8, '2023-08-18', 'CRM002', 'D003', 'P004'),
                                                                                                                                               (9, '2023-09-15', 'CRM003', 'D004', 'P005'),
                                                                                                                                               (10, '2023-10-10', 'CRM001', 'D005', 'P005');
