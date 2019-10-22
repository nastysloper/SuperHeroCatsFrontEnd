'use strict';

angular.module('myApp').factory('UserService', ['$http', '$q', function($http, $q) {
    var REST_SERVICE_URI = "http://localhost:8080/totempole_war_exploded/users";

    var factory = {
        fetchAllUsers: fetchAllUsers,
        createNewUser: createNewUser
    };

    function fetchAllUsers() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(function (response) {
                deferred.resolve(response.data);
            },
            function (errResponse) {
                console.error('Error while fetching users');
                deferred.reject(errResponse);
            });
        return deferred.promise;
    }

    function createNewUser(name, email, image) {
        console.log("js user service creating new user...");
        var data = {
            name: name,
            email: email,
            image: image
        }

        var config = {
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
            }
        }

        $http.post("http://localhost:8080/totempole_war_exploded/createUser", data, config)
            .success(function(data, status, headers, config) {
                console.log("success achieved");
            })
            .error(function(data, status, header, config) {
                console.log("crash and burn");
            });


    }

    return factory
}]);