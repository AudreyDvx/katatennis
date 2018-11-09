package fr.unilim.iut.katatennis;


public class TennisGame1 implements TennisGame {
    
    private int mScore1 = 0;
    private int mScore2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            mScore1 += 1;
        else
            mScore2 += 1;
    }

    public String getScore() {
        String score = "";
        StringBuilder bld = new StringBuilder();
        if (mScore1==mScore2)
            score = egalite();
        else if (mScore1>=4 || mScore2>=4)
            score = avantages();
        else
            score = gererScore(score, bld);
        
        return score;
    }

	private String gererScore(String score, StringBuilder bld) {
        int tempScore=0;
		for (int i=1; i<3; i++)
		{
		    if (i==1) tempScore = mScore1;
		    else { 
		    	bld.append("-");
		    	tempScore = mScore2;
		    }
		    switch(tempScore)
		    {
		        case 0:
		        	bld.append("Love");
		            break;
		        case 1:
		        	bld.append("Fifteen");
		            break;
		        case 2:
		        	bld.append("Thirty");
		            break;
		        case 3:
		        	bld.append("Forty");
		            break;
		        default:
		        	break;
		    }
		    score = bld.toString();
		}
		return score;
	}

	private String avantages() {
		String score;
		int minusResult = mScore1-mScore2;
		if (minusResult==1) score ="Advantage player1";
		else if (minusResult ==-1) score ="Advantage player2";
		else if (minusResult>=2) score = "Win for player1";
		else score ="Win for player2";
		return score;
	}

	private String egalite() {
		String score;
		switch (mScore1)
		{
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