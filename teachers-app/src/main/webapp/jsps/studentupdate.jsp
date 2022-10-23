<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <!DOCTYPE html>
    <html lang="en">
    <head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>student update</title>
      <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/update.css">
    </head>
    <body>
      <canvas id="c"> </canvas>
      <div class="from-wraper">
        <form action="${pageContext.request.contextPath}/update-student" method="post">

          <input class="hide" hidden type="text" name="id" value="${student.id}"><br> 
          <input type="text" name="firstname" value="${student.firstname}"><br> 
          <input type="text" name="lastname" value="${student.lastname}"><br> 

          <button type="submit">Update Student</button>
        </form>
    </div>

    <script src="${pageContext.request.contextPath}/static/js/script.js"></script>
    </body>
    </html>