(function () {
    
    angular.module('caivrs').service("caivrsSearchService", ['$http', '$q', '$log', function ($http, $q, $log) {
        return {
        	getAgencyList: getAgencyList,
        	searchCaivrs: searchCaivrs
        };
 
    	this.searchResults = {};
    	var searchSubmitted;

        function getAgencyList() {
       		// return $http.get('http://Devx-hud-ea2:8080/AJSpring/rest/caivrsAuth/agencyList', {
       		// return $http.get('http://localhost:8080/AJSpring/rest/caivrsAuth/agencyList', {
        	return $http.get('http://localhost:8080/AJSpring/caivrsAuth/agencyList', {
        	// return $http.get('http://localhost:8080/caivrsAuth/agencyList', {
       			cache: true
       		})
    			.then(function (response) {
    	        	return response.data;
    	        })
    			.catch(function (response) {
    	        	return $q.reject("Error getting agency list: " + response.status);
    	        });
        	
        }
        
        function searchCaivrs(data) {
        	// return $http.post('http://Devx-hud-ea2:8080/AJSpring/rest/caivrsAuth/authDetails', data)
        	// return $http.post('http://localhost:8080/AJSpring/rest/caivrsAuth/authDetails', data)
            return $http.post('http://localhost:8080/AJSpring/caivrsAuth/authDetails', data)
            // return $http.post('http://localhost:8080/caivrsAuth/authDetails', data)
        		.then(function(response) {
            		$log.debug(JSON.stringify(data, null, 2));
                	return response.data;
                })
            	.catch(function (response) {
    	        	return $q.reject("Error searching: " + response.status);
    	        });
        }
        
//        function cleanSSN(data, headerGetter) {    
//        	$log.debug(JSON.stringify(data, null, 2));
//            data.caivrsBorrowerList.forEach(function (item) {
//                $log.debug(item.ssn);
//                item.ssn = item.ssn.replace(/[-]/g, '');
//            });	
//            
//            return data;
//        }
        
    }]);

}());