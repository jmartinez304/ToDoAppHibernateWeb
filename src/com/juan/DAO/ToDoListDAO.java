package com.juan.DAO;

import java.util.List;

import com.juan.ToDoAppHibernateWeb.ToDoList;

/**
 * 
 * Data Access Object Interface which defines the standard operations to be
 * performed on a model object which in this case the object will be the To-Do
 * list items.
 *
 */
public interface ToDoListDAO {

	/**
	 * saveItem method that uses hibernate to save an item into the database.
	 * 
	 * @param itemEntry that is going to be added into the list.
	 */
	public void saveItem(ToDoList itemEntry);

	/**
	 * showAllItems method that uses hibernate to show all the To-Do list items from
	 * the database
	 * 
	 */
	public List<ToDoList> showAllListItems();

	/**
	 * deleteItem method that uses hibernate to delete an To-Do list item from the
	 * Database
	 * 
	 * @param listItem that is going to be deleted from the database.
	 */
	public void deleteItem(ToDoList listItem);

}
