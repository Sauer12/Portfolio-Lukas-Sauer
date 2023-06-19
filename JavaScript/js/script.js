/* 
    Zakladne operatory
*/

/* var numberX = Number(prompt("Zadaj prve cislo"));
var numberY = Number(prompt("Zadaj druhe cislo"));
var sign = prompt("Zadaj nazov operacie");

if (sign == "+") {
    console.log(numberX + numberY);
} 
else if (sign == "-") {
    console.log(numberX - numberY);
} 
else if (sign == "*") {
    console.log(numberX * numberY);
} 
else if (sign == "/" && numberY != 0) {
    console.log(numberX / numberY);
}
else {
    console.log("Zvolil si zlu operaciu alebo delis nulou!");
}  */

/* var ageDavid = 15;

var drink = (ageDavid >= 18) ? drink = "pivo" : drink = "voda";

console.log(drink); */

/* function calculateAge(birth) {
    console.log(2020 - birth);
}

calculateAge(2000);
calculateAge(1995);
calculateAge(2019);

function calculateAge1(birth) {
    return 2020 - birth;
}

console.log(calculateAge1(2005)); */

/* function calculateAge(birth) {
    return 2021 - birth;
}

function yearsUntilRetirement(year, firstName) {
    var age = calculateAge(year);
    var retirement = 65 - age;

    if(retirement > 0) {
        console.log("Pocet rokov do dochodku: " + retirement + " rokov pre " + firstName);
    }
    else {
        console.log(firstName + " je v dochodku uz " + retirement * -1 + " rokov.")
    }
}

yearsUntilRetirement(2000, "David")
yearsUntilRetirement(1960, "John");
yearsUntilRetirement(1930, "Karol"); */

// Function statements
/* function calculateAge(birth) {
    return 2021 - birth;
}

console.log(calculateAge(2000)); */

// Function expressions
/* var myJob = function(job, firstName) {
    switch(job) {
        case "ucitel":
            return firstName + " je " + job;
        case "manager":
            return firstName + " je " + job;
        default:
            return "Praca " + firstName + " je neznama.";
    }
}

console.log(myJob("ucitel", "Karol")); */

/* var salary = 0;

if(salary || salary == 0){
    console.log("true");
} 
else {
    console.log("false");
} */

// Array

/* var employees = ["David", "Jane", "Diana"];


    push - prida na koniec
    unshift - prida na zaciatok
    pop - odobere posledny
    shift - odobere prvy


employees.push("John");
employees.unshift("Adam");

employees.pop();
employees.shift();

console.log(employees); */

/* var employees = ["Karol", "Peter", "Ferenc", "Marek"];

console.log(employees.indexOf("Peter"));
console.log(employees.indexOf("Marek"));

console.log(employees.length);
console.log(employees[employees.length - 1]); */


/* var lukas = {
    firstName: "Lukáš",
    lastName: "Sauer",
    birthYear: 2000,
    drivingLicence: true,
    family: ["Marek", "Lenka", "Lucia", "Filip"],
    calculateAge: function(){
        return 2021 - this.birthYear;
    }
}

console.log(lukas.calculateAge(1999));

var diana = {
    firstName: "Lukáš",
    lastName: "Sauer",
    birthYear: 2000,
    drivingLicence: true,
    family: ["Marek", "Lenka", "Lucia", "Filip"],
    calculateAge: function(){
        return 2021 - this.birthYear;
    }
} */

/*  
    var diana = new Object();
    diana.firstName = "Diana";
    diana.lastName = "Karlová";
    diana.birthYear = "1998";

    console.log(diana); 
*/

// Cykly for
// for(var a = 1; a <= 10; a++) {
//     console.log(a);
// }

// var employees = ["Lukas", "David", "Karol", "Ema"];

// for(var i = 0; i < employees.length; i++) {
//     console.log(employees[i]);
// }

/* nameSurname = "Lukáš Sauer";

for(var i = 0; i < 12; i++) {
    console.log(nameSurname);
}
for(var i = 0; i < 10; i++) {

    console.log(i + 1);
} */

/* for(var i = 5; i <= 50; i+=5) {
    console.log(i);
} */

/* for(var i = 15; i >= 0; i--) {
    console.log(i);
} */

//Cyklus while
/* 
var i = 0;

while(i < 10) {
    console.log(i);
    i++;
} */

// var i = 0;
// var number = 12;

// while(number >= 1){
//     number = number/2;
//     i++;
// }

// console.log(i);

/* var headline = document.querySelector(".heading1").textContent;
console.log(headline);

document.querySelector(".paragraph").textContent = "Kar karovsky karlovy";
console.log(document.querySelector("p").textContent); */

// var text = document.querySelectorAll("p");

// for(var i = 0; i < text.length; i++) {
//     console.log(text[i].textContent);    
// }

/* var farba = prompt();

if(farba == "blue") {
    document.querySelector("h1").style.color = "blue";
}
else if(farba == "green") {
    document.querySelector("h1").style.color = "green";
} */

// document.querySelector("h1").style.fontSize = "100px";

/* var test = document.querySelector("a").hasAttribute("href");
console.log(test);

var textX = document.getElementById("list").firstElementChild.textContent;
console.log(textX);

var textY = document.getElementById("list").lastElementChild.textContent;
console.log(textY); */

/* var span = document.createElement("span");
console.log(span);

var myH1 = document.querySelector("h1");
console.log(myH1);

document.body.insertBefore(span, myH1); */

/* var test = prompt("Ako sa voláš?");

if (test === "Lukáš") {
    document.querySelector("h1").textContent = "Ahoj, " + test;
}
else {
    document.querySelector("h1").textContent = "Teba nepoznám!"
} */


// EVENTY

// click - kliknutie
// dblclick - dvojite kliknutie
// wheel - koliesko mysi



/* function welcome(){
    console.log("Welcome!");
}

// Callback function
// document.querySelector("h1").addEventListener("click", welcome);

// Anonymná funkcia
document.querySelector("h1").addEventListener("click", function(){
    console.log("Cau");
}); */

/* function myEvent(){
    console.log("Event bol spusteny");
}

document.querySelector("h1").addEventListener("mouseover", myEvent); */

/* var button = document.getElementsByClassName("btn");

button[0].addEventListener("click", clickMe);

function clickMe(){
    var myList = document.getElementById("list");
    var newItem = document.createElement("li");
    newItem.textContent = "Nová položka zoznamu";

    myList.appendChild(newItem);

} */

/* document.body.addEventListener("keydown", myFunction);

function myFunction(e){
    console.log(e.key);
} */

// MOVING SQUARE
/* var cube = document.querySelector("#cube");
console.log(cube);

var style = getComputedStyle(cube);
console.log(parseInt(style.left));

document.body.addEventListener("keydown", myFunction);

function myFunction(event){
    var oldLeft = parseInt(style.left);
    var oldUp = parseInt(style.top);

    if(event.key === "ArrowRight"){        
        var newLeft = oldLeft + 10;
        cube.style.left = newLeft + "px";
    }
    else if(event.key === "ArrowLeft"){
        var newLeft = oldLeft - 10;
        cube.style.left = newLeft + "px";
    }
    else if(event.key === "ArrowUp"){
        var newUp = oldUp - 10;
        cube.style.top = newUp + "px";
    }
    else if(event.key === "ArrowDown"){
        var newUp = oldUp + 10;
        cube.style.top = newUp + "px";
    }

} */






