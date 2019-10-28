'use strict';

angular.module('myApp').factory('CatService', ['$http', '$q', function($http, $q) {
    var REST_SERVICE_URI = "http://localhost:8080/totempole_war_exploded/cat";

    var factory = {
        fetchAllCats: fetchAllCats,
        createCat: createCat
    };

    function fetchAllCats() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(function (response) {
                deferred.resolve(response.data);
            },
            function (errResponse) {
                console.error('Error while fetching cats');
                deferred.reject(errResponse);
            });
        return deferred.promise;
    }

    function createCat(cat) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, cat)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Error while creating Cat');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }

    return factory
}]);