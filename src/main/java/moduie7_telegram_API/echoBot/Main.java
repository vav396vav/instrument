package moduie7_telegram_API.echoBot;

import moduie7_telegram_API.echoBot.config.Config;
import moduie7_telegram_API.echoBot.config.ConfigReader;
import moduie7_telegram_API.echoBot.config.ConfigReaderEnvironment;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

public class Main {
    public static void main(String[] args) {
        ConfigReader configReader = new ConfigReaderEnvironment();
        Config config = configReader.read();

        TelegramClient telegramClient = new OkHttpTelegramClient(config.botApiToken());

        try {
            TelegramBotsLongPollingApplication botsApplication = new TelegramBotsLongPollingApplication();
            botsApplication.registerBot(config.botApiToken(), new EchoBot(telegramClient));
            Thread.currentThread().join();
        } catch (TelegramApiException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
