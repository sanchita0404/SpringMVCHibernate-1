<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Task Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Add a Task
</h1>

<c:url var="addAction" value="/person/add" ></c:url>

<form:form action="${addAction}" commandName="Task">
<table>
	<c:if test="${!empty Task.taskName}">
	<tr>
		<td>
			<form:label path="taskId">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="taskId" readonly="true" size="8"  disabled="true" />
			<form:hidden path="taskId" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="taskName">
				<spring:message text="Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="taskName" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="description">
				<spring:message text="Description"/>
			</form:label>
		</td>
		<td>
			<form:input path="description" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty Task.taskName}">
				<input type="submit"
					value="<spring:message text="Edit Task"/>" />
			</c:if>
			<c:if test="${empty Task.taskName}">
				<input type="submit"
					value="<spring:message text="Add Task"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Persons List</h3>
<c:if test="${!empty listTasks}">
	<table class="tg">
	<tr>
		<th width="80">Task ID</th>
		<th width="120">Task Name</th>
		<th width="120">Task Description</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listTasks}" var="Task">
		<tr>
			<td>${Task.taskId}</td>
			<td>${Task.taskName}</td>
			<td>${Task.description}</td>
			<td><a href="<c:url value='/edit/${Task.taskId}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove/${Task.taskId}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
