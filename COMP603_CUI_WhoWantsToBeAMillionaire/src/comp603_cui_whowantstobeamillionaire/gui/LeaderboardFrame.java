package comp603_cui_whowantstobeamillionaire.gui;

import comp603_cui_whowantstobeamillionaire.Player;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;

/**
 * Leaderboard GUI
 * @author Charles Monaghan & Jona Stevenson
 */
public class LeaderboardFrame extends javax.swing.JFrame {

    private static final String LEADERBOARD = "src/comp603_cui_whowantstobeamillionaire/leaderboard.txt";

    /**
     * Creates new form LeaderboardFrame
     */
    public LeaderboardFrame() {
        initComponents();
        this.importLeaderboard();
        this.generateTable();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titlePanel = new javax.swing.JPanel();
        leaderboardLabel = new javax.swing.JLabel();
        menuPanel = new javax.swing.JPanel();
        backToMenuButton = new javax.swing.JButton();
        tablePanel = new javax.swing.JScrollPane();
        leaderboardTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        leaderboardLabel.setText("Leaderboard");
        titlePanel.add(leaderboardLabel);

        backToMenuButton.setText("Back to Main Menu");
        backToMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToMenuButtonActionPerformed(evt);
            }
        });
        menuPanel.add(backToMenuButton);

        leaderboardTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Rank", "Player Name", "Score"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablePanel.setViewportView(leaderboardTable);
        if (leaderboardTable.getColumnModel().getColumnCount() > 0) {
            leaderboardTable.getColumnModel().getColumn(0).setResizable(false);
            leaderboardTable.getColumnModel().getColumn(0).setPreferredWidth(30);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(tablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backToMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToMenuButtonActionPerformed
        this.setVisible(false);
        MainScreen ms = new MainScreen();
        ms.setVisible(true);
    }//GEN-LAST:event_backToMenuButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new LeaderboardFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backToMenuButton;
    private javax.swing.JLabel leaderboardLabel;
    private javax.swing.JTable leaderboardTable;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JScrollPane tablePanel;
    private javax.swing.JPanel titlePanel;
    // End of variables declaration//GEN-END:variables

    private void generateTable() {
        System.out.println("Sorted leaderboard generated");
        ArrayList<Player> player = importLeaderboard();
        DefaultTableModel model = (DefaultTableModel) leaderboardTable.getModel();
        int leaderboardCount = 1;
        // Add sorted players to the leaderboard
        for (Player i : player) {
            System.out.println(leaderboardCount + ") " + i);
            model.addRow(new Object[]{leaderboardCount, i.getName(), i.getScore()});
            leaderboardCount++;
        }
    }

    private ArrayList<Player> importLeaderboard() {
        ArrayList<Player> playerScores = new ArrayList<>();
        File file = new File(LEADERBOARD);

        // Read each line of leaderboard.txt and split "," into name & score
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                String[] parts = line.split(",");
                String lbName = parts[0];
                int score = Integer.parseInt(parts[1]);

                playerScores.add(new Player(lbName, score));

                // Sorts list by player scores high -> low
                playerScores.sort(Comparator.comparingInt(Player::getScore).reversed());
            }
        } catch (Exception e) {
            System.out.println("Couldn't import questions.");
            System.out.println("Error: " + e.getMessage());
        }
        return playerScores;
    }

    public void appendLeaderboard(String name, int bank) {
        // Open file in append mode
        try {
            FileWriter fw = new FileWriter("src/comp603_cui_whowantstobeamillionaire/leaderboard.txt", true);

            // Append item
            fw.append("\n" + name + "," + bank);

            // Close the file
            fw.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
