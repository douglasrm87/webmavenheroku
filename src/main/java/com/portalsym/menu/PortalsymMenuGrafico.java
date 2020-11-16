package com.portalsym.menu;

import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.model.request.Keyboard;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;

import bancodedados.dto.CentralMensagensBrewField;
import br.com.bottelegram.FluxoTelegram;

public class PortalsymMenuGrafico extends FluxoTelegram {

	 
	private static final String PEDIDO = "Digite seu pedido";
	private static final String  ORCAMENTO = "Solicite um orçamento";
	private static final String  AGENDAMENTO = "Agendamento de entrega";
	private static final String  PRODUTOS = "Produtos";
	private static final String  CONSULTOR = "Fale com um consultor";
	private static final String  LOCALIZACAO = "Localização";
	private static final String  SAIR = "Sair";
	private static final String  SITE_SYM = "https://www.portalsym.com/";

	public void menuOpcoesGrafico(long idUsuario) {
		
		InlineKeyboardButton pedido = new InlineKeyboardButton(PEDIDO)
				.callbackData(String.valueOf(PEDIDO));
		InlineKeyboardButton orcamento = new InlineKeyboardButton(ORCAMENTO)
				.callbackData(String.valueOf(ORCAMENTO));
		InlineKeyboardButton agendamento = new InlineKeyboardButton(AGENDAMENTO)
				.callbackData(String.valueOf(AGENDAMENTO));
		InlineKeyboardButton produtos = new InlineKeyboardButton(PRODUTOS)
				.callbackData(String.valueOf(PRODUTOS));
		InlineKeyboardButton consultor = new InlineKeyboardButton(CONSULTOR)
				.callbackData(String.valueOf(CONSULTOR));
		InlineKeyboardButton sair = new InlineKeyboardButton(SAIR)
				.callbackData(String.valueOf(SAIR));
		InlineKeyboardButton localizacao = new InlineKeyboardButton(LOCALIZACAO)
						.url(SITE_SYM);

		InlineKeyboardButton[][] vetorBotoes = { { pedido, orcamento }, { agendamento, produtos },
				{ consultor , sair }, { localizacao } };
		Keyboard teclado = new InlineKeyboardMarkup(vetorBotoes);

		SendMessage msgTelegram = new SendMessage(idUsuario, "Escolha a opção desejada:")
				.parseMode(ParseMode.HTML).disableWebPagePreview(false).replyMarkup(teclado);
		SendResponse sendResponse = this.botTelegram.execute(msgTelegram);
	}
 

}
