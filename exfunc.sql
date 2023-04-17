CREATE DATABASE ex_func
GO
USE ex_func

CREATE TABLE funcionario (
codigo		INT				NOT NULL,
nome		VARCHAR(100)	NOT NULL,
salario		DECIMAL(7,2)	NOT NULL
PRIMARY KEY (codigo)
)

CREATE TABLE dependente(
codigo_funcionario		INT				NOT NULL,
nome_dependente			VARCHAR(100)	NOT NULL,
salario_dependente		DECIMAL(7,2)	NOT NULL
PRIMARY KEY (codigo_funcionario)
FOREIGN KEY (codigo_funcionario) REFERENCES funcionario(codigo)
)

DECLARE @codigo  INT,
		@nome    VARCHAR(100),
		@salario DECIMAL(7,2)
	SET @codigo = 1
	WHILE (@codigo < 11)
	BEGIN
	SET @salario = ((RAND()*5000) + 10)
	INSERT INTO funcionario VALUES 
	(@codigo, 'pessoa'+CAST(@codigo AS VARCHAR(1)), @salario)
	SET @codigo = @codigo + 1
	END

select * FROM funcionario 

DECLARE @codigo_funcionario	INT,
		@nome_dependente    VARCHAR(100),
		@salario_dependente DECIMAL(7,2)
	SET @codigo_funcionario = 1
	WHILE (@codigo_funcionario < 11)
	BEGIN
	SET @salario_dependente = ((RAND()*5000) + 10)
	INSERT INTO dependente VALUES 
	(@codigo_funcionario, 'dependente'+CAST(@codigo_funcionario AS VARCHAR(1)), @salario_dependente)
	SET @codigo_funcionario = @codigo_funcionario + 1
	END

/* Function que Retorne uma tabela:  
(Nome_Funcionário, Nome_Dependente, Salário_Funcionário, Salário_Dependente)
*/
CREATE FUNCTION fn_tablefunc()
RETURNS @tabela TABLE (
nome				VARCHAR(100),
nome_dependente		VARCHAR(100),
salario				DECIMAL(7,2),
salario_dependente  DECIMAL(7,2)
)
AS
	BEGIN
		INSERT INTO @tabela(f.nome, d.nome_dependente, f.salario, d.salario_dependente)
			SELECT f.nome, d.nome_dependente, f.salario, d.salario_dependente FROM funcionario f
			INNER JOIN dependente d
			ON f.codigo = d.codigo_funcionario	
	RETURN
END

SELECT * FROM fn_tablefunc()

/*
Scalar Function que Retorne a soma dos Salários dos dependentes, mais a do funcionário
*/
CREATE FUNCTION fn_soma(@codigo_funcionario INT)
RETURNS DECIMAL(7,2)
AS
BEGIN
		DECLARE @salario			DECIMAL(7,2),
				@salario_dependente DECIMAL(7,2),
				@soma_salario		DECIMAL(7,2)

		SELECT @salario = f.salario, @salario_dependente = d.salario_dependente
				FROM funcionario f
				INNER JOIN dependente d
				ON f.codigo = d.codigo_funcionario
				WHERE f.codigo = @codigo_funcionario

		SET @soma_salario = @salario + @salario_dependente

		RETURN @soma_salario
END

SELECT dbo.fn_soma(1) AS func

SELECT * FROM funcionario
SELECT * FROM dependente