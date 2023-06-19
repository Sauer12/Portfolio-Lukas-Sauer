const slides = document.querySelectorAll(".slide");
// console.log(slides);

slides.forEach(function(oneslide){
    oneslide.addEventListener("click", function(){
        // active sa vymaze vsetkym
        deleteActiveClass();
        oneslide.classList.add("active");
    })
})

function deleteActiveClass(){
    slides.forEach(function(mySlide){
        mySlide.classList.remove("active");
    })
}