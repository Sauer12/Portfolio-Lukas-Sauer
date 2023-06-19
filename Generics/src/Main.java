
interface Player {
    String name();
}
record BaseballPlayer(String name, String position) implements Player{}

record FootballPlayer(String name, String position) implements Player{}

public class Main {
    public static void main(String[] args) {
        BaseballTeam slovakia1 = new BaseballTeam("Slovakia");
        BaseballTeam germany1 = new BaseballTeam("Germany");
        scoreResult(slovakia1, 5, germany1, 3);

        Team<BaseballPlayer, Affiliation> slovakia2 = new Team<>("Slovakia");
        Team<BaseballPlayer, Affiliation> germany2 = new Team<>("Germany");
        scoreResult(slovakia2, 5, germany2, 3);

 /*       SportsTeam slovakia = new SportsTeam("Slovakia");
        SportsTeam germany = new SportsTeam("Germany");
        scoreResult(slovakia, 5, germany, 3);

        var kamzik = new BaseballPlayer("M Kamzik", "Right Fielder");
        var petron = new BaseballPlayer("S Petron", "Right Fielder");
        slovakia.addTeamMember(kamzik);
        slovakia.addTeamMember(petron);
        slovakia.listTeamMembers();*/

        SportsTeam austria = new SportsTeam("Austria FC");
        var sauer = new FootballPlayer("L Sauer", "Centre half forward");
        austria.addTeamMember(sauer);
        var marshal = new FootballPlayer("P Marshal", "Midfield");
        austria.addTeamMember(marshal);
        austria.listTeamMembers();

    }

    public static void scoreResult(BaseballTeam team1, int t1_score, BaseballTeam team2, int t2_score){
        String message = team1.setScore(t1_score, t2_score);
        team2.setScore(t2_score, t1_score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }
    public static void scoreResult(SportsTeam team1, int t1_score, SportsTeam team2, int t2_score){
        String message = team1.setScore(t1_score, t2_score);
        team2.setScore(t2_score, t1_score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }

    public static void scoreResult(Team team1, int t1_score, Team team2, int t2_score){
        String message = team1.setScore(t1_score, t2_score);
        team2.setScore(t2_score, t1_score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }
}
