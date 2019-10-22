<html lang="en-US">
<head>
    <title>AngularJS + Spring MVC</title>
    <meta charset="UTF-8">
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
    <script src='${pageContext.request.contextPath}/static/js/app.js'></script>
    <script src='${pageContext.request.contextPath}/static/js/service/user_service.js'></script>
    <script src='${pageContext.request.contextPath}/static/js/controller/user_controller.js'></script>

    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
</head>
<body ng-app="myApp" ng-controller="UserController as ctrl">
<h2>Cat Collection App</h2>
<div>
    <img ng-src="https://placekitten.com/98/139">
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Image</th>
            <th width="20%"></th>
        </tr>
        </thead>
        <tbody>
        <tr ng-repeat="u in ctrl.users">
            <td ng-bind="u.id"></td>
            <td ng-bind="u.name"></td>
            <td ng-bind="u.email"></td>
            <td><img ng-src="{{u.image}}"></td>
            <td>
                <button>Edit</button><button>Delete</button>
            </td>
        </tr>
        </tbody>
    </table>
    <form action="/totempole_war_exploded/createUser" name="User" method="POST">
        ID:<input type="text" id="id" name="id"><br>
        Name:<input type="text" id="name" name="name"><br>
        Email:<input type="text" id="email" name="email"><br>
        Photo URL:<input type="text" id="image" name="image"><br>
        <button type="submit">Create</button>
    </form>
    <form ng-submit="submit()" ng-controller="UserController">
        ID:<input type="text"><br>
        Name:<input type="text" ng-model="name"/><br>
        Email:<input type="text" ng-model="email"><br>
        Photo URL:<input type="text" ng-model="image"><br>
        <button type="submit">Create</button>
    </form>
</div>
</body>
</html>