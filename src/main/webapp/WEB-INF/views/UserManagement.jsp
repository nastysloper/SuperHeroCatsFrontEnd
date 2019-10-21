<html lang="en-US">
    <head>
        <title>AngularJS + Spring MVC</title>
        <meta charset="UTF-8">
    </head>
    <body ng-app="myApp">
        <h2>Spring + Angular</h2>
        <button>Fetch Users</button>
        <div>
            <table>
                <thead>
                <tr>
                    <th>ID.</th>
                    <th>Name</th>
                    <th>Address</th>
                    <th>Email</th>
                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="u in ctrl.users">
                    <td><span ng-bind="u.id"></span></td>
                    <td><span ng-bind="u.username"></span></td>
                    <td><span ng-bind="u.address"></span></td>
                    <td><span ng-bind="u.email"></span></td>
                    <td>
                        <button>Edit</button><button>Delete</button>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>

        <script src='/static/js/app.js'></script>
        <script src='/static/js/service/user_service.js'></script>
        <script src='/static/js/controller/user_controller.js'></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
    </body>
</html>