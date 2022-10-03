package controller;

import model.entity.Credenciais;
import view.InteracoesTela;

public class AppGestaoCondominio {
	public static void main(String[] args) throws Exception  {
		String mensagem=null;
		InteracoesTela 	entrada =  new InteracoesTela();
		Credenciais  credenciais = entrada.loginSistema();
		if (credenciais != null)  {
			entrada.loginSucesso(credenciais.getNomeLogin(),credenciais.getEmailLogin());
		}else {
			mensagem = "Suas Credenciais de entrada não são válidas !!!\n Faça seu Cadastro no Sistema";
			entrada.enviaMensagemTela(mensagem);
		};
		
	}
}