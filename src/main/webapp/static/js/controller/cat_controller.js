'use strict';

angular.module('myApp')
    .controller('CatController', ['$scope', '$log', 'CatService', function ($scope, $log, CatService) {

    var self = this;
    $scope.$log = $log;
    self.cat = {id: null, name: '', power: '', image: '', weakness: '', birthday: ''};
    self.cats = [];
    self.flash = false;
    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;
    self.setEdit = setEdit;

    fetchCats();

    function fetchCats() {
        CatService.fetchAllCats()
            .then(function (response) {
                self.cats = response.data;
            })
            .then(translateBirthday)
            .catch(function (errResponse) {
            $log.error("Error while fetching cats", errResponse);
        });
    }

    function submit() {
        if (self.cat.id === null) {
            $log.log('Saving New Super Hero Cat', self.cat);
            createCat(self.cat);
        } else {
            updateCat(self.cat, self.cat.id);
            $log.log('Cat updated with id ', self.cat.id);
        }
    }

    function createCat(cat) {
        try {
            if (catExists(cat)) {
                $log.warn("Cannot create duplicate cat in JS controller.");
                throw "A cat with this name already exists!";
            } else {
                formatBirthday();
                CatService.createCat(cat)
                    .then(fetchCats)
                    .then(reset)
                    .then(showFlash('create'))
                    .catch(function (errResponse) {
                        $log.error('Error while creating Super Cat,', errResponse);
                    });
            }
        } catch (e) {
            $log.error(e);
        }
    }

    function updateCat(cat, id) {
        CatService.updateCat(cat, id)
            .then(fetchCats)
            .then(reset)
            .then(showFlash('update'))
            .catch(function (e) {
                $log.error('Error while updating cat: ', e);
            });
    }

    function remove(id) {
        CatService.deleteCat(id)
            .then(fetchCats)
            .then(hideFlash)
            .catch(function (e) {
                $log.error('Error while deleting cat:', e);
            });
    }

    function edit(id) {
        $log.log('id to be edited', id);
        for (var i = 0; i < self.cats.length; i++) {
            if (self.cats[i].id === id) {
                self.cat = angular.copy(self.cats[i]);
                break;
            }
        }
    }

    function getOffset() {
        var offset = new Date().getTimezoneOffset() / 60;
        offset = offset < 10 ? '0' + offset : offset;
        return "T" + offset + ":00Z"
    }

    /*
     * formatBirthday ensures that a user-entered date (e.g., "2001-02-03") is sent to the server with the
     * correct timezone data (e.g., "2001-02-03T06:00Z" for a user in Texas).
     */
    function formatBirthday() {
        self.cat.birthday = self.cat.birthday + getOffset();
    }

    /*
     * birthday comes from the server as a timestamp.
     */
    function translateBirthday() {
        for (var i = 0; i < self.cats.length; i++) {
            var birthdayTimestamp = self.cats[i].birthday
            if (birthdayTimestamp !== null) {
                var birthday = new Date(birthdayTimestamp).toISOString().split('T')[0];
                self.cats[i].birthday = birthday; }
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
            weakness: '',
            birthday: ''
        }
        $scope.catForm.$setPristine();
        hideFlash();
    }

    function setEdit(id) {
        document.getElementById('formInput').focus();
        hideFlash();
        edit(id);
    }

    function showFlash(isNew) {
        return function () {
            if (!self.flash) {
                document.getElementById('success-message-async')
                    .textContent = 'You have successfully created a new Super Cat';
                document.getElementById('flash-message-async').classList.remove('hidden');
                document.getElementById('success-message-async').classList.remove('hidden');
                self.flash = true;
            }
            if (isNew === 'update') {
                document.getElementById('success-message-async')
                    .textContent = 'You have successfully updated Super Cat';
            }
        }
    }

    function hideFlash() {
        if(self.flash) {
            document.getElementById('flash-message-async').classList.add('hidden');
            document.getElementById('success-message-async').classList.add('hidden');
            self.flash = false;
        }
    }
}]);