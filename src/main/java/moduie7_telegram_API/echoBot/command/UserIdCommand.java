package moduie7_telegram_API.echoBot.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

public class UserIdCommand implements Command {

    private static final Logger log = LoggerFactory.getLogger(UserIdCommand.class);
    private final String answerPattern = "Ваш ID: %s";

    private final TelegramClient client;

    public UserIdCommand(TelegramClient client) {
        this.client = client;
    }

    @Override
    public void execute(Update update) {
        long senderId = update.getMessage().getChatId();
        SendMessage sendMessage = SendMessage.builder()
                .chatId(senderId)
                .text(answerPattern.formatted(senderId))
                .build();

        try {
            client.execute(sendMessage);
        } catch (TelegramApiException e) {
            log.error("Не удалось отправить сообщение в ответ на команду /myid");
            e.printStackTrace();
        }
    }
}
