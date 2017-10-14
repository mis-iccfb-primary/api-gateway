'use strict'

angular.module('app.services')

.factory('AuthorService', function($resource) {
    return $resource('/api/author/:id', {id:'@_id'});
});
