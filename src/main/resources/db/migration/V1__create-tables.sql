CREATE TABLE unidade_federativa (
                                    sigla_uf VARCHAR(2) PRIMARY KEY,
                                    nome_uf VARCHAR(100)
);

CREATE TABLE cidade (
                        id_cidade INT PRIMARY KEY,
                        nome_cidade VARCHAR(100),
                        sigla_uf VARCHAR(2),
                        FOREIGN KEY (sigla_uf) REFERENCES unidade_federativa(sigla_uf)
);

CREATE TABLE bairro (
                        id_bairro INT PRIMARY KEY,
                        nome_bairro VARCHAR(100)
);

CREATE TABLE tipo_logradouro (
                                 sigla_tipo_logradouro CHAR(3) PRIMARY KEY,
                                 nome_tipo_logradouro VARCHAR(50)
);

CREATE TABLE logradouro (
                            id_logradouro INT PRIMARY KEY,
                            nome_logradouro VARCHAR(100),
                            sigla_tipo_logradouro CHAR(3),
                            FOREIGN KEY (sigla_tipo_logradouro) REFERENCES tipo_logradouro(sigla_tipo_logradouro)
);

CREATE TABLE endereco (
                          id_endereco INT PRIMARY KEY,
                          cep_endereco VARCHAR(20),
                          id_cidade INT,
                          id_logradouro INT,
                          id_bairro INT,
                          FOREIGN KEY (id_cidade) REFERENCES cidade(id_cidade),
                          FOREIGN KEY (id_logradouro) REFERENCES logradouro(id_logradouro),
                          FOREIGN KEY (id_bairro) REFERENCES bairro(id_bairro)
);

CREATE TABLE sexo (
                      id_sexo INT PRIMARY KEY,
                      nome_sexo VARCHAR(20)
);

CREATE TABLE estado_civil (
                              id_estado_civil INT PRIMARY KEY,
                              nome_estado_civil VARCHAR(50)
);

CREATE TABLE paciente (
                          numero_paciente VARCHAR(20) PRIMARY KEY,
                          nome_paciente VARCHAR(100),
                          data_nascimento_paciente DATE,
                          id_sexo INT,
                          id_estado_civil INT,
                          numero_documento_identidade_paciente VARCHAR(50),
                          complemento_endereco_paciente VARCHAR(100),
                          numero_endereco_paciente VARCHAR(10),
                          id_endereco INT,
                          FOREIGN KEY (id_sexo) REFERENCES sexo(id_sexo),
                          FOREIGN KEY (id_estado_civil) REFERENCES estado_civil(id_estado_civil),
                          FOREIGN KEY (id_endereco) REFERENCES endereco(id_endereco)
);

CREATE TABLE ddi (
                     numero_ddi VARCHAR(5) PRIMARY KEY
);

CREATE TABLE ddd (
                     numero_ddd VARCHAR(5) PRIMARY KEY
);

CREATE TABLE telefone_paciente (
                                   numero_telefone_paciente VARCHAR(20) PRIMARY KEY,
                                   numero_ddd VARCHAR(5),
                                   numero_ddi VARCHAR(5),
                                   numero_paciente VARCHAR(20),
                                   FOREIGN KEY (numero_ddd) REFERENCES ddd(numero_ddd),
                                   FOREIGN KEY (numero_ddi) REFERENCES ddi(numero_ddi),
                                   FOREIGN KEY (numero_paciente) REFERENCES paciente(numero_paciente)
);

CREATE TABLE email_paciente (
                                email_paciente VARCHAR(100) PRIMARY KEY,
                                numero_paciente VARCHAR(20),
                                FOREIGN KEY (numero_paciente) REFERENCES paciente(numero_paciente)
);

CREATE TABLE tipo_exame_medico (
                            codigo_tipo_exame_medico VARCHAR(10) PRIMARY KEY,
                            nome_tipo_exame_medico VARCHAR(100)
);

CREATE TABLE resultado_geral_exame_medico (
                                       id_resultado_geral_exame_medico INT PRIMARY KEY,
                                       resultado_geral_exame_medico VARCHAR(100)
);

CREATE TABLE exame_medico (
                              numero_exame_medico INT PRIMARY KEY,
                              data_realizacao_exame_medico DATE,
                              codigo_tipo_exame_medico VARCHAR(10),
                              id_resultado_geral_exame_medico INT,
                              observacao_exame_medico TEXT,
                              numero_paciente VARCHAR(20),
                              FOREIGN KEY (codigo_tipo_exame_medico) REFERENCES tipo_exame_medico(codigo_tipo_exame_medico),
                              FOREIGN KEY (id_resultado_geral_exame_medico) REFERENCES resultado_geral_exame_medico(id_resultado_geral_exame_medico),
                              FOREIGN KEY (numero_paciente) REFERENCES paciente(numero_paciente)
);

CREATE TABLE diagnostico_cid (
                                 codigo_diagnostico_cid VARCHAR(10) PRIMARY KEY,
                                 descricao_diagnostico_cid TEXT
);

CREATE TABLE medico (
                        crm_medico VARCHAR(20) PRIMARY KEY,
                        nome_medico VARCHAR(100),
                        id_endereco INT,
                        numero_endereco_medico VARCHAR(10),
                        complemento_endereco_medico VARCHAR(100),
                        FOREIGN KEY (id_endereco) REFERENCES endereco(id_endereco)
);

CREATE TABLE telefone_medico (
                                 numero_telefone_medico VARCHAR(20) PRIMARY KEY,
                                 numero_ddd VARCHAR(5),
                                 numero_ddi VARCHAR(5),
                                 crm_medico VARCHAR(20),
                                 FOREIGN KEY (numero_ddd) REFERENCES ddd(numero_ddd),
                                 FOREIGN KEY (numero_ddi) REFERENCES ddi(numero_ddi),
                                 FOREIGN KEY (crm_medico) REFERENCES medico(crm_medico)
);

CREATE TABLE email_medico (
                              email_medico VARCHAR(100) PRIMARY KEY,
                              crm_medico VARCHAR(20),
                              FOREIGN KEY (crm_medico) REFERENCES medico(crm_medico)
);

CREATE TABLE consulta_medica (
                                 numero_consulta_medica INT PRIMARY KEY,
                                 data_realizacao_consulta_medica DATE,
                                 crm_medico VARCHAR(20),
                                 codigo_diagnostico_cid VARCHAR(10),
                                 numero_paciente VARCHAR(20),
                                 FOREIGN KEY (crm_medico) REFERENCES medico(crm_medico),
                                 FOREIGN KEY (codigo_diagnostico_cid) REFERENCES diagnostico_cid(codigo_diagnostico_cid),
                                 FOREIGN KEY (numero_paciente) REFERENCES paciente(numero_paciente)
);