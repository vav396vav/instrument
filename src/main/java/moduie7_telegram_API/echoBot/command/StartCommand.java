package moduie7_telegram_API.echoBot.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

public class StartCommand implements Command {
    private static final Logger log = LoggerFactory.getLogger(StartCommand.class);
    private final String startText = """
            Этот бот позволяет узнать свой ID в мессенджере Telegram.
            Для этого используй команду /myid""";
    private final TelegramClient client;

    public StartCommand(TelegramClient client) {
        this.client = client;
    }

    @Override
    public void execute(Update update) {
        SendMessage sendMessage = SendMessage.builder()
                .chatId(update.getMessage().getChatId())
                .text(startText)
                .build();

        try {
            client.execute(sendMessage);
        } catch (TelegramApiException e) {
            log.info("Ошибка отправки сообщения");
            e.printStackTrace();
        }
    }
}
