//Card Class
class Card {
    constructor(name, cost) {
        this.name = name;
        this.cost = cost;
    }
}

//Unit Class
//Parent : Card Class
class Unit extends Card {
    constructor(name, cost, resilience, power) {
        super(name, cost);
        this.power = power;
        this.resilience = resilience;
    }

    //Do Attack on target
    attack(enemy) {
        if (enemy instanceof Unit) {
            console.log(`==> ${this.name} attacked ${enemy.name} and deducted ${this.power} from their resilience`);
            enemy.reduceResilience(this.power);
        } else {
            throw new Error("Target must be a unit!");
        }
    }

    //Change stats
    reduceResilience(amount) {
        this.resilience -= amount;
    }

    reducePower(amount) {
        this.power -= amount;
    }

    increaseResilience(amount) {
        this.resilience += amount;
    }

    increasePower(amount) {
        this.power += amount;
    }

    //View Stats
    viewStats() {
        console.log(`>>> Name: ${this.name} ,Resilience: ${this.resilience} ,Power: ${this.power}`)
    }
}

//Effect Class
//Parent : Card Class
class Effect extends Card {
    constructor(name, cost, text) {
        super(name, cost);
        this.text = text;
    }

    play(target) {
        if (target instanceof Unit) {
            const regex = /(?<=(by ){1})(\d+)/g;
            const str = this.text;
            let amount = str.match(regex);
            if (amount == null) {
                throw new Error("Card Format not Supported yet or Wrong!");
            }
            if (this.text.toLowerCase().includes("increase")) {
                if (this.text.toLowerCase().includes("power")) {
                    console.log(`[played effect of card ${this.name} on unit ${target.name} and increased its power by ${amount}]`)
                    target.increasePower(parseInt(amount));
                } else if (this.text.toLowerCase().includes("resilience")) {
                    console.log(`[played effect of card ${this.name} on unit ${target.name} and increased its resilience by ${amount}]`)
                    target.increaseResilience(parseInt(amount));
                } else {
                    throw new Error("Card Format not Supported yet or Wrong!");
                }
            } else if (this.text.toLowerCase().includes("reduce")) {
                if (this.text.toLowerCase().includes("power")) {
                    console.log(`[played effect of card ${this.name} on unit ${target.name} and decreased its power by ${amount}]`)
                    target.reducePower(parseInt(amount));
                } else if (this.text.toLowerCase().includes("resilience")) {
                    console.log(`[played effect of card ${this.name} on unit ${target.name} and decreased its resilience by ${amount}]`)
                    target.reduceResilience(parseInt(amount));
                } else {
                    throw new Error("Card Format not Supported yet or Wrong!");
                }
            } else {
                throw new Error("Card Format not Supported yet or Wrong!");
            }
        } else {
            throw new Error("Target must be a unit!");
        }
    }
}

//Declarations

//Units
Red_Belt_Ninja = new Unit("Red Belt Ninja", 3, 3, 3);
Black_Belt_Ninja = new Unit("Black Belt Ninja", 4, 4, 5);

//Effects
hardalgo = new Effect("Hard Algorithm", 2, "increase target's resilience by 3");
upr = new Effect("Unhandled Promise Rejection", 1, "reduce target's resilience by 2");
pairprogram = new Effect("Pair Programming", 3, "increase target's power by 2");


//Tests
Black_Belt_Ninja.viewStats();
hardalgo.play(Black_Belt_Ninja);
upr.play(Black_Belt_Ninja);
pairprogram.play(Black_Belt_Ninja);
Red_Belt_Ninja.attack(Black_Belt_Ninja);
Black_Belt_Ninja.viewStats();



