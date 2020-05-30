//server main class


import javax.swing.JFrame;

public class chat_main {
	public static void main(String[] args) {
		tannveer t = new tannveer();
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		t.startRunning();
	}
}



// Server setup class

import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class tannveer extends JFrame{
	
	private JTextField text;
	private JTextArea window;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private ServerSocket server;
	private Socket connection;
	
	public tannveer() {
		
		super("Messenger");
		
		//adding text field
		
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
		add(text,BorderLayout.SOUTH);
		
		//adding chat window
		
		window = new JTextArea();
		add(new JScrollPane(window));
		setSize(300,100);
		setVisible(true);
	}
	
	public void startRunning() {
		try {
			server = new ServerSocket(1234,100);
			while(true) {
				try {
					waitForConnection();
					setupStream();
					whileChatting();
				}catch(EOFException e) {
					showMessage("\n Server ended the connection!");
				}finally {
					closechat();
				}
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private void waitForConnection() throws IOException{
		showMessage("Waiting for someone to connect... \n");
		connection = server.accept();
		showMessage("Now connected to " + connection.getInetAddress().getHostName());
	}
	
	private void setupStream() throws IOException {
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush();
		input = new ObjectInputStream(connection.getInputStream());
		showMessage("\n Streams are now setup \n");
	}
	
	private void whileChatting() throws IOException{
		String Message = "You are now connected! ";
		sendMessage(Message);
		abletotype(true);
		do {
			try {
				Message = (String)	input.readObject();
				showMessage("\n " + Message);
			}catch(ClassNotFoundException e) {
				showMessage("\n Sent something weird");
			}
		}while(!Message.equals("CLIENT - END"));
	}
	
	private void closechat() {
		showMessage("\n closing down server");
		abletotype(false);
		try {
			output.close();
			input.close();
			connection.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private void sendMessage(String message) {
		try {
			output.writeObject("Tanveer : "+ message);
			output.flush();
			showMessage("\n Tanveer : " + message);
		}catch(IOException e) {
			window.append("\n Can't send message");
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