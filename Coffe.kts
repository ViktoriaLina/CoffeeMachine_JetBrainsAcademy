package machine

// показать, сколько сейчас в машине ингредиентов
fun showIngredients(machine: MutableMap<String, Int>) {
    println("The coffee machine has: ")
    println("${machine["water"]} ml of water")
    println("${machine["milk"]} ml of milk")
    println("${machine["coffeeBeans"]} g of coffee beans")
    println("${machine["disposableCups"]} disposable cups")
    println("$${machine["money"]} of money")
}

// сделать эспрессо
fun makeEspresso(machine: MutableMap<String, Int>): MutableMap<String, Int> {
    val water = 250 // вода на 1 чашку эспрессо
    val coffeeBeans = 16 // зерна на 1 чашку эспрессо
    val disposableCups = 1 // одноразовый стаканчик на 1 чашку эспрессо
    val price = 4 // цена за 1 чашку эспрессо

    if ((machine["water"]!! >= water && machine["coffeeBeans"]!! >= coffeeBeans) && machine["disposableCups"]!! >= disposableCups) {
        println("I have enough resources, making you a coffee!")

        machine["water"] = machine["water"]!! - water
        machine["coffeeBeans"] = machine["coffeeBeans"]!! - coffeeBeans
        machine["disposableCups"] = machine["disposableCups"]!! - disposableCups
        machine["money"] = machine["money"]!! + price
    } else {
        if (machine["water"]!! < water) {
            println("Sorry, not enough water!")
        }
        if (machine["coffeeBeans"]!! < coffeeBeans) {
            println("Sorry, not enough coffee beans!")
        }
        if (machine["disposableCups"]!! < disposableCups) {
            println("Sorry, not disposable cups!")
        }
    }

    return machine
}

fun makeLatte(machine: MutableMap<String, Int>) {
    val water = 350 // вода на 1 чашку латте
    val milk = 75 // молоко на 1 чашку латте
    val coffeeBeans = 20 // зерна на 1 чашку латте
    val disposableCups = 1 // одноразовый стаканчик на 1 чашку
    val price = 7 // цена за 1 чашку латте

    if ((machine["water"]!! >= water && machine["milk"]!! >= milk) && (machine["coffeeBeans"]!! >= coffeeBeans && machine["disposableCups"]!! >= disposableCups)) {
        println("I have enough resources, making you a coffee!")

        machine["water"] = machine["water"]!! - water
        machine["milk"] = machine["milk"]!! - milk
        machine["coffeeBeans"] = machine["coffeeBeans"]!! - coffeeBeans
        machine["disposableCups"] = machine["disposableCups"]!! - disposableCups
        machine["money"] = machine["money"]!! + price
    } else {
        if (machine["water"]!! < water) {
            println("Sorry, not enough water!")
        }
        if (machine["milk"]!! < milk) {
            println("Sorry, not enough milk!")
        }
        if (machine["coffeeBeans"]!! < coffeeBeans) {
            println("Sorry, not enough coffee beans!")
        }
        if (machine["disposableCups"]!! < disposableCups) {
            println("Sorry, not disposable cups!")
        }
    }
}

fun makeCappuccino(machine: MutableMap<String, Int>) {
    val water = 200 // вода на 1 чашку капучино
    val milk = 100 // молоко на 1 чашку капучино
    val coffeeBeans = 12 // зерна на 1 чашку капучино
    val disposableCups = 1 // одноразовый стаканчик на 1 чашку
    val price = 6 // цена за 1 чашку капучино

    if ((machine["water"]!! >= water && machine["milk"]!! >= milk) && (machine["coffeeBeans"]!! >= coffeeBeans && machine["disposableCups"]!! >= disposableCups)) {
        println("I have enough resources, making you a coffee!")

        machine["water"] = machine["water"]!! - water
        machine["milk"] = machine["milk"]!! - milk
        machine["coffeeBeans"] = machine["coffeeBeans"]!! - coffeeBeans
        machine["disposableCups"] = machine["disposableCups"]!! - disposableCups
        machine["money"] = machine["money"]!! + price
    } else {
        if (machine["water"]!! < water) {
            println("Sorry, not enough water!")
        }
        if (machine["milk"]!! < milk) {
            println("Sorry, not enough milk!")
        }
        if (machine["coffeeBeans"]!! < coffeeBeans) {
            println("Sorry, not enough coffee beans!")
        }
        if (machine["disposableCups"]!! < disposableCups) {
            println("Sorry, not disposable cups!")
        }
    }
}

// купить кофе
fun buy(machine: MutableMap<String, Int>) {
    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
    var choiceCoffee = readln()

    when (choiceCoffee) {
        "1" -> makeEspresso(machine)
        "2" -> makeLatte(machine)
        "3" -> makeCappuccino(machine)
        "back" -> return
    }
}

// заполнить машину ингредиентами
fun fill(machine: MutableMap<String, Int>) {
    println("Write how many ml of water you want to add: ")
    var waterAdd = readln().toInt()
    println("Write how many ml of milk you want to add: ")
    var milkAdd = readln().toInt()
    println("Write how many grams of coffee beans you want to add: ")
    var coffeeBeansAdd = readln().toInt()
    println("Write how many disposable cups you want to add: ")
    var disposableCupsAdd = readln().toInt()

    machine["water"] = machine["water"]!! + waterAdd
    machine["milk"] = machine["milk"]!! + milkAdd
    machine["coffeeBeans"] = machine["coffeeBeans"]!! + coffeeBeansAdd
    machine["disposableCups"] = machine["disposableCups"]!! + disposableCupsAdd
}

// достать деньги из кофемашины
fun take(machine: MutableMap<String, Int>) {
    println("I gave you $${machine["money"]}")
    machine["money"] = 0
}

fun main() {
    var machine = mutableMapOf(
        "water" to 400,
        "milk" to 540,
        "coffeeBeans" to 120,
        "disposableCups" to 9,
        "money" to 550
    )

    do {
        println()
        println("Write action (buy, fill, take, remaining, exit): ")
        var userChoice = readln()

        when (userChoice) {
            "buy" -> {
                buy(machine)
            }
            "fill" -> {
                fill(machine)
            }
            "take" -> {
                take(machine)
            }
            "remaining" -> {
                showIngredients(machine)
            }
        }
    } while (userChoice != "exit")
}
main()
    /* println("""Starting to make a coffee
Grinding coffee beans
Boiling water
Mixing boiled water with crushed coffee beans
Pouring coffee into the cup
Pouring some milk into the cup
Coffee is ready!""") */

/* println("Write how many ml of water the coffee machine has: ")
var waterMachine = readln().toInt()

println("Write how many ml of milk the coffee machine has: ")
var milkMachine = readln().toInt()

println("Write how many grams of coffee beans the coffee machine has: ")
var coffeeBeansMachine = readln().toInt()

println("Write how many cups of coffee you will need: ")
var numberCupsNeed = readln().toInt() */

/*val water = 200 // вода на 1 чашку кофе
val milk = 50 // молоко на 1 чашку кофе
val coffeeBeans = 15 // зерна на 1 чашку кофе

var waterReal = waterMachine
var milkReal = milkMachine
var coffeeBeansReal = coffeeBeansMachine
var realCups = 0 // столько кружек кофе по факту

while (waterReal >= water && milkReal >= milk && coffeeBeansReal >= coffeeBeans) {
    waterReal -= water
    milkReal -= milk
    coffeeBeansReal -= coffeeBeans
    realCups ++
}

var extraCups = realCups - numberCupsNeed // столько кружек кофе осталось в запасе
if (extraCups < 0 ) {
    extraCups = 0
}

/*println("For $numberCupsNeed cups of coffee you will need: ")
println("""$waterNeed ml of water
$milkNeed ml of milk
$coffeeBeansNeed g of coffee beans""") */

if (numberCupsNeed <= realCups) {
    if (extraCups > 0) {
        println("Yes, I can make that amount of coffee (and even $extraCups more than that)")
    } else {
        println("Yes, I can make that amount of coffee")
    }
} else {
    println("No, I can make only $realCups cups of coffee")
}

 */


