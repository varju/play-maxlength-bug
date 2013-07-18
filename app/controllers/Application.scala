package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {
  
  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def maxlen = Action(parse.maxLength(5, parser = parse.anyContent)) { implicit request =>
    request.body match {
      case Left(maxSize) => BadRequest("exceeded maxSize " + maxSize)
      case Right(body) => Ok("accepted")
    }
  }
}
