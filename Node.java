
public class Node {
	private Object data;
	private Node link;
	
	Node(Object dataToAdd){
		data = dataToAdd;
		link = null;
	}
	
	Object getData() {
		return data;
	}
	void setData(Object data) {
		this.data=data;
	}
	Node getLink() {
		return link;
	}
	void setLink(Node link) {
		this.link=link;
	}
	
}
