public class 15_ Sorting{
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }

    // ****************BUBBLE
    // SORT******************************************************** */
    public static void BubbleSort(int arr[]) {
        for (int i = 0; i < n - 1; i++) {
            boolean swap = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (swap == false) {
                break;
            }
        }
    }

    // ****************INSERTION
    // SORT******************************************************** */
    public static void InsertionSort(int arr[]) {
        for (int i = 1; i < n - 1; i++) {
            int currEle = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > currEle) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = currEle;
        }
    }

    // ****************SELECTION
    // SORT******************************************************** */
    public static void SelectionSort(int arr[]) {
        for (int i = 0; i < n; i++) {
            int minEle = arr[i];
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < minEle) {
                    minEle = arr[j];
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }

    }

    // ****************MERGE
    // SORT******************************************************** */
    public static void MergeSort(int arr[]){

    public static void MergeSortRecur(int arr[], int start, int end) {
        if (start == end) {
            return;
        }
        int mid = (start + end) / 2;
        MergeSortRecur(arr, start, mid);
        MergeSortRecur(arr, mid + 1, end);
        MergeSortedArrays(arr, start, mid, end);
    }

    public static void MergeSortedArrays(int arr[], int start, int mid, int end) {
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();
        ArrayList<Integer> C = new ArrayList<>();
        for (int i = start; i <= mid; i++) {
            A.add(arr[i]);
        }
        for (int i = mid + 1; i <= end; i++) {
            B.add(arr[i]);
        }
        int i = start;
        int j = mid + 1;
        while (i < A.size() && j < B.size()) {
            if (A.get(i) < B.get(j)) {
                C.add(A.get(i));
                i++;
            } else {
                C.add(B.get(j));
                j++;
            }
        }
        while (i < A.size()) {
            C.add(A.get(i));
        }
        while (j < B.size()) {
            C.add(B.get(j));
        }
        int v = start;
        for (int i = 0; i < C.size(); i++) {
            arr[v++] = C.get(i);
        }
    }

    }

    // ****************QUICK
    // SORT******************************************************** */
    public static void QuickSort(int arr[]){

    public static void QuickSortRecur(int arr[],int start,int end){
	        if(start>=end){
	            return;
	        }
	        int indexOfPivot=QuickSortPartition(arr,start,end)
	        QuickSortRecur(arr,start,indexOfPivot-1);
	        QuickSortRecur(arr,indexOfPivot+1,end);
	    }

    public static void QuickSortPartition(int arr[], int start, int end) {
        int pivot = arr[end];
        int i = start;
        for (int j = start; j < end; j++) {
            if (arr[j] < pivot) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;

                i++;
            }
        }
        int temp = arr[i];
        arr[i] = arr[end];
        arr[end] = temp;
        return i;
    }
}}

}
