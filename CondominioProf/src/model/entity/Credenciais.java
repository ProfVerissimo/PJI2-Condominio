package model.entity;

public class Credenciais {
String emailLogin;
String nomeLogin;
String senhaLogin;
public String getSenhaLogin() {
	return senhaLogin;
}
public void setSenhaLogin(String senhaLogin) {
	this.senhaLogin = senhaLogin;
}
public Credenciais(String email, String nome, String senha ) {
	setEmailLogin(email);
	setNomeLogin(nome);
	setSenhaLogin(senha);
}
public String getEmailLogin() {
	return emailLogin;
}
public void setEmailLogin(String emailLogin) {
	this.emailLogin = emailLogin;
}
public String getNomeLogin() {
	return nomeLogin;
}
public void setNomeLogin(String nomeLogin) {
	this.nomeLogin = nomeLogin;
}

}
