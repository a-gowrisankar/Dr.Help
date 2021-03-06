package View;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.mysql.jdbc.ResultSetMetaData;

import Models.ResultSetFetch;

public class MedView {

	
	
	

	public void MedViewByLoc(String LocName) 
	{
		Models.ResultSetFetch MRS = new ResultSetFetch();
		Vector<Vector<Object>> records = new Vector<Vector<Object>>();
		Vector<String> columns = new Vector<String>();
		try
		{
			System.out.println(LocName);
		ResultSet rs = ResultSetFetch.getMedRecordsByLoc(LocName.toUpperCase());
		java.sql.ResultSetMetaData metaData = rs.getMetaData();
		int columnsCount = metaData.getColumnCount();

		// get column names from table!
		String cols = "";

		for (int i = 1; i <= columnsCount; i++) {
			cols = metaData.getColumnName(i);
			columns.add(cols);
		}
		// get row data from table!
		while (rs.next()) {
			Vector<Object> row = new Vector<Object>(columnsCount);

			for (int i = 1; i <= columnsCount; i++) {
				row.addElement(rs.getObject(i));
			}
			records.addElement(row);
		}
		rs.close();

		DefaultTableModel model = new DefaultTableModel(records, columns);

		JTable table = new JTable(model);
		
		JFrame frame = new JFrame("NearBy Medical Shops");
		frame.setSize(1500, 1500);
		frame.add(new JScrollPane(table));
		//frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
	
	public void MedView(String tZipCode) 
	{
		Models.ResultSetFetch MRS = new ResultSetFetch();
		Vector<Vector<Object>> records = new Vector<Vector<Object>>();
		Vector<String> columns = new Vector<String>();
		try
		{
			System.out.println(tZipCode);
		ResultSet rs = ResultSetFetch.getMedRecordsByZip(tZipCode);
		java.sql.ResultSetMetaData metaData = rs.getMetaData();
		int columnsCount = metaData.getColumnCount();

		// get column names from table!
		String cols = "";

		for (int i = 1; i <= columnsCount; i++) {
			cols = metaData.getColumnName(i);
			columns.add(cols);
		}
		// get row data from table!
		while (rs.next()) {
			Vector<Object> row = new Vector<Object>(columnsCount);

			for (int i = 1; i <= columnsCount; i++) {
				row.addElement(rs.getObject(i));
			}
			records.addElement(row);
		}
		rs.close();

		DefaultTableModel model = new DefaultTableModel(records, columns);

		JTable table = new JTable(model);

		JFrame frame = new JFrame("NearBy Medical Shops");
		frame.setSize(700, 200);
		frame.add(new JScrollPane(table));
		//frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
