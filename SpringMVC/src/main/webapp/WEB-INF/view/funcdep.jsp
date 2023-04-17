<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href='<c:url value="./resources/css/styles.css" />'>
<title>SpringUDFFuncDep</title>
</head>
<body>
		<jsp:include page="menu.jsp"></jsp:include>
		<div align="center">
			<form action="funcdep" method="post">
			<input type="submit" name="botaol" id="botaol" value ="Listar">
			</form>
		</div>
		<br>
		<div align="center">
			<c:if test="${not empty lista}">
			<table border="1">
			<thead>
		<tr>
			<th>Funcionario</th>
			<th>Dependente</th>
			<th>Salario Funcionario</th>
			<th>Salario Dependente</th>
		</tr>
			</thead>
		<tbody>
				<c:forEach items="${lista}" var="l">
		<tr>
			<td><c:out value="${l.nomeFuncionario}"></c:out></td>
			<td><c:out value="${l.nomeDependente}"></c:out></td>
			<td><c:out value="${l.salarioFuncionario}"></c:out></td>
			<td><c:out value="${l.salarioDependente}"></c:out></td>
		</tr>
				</c:forEach>
		</tbody>
			</table>
			</c:if>
		</div>
		<br>
		<br>
			<div align="center">
			<form action="funcdep" method="post">
			<table border="1">
		<tr>
			<td><input type="number" name="botaoid" id="botaoid" placeholder="ID" required step="1"></td>
			<td><input type="submit" name="botaobv" id="botaobv" value="Busca Valor"></td>
		</tr>
		<tr>
			<td><input type="number" name="botaovalor" id="botaovalor" 
			value="<c:out value="${soma_salario}"></c:out>" step="0.01"></td>
		</tr>
			</table>
			</form>
			</div>
</body>
</html>