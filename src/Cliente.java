import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	
	private String nome;
	private String cli_repost;
	
	public String getCli_repost() {
		return cli_repost;
	}

	public void setCli_repost(String cli_repost) {
		this.cli_repost = cli_repost;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public void Cliente_CX(String localhost,int port ) {
		Chat ch = new Chat();
	    ch.contruir();
	    /*
		Socket cliente; 
        try { 
        	
        cliente= new Socket(localhost,port);
     	System.out.println("O cliente conectado");
     	
     	  
     	
     	//Scanner tec = new Scanner(System.in);
     	
     
     	String teclado =ch.getretorna();
     	System.out.println("?"+teclado);
     	PrintStream saida=new PrintStream(cliente.getOutputStream());
     	saida.println(teclado);
     	
     
     	fecharConexao(cliente,teclado,saida);
     
        }catch(IOException ex ) {
        	System.out.println("Servidor recebeu"+ex.toString());
        }
        */
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stu
		
		Cliente cli = new Cliente();
		cli.Cliente_CX("127.0.0.1",3334);
	   
	 

}
	
	public void fecharConexao(Socket cliente ,String teclado,PrintStream saida) {
		
     	saida.flush();
     	//saida.close();
     	
     	
     	try {
     	 cliente.close();
     	}catch(IOException e) {
     		System.out.println("Erro ao  Fechar Conexao");
     	}
     	
     	
	}
	
	
	public void mandar_msg(String teclado) {
	 Socket cliente;
		
	 try {
		cliente= new Socket("127.0.0.1",3334);
	    System.out.println("O cliente conectado");
	     	
	    String tec = teclado;
		System.out.println("Cliente:"+teclado);
     	PrintStream saida=new PrintStream(cliente.getOutputStream());
     	saida.println(tec);
	
	 }catch(IOException e){
		 
		 
	 }
     	
	}
	

	
}
