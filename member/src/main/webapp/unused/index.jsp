<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="app">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>VIP 会员</title>
    <link rel="stylesheet" href="include/styles.css">
    <!-- Use Bootstrap -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.4/angular.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.19/angular-resource.js"></script>
    
    <script type="text/javascript" src="app.js"></script>
    <script type="text/javascript" src="main.ctrl.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">   
  </head>
   
  <body ng-controller="MainController as vm">
    <div class="container">
    <div class="header">
      <h1 class="custom">泉州市东南医药VIP会员管理网页</h1>
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
      <image src="{{vm.image}}" width="220">     
    </div>
   
    <div class="MainBody">
        <form>
          <table>
          <tr>
            <td><input type="text" ng-model="vm.searchName" size="30"></td>
            <td><button type="button" ng-click="vm.searchMember(vm.searchName)" class="btn btn-primary btn-sm">
                <span class="glyphicon glyphicon-search"></span> 搜索 </button></td>
            <td><button ng-click="vm.addNew()" class="btn btn-primary btn-sm">
            <span class="glyphicon glyphicon-plus"></span> 添加新会员 </button></td>
            <td><button ng-click="vm.resetSearch()"  class="btn btn-info btn-sm">
            <span class="glyphicon glyphicon-refresh"></span> 重置搜索 </button></td>
            <!-- 
            <td><a href="upload.jsp">upload</a></td>
            -->
          </tr>
        </table>
        </form>
         
      <form id="main">
        <table>
          <tr>
            <td class="display_bold"><label for="vm.member.memId">ID:</label></td>
          </tr>
          <tr>
            <td class="display"><input id="id" type="text" ng-model="vm.member.memId" size="4" disabled></td>
          </tr>
          <tr>
            <td class="display_bold"><label for="vm.member.name">姓名:</label></td>
          </tr>
          <tr>
            <td class="display"><input id="name" type="text" ng-model="vm.member.name" size="20"></td>
          </tr>
          <tr>
            <td class="display_bold"><label for="vm.member.phone">电话:</label></td>
          </tr>
          <tr>
            <td class="display"><input type="text" ng-model="vm.member.phone" size="20"></td>
          </tr>
          <tr>
            <td class="display_bold"><label for="vm.member.address">地址:</label></td>
          </tr>
          <tr>
            <td class="display"><input type="text" ng-model="vm.member.address" size="50"></td>
          </tr>
          <tr>
            <td class="display_bold"><label for="vm.member.mark">积分:</label></td>
          </tr>
          <tr>
            <td class="display"><input type="text" ng-model="vm.member.mark" size="4"></td>
          </tr>
          <tr>
            <td class="display_bold"><label for="vm.member.comment">注解:</label></td>
          </tr>
          <tr>
            <td class="display"><input type="text" ng-model="vm.member.comment" size="50"></td>
          </tr>
          <!-- 
          <tr>
            <td class="display_bold"><label for="name">Image:</label></td>
          </tr>
          <tr>
            <td class="display"><input type="text" ng-model="actor.image" size="80"></td>
          </tr>
          <tr>
            <td class="display_bold"><label for="name">IsActive:</label></td>
          </tr>
          <tr>
            <td class="display"><input type="text" ng-model="actor.active" size="10"></td>
          </tr>
           -->
          <tr>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>
              <table>               
                <tr>
                  <td><button ng-click="vm.saveMember()" class="btn btn-success btn-sm" title="Save member's details..." ng-disabled="vm.isSaveDisabled">
                  <span class="glyphicon glyphicon-plus"></span> 保存 </button></td>
                <td><button ng-click="vm.deleteMember()" class="btn btn-danger btn-sm" ng-disabled="vm.isDeleteDisabled">
                <span class="glyphicon glyphicon-trash"></span> 删除 </button></td>     
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
