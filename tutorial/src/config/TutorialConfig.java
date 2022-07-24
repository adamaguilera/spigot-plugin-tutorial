package config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import config.data.TutorialData;
import tutorial.util.TutorialLogger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TutorialConfig {
    final TutorialLogger logger = new TutorialLogger("TUTORIAL_CONFIG", true);

    final String ATTEMPT_LOADING_TUTORIAL_DATA = "Attempting to load tutorial config from %s";
    final String FINISH_LOADING_FAILED_LOAD_TUTORIAL_DATA = "Finished loading tutorial config from json";
    final String FAILED_LOAD_TUTORIAL_DATA = "Unable to load tutorial config, using default";
    final Path TUTORIAL_CONFIG_PATH = Paths.get("./plugins/Tutorial/config.json");
    final String ATTEMPT_SAVING_TUTORIAL_DATA = "TutorialConfig doesn't exist, attempting to save default tutorial config to %s";
    final String FINISH_SAVING_TUTORIAL_DATA = "Finished tutorial config to %s";
    final String FAILED_SAVING_TUTORIAL_DATA = "Failed to tutorial config with error {%s}";
    final Gson GSON_BUILDER = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public TutorialData load () {
        this.logger.debug(String.format(ATTEMPT_LOADING_TUTORIAL_DATA, TUTORIAL_CONFIG_PATH));
        try {
            String json = new String(Files.readAllBytes(TUTORIAL_CONFIG_PATH));
            TutorialData tutorialData = GSON_BUILDER.fromJson(json, TutorialData.class);
            this.logger.debug(FINISH_LOADING_FAILED_LOAD_TUTORIAL_DATA);
            return tutorialData;
        } catch (IOException e) {
            this.logger.debug(FAILED_LOAD_TUTORIAL_DATA);
            return new TutorialData();
        }
    }

    public void save (final TutorialData tutorialData) {
        // only save if tutorial config doesn't exist
        File tutorialJson =  new File(TUTORIAL_CONFIG_PATH.toString());
        if (!tutorialJson.exists()) {
            this.logger.debug(String.format(ATTEMPT_SAVING_TUTORIAL_DATA, TUTORIAL_CONFIG_PATH));
            try {
                boolean fileCreated = tutorialJson.createNewFile();
                String json = GSON_BUILDER.toJson(tutorialData);
                Files.write(TUTORIAL_CONFIG_PATH, json.getBytes());
                this.logger.debug(String.format(FINISH_SAVING_TUTORIAL_DATA, TUTORIAL_CONFIG_PATH));
            } catch (IOException e) {
                this.logger.debug(String.format(FAILED_SAVING_TUTORIAL_DATA, e.getLocalizedMessage()));
            }
        }

    }
}
