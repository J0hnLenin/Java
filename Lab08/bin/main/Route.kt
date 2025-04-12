import kotlinx.serialization.Serializable
import java.util.Scanner

@Serializable
data class Route(
    val pointOfDeparture: String,
    val pointOfDestination: String,
    var number: String?,
){
    constructor(scanner: Scanner) : this(
        pointOfDeparture = readInput(scanner, "Point of departure: "),
        pointOfDestination = readInput(scanner, "Point of destination: "),
        number = readOptionalInput(scanner, "Number: ")
    )

    override fun toString(): String {
        return "Route N:${number ?: "N/A"} $pointOfDeparture - $pointOfDestination"
    }

    companion object {
        fun readInput(scanner: Scanner, prompt: String): String {
            print(prompt)
            return scanner.nextLine()
        }

        fun readOptionalInput(scanner: Scanner, prompt: String): String? {
            print(prompt)
            val input = scanner.nextLine()
            return if (input.isNotEmpty()) input else null
        }

        const val version = 1
    }
}