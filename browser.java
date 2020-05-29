//MAIN CLASS

import javax.swing.JFrame;

public class tannveer {
	public static void main(String[] args) {
		index i = new index();
		i.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

// MAKING THE BROWSER

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class index extends JFrame{
	private JTextField bar;
	private JEditorPane display;
	
	public index() {
		super("Sasta Firefox");
		bar = new JTextField("Enter a url");
		bar.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						load(e.getActionCommand());
					}
					
				}
				);
		add(bar,BorderLayout.NORTH);
		
		display = new JEditorPane();
		display.setEditable(false);
		display.addHyperlinkListener(
				new HyperlinkListener() {
					public void hyperlinkUpdate(HyperlinkEvent event) {
						if(event.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
							load(event.getURL().toString());
						}
					}
					
				}
				);
		add(new JScrollPane(display),BorderLayout.CENTER);
		setSize(500,300);
		setVisible(true);
		
	}
	private void load(String user_text) {
		try {
			display.setPage(user_text);
			bar.setText(user_text);
		}catch(Exception e) {
			System.out.println("wrong url");
		}
	}
}