package moduie7_telegram_API.echoBot.config;

public record Config(String botApiToken) {
    public Config {
        if (botApiToken == null || botApiToken.isEmpty()){
            throw new IllegalArgumentException("Токен не задан!");
        }
    }
}
