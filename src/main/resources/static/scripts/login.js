
function getYzm(){
	$.get(
        "login/yzm",
    {
    	"user":$("#femail").val()
    },
    function(json){
        console.log(json);
    },"json");
}
