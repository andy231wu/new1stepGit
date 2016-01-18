 
app.controller("MainController", function($scope, $http, config, fileUploadService,accommodation) {
	console.log("app config3"); 
    var vm = this;
    vm.navTitle = "当前VIP会员";
    vm.operation="";
    vm.isSaveDisabled = true;
    vm.isDeleteDisabled = true;
    vm.showDefaultImage = true;
    vm.showImage = false;
    vm.totalNums = 0;
    vm.saveSuccess = '';
    vm.appName = config.appName;
                                
    console.log("Andy22-uri: " + accommodation.hotelName());
    /*
    ConnectionService.then(function(data){
        $scope.connectInfo = data;
    });
    */
    /*
    vm.host = '';
    vm.uri = '';
   
    vm.init = function() {
    	// read properties file
        $http.get('resources/connection.properties').then(function (response) {
        	$scope.host = response.data.host;
        	$scope.uri = response.data.uri;
            console.log("HOST1: " + $scope.uri);
         });
    };
    vm.host = $scope.host;
    */
   // vm.uri  = $rootScope.uri
   // console.log("HOST2: " + vm.uri);
   // console.log("Andy host: " + $scope.connectInfo.host);
  //  console.log("Andy uri: " + $scope.connectInfo.uri);
    vm.uri =  "localhost/memberws";
    
    vm.memberOptions = [
                        {label: '所有会员', value: 'a'},  
                        {label: '当前会员', value: 'c'}, 
                        {label: '以前会员', value: 'i'}, 
                        {label: '金卡会员', value: 'g'},  
                        {label: '银卡会员', value: 's'}, 
                        {label: '钻卡会员', value: 'd'}, 
                        {label: '普通会员', value: 'o'} 
                     ];
    vm.classOptions = [
                        {label: '普通会员', value: 'o'}, 
                        {label: '金卡会员', value: 'g'},  
                        {label: '银卡会员', value: 's'}, 
                        {label: '钻卡会员', value: 'd'}
                     ];
   
    vm.genderOptions = [
                        {label: '男', value:'男'},  
                        {label: '女', value:'女'} 
                     ];
                 
    fileUploadService.registerObserver(this);
    
    this.update = function(){
    	console.log("[main.ctrl.js visit] file location: " + fileUploadService.uploadLocation());
    	vm.member.fileUrl = fileUploadService.uploadLocation();
    	vm.operation = "update";
    	vm.saveMember();
    }  

   // var service = config.uri + "/services/memberService/";
	var service = vm.uri + "/services/memberService/";
  
	// get all members
    var theUrl = service + 'fetchAllActiveMembers';  
    vm.jsonObj={"member":{"appId":config.appName}};   
    var response = $http({
        method: 'POST',        
        url: theUrl,
        data: vm.jsonObj,       
        headers: {'Content-Type': 'application/json','DataServiceVersion': 2.0, 'Access': 'application/json'}
    }); 
    response.success(function(data, status, headers, config) {    	
    	vm.returnData = data;
    	//console.log("[main] # of return data: " + data + "  Members: " + data.members);
    	if(data.members == null) {
    		vm.totalNums = 0;
    	}else{
    		vm.totalNums = data.members.length;
    		vm.member = data.members[0];
	    	if(vm.member.fileUrl == null || vm.member.fileUrl == ""){
	    		vm.showDefaultImage = true;
	    		vm.showImage = false;
	    	}else{
	    		vm.showImage = true;
	    		vm.showDefaultImage = false;
	    	}
            console.log("[main] # of items: " + data.members.length)
            /* keep for later reference
               angular.forEach(data.members, function(element) {
                    console.log("[main] member: " + element.name);
               });
           */
    	}
    	
    });     
    response.error(function(data, status, headers, config) {
        alert("系统出错: AJAX failed to get All Vip Members, status=" + status);
    });  
      
    	
    // get a member by id       
    vm.getMemberById = function(id, isUpdate) {     	
    	theUrl = service + 'fetchMemberById';
    	vm.jsonObj={"member":{"memId": id}};        
	    var response = $http({
	        method: 'POST',        
	        url: theUrl,
	        data: vm.jsonObj,       
	        headers: {'Content-Type': 'application/json','DataServiceVersion': 2.0, 'Access': 'application/json'}
	    }); 
	    response.success(function(data, status, headers, config) {    	
	    	vm.member = data.members[0];	
	    	if(vm.member.fileUrl == null || vm.member.fileUrl == ""){
	    		vm.showDefaultImage = true;
	    		vm.showImage = false;
	    	}else{
	    		vm.showImage = true;
	    		vm.showDefaultImage = false;
	    	}
	    	
	    	if(!isUpdate){
		    	vm.operation="update";
		    	vm.isSaveDisabled = false;
		    	vm.isDeleteDisabled = false;
		    	vm.saveSuccess = '';
	    	}
	    	
	      });	     
	    response.error(function(data, status, headers, config) {
	        alert("系统出错: AJAX failed to get Member By Id, status=" + status);
	    });  
    };
    
    
    vm.searchMember = function(param) {    	
    	if(stringIsNumber(param)){    		
    	  theUrl = service + 'fetchMembersByPhone'; 
    	  vm.jsonObj = {"member":{"phone":param,"appId":config.appName}};
    	}else{    		
    	  theUrl = service + 'fetchMembersByName';	
    	  vm.jsonObj = {"member":{"name":param,"appId":config.appName}};
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
 	    	   vm.operation="update";
 	    	   vm.isSaveDisabled = false;
 	        }else{
 	           vm.operation="";
 	           vm.clearForm();
 	           vm.isSaveDisabled = true;
 	           vm.isDeleteDisabled = true; 	          
 	           vm.searchName = '';  
 	           vm.totalNums = 0;
 	        }
 	    	 vm.saveSuccess = ''; 	    	             
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
          comment:'',
          active: false,
          fileUrl: '',
          email:'',
          gender: '',
          dob:''
      };
    }
     
    vm.addNew = function() {
      vm.operation="create";
      vm.clearForm();
      main.name.focus();
      vm.member.gender = vm.genderOptions[0].value;
      vm.member.memClass = vm.classOptions[0].value;
      vm.member.mark = 0;
      vm.member.varRate = 0.1;
      vm.member.fixRate = 0.0;
      vm.member.active = true;
      vm.isSaveDisabled = false;
      vm.isDeleteDisabled = true;
      vm.saveSuccess = '';
      vm.showDefaultImage = true;
      vm.showImage = false;
    }
     
    vm.saveMember = function() {
      vm.member.appId = config.appName; // inject application name
      var jsonMember = angular.toJson(vm.member, false);     
      vm.jsonObj ='{"member":' + jsonMember + '}';
      var saveMemId = vm.member.memId;
      //console.log("[update] data: " + vm.jsonObj);
      if (vm.operation == "update") {
    	  var theUrl = service + 'updateMember'; 
    	  var response = $http({
  	        method: 'POST',        
  	        url: theUrl,
  	        data: vm.jsonObj,       
  	        headers: {'Content-Type': 'application/json','DataServiceVersion': 2.0, 'Access': 'application/json'}
  	      }); 
  	      response.success(function(data, status, headers, config) { 
  	    	  vm.resetSearch("c", true);  	    	 
 	    	  vm.getMemberById(saveMemId, true);
 	    	  vm.expense = '';
 	    	  vm.isSaveDisabled = true;
  		      vm.saveSuccess = "先前记录已经成功地提交!";  	    	 
  	      });  	     
  	      response.error(function(data, status, headers, config) {
  	        alert("系统出错: AJAX failed to update Member, status=" + status);
  	      })  
      } else if (vm.operation == "create") {
    	  var theUrl = service + 'insertMember'; 
    	  var response = $http({
  	        method: 'POST',        
  	        url: theUrl,
  	        data: vm.jsonObj,       
  	        headers: {'Content-Type': 'application/json','DataServiceVersion': 2.0, 'Access': 'application/json'}
  	      }); 
  	      response.success(function(data, status, headers, config) {  	    	  
  	    	  var id = data.members[0].memId;
  	    	 // console.log("After adding new record: " + id);
  	    	  vm.resetSearch("c", true); 
  	    	  vm.getMemberById(id, true);
  	    	  vm.expense = '';
  	    	  vm.isSaveDisabled = true;
  	    	  vm.operation = "update";
   		      vm.saveSuccess = "先前记录已经成功地提交!";  	    	 
  	      });  	     
  	      response.error(function(data, status, headers, config) {
  	        alert("系统出错: AJAX failed to Insert Member, status=" + status);
  	      });  
      }
    };
     
    vm.deleteMember = function() {
       if(confirm("你确定你要删除这个会员吗？")){
	       theUrl = service + 'deleteMember'; 
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
		       vm.resetSearch("c"); 
		   });  	     
		   response.error(function(data, status, headers, config) {
		       alert("系统出错: AJAX failed to delete Member, status=" + status);
		   }); 
       }
    };
     
    vm.resetSearch = function(mode, isUpdate) {
       if(!isUpdate){
	       vm.operation="";
	       vm.clearForm();
	       vm.isSaveDisabled = true;
	       vm.isDeleteDisabled = true;      
	       vm.searchName = '';   
	       vm.showDefaultImage = true;
	       vm.showImage = false;
	       vm.totalNums = 0;
	       vm.saveSuccess = '';	       
       }
                    
       // get all members   
       if(mode == "c"){
    	   theUrl = service + 'fetchAllActiveMembers'; 
    	   vm.navTitle = '当前VIP会员';
       }else if(mode == "i"){
  		 theUrl = service + 'fetchAllInactiveMembers'; 
		 vm.navTitle = '以前VIP会员'
       }else if(mode == "g"){
    		 theUrl = service + 'fetchAllActiveGoldMembers'; 
  		     vm.navTitle = '金卡会员'
       }else if(mode == "s"){
  		     theUrl = service + 'fetchAllActiveSilverMembers'; 
		     vm.navTitle = '银卡会员'
       }else if(mode == "d"){
  		     theUrl = service + 'fetchAllActiveDiamondMembers'; 
		     vm.navTitle = '钻卡会员'
       }else if(mode == "o"){
  		     theUrl = service + 'fetchAllActiveOrdinaryMembers'; 
		     vm.navTitle = '普通会员'  
       }else{
    		 theUrl = service + 'fetchAllMembers'; 
    		 vm.navTitle = '所有VIP会员';
       }
           
       vm.jsonObj={"member":{"appId":config.appName}};   
       var response = $http({
          method: 'POST',          
          url: theUrl,
          data: vm.jsonObj,       
          headers: {'Content-Type': 'application/json','DataServiceVersion': 2.0, 'Access': 'application/json'}
       }); 
       response.success(function(data, status, headers, config) {    	
          vm.returnData = data;
          vm.totalNums = data.members.length;
          if(!isUpdate){
	          vm.member = data.members[0];
		      if(vm.member.fileUrl == null || vm.member.fileUrl == ""){
		    		vm.showDefaultImage = true;
		    		vm.showImage = false;
		      }else{
		    		vm.showImage = true;
		    		vm.showDefaultImage = false;
		      }
          }
          console.log("[main] # of items: " + data.members.length); 
       });       
       response.error(function(data, status, headers, config) {
         alert("系统出错: AJAX failed to get All Vip Members, status=" + status);
       });        
    };
        
    vm.sendSMS = function() {
    	alert("发送会员短信功能待开发， 请原谅！");
    };  
    
    function stringIsNumber(s) {
    	var x = Number(s).toString();
    	return x != 'NaN';
    };
    
    vm.updateMark = function(){
    	vm.saveMark = vm.member.mark;
    	vm.member.mark = vm.expense * vm.member.varRate + vm.member.mark;
    	vm.saveSuccess = "";
    }
    vm.rollbackMark = function(){
    	vm.member.mark = vm.saveMark;
    	vm.expense = '';
    }
   
  }); 

