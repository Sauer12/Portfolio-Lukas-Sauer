
/* let firstName = "Lukáš"
let age = 21

console.log("Volam sa " + firstName + " a mam " + age + " rokov.")
console.log("Za 5 rokov mi bude " + (age + 5) + " rokov") */

/* let student1 = 50   
let student2 = 75

let student1Name = "Karol"
let student2Name = "Peter"

console.log(student1Name + " dosiahol " + student1 + "% úspešnosti.");
console.log(student2Name + " dosiahol " + student2 + "% úspešnosti.");

let age = 100
let child = age < 18
let adult = age >= 18 && age < 65
let pensioner = age >= 65

console.log("Dieta: " + child);
console.log("Dospely: " + adult);
console.log("pensioner: " + pensioner); */

/* let pozicia = "administrator"

if(pozicia === "programator"){
    console.log("Aky je rozdiel medzi HTML, CSS a JavaScriptom?")
}
else if(pozicia === "administrator"){
    console.log("Ake druhy sieti poznate?")
}
else if(pozicia === "sekretarka"){
    console.log("Ake druhy funkcii v exceli poznate?")
}
else{
    console.log("Nepoznam otazku na danu poziciu")
} */

/* let temperature = 34

if(temperature <= 10){
    console.log("Chladno")
}
else if(temperature >= 11 && temperature <= 25){
    console.log("teplo")
}
else if(temperature > 25){
    console.log("horko")
}

let vyskaPachatela = 180
let vahaPachatela = 102

if(vyskaPachatela > 190 || vahaPachatela > 100){
    console.log("Pachatelia");
}

let naDruhu = (num) => console.log(num * num)

naDruhu(2)
naDruhu(5)
naDruhu(10)

let zdraviacaFunkcia = (name) => console.log("Ahoj, ja som " + name)

zdraviacaFunkcia("Lukas")
zdraviacaFunkcia("Karol")
zdraviacaFunkcia("Peter")

let adultChecker = function(vek){
    if(vek >= 18){
        return "dospely"
    }
    else{
        return "dieta"
    }
}

let clovek = adultChecker(17)

if(clovek === "dospely"){
    console.log("Vysledok kontroly veku: " + clovek)
    console.log("Mozete vstupit!")
}
if(clovek === "dieta"){
    console.log("Vysledok kontroly veku: " + clovek)
    console.log("Nemozete vstupit!")
} */

/* let firstNumber = 5
let secondNumber = 5
let thirdNumber = 3

let verifikacia = function(first, second, third){
    if(first === firstNumber && second === secondNumber && third === thirdNumber){
        return "Mozete vstupit!"
    }
    else{
        return "Zle zadany kod. Skuste to prosim znovu"
    }
}

let vstup = verifikacia(5,5,5)
console.log(vstup)

let myName = "Harry Potter"
let age = 15
console.log("Ahoj, ja som " + myName + " a mam " + age + " rokov")
console.log(`Ahoj, ja som ${myName} a je mi ${age} rokov`)

let pozdrav = function(firstName, lastName){
    console.log(`Ahoj, ja som ${firstName} ${lastName}.`)
}

pozdrav("Lukas","Sauer") */

/* let firstName = "Harry"
let secondName = "Potter"
let age = 15
let firstFriend = "Ron"
let secondFriend = "Hermiona"

console.log(`Ahoj, volam sa ${firstName} ${secondName} a mam ${age} rokov. Moji priatelia su ${firstFriend} a ${secondFriend}`)

let movie = "Ospala dira"
let director = "Tim Burton"
let award = "najlepsi vykon vo vyprave"

console.log(`Videl som firm ${movie}, ktory reziroval ${director}. Tento film ziskal ocenenie ${award}.`) */

/* let myBook = {
    title: "Harry Potter a kamen mudrcov",
    author: "J. K. Rowlingova",
    published: 1997
}

let secondBook = {
    title: "Harry Potter a tajomna komnata",
    author: "J. K. Rowlingova",
    published: 1998
}

let resultBook = function(book){
    console.log(`Kniha od ${book.author} z roku ${book.published} sa vola ${book.title}`)
}

resultBook(myBook)
resultBook(secondBook)




console.log(myBook)
console.log(myBook.author)
console.log(myBook.published)

console.log(`${myBook.title} je kniha od autorky ${myBook.author} a bola vydana v roku ${myBook.published}`)

let person1 = {
    meno: "Lukas",
    vek: "21",
    mesto: "Kosice"
}

let person2 = {
    meno: "Karol",
    vek: "25",
    mesto: "Bratislava"
}

let person3 = {
    meno: "Anna",
    vek: "19",
    mesto: "Presov"
}

let personPrintout = function(person){
    console.log(`Volam sa ${person.meno}, mam ${person.vek} a byvam v ${person.mesto}`)
}

personPrintout(person1)
personPrintout(person2)
personPrintout(person3) */

/* console.log(`Volam sa ${person1.meno}, mam ${person1.vek} a pochadzam z mesta ${person1.mesto}`)
console.log(`Volam sa ${person2.meno}, mam ${person2.vek} a pochadzam z mesta ${person2.mesto}`)
console.log(`Volam sa ${person1.meno}, mam ${person1.vek} a pochadzam z mesta ${person3.mesto}`) */

/* let school = {
    type: "gymnazium",
    street: "Komenskeho 34",
    city: "Kosice",
    capacity: 300,
    open: function(){
        console.log("Skola je otvorena")
    },
    closed: function(){
        return "Skola je zatvorena"
    }
}

console.log(school.type)
console.log(school.city)
school.open()
console.log(school.closed()) */

/* let person1 = {
    firstName: "Lukáš",
    secondName: "Sauer",
    age: 21,
    greet: function(){
        console.log(this.firstName)
    }
}

let person2 = {
    firstName: "Marek",
    secondName: "Sauer",
    age: 47,
    greet: function(){
        console.log(this.firstName)
    }
}

console.log(person1) */

/* let vladneNariadenie = false

let school = {
    type: "Gymnazium",
    street: "Hlavna 23",
    city: "Košice",
    capacity: 500,
    open: function(){
        console.log(`Škola ${this.type} na ulici ${this.street} je otvorená.`)
    },
    closed: function(){
        console.log(`Škola ${this.type} na ulici ${this.street} je zatvorená.`)
    }
}

if(vladneNariadenie){
    school.closed()
}
else{
    school.open()
} */

/* let firstName = "Lukáš"

console.log(firstName.length)
console.log(firstName.toUpperCase())
console.log(firstName.toLowerCase())

let sentence = "Cus bus Autobus!"
console.log(sentence.includes("Cus"))

let secondName = "Sauer"
console.log(secondName.trim()) */

/* let password = "Neviem123"

if(password.length > 13){
    console.log("Veľmi silné heslo")
}
else if(password.length >= 8 && password.length <= 13){
    console.log("Silné heslo")
}
else{
    console.log("Slabé heslo")
}

if(password.includes("1234")){
    console.log("Heslo nesmie obsahovať 1234")
}
else{
    console.log("Heslo je v poriadku")
} */

/* let number = 3.1438

console.log(number.toFixed(3))
console.log(Math.round(number))
console.log(Math.ceil(number))
console.log(Math.floor(number))

console.log(Math.ceil(Math.random() * 10)) */

// let min = 15
// let max = 20
// console.log(Math.floor(Math.random() * (max - min + 1)) + min)


/* let min = 1
let max = 6
let number1 = Math.floor(Math.random() * (max - min +1)) + min
let number2 = Math.floor(Math.random() * (max - min +1)) + min
let number3 = Math.floor(Math.random() * (max - min +1)) + min
let number4 = Math.floor(Math.random() * (max - min +1)) + min
let number5 = Math.floor(Math.random() * (max - min +1)) + min
let number6 = Math.floor(Math.random() * (max - min +1)) + min

let sum = number1 + number2 + number3 + number4 + number5 + number6

if(sum >= 25){
    console.log("Vitaz: " + sum)
}
else{
    console.log("Skus svoje stastie znova: " + sum)
} */

/* let adult = false

adult = true

console.log(adult)

let employees = ["David", "Marek", "Jana"]

console.log(employees[0])

let data = [15, "Karol", true]
console.log(data)

// dlzka pole
console.log(data.length) */

/* let passwords = ["Heslo123", "Karolko", "penisDenis"]

let number = Math.floor(Math.random() * (passwords.length))

console.log(passwords[number]) */

/* let testArray = ["test1", "test2", "test3"]
console.log(testArray[0])

let myArray = [1, 2, 3]

myArray.push(4)

console.log(myArray)

myArray.pop()
console.log(myArray)

myArray.unshift("Nulty")
console.log(myArray)

myArray.shift()
console.log(myArray) */

/* let mySecondArray = ["Jedna", "Dva", "Tri"]
mySecondArray.splice(0, 1)
console.log(mySecondArray)

let myThirdArray = [1, 2, 4]
myThirdArray.splice(2, 0, 3)
console.log(myThirdArray) */

/* let names = []

for(let i = 0; i < 3; i++){
    let name = prompt("Zadaj meno")
    if(name != null && name != ""){
        console.log(name)
        names.push(name)
    }
}

for(let i = 0; i < 3; i++){
    let name = prompt("Zadaj meno")
    if(name != null && name != ""){
        console.log(name)
        names.unshift(name)
    }
}

console.log(names) */

/* let employees = ["David", "Harry", "Hermiona", "Ron"]

employees.forEach(function(){
    console.log("testujeme")
})

employees.forEach(function(person){
    console.log(person)
})

employees.forEach(function(person, index){
    console.log(index + " - " + person)
}) */

/* let toDo = ["vyvencit psa", "kupit kecup", "vymalovat izbu", "urobit si olovrant"]

toDo.forEach(function(list, index){
    console.log(index + 1 + ". " + list)
}) */

// for(let i = 0; i <= 5; i++){
//     console.log(i)
// }

/* let toDo = ["zostrihat video", "poupratovat izbu", "vyluxovat"]

for(let i = 0; i < toDo.length; i++){
    console.log(`${i + 1}. ${toDo[i]}`)
}

let pole = []

for(let i = 0; i < 5; i++){
    pole[i] = i
}

pole.forEach(function(index){
    console.log(index)
}) */

/* let people = ["Lukáš", "David", "Anna"]

console.log(people.indexOf("Anna"))

let books = [{
    title: "Kanal a potkan",
    author: "Karolko Nevisky",
    published: 1997
}, {
    title: "Nemenovana kniha",
    author: "Marek Urban",
    published: 2000
}, {
    title: "Code Geass",
    author: "Ikiharo Nakishita",
    published: 20010
}]

console.log(books[0].title)
console.log(books[0].author)
console.log(books[0].published)

console.log(books.indexOf({}))

let array = [8, 11, 9, 20, 30]

let result = array.findIndex(function(number){
    return number > 15
})

console.log(result)

let idk = books.findIndex(function(oneBook){
    return oneBook.published === 2000
})

console.log(idk) */

/* let criminals = [{
    firstName: "Martin",
    secondName: "Zelený",
    birth: 1995,
    address: "U sloupú 16",
    city: "České Budějovice"
}, {
    firstName: "Jana",
    secondName: "Rehocká",
    birth: 1995,
    address: "U sloupú 16",
    city: "České Budějovice"
}, {
    firstName: "Filip",
    secondName: "Zelený",
    birth: 1989,
    address: "U sloupú 16",
    city: "České Budějovice"
}]

let podozriveMeno = prompt()
let index = criminals.findIndex(function(person){
    return person.firstName === podozriveMeno
})

if(index != -1){
    console.log("Meno: " +criminals[index].firstName)
    console.log("Priezvisko: " + criminals[index].secondName)
    console.log("Datum narodenia: " + criminals[index].birth)
    console.log("Adresa: " + criminals[index].address)
    console.log("Mesto: " + criminals[index].city)
}
else{
    console.log("Zadane meno sa nenachadza v databazi podozrivych")
} */



let myArray = [1, 3, 5, 2, 8]

let result = myArray.find(function(oneNumber){
    return oneNumber > 4
})

// let result = myArray.find(oneNumber => oneNumber > 4)

console.log(result)

let books = [{
    title: "Kanal a potkan",
    author: "Karolko Nevisky",
    published: 1997
}, {
    title: "Nemenovana kniha",
    author: "Marek Urban",
    published: 2000
}, {
    title: "Code Geass",
    author: "Ikiharo Nakishita",
    published: 2010
}]

result = books.find(function(oneBook){
    if(oneBook.published === 2000){
        return oneBook
    }
})

console.log(result.title)







