'use strict';

angular.module('myApp').controller('CatController', ['$scope', 'CatService', function ($scope, CatService) {
    var self = this;
    self.cat = {id: null, name: '', power: '', image: '', weakness: ''};
    self.cats = [];
    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;

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

    function edit(id) {
        console.log("ID to be edited is " + id);
    }

    function remove(id) {
        console.log("ID to be removed is " + id);
    }

    function reset() {
        self.user = {
            id: null,
            name: '',
            power: '',
            image: '',
            weakness: ''
        };
        $scope.catForm.$setPristine();
    }
}]);