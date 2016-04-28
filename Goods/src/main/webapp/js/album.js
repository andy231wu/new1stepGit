
<!-- handle main menu -->
var setActiveColor=true;
$().ready(function(){
	
	$("#mainMenuItems li:not(.selected)").hover(function(){	<!--goodsell -->
	runLoop();
		$(this).addClass("selected");
	},function(){
		$(this).removeClass("selected");
		highlightSeletedMenu();
	});
	
	
	highlightSeletedMenu();
	
	/*
	<!-- blinking -->
	setInterval(function(){
		if(setActiveColor){
		$("#menu_05>a").css("color","rgb(200, 150, 100)");
			setActiveColor=false;
		}
		else{
			$("#menu_05>a").css("color","rgb(255,0,0)");
			setActiveColor=true;
		}
	},500);
	
	*/
	/* clear input field */
	
	$('#verifyImageInput').val('');
	
	/* loop photos	runLoop();	*/
	 
	runLoop();
	
	$(":file").filestyle({buttonText: "选择文件"});
	
});

//add more file components if Add is clicked
$(document).ready(function() {
        
        $('#addFile').click(function() {        	
            var fileIndex = $('#fileTable').children().length;           
            $('#fileTable').append(
            		'<li>' 
            		+' <span class="column-left">上载文件</span>'
				    +' <span class="column-right"> ' 
				    + '   <input type="file" name="files['+ fileIndex +']" class="filestyle" data-buttonText="选择文件">'
				    + ' </span> <br/><br/>'
			        +' </li> '
            );
            $(":file").filestyle({buttonText: "选择文件"});
        });

    });


/*  to handle tab panel */

$(document).ready(function(){
    $(".tabbable").find(".tab").hide();
    $(".tabbable").find(".tab").first().show();
    $(".tabbable").find(".tabs li").first().find("a").addClass("active");
    $(".tabbable").find(".tabs").find("a").click(function(){
        tab = $(this).attr("href");
        $(".tabbable").find(".tab").hide();
        $(".tabbable").find(".tabs").find("a").removeClass("active");
        $(tab).show();
        $(this).addClass("active");
        return false;
    });
   
     <!-- contine button to trigger next tab show -->
    $(".tabbable").find(".tabcontent").find("button").click(function(){
    	
    	var pid = $(this).parent().parent().attr('id');
		var res = pid.substring(3);
	    var res = parseInt(res) + 1 ;
	    var target = "#tab"+res;
	   
	    var nextTabs = $(".tabbable").find(".tabs li").next();
	    
	    var i;
        for(i=0; i<nextTabs.length; i++) {	    	
	    	if(target == $(nextTabs[i]).find("a").attr("href") ) {
	    		$(nextTabs[i]).find("a").trigger("click");
	    		break;
	    	}
	    }
      
	    return false;
    });
});


/* main menu */
function highlightSeletedMenu(){	
	//alert("Andy-pageUrl: " + pageUrl);
	 /* apply selected states depending on current page */
	if (pageUrl.match(/home.htm/)) {
		$("ul#mainMenuItems li:eq(0)").addClass('selected');		                    
	}else if (pageUrl.match(/requestList.htm/)) {
		$("ul#mainMenuItems li:eq(1)").addClass('selected');
	}else if (pageUrl.match(/users.htm/)) {
		$("ul#mainMenuItems li:eq(2)").addClass('selected');	
	}else if (pageUrl.match(/login.htm/)) {
		$("ul#mainMenuItems li:eq(3)").addClass('selected');
	} else { /* don't mark any nav links as selected */
		$("ul#mainMenuItems li").removeClass('selected');
	};
}
/*
<!-- verical menu -->
function highlightSeletedVMenu(){	
	
	 <!-- apply selected states depending on current page -->	
	if (pageUrl.match(/sdp6100.htm/)) { <!-- pressure sensors -->
		$("ul#vMenu li:eq(1)").addClass('selected');
	} else if (pageUrl.match(/sdp6200.htm/)) {
		$("ul#vMenu li:eq(2)").addClass('selected');
	} else if (pageUrl.match(/sdp6300.htm/)) {
		$("ul#vMenu li:eq(3)").addClass('selected');
	} else if (pageUrl.match(/sdp6400.htm/)) {
		$("ul#vMenu li:eq(4)").addClass('selected');
	} else if (pageUrl.match(/sdp6500.htm/)) {
		$("ul#vMenu li:eq(5)").addClass('selected');
	} else if (pageUrl.match(/sdp6800.htm/)) {
		$("ul#vMenu li:eq(6)").addClass('selected');
	} else if (pageUrl.match(/sdw1100.htm/)) {
		$("ul#vMenu li:eq(7)").addClass('selected');
	} else if (pageUrl.match(/sdw1200.htm/)) {
		$("ul#vMenu li:eq(8)").addClass('selected');
		
		<!-- displacement sensors -->
	} else if (pageUrl.match(/sdm7100.htm/)) {
		$("ul#vMenu li:eq(1)").addClass('selected');
	} else if (pageUrl.match(/sdm7200.htm/)) {
		$("ul#vMenu li:eq(2)").addClass('selected');
	} else if (pageUrl.match(/sdm7300.htm/)) {08
		$("ul#vMenu li:eq(3)").addClass('selected');
	} else if (pageUrl.match(/sdm7400.htm/)) {
		$("ul#vMenu li:eq(4)").addClass('selected');
	} else if (pageUrl.match(/sdm2100.htm/)) {
		$("ul#vMenu li:eq(5)").addClass('selected');
	} else if (pageUrl.match(/sdm2200.htm/)) {
		$("ul#vMenu li:eq(6)").addClass('selected');
		
		<!-- tilt sensors -->
	} else if (pageUrl.match(/sda8100.htm/)) {
		$("ul#vMenu li:eq(1)").addClass('selected');
	} else if (pageUrl.match(/sda8200.htm/)) {
		$("ul#vMenu li:eq(2)").addClass('selected');
		08
		<!-- temperature sensors -->
	} else if (pageUrl.match(/sdt5100.htm/)) {
		$("ul#vMenu li:eq(1)").addClass('selected');
	} else if (pageUrl.match(/sdt5200.htm/)) {
		$("ul#vMenu li:eq(2)").addClass('selected');
	} else if (pageUrl.match(/sdt5300.htm/)) {
		$("ul#vMenu li:eq(3)").addClass('selected');
	} else if (pageUrl.match(/sdt5400.htm/)) {
		$("ul#vMenu li:eq(4)").addClass('selected');
		
		<!-- data collection system -->
	} else if (pageUrl.match(/sde9-net-br.htm/)) {
		$("ul#vMenu li:eq(1)").addClass('selected');		
	
		<!-- industrial applications -->
	} else if (pageUrl.match(/aerospace.htm/)) {
		$("ul#vMenu li:eq(1)").addClass('selected');
	} else if (pageUrl.match(/steelIndustry.htm/)) {
		$("ul#vMenu li:eq(2)").addClass('selected');
	} else if (pageUrl.match(/heavyMachinery.htm/)) {
		$("ul#vMenu li:eq(3)").addClass('selected');
	} else if (pageUrl.match(/petroleumChemical.htm/)) {
		$("ul#vMenu li:eq(4)").addClass('selected');
	} else if (pageUrl.match(/railTransportation.htm/)) {
		$("ul#vMenu li:eq(5)").addClass('selected');
	} else if (pageUrl.match(/cncMachineTool.htm/)) {
		$("ul#vMenu li:eq(6)").addClass('selected');
	} else if (pageUrl.match(/structureSafety.htm/)) {
		$("ul#vMenu li:eq(7)").addClass('selected');
	} else if (pageUrl.match(/airCompressor.htm/)) {
		$("ul#vMenu li:eq(8)").addClass('selected');
	} else if (pageUrl.match(/others.htm/)) {
		$("ul#vMenu li:eq(9)").addClass('selected');
	
	}else { <!-- don't mark any nav links as selected -->
		$("ul#vMenu li").removeClass('selected');
	};
}	

<!-- print specifications -->
function printDivs(divIds) {
 	   var divs = divIds.split("/");
 	   var printContents = "";
 	   for(var i=0; i < divs.length; i++) {
 		   printContents += "<div style='page-break-before: always;'>" + document.getElementById(divs[i]).innerHTML + "</div>";
 	   }
         
        var originalContents = document.body.innerHTML;
        document.body.innerHTML = "<html><head><title></title></head><body>" + printContents + "</body>";
        window.print();
        document.body.innerHTML = originalContents;
        window.location.reload(false);
}
*/

/* auto running photos */
function runLoop() {
	$(".photoarea").each(function(){
		
		//don't run if not enough photos
		if($(this).children().length < 2)
			return;
		
		var size = $('.photoarea *:first').outerHeight();
		var t = $(this).css('top');
		if(t){
			if(t == 'auto'){
				t = 0;
			}
			else {
				t = t.substring(0,t.length-2);
			}
			var pcThrough = Math.abs(t) / size * 100;
			/*var speed = 80 * (100-pcThrough) / 100 * size; */	
			
			 var speed = 30000; 
			$('.photoarea:not(:animated)').animate({'top':'-'+ size +'px'}, speed, "linear", function(){
				$('*:first',this).appendTo(this);
				$(this).css({'top':'0px'});
				setTimeout(function(){ runLoop() }, 10);
			}).hover(function(e){
				$(this).stop();
			},function(e){
				setTimeout(function(){ runLoop() }, 10);
			});
			
			return false;
		}
	});
}
/*
function doSave(url, index){
	return redirectTo(url, index, "save");
}

function redirectTo(url, index, method) {
	var stockId1 = document.getElementById("buyStocks" + index + ".stockId").value;
	var stockCode1 = document.getElementById("buyStocks" + index + ".stockCode").value;
	var tradeDate1 = document.getElementById("buyStocks" + index + ".tradeDate").value;
	var settleDate1 = document.getElementById("buyStocks" + index + ".settleDate").value;
	var units1 = document.getElementById("buyStocks" + index + ".units").value;
	var price1 = document.getElementById("buyStocks" + index + ".price").value;
	var brokerage1 = document.getElementById("buyStocks" + index + ".brokerage").value;
	var amount1 = document.getElementById("buyStocks" + index + ".amount").value;

	if (method == "save") {
		
		var total = getRowUnits(units1) * getRowPrice(price1) + getRowBrokerage(brokerage1);
		total = Math.round(total * 100)/100;
		var amount = getRowAmount(amount1);
		amount = Math.round(amount * 100)/100;
		if (amount != total) {
			alert("Error - Amount not = Units * price + brokerage");
			return false;
		}
		
		
		if (!CompareDates(tradeDate1, settleDate1)) {
			alert("Error - Trade Date cannot be greater than Settlement Date");
			return false;
		}
	}
	
	parent.location=url + "?stockId1=" + stockId1 + "&stockCode1=" + stockCode1 +
	                "&tradeDate1=" + tradeDate1 + "&settleDate1=" + settleDate1 +
	                "&units1=" + units1 + "&price1=" + price1 +
	                "&brokerage1=" + brokerage1 + "&amount1=" + amount1;	
}
*/
function doUpdate(url, reqId, index){
	var state = document.getElementById("requests" + index + ".state").value;
	parent.location=url + "?reqId=" + reqId + "&state=" + state;
}
