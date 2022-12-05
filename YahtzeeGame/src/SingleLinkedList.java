
public class SingleLinkedList {
	Node head;
	
	
	SingleLinkedList(){
		
	}
	
	void sortList(SingleLinkedList n) {
		// this method sort scoreSLL in decreasing order with nameSLL .
		Node current = null, index=null , currentn=null , indexn=null ;
		Object tempObj;
		Object tempNameObj;
		if(head==null) {
			return;
		}else {
			
			current=head;
			currentn=n.head;
			while(current.getLink()!=null) {
				
				index=current.getLink();
				indexn=currentn.getLink();
				while(index!=null) {
					
					String k = current.getData().toString();
					String l = index.getData().toString();
					if( Integer.parseInt(k)  < Integer.parseInt(l) ) {
						// program swap two item in order to obey an order
						tempObj=current.getData();
						current.setData( index.getData() );
						index.setData(tempObj);
						
						// names also need to swap.
						tempNameObj = currentn.getData();
						currentn.setData( indexn.getData() );
						indexn.setData(tempNameObj);
					}
					
					index = index.getLink();
					indexn=indexn.getLink();
				}
				
				current= current.getLink();
				currentn=currentn.getLink();
			}
			
			
		}
	}
	
	
	void deleteOneItem(Object dataToDelete ) {
		if(head==null) {
			System.out.println("Linked list is emtyp");
		}else {
			while( (Integer)head.getData() == (Integer)dataToDelete ) {
				head=head.getLink();
				return;
			}
			Node temp = head.getLink();
			Node previous =head;
			while(temp!=null) {
				if( (Integer)temp.getData() == (Integer)dataToDelete ) {
					previous.setLink( temp.getLink() );
					temp=previous;
					return;
				}
				
				previous = temp;
				temp=temp.getLink();
			}
		}
	}
	
	void delete(Object dataToDelete ) {
		if(head==null) {
			
		}else {
			while( (Integer)head.getData() == (Integer)dataToDelete ) {
				head=head.getLink();
			}
			Node temp = head;
			Node previous =null;
			while(temp!=null) {
				if( (Integer)temp.getData() == (Integer)dataToDelete ) {
					previous.setLink( temp.getLink() );
					temp=previous;
				}
				
				previous = temp;
				temp=temp.getLink();
			}
		}
	}
	
	
	void addBackward(Object dataToAdd) {
		// singleLinkedList ime sondan eleman ekler sürekli.
		if(head == null) {
			Node newnode = new Node(dataToAdd);
			head= newnode;
		}
		else {
			Node temp = head;
			while(temp.getLink() != null) {
				temp = temp.getLink();
			}
			Node newnode = new Node(dataToAdd); 
			temp.setLink(newnode);
		}
	}
	
	
	void display() {
		if(head ==null) {
			System.out.println("     ");
		}else {
			
			Node temp = head;
			while(temp!=null) {
				System.out.print(temp.getData() + " ");
				temp=temp.getLink();
			}
		}
	}
	
	void displayNames() {
		
		if(head ==null) {
			System.out.println("     ");
		}else {
			System.out.println("\n- ->");
			Node temp = head;
			int count=0;
			while(temp!=null) {
				System.out.print(temp.getData() + "    ");
				temp=temp.getLink();
				count++;
				if(count==10) {
					return;
				}
			}
		}
	}
	
	void displayScores() {
		if(head ==null) {
			System.out.println("     ");
		}else {
			System.out.println("\n- ->");
			Node temp = head;
			int count=0;
			while(temp!=null) {
				System.out.print(temp.getData() + "     ");
				temp=temp.getLink();
				count++;
				if(count==10) {
					return;
				}
			}
		}
	}
	
	int size() {
		int count=0;
		if(head==null) {
			System.out.println("Linked list is emtyp");
		}else {
			Node temp = head;
			while(temp!=null) {
				count++;
				temp=temp.getLink();
			}
		}
		return count;
	}
	
	int howMany(Object item) {
		int counter=0;
		Node temp = head;
		while(temp!=null) {
			
			if(temp.getData()==item) {
				counter++;
			}
			if(counter==4) {
				return counter;
			}
			temp=temp.getLink();
		}
		return counter;
	}
	
	
}
