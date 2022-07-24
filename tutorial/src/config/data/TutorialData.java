package config.data;

public class TutorialData {
    // defaults to these value if not present in config
    int tutorialSeed = 12345678;
    String tutorialConfigValue = "default value";
    // transient hides this value from being saved to JSON
    final transient String FORMAT_TO_STRING = "TutorialData{tutorialSeed=%d, tutorialConfigValue=%s}";

    @Override
    public String toString() {
        return String.format(FORMAT_TO_STRING, tutorialSeed, tutorialConfigValue);
    }
}
