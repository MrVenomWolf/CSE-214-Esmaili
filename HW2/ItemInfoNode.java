//Anubrota Majumdar, 114586887, Recitation 30
public class ItemInfoNode {
	ItemInfoNode next;
	ItemInfoNode prev;
	ItemInfo info= new ItemInfo();

	public ItemInfoNode() {

	}

	public void setInfo(ItemInfo info) { //data from insertinfo ()
		this.info=info;
	}

	public ItemInfo getInfo() {
		return info;
	}

	public void setNext(ItemInfoNode next) {
		this.next = null;
	}

	public void setPrev(ItemInfoNode prev) {
		this.prev = null;
	}

	public ItemInfoNode getNext() {
		return next;
	}

	public ItemInfoNode getPrev() {
		return prev;
	}
}
