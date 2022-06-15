<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page isELIgnored="false"%>


<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>TODO APP</title>
</head>
<body>

<div class="jumbotron jumbotron-fluid">
    <div class="container">
        <h1 class="display-4">Welcome!</h1>
        <p class="lead">Complete Task Management Tool.</p>
    </div>
</div>

<div class="container-fluid " >
    <h1 class="text-center  text-dark display-4 ">Plan Your Day</h1>

    <c:if test="${not empty msg}">
        <div class="alert alert-success">
            <c:out value="${msg}"></c:out>
        </div>

    </c:if>

    <div class="row mt-4">
        <div class="col-md-2">
            <h3 class="text-center"></h3>
            <div class="list-group">
                <a href='<c:url value="/add" ></c:url>' class="list-group-item list-group-item-action active">
                    Add Task
                </a>
                <a href="#" class="list-group-item list-group-item-action">My Day</a>
                <a href="#" class="list-group-item list-group-item-action">Important</a>
                <a href="#" class="list-group-item list-group-item-action">Planned</a>
                <a href='<c:url value="/home"></c:url> ' class="list-group-item list-group-item-action disabled">View All</a>
            </div>
        </div>
       <div class="col-md-10  " >


               <c:if test="${page=='home'}">
                   <h3 class="text-left text-muted">All Task</h3>

                            <c:forEach items="${todos}" var="t">
                                <div class="card">

                                    <div class="card-body">
                                        <h3><c:out value="${t.title}"></c:out> </h3>
                                        <p><c:out value="${t.description}"></c:out></p>
                                        <p><c:out value="${t.date}"></c:out></p>
                                    </div>
                                </div>
                                <br>
                            </c:forEach>



               </c:if>
                <c:if test="${page=='add'}">
                    <h3 class="text-left text-muted">Add Task</h3>

                    <form:form action="saveTodo" method="post" modelAttribute="AddTodo">

                        <div class="form-group">
                            <form:input path="title" cssClass="form-control" placeholder="Enter ToDo title"/>
                        </div>

                        <div class="form-group">
                            <form:textarea path="description" cssClass="form-control" placeholder="Enter ToDo Description"/>
                        </div>
                        <div class="p-0 m-0 text-left container ">
                            <button class="btn btn-outline-primary">Save</button>
                        </div>

                    </form:form>

                </c:if>

       </div>
    </div>
</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>