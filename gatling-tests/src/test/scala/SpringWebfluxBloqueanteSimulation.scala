import Config.{apiDelay, users}
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class SpringWebfluxBloqueanteSimulation extends Simulation {

  val scn = scenario("Spring Webflux Bloqueante")
    .exec(http("GET").get(s"http://localhost:8001/bloqueante?responseDelay=" + apiDelay))

  setUp(scn.inject(atOnceUsers(users)))
}