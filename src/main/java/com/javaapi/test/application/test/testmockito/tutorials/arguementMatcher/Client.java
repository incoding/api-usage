package com.javaapi.test.application.test.testmockito.tutorials.arguementMatcher;

import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * 自定义matcher
 */
public class Client {
    @Test
    public void should_run_customer_mockito_matcher() throws Exception {

        final GameDao gameDao = mock(GameDao.class);
        gameDao.addRate(new Game("签到", 7));

        verify(gameDao).addRate(Mockito.argThat(new PartyMatcher<>(game -> game.getRate(), 7)));

        verify(gameDao).addRate(Mockito.argThat(new PartyMatcher<>(game -> game.getType(), "签到")));


    }
}
