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
		setTitle("프로그램 V 1.0.0 로그인");
		setSize(1000, 300);
		setLocationRelativeTo(null); // 화면 가운데 정렬
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		dao = new SoojongDAO();
		
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
		        String password = passwordField.getText();
		        
		        // 입력된 이름으로 회원 조회
		        SoojongDTO memberDTO = dao.selectMemberByName(name);

		        if (memberDTO != null && memberDTO.getPassword() != null) { // null 체크 추가
		            // 비밀번호 일치 여부 확인
		            if (memberDTO.getPassword().equals(password)) {
		                JOptionPane.showMessageDialog(null, "로그인 성공!", "확인", JOptionPane.INFORMATION_MESSAGE);
		                new SoojongPosts();
		            } else {
		                JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.", "로그인 실패", JOptionPane.WARNING_MESSAGE);
		            }
		        } else {
		            JOptionPane.showMessageDialog(null, "해당 이름의 회원이 존재하지 않거나 비밀번호가 설정되지 않았습니다.", "로그인 실패", JOptionPane.WARNING_MESSAGE);
		        }
		    }
		});
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SoojongMain();
	}

}
