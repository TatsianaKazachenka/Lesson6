public final class Constants {
    public static class AddRemove {
        public static final String URL_ELEMENTS = "http://the-internet.herokuapp.com/add_remove_elements/";
        public static final String ADD_ELEMENTS = "//button[@onclick=\"addElement()\"]";
        public static final String REMOVEBLE_ELEMENTS = "added-manually";
    }
    public static class Checkboxes{
        public static final String URL_ELEMENTS = "http://the-internet.herokuapp.com/checkboxes";
        public static final String TYPENAME_ELEMENTS = "//*[@type='checkbox']";
    }
    public static class Tables{
        public static final String URL_ELEMENTS = "http://the-internet.herokuapp.com/tables";
        public static final String ID_ELEMENTS = "//*[@id=\"table1\"]";
    }
    public static class Typos{
        public static final String URL_ELEMENTS = "http://the-internet.herokuapp.com/typos";
        public static final String ID_ELEMENTS = "//*[@id=\"content\"]";
        public static final String ELEMENT_RIGTH_TEXT = "Sometimes you'll see a typo, other times you won't.";
        public static final String XPATH_FOR_P = "//p[2]";
    }
    public static class Hovers{
        public static final String URL_ELEMENTS = "http://the-internet.herokuapp.com/hovers";
        public static final String ID_ELEMENTS = "//*[@id=\"content\"]";
        public static final String CLASSNAME_ELEMENTS = "figure";
        public static final String NOT_FOUND_TEXT = "Not Found";
    }
    public static class NotificationMessage{
        public static final String URL_ELEMENTS = "http://the-internet.herokuapp.com/notification_message_rendered";
        public static final String HREF_ELEMENT = "//*[@id=\"content\"]//a";
        public static final String MESSAGE_ELEMENT = "//*[@id=\"flash\"]";
    }
}
