'use strict';

angular.module('myApp').controller('CatController', ['$scope', 'CatService', function ($scope, CatService) {
    var self = this;
    self.cat = {id: null, name: '', power: '', image: '', weakness: ''};
    self.cats = [];
    self.submit = submit;

    fetchCats();

    function fetchCats() {
        CatService.fetchAllCats()
            .then(function (data) {
                self.cats = data;
            }, function (error) {
                console.log(error);
            });
    }

    function createCat(cat) {
        CatService.createCat(cat)
            .then(
                fetchCats,
                function (errResponse) {
                    console.error('Error while creating Super Cat');
                }
            );
    }

    function submit() {
        console.log('Saving New Super Hero Cat', self.cat);
        createCat(self.cat);
    }
}]);