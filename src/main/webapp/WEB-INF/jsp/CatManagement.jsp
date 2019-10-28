<html lang="en-US">
<head>
    <title>AngularJS + Spring MVC</title>
    <meta charset="UTF-8">
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
    <script src='${pageContext.request.contextPath}/static/js/app.js'></script>
    <script src='${pageContext.request.contextPath}/static/js/service/cat_service.js'></script>
    <!-- The controller has a dependency on the Cat Service -->
    <script src='${pageContext.request.contextPath}/static/js/controller/cat_controller.js'></script>
    <link href="https://fonts.googleapis.com/css?family=Nunito&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">
    <link rel="icon" href="favicon.ico">
</head>
<body ng-app="myApp" ng-controller="CatController as ctrl">
<h2 class="title">Super Hero Cat App</h2>
<h3 class="title">The Place Where Cats Save The Day... Every Day</h3>
<div>
    <table>
        <thead>
        <tr>
            <th>Pic</th>
            <th>ID</th>
            <th>Name</th>
            <th>Super Power</th>
            <th>Weakness</th>
            <th width="20%"></th>
        </tr>
        </thead>
        <tbody>
        <tr ng-repeat="c in ctrl.cats">
            <td><img ng-src="{{c.image}}"></td>
            <td ng-bind="c.id"></td>
            <td ng-bind="c.name"></td>
            <td ng-bind="c.power"></td>
            <td ng-bind="c.weakness"></td>
            <td>
                <button>Edit</button><button>Delete</button>
            </td>
        </tr>
        </tbody>
    </table>
    <h2>Add New Super Hero Cat</h2>
    <!-- synchronous submit. remove after phase 1 -->
    <form action="/totempole_war_exploded/createCat" name="User" method="POST">
        <h3>Synchronous Submit</h3>
        <div>Photo URL:<input type="text" id="image" name="image"></div><br>
        <div>Name:<input type="text" id="name" name="name"></div><br>
        <div>Power:<input type="text" id="power" name="power"></div><br>
        <div>Weakness:<input type="text" id="weakness" name="weakness"></div><br>
        <button type="submit">Create</button>
    </form>
    <form ng-submit="ctrl.submit()">
        <h3>Async Submit</h3>
        <div>Photo URL:<input type="text" ng-model="ctrl.cat.image"></div><br>
        <div>Name:<input type="text" ng-model="ctrl.cat.name"/></div><br>
        <div>Power:<input type="text" ng-model="ctrl.cat.power"></div><br>
        <div>Weakness:<input type="text" ng-model="ctrl.cat.weakness"></div><br>
        <button type="submit">Create</button>
    </form>
</div>
</body>
</html>