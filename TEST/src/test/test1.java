package test;

import java.util.Arrays;
import java.util.Scanner;

public class test1 {
		static void sort(int b[]){
			int m;
			int n = 0;
			for(int i = 0;i<b.length;i++){
				m=b[i];
				for(int j = i+1;j<b.length;j++){
					if(m>b[j]){
						m=b[j];
						n=j;
					}
					b[n] = b[i];
					b[i] = m;
				}
				
			}
	
		}
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String data = sc.nextLine();
//		String result = Md5Utils.encrypt(data);
//		System.out.println(result);
		
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String a[] = s.split(" ");
		int b[] = new int[a.length];
		for(int i = 0;i<b.length;i++){
			b[i] = Integer.parseInt(a[i]);
		}
		int p = 6;
		sort(b);

		for(int m:b){
			System.out.print(m);			
		}

		

	}

}
