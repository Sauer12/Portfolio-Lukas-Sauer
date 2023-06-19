(function($){
     $(function(){      
        // Scroll to sections 
        $(".jq--scroll-our-pizza").click(function(){
            $("html").animate({scrollTop: $(".jq--our-pizza").offset().top}, 500);
        });

        $(".jq--scroll-about-pizza").click(function(){
            $("html").animate({scrollTop: $(".jq--about-pizza").offset().top}, 500);
        });

        $(".jq--scroll-references").click(function(){
            $("html").animate({scrollTop: $(".jq--references").offset().top}, 500);
        });

        $(".jq--scroll-photogallery").click(function(){
            $("html").animate({scrollTop: $(".jq--photogallery").offset().top}, 500);
        });

        $(".jq--scroll-contact-form").click(function(){
            $("html").animate({scrollTop: $(".jq--contact-form").offset().top}, 500);
        });

        // Scroll buttons to sections 
        $(".jq--scroll-btn-first").click(function(){
            $("html").animate({scrollTop: $(".jq--our-pizza").offset().top}, 500);
        });

        $(".jq--scroll-btn-second").click(function(){
            $("html").animate({scrollTop: $(".jq--photogallery").offset().top}, 500);
        });

        /*  Mobile navigation */
        $(".jq--nav-icon").click(function() {
            $(".nav-background").fadeToggle();
            $(".mobile-nav-back").fadeToggle();
            $("nav ul").fadeToggle();
        });

        // Hamburger x Cross
        $(".jq--image-hamburger").click(function(){
            if($(".jq--image-hamburger").attr("src") == "img/hamburgerMenu.png") {
                $($(".jq--image-hamburger").attr("src", "img/crossMenu.png"));
            }
            else {
                $($(".jq--image-hamburger").attr("src", "img/hamburgerMenu.png"));
            }
        });

    });
})(jQuery);