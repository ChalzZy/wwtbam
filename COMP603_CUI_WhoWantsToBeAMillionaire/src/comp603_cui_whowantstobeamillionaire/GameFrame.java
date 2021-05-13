package comp603_cui_whowantstobeamillionaire;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Jona Stevenson & Charles Monaghan
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
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        imageLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        answerA = new javax.swing.JButton();
        answerB = new javax.swing.JButton();
        answerC = new javax.swing.JButton();
        answerD = new javax.swing.JButton();
        askAudienceAnswer1 = new javax.swing.JLabel();
        askAudienceAnswer2 = new javax.swing.JLabel();
        askAudienceAnswer3 = new javax.swing.JLabel();
        askAudienceAnswer4 = new javax.swing.JLabel();
        fiftyFifty = new javax.swing.JButton();
        askTheAudience = new javax.swing.JButton();

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

        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        imageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/comp603_cui_whowantstobeamillionaire/wwtbam.jpg"))); // NOI18N
        jPanel4.add(imageLabel);

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

        answerA.setBackground(new java.awt.Color(51, 153, 255));
        answerA.setForeground(new java.awt.Color(255, 255, 255));
        answerA.setText("Answer 1");
        answerA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answerAActionPerformed(evt);
            }
        });

        answerB.setBackground(new java.awt.Color(51, 153, 255));
        answerB.setForeground(new java.awt.Color(255, 255, 255));
        answerB.setText("Answer 2");
        answerB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answerBActionPerformed(evt);
            }
        });

        answerC.setBackground(new java.awt.Color(51, 153, 255));
        answerC.setForeground(new java.awt.Color(255, 255, 255));
        answerC.setText("Answer 3");
        answerC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answerCActionPerformed(evt);
            }
        });

        answerD.setBackground(new java.awt.Color(51, 153, 255));
        answerD.setForeground(new java.awt.Color(255, 255, 255));
        answerD.setText("Answer 4");
        answerD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answerDActionPerformed(evt);
            }
        });

        askAudienceAnswer1.setText("20%");

        askAudienceAnswer2.setText("30%");

        askAudienceAnswer3.setText("40%");

        askAudienceAnswer4.setText("10%");

        fiftyFifty.setText("50/50");
        fiftyFifty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiftyFiftyActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(answerA, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(answerB, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(answerC, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(answerD, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(askAudienceAnswer1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(askAudienceAnswer2)
                                .addGap(156, 156, 156)
                                .addComponent(askAudienceAnswer3)
                                .addGap(156, 156, 156)
                                .addComponent(askAudienceAnswer4)
                                .addGap(84, 84, 84)))
                        .addComponent(answerBoxPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(questionTitlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fiftyFifty, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(askTheAudience, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 756, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(questionTitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(answerBoxPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(answerA, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(answerB, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(answerC, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(answerD, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(askAudienceAnswer3)
                                    .addComponent(askAudienceAnswer2)
                                    .addComponent(askAudienceAnswer4)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(askAudienceAnswer1)))))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fiftyFifty)
                    .addComponent(askTheAudience))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
        int currentQuestion = Integer.parseInt(questionNumber.getText());
        askTheAudience(qm, currentQuestion);
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
    private javax.swing.JLabel askAudienceAnswer1;
    private javax.swing.JLabel askAudienceAnswer2;
    private javax.swing.JLabel askAudienceAnswer3;
    private javax.swing.JLabel askAudienceAnswer4;
    private javax.swing.JButton askTheAudience;
    private javax.swing.JButton fiftyFifty;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JLabel jLabel2;
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
        askAudienceAnswer1.setVisible(false);
        askAudienceAnswer2.setVisible(false);
        askAudienceAnswer3.setVisible(false);
        askAudienceAnswer4.setVisible(false);
        
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
        System.out.println("fiftyFity() Working!");
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
            System.out.println("A PANEL DISABLED!");
            answerA.setEnabled(false);
        }
        if (randomNumOne == 2 || randomNumTwo == 2) {
            System.out.println(qm.getQuestions().get(currentQuestion).getAnswerTwo());
        } else {
            answerB.setEnabled(false);
            System.out.println("B PANEL DISABLED!");
        }
        if (randomNumOne == 3 || randomNumTwo == 3) {
            System.out.println(qm.getQuestions().get(currentQuestion).getAnswerThree());
        } else {
            answerC.setEnabled(false);    
            System.out.println("C PANEL DISABLED!");
        }
        if (randomNumOne == 4 || randomNumTwo == 4) {
            System.out.println(qm.getQuestions().get(currentQuestion).getAnswerFour());
        } else {
            answerD.setEnabled(false);
            System.out.println("D PANEL DISABLED!");
        }
        fiftyFifty.setEnabled(false);
    }
    
    public void askTheAudience(QuestionManager qm, int currentQuestion) {
        String answer = "61%";
        String incorrect2 = "10%";
        String incorrect3 = "15%";
        String incorrect4 = "14%";
        
        int correctAnswer = qm.getQuestions().get(currentQuestion - 1).getAnswerIndex();
        System.out.println(correctAnswer);
        switch (correctAnswer) {
            case 1:
                askAudienceAnswer1.setText(answer);
                askAudienceAnswer2.setText(incorrect2);
                askAudienceAnswer3.setText(incorrect3);
                askAudienceAnswer4.setText(incorrect4);
                break;
            case 2:
                askAudienceAnswer1.setText(incorrect2);
                askAudienceAnswer2.setText(answer);
                askAudienceAnswer3.setText(incorrect4);
                askAudienceAnswer4.setText(incorrect3);
                break;
            case 3:                
                askAudienceAnswer1.setText(incorrect2);
                askAudienceAnswer2.setText(incorrect3);
                askAudienceAnswer3.setText(answer);
                askAudienceAnswer4.setText(incorrect4);
                break;
            case 4:
                askAudienceAnswer1.setText(incorrect4);
                askAudienceAnswer2.setText(incorrect2);
                askAudienceAnswer3.setText(incorrect3);
                askAudienceAnswer4.setText(answer);
                break;
        }
        askAudienceAnswer1.setVisible(true);
        askAudienceAnswer2.setVisible(true);
        askAudienceAnswer3.setVisible(true);
        askAudienceAnswer4.setVisible(true);
        askTheAudience.setEnabled(false);
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
