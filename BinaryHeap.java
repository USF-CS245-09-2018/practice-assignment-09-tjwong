public class BinaryHeap {
    private int[] arr;
    private int size;


    BinaryHeap() {
        arr = new int[10];
        size = 0;

    }

    public void add(int pri){

        if(arr.length == size) {
            grow_array();
        }
        arr[size] = pri;
        size++;
        int item = size-1;
        while(item < pri){
            int parent = (item-1)/2;
            if(arr[item]<arr[parent]){
                int temp = arr[item];
                arr[item] = arr[parent];
                arr[parent] = temp;
                item = parent;
            } else{
                return;
            }
        }
    }

    public int remove(){
        int priority = arr[0];
        arr[0] = arr[size-1];
        --size;
//        System.out.println(size);
        if(size != 0){
            shiftdown(0);
        }
        return priority;
    }


    private void shiftdown(int index){
        int child = index * 2 + 1;
        if(child < size){
            return;
        }
        if(arr[child+1]<arr[child]){
            child = child +1;
        }
        if(arr[index]>arr[child]){
            int temp = arr[index];
            arr[index] = arr[child];
            arr[child] = temp;
            shiftdown(child);
        } else{
            return;
        }
    }


    public void grow_array(){
        int[] new_a = new int[(arr.length)*2];
        for(int i = 1; i <size; i++){
            new_a[i] = arr[i];
        }
        arr = new_a;
    }


}