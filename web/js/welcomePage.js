/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function AutoLoad(){
	changeWindowAuto();
}

//窗口设置
function changeWindowAuto(){
	var width=$(document.body).width();
	var height=$(window).height();
	var panelwidth;
	if(width<360)
	{
            panelwidth=width;
            $("#loginDiv").css({
		"width":width,
		"height":height,
		"top":"0px",
		"left":"0px"
            });
	}
	else
	{
            panelwidth=360;
            var left=(width-360)/2;
            var top =(height-636)/2;
            $("#loginDiv").css({
                "width":"360px",
                "height":"636px",
                "top":top+"px",
                "left":left+"px"
            });
	}
        $("#userDetails").css({
		"height":panelwidth*0.463889,
		"width":panelwidth*0.791667,
		"left":panelwidth*0.1,
		"top":panelwidth*0.127778
	});
        $("#btPanel").css({
		"left":panelwidth*0.097222,
		"top":panelwidth*0.6638889,
                "right":panelwidth*0.105556,
                "bottom":panelwidth*0.02222
	});
        $("#start").css({
		"left":panelwidth*0.2138889,
		"top":panelwidth*-0.175
	});
        $("#newQues").css({
		"left":panelwidth*0.2138889,
		"top":panelwidth*0.0638889
	});
        $("#sendReport").css({
		"left":panelwidth*0.2138889,
		"top":panelwidth*0.308333
	});
        $("#userimg").css({
		"left":panelwidth*0.069444,
		"top":panelwidth*0.069444,
                "right":panelwidth*0.4805556,
                "bottom":panelwidth*0.1527778
	});
        $("#username").css({
		"left":panelwidth*0.333333,
		"top":panelwidth*0.0694444,
                "font-size":panelwidth*0.055556
	});
        $("#userscore").css({
		"left":panelwidth*0.333333,
		"top":panelwidth*0.227778,
                "font-size":panelwidth*0.055556
	});
        $("#welcomemsg").css({
		"left":panelwidth*0.069444,
		"top":panelwidth*0.34444,
                "font-size":panelwidth*0.066667
	});
}

function alerts()
{
	$.DialogByZ.Close();
        $(window).attr('location','login.jsp');
}

//开始游戏
var animateButtonStart = function(e) {

  e.preventDefault;
  //reset animation
  e.target.classList.remove('animate');
  
  e.target.classList.add('animate');
  setTimeout(function(){
    e.target.classList.remove('animate');
    $(window).attr('location','Start.jsp');
  },700);
};

var animateButtonInsertNewQues = function(e) {

  e.preventDefault;
  //reset animation
  //移除和添加class，可用来修改显示
  e.target.classList.remove('animate');
  
  e.target.classList.add('animate');
  setTimeout(function(){
    e.target.classList.remove('animate');
    $(window).attr('location','insertNewQues.jsp');
  },700);
};

//反馈问题
var animateButtonSendReport = function(e) {
//e=window.event||e
  e.preventDefault;
  //reset animation
  e.target.classList.remove('animate');
  
  e.target.classList.add('animate');
  setTimeout(function(){
    e.target.classList.remove('animate');
  },700);
};

//添加事件监听
//根据元素id

var start = document.getElementById("start");
start.addEventListener('click',animateButtonStart,false);

var newQues = document.getElementById("newQues");
newQues.addEventListener('click',animateButtonInsertNewQues,false);

var sendReport = document.getElementById("sendReport");
sendReport.addEventListener('click',animateButtonSendReport,false);

function clickMessage()
{
    if (canClick)
    {
        canClick=false;
    }
    setTimeout("message.jsp",200);
}

function call_back()
{
    alert("跳转");
}