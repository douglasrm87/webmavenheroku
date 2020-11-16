package br.com.bottelegram.tk4telecombot;

import com.pengrad.telegrambot.TelegramBot;

import bancodedados.dto.CentralMensagensBrewField;

//https://web.telegram.org/#/im?p=@cscpr_bot
public class FluxoTelegramTK4Telcom  {
//	public static final Logger logger = Logger.getLogger(FluxoTelegramTK4Telcom.class);

	TelegramBot botTelegram = new TelegramBot(CentralMensagensBrewField.TOKEN_TELEGRAM_TK4TELECOMBOT);
	int offSetAtributo = 0;

	public void iniciarChatBotTelegram() {
//		if (PS1.liberarEnvio) {
//			String idManutencaCel = "-267387347";
//			TelegramBot botTK4Telecom = new TelegramBot(CentralMensagensBrewField.TOKEN_TELEGRAM_TK4TELECOMBOT);
//			botTK4Telecom.execute(new SendMessage(idManutencaCel, getMsgTelegram()));
//			PS1.liberarEnvio = false;
//			System.out.println("Bloqueado mensagem.");
//		}
	}
}