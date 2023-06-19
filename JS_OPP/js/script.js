var Car = function(wheels, color, brand, tank, distance){
    this.wheels = wheels;
    this.color = color;
    this.brand = brand;
    this.tank = tank;
    this.distance = distance;
    this.calculateDistance = function(){
        return this.tank * this.distance;
    };
}

Car.prototype.type = "Riadené ľuďmi";

var car1 = new Car(4, "red", "Nissan", 40, 7);
var car2 = new Car(4, "blue", "Toyota", 35, 6);

console.log(car1.wheels);
console.log(car2.color);
console.log(car1.calculateDistance());