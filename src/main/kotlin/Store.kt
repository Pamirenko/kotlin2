class Store {
    private val products = mapOf(
        1 to Product("Nike Air Forse", 4000),
        2 to Product("Jordan 1", 5000),
        3 to Product("Jordan 4 Retro", 5000),
        4 to Product("New Balance 580", 4000),
        5 to Product("Nike Air Max", 3500),
        6 to Product("Adidas Samba", 5000),
        7 to Product("Nike Travis Scot",5000)
    )

    fun printAllProducts() {
        products.forEach { (id, product) ->
            println("ID: $id, Название: ${product.name}, Цена: ${product.price}")
        }
    }

    fun buy(productId: Int, user: User) {
        when (productId) {
            in products.keys -> {
                val product = products[productId]!!
                val totalPrice = product.price

                if (totalPrice <= user.balance) {
                    user.balance -= totalPrice

                    println("Вы купили: ${product.name}")
                    println("Списано с баланса: $totalPrice")
                    println("Адрес доставки: ${user.address}")
                    println("Остаток на балансе: ${user.balance}")
                } else {
                    println("Недостаточно средств на балансе")
                }
            }
            else -> {
                println("Вы ввели неверный ID товара")
            }
        }
    }
}