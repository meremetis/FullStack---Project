<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
 <link rel="stylesheet"  href="${pageContext.request.contextPath}/static/js/style.css"> 
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/login.css"> 
<style>
   
</style>
<body>
    <canvas id="c"> </canvas>
    <section>
        <div class="container-fluid">
            <div class="in"></div> 
            <div class="container">
            
                <div class="row-title">
                    <h1>Login</h1>
                </div>
                
                <form action="${pageContext.request.contextPath}/login" method="POST">
                    <div class="row-input">
                        <input type="email" name="eMail" required placeholder="E-mail">
                    </div>

                    <div class="row-input">
                        <input type="password" name="password" required placeholder="Password">
                    </div>

                    <div class="row-button">
                        <button type="submit">Sign in</button>    
                    </div>

                </form>

                <!-- <div class="row text-grey">
                    <a href="#">lost your password ?</a>
                </div>

                <div class="row">
                    <p>dont have an account? <a href="#">sign up here</a></p>
                </div> -->

                <div class="error-container">
                    <c:if test="${error}">
                        <p>Log in Error</p>
                    </c:if>
                </div>
            </div>
        </div>
    </section>
    <script src="${pageContext.request.contextPath}/static/js/script.js"></script>
</body>
</html>