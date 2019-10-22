'use strict';

angular.module('myApp').controller('UserController', ['$scope', 'UserService', function ($scope, UserService) {
    var self = this;
    self.user = {id: null, username: '', email: '', image: ''};
    self.users = [];
    $scope.submit = function() {
        console.log("form has been submitted...");
        UserService.createNewUser($scope.name, $scope.email, "https://placekitten.com/96/139");
        console.log(self.users);
        console.log($scope.name);
        console.log($scope.email);
        console.log($scope.image);
        //self.users.push({ id: 4, name: $scope.name, email: $scope.email, image: "https://placekitten.com/96/139"});
        console.log(self.users);
    };

    fetchAllUsers();

    function fetchAllUsers() {
        UserService.fetchAllUsers()
            .then(function (value) {
                self.users = value;
            },
            function (reason) {
                console.error('Error while fetching users => ' + reason);
            });
    }
}]);