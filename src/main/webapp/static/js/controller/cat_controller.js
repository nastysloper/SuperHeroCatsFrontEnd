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
        console.log('Saving New Super Hero Cat', self.cat);
        createCat(self.cat);
    }
}]);