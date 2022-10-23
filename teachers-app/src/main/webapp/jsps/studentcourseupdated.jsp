<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <!DOCTYPE html>
    <html lang="en">
    <head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>student course updated</title>
      <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/updateddata.css">

    </head>
    <body>
      <canvas id="c"> </canvas>
      <div>
        <h1>Νέα StudentCourse data</h1>
        <p>course ${studentcourse.studentId}</p>
        <p>course ${studentcourse.courseId}</p>
      </div>
    

      <div>

        <a href="${pageContext.request.contextPath}/jsps/menu.jsp">Go back</a>
      </div>
     


      <script src="${pageContext.request.contextPath}/static/js/script.js"></script>
    </body>
    </html>