// main class

import javax.swing.JFrame;

public class clientmain {
	public static void main(String[] args) {
		client c;
		c = new client("127.0.0.1");
		c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.startRunning();
		
	}
}




//client setup class

import java.io.*;
import java.awt.*;
import java.net.*;
import java.awt.event.*;
import javax.swing.*;


public class client extends JFrame{
	private JTextField text;
	private JTextArea window;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private Socket connection;
	private String message = "";
	private String serverIP;
	
	public client(String host) {
		super("Friend");
		serverIP = host;
		text = new JTextField("Type a Message");
		text.setEditable(false);
		text.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						sendMessage(e.getActionCommand());
						text.setText("");
					}
				}
				);
		add(text,BorderLayout.NORTH);
		
		window = new JTextArea();
		add(new JScrollPane(window));
		setSize(300,100);
		setVisible(true);
	}
	
	public void startRunning() {
		try {
			connectToServer();
			setupSteams();
			whileChatting();
		}catch(EOFException e) {
			showMessage("\n Client terminated connection");
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			closechat();
		}
	}

	private void connectToServer() throws IOException {
			showMessage("Connecting... \n");
			connection = new Socket(InetAddress.getByName(serverIP),1234);
			showMessage("Now connected to " + connection.getInetAddress().getHostName());
	}
	
	private void setupSteams() throws IOException {
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush();
		input = new ObjectInputStream(connection.getInputStream());
		showMessage("\n Streams are now setup \n");
	}
	
	private void whileChatting() throws IOException{
		abletotype(true);
		do {
			try {
				message = (String)	input.readObject();
				showMessage("\n "+ message);
			}catch(ClassNotFoundException e) {
				showMessage("\n Sent something weird");
			}
		}while(!message.equals("CLIENT - END"));
	}
	
	private void closechat() {
		showMessage("Closing server! ");
		abletotype(false);
		try {	
			output.close();
			input.close();
			connection.close();
		}catch(IOException e) {
			e.printStackTrace();
		}	
		
	}
	
	private void sendMessage(String Message) {
		try {
			output.writeObject("Friend :" + Message);
			output.flush();
			showMessage("\n Friend : "+ Message);
		}catch(IOException e) {
			window.append("\n something messed up");
		}
	}
	
	private void showMessage(final String text) {
		SwingUtilities.invokeLater(
				new Runnable() {
					public void run() {
						window.append(text);
					}
				}
				);
	}
	
	private void abletotype(final boolean tof){
		SwingUtilities.invokeLater(
				new Runnable() {
					public void run() {
						text.setEditable(tof);
					}
				}
			);
	}
	
	
	
	
	
	
}
