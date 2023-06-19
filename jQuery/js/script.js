$(function(){

    $("li").filter(function(index){
        return index == 5;
    }).css("background-color", "#FA023A");


    // $("li:last").prev().css("background-color", "#24FABC");
    // $("li:first").parent().css("background-color", "#24FABC");
    // $("input:text").css("background-color", "rgba(150, 150, 40, 0.8");
    // $("li:odd").css("background-color", "rgba(150, 150, 40, 0.8");
    // $("li:first").css("background-color", "#555");
    // $("li:last").css("background-color", "#333");


    // $("p:last").css("background-color", "#555");


    // $(".red-box").css("background-color",
    // "rgba(150, 150, 40, 0.8)");

    
    // $(".blue-box").animate({
    //     marginLeft: "500px",
    //     opacity: "0",
    //     width: "50px",
    //     height: "50px",
    //     marginTop: "25px"
    // }, 1000);


    // $(".red-box").fadeTo(1000, 0.2);
    // $(".blue-box").delay(1000).fadeTo(1000, 0.3);
    // $(".green-box").delay(2000).fadeTo(1000, 0.6);
    // $(".yellow-box").delay(3000).fadeTo(1000, 0.8);


    // $(".red-box").fadeTo(2000, 0, function(){
    //     $(".blue-box").fadeTo(2000, 0, function(){
    //         $(".green-box").fadeTo(2000, 0)
    //     });
    // });
});