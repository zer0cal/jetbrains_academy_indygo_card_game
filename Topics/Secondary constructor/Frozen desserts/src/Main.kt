class IceCreamOrder {
    val price: Int

    constructor(popsicles: Int) {
        this.price = 7 * popsicles
    }

    constructor(scoops: Int, toppings: Int) {
        this.price = 5 * scoops + 2 * toppings
    }
}