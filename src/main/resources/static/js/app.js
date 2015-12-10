(function () {

    var app = angular.module('caivrs', ['ngRoute', 'ngAnimate', 'ui.mask']);

    app.config(['$routeProvider', '$httpProvider', '$logProvider', function ($routeProvider, $httpProvider, $logProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'caivrs/home.html',
                controller: 'caivrsController'
            })
            .when('/caivrsSearch', {
                templateUrl: 'caivrs/search.html',
                controller: 'caivrsSearchController'
            })
            .when('/caivrsSearchResult', {
                templateUrl: 'caivrs/result.html',
                controller: 'caivrsSearchController'
            })
            .otherwise('/');
        
        $httpProvider.defaults.useXDomain = true;
        
        $logProvider.debugEnabled(false);
    }]);

    
    app.filter('ssnFilter', function () {
        return function (value) {
            if (value != null) {
                val = value.replace(/[-]/g, '');
                len = val.length;
                if (len < 4)
                    return val;
                else if (len < 6)
                    return val.substr(0, 3) + '-' + val.substr(3);
                else if (len > 5)
                    return val.substr(0, 3) + '-' + val.substr(3, 2) + '-' + val.substr(5, 4);
            }
        }

    });

}());


$(document).on('click', '.navbar-collapse.in', function (e) {
    if (($(e.target).is('a') || $(e.target).is('span')) && $(e.target).attr('class') != 'dropdown-toggle') {
        $(this).collapse('hide');
    }
});