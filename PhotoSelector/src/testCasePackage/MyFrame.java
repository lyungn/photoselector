package testCasePackage;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPopupMenu;

import FramePackage.ProgressBarFrame;

public class MyFrame extends JFrame {
	JButton jButton1 = new JButton();
	JButton jButton2 = new JButton();
	

	public MyFrame() {
		try {
			init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void init() throws Exception {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		jButton1.setText("Show Singleton Frame");
		jButton1.setBounds(new Rectangle(12, 12, 220, 40));
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButton1_actionPerformed(e);
			}
		});

		jButton2.setText("Show the same Singleton Frame");
		jButton2.setBounds(new Rectangle(12, 72, 220, 40));
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButton2_actionPerformed(e);
			}
		});

		this.getContentPane().setLayout(null);
		this.getContentPane().add(jButton1, null);
		this.getContentPane().add(jButton2, null);
	}

	void jButton1_actionPerformed(ActionEvent e) {
		ProgressBarFrame jPro = ProgressBarFrame.getInstance();
		jPro.setMaxValue(100000000);
		jPro.setVisible(true);
		//SingletonFrame singletonFrame = SingletonFrame.getInstance();
		//singletonFrame.setVisible(true);
		
		jPro.setActualValue(10);
	}

	void jButton2_actionPerformed(ActionEvent e) {
		//jPro.setActualValue(1600);
		//SingletonFrame singletonFrame = SingletonFrame.getInstance();
		ProgressBarFrame jPro = ProgressBarFrame.getInstance();
		jPro.setActualValue(jPro.getActualValue());
		//singletonFrame.setVisible(true);
	}

	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
		frame.setSize(300, 250);
		frame.setVisible(true);
	}

}
