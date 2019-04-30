package com.starlc.refactoring.tennis;

public class EqualScoreResult extends AbstractResult {

	public EqualScoreResult(int score1, int score2) {
		super(score1, score2);
	}

	@Override
	public String getResult() {
		String score = "";
		switch (score1) {
		case 0:
			score = "Love-All";
			break;
		case 1:
			score = "Fifteen-All";
			break;
		case 2:
			score = "Thirty-All";
			break;
		default:
			score = "Deuce";
			break;
		}
		return score;
	}


}
