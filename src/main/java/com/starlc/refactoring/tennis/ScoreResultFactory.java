package com.starlc.refactoring.tennis;

public class ScoreResultFactory {
	
	public static Result getInstance(int score1,int score2){
		Result objScore = null;
		if (score1 == score2) {
			objScore = new EqualScoreResult(score1,score2);
		} else if (score1 >= 4 || score2 >= 4) {
			objScore = new BigThan4AndNotEqualScoreResult(score1,score2);
		} else {
			objScore = new OtherScoreResult(score1,score2);
		}
		return objScore;
		
	}
}
