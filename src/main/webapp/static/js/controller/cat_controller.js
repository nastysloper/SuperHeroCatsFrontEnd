'use strict';

angular.module('myApp').controller('CatController', ['$scope', 'CatService', function ($scope, CatService) {
    var self = this;
    self.cat = {id: null, name: '', power: '', image: '', weakness: ''};
    self.cats = [];
    self.submit = submit;


    fetchAllCats();

    function fetchAllCats() {
        CatService.fetchAllCats()
        .then(function (value) {
            self.cats = value;
        },
        function (reason) {
            console.error('Error while fetching Super Hero Cats => ' + reason);
        });
    }

    function createCat(cat){
        CatService.createCat(cat)
        .then(
            fetchAllCats,
            function(errResponse){
                console.error('Error while creating Super Cat');
            }
        );
    }

    function submit() {
        if (self.cat.id === null) {
            console.log('Saving New Super Hero Cat', self.cat);
            createCat(self.cat);
        } else {
            updateCat(self.cat, self.cat.id);
            console.log('Cat updated with id ', self.cat.id);
        }
    }

    function updateCat(cat, id) {
        CatService.updateCat(cat, id)
        .then(
            fetchAllCats,
            function(errResponse) {
                console.error('Error while updating cat');
            }
        );
    }

    function deleteCat(id) {
        CatService.deleteCat(id)
        .then(
            fetchAllCats,
            function (errResponse) {
                console.error('Error while deleting cat');
            }
        );
    }

    function edit(id) {
        console.log('id to be edited', id);
        for (var i = 0; i < self.cats.length; i++) {
            if(self.cats[i].id === id) {
                self.cat = angular.copy(self.cats[i]);
                break;
            }
        }
    }

    function remove(id) {
        console.log('id to be deleted', id);
        if (self.cat.id === id) {
            reset(); // clear the form if the cat will be deleted.
        }
        deleteCat(id);
    }

    function reset() {
        self.cat = {
            id: null,
            name: '',
            power: '',
            image: '',
            weakness: ''
        }
        $scope.catForm.$setPristine();
    }
}]);