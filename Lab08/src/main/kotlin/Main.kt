import kotlinx.serialization.json.*
import java.io.File
import java.util.Scanner
import kotlin.text.reversed

fun main() {
    val inpitFile = File("src/main/resources/input.json")
    val outputFile = File("src/main/resources/output.json")
    var jsonString = inpitFile.readText()
    var routers = Json.decodeFromString<MutableList<Route>>(jsonString)

    println("Version: ${Route.version}\n")
    println("Routers in file:")
    routers.forEach { println(it) }

    val scanner = Scanner(System.`in`)
    println("\nWrite new route from console:")
    routers.add(Route(scanner))

    println("\nRouters, sorted by number:")
    routers.sortedBy { it.number }.forEach { println(it) }

    println("\nChange number:")
    routers.forEach { 
        it.number = "${it.pointOfDeparture.first()}${it.pointOfDestination.first()}" 
        println(it) 
    }

    println("\nChange number again:")
    for(i in 0..routers.size-1){
        routers[i].number?.let { routers[i].number = it.reversed() }
        println(routers[i])
    }

    jsonString = Json.encodeToString(
        routers.filter { 
            setOf(it.pointOfDeparture, it.pointOfDestination).contains("Vasyuki") 
        }
    )
    outputFile.writeText(jsonString)
}
