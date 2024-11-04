package Project01;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class SoojongPostWrite extends JFrame {
	private JTextField titField;
	private JTextArea contentField;
	
	SoojongDAO dao = null;
	
	private DefaultListModel<String> postListModel = new DefaultListModel<>();
	private final JList<String> postsList = new JList<>(postListModel);
	
	public SoojongPostWrite() {
		setTitle("프로그램 V 1.0.0 포스트");
		setSize(1000, 300);
		setLocationRelativeTo(null); // 화면 가운데 정렬
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		dao = new SoojongDAO();

		JPanel titPanel = new JPanel();
		titPanel.setLayout(new BoxLayout(titPanel, BoxLayout.LINE_AXIS));

		JLabel titTit = new JLabel("title: ");
		titPanel.add(titTit);
		titTit.setPreferredSize(new Dimension(100, 0));
		titField = new JTextField(10);
		titPanel.add(titField);

		add(titPanel, BorderLayout.NORTH);

		
		JPanel conPanel = new JPanel();
		conPanel.setLayout(new BoxLayout(conPanel, BoxLayout.LINE_AXIS));
		
		JLabel conTit = new JLabel("content: ");
		conPanel.add(conTit);
		conTit.setPreferredSize(new Dimension(100, 0));
		contentField = new JTextArea();
		conPanel.add(contentField);

		add(conPanel, BorderLayout.CENTER);
		
		
		
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new FlowLayout());

		JButton addPostBtn = new JButton("등록");
		btnPanel.add(addPostBtn);
		
		JButton removePostBtn = new JButton("삭제");
		btnPanel.add(removePostBtn);
		
		JPanel ListPanel = new JPanel();
		ListPanel.setLayout(new FlowLayout());
		
		add(btnPanel, BorderLayout.SOUTH);
		

		addPostBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String title = titField.getText();
				String content = contentField.getText();

				SoojongDTO dto = new SoojongDTO(title, content);
				dao.insertMember(dto);
				refreshTable();
				
//				SoojongDTO memberLsyTest1205DTO = dao.selectMemberByEmail(email);
				// 이메일 중복 여부
//				if (memberLsyTest1205DTO == null) {
//
//					// 패스워드 일치 여부 확인
//					if (password.equals(passwordConfirm)) {
//						LsyTest1205DTO dto = new LsyTest1205DTO(name, email, password);
//						dao.insertMember(dto);
//						refreshTable();
//
//					} else {
//						// 경고 메시지 출력
//						JOptionPane.showMessageDialog(null, "패스워드가 일치하지 않습니다. 다시 확인해주세요.", "경고",
//								JOptionPane.WARNING_MESSAGE);
//					}
//				} // 이메일 중복 여부
//				else {
//					// 경고 메시지 출력
//					JOptionPane.showMessageDialog(null, "이메일 중복입니다. 다시 확인해주세요.", "경고",
//							JOptionPane.WARNING_MESSAGE);
//				}
			}
		});
		
		
		
		
		refreshTable();
		
		setVisible(true);
		
	}
	
	public void refreshTable() {
		postListModel.clear();
		ArrayList<SoojongDTO> resultList = dao.selectAllMember();
		for (SoojongDTO SoojongDTO : resultList) {
			postListModel.addElement(SoojongDTO.toPostString());
		}

	}
	
	public static void main(String[] args) {
		new SoojongPostWrite();
	}

}