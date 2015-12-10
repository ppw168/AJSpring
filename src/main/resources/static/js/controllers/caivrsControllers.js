(function () {

    angular.module('caivrs').controller('caivrsController', ['$scope', '$location', '$log', function ($scope, $location, $log) {
        $scope.search = function () {
            $log.debug("Search!");
            $location.path("/caivrsSearch");
        };
    }]);


    angular.module('caivrs').controller('caivrsSearchController', ['$scope', '$location', '$log', 'caivrsSearchService', function ($scope, $location, $log, caivrsSearchService) {
    	if (!caivrsSearchService.searchSubmitted) {
    		initSearch();
            
    		caivrsSearchService.getAgencyList()
    			.then(function (data) {
    				$scope.agencyList = data;
    				$log.debug("Success!");
    			})
    			.catch(function (errorMsg) {
    				$log.debug('Error Message: ' + errorMsg);
    				$scope.has_error = true;
    			})
    	}
    	else {
    		$scope.searchResults = caivrsSearchService.searchResults;
    		caivrsSearchService.searchSubmitted = false;
    		$scope.alertFlag = true;
    	}
        
        $scope.onSubmit = function () {
            $scope.submitting = true;
            $log.debug("submitting!");
            $log.debug($scope.searchParams);
            
            caivrsSearchService.searchCaivrs($scope.searchParams)
            	.then(function (data) {
                    $scope.has_error = false;
                    caivrsSearchService.searchResults = data;
                    caivrsSearchService.searchSubmitted = true;
                    $log.debug("Success!");
                    $log.debug(JSON.stringify(data, null, 2));
                    $location.path("/caivrsSearchResult");
                })
            	.catch(function (errorMsg) {
                    $log.debug('Error Message: ' + errorMsg);
                    $scope.has_error = true;
                })
    		
        };

        
        $scope.search = function () {
            initSearch();
            $location.path("/caivrsSearch");
        };

        
        function initSearch() {
            $scope.searchParams = {};
            var caivrsBorrowerList = [];
            $scope.searchParams["caivrsBorrowerList"] = caivrsBorrowerList;
            $scope.searchResults = {};
            $scope.has_error = false;
            $scope.alertFlag = false;
        };

        
        $scope.hideAlert = function () {
            $scope.alertFlag = false;
        };

    }]);

}());