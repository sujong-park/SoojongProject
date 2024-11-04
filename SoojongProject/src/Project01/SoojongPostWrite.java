package Project01;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

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
	
	private String title;
    private String content;
    private String author;
    private Date createdAt;
	
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
		
		
		JPanel ListPanel = new JPanel();
		ListPanel.setLayout(new FlowLayout());
		
		add(btnPanel, BorderLayout.SOUTH);
		

		// SoojongPostWrite 클래스 내부에 있는 코드 예시
		addPostBtn.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        String title = titField.getText();
		        String content = contentField.getText();
		        String author = "이름"; // 또는 사용자 입력을 받는 방식
		        Date createdAt = new Date(); // 현재 날짜

		        SoojongDTO dto = new SoojongDTO(title, content, author, createdAt);
		        boolean isInserted = dao.insertMember(dto);

		        if (isInserted) {
		            System.out.println("insert 성공");
		            dispose(); // 창 닫기
		        } else {
		            System.out.println("insert 실패");
		        }
		        refreshTable();
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