package main.inventory;

import main.exceptions.FullStorageException;

import java.util.ArrayList;
;

public class Inventory implements  IInventory{
	int capacity = 0;
	ArrayList<String> items;

	public int maximumcapacity;

	/**
	 * @param capacity  The number of items that the inventory can handle
	 */

	public void Inventory(int capacity) {
		this.maximumcapacity = 10;
		this.items = new ArrayList<String>();
	}

	public String addItem(String item) {
		if (this.items.size() < this.maximumcapacity) {
			this.items.add(item);
			return "Item added";
		} else {
			return "Inventory is full";
		}
	}

	public void listItems() {
		for (int i = 0; i < this.items.size(); i++) {
			System.out.println((i + 1) + ". " + this.items.get(i));
		}
	}

	public boolean isFull() {
		return this.items.size() == this.maximumcapacity;
	}
	public Inventory(int capacity) {
		this.capacity = capacity;
		this.items = new ArrayList<String>();
	}

	/**
	 * AddItem method lets you add a new item to the inventory
	 *
	 * @param val       The String value that you want to add to inventory
	 * @exception FullStorageException  If the number of items has reached the capacity of the inventory
	 */

	public void setItem(String val) throws FullStorageException {
		if(hasAvailableStorage()){
			this.items.add(val);
		}
		else {
			throw new FullStorageException("No space left");
		}
	}

	/**
	 * getItems method gives you the actual items in the inventory
	 *
	 * @return          Returns an ArrayList of the actual state of the inventory
	 */

	public ArrayList<String> getItems() {
		return this.items;
	}

	private Boolean hasAvailableStorage(){
		return this.items.size() < this.capacity ? true: false;
	}

}