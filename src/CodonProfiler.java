import java.util.*;

public class CodonProfiler {
	
	/**
	 * Count how many times each codon in an array of codons occurs
	 * in a strand of DNA. Return int[] such that int[k] is number
	 * of occurrences of codons[k] in strand. Strand codons can start
	 * at all valid indexes that are multiples of 3: 0, 3, 6, 9, 12, ...
	 * @param strand is DNA to be analyzed for codon occurrences.
	 * @param codons is an array of strings, each has three characters
	 * @return int[] such that int[k] is number of occurrences of codons[k] in 
	 * strand. 
	 */
	public int[] getCodonProfile(IDnaStrand strand, String[] codons) {
//		HashMap<String,Integer> map = new HashMap<>();
//		for (int i = 0 ; i < codons.length ; i++) {
//			int start = 0;
//			map.put(codons[i], 0);
//			while (strand.toString().indexOf(codons[i], start) >= 0 && strand.toString().indexOf(codons[i], start)%3 == 0) {
//				map.put(codons[i], map.get(codons[i]) + 1);
//				start = strand.toString().indexOf(codons[i], start) + codons[i].length();
//			}
//		}
//		int[] ret = new int[codons.length];
//		for (int i = 0; i < codons.length ; i++) {
//			ret[i] = map.get(codons[i]);
//		}
//		System.out.print(map.values());
//		return ret;
		
//		HashMap<String,Integer> map = new HashMap<>();
//		int[] ret = new int[codons.length];
//				
//		for(int k=0; k < codons.length; k++) {
//			Iterator<Character> iter = strand.iterator();
//			while (iter.hasNext()) {
//				char a = iter.next();
//				char b = 'z';           // not part of any real codon
//				char c = 'z';
//				if (iter.hasNext()) {
//					b = iter.next();
//				}
//				if (iter.hasNext()) {
//					c = iter.next();
//				}
//				String cod = ""+a+b+c;
//				if (cod.equals(codons[k])) {
//					ret[k] += 1;
//				}
//			}
//		}
//		return ret;
		HashMap<String,Integer> map = new HashMap<>();
		int[] ret = new int[codons.length];
		
		for (int i = 0 ; i < strand.toString().length()-2; i= i+3) {
			if (! map.containsKey(strand.toString().substring(i, i+3))) {
				map.put(strand.toString().substring(i, i+3), 0);
			}
			map.put(strand.toString().substring(i, i+3), map.get(strand.toString().substring(i, i+3)) + 1);
		}
		for (int i = 0; i < codons.length ; i++) {
			if (map.containsKey(codons[i])) {
				ret[i] = map.get(codons[i]);
			}
			else {ret[i] = 0;}
		}
		return ret;
	}
//	public static void main(String[] args) {
//		LinkStrand bla = new LinkStrand("cgacgacgatagtagtagtagcgacgacgacga");
//		String[] codons = {"cga", "gat","tag"};
//		int[] Ans = getCodonProfile(bla ,codons);
//		System.out.print(Ans.toString());
//	}
}
