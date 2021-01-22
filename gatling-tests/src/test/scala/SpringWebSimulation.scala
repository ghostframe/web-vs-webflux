import Config.users
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class SpringWebSimulation extends Simulation {

  val scn = scenario("Spring Web")
    .exec(http("GET").get("http://localhost:8000"))

  setUp(scn.inject(atOnceUsers(users)))
}