package com.qS;

// Функция быстрой сортировки
class Sortfast {
    static void quickSort(int[] numbers,int left,int right) {
        int l_hold = left;          //левая граница
        int r_hold = right;         // правая граница
        int pivot = numbers[left];  // разрешающий элемент
        while (left < right) {      // пока границы не сомкнутся

            while ((numbers[right]>=pivot)&&(left<right))
                right--;    // сдвигаем правую границу пока элемент [right] больше [pivot]
            if (left != right) {    // если границы не сомкнулись
                numbers[left++] = numbers[right];   // перемещаем элемент [right] на место разрешающего
//                numbers[left] = numbers[right];   // перемещаем элемент [right] на место разрешающего
//                left++;   // сдвигаем левую границу вправо
            }
            while ((numbers[left]<=pivot)&&(left<right))
                left++; // сдвигаем левую границу пока элемент [left] меньше [pivot]
            if (left != right) {    // если границы не сомкнулись
                numbers[right--] = numbers[left];
//                numbers[right] = numbers[left];   // перемещаем элемент [left] на место [right]
//                right--;  // перемещаем элемент [left] на место [right]
            }
        }
        numbers[left] = pivot;  // ставим разрешающий элемент на место
        pivot = left;
        left = l_hold;
        right = r_hold;
        if (left < pivot) // Рекурсивно вызываем сортировку для левой и правой части массива
            quickSort(numbers, left, pivot - 1);
        if (right > pivot)
            quickSort(numbers, pivot + 1, right);
    }

    public static void main(String[] args) {
        int[] a=new int[10];
        // Заполнение массива случайными числами
        for (int i = 0; i<10; i++)
            a[i] = (int)(Math.random() * 20 - 10);

        // Вывод элементов массива до сортировки
        for (int i = 0; i<10; i++)
            printf("%d ", a[i]);
        printf("\n",0);
        quickSort(a, 0, 9); // вызов функции сортировки
        // Вывод элементов массива после сортировки
        for (int i = 0; i<10; i++)
            printf("%d ", a[i]);
        printf("\n",0);
//        getchar();
//        return 0;
    }

    static void  printf(String s, int x) {
        System.out.printf(s,x);
    }
}
