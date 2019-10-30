'use strict';

angular.module('myApp').controller('CatController', ['$scope', 'CatService', function ($scope, CatService) {
    var self = this;
    self.cat = {id: null, name: '', power: '', image: '', weakness: ''};
    self.cats = [];
    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;
    self.hasCat = hasCat;

    fetchCats();

    function fetchCats() {
        CatService.fetchAllCats()
            .then(function (data) {
                self.cats = data;
            }).catch(function (errResponse) {
            console.log("Error while fetching cats", errResponse);
        });
    }

    function createCat(cat) {
        CatService.createCat(cat)
            .then(fetchCats)
            .catch(function (errResponse) {
                console.error('Error while creating Super Cat', errResponse);
            });
        console.log("Super cat created!")
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
            .then(fetchCats)
            .catch(function (errResponse) {
                console.error('Error while updating cat');
            });
    }

    function remove(id) {
        CatService.deleteCat(id)
            .then(fetchCats)
            .catch(function (errResponse) {
                console.error('Error while deleting cat');
            });
    }

    function edit(id) {
        console.log('id to be edited', id);
        for (var i = 0; i < self.cats.length; i++) {
            if (self.cats[i].id === id) {
                self.cat = angular.copy(self.cats[i]);
                break;
            }
        }
    }

    function hasCat() {
        self.cats.forEach(function (cat) {
            if (cat.name === self.cat.name) {
                console.log("yes, this cat is already in the list...");
                return true;
            }
        });
        return false;
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