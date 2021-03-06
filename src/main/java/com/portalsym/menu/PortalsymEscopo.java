package com.portalsym.menu;//https://medium.com/@dds861/sending-message-to-telegram-group-channel-using-bot-from-android-or-java-apps-3c68ffe04a46

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import com.portalsym.PortalsymFluxoTelegram;

//import org.apache.log4j.Logger;
import br.com.bottelegram.comando.dto.GestaoAtendimento;
import br.com.bottelegram.comando.dto.InteracaoComando;
import br.com.bottelegram.comando.dto.VPNConectadaExcel;
//Exemplos
//https://www.codota.com/code/java/methods/com.pengrad.telegrambot.response.SendResponse/message
//https://github.com/pengrad/java-telegram-bot-api/blob/master/README.md

// digitar 2 de uma vez Exception in thread "Timer-0" java.util.ConcurrentModificationException
//92619070#877554#80050350#777 ap 2777
//

//heroku ps:scale web=0 --app webmavenheroku

public class PortalsymEscopo implements Serializable {
	private static final String INICIANDO_CSC_BOT_TELEGRAM = "Iniciando CSC BOT Telegram.";
	private static final String ASTERICS = "***********************************";
	private static final long serialVersionUID = 1L;
	private int delay = 4000; // delay de 4 seg.
	private int interval = 4000; // intervalo de 4 seg.
	private PortalsymFluxoTelegram fluxo = new PortalsymFluxoTelegram();

	@PostConstruct
	public void iniciarOuvinteTelegram() {
		System.out.println(ASTERICS);
		System.out.println(INICIANDO_CSC_BOT_TELEGRAM);
		System.out.println(ASTERICS);

		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				PortalsymEscopo.this.fluxo.iniciarChatBotTelegram();
			}
		}, this.delay, this.interval);
	}

	public static void main(String[] args) {
		new PortalsymEscopo().processar();
	}

	private void processar() {
		iniciarOuvinteTelegram();
	}

	public PortalsymEscopo() {
		super();
	}
 
 
}
