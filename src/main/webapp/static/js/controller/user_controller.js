'use strict';

angular.module('myApp').controller('UserController', ['$scope', 'UserService', function ($scope, UserService) {
    var self = this;
    self.user = {id: null, username: '', email: ''};
    self.users = [];
    self.richString = "getRich called successfully";
    self.two = "Twosome";
    self.local = fetchBarUser();
    self.service = UserService.fetchServiceUser();

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

    function fetchBarUser() {
        return "foo bar";
    }
}]);