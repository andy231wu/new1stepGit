//inject angular file upload directives and service.
var app = angular.module('uploadApp', []);

app.controller("UploadController", function($scope) {
   var vm = this;
   $scope.uploadFile = function(element) {   
	   var data = new FormData();
	   data.append('file', $(element)[0].files[0]);
	   jQuery.ajax({
		         url: 'images/upload',
		         type:'post',
		         data: data,
		         contentType: false,
		         processData: false,
		         success: function(response) {
		        	 console.log(response);
		         },
		         error: function(jqXHR, textStatus, errorMessage) {
		        	 alert('Error uploading: ' + errorMessage);
		         }
	    });   
	};
  
   /*
   vm.onFileSelect = function($files) {
    //$files: an array of files selected, each file has name, size, and type.
    for (var i = 0; i < $files.length; i++) {
        var file = $files[i];
        vm.upload = $upload.upload({
           url: 'server/upload/url', //upload.php script, node.js route, or servlet url
           data: {myObj: $scope.myModelObj},
           file: file,
        }).progress(function(evt) {
          console.log('percent: ' + parseInt(100.0 * evt.loaded / evt.total));
      }).success(function(data, status, headers, config) {
        // file is uploaded successfully
        console.log(data);
      });
    }
  };
  */
})