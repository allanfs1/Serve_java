import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;


import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Chat extends JFrame  implements Runnable , ActionListener,KeyListener {

	
	private Container cn;
	private Thread t2;
	
	
	private JTextArea texto;
	private JTextField txtMsg;
	private JButton btnSend;
	private JButton btnSair;
	private JLabel lblHistorico;
	private JLabel lblMsg;
	private JPanel pnlContent;
    private String textoChat;
	private ArrayList<String> lista = new ArrayList();;
	private String txtMsg_texto;
	
	
	public String getTxtMsg() {
		return txtMsg_texto;
	}




	

	
	public String getTextoChat() {
		return txtMsg.getText();
	}




	public void setTextoChat(String textoChat) {
		texto.setText(this.textoChat = textoChat);
        
	}




	public Chat(){
		 //System.out.println("\nClasse init \n");
	     t2 = new Thread() {
	         @Override
	         public void run() {
	            // System.out.println(": t2");
	         }

	     };

		  t2.start();
		
	}
	

public void contruir() {
	
	
	try {
	
	
        setDefaultCloseOperation(JFrame. EXIT_ON_CLOSE); 
        this.setSize(240,300);
        this.setTitle("Allan");
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    	cn =  getContentPane();
    	
      
        
        pnlContent = new JPanel();
        texto = new JTextArea(10,20);
        btnSend = new JButton("Enviar");
        btnSair = new JButton("Sair");
        lblHistorico = new JLabel("IP:127.0.0.1");
        lblMsg = new JLabel("Port:3334");
        txtMsg = new JTextField(20);
       
        texto.setEditable(false);
        texto.setBackground(new Color(240,240,240));   
        JScrollPane scroll = new JScrollPane(texto);
        texto.setLineWrap(true);  
      
       
        
        cn.add(pnlContent);
        pnlContent.add(lblHistorico);
        pnlContent.add(scroll);
        pnlContent.add(lblMsg);
        pnlContent.add(texto);
        pnlContent.add(txtMsg);
        pnlContent.add(btnSair);
        pnlContent.add(btnSend);
        btnSend.addActionListener(this);
        btnSair.addActionListener(this);
        

      
        setContentPane(pnlContent);
        pnlContent.setBackground(Color.LIGHT_GRAY);                                 
        texto.setBorder(BorderFactory.createEtchedBorder(Color.ORANGE,Color.LIGHT_GRAY));
        txtMsg.setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.BLUE));                    
        lblHistorico.setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.BLUE));
        lblMsg.setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.BLUE));  
        
      
       
        
     
	}catch(Exception e) {		
		System.err.println("Erro"+e);
	}
	
	
	
}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//System.out.println(": t1");
		
	}//fim


	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
		if(e.getActionCommand() == btnSair.getActionCommand()) {
		  System.out.println("Press Sair");
		  System.exit(0);
		
		}
		 
		
		if(e.getActionCommand() == btnSend.getActionCommand()) {
			/*Em contrução*/
			  Cliente cli = new Cliente();
              cli.mandar_msg(txtMsg.getText());
              
              
	          lista.add(Serve.nomeChat+"Serve@ "+txtMsg.getText());
	          for(int i=0;i<lista.size();i++) {
				   texto.setText(lista.get(i)+"\n");
			     
			     }
	       	
			 
		}
		
		
		       
	}
	
	
	public void  retorna (String txt) {
		this.txtMsg_texto = txt;
	}

	public String  getretorna () {
		return txtMsg_texto;
	}


	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Chat c = new Chat();
		c.contruir();
		Thread t1 = new Thread(c);
		t1.start();
	}



	

}
