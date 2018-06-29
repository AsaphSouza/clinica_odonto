CREATE DATABASE CLINICA_ODONTOLOGICA;

DROP TABLE IF EXISTS PACIENTE CASCADE;
CREATE TABLE PACIENTE (
idPaciente SERIAL PRIMARY KEY,
cpf VARCHAR(11) NOT NULL,
email VARCHAR,
nome VARCHAR NOT NULL,
telefone VARCHAR NOT NULL, 
nascimento DATE NOT NULL,
profissao VARCHAR,
sexo CHAR NOT NULL,
rua VARCHAR NOT NULL,
bairro VARCHAR,
numero INTEGER,
estado VARCHAR NOT NULL,
pais VARCHAR DEFAULT ('Brasil'),
cidade VARCHAR NOT NULL,
complemento VARCHAR
UNIQUE(cpf),
CHECK (sexo IN ('M','F')),
);

DROP TABLE IF EXISTS MEDICAMENTO CASCADE;
CREATE TABLE MEDICAMENTO (
	idMedicamento SERIAL PRIMARY KEY,
	intervalo INTEGER,
	dose FLOAT,
	via VARCHAR,
	tempo_de_uso INTEGER,
	nome VARCHAR NOT NULL
);

DROP TABLE IF EXISTS RECEPCIONISTA CASCADE;
CREATE TABLE RECEPCIONISTA (
	idRecepcionista SERIAL PRIMARY KEY,
	nome VARCHAR NOT NULL,
	formacao VARCHAR NOT NULL
);

DROP TABLE IF EXISTS DENTISTA CASCADE;
CREATE TABLE DENTISTA (
	idDentista SERIAL PRIMARY KEY,
	cro VARCHAR NOT NULL,
	formacao VARCHAR NOT NULL,
	nome VARCHAR NOT NULL
);

DROP TABLE IF EXISTS ASSISTENTE CASCADE;
CREATE TABLE ASSISTENTE (
	idAssistente SERIAL PRIMARY KEY,
	nome VARCHAR NOT NULL,
	formacao VARCHAR NOT NULL
);

DROP TABLE IF EXISTS CONSULTA CASCADE;
CREATE TABLE CONSULTA (
	idConsulta SERIAL PRIMARY KEY,
	meio VARCHAR,
	dataHora TIMESTAMP NOT NULL,
	tipo VARCHAR,
	dataMarcacao TIMESTAMP NOT NULL,
	idRecepcionista INTEGER,
	cro SERIAL,
	idAssistente SERIAL,
	idPaciente SERIAL,
	CONSTRAINT FK_RECEPCIONISTA FOREIGN KEY (idRecepcionista) REFERENCES RECEPCIONISTA (idRecepcionista),
	CONSTRAINT FK_DENTISTA FOREIGN KEY (idDentista) REFERENCES DENTISTA (idDentista),
	CONSTRAINT FK_ASSISTENTE FOREIGN KEY (idAssistente) REFERENCES ASSISTENTE (idAssistente),
	CONSTRAINT FK_PACIENTE FOREIGN KEY (idPaciente) REFERENCES PACIENTE (idPaciente)
	ON UPDATE CASCADE ON DELETE CASCADE
);

DROP TABLE IF EXISTS EXAME CASCADE;
CREATE TABLE EXAME (
	idExame SERIAL PRIMARY KEY,
	status VARCHAR NOT NULL,
	nome VARCHAR NOT NULL,
	descricao VARCHAR,
	tempoEstimado TIME,
	resultado VARCHAR,
	idConsulta SERIAL,
	idPaciente SERIAL,
	dataMarcacaoPaciente TIMESTAMP,
	dataMarcacaoRecepcionista TIMESTAMP,
	idRecepcionista SERIAL,
	CONSTRAINT FK_PACIENTE FOREIGN KEY (idPaciente) REFERENCES PACIENTE (idPaciente),
	CONSTRAINT FK_RECEPCIONISTA FOREIGN KEY (idRecepcionista) REFERENCES RECEPCIONISTA (idRecepcionista),
	CONSTRAINT FK_CONSULTA FOREIGN KEY (idConsulta) REFERENCES CONSULTA (idConsulta)
	ON UPDATE CASCADE ON DELETE CASCADE
);

DROP TABLE IF EXISTS ATESTADO CASCADE;
CREATE TABLE ATESTADO (
	idAtestado SERIAL PRIMARY KEY,
	tipo VARCHAR,
	descricao VARCHAR NOT NULL,
	idConsulta SERIAL,
	CONSTRAINT FK_CONSULTA FOREIGN KEY (idConsulta) REFERENCES CONSULTA (idConsulta)
	ON UPDATE CASCADE ON DELETE CASCADE 
); 

DROP TABLE IF EXISTS QUESTIONARIO CASCADE;
CREATE TABLE QUESTIONARIO (
	idQuestionario SERIAL PRIMARY KEY,
	nome VARCHAR
);

DROP TABLE IF EXISTS PERGUNTA CASCADE;
CREATE TABLE PERGUNTA (
	idPergunta SERIAL PRIMARY KEY,
	descricao VARCHAR NOT NULL, 
	tipo VARCHAR,
	idQuestionario SERIAL,
	cro SERIAL,
	CONSTRAINT FK_QUESTIONARIO FOREIGN KEY (idQuestionario) REFERENCES QUESTIONARIO (idQuestionario),
	CONSTRAINT FK_DENTISTA FOREIGN KEY  (idDentista) REFERENCES DENTISTA (idDentista)
	ON UPDATE CASCADE ON DELETE CASCADE
);

DROP TABLE IF EXISTS DOENCA CASCADE;
CREATE TABLE DOENCA (
	idDoenca SERIAL PRIMARY KEY,
	nome VARCHAR
);

DROP TABLE IF EXISTS RESPOSTA CASCADE;
CREATE TABLE RESPOSTA (
	idResposta SERIAL PRIMARY KEY,
	descricao VARCHAR NOT NULL, 
	idPergunta SERIAL,
	cro SERIAL,
	idDoenca SERIAL,
	idMedicamento SERIAL,
	CONSTRAINT FK_PERGUNTA FOREIGN KEY (idPergunta) REFERENCES PERGUNTA (idPergunta),
	CONSTRAINT FK_DENTISTA FOREIGN KEY (idDentista) REFERENCES DENTISTA (idDentista),
	CONSTRAINT FK_DOENCA FOREIGN KEY (idDoenca) REFERENCES DOENCA (idDoenca),
	CONSTRAINT FK_MEDICAMENTO FOREIGN KEY (idMedicamento) REFERENCES MEDICAMENTO (idMedicamento)
	ON UPDATE CASCADE ON DELETE CASCADE
);

DROP TABLE IF EXISTS CONSULTA_SOLICITACAO_EXAME;
CREATE TABLE CONSULTA_SOLICITACAO_EXAME (
	idExame SERIAL,
	idConsulta SERIAL,
	CONSTRAINT FK_EXAME FOREIGN KEY (idExame) REFERENCES EXAME (idExame),
	CONSTRAINT FK_CONSULTA FOREIGN KEY (idConsulta) REFERENCES CONSULTA (idConsulta)
	ON UPDATE CASCADE ON DELETE CASCADE
);

DROP TABLE IF EXISTS CONSULTA_EMISSAO_ATESTADO;
CREATE TABLE CONSULTA_EMISSAO_ATESTADO (
	idConsulta SERIAL,
	idAtestado SERIAL,
	CONSTRAINT FK_CONSULTA FOREIGN KEY (idConsulta) REFERENCES CONSULTA (idConsulta)
	ON UPDATE CASCADE ON DELETE CASCADE
);

DROP TABLE IF EXISTS CONSULTA_EMISSAO_MEDICAMENTO;
CREATE TABLE CONSULTA_EMISSAO_MEDICAMENTO (
	idConsulta SERIAL,
	idMedicamento SERIAL,
	CONSTRAINT FK_CONSULTA FOREIGN KEY (idConsulta) REFERENCES CONSULTA (idConsulta),
	CONSTRAINT FK_MEDICAMENTO FOREIGN KEY (idMedicamento) REFERENCES MEDICAMENTO (idMedicamento)
	ON UPDATE CASCADE ON DELETE CASCADE
);

DROP TABLE IF EXISTS PACIENTE_UTILIZA_MEDICAMENTO;
CREATE TABLE PACIENTE_UTILIZA_MEDICAMENTO (
	idPaciente SERIAL,
	idMedicamento SERIAL,
	CONSTRAINT FK_PACIENTE FOREIGN KEY (idPaciente) REFERENCES PACIENTE (idPaciente),
	CONSTRAINT FK_MEDICAMENTO FOREIGN KEY (idMedicamento) REFERENCES MEDICAMENTO (idMedicamento)
);


DROP TABLE IF EXISTS DOENCA_TEM_RESPOSTA;
CREATE TABLE DOENCA_TEM_RESPOSTA (
	idDoenca SERIAL,
	idResposta SERIAL,
	CONSTRAINT FK_DOENCA FOREIGN KEY (idDoenca) REFERENCES DOENCA (idDoenca),
	CONSTRAINT FK_RESPOSTA FOREIGN KEY (idResposta) REFERENCES RESPOSTA (idResposta)
	ON UPDATE CASCADE ON DELETE CASCADE
);

DROP TABLE IF EXISTS MEDICAMENTO_TEM_RESPOSTA;
CREATE TABLE MEDICAMENTO_TEM_RESPOSTA (
	idMedicamento SERIAL,
	idResposta SERIAL,
	CONSTRAINT FK_MEDICAMENTO FOREIGN KEY (idMedicamento) REFERENCES MEDICAMENTO (idMedicamento),
	CONSTRAINT FK_RESPOSTA FOREIGN KEY (idResposta) REFERENCES RESPOSTA (idResposta)
	ON UPDATE CASCADE ON DELETE CASCADE
);