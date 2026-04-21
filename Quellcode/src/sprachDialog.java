import java.awt.*;
import javax.swing.*;
import jxl.Sheet;
import java.io.File;
import jxl.Cell;
import jxl.Workbook;
import java.util.*;
import java.awt.event.MouseEvent;
import java.awt.event.ItemEvent;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: </p>
 *
 * @author unbekannt
 * @version 1.0
 */
public class sprachDialog
    extends JDialog {
  JButton jButton1 = new JButton();
  JList jListSprachen = new JList();
  JScrollPane scrollPane = new JScrollPane();
  JComboBox jComboBoxSprachen = new JComboBox();


  // Or in two steps:
  //JScrollPane scrollPane = new JScrollPane();
  //scrollPane.getViewport().setView(jListSprachen);



  public sprachDialog(Frame owner, String title, boolean modal) {
    super(owner, title, modal);
    //jListSprachen.setListData(sv);
     scrollPane.getViewport().setView(jListSprachen);

    try {
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      jbInit();
      pack();
    }
    catch (Exception exception) {
      exception.printStackTrace();
    }
  }

  public sprachDialog(Frame owner,String title, boolean modal,Vector sv) {
     super(owner, title, modal);
     //jListSprachen.setListData(sv);
       int s = sv.size();
       int v;
       for (v=1;v<s;v++)
       {
         jComboBoxSprachen.addItem(sv.get(v));
       }
       jComboBoxSprachen.setEditable(false);
       jComboBoxSprachen.setSelectedIndex(startframe.sprachIndex);
       jComboBoxSprachen.addItemListener(new java.awt.event.ItemListener()
      {
      public void itemStateChanged(ItemEvent e) {

        int a = jComboBoxSprachen.getSelectedIndex();
        String b = jComboBoxSprachen.getSelectedItem().toString();
        int r;
      }
    });

     //scrollPane.getViewport().setView(jListSprachen);
     try {
       setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       jbInit();
       pack();
     }
     catch (Exception exception) {
       exception.printStackTrace();
     }
  }
  public sprachDialog() {
    this(new Frame(), "Sprache wählen.", false);


  }
public  sprachDialog(Vector sv)
  {
    this(new Frame(), "Sprache wählen.", false);
    jListSprachen.setListData(sv);
    scrollPane.getViewport().setView(jListSprachen);
  }

  private void jbInit() throws Exception {
    jButton1.setText("ok");
    jButton1.addMouseListener(new java.awt.event.MouseAdapter() {

     public void mouseClicked(MouseEvent e) {
       startframe.sprachIndex = jComboBoxSprachen.getSelectedIndex();
        String strf = jComboBoxSprachen.getSelectedItem().toString();
       dispose();
     }
   });

    this.getContentPane().add(jButton1, java.awt.BorderLayout.SOUTH);
    this.getContentPane().add(jListSprachen, java.awt.BorderLayout.NORTH);
    this.getContentPane().add(jComboBoxSprachen, java.awt.BorderLayout.CENTER);
    //this.getContentPane().add(scrollPane,java.awt.BorderLayout.CENTER);
    this.setBackground(new Color(55, 71, 100));
  }
  void datainit()
  {

  }
}
