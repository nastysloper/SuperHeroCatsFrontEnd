<html lang="en-US">
<head>
    <title>AngularJS + Spring MVC</title>
    <meta charset="UTF-8">
    <link href="https://fonts.googleapis.com/css?family=Nunito&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">
    <link rel="icon" href="${pageContext.request.contextPath}/static/images/favicon.ico">
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
            <td><!-- ctrl.edit(c.id) -->
                <button name="edit" ng-click="ctrl.setEdit(c.id)">Edit</button>
                <button name="delete" ng-click="ctrl.remove(c.id)">Delete</button>
            </td>
        </tr>
        </tbody>
    </table>
    <h2>Add New Super Hero Cat</h2>
    <div class="flash-message-sync hidden">
        <h3 class="success-message-sync hidden">Success! Your Super Cat has been created.</h3>
    </div>
    <form action="/totempole_war_exploded/createCat" name="Cat" method="POST">
        <h3>Synchronous Submit</h3>
        <div><label for="image">Photo URL:<input type="text" id="image" name="image"></label></div><br>
        <div><label for="name">Name <span class="required">(required)</span>:<input type="text" id="name" name="name" required></label></div><br>
        <div><label for="power">Power:<input type="text" id="power" name="power"></label></div><br>
        <div><label for="weakness">Weakness:<input type="text" id="weakness" name="weakness"></label></div><br>
        <input type="submit" value="Submit" />
    </form>
    <div id="flash-message hidden">
        <h3 id="success-message hidden">Success! Your Super Cat has been created.</h3>
    </div>
    <form name="catForm" ng-submit="ctrl.submit()">
        <h3>Async Submit</h3>
        <div><label for="image">Photo URL:</label><input type="text" ng-model="ctrl.cat.image" name="image"></div><br>
        <div><label for="name">Name <span class="required">(required)</span>:</label><input type="text" ng-model="ctrl.cat.name" name="name" required></div><br>
        <div><label for="power">Power:</label><input type="text" id="formInput" ng-model="ctrl.cat.power" name="power"></div><br>
        <div><label for="weakness">Weakness:</label><input type="text" ng-model="ctrl.cat.weakness" name="weakness"></div><br>
        <input type="submit" value="{{ctrl.cat.id ? 'Update' : 'Create'}}" />
        <input type="submit" ng-click="ctrl.reset()" value="Clear" />
    </form>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
<script src='${pageContext.request.contextPath}/static/js/app.js'></script>
<script src='${pageContext.request.contextPath}/static/js/service/cat_service.js'></script>
<script src='${pageContext.request.contextPath}/static/js/controller/cat_controller.js'></script>
</body>
</html>