var app = angular.module("app", []);
  
app.controller("MainController", function($scope, $http) {
    var vm = this;
    vm.navTitle = "所有VIP会员";
    vm.operation="";
    vm.isSaveDisabled = true;
    vm.isDeleteDisabled = true;
    vm.image = "images/huanbingbing.jpg";
    vm.totalNums = 0;
    
     
	var prodHost = "http://new1step.com/";
	var testHost = "http://localhost/";
	//var host = testHost;
	var host = prodHost;
	var service = "dongnanws/services/memberService/";
  
	// get all members
    var theUrl = host + service + 'fetchAllMembers';  
    vm.jsonObj={"member":{}};   
    var response = $http({
        method: 'POST',        
        url: theUrl,
        data: vm.jsonObj,       
        headers: {'Content-Type': 'application/json','DataServiceVersion': 2.0, 'Access': 'application/json'}
    }); 
    response.success(function(data, status, headers, config) {    	
    	vm.returnData = data;
    	vm.totalNums = data.members.length;
        console.log("[main] # of items: " + data.members.length)
        angular.forEach(data.members, function(element) {
           console.log("[main] member: " + element.name);
        });
    });     
    response.error(function(data, status, headers, config) {
        alert("系统出错: AJAX failed to get All Vip Members, status=" + status);
    });  
      
    	
    // get a member by id       
    vm.getMemberById = function(id) {
    	theUrl = host + service + 'fetchMemberById';
    	vm.jsonObj={"member":{"memId": id}};        
	    var response = $http({
	        method: 'POST',        
	        url: theUrl,
	        data: vm.jsonObj,       
	        headers: {'Content-Type': 'application/json','DataServiceVersion': 2.0, 'Access': 'application/json'}
	    }); 
	    response.success(function(data, status, headers, config) {    	
	    	vm.member = data.members[0];	    	
	        vm.operation="update";
	        vm.isSaveDisabled = false;
	        vm.isDeleteDisabled = false;
	      });	     
	    response.error(function(data, status, headers, config) {
	        alert("系统出错: AJAX failed to get Member By Id, status=" + status);
	    });  
    };
    
    
    vm.searchMember = function(param) {
    	if(stringIsNumber(param)){    		
    	  theUrl = host + service + 'fetchMembersByPhone'; 
    	  vm.jsonObj = {"member":{"phone":param}};
    	}else{    		
    	  theUrl = host + service + 'fetchMembersByName';	
    	  vm.jsonObj = {"member":{"name":param}};
    	}
    	vm.navTitle = '搜索结果'; 
   	    var response = $http({
 	        method: 'POST',        
 	        url: theUrl,
 	        data: vm.jsonObj,       
 	        headers: {'Content-Type': 'application/json','DataServiceVersion': 2.0, 'Access': 'application/json'}
 	    }); 
 	    response.success(function(data, status, headers, config) {    	
 	    	vm.returnData = data;
 	    	if(data.success && data.members.length > 0){
 	    	   vm.totalNums = data.members.length;
 	    	   vm.member = data.members[0];
 	        }else{
 	           vm.operation="";
 	           vm.clearForm();
 	           vm.isSaveDisabled = true;
 	           vm.isDeleteDisabled = true; 	          
 	           vm.searchName = '';  
 	           vm.totalNums = 0;
 	        }
 	    	//$scope.$apply(); 	               
 	    });  	     
 	    response.error(function(data, status, headers, config) {
 	        alert("系统出错: AJAX failed to search Member, status=" + status);
 	    })  
    };
     
    vm.clearForm = function() {
      vm.member = {
          memId:'',
          name:'',
          phone:'',
          address:'',
          mark:'',
          comment:''
      };
    }
     
    vm.addNew = function() {
      vm.operation="create";
      vm.clearForm();
      main.name.focus();
      vm.isSaveDisabled = false;
      vm.isDeleteDisabled = true;
    }
     
    vm.saveMember = function() {
      var jsonMember = angular.toJson(vm.member, false);     
      vm.jsonObj ='{"member":' + jsonMember + '}';
      console.log("[update] data: " + vm.jsonObj);
      if (vm.operation == "update") {
    	  var theUrl = host + service + 'updateMember'; 
    	  var response = $http({
  	        method: 'POST',        
  	        url: theUrl,
  	        data: vm.jsonObj,       
  	        headers: {'Content-Type': 'application/json','DataServiceVersion': 2.0, 'Access': 'application/json'}
  	      }); 
  	      response.success(function(data, status, headers, config) {    	
  	    	vm.resetSearch();	
  	      });  	     
  	      response.error(function(data, status, headers, config) {
  	        alert("系统出错: AJAX failed to update Member, status=" + status);
  	      })  
      } else if (vm.operation == "create") {
    	  var theUrl = host + service + 'insertMember'; 
    	  var response = $http({
  	        method: 'POST',        
  	        url: theUrl,
  	        data: vm.jsonObj,       
  	        headers: {'Content-Type': 'application/json','DataServiceVersion': 2.0, 'Access': 'application/json'}
  	      }); 
  	      response.success(function(data, status, headers, config) {    	
  	    	vm.resetSearch();	
  	      });  	     
  	      response.error(function(data, status, headers, config) {
  	        alert("系统出错: AJAX failed to Insert Member, status=" + status);
  	      });  
      }
    };
     
    vm.deleteMember = function() {
       if(confirm("你确定你要删除这个会员吗？")){
	       theUrl = host + service + 'deleteMember'; 
	       var jsonMember = angular.toJson(vm.member, false);     
	       vm.jsonObj ='{"member":' + jsonMember + '}';
	       console.log("[delete] data: " + vm.jsonObj);
	  	   var response = $http({
		       method: 'POST',        
		       url: theUrl,
		       data: vm.jsonObj,       
		       headers: {'Content-Type': 'application/json','DataServiceVersion': 2.0, 'Access': 'application/json'}
		   }); 
		   response.success(function(data, status, headers, config) {    	
		       vm.resetSearch();	
		   });  	     
		   response.error(function(data, status, headers, config) {
		       alert("系统出错: AJAX failed to delete Member, status=" + status);
		   }); 
       }
    };
     
    vm.resetSearch = function() {     
       vm.operation="";
       vm.clearForm();
       vm.isSaveDisabled = true;
       vm.isDeleteDisabled = true;
       vm.navTitle = '所有VIP会员';
       vm.searchName = '';   
      
       // get all members   
       theUrl = host + service + 'fetchAllMembers';     
       vm.jsonObj={"member":{}};   
       var response = $http({
          method: 'POST',          
          url: theUrl,
          data: vm.jsonObj,       
          headers: {'Content-Type': 'application/json','DataServiceVersion': 2.0, 'Access': 'application/json'}
       }); 
       response.success(function(data, status, headers, config) {    	
          vm.returnData = data;
          vm.totalNums = data.members.length;
          console.log("[main] # of items: " + data.members.length);
          // $scope.$apply();
       });       
       response.error(function(data, status, headers, config) {
         alert("系统出错: AJAX failed to get All Vip Members, status=" + status);
       });        
    };
    
    function stringIsNumber(s) {
    	var x = Number(s).toString();
    	return x != 'NaN';
    };
   
  }); 

