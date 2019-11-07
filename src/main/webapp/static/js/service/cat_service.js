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
        return $http.get(REST_SERVICE_URI + 'cats');
    }

    function createCat(cat) {
        return $http.post(REST_SERVICE_URI + 'cat', cat);
    }

    function updateCat(cat, id) {
        return $http.put(REST_SERVICE_URI + 'cat/' + id, cat);
    }

    function deleteCat(id) {
        return $http.delete(REST_SERVICE_URI + 'cat/' + id);
    }

    return factory
}]);