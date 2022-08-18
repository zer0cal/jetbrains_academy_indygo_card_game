package indigo

val cardFigures = listOf<String>("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K")
val cardColors = listOf<String>("♥", "♦", "♣", "♠")
var cardsInDeck = mutableListOf<String>()
var cardsOnTable = mutableListOf<String>()
var cardsInPlayerHand = mutableListOf<String>()
var cardsInComputerHand = mutableListOf<String>()
var playerScore = 0
var playerWinedCards = 0
var computerScore = 0
var computerWindedCards = 0
var lastWin = 0
var isPlayerFirst = true

fun main() {
    println("Indigo Card Game")
    firstQuestion()
}

fun firstQuestion() {
    println("Play First?")

    when (readln()) {
        "yes" -> {
            isPlayerFirst = true
            startGame(true)
        }
        "no" -> {
            isPlayerFirst = false
            startGame(false)
        }
        else -> firstQuestion()
    }
}

fun startGame(isPlayerFirst: Boolean) {
    reset()
    shuffle()
    printCardsOnTable(true)
    if (isPlayerFirst) {
        playerTurn()
    } else {
        computerTurn()
    }
}

fun bothPlayersDrawCards() {
    if (cardsInDeck.isEmpty()) return
    if (cardsOnTable.isEmpty()) when(lastWin) {
        0 -> {
            if (isPlayerFirst) playerWins()
            else computerWins()
        }
        1 -> playerWins()
        2 -> computerWins()
    }
    cardsInPlayerHand = get(6)
    cardsInComputerHand = get(6)
}

fun playerTurn() {
    printCardsOnTable(false)
    if (cardsInDeck.isEmpty() && cardsInPlayerHand.isEmpty() && cardsInComputerHand.isEmpty()) {
        exit()
        return
    }
    if (cardsInPlayerHand.isEmpty() && cardsInComputerHand.isEmpty()) {
        bothPlayersDrawCards()
    }
    printCardsInPlayerHand()
    if (playerChoseCard()) return
    computerTurn()
}

fun playerChoseCard(): Boolean {
    println("Choose a card to play (1-${cardsInPlayerHand.count()}):")
    val playerChoice = readln()
    if (playerChoice == "exit") {
        exit()
        return true
    }
    val chosenCard = cardsInPlayerHand[playerChoice.toInt() - 1]
    val topCardOnTable = cardsOnTable.lastOrNull() ?: "empty"
    cardsInPlayerHand.remove(chosenCard)
    cardsOnTable.add(chosenCard)
    if (chosenCard.first() == topCardOnTable.first() || chosenCard.last() == topCardOnTable.last()) playerWins()
    return false
}

fun printCardsInPlayerHand() {
    print("Cards in hand:")
    var i = 1
    for (card in cardsInPlayerHand) {
        print(" $i)$card")
        i++
    }
    println()
}

fun playerWins() {
    lastWin = 1
    playerWinedCards += cardsOnTable.count()
    playerScore = countWinedPoints()
    cardsOnTable.clear()
    printScore("Player")
}

fun computerTurn() {
    printCardsOnTable(false)
    if (cardsInDeck.isEmpty() && cardsInComputerHand.isEmpty()) {
        exit()
        return
    }
    if (cardsInPlayerHand.isEmpty() && cardsInComputerHand.isEmpty()) {
        bothPlayersDrawCards()
    }
    computerChoseCard()
    playerTurn()
}

fun printCardsInComputerHand() {
    println(cardsInComputerHand.joinToString(separator = " "))
}

fun computerChoseCard() {
    printCardsInComputerHand()
    val topCardOnTable = cardsOnTable.lastOrNull() ?: "empty"
    val candidates = cardsInComputerHand.filter { it.first() == topCardOnTable.first() || it.last() == topCardOnTable.last() }
    var cardChosenBuComputer: String = cardsInComputerHand.random()
    if (candidates.count() == 1) cardChosenBuComputer = candidates.first()
    if (candidates.count() > 1) {
        val candidatesWithSuit = candidates.filter { it.first() == topCardOnTable.first() }
        if (candidatesWithSuit.isEmpty()) cardChosenBuComputer = candidates.random()
        if (candidatesWithSuit.count() == 1) cardChosenBuComputer = candidatesWithSuit.first()
        if (candidatesWithSuit.count() > 1) cardChosenBuComputer = candidatesWithSuit.random()
    }

    cardsInComputerHand.remove(cardChosenBuComputer)
    cardsOnTable.add(cardChosenBuComputer)
    println("Computer plays $cardChosenBuComputer")
    if (cardChosenBuComputer.first() == topCardOnTable.first() || cardChosenBuComputer.last() == topCardOnTable.last()) computerWins()
}

fun computerWins() {
    lastWin = 2
    computerWindedCards += cardsOnTable.count()
    computerScore = countWinedPoints()
    cardsOnTable.clear()
    printScore("Computer")
}

fun countWinedPoints(): Int {
    val pointsForA = cardsOnTable.count { it.contains("A") }
    val pointsFor10 = cardsOnTable.count { it.contains("10") }
    val pointsForJ = cardsOnTable.count { it.contains("J") }
    val pointsForQ = cardsOnTable.count { it.contains("Q") }
    val pointsForK = cardsOnTable.count { it.contains("K") }
    return pointsForA + pointsFor10 + pointsForJ + pointsForQ + pointsForK
}

fun printCardsOnTable(initial: Boolean) {
    if (initial) {
        cardsOnTable.addAll(get(4))
        println("Initial cards on the table: ${cardsOnTable.joinToString(separator = " ")}")
        return
    }
    if (cardsOnTable.isNotEmpty()) {
        println("\n${cardsOnTable.count()} cards on the table, and the top card is ${cardsOnTable.last()}")
        return
    }
    println("\nNo cards on the table")
}

fun printScore(whoWins: String) {
    println("$whoWins wins cards")
    println("Score: Player $playerScore - Computer $computerScore")
    println("Cards: Player $playerWinedCards - Computer $computerWindedCards")
}

fun resetDeck() {
    cardsInDeck.clear()
    for (figure in cardFigures) {
        for (color in cardColors) {
            cardsInDeck.add("$figure$color")
        }
    }
}

fun shuffleDeck() {
    cardsInDeck.shuffle()
}

fun reset() {
    resetDeck()
    cardsOnTable = mutableListOf()
    cardsInPlayerHand = mutableListOf()
    cardsInComputerHand = mutableListOf()
}

fun shuffle() {
    shuffleDeck()
}

fun get(numberOfCards: Int): MutableList<String>  {
    if (numberOfCards < 1 || numberOfCards > 52) {
        return mutableListOf()
    }
    if (cardsInDeck.count() < numberOfCards) {
        return mutableListOf()
    }

    var cards = mutableListOf<String>()
    for (i in 1..numberOfCards) {
        cards.add(cardsInDeck.last())
        cardsInDeck.removeLast()
    }
    return cards
}

fun exit() {
    println("Game Over")
}