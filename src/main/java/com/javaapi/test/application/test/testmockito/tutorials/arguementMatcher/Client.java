package com.javaapi.test.application.test.testmockito.tutorials.arguementMatcher;

import com.google.common.base.Function;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 *自定义matcher
 *
 */
public class Client {
	@Test
	public void should_run_customer_mockito_matcher() throws Exception {
	 
	    final GameDao gameDao = mock(GameDao.class);
	    gameDao.addRate(new Game("签到", 7));
	 
	    verify(gameDao).addRate(Mockito.argThat(new PartyMatcher<Game>(new Function<Game, Object>() {
	        @Override
	        public Object apply(Game game) {
	            return game.getRate();
	        }
	    }, 7)));
	 
	    verify(gameDao).addRate(Mockito.argThat(new PartyMatcher<Game>(new Function<Game, Object>() {
	        @Override
	        public Object apply(Game game) {
	            return game.getType();
	        }
	    }, "签到")));
	}
}
