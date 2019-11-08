'use strict';

angular.module('myApp').controller('CatController', ['$scope', 'CatService', function ($scope, CatService) {
    var self = this;
    self.cat = {id: null, name: '', power: '', image: '', weakness: ''};
    self.cats = [];
    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;
    self.setEdit = setEdit;

    fetchCats();

    function fetchCats() {
        CatService.fetchAllCats()
            .then(function (response) {
                console.log(response.data);
                self.cats = response.data;
            }).catch(function (errResponse) {
            console.log("Error while fetching cats", errResponse);
        });
    }

    function createCat(cat) {
        try {
            if (catExists(cat)) {
                console.log("Cannot create duplicate cat in JS controller.");
                throw "A cat with this name already exists!";
            } else {
                CatService.createCat(cat)
                    .then(fetchCats)
                    .then(reset)
                    .then(flashSuccess)
                    .catch(function (errResponse) {
                        console.error('Error while creating Super Cat,', errResponse);
                    });
            }
        } catch (e) {
            console.error(e);
        }
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
            .then(reset)
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

    function catExists(cat) {
        for (var i = 0; i < self.cats.length; i++) {
            if (cat.name === self.cats[i].name) {
                return true;
            }
        }
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

    function setEdit(id) {
        document.getElementById('formInput').focus();
        edit(id);
    }

    function flashSuccess() {
        document.getElementById('formInput').focus();
    }
}]);