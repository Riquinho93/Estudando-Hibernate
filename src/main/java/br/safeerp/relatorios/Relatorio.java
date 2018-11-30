package br.safeerp.relatorios;

import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

import br.safeerp.entitidades.ProdutoModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class Relatorio implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public void gerarRelatorio(List<ProdutoModel> produto) throws JRException{
		
		InputStream arq = Relatorio.class.getResourceAsStream("/Relatorio/ProdutosRelatorio.jrxml");
		
		JasperReport report = JasperCompileManager.compileReport(arq);
		
		JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(produto));
		
		JasperViewer.viewReport(print, false);
		
	}
}
