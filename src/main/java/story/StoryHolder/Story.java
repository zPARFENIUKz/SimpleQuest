package story.StoryHolder;

public class Story {
    protected String title;
    protected String text;
    protected String form;

    public Story(String title, String text, String form) {
        this.title = title;
        this.text = text;
        this.form = form;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getForm() {
        return form;
    }
}
