/**
 * 
 */
package controllers;

import play.Application;
import play.ApplicationLoader;
import play.inject.guice.GuiceApplicationBuilder;
import play.inject.guice.GuiceApplicationLoader;
import services.KafkaComsumers;
import services.Propertiesz;

/**
 * @author abhimanyu
 *
 */
public class KafkaModule extends GuiceApplicationLoader {

	@Override
	public GuiceApplicationBuilder builder(ApplicationLoader.Context context) {
		GuiceApplicationBuilder guiceApplicationBuilder = initialBuilder.in(context.environment())
				.overrides(overrides(context));

		Application application = guiceApplicationBuilder.build();
		guiceApplicationBuilder.injector().instanceOf(Propertiesz.class);
		KafkaComsumers comsumers = new KafkaComsumers();
		comsumers.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return guiceApplicationBuilder;

	}
}
