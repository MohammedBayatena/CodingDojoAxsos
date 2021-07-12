class Ninja{
    constructor(name , health , speed = 3 , strength = 3){
        this.name = name;
        this.health = health;
        this.speed = speed;
        this.strength = strength;
    }

    sayName(){
        console.log("My Name is :" + this.name );
    }
    showStats(){
        console.log(`{ Health: ${this.health} , Speed = ${this.speed} , Strength = ${this.strength} }`);
    }
    drinkSake(){
        this.health+=10;
    }

}

const ninja1 = new Ninja("Hanabusa",100);
ninja1.sayName();
ninja1.drinkSake();
ninja1.showStats();