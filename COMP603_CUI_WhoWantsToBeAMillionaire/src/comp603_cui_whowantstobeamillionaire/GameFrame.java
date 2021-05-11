package comp603_cui_whowantstobeamillionaire;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jona Stevenson
 */
public class GameFrame extends javax.swing.JFrame {

    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension screenSize = kit.getScreenSize();

    int screenWidth = screenSize.width;
    int screenHeight = screenSize.height;
    int frameWidth = screenWidth / 2;
    int frameHeight = screenHeight / 2;

    private Player newPlayer;
    private Leaderboard lb;
    private QuestionManager qm;
    private Bank bank;
    private int questionCount;

    /**
     * Creates new gameFrame
     */
    public GameFrame() {
        initComponents();
        this.setSize(778, 693);
        this.newPlayer = new Player("null", 0);
        this.lb = new Leaderboard();
        this.qm = new QuestionManager();
        this.bank = new Bank();
        this.importQuestions();
    }

    public void importQuestions() {
        try {
            DBManager dbm = new DBManager();
            Connection conn = dbm.getConnection();

            Statement stm;
            stm = conn.createStatement();

            String sql = "Select * From QUESTIONS";

            ResultSet rs;
            rs = stm.executeQuery(sql);

            while (rs.next()) {
                qm.addQuestion(new Question(rs.getString("QUESTION"), rs.getString("QUESTIONA"), rs.getString("QUESTIONB"),
                        rs.getString("QUESTIONC"), rs.getString("QUESTIOND"), rs.getInt("CORRECTANSWER"), rs.getInt("PRIZE")));
            }
        } catch (SQLException ex) {
            System.err.println("Unable to import questions. Excpetion: " + ex.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        questionTitlePanel = new javax.swing.JPanel();
        questionText = new javax.swing.JLabel();
        questionNumber = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        questionTitle = new javax.swing.JLabel();
        answerBoxPanel = new javax.swing.JPanel();
        answerA = new javax.swing.JButton();
        answerB = new javax.swing.JButton();
        answerC = new javax.swing.JButton();
        answerD = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        questionText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        questionText.setText("Question");
        questionTitlePanel.add(questionText);

        questionNumber.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        questionNumber.setText("-");
        questionTitlePanel.add(questionNumber);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("| Question Value: ");
        questionTitlePanel.add(jLabel2);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("$500");
        questionTitlePanel.add(jLabel3);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        questionTitle.setForeground(new java.awt.Color(255, 255, 255));
        questionTitle.setText("Question Placeholder");
        jPanel1.add(questionTitle, new java.awt.GridBagConstraints());

        answerBoxPanel.setLayout(new java.awt.GridLayout(1, 0));

        answerA.setBackground(new java.awt.Color(51, 153, 255));
        answerA.setForeground(new java.awt.Color(255, 255, 255));
        answerA.setText("Answer 1");
        answerBoxPanel.add(answerA);

        answerB.setBackground(new java.awt.Color(51, 153, 255));
        answerB.setForeground(new java.awt.Color(255, 255, 255));
        answerB.setText("Answer 2");
        answerBoxPanel.add(answerB);

        answerC.setBackground(new java.awt.Color(51, 153, 255));
        answerC.setForeground(new java.awt.Color(255, 255, 255));
        answerC.setText("Answer 3");
        answerBoxPanel.add(answerC);

        answerD.setBackground(new java.awt.Color(51, 153, 255));
        answerD.setForeground(new java.awt.Color(255, 255, 255));
        answerD.setText("Answer 4");
        answerBoxPanel.add(answerD);

        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        jButton6.setText("50/50");
        jPanel3.add(jButton6);

        jButton5.setText("Ask The Audience");
        jPanel3.add(jButton5);

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\jonat\\Desktop\\Who-Wants-To-Be-A-Millionaire_Jimmy-Kimmel-studio.jpg")); // NOI18N
        jPanel4.add(jLabel5);

        jScrollPane1.setToolTipText("");
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane1.setHorizontalScrollBar(null);
        jScrollPane1.setMaximumSize(new java.awt.Dimension(84, 134));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(84, 134));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(90, 250));

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "$1 MILLION", "$500 000", "$250 000", "$150 000", "$75 000", "$50 000", "$20 000", "$10 000", "$5 000", "$2 000", "$1 000", "$500" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.setToolTipText("");
        jList1.setAutoscrolls(false);
        jList1.setPreferredSize(new java.awt.Dimension(58, 350));
        jList1.setVisibleRowCount(12);
        jScrollPane1.setViewportView(jList1);

        jPanel4.add(jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(answerBoxPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(questionTitlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(questionTitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(answerBoxPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton answerA;
    private static javax.swing.JButton answerB;
    private javax.swing.JPanel answerBoxPanel;
    private static javax.swing.JButton answerC;
    private static javax.swing.JButton answerD;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JLabel questionNumber;
    private javax.swing.JLabel questionText;
    private static javax.swing.JLabel questionTitle;
    private javax.swing.JPanel questionTitlePanel;
    // End of variables declaration//GEN-END:variables

    public void start() {
        questionCount = 0;

        for (int i = 0; i < qm.getQuestions().size(); i++) {
            this.questionNumber.setText(String.valueOf(i + 1));
            this.questionTitle.setText(qm.getQuestions().get(i).getTitle());
            this.answerA.setText(qm.getQuestions().get(i).getAnswerOne());
            this.answerB.setText(qm.getQuestions().get(i).getAnswerTwo());
            this.answerC.setText(qm.getQuestions().get(i).getAnswerThree());
        }
    }
}
