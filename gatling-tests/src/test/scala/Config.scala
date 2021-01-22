object Config {
  val users = Integer.getInteger("users", 50)
  val apiDelay = Integer.getInteger("apiDelay", 2000)
}
