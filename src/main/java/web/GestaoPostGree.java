package web;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import bancodedados.PostgreSQLJDBCDCL;
import bancodedados.faculdade.dto.CriarTabelas;
import bancodedados.faculdade.dto.LOGFaculdade;
import bancodedados.faculdade.dto.PesquisaFaculdade;

@ViewScoped
@ManagedBean(name = "gestaoPostGree")
public class GestaoPostGree {

	private PostgreSQLJDBCDCL dcl = new PostgreSQLJDBCDCL();
	private CriarTabelas facDCL = new CriarTabelas();
	private PesquisaFaculdade facDML = new PesquisaFaculdade();

	public List<LOGFaculdade> listaLOG = new ArrayList<>();

	public void criarTabelaspostGree() {
		this.dcl.criarTabelasViaWEB();
	}

	public void removerTabelaspostGree() {
		this.dcl.removerTabelasViaWEB();
	}

	public void criarTabelasFaculdadeViaWEB() {
		this.facDCL.criarTabelaLOGFAQ();
	}

	public void removerTabelasFaculdadeViaWEB() {
		this.facDCL.removerTabelaLOG();
	}

	public void selecionarLOGs() {
		this.listaLOG = this.facDML.selecionarLogs();
		System.out.println("ola");
	}

	public List<LOGFaculdade> getListaLOG() {
		return this.listaLOG;
	}

	public void setListaLOG(List<LOGFaculdade> listaLOG) {
		this.listaLOG = listaLOG;
	}

	private int number;

	public int getNumber() {
		return this.number;
	}

	public void increment() {
		this.number++;
	}

}
