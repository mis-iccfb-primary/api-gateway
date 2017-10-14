'use strict'

angular.module('app.controllers')

.controller('AuthorCtrl', function($scope, AuthorService, $stateParams) {
    AuthorService.get({id:$stateParams.authorId})
    .$promise.then(function(author) {
        $scope.author = author;
    });
});