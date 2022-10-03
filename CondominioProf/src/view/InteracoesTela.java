package view;

import javax.swing.JOptionPane;

import model.DAO.ContaDAO;
import model.entity.Credenciais;
import util.TrataException;

public class InteracoesTela {
	public InteracoesTela() throws Exception {
		JOptionPane.showMessageDialog(null, "Bem vindo ao sistema de Gestão de Condominio!");
	}

	public void enviaMensagemTela(String mensagem) {

		JOptionPane.showMessageDialog(null, mensagem);
	}

	public Credenciais loginSistema() {

		Credenciais credenciais = null;
		boolean valor_correto_OK = true;
		String email = obtemEmailTela();
		String senha = obtemSenhaTela();
		ContaDAO conta = new ContaDAO();
		try {
			credenciais = conta.getCredenciais(email, senha);
		} catch (TrataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return credenciais;
	}

	public String obtemEmailTela() {
		String email = null;
		boolean valor_correto_OK = true;
		do {
			email = (JOptionPane.showInputDialog(null, "Insira o seu email: "));
			if (!email.equals(null)) {
				if (email.equals("")) {
					JOptionPane.showMessageDialog(null, "Voce naox inseriu seu email");
				} else {
					valor_correto_OK = false;
				}
			}
		} while (valor_correto_OK);
		return email;

	}

	public String obtemSenhaTela() {
		String senha = null;
		boolean valor_correto_OK = true;
		do {
			senha = (JOptionPane.showInputDialog(null, "Informe a senha: "));
			if (!senha.equals(null)) {
				if (senha.equals("")) {
					JOptionPane.showMessageDialog(null, "Voce nao informou sua senha");
				} else {
					valor_correto_OK = false;
				}
			}
		} while (valor_correto_OK);
		return senha;
	}
	public void loginSucesso(String nome, String email) {
		JOptionPane.showMessageDialog(null, "Sr. "+nome+"\n Você foi autenticado com sucesso("+email+")");
	}
}
