package moduie7_telegram_API.echoBot.config;

public class ConfigReaderEnvironment implements ConfigReader {
    @Override
    public Config read() {
        String token = System.getenv("ECHO_BOT_TOKEN");
        return new Config(token);
    }
}
