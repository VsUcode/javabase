
package com.sort;

/**
 * Created by VSU on 2017/09/11.
 */



import java.util.Arrays;

/*
 *排序：8大排序算法(内部排序)
 * 插入排序：直接插入排序 希尔排序
 * 选择排序：简单选择排序 堆排序
 * 交换排序：冒泡排序 快速排序
 * 归并排序
 * 基数排序
 *
 *
 * 当n较大，则应采用时间复杂度为O(nlog2n)的排序方法：快速排序、堆排序或归并排序序。
 * 快速排序：是目前基于比较的内部排序中被认为是最好的方法，当待排序的关键字是随机分布时，快速排序的平均时间最短；
 */


/***************************************************************************/
/*1.插入排序—直接插入排序(Straight Insertion Sort)
 * 基本思想:
 * 将一个记录插入到已排序好的有序表中，从而得到一个新，记录数增1的有序表。
 *   即：先将序列的第1个记录看成是一个有序的子序列，然后从第2个记录逐个进行插入，直至整个序列有序为止。
 * 要点：设立哨兵，作为临时存储和判断数组边界之用。
 * 如果碰见一个和插入元素相等的，那么插入元素把想插入的元素放在相等元素的后面。
 *   所以，相等元素的前后顺序没有改变，从原无序序列出去的顺序就是排好序后的顺序，所以插入排序是稳定的。
 */

//算法实现

public class Sort {
    public static void main(String[] args){

        int arr[] = {3, 1, 5, 7, 2, 4, 9, 6, 10, 8};
        System.out.println("排序前:");
        System.out.println(Arrays.toString(arr));
        insertSort(arr);
        System.out.println("排序后:");
        System.out.println(Arrays.toString(arr));
    }

    private static void insertSort(int[] a){

        for (int i=1; i<a.length; i++){//从头部第一个当做已经排好序的，把后面的一个一个的插到已经排好的列表中去。
            if (a[i] < a[i-1]){
                int j;
                int x = a[i];//x为待插入元素
                a[i] = a[i-1];
                for (j = i-1; j>=0 && x <a[j]; j--){//通过循环，逐个后移一位找到要插入的位置。
                    a[j+1] = a[j];
                }
                a[j+1] = x;//插入
            }
        }
    }
}


/* 效率：
 *时间复杂度：O（n^2）.
 *其他的插入排序有二分插入排序，2-路插入排序。
 *
 */


/*************************************************************************/
/*3. 选择排序—简单选择排序（Simple Selection Sort）
 *基本思想：
 * 在要排序的一组数中，选出最小（或者最大）的一个数与第1个位置的数交换；然后在剩下的数当中再找最小（或者最大）的与第2个位置的数交换，
 *   依次类推，直到第n-1个元素（倒数第二个数）和第n个元素（最后一个数）比较为止。
 */

//算法实现

public class Sort {
    public static void main(String[] args) {
        int arr[] = {3, 1, 5, 7, 2, 4, 9, 6, 10, 8};
        System.out.println("排序前:");
        System.out.println(Arrays.toString(arr));
        selectSort(arr);
        System.out.println("排序后:");
        System.out.println(Arrays.toString(arr));
    }

    private static void selectSort(int[] a){
        for(int i=0;i<a.length;i++){
            int k=i;//k存放最小值下标。每次循环最小值下标+1
            for(int j=i+1;j<a.length;j++){//找到最小值下标
                if(a[k]>a[j])
                    k=j;
            }
            swap(a,k,i);//把最小值放到它该放的位置上
        }
    }

    private static void swap(int[] arr, int k, int i){
        if (i == k) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[k];
        arr[k] = temp;
    }
}


/*简单选择排序的改进——二元选择排序
 *简单选择排序，每趟循环只能确定一个元素排序后的定位。
 * 我们可以考虑改进为每趟循环确定两个元素（当前趟最大和最小记录）的位置,从而减少排序所需的循环次数。
 * 改进后对n(n>=11)个数据进行排序，最多只需进行[n/2]趟循环即可。
 */
                                     /************      待修改        **********************/
public class Sort {
    public static void main(String[] args) {
        int arr[] = {3, 1, 5, 7, 2, 4, 9, 6, 10, 8};
        System.out.println("排序前:");
        System.out.println(Arrays.toString(arr));
        selectSort(arr, arr.length);
        System.out.println("排序后:");
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] a, int n){

        int i ,j , min ,max, tmp;
        for (i=0 ;i <n/2 ;i++) {
            // 做不超过n/2趟选择排序
            min = i; max = i ; //分别记录最大和最小关键字记录位置
            for (j= i+1; j<= n-i-1; j++) {
                if (a[j] > a[max]) {
                    max = j ; continue ;
                }
                if (a[j]< a[min]) {
                    min = j ;
                }
            }
            //该交换操作还可分情况讨论以提高效率
            //i == max
            if (max != i){
                tmp = a[i]; a[i] = a[min];a[min] = tmp;
                tmp = a[n-i-1]; a[n-i-1] = a[max]; a[max] = tmp;
            }else{
                tmp = a[i]; a[i] = a[min];a[min] = tmp;
                tmp = a[n-i-1]; a[n-i-1] = a[min]; a[min] = tmp;
            }

            System.out.println(Arrays.toString(a));
        }
    }
}





/**************************************************************************/
/*5. 交换排序—冒泡排序（Bubble Sort）
 *基本思想：
 * 在要排序的一组数中，对当前还未排好序的范围内的全部数，自上而下对相邻的两个数依次进行比较和调整，
 * 让较大的数往下沉，较小的往上冒。即：每当两相邻的数比较后发现它们的排序与排序要求相反时，就将它们互换。
 */


public class Sort {
    public static void main(String[] args) {
        int arr[] = {3, 5, 7, 2, 4, 9, 1, 6, 10, 8};
        System.out.println("排序前:");
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr, arr.length);
        System.out.println("排序后:");
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int a[], int n) {
        for (int i = 0; i < n - 1; ++i) {
            for (int j = 0; j < n - i - 1; ++j) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
    }
}




/*冒泡排序算法的改进
 *对冒泡排序常见的改进方法是加入一标志性变量exchange，用于标志某一趟排序过程中是否有数据交换，
 * 如果进行某一趟排序时并没有进行数据交换，则说明数据已经按要求排列好，可立即结束排序，避免不必要的比较过程。
 */

/* 1设置一标志性变量pos,用于记录每趟排序中最后一次进行交换的位置。由于pos位置之后的记录均已交换到位,故在进行下一趟排序时只要扫描到pos位置即可。
 */
/*
public class Sort {
    public static void main(String[] args) {
        int arr[] = {3, 5, 7, 2, 4, 9, 1, 6, 10, 8};
        System.out.println("排序前:");
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr, arr.length);
        System.out.println("排序后:");
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int r[], int n) {
        int i = n - 1;  //初始时,最后位置保持不变
        while (i > 0) {
            int pos = 0; //每趟开始时,无记录交换
            for (int j = 0; j < i; j++)
                if (r[j] > r[j + 1]) {
                    pos = j; //记录交换的位置
                    int tmp = r[j];
                    r[j] = r[j + 1];
                    r[j + 1] = tmp;
                }
            i = pos; //为下一趟排序作准备
        }
    }
}


/* 2 传统冒泡排序中每一趟排序操作只能找到一个最大值或最小值,我们考虑利用在每趟排序中进行正向和反向两遍冒泡的方法一次可以得到两个最终值(最大者和最小者) ,
  *从而使排序趟数几乎减少了一半。
*/

/*
public class Sort {
    public static void main(String[] args) {
        int arr[] = {3, 5, 7, 2, 4, 9, 1, 6, 10, 8};
        System.out.println("排序前:");
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr, arr.length);
        System.out.println("排序后:");
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int r[], int n) {
        int low = 0;
        int high = n - 1; //设置变量的初始值
        int tmp, j;
        while (low < high) {
            for (j = low; j < high; ++j) //正向冒泡,找到最大者
                if (r[j] > r[j + 1]) {
                    tmp = r[j];
                    r[j] = r[j + 1];
                    r[j + 1] = tmp;
                }
            --high;                 //修改high值, 前移一位
            for (j = high; j > low; --j) //反向冒泡,找到最小者
                if (r[j] < r[j - 1]) {
                    tmp = r[j];
                    r[j] = r[j - 1];
                    r[j - 1] = tmp;
                }
            ++low;                  //修改low值,后移一位
        }
    }
}



/******************************************************************/
/*6. 交换排序—快速排序（Quick Sort）
 *基本思想：
 * 选择一个基准元素,通常选择第一个元素或者最后一个元素,
 * 通过一趟排序将待排序的记录分割成独立的两部分，其中一部分记录的元素值均比基准元素值小。另一部分记录的 元素值比基准值大。
 * 此时基准元素在其排好序后的正确位置
 * 然后分别对这两部分记录用同样的方法继续进行排序，直到整个序列有序。
 */


public class Sort {
    public static void main(String[] args) {
        int arr[] = {3, 5, 7, 2, 4, 9, 1, 6, 10, 8};
        System.out.println("排序前:");
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length-1);
        System.out.println("排序后:");
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] a,int low, int high) {
        if(low<high){ //如果不加这个判断递归会无法退出导致堆栈溢出异常
            int middle=getMiddle(a,low,high);
            quickSort(a,  0,  middle-1);          //递归对低子表递归排序
            quickSort(a,   middle + 1, high);        //递归对高子表递归排序
        }
    }
    public static int getMiddle(int[] a, int low, int high){

        int key = a[low];//基准元素，排序中会空出来一个位置
        while(low<high){
            while(low<high && a[high]>=key){//从high开始找比基准小的，与low换位置
                high--;
            }
            a[low]=a[high];
            while(low<high && a[low]<=key){//从low开始找比基准大,放到之前high空出来的位置上
                low++;
            }
            a[high]=a[low];
        }
        a[low]=key;//此时low=high 是基准元素的位置，也是空出来的那个位置
        return low;

    }

}


/*分析：
 *快速排序是通常被认为在同数量级（O(nlog2n)）的排序方法中平均性能最好的。
 * 但若初始序列按关键码有序或基本有序时，快排序反而蜕化为冒泡排序。为改进之，通常以“三者取中法”来选取基准记录，
 * 即将排序区间的两个端点与中点三个记录关键码居中的调整为支点记录。快速排序是一个不稳定的排序方法。
 */


/*快速排序的改进：
 *在本改进算法中,只对长度大于k的子序列递归调用快速排序,让原序列基本有序，然后再对整个基本有序序列用插入排序算法排序。
 *实践证明，改进后的算法时间复杂度有所降低，且当k取值为 8 左右时,改进算法的性能最佳。
 */

/************      待修改        **********************
public class Sort {
    public static void main(String[] args) {
        int arr[] = {3, 5, 7, 2, 4, 9, 1, 6, 10, 8};
        System.out.println("排序前:");
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 9, 4);
        System.out.println("排序后:");
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int r[], int n, int k) {
        qsortImprove(r, 0, n, k);//先调用改进算法Qsort使之基本有序

        //再用插入排序对基本有序序列排序
        for (int i = 1; i <= n; i++) {
            int tmp = r[i];
            int j = i - 1;
            while (tmp < r[j]) {
                r[j + 1] = r[j];
                j = j - 1;
            }
            r[j + 1] = tmp;
        }

    }

    public static void qsortImprove(int r[], int low, int high, int k) {
        if (high - low > k) { //长度大于k时递归, k为指定的数
            int pivot = partition(r, low, high); // 调用的Partition算法保持不变
            qsortImprove(r, low, pivot - 1, k);
            qsortImprove(r, pivot + 1, high, k);
        }
    }


    public static int partition(int a[], int low, int high) {
        int privotKey = a[low];                 //基准元素
        while (low < high) {                   //从表的两端交替地向中间扫描
            while (low < high && a[high] >= privotKey) --high; //从high 所指位置向前搜索，至多到low+1 位置。将比基准元素小的交换到低端
            swap( a[low], a[high]);
            while (low < high && a[low] <= privotKey) ++low;
            swap(  a[low], a[high]);
        }
        return low;
    }

    public static void swap(int a, int b) {
        int tmp = a;
        a = b;
        b = tmp;
    }

}
*/




/**************************************************************************/
/* 2. 插入排序—希尔排序（Shell`s Sort）
 *希尔排序是1959 年由D.L.Shell 提出来的，相对直接排序有较大的改进。希尔排序又叫缩小增量排序
 * 基本思想：先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，待整个序列中的记录“基本有序”时，再对全体记录进行依次直接插入排序。
 * 操作方法：
 *  选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
 *  按增量序列个数k，对序列进行k 趟排序；
 *  每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
 */

/*算法实现：
 *我们简单处理增量序列：增量序列d = {n/2 ,n/4, n/8 .....1} n为要排序数的个数
 * 即：先将要排序的一组记录按某个增量d（n/2,n为要排序数的个数）分成若干组子序列，
 *   每组中记录的下标相差d.对每组中全部元素进行直接插入排序，
 *   然后再用一个较小的增量（d/2）对它进行分组，在每组中再进行直接插入排序。
 */

public class Sort {
    public static void main(String[] args) {
        int arr[] = {3, 1, 5, 7, 2, 4, 9, 6, 10, 8};
        System.out.println("排序前:");
        System.out.println(Arrays.toString(arr));
        shellSort(arr);
        System.out.println("排序后:");
        System.out.println(Arrays.toString(arr));
    }

    private static void shellSort(int[] a){
        int dk = a.length / 2;
        while (dk >= 1){
            shellInsertSort(a, dk);
            dk = dk/2;
        }
    }

    private static void shellInsertSort(int[] a, int dk){//类似插入排序，只是插入排序增量是1，这里增量是dk,把1换成dk就可以了
        for(int i=dk;i<a.length;i++){
            if(a[i]<a[i-dk]){
                int j;
                int x=a[i];//x为待插入元素
                a[i]=a[i-dk];
                for(j=i-dk;  j>=0 && x<a[j];j=j-dk){//通过循环，逐个后移一位找到要插入的位置。
                    a[j+dk]=a[j];
                }
                a[j+dk]=x;//插入
            }

        }
    }

}

/*希尔排序时效分析很难，关键码的比较次数与记录移动次数依赖于增量因子序列d的选取，特定情况下可以准确估算出关键码的比较次数和记录的移动次数。
 *目前还没有人给出选取最好的增量因子序列的方法。增量因子序列可以有各种取法，有取奇数的，也有取质数的，
 * 但需要注意：增量因子中除1 外没有公因子，且最后一个增量因子必须为1。希尔排序方法是一个不稳定的排序方法。
 */





/**************************************************************************/
/*4. 选择排序—堆排序（Heap Sort）
 *堆排序是一种树形选择排序，是对直接选择排序的有效改进。
 * 由堆的定义可以看出，堆顶元素（即第一个元素）必为最小项（小顶堆）。
 */

/**********************************/






/************************************************************/
/*7. 归并排序（Merge Sort）
 *
 */

/**************************************







 *****************************************************************/
/*8. 桶排序/基数排序(Radix Sort)
 *
 */

/**************************************/
