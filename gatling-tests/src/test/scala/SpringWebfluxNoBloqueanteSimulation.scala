import Config.{apiDelay, users}
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class SpringWebfluxNoBloqueanteSimulation extends Simulation {

  val scn = scenario("Spring Webflux No Bloqueante")
    .exec(http("GET").get("http://localhost:8001?responseDelay=" + apiDelay))

  setUp(scn.inject(atOnceUsers(users)))
}