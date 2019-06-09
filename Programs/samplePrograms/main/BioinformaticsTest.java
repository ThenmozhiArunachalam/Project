package main;

import java.util.Scanner;

public class BioinformaticsTest {

	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		String chromosome, gene;
		int n = s.nextInt();
		for (int i = 0; i < n; i++) {
			chromosome = s.next();
			gene = s.next();
			identifyGenesInChromosome(chromosome, gene);
		}
	}

	private static int getEqualCount(String chromosome, String gene) {
		char chromosomeArray[], geneArray[];
		int chromosomeSize, geneSize;
		chromosomeArray = chromosome.toCharArray();
		geneArray = gene.toCharArray();
		chromosomeSize = chromosomeArray.length;
		geneSize = geneArray.length;
		int count = 0;
		int tempIndex = 0, i, j;

		for (i = 0; i < geneSize; i++) {
			for (j = tempIndex; j < chromosomeSize; j++) {
				if (chromosomeArray[j] == geneArray[i]) {
					count++;
					tempIndex = j + 1;
					break;
				}
			}
		}
		return count;
	}

	private static boolean presentGeneInChromosome(String gene, int geneEqualCount) {
		return geneEqualCount == gene.length();
	}

	private static void identifyGenesInChromosome(String chromosome, String gene) {
		int geneEqualCount = getEqualCount(chromosome, gene);
		String isPresent = (presentGeneInChromosome(gene, geneEqualCount)) ? "YES" : "NO";
		System.out.println(isPresent);
	}
}
