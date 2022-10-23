<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <!DOCTYPE html>
    <html lang="en">
    <head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" />
      <script rel="stylesheet" ; src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" ;></script>
      <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/search.css">
  
      <title>courses</title>
    </head>
    <body>
        <canvas id="c"> </canvas>
      <div class="pinakas table table-dark table-striped table-hover w-auto">
        <h1>Data</h1><br><br><br>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>description</th>
                    <th>teacherid</th>
                    <th>Delete</th>
                    <th>Update</th>
                </tr>
            </thead>
            <c:forEach var = "course" items ="${courses}">
                <tr>
                    <td>${course.id}</td>
                    <td>${course.description}</td>
                    <td>${course.teacherId}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/delete-course?id=${course.id}
					              &description=${course.description}&teacherId=${course.teacherId}">Delete</a>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/update-course?id=${course.id}
                        &description=${course.description}&teacherId=${course.teacherId}">Update</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>


<div class="errors">
    <div >
        <c:if test="${deleteAPIerror}">
            <p>deleteAPIerror</p>
        </c:if>
    </div>
    <div >
        <c:if test="${courseNotFound}">
            <p>courseNotFound</p>
        </c:if>
    </div>
    <div >
        <c:if test="${sqlError}">
            <p>sqlErrorupdate</p>
        </c:if>
    </div>
</div>


<script src="${pageContext.request.contextPath}/static/js/script.js"></script>
    </body>
    </html>