'use strict';

angular.module('myApp').factory('CatService', ['$http', function ($http) {
    var REST_SERVICE_URI = "http://localhost:8080/totempole_war_exploded/";

    var factory = {
        fetchAllCats: fetchAllCats,
        createCat: createCat,
        updateCat: updateCat,
        deleteCat: deleteCat
    };

    function fetchAllCats() {
        return $http.get(REST_SERVICE_URI + 'cats')
            .then(function (response) {
                return response.data;
            }).catch(function (errResponse) {
                console.error('Error while fetching cats');
            });
    }

    function createCat(cat) {
        return $http.post(REST_SERVICE_URI + 'add', cat)
            .then(function (response) {
                return response.data;
            }).catch(function (err) {
                console.error('Error while creating Cat:', err);
            });
    }

    function updateCat(cat, id) {
        return $http.put(REST_SERVICE_URI + 'cat/' + id, cat)
            .then(function (response) {
                return (response.data);
            }).catch(function (err) {
                console.error('Error while updating Cat', err);
            });
    }

    function deleteCat(id) {
        return $http.delete(REST_SERVICE_URI + 'cat/' + id)
            .then(function (response) {
                return response.data;
            }).catch(function (err) {
                console.error('Error while deleting Cat');
            });
    }

    return factory
}]);