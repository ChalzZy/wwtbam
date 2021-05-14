package wwtbam_gui.gui;

import wwtbam_gui.Player;

/**
 * Signs the player in
 *
 * @author Jona Stevenson & Charles Monaghan
 */
public class SignInFrame extends javax.swing.JFrame {

    /**
     * Creates new form SignInFrame
     */
    public SignInFrame() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonPanel = new javax.swing.JPanel();
        startButton = new javax.swing.JButton();
        textPanel = new javax.swing.JPanel();
        textLabel = new javax.swing.JLabel();
        nameFieldPanel = new javax.swing.JPanel();
        nameField = new javax.swing.JTextField();
        nameFieldPanel1 = new javax.swing.JPanel();
        nameErrorLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        startButton.setText("Start Game");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(startButton);

        textPanel.setLayout(new java.awt.GridBagLayout());

        textLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textLabel.setText("To continue, please enter your first name:");
        textPanel.add(textLabel, new java.awt.GridBagConstraints());

        nameField.setText("First Name");
        nameField.setPreferredSize(new java.awt.Dimension(120, 22));
        nameFieldPanel.add(nameField);

        nameErrorLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        nameErrorLabel.setForeground(new java.awt.Color(255, 51, 51));
        nameFieldPanel1.add(nameErrorLabel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                    .addComponent(nameFieldPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nameFieldPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(109, Short.MAX_VALUE)
                .addComponent(textPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameFieldPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nameFieldPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Initiates a new game
     *
     * @param evt
     */
    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        String name = nameField.getText();

        if (!name.matches("^[a-zA-Z]+$")) {
            nameErrorLabel.setText("Please enter your first name only!");
        } else {
            Player newPlayer = new Player(name, 0); // Creates a new player object with a default score of 0

            // Create new GameFrame object run it with the start method
            this.setVisible(false);
            GameFrame gf = new GameFrame(newPlayer);
            gf.setSize(797, 710);
            gf.start(0);
            gf.setVisible(true);
        }
    }//GEN-LAST:event_startButtonActionPerformed

    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new SignInFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JLabel nameErrorLabel;
    private javax.swing.JTextField nameField;
    private javax.swing.JPanel nameFieldPanel;
    private javax.swing.JPanel nameFieldPanel1;
    private javax.swing.JButton startButton;
    private javax.swing.JLabel textLabel;
    private javax.swing.JPanel textPanel;
    // End of variables declaration//GEN-END:variables
}
