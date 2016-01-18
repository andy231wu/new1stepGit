//var app2 = angular.module('imageUpload', ['imageupload']);
/*  
app.controller("UploadController", function($scope, $http) {
	var up = this;
    up.single = function(image) {
        var formData = new FormData();
        formData.append('file', image, image.name); 
        formData.append('filename', image.name);
       // formData.append('app', "dongnan");
       // formData.append('id', "99");
        alert("ANDY name: " + image.name + "   IMAGE-type: " + image.type);
      
        $http.post('http://localhost/up2downloadws/services/uploadService/uploadFile', formData, {
            headers: { 'Content-Type': undefined },
            transformRequest: angular.identity
        }).success(function(result) {
           // up.uploadedImgSrc = result.src;
           // up.sizeInBytes = result.size;
        }).error(function(data, status, headers, config) {
            alert("系统出错: AJAX failed to get All Vip Members, status=" + status);
        });   
        
        
    };
}); */


//app.controller('uploadCtrl', ['$scope', 'fileUploadService', 'config','$attrs', function($scope, fileUploadService, config, $attrs){
app.controller('uploadCtrl', function($scope, fileUploadService, config, $attrs, $http){
	var vm = this;
    /*
    // read properties file
    $http.get('resources/connection.properties').then(function (response) {
        vm.host = response.data.host;
        vm.uri = response.data.uri;
     });
    */
	$(":file").filestyle({buttonName: "btn-primary"});
	/* not need for this controller, test only here
	fileUploadService.registerObserver(this);
    
    this.update = function(){
    	console.log("[upload] file location: " + fileUpload.uploadLocation());
    	vm.location = fileUploadService.uploadLocation();
    }
	*/
	// use to clear upload field
	$scope.clearUploadFile = function(){
		 $scope.errMessage = '';
		 var es = document.forms.namedItem("uploadForm").elements;
		  clearInputFile(es[1]);
	}
    function clearInputFile(f){
        if(f.value){
            try{
                f.value = ''; //for IE11, latest Chrome/Firefox/Opera...
            }catch(err){
            }
            if(f.value){ //for IE5 ~ IE10
                var form = document.createElement('form'), ref = f.nextSibling;
                form.appendChild(f);
                form.reset();
                ref.parentNode.insertBefore(f,ref);
            }
        }
    }
	//-------------------------------
	
    $scope.uploadFile = function(){
        if(!$attrs.model) throw new Error("No model for upload controller");
    	if(!$attrs.id) {
    		$scope.errMessage = "上传图片之前, 请选择一个会员!";
    		throw new Error("No member id for upload controller");
    	}else{
    		$scope.errMessage = "";
    	}
    	
        var file = $scope.myFile;
        $scope.myFile = "";
        $scope.appName = $attrs.model;  //Todo: change to get from properties file
        $scope.id = $attrs.id;
        console.log('file is ' );
        console.dir(file);       
       // var theHost = config.host;
        var theHost = vm.host; // from connection.properties
        console.log("Andy-host: " + theHost);
      //  console.log('host from html page:', theHost);
      //  console.log('Member id from html page:', $scope.id);
        var uploadUrl = theHost + "/up2downloadws/services/uploadService/uploadFile";
        fileUploadService.uploadFileToUrl(file, uploadUrl, $scope.appName, $scope.id, theHost);                                
    };
});    
//}]);

