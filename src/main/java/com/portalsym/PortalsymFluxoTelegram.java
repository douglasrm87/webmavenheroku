package com.portalsym;

import java.util.List;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SendPhoto;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.GetUpdatesResponse;
import com.pengrad.telegrambot.response.SendResponse;
import com.portalsym.menu.PortalsymMenuGrafico;

import bancodedados.dto.CentralMensagensBrewField;
import br.com.bottelegram.EscopoApplictCSCTimerTelegram;

//https://web.telegram.org/#/im?p=@cscpr_bot
public class PortalsymFluxoTelegram {

//	public static final Logger logger = Logger.getLogger(FluxoTelegram.class);

	protected TelegramBot botTelegram = new TelegramBot(CentralMensagensBrewField.TOKEN_TELEGRAM_FACULDADE);
	private int offSetAtributo = 0;

	public void iniciarChatBotTelegram() {
		GetUpdatesResponse updatesResponse;
		SendResponse sendResponse = null;
		BaseResponse baseResponse;

		// executa comando no Telegram para obter as mensagens pendentes a partir de um
		// off-set (limite inicial)
		updatesResponse = this.botTelegram.execute(new GetUpdates().limit(100).offset(this.offSetAtributo));

		// lista de mensagens
		List<Update> updates = updatesResponse.updates();

		// analise de cada ação da mensagem
		if (updates != null) {
			for (Update update : updates) {
				if (update.message().text() != null) {
					String nome = update.message().chat().firstName();
					String sobreNome = update.message().chat().lastName();
					if (sobreNome != null) {
						nome += " " + sobreNome;
					}
					String saudacao = "Boa tarde <b>" + nome
							+ "</b>, seja bem vindo ao atendimento virtual Vidra�aria SYM";

					this.botTelegram.execute(new SendPhoto(update.message().chat().id(), new java.io.File("sym.png")));

					this.botTelegram
							.execute(new SendMessage(update.message().chat().id(), saudacao).parseMode(ParseMode.HTML));
					PortalsymMenuGrafico menu = new PortalsymMenuGrafico();
					menu.menuOpcoesGrafico(update.message().chat().id());
					this.botTelegram
					.execute(new SendMessage(update.message().chat().id(), "<b>by DRM</b>").parseMode(ParseMode.HTML));
				}
			}
		}
	}

}
