<%-- 
    Document   : index
    Created on : Jan 23, 2018, 2:37:11 AM
    Author     : Faculty
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
    <script src="<c:url value='/static/js/app.js' />"></script>
    <!--<script src="<c:url value='/static/js/service/user_service.js' />"></script>-->
    <script src="<c:url value='/static/js/controller/user_controller.js' />"></script>
    <body>

        <div ng-app="myApp" ng-controller="myCtrl">

            <select ng-model="selectedName" ng-options="x for x in names">
            </select>

        </div>

        <!--        <script>
                    var app = angular.module('myApp', []);
                    app.controller('myCtrl', function ($scope) {
                        $scope.names = ["Emil", "Tobias", "Linus"];
                    });
                </script>-->

        <p>This example shows how to fill a dropdown list using the ng-options directive.</p>
        <a href="info/home">Go to person</a>
    </body>
</html>

