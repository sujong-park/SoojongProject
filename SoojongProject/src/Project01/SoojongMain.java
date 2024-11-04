package Project01;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SoojongMain extends JFrame {
	private JTextField nameField;
	private JTextField emailField;
	private JPasswordField passwordField;
	private JPasswordField passwordConfirmField;
	
	SoojongDAO dao = null;
	
	
	public SoojongMain() {
		setTitle("회원관리 프로그램 V 1.0.0");
		setSize(1000, 300);
		setLocationRelativeTo(null); // 화면 가운데 정렬
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new FlowLayout());
		
		JLabel nameTit = new JLabel("id: ");
		inputPanel.add(nameTit);
		nameField = new JTextField(10);
		inputPanel.add(nameField);
		
		JLabel emailTit = new JLabel("email: ");
		inputPanel.add(emailTit);
		emailField = new JTextField(10);
		inputPanel.add(emailField);

		JLabel passwordTit = new JLabel("password: ");
		inputPanel.add(passwordTit);
		passwordField = new JPasswordField(10);
		inputPanel.add(passwordField);

		JLabel passwordConfirmTit = new JLabel("password confirm: ");
		inputPanel.add(passwordConfirmTit);
		passwordConfirmField = new JPasswordField(10);
		inputPanel.add(passwordConfirmField);
		
		JButton loginbtn = new JButton("로그인");
		inputPanel.add(loginbtn);

		JButton signupbtn = new JButton("회원가입");
		inputPanel.add(signupbtn);

		JButton addbtn = new JButton("등록");
		inputPanel.add(addbtn);

		add(inputPanel, BorderLayout.CENTER);
		
		setVisible(true);
		
		emailTit.setVisible(false);
		emailField.setVisible(false);
		emailTit.setVisible(false);
		passwordConfirmTit.setVisible(false);
		passwordConfirmField.setVisible(false);
		
		addbtn.setVisible(false);
		
		
		
		
		
		
		
		loginbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				String email = emailField.getText();
				String password = passwordField.getText();
				String passwordConfirm = passwordConfirmField.getText();

				SoojongDTO memberLsyTest1205DTO = dao.selectMemberByEmail(email);
				// 이메일 중복 여부
				if (memberLsyTest1205DTO == null) {

					// 패스워드 일치 여부 확인
					if (password.equals(passwordConfirm)) {
						SoojongDTO dto = new SoojongDTO(name, email, password);
						dao.insertMember(dto);

					} else {
						// 경고 메시지 출력
						JOptionPane.showMessageDialog(null, "패스워드가 일치하지 않습니다. 다시 확인해주세요.", "경고",
								JOptionPane.WARNING_MESSAGE);
					}
				} // 이메일 중복 여부
				else {
					// 경고 메시지 출력
					JOptionPane.showMessageDialog(null, "이메일 중복입니다. 다시 확인해주세요.", "경고",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		}); // joinBtn
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SoojongMain();
	}

}
