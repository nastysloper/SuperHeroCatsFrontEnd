'use strict';

angular.module('myApp').factory('UserService', ['$http', '$q', function($http, $q) {
    var REST_SERVICE_URI = "http://localhost:8080/totempole_war_exploded/user/";

    var factory = {
        fetchAllUsers: fetchAllUsers,
        fetchServiceUser: fetchServiceUser
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

    function fetchServiceUser() {
        return 'Service User Returned';
    }

    return factory
}]);