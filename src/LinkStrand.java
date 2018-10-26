
public class LinkStrand implements IDnaStrand {
	
	/**
	 * Creates Node Class
	 * @author brycenrushing
	 *
	 */
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
	
	/**
	 * Constructs a LinkStrand object.
	 */
	public LinkStrand() {
		this("");
	}
	
	/**
	 * Constructs a LinkStrand using method 
	 * initialize with initial node with info s
	 * @param s
	 */
	public LinkStrand(String s) {
		initialize(s);
	}
	
	/**
	 * Initializes the information for the LinkStrand
	 */
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
	
	/**
	 * returns the size of the LinkStrand
	 */
	@Override
	public long size() {
		return mySize;
	}

	/** 
	 * Converts the LinkStrand to a string
	 */
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

	/**
	 * Returns a new LinkStrand
	 * @param source is the info in the node
	 */
	@Override
	public IDnaStrand getInstance(String source) {
		return new LinkStrand(source);
	}

	/**
	 * Appends a new Node to the ListStrand
	 * @param dna is the info in the appended node
	 */
	@Override
	public IDnaStrand append(String dna) {
		myLast.next = new Node(dna);
		myLast = myLast.next;
		mySize = mySize + dna.length();
		myAppends++;
		return this;
	}

	/**
	 * Reverses the nodes and info in the nodes of the LinkStrand
	 */
	@Override
	public IDnaStrand reverse() {
		LinkStrand ss = new LinkStrand();
		Node curr = this.myFirst;
		Node prev = null;
		while (curr != null) {
			StringBuilder info = new StringBuilder(curr.info);
			StringBuilder reverseInfo = info.reverse();
			ss.myFirst = new Node(reverseInfo.toString());
			ss.myFirst.next = prev;
			prev = ss.myFirst;
			curr = curr.next;
		}
		ss.mySize = this.mySize;
		return ss;
	}

	/**
	 * Returns the number of appends the LinkStrand has undergone
	 */
	@Override
	public int getAppendCount() {
		return myAppends;
	}

	/**
	 * Finds the character at the index
	 * @param index is the index of the character
	 */
	@Override
	 public char charAt(int index) {
		if (index > this.mySize || index < 0) {
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
			if (myCurrent == null) {
				throw new IndexOutOfBoundsException();
			}
			if (myLocalIndex >= myCurrent.info.length()) {
				myLocalIndex = 0;
				myCurrent = myCurrent.next;
				}
			}
		myIndex = index;
		return myCurrent.info.charAt(myLocalIndex);
		}
}

