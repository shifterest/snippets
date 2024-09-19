package tasks;

import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TaskFrame extends javax.swing.JFrame {
    TaskManager taskManager = new TaskManager();
    Vector v = new Vector();
    
    String taskID;
    String taskDescription;
    Task task;
    
    /**
     * Creates new form TaskFrame
     */
    public TaskFrame() {
        initComponents();
        
        taskID = "Task" + (taskManager.getSizeTaskManager() + 1);
        txtTask.setText(taskID);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        btnAdd = new javax.swing.JButton();
        btnComplete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTask = new javax.swing.JTable();
        btnList = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTask = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        btnListNotCompleted = new javax.swing.JButton();
        btlListCompleted = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnListRemoved = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Delmoro - Task Management Application");

        btnAdd.setText("+");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnComplete.setText("Mark task completed");
        btnComplete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompleteActionPerformed(evt);
            }
        });

        tblTask.setBackground(new java.awt.Color(200, 200, 200));
        tblTask.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Task ID", "Description", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblTask);
        if (tblTask.getColumnModel().getColumnCount() > 0) {
            tblTask.getColumnModel().getColumn(0).setResizable(false);
            tblTask.getColumnModel().getColumn(2).setResizable(false);
        }

        btnList.setText("All");
        btnList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(240, 0, 0));
        btnDelete.setForeground(new java.awt.Color(240, 240, 240));
        btnDelete.setText("Delete task");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        jLabel1.setText("Description");

        jLabel2.setText("Task ID");

        txtTask.setText("Task1");

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        jScrollPane2.setViewportView(txtDescription);

        btnListNotCompleted.setText("Not completed");
        btnListNotCompleted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListNotCompletedActionPerformed(evt);
            }
        });

        btlListCompleted.setText("Completed");
        btlListCompleted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btlListCompletedActionPerformed(evt);
            }
        });

        jLabel3.setText("List tasks");

        btnListRemoved.setText("Removed");
        btnListRemoved.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListRemovedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnExit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdd))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(27, 27, 27)
                        .addComponent(txtTask))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnComplete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnList)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btlListCompleted)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnListNotCompleted)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnListRemoved)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnComplete)
                            .addComponent(btnDelete))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnList)
                            .addComponent(btlListCompleted)
                            .addComponent(btnListNotCompleted)
                            .addComponent(btnListRemoved))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtTask))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(btnExit)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {                                       
        DefaultTableModel mTask = (DefaultTableModel) this.tblTask.getModel();
        v = new Vector();
        
        if (txtDescription.getText().equals("TaskRemoved")) {
            JOptionPane.showMessageDialog(this, "Invalid description.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (txtDescription.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Description empty.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            taskDescription = txtDescription.getText();
            task = new Task (taskID, taskDescription);
            taskManager.addTask (task);
            txtDescription.setText("");
        }
        
        listTasks();
            
    }                                      

    private void btnCompleteActionPerformed(java.awt.event.ActionEvent evt) {                                            
        String compTaskID = JOptionPane.showInputDialog("Enter Task ID");
        
        for (int i = 0; i < taskManager.getSizeTaskManager(); i++) {
            if (taskManager.getTask(i).getTaskId().equals(compTaskID)) {
                if (taskManager.getTask(i).isCompleted()) {
                    JOptionPane.showMessageDialog(this, "Task already completed.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    taskManager.markTaskAsCompleted(taskManager.getTask(i).getDescription());
                    listTasks();
                    return;
                }
            }
        }
        
        JOptionPane.showMessageDialog(this, "Task not found.", "Error", JOptionPane.ERROR_MESSAGE);
    }                                           

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {                                          
        DefaultTableModel mTask = (DefaultTableModel) this.tblTask.getModel();
        String removeTaskDesc = JOptionPane.showInputDialog("Enter Description");
        
        if (removeTaskDesc.equals("TaskRemoved")) {
            JOptionPane.showMessageDialog(this, "Invalid description.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        for (int i = 0; i < taskManager.getSizeTaskManager(); i++) {
            if (taskManager.getTask(i).getDescription().equals(removeTaskDesc)) {
                taskManager.removeTask(removeTaskDesc);
                listTasks();
                return;
            }
        }
        
        JOptionPane.showMessageDialog(this, "Task not found.", "Error", JOptionPane.ERROR_MESSAGE);
    }                                         

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {                                        
        int result = JOptionPane.showConfirmDialog(this, "Do you want to exit?", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if (result == JOptionPane.YES_OPTION) System.exit(0);
    }                                       

    private void btnListActionPerformed(java.awt.event.ActionEvent evt) {                                        
        listTasks();
        
        JOptionPane.showMessageDialog(this, "All tasks listed.", "Done", JOptionPane.INFORMATION_MESSAGE);
    }                                       

    private void btnListNotCompletedActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        listTasks(false, false);
        
        JOptionPane.showMessageDialog(this, "Uncompleted tasks listed.", "Done", JOptionPane.INFORMATION_MESSAGE);
    }                                                   

    private void btlListCompletedActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        listTasks(true, false);
        
        JOptionPane.showMessageDialog(this, "Completed tasks listed.", "Done", JOptionPane.INFORMATION_MESSAGE);
    }                                                

    private void btnListRemovedActionPerformed(java.awt.event.ActionEvent evt) {                                               
        listTasks(false, true);
        
        JOptionPane.showMessageDialog(this, "Removed tasks listed.", "Done", JOptionPane.INFORMATION_MESSAGE);
    }                                              

    private void listTasks() {
        DefaultTableModel mTask = (DefaultTableModel) this.tblTask.getModel();
        mTask.setRowCount(0);
        v = new Vector ();

        for (int i = 0; i < taskManager.getSizeTaskManager(); i++) {
            v = new Vector();
            task = taskManager.getTask(i);

            if (!task.getDescription().equals("TaskRemoved")) {
                taskID = task.getTaskId();
                taskDescription = task.getDescription();
                v.add (taskID);
                v.add (taskDescription);
                if (task.isCompleted()) v.add ("COMPLETED");
                else v.add ("NOT COMPLETED");
                mTask.addRow (v);
            }
        }

        taskID = "Task" + (taskManager.getSizeTaskManager() + 1);
        txtTask.setText(taskID);
    }
    
    private void listTasks(boolean isCompleted, boolean isRemoved) {
        DefaultTableModel mTask = (DefaultTableModel) this.tblTask.getModel();
        mTask.setRowCount(0);
        v = new Vector ();

        for (int i = 0; i < taskManager.getSizeTaskManager(); i++) {
            v = new Vector();
            task = taskManager.getTask(i);

            if (isRemoved) {
                if (task.getDescription().equals("TaskRemoved")) {
                    taskID = task.getTaskId();
                    taskDescription = "REMOVED";
                    v.add (taskID);
                    v.add (taskDescription);
                    if (task.isCompleted()) v.add ("COMPLETED");
                    else v.add ("NOT COMPLETED");
                    mTask.addRow (v);
                }
            } else {
                if (isCompleted) {
                    if (task.isCompleted() && !task.getDescription().equals("TaskRemoved")) {
                        taskID = task.getTaskId();
                        taskDescription = task.getDescription();
                        v.add (taskID);
                        v.add (taskDescription);
                        v.add ("COMPLETED");
                        mTask.addRow (v);
                    }
                } else {
                    if (!task.isCompleted() && !task.getDescription().equals("TaskRemoved")) {
                        taskID = task.getTaskId();
                        taskDescription = task.getDescription();
                        v.add (taskID);
                        v.add (taskDescription);
                        v.add ("NOT COMPLETED");
                        mTask.addRow (v);
                    }
                }
            }
        }

        taskID = "Task" + (taskManager.getSizeTaskManager() + 1);
        txtTask.setText(taskID);
    }
     
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TaskFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TaskFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TaskFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TaskFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TaskFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btlListCompleted;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnComplete;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnList;
    private javax.swing.JButton btnListNotCompleted;
    private javax.swing.JButton btnListRemoved;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblTask;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JLabel txtTask;
    // End of variables declaration                   
}
