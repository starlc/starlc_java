package com.starlc.refactoring.tennis;

public class BigThan4AndNotEqualScoreResult extends AbstractResult {

	public BigThan4AndNotEqualScoreResult(int score1, int score2) {
		super(score1, score2);
	}

	@Override
	public String getResult() {
		String score = "";
		if (score1 >= 4 || score2 >= 4) {
			int minusResult = score1 - score2;
			if (minusResult == 1)
				score = "Advantage player1";
			else if (minusResult == -1)
				score = "Advantage player2";
			else if (minusResult >= 2)
				score = "Win for player1";
			else
				score = "Win for player2";
		}
		return score;
	}

}
