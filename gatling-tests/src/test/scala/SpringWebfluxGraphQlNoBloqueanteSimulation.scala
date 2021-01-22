import Config.{apiDelay, users}
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class SpringWebfluxGraphQlNoBloqueanteSimulation extends Simulation {

  val scn = scenario("Spring Webflux GraphQL Bloqueante")
    .exec(
      http("GET")
        .post("http://localhost:8001/graphql")
        .header("Content-Type","application/json")
        .body(StringBody("{\"query\":\"query{ noBloqueante(responseDelay: " + apiDelay + ") }\"}")))

  setUp(scn.inject(atOnceUsers(users)))
}