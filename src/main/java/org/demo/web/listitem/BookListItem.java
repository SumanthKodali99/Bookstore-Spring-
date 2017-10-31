/*
 * Created on 3 avr. 2014 ( Time 19:39:49 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package org.demo.web.listitem;

import org.demo.bean.Book;
import org.demo.web.common.ListItem;

public class BookListItem implements ListItem {

	private final String value ;
	private final String label ;
	
	public BookListItem(Book book) {
		super();

		this.value = ""
			 + book.getId()
		;

		//TODO : Define here the attributes to be displayed as the label
		this.label = book.toString();
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
