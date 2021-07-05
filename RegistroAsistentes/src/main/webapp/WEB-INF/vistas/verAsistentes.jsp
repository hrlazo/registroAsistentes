<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../templates/header.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<main class="container mt-6">
    <div class="columns is-centered">
        <div class="column is-8 mt-3">
            <form method="POST" action="verAsistentes">
                <div class="card">
                    <div class="card-header has-background-primary ">
                        <span class="card-header-title is-centered">Resumen Asistentes</span>
                    </div>
                    <div class="card-content">
                        <div class="field">
                            <label class="label has-text-centered" for="estado-select">Filtro Asistentes</label>
                            <div class="control">
                                <div  align="center">
                                    <div class="select">
                                        <select name="estado-select" id="estado-select">
                                            <option>Sin filtro</option>
                                            <option>Pagada</option>
                                            <option>Con Deuda</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="field">
                            <label class="label has-text-centered" for="filtro-button">Filtrar</label>
                            <div class="control">
                                <div align="center">
                                    <button type="submit" class="button is-primary">Filtrar</button>
                                </div>
                            </div>	
                        </div>
                        <div class="field">
                            <label class="label has-text-centered" for="asistentes-table">Asistentes</label>
                            <div class="control">
                                <div align="center">
                                    <table class="table is-hovered is-bordered is-fullwidth">
                                        <thead class="has-background-primary"> 
                                            <tr> 
                                                <th>Nombre Completo</th>
                                                <th>Empresa</th>
                                                <th>Region</th>
                                                <th>Estado</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="asistente" items="${asistente}">
                                                <tr>
                                                    <td>"${asistente.nombre} ${asistente.apellido}"</td>
                                                    <td>${asistente.empresa} </td>
                                                    <td>${asistente.region} </td>
                                                    <td>${asistente.estado} </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <div class="field"> 
                            <label class="label" for="numero-asistentes">Numero de Asistentes</label>
                            <li>${cantidadAsistentes}</li>
                        </div>                            
                    </div>
                </div>
            </form>
        </div>
    </div>
</main>
</body>
</html>