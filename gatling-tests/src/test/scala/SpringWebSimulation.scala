import Config.users
import Config.apiDelay
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class SpringWebSimulation extends Simulation {

  val scn = scenario("Spring Web")
    .exec(http("GET").get("http://localhost:8000?responseDelay=" + apiDelay))

  setUp(scn.inject(atOnceUsers(users)))
}