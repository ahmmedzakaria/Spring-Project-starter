<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en-US">
    <head>
        <meta charset="UTF-8" /> 
        <title> Faculty </title>
    </head>
    <body ng-app="myApp">
        <div ng-controller="FacultyController as objCtrl">
            <h1> Faculty Info </h1>
            <form name="objForm" method="POST">
                <table>
                    <tr><td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <h3> Add New Faculty </h3> 
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <h3> Update Faculty for ID: {{ objCtrl.obj.facultyId}} </h3> 
                            </div> </td>
                    </tr>
                    <tr>
                        <td>Tsp Name</td>
                        <td>
                            <select ng-model="objCtrl.obj.tspInfo" ng-options="x.tspName for x in names">
</select>
                        </td>
                    </tr>
                    <tr>
                        <td>Faculty Code: </td> <td><input type="text" name="facultyCode" ng-model="objCtrl.obj.facultyCode" required/> 
                            <span ng-show="objForm.facultyCode.$error.required" class="msg-val">Faculty Code is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Faculty Name: </td> <td><input type="text" name="facultyName" ng-model="objCtrl.obj.facultyName" required/> 
                            <span ng-show="objForm.facultyName.$error.required" class="msg-val">Faculty Name is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Email: </td> <td> <input type="text" name="facultyEmail" ng-model="objCtrl.obj.facultyEmail" required/> 
                            <span ng-show="objForm.facultyEmail.$error.required" class="msg-val">Email is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Phone: </td> <td> <input type="text" name="facultyPhone" ng-model="objCtrl.obj.facultyPhone" required/> 
                            <span ng-show="objForm.facultyPhone.$error.required" class="msg-val">Phone is required.</span> </td>
                    </tr>


                    <tr>
                        <td colspan="2"> <span ng-if="objCtrl.flag == 'created'" class="msg-success">Faculty successfully added.</span>
                            <span ng-if="objCtrl.flag == 'failed'" class="msg-val">Faculty already exists.</span> </td>
                    </tr>
                    <tr><td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <input  type="submit" ng-click="objCtrl.addObject()" value="Add Faculty"/> 
                                <input type="button" ng-click="objCtrl.reset()" value="Reset"/>
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <input  type="submit" ng-click="objCtrl.updateObjectDetail()" value="Update Faculty"/> 	
                                <input type="button" ng-click="objCtrl.cancelUpdate()" value="Cancel"/>				   
                            </div> </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="objCtrl.flag == 'deleted'" class="msg-success">Faculty successfully deleted.</span>
                    </tr>
                </table>     
            </form>
            <table>
                <tr><th>ID </th> 
                    <th>Tsp Name</th> 
                    <th>Faculty Code</th> 
                    <th>Faculty Name</th>
                    <th>Email</th>
                    <th>Location</th></tr>
                <tr ng-repeat="row in objCtrl.objArray">
                    <td><span ng-bind="row.facultyId"></span></td>
                    <td><span ng-bind="row.tspInfo.tspName"></span></td>
                    <td><span ng-bind="row.facultyCode"></span></td>
                    <td><span ng-bind="row.facultyName"></span></td>
                    <td><span ng-bind="row.facultyEmail"></span></td>
                    <td><span ng-bind="row.facultyPhone"></span></td>
                    <td>
                        <input type="button" ng-click="objCtrl.deleteObject(row.facultyId)" value="Delete"/>
                        <input type="button" ng-click="objCtrl.editObject(row.facultyId)" value="Edit"/>
                        <span ng-if="objCtrl.flag == 'updated' && row.facultyId == objCtrl.updatedId" class="msg-success">Faculty successfully updated.</span> </td> 
                </tr>	
<!--                <tr ng-repeat="row in objCtrl.objArray2">
                    <td><span ng-bind="row.tspName"></span></td>
                    
                </tr>-->
            </table>
        </div>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular-resource.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/app.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/controller/faculty_controller.js"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css"/>
    </body>
</html> 