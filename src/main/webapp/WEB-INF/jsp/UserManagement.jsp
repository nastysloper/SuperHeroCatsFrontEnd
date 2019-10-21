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
<h2>A Fresh New Take On Spring + Angular</h2>
<button>Fetch Users</button>
<div>
    <h2 ng-bind="ctrl.richString">1</h2>
    <h2 ng-bind="ctrl.two"></h2>
    <h2 ng-bind="ctrl.local"></h2>
    <h2 ng-bind="ctrl.service"></h2>
    <img src="https://images.pexels.com/photos/127028/pexels-photo-127028.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500">
    <img src="${pageContext.request.contextPath}/static/images/cat-1.jpg">
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Address</th>
            <th>Email</th>
            <th width="20%"></th>
        </tr>
        </thead>
        <tbody>
        <tr ng-repeat="u in ctrl.users">
            <td ng-bind="u.id"></td>
            <td ng-bind="u.username"></td>
            <td ng-bind="u.address"></td>
            <td ng-bind="u.email"></td>
            <td>
                <button>Edit</button><button>Delete</button>
            </td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>