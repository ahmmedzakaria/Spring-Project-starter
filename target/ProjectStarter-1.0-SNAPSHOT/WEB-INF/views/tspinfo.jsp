<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en-US">
    <head>
        <meta charset="UTF-8" /> 
        <title> Spring MVC 4 REST + AngularJS </title>
    </head>
    <body ng-app="myApp">
        <div ng-controller="TspController as objCtrl">
            <h1> TSP Info </h1>
            <form name="objForm" method="POST">
                <table>
                    <tr><td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <h3> Add New Tsp </h3> 
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <h3> Update Tsp for ID: {{ objCtrl.obj.tspId}} </h3> 
                            </div> </td>
                    </tr>
                    <tr>
                        <td>Tsp Name: </td> <td><input type="text" name="tspName" ng-model="objCtrl.obj.tspName" required/> 
                            <span ng-show="objForm.tspName.$error.required" class="msg-val">Name is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Address: </td> <td> <input type="text" name="tspAddress" ng-model="objCtrl.obj.tspAddress" required/> 
                            <span ng-show="objForm.tspAddress.$error.required" class="msg-val">Address is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Phone: </td> <td> <input type="text" name="tspPhone" ng-model="objCtrl.obj.tspPhone" required/> 
                            <span ng-show="objForm.tspPhone.$error.required" class="msg-val">Phone is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Email: </td> <td> <input type="text" name="tspEmail" ng-model="objCtrl.obj.tspEmail" required/> 
                            <span ng-show="objForm.tspEmail.$error.required" class="msg-val">Email is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Location: </td> <td> <input type="text" name="tspLocation" ng-model="objCtrl.obj.tspLocation" required/> 
                            <span ng-show="objForm.tspLocation.$error.required" class="msg-val">Location is required.</span> </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="objCtrl.flag == 'created'" class="msg-success">Tsp successfully added.</span>
                            <span ng-if="objCtrl.flag == 'failed'" class="msg-val">Tsp already exists.</span> </td>
                    </tr>
                    <tr><td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <input  type="submit" ng-click="objCtrl.addObject()" value="Add Tsp"/> 
                                <input type="button" ng-click="objCtrl.reset()" value="Reset"/>
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <input  type="submit" ng-click="objCtrl.updateObjectDetail()" value="Update Tsp"/> 	
                                <input type="button" ng-click="objCtrl.cancelUpdate()" value="Cancel"/>				   
                            </div> </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="objCtrl.flag == 'deleted'" class="msg-success">Tsp successfully deleted.</span>
                    </tr>
                </table>     
            </form>
            <table>
                <tr><th>ID </th> <th>Name</th> <th>Location</th></tr>
                <tr ng-repeat="row in objCtrl.objArray">
                    <td><span ng-bind="row.tspId"></span></td>
                    <td><span ng-bind="row.tspName"></span></td>
                    <td><span ng-bind="row.tspAddress"></span></td>
                    <td><span ng-bind="row.tspPhone"></span></td>
                    <td><span ng-bind="row.tspEmail"></span></td>
                    <td><span ng-bind="row.tspLocation"></span></td>
                    <td>
                        <input type="button" ng-click="objCtrl.deleteObject(row.tspId)" value="Delete"/>
                        <input type="button" ng-click="objCtrl.editObject(row.tspId)" value="Edit"/>
                        <span ng-if="objCtrl.flag == 'updated' && row.tspId == objCtrl.updatedId" class="msg-success">Tsp successfully updated.</span> </td> 
                </tr>	
            </table>
        </div>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular-resource.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/app.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/controller/tsp_info_controller.js"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css"/>
    </body>
</html> 