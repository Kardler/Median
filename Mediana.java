package source;

import java.util.Scanner;

public class Mediana {
	
	public static void sort(int[] arr, int r){
		
		int size=arr.length;
		int a; // переменная для перемещения двух элементов массива
        int count=1;//счетчик перестановок
        for(int i=r+2; i<size-2; i++){
        	count=0;
        	for (int j=size-1;j>i; j-- ){
        		
        		if(arr[j]<arr[j-1]){
        			count++;
        			count++;
        			a = arr[j];
        			arr[j]=arr[j-1];
        			arr[j-1]=a;	
        		}	
        	}
    		if(count ==0 ) {break;}
        }
	}
	
	public static int[] intMass(String s){// разбив строки на массив чисел типа int
		String[] numbers = s.split(" ");
		int[] a = new int[numbers.length];
		for(int i=0; i<numbers.length;i++){
			a[i]=Integer.parseInt(numbers[i]);
		}
		return a;
	}
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Введите первый массив: ");
		int[] a = intMass(in.nextLine());
		System.out.println("Введите второй массив: ");
		int[] b = intMass(in.nextLine());
		if(b[0]>=a[a.length-1]){
			System.out.println("Медиана равна "+(double)(a[a.length-1]+b[0])/2);}//При соединении осортированных массивов ответ можно сказать сразу
		else{
		int size = a.length;
		int[] res = new int[size*2];
		int r=0;//индекс за которым будет вставлен второй массив
		for (int i=0; i<size-1; i++){
			if(b[0]>=a[i]&&b[0]<a[i+1]){
				r=i;
				break;
			}
		}
		for(int i=0; i<=r; i++){
			res[i]=a[i];
		}
		for(int i=r+1, j=0; j<size; i++, j++){
			res[i]=b[j];
		}
		for(int i=r+size+1, j=r+1; i<2*size; i++, j++){
			res[i]=a[j];
		}
		sort(res, r);
		System.out.println("Медиана равна "+(double)(res[size-1]+res[size])/2);
		in.close();
		}
		
	}
}
