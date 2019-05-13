/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exportfactory;

import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import view.TelaArduino;

/**
 *
 * @author Mathias
 */
public class ExportOptions {
    
    private String file = "";
    
    public String pathFounder(){
        JFileChooser fc = new JFileChooser();
        int option;
        
        option = fc.showSaveDialog(null);
        if(option == JFileChooser.APPROVE_OPTION){
            String fileName = fc.getSelectedFile().getName();
            String filePath = fc.getSelectedFile().getParentFile().getPath();
            int len = fileName.length();
            String ext = "";
            
            if(len > 4){
		ext = fileName.substring(len-4, len);
            }
            if(ext.equals(".xls")){
		file = filePath + "\\" + fileName; 
            }else{
		file = filePath + "\\" + fileName + ".xls"; 
            }
            
        }      
        return file;
    }
    
    public void toExcel(JTable table) {
        try {
            pathFounder();
            TableModel model = table.getModel();
            FileWriter excel = new FileWriter(file);

            for (int i = 0; i < model.getColumnCount(); i++) {
                excel.write(model.getColumnName(i) + "\t");
            }
            excel.write("\n");
            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < model.getColumnCount(); j++) {
                    excel.write(model.getValueAt(i, j).toString() + "\t");
                }
                excel.write("\n");
            }

            excel.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
