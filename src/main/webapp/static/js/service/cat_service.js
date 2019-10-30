'use strict';

angular.module('myApp').factory('CatService', ['$http', '$q', function ($http, $q) {
    var REST_SERVICE_URI = "http://localhost:8080/totempole_war_exploded/";
    var ALL_CATS = "http://localhost:8080/totempole_war_exploded/cats";

    var factory = {
        fetchAllCats: fetchAllCats,
        createCat: createCat,
        updateCat: updateCat,
        deleteCat: deleteCat
    };

    function fetchAllCats() {
        return $http.get(ALL_CATS)
            .then(function (response) {
                return response.data;
            }).catch(function (errResponse) {
                console.error('Error while fetching cats');
            });

    }

    function createCat(cat) {
        return $http.post(REST_SERVICE_URI, cat)
            .then(function (response) {
                return response.data;
            }).catch(function (err) {
                console.error('Error while creating Cat:', err);
            });
    }

    function updateCat(cat, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI + id, cat)
            .then(function (response) {
                    deferred.resolve(response.data);
                },
                function (errResponse) {
                    console.error('Error while updating Cat');
                    deferred.reject(errResponse);
                });
        return deferred.promise;
    }

    function deleteCat(id) {
        $http.delete(REST_SERVICE_URI + 'remove/' + id)
            .then(function (response) {
                return (response.data);
            }).catch(function (err) {
            console.error('Error while deleting Cat');
        });
    }

    return factory
}]);