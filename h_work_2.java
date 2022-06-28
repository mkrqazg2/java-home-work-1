import java.util.Scanner;

//Реализовать алгоритм сортировки слиянием
import java.util.Arrays;

public class h_work_2 {
    public static void main(String[] args) {

        int[] array1 = { 17, 0, -3, 33, 6, 9, 8, -4, 2, -32, 34, 15 };
        int[] result = mergesort(array1);
        System.out.println(Arrays.toString(result));
    }
    public static int[] mergesort(int[] array1) {
        int[] buffer1 = Arrays.copyOf(array1, array1.length);
        int[] buffer2 = new int[array1.length];
        int[] result = mergesortInner(buffer1, buffer2, 0, array1.length);
        return result;
    }
    
    public static int[] mergesortInner(int[] buffer1, int[] buffer2,
            int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return buffer1;
        }
        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergesortInner(buffer1, buffer2, startIndex, middle);
        int[] sorted2 = mergesortInner(buffer1, buffer2, middle, endIndex);

        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sorted1 == buffer1 ? buffer2 : buffer1;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1] < sorted2[index2]
                    ? sorted1[index1++] : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }
}

// ЗАДАНИЕ 2. Реализовать алгоритм пирамидальной сортировки (HeapSort)

// public class h_work_2
// {
//     public void sort(int arr[])
//     {
//         int n = arr.length;

//         for (int i = n / 2 - 1; i >= 0; i--)
//             heapify(arr, n, i);
  
//         for (int i=n-1; i>=0; i--)
//         {
//             int temp = arr[0];
//             arr[0] = arr[i];
//             arr[i] = temp;

//             heapify(arr, i, 0);
//         }
//     }

//      void heapify(int arr[], int n, int i)
//     {
//         int largest = i; // Инициализируем наибольший элемент как корень
//         int l = 2*i + 1; // левый = 2*i + 1
//         int r = 2*i + 2; // правый = 2*i + 2

//         if (l < n && arr[l] > arr[largest])
//             largest = l;

//         if (r < n && arr[r] > arr[largest])
//             largest = r;

//         if (largest != i)
//         {
//             int swap = arr[i];
//             arr[i] = arr[largest];
//             arr[largest] = swap;

//             heapify(arr, n, largest);
//         }
//     }

//     static void printArray(int arr[])
//     {
//         int n = arr.length;
//         for (int i=0; i<n; ++i)
//             System.out.print(arr[i]+" ");
//         System.out.println();
//     }

//     public static void main(String args[])
//     {
//         int arr[] = {-86, 78, 56, 12, 1, -5, 15};
//         int n = arr.length;

//         h_work_2 ob = new h_work_2();
//         ob.sort(arr);

//         System.out.println("Отсортированный массив :");
//         printArray(arr);
//     }
// }
