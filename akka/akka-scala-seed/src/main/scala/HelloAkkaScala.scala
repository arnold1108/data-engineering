import akka.actor.Props
import akka.actor.ActorSystem
import akka.actor.Actor
// Defining the Actor Messages 
case class WhoToGreet(who: String)

// Define Greeter Actor 
class Greeter extends Actor {
    def receive = {
        case WhoToGreet(who) => println(s"Hello $who")
    }
}

object HelloAkkaScala extends App {
    // Create the "hello Akka" actor system 
    val system = ActorSystem("Hello-Akka")
    // Create the 'greeter' actor 
    val greeter = system.actorOf(Props[Greeter], "greeter")
    // Send WhoToGreet Message to actor 
    greeter ! WhoToGreet("Akka")
  
}
