<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="app">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>VIP 会员</title>
    
    <!-- Use Bootstrap -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="include/styles.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script src="javascripts/bootstrap-filestyle.min.js"></script>
    <!-- 
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.4/angular.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.19/angular-resource.js"></script>
     -->
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.4.8/angular-route.js"></script>
                 
    <!-- 
     <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.4.8/angular-route.js"></script>
     -->
    <script type="text/javascript" src="app.js"></script>
    <script type="text/javascript" src="main.ctrl.js"></script>
    <script type="text/javascript" src="upload.ctrl.js"></script>
    <script src="javascripts/imageupload.js" type="text/javascript"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">   
  </head>
   
  <body ng-controller="MainController as vm">
    <div class="container2">
    <div class="header">
      <!-- h1 class="custom">福建省泉州市东南医药连锁<span style="color:red">(VIP)</span>会员管理网页 - 示范</h1 -->
      <h1 class="custom">中国旋风高尔夫俱乐部<span style="color:red">(VIP)</span>会员管理网页 - 示范版</h1>
    </div>
 
    <div class="LeftPanel">
      <div class="LeftPanelHeader">{{vm.navTitle}} ({{vm.totalNums}})</div>
      <table class="side">
        <div ng-if="vm.returnData.success">
	        <tr ng-repeat="member in vm.returnData.members" ng-click="vm.getMemberById(member.memId)" >
	          <td class="side">{{member.name}}</td>
	        </tr>
        </div>
      </table>
    </div>
   
    <div class="RightPanel">   
       <div ng-if="vm.showDefaultImage">
            <image src="/member/images/icon_male.png" width="220px" height="300px"> 
       </div>
       
       <div ng-if="vm.showImage">       
            <image src="{{vm.member.fileUrl}}" width="220px" height="300px"> 
       </div>
       
       <hr />
       <font size="3">上传会员(ID:{{vm.member.memId}})照片</font>
       <!-- alw: for using upload service model and id must be set, 
           model is Application Name to create a upload directory -->
       <div ng-controller = "uploadCtrl as up" model={{vm.appName}} id="{{vm.member.memId}}">
           <form id="uploadForm">         
	           <font size="1" color="red" id="myErr">{{errMessage}}</font>		  
			   <input type="file" file-model="myFile" class="filestyle" data-buttonName="btn-primary" data-buttonText="选择文件">
			   <hr />    
			    <button ng-click="uploadFile()" class="btn btn-success btn-sm">
	                  <span class="glyphicon glyphicon-plus"></span> 上传 </button>
	              
	            <button ng-click="clearUploadFile()" class="btn btn-danger btn-sm">
                     <span class="glyphicon glyphicon-trash"></span> 清除 </button>
           </form>  
		</div>
              
       <!-- 
       
      <form ng-controller="UploadController as up">           
         <input id="inputImage2" 
                name="uploadedFile_dongnan_{{vm.member.memId}}"
                type="file" 
                accept="image/*" 
                image="image2" 
                resize-max-height="300"
                resize-max-width="250"
                resize-quality="0.7" />
           
            <img ng-show="image2" ng-src="{{image2.resized.dataURL}}"/>           
            <button type="submit" ng-click="up.single(image2)" >Add</button>  
      </form>
      -->
    </div>
   
    <div class="MainBody">
        <form>
          <table>
          <tr>
            <td><input type="text" ng-model="vm.searchName" size="12"></td>
            <td><button type="button" ng-click="vm.searchMember(vm.searchName)" class="btn btn-primary btn-sm">
                <span class="glyphicon glyphicon-search"></span> 搜索 </button></td>
            <td><button ng-click="vm.addNew()" class="btn btn-primary btn-sm">
            <span class="glyphicon glyphicon-plus"></span> 添加新会员 </button></td>
            <td>&nbsp;&nbsp;</td>
            <td>
			    <select name="searchMode" ng-model="vm.searchMode" ng-init="vm.searchMode = vm.memberOptions[1].value" 
			          ng-options ="option.value as option.label for option in vm.memberOptions">			      
			    </select>			   
            </td>           
            
            <td><button ng-click="vm.resetSearch(vm.searchMode)"  class="btn btn-info btn-sm">
            <span class="glyphicon glyphicon-refresh"></span> 重新搜索 </button></td>
            
          </tr>
        </table>
        </form>
         
      <form id="main" name="main">
        <table>
          <tr><td class="display_bold"><label for="vm.member.memId">ID:</label></td></tr>
          <tr><td>
                  <table>
                        <td class="display"><input id="id" type="text" ng-model="vm.member.memId" size="4" disabled></td>
                        <td>&nbsp;&nbsp;</td>
                        <td>
                        	<div ng-show="main.$submitted || main.uName.$touched">
                               <div ng-show="main.uName.$error.required"><span style="color:red">(请输入名字！)</span></div>
                            </div>
                            <div ng-show="main.$submitted || main.uPhone.$touched">
                               <div ng-show="main.uPhone.$error.required"><span style="color:red">(请输入电话号码！)</span></div>
                            </div>
                            <div ng-show="main.$submitted || main.uEmail.$touched">
						      <span ng-show="main.uEmail.$error.required"><span style="color:red">(输入电子邮件地址！)</span></span>
						      <span ng-show="main.uEmail.$error.email"><span style="color:red">(无效的电子邮件地址)</span></span>
						    </div>
                        </td>
                  </table>
          </td></tr>
          
          <tr></tr>
          <tr><td>
               <table>
                    <tr>
                    	<td class="display_bold"><label for="vm.member.name">姓名:<span style="color:red">(*)</span></label></td>
                    	<td>&nbsp;&nbsp;</td>
                    	<td class="display_bold"><label for="vm.member.memClass">等级:</label></td>
                    	<td>&nbsp;&nbsp;</td>
                    	<td class="display_bold"><label for="vm.member.gender">性别:</label></td>
                    	<td class="display_bold"><label for="vm.member.dob">&nbsp;&nbsp;生日:</label></td>
                    </tr>
                    <tr>
                        <td class="display"><input id="name" type="text"name="uName" ng-model="vm.member.name" size="15" required=""/>  
                        </td>
                        <td>&nbsp;&nbsp;</td>
                        <td class="display">
	                        <select name="class" ng-model="vm.member.memClass"  
						          ng-options ="option.value as option.label for option in vm.classOptions">			      
						    </select>
                        </td>
                        <td>&nbsp;&nbsp;</td>
                        <td class="display">
	                        <select name="gender" ng-model="vm.member.gender" 
						          ng-options ="option.value as option.label for option in vm.genderOptions" ng-required="true">			      
						    </select>
                        </td>
                        <td class="display">&nbsp;&nbsp;<input type="text" ng-model="vm.member.dob" size="14"></td>
                    </tr>
                    
               </table>
          </td></tr>
          
          <tr><td>
               <table>
                     <tr>
                         <td class="display_bold"><label for="vm.member.phone">电话:<span style="color:red">(*)</span></label></td>
                         <td class="display_bold"><label for="vm.member.phone" ng-required="true">&nbsp;&nbsp;电子邮箱:</label></td>
                     </tr>
                     <tr>
                         <td class="display"><input type="text" name="uPhone" ng-model="vm.member.phone" size="15" required=""></td>                                                  
                         <td class="display">&nbsp;&nbsp;<input type='email' name='uEmail' ng-model='vm.member.email' size="32"></td>
                     </tr>
               </table>
          </td></tr>         
             
          <tr><td>
              <table>
                    <tr>
                       <td class="display_bold"><label for="vm.member.address">地址:</label></td>
              		   <td class="display_bold"><label for="vm.member.active">&nbsp;&nbsp;&nbsp;&nbsp;当前会员:</label></td>
                    </tr>
                    <tr>
                       <td class="display"><input type="text" ng-model="vm.member.address" size="40"></td> 
                       <td class="display">&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" ng-model="vm.member.active"></td>
                    </tr>
              </table>
          </td></tr>
          
          <tr><td>
              <table>
                   <tr>
                       <td class="display_bold"><label for="vm.member.mark">积分:</label></td>
                       <td class="display_bold"><label for="vm.member.varRate">&nbsp;&nbsp;&nbsp;&nbsp;积分比率:</label></td>
                       
                       <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                       <td class="display_bold"><label for="vm.expense">本次消费额：</label></td>
                   </tr>
                   <tr>
                       <td class="display"><input type="text" ng-model="vm.member.mark" size="5"></td>
                       <td class="display">&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" ng-model="vm.member.varRate" ng-init="vm.member.varRate = 0.1" size="4"></td>
                       
                       <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                       <td class="display">
                          <form id="expense">
                                <input type="text" ng-model="vm.expense" size = "6">
                                <button ng-click="vm.updateMark()" class="btn btn-success btn-sm">
                                <span class="glyphicon glyphicon-plus"></span> 累积积分 </button>
                                <button ng-click="vm.rollbackMark()" class="btn btn-success btn-sm">
                                <span class="glyphicon glyphicon-minus"></span> 复原积分 </button>
                          </form>
                           
                           
                       </td>
                   </tr>
              </table>
          </td></tr>
         
          <!--  
          <tr><td class="display_bold"><label for="vm.member.fileUrl">照片位置:</label></td></tr>
          <tr><td class="display"><input type="text" ng-model="vm.member.fileUrl" size="50"></td></tr>          
          -->
          <tr><td class="display_bold"><label for="vm.member.comment">备注:</label></td></tr>
          <tr><td class="display"><textarea cols="49" rows="2" ng-model="vm.member.comment"></textarea></td>
              
          </tr>          
          
          <tr><td><span style="color: blue">{{vm.saveSuccess}}</span></td></tr>
          <tr><td>&nbsp;</td></tr>
          <tr>
            <td>
              <table>               
                <tr>
                  <td><button ng-click="vm.saveMember()" class="btn btn-success btn-sm" title="Save member's details..." 
                              ng-disabled="main.$invalid" ng-disabled="vm.isSaveDisabled">
                              <span class="glyphicon glyphicon-plus"></span> 提交 </button>
                  </td>
                  <td><button ng-click="vm.deleteMember()" class="btn btn-danger btn-sm" ng-disabled="vm.isDeleteDisabled">
                         <span class="glyphicon glyphicon-trash"></span> 删除 </button>
                  </td>  
                  <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                  <td><button ng-click="vm.sendSMS()" class="btn btn-primary btn-sm">
                         <span class="glyphicon glyphicon-plus"></span> 发送会员短信 </button>
                  </td>   
                </tr>
              </table>
            </td>
          </tr>
           
        </table>
      </form>
     
    </div>
 
   
    <div class="footer">New1step  - Copyright Â© new1step.com</div>
  </div>
  </body>
</html>
