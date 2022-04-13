<%@page import="com.emergentes.modelo.tarea"%>
<%@page import="com.emergentes.modelo.gestortareas"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    if (session.getAttribute("agenda") == null) {
        gestortareas gt = new gestortareas();

        gt.insertarTarea(new tarea(1, "Reunion con estudiantes de la carrera", "ALTA"));
        gt.insertarTarea(new tarea(2, "Estudiar para el examen", "ALTA"));
        gt.insertarTarea(new tarea(2, "Partido de futsal", "BAJA"));

        session.setAttribute("agenda", gt);
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de tareas</h1>
        <a href="controller?op=nuevo"><input type="submit" value="Nuevo"></a><br><br>

        <table border="1">
            <tr>
                <th>Id</th><th>Tarea</th><th>Prioridad</th><th>Btn Modificar</th><th>Btn Eliminar</th>
            </tr>

            <c:forEach var="item" items="${sessionScope.agenda.getLista()}">
                <tr>
                    <td> ${item.id} </td>
                    <td> ${item.tarea} </td>
                    <td> ${item.prioridad} </td>
                    <td> <a href="controller?op=modificar&id=${item.id}"><input type="submit" value="Modificar"></a></td>
                    <td> <a href="controller?op=eliminar&id=${item.id}"><input type="submit" value="Eliminar"></a></td>
                </tr>
            </c:forEach>

        </table>
    </body>
</html>
