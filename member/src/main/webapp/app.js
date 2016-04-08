//var app = angular.module('app', ['imageupload']);
//var app = angular.module('app', []);
/*
var app = angular.module('app').run(['$rootScope', '$http', function($rootScope, $http) {
    $rootScope.$on("$routeChangeStart", function (event, next, current) {
        if (!$rootScope.myBooleanProperty)) {
            $location.path('/');
        }
        else {
            $location.path('/page');
        }
    });
});
*/
var app = angular.module( "app", [ ] );

app.config( function( $routeProvider ) {
  $routeProvider
     .when( "/", 
    		 {
			    templateUrl: "index.jsp",
			    controller: "MainController"
			  } )
      .when("/login", {
    	  templateUrl: "login.jsp",
    	  controller: "LoginController"
      })
      .otherwise({redirectTo: '/login'});
} );

app.factory( "accommodation", function( ) {
  return {
    hotelName: function( ) {
      return "Some Hotel";
    },
    roomNo: function( ) {
      return "203";
    }
  };
} );

/*
//var app = angular.module('app', ['ngRoute'], function($routeProvider) {
var app = angular.module( "app", [ ] , function( $routeProvider ) {
  $routeProvider.when( "/", {
    templateUrl: "index.jsp",
    controller: "MainController",
    resolve: {
      myFriendsHotel: function( ) {
        return {
          hotelName: function( ) {
            return "My Friend's hotel";
          },
          roomNo: function( ) {
            return "100";
          }
        };
      }
    }
  });
} );
*/
/*
var app = angular.module('app', ['ngRoute']);
app.config(function($routeProvider){
	 console.log("app config1");           
    $routeProvider.when('/', {
        templateUrl: 'index.jsp',
        controller: 'MainController',
        resolve: {
            "myFriendsHotel": function( ) {
              return {
                hotelName: function( ) {
                  return "My Friend's hotel";
                },
                roomNo: function( ) {
                  return "100";
                }
              };
            }
          }
      
    });
    console.log("app config2"); 
});
*/
/*
app.factory( "accommodation", function($http,$timeout ) {
	  return {
		  connectInfo : function(scope) {
  	    	$timeout(function(){
	  	        return $http({
	  	            method: 'GET', 
	  	            url: 'resources/connection.properties'
	  	        });
  	    	}, 10000);
  	       return "--";
  	    }
	    
	  };
	} );

*/

/*
MainController.resolve = {
	    datasets : function($http) {
	        return $http({
	            method: 'GET', 
	            url: 'resources/connection.properties'
	        });
	    }
	};
*/
/*
function MainController($scope, datasets) {    
    $scope.datasets = datasets;
};​
*/
app.factory('aProvider', function() {
	   console.log("factory");
	});
   /*
	app.directive("test1", function() {
	    console.log("directive setup");
	    return {
	        compile: function() {console.log("directive compile");}
	    }
	});

	app.directive("test2", function() {
	    return {
	        link: function() {console.log("directive link");}
	    }
	});
    */ /*
	app.run(function() {
	    console.log("app run");
	});
    */
/*
	app.config( function() {
	    console.log("app config");
	});
	 */
	
/*
app.run(['$http', '$rootScope', function($http, $rootScope) {
	  console.log("app.run()");
	// $rootScope.$on("$routeChangeStart", function (event, next, current) {
		$http.get('resources/connection.properties').then(function (response) {
	    	$rootScope.host = response.data.host;
	    	$rootScope.uri = response.data.uri;
	        console.log("HOST1: " + $rootScope.uri);
	     });
	// });

}]);
*/
app.constant('config', {
    appName: 'dongnan',
   
   // host: "http://localhost",    
   // uri: "http://localhost/memberws"
    	
    //  host: "http://new1step.com",    
    //  uri: "http://new1step.com/memberws"
   // appVersion: 2.0,
   // apiUrl: ‘http://www.google.com?api’
});

app.directive('fileModel', ['$parse', function ($parse) {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;
            
            element.bind('change', function(){
                scope.$apply(function(){
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
}]);

/*
app.directive('validateEmail', function() {
	  var EMAIL_REGEXP = /^[_a-z0-9]+(\.[_a-z0-9]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,4})$/;

	  return {
	    require: 'ngModel',
	    restrict: '',
	    link: function(scope, elm, attrs, ctrl) {
	      // only apply the validator if ngModel is present and Angular has added the email validator
	      if (ctrl && ctrl.$validators.email) {

	        // this will overwrite the default Angular email validator
	        ctrl.$validators.email = function(modelValue) {
	          return ctrl.$isEmpty(modelValue) || EMAIL_REGEXP.test(modelValue);
	        };
	      }
	    }
	  };
	});
*/

app.service('fileUploadService', ['$http', function ($http) {
	var location = "";
	//-----------------
	var observers = [];
	this.registerObserver = function(observer){		
		observers.push(observer);		
	}
	var nortifyAllObservers = function(){		
		for(var index=0; index <observers.length; ++index){			
			observers[index].update();
		}
	}
	
	this.uploadLocation = function(){		
    	return location;
    }
	//----------------------
	
	// this function set location data
    this.uploadFileToUrl = function(file, uploadUrl, appName, memId, host){
        var fd = new FormData();
        fd.append(appName+"_"+memId, file);        
        var response = $http.post(uploadUrl, fd, { 
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        });
        response.success(function(data, status, headers, config) { 
        	location = host + data.uploadInfos[0].location;        	
        	console.log("[upload] location: " + location);  
        	nortifyAllObservers();
        });     
        response.error(function(data, status, headers, config) {
        	location = "系统出错: AJAX failed to upload file, status=" + status;
        	nortifyAllObservers();
          //  alert("系统出错: AJAX failed to upload file, status=" + status);
        }); 
    }
    
}]);

/*
app.service('ConnectionService', ['$http', function ($http) {
		var promise = $http.get('resources/connection.properties').then(function (response) {
	    	//$scope.host = response.data.host;
	    	//$scope.uri = response.data.uri;
	        console.log("HOST1-URI: " + response.data.uri);
	        console.log("HOST1: " + response.data.host);
	        return response.data;
	     });
		return promise;
	
}]);
*/


