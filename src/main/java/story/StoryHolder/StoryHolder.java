package story.StoryHolder;

import java.util.HashMap;
import java.util.Map;

public class StoryHolder {
    private static Map<Integer, Story> stories = new HashMap<>();
    static {
        final StringBuilder sb = new StringBuilder();
        sb.append("<form action=\"story\" method=\"post\">\n" +
                "    <input type=\"radio\" name=\"choice\" value=\"2\">Отклонить вызов<br/>\n" +
                "    <input type=\"radio\" name=\"choice\" value=\"3\">Принять вызов<br/>\n" +
                "    <input type=\"submit\" value=\"Ответить\">\n" +
                "</form>");
        stories.put(1, new Story("Ты потерял память", "Принять вызов НЛО?", sb.toString()));
        sb.delete(0, sb.length());

        sb.append("<form action=\"story\" method=\"post\">\n" +
                "    <button name=\"choice\" value=\"-1\">Вернуться на главную страницу</button>\n" +
                "</form>");
        stories.put(2, new Story("Ты проиграл", "Ты отклонил вызов", sb.toString()));
        sb.delete(0, sb.length());

        sb.append("<form action=\"story\" method=\"post\">\n" +
                "    <input type=\"radio\" name=\"choice\" value=\"4\">Отказаться подниматься на мостик<br/>\n" +
                "    <input type=\"radio\" name=\"choice\" value=\"5\">Подняться на мостик<br/>\n" +
                "    <input type=\"submit\" value=\"Ответить\">\n" +
                "</form>");
        stories.put(3, new Story("Ты принял вызов", "Поднимешься на мостик к капитану?", sb.toString()));
        sb.delete(0, sb.length());

        sb.append("<form action=\"story\" method=\"post\">\n" +
                "    <button name=\"choice\" value=\"-1\">Вернуться на главную страницу</button>\n" +
                "</form>");
        stories.put(4, new Story("Поражение", "Ты не пошел на переговоры", sb.toString()));
        sb.delete(0, sb.length());

        sb.append("<form action=\"story\" method=\"post\">\n" +
                "    <input type=\"radio\" name=\"choice\" value=\"6\">Рассказать правду о себе<br/>\n" +
                "    <input type=\"radio\" name=\"choice\" value=\"7\">Солгать о себе<br/>\n" +
                "    <input type=\"submit\" value=\"Ответить\">\n" +
                "</form>");
        stories.put(5, new Story("Ты поднялся на мостик", "Ты кто?", sb.toString()));
        sb.delete(0, sb.length());

        sb.append("<form action=\"story\" method=\"post\">\n" +
                "    <button name=\"choice\" value=\"-1\">Вернуться на главную страницу</button>\n" +
                "</form>");
        stories.put(6, new Story("Победа", "Тебя вернули домой", sb.toString()));

        stories.put(7, new Story("Поражение", "Твою ложь разоблачили", sb.toString()));


    }

    public static Story getStory(int numOfQuest) {
        return stories.get(numOfQuest);
    }
}
