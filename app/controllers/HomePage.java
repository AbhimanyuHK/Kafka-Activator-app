/**
 * 
 */
package controllers;

import play.mvc.Result;
import play.mvc.Controller;

/**
 * @author abhimanyu
 *
 */
public class HomePage extends Controller {

	public Result homePage() {

		return ok("Application started");

	}
}
