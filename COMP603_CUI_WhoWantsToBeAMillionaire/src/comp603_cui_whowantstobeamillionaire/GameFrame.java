package comp603_cui_whowantstobeamillionaire;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Jona Stevenson
 */
public class GameFrame extends javax.swing.JFrame {

    private static Player newPlayer;
    private LeaderboardFrame lbf;
    private QuestionManager qm;
    private Bank bank;
//    private Lifeline lifeline;

    /**
     * Creates new gameFrame
     *
     * @param player
     */
    public GameFrame(Player player) {
        initComponents();
        GameFrame.newPlayer = player;
        this.lbf = new LeaderboardFrame();
        this.qm = new QuestionManager();
        this.bank = new Bank();
        this.importQuestions();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        questionTitlePanel = new javax.swing.JPanel();
        questionText = new javax.swing.JLabel();
        questionNumber = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        questionValue = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        questionTitle = new javax.swing.JLabel();
        answerBoxPanel = new javax.swing.JPanel();
        answerA = new javax.swing.JButton();
        answerB = new javax.swing.JButton();
        answerC = new javax.swing.JButton();
        answerD = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        fiftyFifty = new javax.swing.JButton();
        askTheAudience = new javax.swing.JButton();
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

        questionValue.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        questionValue.setText("$500");
        questionTitlePanel.add(questionValue);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        questionTitle.setForeground(new java.awt.Color(255, 255, 255));
        questionTitle.setText("Question Placeholder");
        jPanel1.add(questionTitle, new java.awt.GridBagConstraints());

        answerBoxPanel.setLayout(new java.awt.GridLayout(1, 0));

        answerA.setBackground(new java.awt.Color(51, 153, 255));
        answerA.setForeground(new java.awt.Color(255, 255, 255));
        answerA.setText("Answer 1");
        answerA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answerAActionPerformed(evt);
            }
        });
        answerBoxPanel.add(answerA);

        answerB.setBackground(new java.awt.Color(51, 153, 255));
        answerB.setForeground(new java.awt.Color(255, 255, 255));
        answerB.setText("Answer 2");
        answerB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answerBActionPerformed(evt);
            }
        });
        answerBoxPanel.add(answerB);

        answerC.setBackground(new java.awt.Color(51, 153, 255));
        answerC.setForeground(new java.awt.Color(255, 255, 255));
        answerC.setText("Answer 3");
        answerC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answerCActionPerformed(evt);
            }
        });
        answerBoxPanel.add(answerC);

        answerD.setBackground(new java.awt.Color(51, 153, 255));
        answerD.setForeground(new java.awt.Color(255, 255, 255));
        answerD.setText("Answer 4");
        answerD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answerDActionPerformed(evt);
            }
        });
        answerBoxPanel.add(answerD);

        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        fiftyFifty.setText("50/50");
        fiftyFifty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiftyFiftyActionPerformed(evt);
            }
        });
        jPanel3.add(fiftyFifty);

        askTheAudience.setText("Ask The Audience");
        askTheAudience.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                askTheAudienceMouseClicked(evt);
            }
        });
        askTheAudience.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                askTheAudienceActionPerformed(evt);
            }
        });
        jPanel3.add(askTheAudience);

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

    private void answerAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answerAActionPerformed
        checkAnswer(1);
    }//GEN-LAST:event_answerAActionPerformed

    private void answerBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answerBActionPerformed
        checkAnswer(2);
    }//GEN-LAST:event_answerBActionPerformed

    private void answerCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answerCActionPerformed
        checkAnswer(3);
    }//GEN-LAST:event_answerCActionPerformed

    private void answerDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answerDActionPerformed
        checkAnswer(4);
    }//GEN-LAST:event_answerDActionPerformed

    private void fiftyFiftyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiftyFiftyActionPerformed
        int currentQuestion = Integer.parseInt(questionNumber.getText());
        fiftyFifty(qm, currentQuestion - 1);
    }//GEN-LAST:event_fiftyFiftyActionPerformed

    private void askTheAudienceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_askTheAudienceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_askTheAudienceActionPerformed

    private void askTheAudienceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_askTheAudienceMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_askTheAudienceMouseClicked

    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new GameFrame(newPlayer).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton answerA;
    private static javax.swing.JButton answerB;
    private javax.swing.JPanel answerBoxPanel;
    private static javax.swing.JButton answerC;
    private static javax.swing.JButton answerD;
    private javax.swing.JButton askTheAudience;
    private javax.swing.JButton fiftyFifty;
    private javax.swing.JLabel jLabel2;
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
    private static javax.swing.JLabel questionValue;
    // End of variables declaration//GEN-END:variables

    public void start(int i) {
        GameFrame.questionNumber.setText(String.valueOf(i + 1));
        GameFrame.questionTitle.setText(qm.getQuestions().get(i).getTitle());
        GameFrame.answerA.setText(qm.getQuestions().get(i).getAnswerOne());
        GameFrame.answerB.setText(qm.getQuestions().get(i).getAnswerTwo());
        GameFrame.answerC.setText(qm.getQuestions().get(i).getAnswerThree());
        GameFrame.answerD.setText(qm.getQuestions().get(i).getAnswerFour());
        GameFrame.questionValue.setText(String.valueOf(qm.getQuestions().get(i).getQuestionValue()));
        GameFrame.answerA.setEnabled(true);
        GameFrame.answerB.setEnabled(true);
        GameFrame.answerC.setEnabled(true);
        GameFrame.answerD.setEnabled(true);
    }

    public void checkAnswer(int i) {
        int currentQuestion = Integer.parseInt(questionNumber.getText());

        if (qm.getQuestions().get(currentQuestion - 1).getAnswerIndex() == i) {
            this.bank.setMoney(qm.getQuestions().get(currentQuestion - 1).getQuestionValue());
            JOptionPane.showMessageDialog(null, "That's correct, well done!\nBank: $" + this.bank.getAvaiBank(), "CORRECT", JOptionPane.INFORMATION_MESSAGE);
            this.start(currentQuestion);
        } else {
            if ((currentQuestion - 1) == 0) {
                JOptionPane.showMessageDialog(null, "That's incorrect!\nYou got no questions correct.", "Incorrect", JOptionPane.ERROR_MESSAGE);
            } else if ((currentQuestion - 1) == 1) {
                GameFrame.newPlayer.setScore(bank.getAvaiBank());
                lbf.appendLeaderboard(newPlayer.getName(), newPlayer.getScore());
                
                JOptionPane.showMessageDialog(null, "That's incorrect!\nYou got " + (currentQuestion - 1) + " question correct, earning $"
                        + this.bank.getAvaiBank() + ".\nYour score has been recorded on the leaderboard.", "Incorrect", JOptionPane.ERROR_MESSAGE);
            } else {
                GameFrame.newPlayer.setScore(bank.getAvaiBank());
                lbf.appendLeaderboard(newPlayer.getName(), newPlayer.getScore());
                
                JOptionPane.showMessageDialog(null, "That's incorrect!\nYou got " + (currentQuestion - 1) + " questions correct, earning $"
                        + this.bank.getAvaiBank() + ".\nYour score has been recorded on the leaderboard.", "Incorrect", JOptionPane.ERROR_MESSAGE);
            }

            this.setVisible(false);
            MainScreen ms = new MainScreen();
            ms.setVisible(true);
        }
    }
    
    public void fiftyFifty(QuestionManager qm, int currentQuestion) {
        int randomNumOne;
        int randomNumTwo;
        System.out.println("Working!");
        while (true) {
            // Generates 2 random numbers between 1-4
            randomNumOne = 1 + (int) (Math.random() * ((4 - 1) + 1));
            randomNumTwo = 1 + (int) (Math.random() * ((4 - 1) + 1));

            // Checks that at least 1 number is the correct answer, and one is a random answer that isn't equal to number 1
            if ((randomNumOne == qm.getQuestions().get(currentQuestion).getAnswerIndex()
                    || randomNumTwo == qm.getQuestions().get(currentQuestion).getAnswerIndex()) && (randomNumOne != randomNumTwo)) {
                break;
            }
        }
        
        System.out.println("Possible answers:");
        
        // Assigns each random number generated to it's applicable answer and prints it
        if (randomNumOne == 1 || randomNumTwo == 1) {
            System.out.println(qm.getQuestions().get(currentQuestion).getAnswerOne());
        } else {
            System.out.println("DISABLED!");
            answerA.setEnabled(false);
        }
        if (randomNumOne == 2 || randomNumTwo == 2) {
            System.out.println(qm.getQuestions().get(currentQuestion).getAnswerTwo());
        } else {
            answerB.setEnabled(false);
            System.out.println("DISABLED!");
        }
        if (randomNumOne == 3 || randomNumTwo == 3) {
            System.out.println(qm.getQuestions().get(currentQuestion).getAnswerThree());
        } else {
            answerC.setEnabled(false);    
            System.out.println("DISABLED!");
        }
        if (randomNumOne == 4 || randomNumTwo == 4) {
            System.out.println(qm.getQuestions().get(currentQuestion).getAnswerFour());
        } else {
            answerD.setEnabled(false);
            System.out.println("DISABLED!");
        }

        fiftyFifty.setEnabled(false);
        
    }

    public final void importQuestions() {
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
}
