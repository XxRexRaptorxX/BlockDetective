package xxrexraptorxx.block_detective.utils;

public enum InformationTypes {

    HIDDEN("hidden"),
    TINY("tiny"),
    NORMAL("normal"),
    EXTENDED("extended");

    private final String name;


    InformationTypes(String name) {
        this.name = name;
    }


    public String toString() {
        return this.name;
    }
}
