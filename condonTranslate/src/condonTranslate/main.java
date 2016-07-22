package condonTranslate;

import java.util.Arrays;
import java.util.Scanner;

public class main {
	public static String dnarnaSeq;
	public static int i, j, k, l, m;
	private static String dnaSeq;

	static char[] changernaSequence(char rnaSeq[]) {// 碱基互补配对原则函数
		int k;
		for (k = 0; k < rnaSeq.length; k++) {
			switch (rnaSeq[k]) {
			case 'A':
				rnaSeq[k] = 'T';
				break;
			case 'T':
				rnaSeq[k] = 'A';
				break;
			case 'G':
				rnaSeq[k] = 'C';
				break;
			case 'C':
				rnaSeq[k] = 'G';
				break;
			case 'a':
				rnaSeq[k] = 'T';
				break;
			case 't':
				rnaSeq[k] = 'A';
				break;
			case 'g':
				rnaSeq[k] = 'C';
				break;
			case 'c':
				rnaSeq[k] = 'G';
				break;
			case 'Y':
				rnaSeq[k] = 'R';
				break;
			case 'R':
				rnaSeq[k] = 'Y';
				break;
			case 'W':
				rnaSeq[k] = 'S';
				break;
			case 'S':
				rnaSeq[k] = 'W';
				break;
			case 'M':
				rnaSeq[k] = 'K';
				break;
			case 'K':
				rnaSeq[k] = 'M';
				break;
			case 'y':
				rnaSeq[k] = 'R';
				break;
			case 'r':
				rnaSeq[k] = 'Y';
				break;
			case 'w':
				rnaSeq[k] = 'S';
				break;
			case 's':
				rnaSeq[k] = 'W';
				break;
			case 'm':
				rnaSeq[k] = 'K';
				break;
			case 'k':
				rnaSeq[k] = 'M';
				break;
			default:
				// rnaSeq[k] = rnaSeq[k];
				break;
			}
		}
		return rnaSeq;
	}//changernaSequence

	static char condonTranslate(char codon[]) {//对互补配对之后的序列进行翻译
		if (codon[0] == 'T' || codon[0] == 'U') {
			if (codon[1] == 'T' || codon[1] == 'U') {
				if (codon[2] == 'A' || codon[2] == 'G')
					// Leu
					return 'L';
				else
				// Phe
				if (codon[2] == 'C' || codon[2] == 'T' || codon[2] == 'U')
					return 'F';
			}
			if (codon[1] == 'C')
				// Ser
				return 'S';
			if (codon[1] == 'A') {
				if (codon[2] == 'A' || codon[2] == 'G')
					// Stop
					return '.';
				else
				// Tyr
				if (codon[2] == 'C' || codon[2] == 'T' || codon[2] == 'U')
					return 'Y';
			}

			if (codon[1] == 'G') {
				if (codon[2] == 'U' || codon[2] == 'T' || codon[2] == 'C')
					// Cys
					return 'C';
				else {
					if (codon[2] == 'A')
						// Stop
						return '.';
					else
					// Trp
					if (codon[2] == 'G')
						return 'W';
				}
			}
		}

		if (codon[0] == 'C') {
			if (codon[1] == 'T' || codon[1] == 'U')
				// Leu
				return 'L';
			if (codon[1] == 'C')
				// Pro
				return 'P';
			if (codon[1] == 'A') {
				if (codon[2] == 'A' || codon[2] == 'G')
					// Gln
					return 'Q';
				else
				// His
				if (codon[2] == 'U' || codon[2] == 'T' || codon[2] == 'C')
					return 'H';
			}
			if (codon[1] == 'G')
				// Arg
				return 'R';
		}

		if (codon[0] == 'A') {
			if (codon[1] == 'T' || codon[1] == 'U') {
				if (codon[2] == 'G')
					// Met
					return 'M';
				else
				// Ile
				if (codon[2] == 'U' || codon[2] == 'T' || codon[2] == 'C'
						|| codon[2] == 'A')
					return 'I';
			}
			if (codon[1] == 'C')
				// Thr
				return 'T';
			if (codon[1] == 'A') {
				if (codon[2] == 'A' || codon[2] == 'G')
					// Lys
					return 'K';
				else
				// Asn
				if (codon[2] == 'U' || codon[2] == 'T' || codon[2] == 'C')
					return 'N';
			}

			if (codon[1] == 'G') {
				if (codon[2] == 'A' || codon[2] == 'G')
					// Arg
					return 'R';
				else
				// Ser
				if (codon[2] == 'U' || codon[2] == 'T' || codon[2] == 'C')
					return 'S';
			}

		}

		if (codon[0] == 'G') {
			if (codon[1] == 'T' || codon[1] == 'U')
				// Val
				return 'V';
			if (codon[1] == 'C')
				// Ala
				return 'A';
			if (codon[1] == 'A') {
				if (codon[2] == 'A' || codon[2] == 'G')
					// Glu
					return 'E';
				else
				// Asp
				if (codon[2] == 'U' || codon[2] == 'T' || codon[2] == 'C')
					return 'D';
			}
			if (codon[1] == 'G')
				// Gly
				return 'G';
		}
		return 0;
	}//condonTranslate

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please input DNA dnaSequence:");
		Scanner in = new Scanner(System.in);
		dnaSeq = in.next();
		char[] arrayrnaSeq = dnaSeq.toCharArray();
		char[] rnaSeq = changernaSequence(arrayrnaSeq);//碱基互补配对原则
		for (i = 0; i <= dnaSeq.length(); i = i + 3) {//将配对后序列分为三个一组，跟据密码子表对其进行翻译
			char[] codon = Arrays.copyOfRange(rnaSeq, i, i + 3);
			char str = condonTranslate(codon);
			// for(char s:codon1){
			// System.out.print(s);
			// }
			System.out.print(str);
		}//for
	}// main
}