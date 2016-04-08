package au.com.new1step.apps.dynamic.table;

import org.hibernate.cfg.ImprovedNamingStrategy;
import org.springframework.context.MessageSource;

public class CustomNamingStrategy extends ImprovedNamingStrategy{
	// this class used to create dynamic data table name
	private static final long serialVersionUID = 1L;
		
    private MessageSource messageSource;
	
	
	@Override
	public String columnName(String columnName){
		//System.out.println ("ANDY-IN-COLUMN-NAME: " + columnName);
	        return columnName;
	}

	@Override
	public String tableName(String tableName){  
		   // System.out.println ("ANDY-IN-TABLE-NAME: " + tableName);
	       // return "NEW_" + tableName;
	        return tableName;
	}
   
	
	@Override
    public String classToTableName(final String className) {		
        return this.addPrefix(super.classToTableName(className));
    }
	
	private String addPrefix(final String composedTableName) {
		StringBuilder sb = new StringBuilder();
		sb.append(messageSource.getMessage("appName", null, null));
		sb.append("_");
		sb.append(composedTableName.toLowerCase());		
		//System.out.println("NEW-TABLE-NAME: " + sb.toString());
        return sb.toString();
    }	
	

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
}
