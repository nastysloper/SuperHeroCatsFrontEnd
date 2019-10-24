'use strict';

angular.module('myApp').controller('UserController', ['$scope', 'UserService', function ($scope, UserService) {
    var self = this;
    self.user = {id: null, username: '', email: '', image: ''};
    self.users = [];
    self.submit = submit;


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

    function createUser(user){
        UserService.createUser(user)
            .then(
                fetchAllUsers,
                function(errResponse){
                    console.error('Error while creating User');
                }
            );
    }

    function submit() {
        console.log('Saving New User', self.user);
        createUser(self.user);
    }
}]);