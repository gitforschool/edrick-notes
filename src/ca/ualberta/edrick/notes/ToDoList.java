/*
Student Picker: Randomly pick students to answer questions

Copyright (C) 2014 Abram Hindle abram.hindle@softwareprocess.ca
Copyright (C) 2014 Edrick de Guzman edrick@ualberta.ca

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.
This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
GNU General Public License for more details.
You should have received a copy of the GNU General Public License
along with this program. If not, see <http://www.gnu.org/licenses/>.

*/
package ca.ualberta.edrick.notes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/** This class was implemented by explicitly following Dr. Abram Hindle's StudentPicker videos 
 * https://www.youtube.com/playlist?list=PL240uJOh_Vb4PtMZ0f7N8ACYkCLv0673O 
*/
public class ToDoList implements Serializable {
	
	/**
	 * ToDoList Serialization ID
	 */
	private static final long serialVersionUID = 7292657333395976816L;
	private ArrayList<ToDoItem> todoList = null;
	private transient ArrayList<Listener> listeners;
	
	public ToDoList() {
		todoList = new ArrayList<ToDoItem>();
		listeners = new ArrayList<Listener>();
	}
	
	public ToDoList(Collection<ToDoItem> items) {
		todoList = new ArrayList<ToDoItem>(items);
		listeners = new ArrayList<Listener>();

	}
	
	private ArrayList<Listener> getListeners() {
		if (listeners == null ) {
			listeners = new ArrayList<Listener>();
		}
		return listeners;
	}
	
	public Collection<ToDoItem> getList() {
		return todoList;
	}
	
	public void addToDo(ToDoItem item) {
		todoList.add(item);
		notifyListeners();
	}

	public void removeToDo(ToDoItem item) {
		todoList.remove(item);
		notifyListeners();
	}

	public void removeAll() {
		todoList.clear();
		notifyListeners();
	}
	
	public int size() {
		return todoList.size();
	}
	
	public boolean contains(ToDoItem item) {
		return todoList.contains(item);
	}
	
	public void notifyListeners() {
		for (Listener listener : getListeners()) {
			listener.update();
		}
	}

	public ToDoItem getToDoItem(int pos) {
		return todoList.get(pos);
	}
	
	public void addListener(Listener l) {
		getListeners().add(l);
	}

	public void removeListener(Listener l) {
		getListeners().remove(l);
	}

	public void addAll(Collection<ToDoItem> items) {
		todoList.addAll(items);
	}
	
	public void clear() {
		todoList.clear();
	}
}
