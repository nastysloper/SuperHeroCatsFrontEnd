'use strict';

angular.module('myApp').factory('CatService', ['$http', '$q', function($http, $q) {
    var REST_SERVICE_URI = "http://localhost:8080/totempole_war_exploded/cat/";

    var factory = {
        fetchAllCats: fetchAllCats,
        createCat: createCat,
        updateCat: updateCat,
        deleteCat: deleteCat
    };

    function fetchAllCats() {
        return $http.get(REST_SERVICE_URI)
            .then(function (response) {
                return response.data;
            })
                .catch(function (errResponse) {
                console.error('Error while fetching cats');
            });

    }

    function createCat(cat) {
        $http.post(REST_SERVICE_URI, cat)
            .then(
                function (response) {
                    return response.data;
                },
                function(errResponse){
                    console.error('Error while creating Cat');
                }
            );
    }

    function updateCat(cat, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+id, cat)
        .then(function(response) {
            deferred.resolve(response.data);
        },
        function(errResponse) {
            console.error('Error while updating Cat');
            deferred.reject(errResponse);
        });
        return deferred.promise;
    }

    function deleteCat(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+id)
            .then(function(response) {
                deferred.resolve(response.data);
            },
            function(errResponse) {
            console.error('Error while deleting Cat');
            deferred.reject(errResponse);
            });
        return deferred.promise;
    }

    return factory
}]);