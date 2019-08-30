package football;

public class FootballTeam implements Comparable<FootballTeam> {
    private int gamesWon;

    public FootballTeam(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    @Override
    public int compareTo(FootballTeam otherTeam) {
       /* if(gamesWon > otherTeam.getGamesWon()) return  1;
        if(gamesWon < otherTeam.getGamesWon()) return -1;*/
        return gamesWon - otherTeam.getGamesWon();
    }
}

