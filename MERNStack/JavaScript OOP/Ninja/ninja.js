class Ninja {
    constructor(name, health, speed = 3, strength = 3) {
        this.name = name;
        this.health = health;
        this.speed = speed;
        this.strength = strength;
    }

    sayName() {
        console.log("My Name is :" + this.name);
    }

    showStats() {
        console.log(`{ Name: ${this.name}, Health: ${this.health} , Speed = ${this.speed} , Strength = ${this.strength} }`);
    }

    drinkSake() {
        this.health += 10;
    }
}

class Sensei extends Ninja {
    constructor(name, wisdom = 10) {
        super(name, 200, 10, 10);
        this.wisdom = wisdom;
    }
    speakWisdom() {
        this.drinkSake();
        console.log(`${this.name} Says: `+"What one programmer can do in one month, two programmers can do in two months.")
    }

}


const ninja1 = new Ninja("Hanabusa", 100);
ninja1.sayName();
ninja1.drinkSake();
ninja1.showStats();

const superSensei = new Sensei("Master Splinter");
superSensei.speakWisdom();
superSensei.showStats();

