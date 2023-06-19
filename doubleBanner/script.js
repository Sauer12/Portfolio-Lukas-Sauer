const containerSlider = document.querySelector(".container-slider");
const slideLeft = document.querySelector(".slide-left");
const slideRight = document.querySelector(".slide-right");
const arrowUp = document.querySelector(".arrow-up");
const arrowDown = document.querySelector(".arrow-down");
const slidesLength = slideRight.querySelectorAll("div").length - 1;

console.log(slidesLength);

let numberActiveSlide = 0;

slideLeft.style.top = `${slidesLength * -100}vh`;

console.log(slideLeft.style.top);

arrowUp.addEventListener("click", function(){
    changeSlide("up");
});

arrowDown.addEventListener("click", function(){
    changeSlide("down");
});

function changeSlide(direction){
    const sliderHeight = containerSlider.clientHeight;

    if(direction === "up"){
        numberActiveSlide++;
        if(numberActiveSlide > slidesLength){
            numberActiveSlide = 0;
        }
    }
    else {
        numberActiveSlide--;
        if(numberActiveSlide < 0){
            numberActiveSlide = slidesLength;
        }
    }

    slideRight.style.transform = `translateY(-${sliderHeight * numberActiveSlide}px)`;
    slideLeft.style.transform = `translateY(${sliderHeight * numberActiveSlide}px)`;
}