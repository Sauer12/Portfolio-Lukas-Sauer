const heading = document.getElementById("text");
const speedOriginal = document.getElementById("speed");
console.log(speedOriginal);
const text = "Ahoj, volám sa Lukáš Sauer...";
let idletter = 1;
let speed = 500 / speedOriginal.value;

function printText(){
    heading.innerText = text.slice(0,idletter);
    idletter++;

    if(idletter > text.length){
        idletter = 1;
    }

    setTimeout(printText, speed);
}

printText();

speedOriginal.addEventListener("input", function(event){
    speed = 500 / event.target.value;
});