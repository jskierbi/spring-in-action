package norbsoft.sia01;

import norbsoft.sia01.domain.Instrument;
import norbsoft.sia01.domain.Performer;
import norbsoft.sia01.domain.Poem;
import norbsoft.sia01.domain.impl.*;
import org.springframework.context.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

@Configuration
@ComponentScan("norbsoft.sia01")
@EnableAspectJAutoProxy
public class Config {

	@Bean
	public Poem sonnet29Cfg() {

		return new Sonnet29();
	}

	@Bean
	public Performer duke() {

		return new Juggler(10);
	}

	@Bean
	public Performer poeticDuke() {

		return new PoeticJuggler(11);
	}

	@Bean
	public Performer poeticDuke2() {

		return new PoeticJuggler(12, sonnet29Cfg());
	}

	@Bean
	public Stage theStage() {

		return Stage.getInstance();
	}

	@Bean
	@Scope("prototype")
	public Ticket ticket() {

		return new Ticket();
	}

	@Bean
	public Instrument saxophone() {

		return new Saxophone();
	}

	@Bean(initMethod = "onInit", destroyMethod = "onDestroy")
	public Instrument piano() {

		return new Piano();
	}

	@Bean
	public Instrument guitarCfg() {

		return new Guitar();
	}

	@Bean
	public Performer kenny() {

		Instrumentalist kenny = new Instrumentalist();
		kenny.setInstrument(piano());
		kenny.setSong("Jingle bells");
		return kenny;
	}

	@Bean
	public Performer hank() {

		OneManBand band = new OneManBand();
		band.setInstrumentCollection(new ArrayList<Instrument>(){{
			add(saxophone());
			add(piano());
			add(guitarCfg());
		}});

		return band;
	}

	@Bean
	public Performer hankMap() {

		OneManBandMapBased band = new OneManBandMapBased();
		band.setInstrumentMap(new HashMap<String, Instrument>(){{
			put("Saxo", saxophone());
			put("Piano", piano());
			put("Guitar", guitarCfg());
		}});

		return band;
	}

	@Bean
	public Performer propsPerformer() {

		PropertiesPerformer performer = new PropertiesPerformer();
		performer.setProperties(new Properties(){{
			setProperty("first-key", "This is first key value");
			setProperty("Man-doo-line", "Two-tee-ha");
			setProperty("Last:key!","Last key...");
		}});

		return performer;
	}
}
