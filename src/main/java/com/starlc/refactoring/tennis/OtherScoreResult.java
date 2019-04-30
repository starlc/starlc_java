package com.starlc.refactoring.tennis;

public class OtherScoreResult extends AbstractResult {

	public OtherScoreResult(int score1, int score2) {
		super(score1, score2);
	}

	@Override
	public String getResult() {
		String score = "";
		int tempScore = 0;
		for (int i = 1; i < 3; i++) {
			if (i == 1) {
				tempScore = score1;
			} else {
				score += "-";
				tempScore = score2;
			}
			switch (tempScore) {
				case 0:
					score += "Love";
					break;
				case 1:
					score += "Fifteen";
					break;
				case 2:
					score += "Thirty";
					break;
				case 3:
					score += "Forty";
					break;
				default:
			}
		}
		return score;
	}

}
