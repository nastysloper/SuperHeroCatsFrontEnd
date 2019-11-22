'use strict';

angular.module('myApp').factory('CatService', ['$http', function ($http) {
    // update this to hit the controller
    var CONTROLLER_URI = "http://localhost:8085/super_cats_war_exploded/";

    var factory = {
        fetchAllCats: fetchAllCats,
        createCat: createCat,
        updateCat: updateCat,
        deleteCat: deleteCat
    };

    function fetchAllCats() {
        return $http.get(CONTROLLER_URI + 'cats');
    }

    function createCat(cat) {
        return $http.post(CONTROLLER_URI + 'cat', cat);
    }

    function updateCat(cat, id) {
        return $http.put(CONTROLLER_URI + 'cat/' + id, cat);
    }

    function deleteCat(id) {
        return $http.delete(CONTROLLER_URI + 'cat/' + id);
    }

    return factory
}]);