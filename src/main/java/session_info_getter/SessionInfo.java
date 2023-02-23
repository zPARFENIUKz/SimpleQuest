package session_info_getter;

import java.net.URL;
import java.net.URLConnection;

public class SessionInfo {
    private String IpAddress;
    private String name;
    private int countOfGames;
    private int numOfQuest;

    public SessionInfo(String ipAddress, String name, int countOfGames, int numOfQuest) {
        IpAddress = ipAddress;
        this.name = name;
        this.countOfGames = countOfGames;
        this.numOfQuest = numOfQuest;
    }

    public String getIpAddress() {
        return IpAddress;
    }

    public String getName() {
        return name;
    }

    public int getCountOfGames() {
        return countOfGames;
    }

    public int getNumOfQuest() {
        return numOfQuest;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("<br/><br/><br/>")
                .append("Статистика:")
                .append("<br/>")
                .append("IP address: ")
                .append(IpAddress)
                .append("<br/>")
                .append("Имя в игре: ")
                .append(name)
                .append("<br/>")
                .append("Количество игр: ")
                .append(countOfGames);
        return sb.toString();
    }
}
