package Project01;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class SoojongPosts extends JFrame {
	private JTextField nameField;
	private JTextField emailField;
	private JPasswordField passwordField;
	private JPasswordField passwordConfirmField;
	
	SoojongDAO dao = null;
	
	private DefaultListModel<String> postListModel = new DefaultListModel<>();
	private final JList<String> postsList = new JList<>(postListModel);
	
	public SoojongPosts() {
		setTitle("프로그램 V 1.0.0 포스트");
		setSize(1000, 300);
		setLocationRelativeTo(null); // 화면 가운데 정렬
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		dao = new SoojongDAO();
		
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new FlowLayout());

		JButton addPostBtn = new JButton("등록");
		btnPanel.add(addPostBtn);

		JPanel ListPanel = new JPanel();
		ListPanel.setLayout(new FlowLayout());
		
		add(btnPanel, BorderLayout.SOUTH);
		
		
		postsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		postsList.addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting()) {
				String selectedWord = postsList.getSelectedValue();
				if (selectedWord != null) {
					System.out.println("selectedWord : " + selectedWord);
					String[] parts = selectedWord.split(",");
					String idPart = parts[0].trim();
					String idValue = idPart.split("=")[1].trim();
					int id = Integer.parseInt(idValue);
					
					System.out.println("ID 값: " + id);
				}

			}

		});

		JScrollPane scrollPane = new JScrollPane(postsList);
		add(scrollPane, BorderLayout.CENTER);

		
		
		
		refreshTable();
		
		setVisible(true);		
		
		addPostBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SoojongPostWrite();
			}
		});
		
		
	}
	
	public void refreshTable() {
		postListModel.clear();
		ArrayList<SoojongDTO> resultList = dao.selectAllMember();
		for (SoojongDTO SoojongDTO : resultList) {
			postListModel.addElement(SoojongDTO.toPostString());
		}

	}
	
	public static void main(String[] args) {
		new SoojongPosts();
	}

}
