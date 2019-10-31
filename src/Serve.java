import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Serve extends JFrame {


	public static String nomeChat = "Allan";
	public boolean abri = false;
	private JTextField txtIP;
	private JTextField txtPorta;
	private JTextField txtNome;
	private Container cn;
	
    private String localhost = "127.0.0.1";
	private static int port = 3335; 
	private Controle nome;
	private Controle ip;
	private Controle prt;
	
	
	
	
	public Controle getNome() {
		return nome;
	}




	public void setNome(Controle nome) {
		this.nome = nome;
	}




	public static String getNomeChat() {
		return nomeChat;
	}




	public static void setNomeChat(String nomeChat) {
		Serve.nomeChat = nomeChat;
	}




	public Controle getIp() {
		return ip;
	}




	public void setIp(Controle ip) {
		this.ip = ip;
	}




	public Controle getPrt() {
		return prt;
	}




	public void setPrt(Controle prt) {
		this.prt = prt;
	}

	
	
	
	Serve(int port,String ip){
	
		try {
		    cn =  getContentPane();
            setDefaultCloseOperation( EXIT_ON_CLOSE); 
      
             
		    JLabel lblMessage = new JLabel("Verificar!");
	        txtIP = new JTextField(localhost);
	        txtPorta = new JTextField("3334");
	        txtNome = new JTextField("Cliente");                
	        Object[] texts = {lblMessage, txtIP, txtPorta, txtNome };  
	        JOptionPane.showMessageDialog(null, texts); 
	        JOptionPane.showMessageDialog(null, "Conexao Estabelecida com Sucesso");
	      
	      
		}catch(Exception e) {
			System.err.println("Erro"+e);
		}
		
		
		
		try {

		    Controle ctl = new Controle();
	        ctl.setNome(txtNome.getText());
	        ctl.setPort(txtPorta.getText());
	        ctl.setIp(txtIP.getText());
	        
	        this.setPrt(ctl);
	        this.setIp(ctl);
	        this.setNome(ctl);
	        
	        System.out.println("Info do Servidor:\n"+this.getPrt().getPort() +"\n" + this.getIp().getIp()+"\n"+ this.getNome().getNome().toString()+"\n");
	       

	        localhost = this.getIp().getIp().toString();
	        port = Integer.parseInt(this.getPrt().getPort()); 
			
		}catch(Exception e) {
		       JOptionPane.showMessageDialog(null, "Fatal Erro ...."+e);
			
			
		}
		

		ServerSocket servidor = null;
	  try {
			
		servidor = new ServerSocket(port);
		System.out.println("Servidor Ativo");
		System.out.println("Porta:"+servidor.getLocalPort()+" aberta");
		System.out.println("Endereço: " + InetAddress.getByName("localhost").getHostAddress() );
		
	
		Socket TratarCliente;
		TratarCliente = servidor.accept();
		Scanner s = new Scanner(TratarCliente.getInputStream());
		System.out.println(s.nextLine());
    
		
		while(s.hasNextLine()) {
		 Chat ch = new Chat();
		 ch.setTextoChat(s.nextLine());
		 ch.getTextoChat();
			
		} 
		
		fecharConexao(servidor,s,TratarCliente);
		
		
		}catch(Exception e) {
			System.out.println("Servidor não recebeu:"+e.toString());
		}
		
		  
        

	    
	}
	
	

	public void fecharConexao(ServerSocket servidor,Scanner s, Socket TratarCliente) {
	
     	s.close();
     	
     	try {
    	TratarCliente.close();
    	s.close();
     	}catch(IOException e) {
     		
     	}
    	
     if(abri== true) {
     	try {
     	 servidor.close();
     	
     	}catch(IOException e) {
     		System.out.println("Erro ao  Fechar Conexao");
     	}
     	
     	   }
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Serve sv = new  Serve(port,"121.0.0.1");
		
	}






}
