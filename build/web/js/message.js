/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function AutoLoad(){
        dwr_interface.mg_center(callB1);
        dwr_interface.mc_analysis(callB2);
        //dwr_interface.rwrite();
	changeWindowAuto();
}

function changeWindowAuto(){
	var width=$(document.body).width();
	var height=$(window).height();
	var panelwidth;
	if(width<360)
	{
            panelwidth=width;
            $("#gameDiv").css({
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
            $("#gameDiv").css({
                "width":"360px",
                "height":"636px",
                "top":top+"px",
                "left":left+"px"
            });
	}
        $("#title").css({
            "top":panelwidth*0.46388889,
            "left":panelwidth*0.119444,
            "right":panelwidth*0.119444,
            "font-size":panelwidth*0.0638889
        });
        $("#classes").css({
            "top":panelwidth*0.655556,
            "right":panelwidth*0.097222,
            "font-size":panelwidth*0.04444
        });
        $("#optA").css({
            "top":panelwidth*0.883333,
            "left":panelwidth*0.14444,
            "width":panelwidth*0.71111,
            "font-size":panelwidth*0.055556
        });
        $("#optB").css({
            "top":panelwidth*1.072222,
            "left":panelwidth*0.14444,
            "width":panelwidth*0.71111,
            "font-size":panelwidth*0.055556
        });
        $("#optC").css({
            "top":panelwidth*1.261111,
            "left":panelwidth*0.14444,
            "width":panelwidth*0.71111,
            "font-size":panelwidth*0.055556
        });
        $("#optD").css({
            "top":panelwidth*1.455556,
            "left":panelwidth*0.14444,
            "width":panelwidth*0.71111,
            "font-size":panelwidth*0.055556
        });
        $("#user").css({
            "top":panelwidth*1.686111,
            "right":panelwidth*0.097222,
            "font-size":panelwidth*0.0416667
        });
        $("#score").css({
            "top":panelwidth*0.0694444,
            "left":panelwidth*0.355556,
            "right":panelwidth*0.355556,
            "bottom":panelwidth*1.408333,
            "font-size":panelwidth*0.24444
        });

}

//返回消息条数
function callB1(data)
{
    alert("您有"+data+"条未读消息");
}

//消息内容
function callB2(data)
{
    var div_super=document.getElementById("textA");

    var info="";
    for (var i in data)
    {
        var div_id="div"+i;
        var div=document.createElement("div");
        div.id=div_id;
        div.textContent=data[i];
        div_super.appendChild(div);
        

    }

}

function btn1_click()
{

    var btn = document.createElement("button");
    var btn1= document.getElementById("btn1");
    btn1.appendChild(btn);
}