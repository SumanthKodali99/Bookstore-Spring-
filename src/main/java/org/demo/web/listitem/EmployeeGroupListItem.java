/*
 * Created on 3 avr. 2014 ( Time 19:39:50 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package org.demo.web.listitem;

import org.demo.bean.EmployeeGroup;
import org.demo.web.common.ListItem;

public class EmployeeGroupListItem implements ListItem {

	private final String value ;
	private final String label ;
	
	public EmployeeGroupListItem(EmployeeGroup employeeGroup) {
		super();

		this.value = ""
			 + employeeGroup.getEmployeeCode()
			 + "|"  + employeeGroup.getGroupId()
		;

		//TODO : Define here the attributes to be displayed as the label
		this.label = employeeGroup.toString();
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public String getLabel() {
		return label;
	}

}
