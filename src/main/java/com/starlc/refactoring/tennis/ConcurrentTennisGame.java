package com.starlc.refactoring.tennis;

public class ConcurrentTennisGame implements TennisGame {

	TennisPlay play1;
	TennisPlay play2;

	public ConcurrentTennisGame(String player1Name, String player2Name) {
		play1 = new TennisPlay(player1Name);
		play2 = new TennisPlay(player2Name);
	}

	@Override
	public void wonPoint(String playerName) {
		if (playerName == "player1") {
			play1.winPoint();
		} else {
			play2.winPoint();
		}
	}

	@Override
	public String getScore() {
		return ScoreResultFactory.getInstance(play1.getScore(), play2.getScore())
				.getResult();
	}

}
