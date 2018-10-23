
public class LinkStrand implements IDnaStrand {
	
	private class Node{
		String info;
	   	Node next;
	   	public Node(String s) {
	      	info = s;
	      	next = null;
	   	}
	}
	
	private Node myFirst,myLast;
	private long mySize;
	private int myAppends;
	private int myIndex;
	private int myLocalIndex;
	private Node myCurrent;
	
	public LinkStrand() {
		this("");
	}
	
	public LinkStrand(String s) {
		initialize(s);
	}
	
	@Override
	public void initialize(String source) {
		mySize = source.length();
		myAppends = 0;
		myFirst = new Node(source);
		myLast = myFirst;
		myIndex = 0;
		myLocalIndex = 0;
		myCurrent = myFirst;
	}
	
	@Override
	public long size() {
		return mySize;
	}

	@Override
	public String toString() {
		Node list = myFirst;
		StringBuilder dnaString = new StringBuilder();
		while (list != null) {
			dnaString.append(list.info);
			list = list.next;
		}
		return dnaString.toString();
	}

	@Override
	public IDnaStrand getInstance(String source) {
		return new LinkStrand(source);
	}

	@Override
	public IDnaStrand append(String dna) {
		myLast.next = new Node(dna);
		myLast = myLast.next;
		mySize = mySize + dna.length();
		myAppends++;
		return this;
	}

	@Override
	public IDnaStrand reverse() {
		LinkStrand ss = new LinkStrand();
		Node curr = myFirst;
		Node next = new Node(null);
		Node prev = new Node(null);
		while (curr != null) {
			StringBuilder currInfo = new StringBuilder(curr.info);
			currInfo.reverse();
			curr.info = currInfo.toString();
			ss.append(curr.info);
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return ss;
	}

	@Override
	public int getAppendCount() {
		return myAppends;
	}

	@Override
	 public char charAt(int index) {
		if (this.size() < index) {
			throw new IndexOutOfBoundsException();
		}
		if (index < myIndex) {
			myIndex = 0;
			myCurrent = myFirst;
			myLocalIndex = 0;
		}
		while (myIndex != index) {
			myIndex++;
			myLocalIndex++;
			if (myLocalIndex >= myCurrent.info.length()) {
				myLocalIndex = 0;
				myCurrent = myCurrent.next;
				}
			}
		myIndex = index;
		return myCurrent.info.charAt(myLocalIndex);
		}
}

