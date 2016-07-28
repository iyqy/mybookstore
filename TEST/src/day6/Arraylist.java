package day6;

public class Arraylist {
	// 任务1：创建两个int类型的数组array1和array2，使用{}将array1初始化为8个质数：2，3，5，7，11，13，17和19，显示array1的内容。
	// 任务2：赋值array2=array1，修改array2中的偶索引元素，使其等于索引值，显示array1中的内容，看看有什么变化。
	public Arraylist() {

	}

	public static void main(String[] args) {
		int[] array1 = { 2, 3, 5, 7, 11, 13, 17, 19 };
		int[] array2 = array1;
		for (int i = 2; i < 8; i = i + 2) {
			array2[i] = i;
		}
		for (int s : array1) {
			System.out.print(s+" ");
		}

	}

}
